package com.charlesdrews.trendingproductsmvpdemo;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.data.ProductsDataSource;
import com.charlesdrews.trendingproductsmvpdemo.trending.TrendingContract;
import com.charlesdrews.trendingproductsmvpdemo.trending.TrendingPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Unit tests for the presenter of the Trending Products screen
 *
 * Created by charlie on 12/20/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestTrendingPresenter {

    private TrendingContract.Presenter mPresenterToTest;
    private List<Product> mTestProducts;

    @Mock
    private TrendingContract.View mMockView;

    @Mock
    private ProductsDataSource mMockDataSource;

    @Before
    public void setup() {
        //MockitoAnnotations.initMocks(this);
        /* Often you'll see this in Mockito examples - if you don't have the @RunWith annotation,
           then you'll need to call this method to initialize your mock objects. But if you do
           include the @RunWith(MockitoJUnitRunner.class) annotation, then it automatically
           initializes the mocks, so you don't have to bother doing it yourself.
         */

        mTestProducts = new ArrayList<>(3);
        mTestProducts.add(new Product(1, "Product 1", "Brand 1", "Url 1", 1.99f, true));
        mTestProducts.add(new Product(2, "Product 2", "Brand 2", "Url 2", 2.99f, false));
        mTestProducts.add(new Product(3, "Product 3", "Brand 3", "Url 3", 3.99f, false));

        // mMockDataSource is our mock data source. We need to tell it how to respond when the
        // getTrendingProducts() method is called, since we know that the TrendingPresenter
        // will call that method.
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                ProductsDataSource.GetProductsCallback callback = invocationOnMock.getArgument(0);
                callback.onProductsLoaded(mTestProducts);
                return null;
            }
        }).when(mMockDataSource)
                .getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));

        // In a few of the tests below, the presenter should call isProductInFavorites() on the
        // data source. So, we need to tell the mock data source how to respond to that call.
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                int productId = invocationOnMock.getArgument(0);
                ProductsDataSource.GetFavoriteStatusCallback callback = invocationOnMock.getArgument(1);
                callback.onFavoriteStatusReturned(mTestProducts.get(productId - 1).isFavorite());
                return null;
            }
        }).when(mMockDataSource)
                .isProductInFavorites(anyInt(), any(ProductsDataSource.GetFavoriteStatusCallback.class));

        // Finally, instantiate the presenter we'll be testing
        mPresenterToTest = new TrendingPresenter(mMockView, mMockDataSource);
    }

    @Test
    public void testOnFavoriteStatusUpdateNeeded() {
        // This is called when the user goes from the favorites screen back to the trending screen.
        // The presenter should check whether the favorites status of any trending products has
        // changed, and should update the view with the latest statuses.
        mPresenterToTest.onFavoriteStatusUpdateNeeded();

        // Make sure it called isProductInFavorites() once for each product
        verify(mMockDataSource, times(mTestProducts.size()))
                .isProductInFavorites(anyInt(), any(ProductsDataSource.GetFavoriteStatusCallback.class));

        // Make sure the presenter called the displayProducts() method of the view
        verify(mMockView).displayProducts(mTestProducts);
    }

    @Test
    public void testOnRefreshRequested() {
        // The presenter should call getTrendingProducts() during its construction. Verify this.
        verify(mMockDataSource).getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));

        // Call the method to be tested - this is called by the view when the user hits refresh
        mPresenterToTest.onRefreshRequested();

        // The presenter should have made a second request to the data source. Verify this.
        verify(mMockDataSource, times(2))
                .getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));

        // Verify the presenter sent the update products to the view
        verify(mMockView).displayProducts(mTestProducts);
    }

    @Test
    public void testOnProductFavoriteIconClicked() {
        // Product 3 (index 2 in mTestProducts) was set as not a favorite. Test if the user
        // tries to favorite that product.
        Product fakeProductToFavorite = mTestProducts.get(2);

        mPresenterToTest.onProductFavoriteIconClicked(fakeProductToFavorite);

        // The presenter should have told the data source to add this product to favorites.
        verify(mMockDataSource).addProductToFavorites(fakeProductToFavorite);

        // The presenter should also have updated the view to reflect the change in favorite status.
        verify(mMockView).showFavoriteIconForProduct(fakeProductToFavorite.getId());


        // Now try the opposite - removing a product from favorites. Product 1 (index 0 in
        // mTestProducts) was set as a favorite. Test if the user tries to remove it from favorites.
        Product fakeProductToUnFavorite = mTestProducts.get(0);
        mPresenterToTest.onProductFavoriteIconClicked(fakeProductToUnFavorite);
        verify(mMockDataSource).removeProductFromFavorites(fakeProductToUnFavorite.getId());
        verify(mMockView).showNonFavoriteIconForProduct(fakeProductToUnFavorite.getId());
    }

    @Test
    public void testOnMenuFavoritesIconCLicked() {
        // In this case, the presenter should simply tell the view to launch the Favorites activity.
        mPresenterToTest.onMenuFavoritesIconCLicked();
        verify(mMockView).launchFavoritesView();
    }

    @Test
    public void onViewReady() {
        // Upon its construction, the presenter should request trending products from the data source.
        verify(mMockDataSource).getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));

        // But it shouldn't send those trending products to the view until the view specifically
        // tells the presenter that it is ready.
        verify(mMockView, never()).displayProducts(ArgumentMatchers.<Product>anyList());

        // Now let's tell the presenter the view is ready
        mPresenterToTest.onViewReady();

        // It should use the data it already requested, and should NOT call getTrendingProducts()
        // again. Make sure this has still only been called once!
        verify(mMockDataSource).getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));

        // Now the presenter should pass the products to the view. Verify this.
        verify(mMockView).displayProducts(mTestProducts);
    }
}
