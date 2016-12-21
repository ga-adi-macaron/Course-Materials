package com.charlesdrews.trendingproductsmvpdemo;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.data.ProductsDataSource;
import com.charlesdrews.trendingproductsmvpdemo.favorites.FavoritesContract;
import com.charlesdrews.trendingproductsmvpdemo.favorites.FavoritesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Unit tests for the presenter of the Favorite Products screen
 *
 * Created by charlie on 12/19/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestFavoritesPresenter {

    private FavoritesContract.Presenter mPresenterToTest;
    private List<Product> mTestProducts;

    @Mock
    private FavoritesContract.View mMockView;

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

        // Get a list of fake favorite products
        mTestProducts = new ArrayList<>(3);
        mTestProducts.add(new Product(1, "Product 1", "Brand 1", "Url 1", 1.99f, true));
        mTestProducts.add(new Product(2, "Product 2", "Brand 2", "Url 2", 2.99f, true));
        mTestProducts.add(new Product(3, "Product 3", "Brand 3", "Url 3", 3.99f, true));

        // mMockDataSource is our mock data source. We need to tell it how to respond when the
        // getFavoriteProducts() method is called, since we know that the FavoritesPresenter
        // will call that method from inside its constructor.
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                ProductsDataSource.GetProductsCallback callback = invocationOnMock.getArgument(0);
                callback.onProductsLoaded(mTestProducts);
                return null;
            }
        }).when(mMockDataSource)
                .getFavoriteProducts(any(ProductsDataSource.GetProductsCallback.class));

        // Finally, instantiate the presenter we'll be testing
        mPresenterToTest = new FavoritesPresenter(mMockView, mMockDataSource);
    }

    @Test
    public void testOnViewReady() {
        // The presenter should immediately request favorites from the data source when it is
        // instantiated. If the view is ready, it will also pass them to the view, but in this
        // case the view has not indicated yet that it is ready.
        verify(mMockDataSource).getFavoriteProducts(any(ProductsDataSource.GetProductsCallback.class));

        // Now call onViewReady() on our test object
        mPresenterToTest.onViewReady();

        // Verify the presenter did indeed get the test products from the mock data source,
        // and pass them to the mock view.
        verify(mMockView).displayProducts(mTestProducts);

        // On subsequent calls to onViewReady, the presenter should NOT request products from the
        // data source, but rather pass the products it's already holding in memory to the view.
        mPresenterToTest.onViewReady();

        // We already verified above that this was called once - should still be only once!
        verify(mMockDataSource).getFavoriteProducts(any(ProductsDataSource.GetProductsCallback.class));

        // This one, however, will be called again, so should be two times now
        verify(mMockView, times(2)).displayProducts(mTestProducts);
    }

    @Test
    public void testOnProductUnFavoriteIconClicked() {
        Product fakeProductToRemove = new Product(4, "Product 4", "Brand 4", "Url 4", 4.99f, true);

        // Call the method we want to test - this is what the view calls when the X is clicked
        mPresenterToTest.onProductUnFavoriteIconClicked(fakeProductToRemove);

        // Make sure the presenter updated the data source
        verify(mMockDataSource).removeProductFromFavorites(4);

        // Make sure the presenter also updated the view
        verify(mMockView).removeProductFromList(4);
        verify(mMockView).notifyUserProductWasRemoved(anyString(), eq(fakeProductToRemove));
    }

    @Test
    public void testReversalOfProductRemoval() {
        // In this test, the presenter should call addProductToFavorites() on the data source.
        // That means we need to tell our mock data source how to respond to that call.
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Product product = invocationOnMock.getArgument(0);
                mTestProducts.add(product);
                return null;
            }
        }).when(mMockDataSource)
                .addProductToFavorites(any(Product.class));

        Product fakeProductToReAdd = new Product(4, "Product 4", "Brand 4", "Url 4", 4.99f, true);

        // Combine the test list with this new item that we pretended to add
        List<Product> testProductsPlusOne = new ArrayList<>();
        testProductsPlusOne.addAll(mTestProducts);
        testProductsPlusOne.add(fakeProductToReAdd);

        // Call the method we want to test - this is what the view calls if the user hits UNDO
        mPresenterToTest.onProductRemovalReversed(fakeProductToReAdd);

        // Make sure the presenter updated the data source
        verify(mMockDataSource).addProductToFavorites(fakeProductToReAdd);

        // Make sure the presenter also updated the view
        verify(mMockView).displayProducts(testProductsPlusOne);
    }
}
