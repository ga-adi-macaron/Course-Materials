---
title: Testing w/ Mockito
duration: "1:30"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Testing with Mockito

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe how Mockito makes unit tests more flexible
- Set up a unit test class to use Mockito
- Mock dependencies for the class you want to test
- Apply Mockito to unit test presenters in MVP architecture

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Write unit tests with the JUnit framework
- Identify the layers created by MVP architecture
- Understand the concept of Dependency Injection

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening)  | Review MVP |
| 20 min  | [Introduction](#introduction)  | Why do we need Mockito? |
| 20 min  | [Demo](#demo)  | Set up a test class w/ Mockito |
| 15 min  | [Guided Practice](#guided-practice)  | Write unit tests w/ Mockito |
| 25 min  | [Independent Practice](#ind-practice)  | Add a new test class |
| 5 min  | [Conclusion](#conclusion)  | Review / Recap |

---

<a name="opening"></a>
## Opening: Review of MVP (5 mins)

In a [previous lesson](../mvp-architecture) we discussed the MVP architecture pattern.
It divides an app into three distinct layers:
- **Model:** describes, saves, and retrieves the app's data
- **View:** displays the UI & detects user actions
- **Presenter:** gathers, formats, and presents data for the view; decides how to handle user actions

> Check: What were the benefits of MVP? Have students described them in their own words.

Why bother with MVP? We discussed the following benefits:
- _Maintainability:_ Changing the way one layer is implemented requires no changes at all to other layers, as long as the contract interfaces are upheld.

- _Simplified teamwork:_ You can work on implementing the Presenter even before your coworker has finished implementing the data layer, because you already know what methods you can call from the data entity thanks to the contract.

- _Flexibility for testing:_ When unit testing your Presenter, you can give it fake, or mock implementations of its dependencies (the View and the data storage entity) so you can test the Presenter in isolation.

It's time to elaborate on that last point.
How exactly do we go about testing a Presenter, and why do we need help from a third-party library to do it?

---

<a name="introduction"></a>
## Introduction: What's So Hard About Testing a Presenter? (20 mins)
Let's think about what problems we might run into while unit testing a Presenter.

> Check: Have students take a moment to brainstorm and summarize in their own words

Difficulties in testing a Presenter include:
- Many Presenter methods return `void`, so no return value to check
- Often, the Presenter calls methods from the View; how to ensure it made those calls and passed the correct data?
- If we're going to check for how the View was affected by the Presenter, do we have to use Espresso to check individual views?
- The Presenter will read/write from the data source, and we don't want to alter our database or make actual network calls during testing

#### How Can Mockito Help?
Rather than use an actual View instance (and need Espresso to verify its state) or an actual data source instance (and risk permanent modification to our data), we can create fake, or **mock** versions of these objects.
Then we can control how these mock objects respond to method calls, and verify whether the Presenter called their methods at the right times with the right parameters.

The third-party library [Mockito](http://site.mockito.org/) offers the following capabilities:
- Easily create mock versions of any object, that by default simply do nothing when their methods are called
- If needed, specify how mocks should respond to specific method calls, e.g. have a mock data source respond by returning some fake data
- _Inject_ these mocks into the object you'll be testing, in our case the Presenter (this requires that you create your object using _dependency injection_ - refresher on that below)
- _Verify_ that specific methods of the mocks were called, with the expected arguments, by the object you're testing

#### Dependency Injection
Please note that Mockito is only useful if the object you're testing, like a Presenter, relies on _Dependency Injection_ to get the other objects it depends on. We covered this concept in the [MVP lesson](../mvp-architecture), but as a refresher, consider the Presenter for the "Trending Products" feature in the starter code:

> Look at line 36 of `TrendingActivity`.
> When we instantiate `TrendingPresenter` we give it View and DataSource objects as parameters to its constructor, rather than having the Presenter create those things itself.

> This is an example of **Dependency Injection**, where the objects an entity depends on are injected into it, so the entity doesn't have to instantiate those dependencies.
> In this case, we did it manually, but there are also libraries like [Dagger](http://google.github.io/dagger/) that can automate this process for you.

If we _didn't_ use dependency injection, and the Presenter instantiated the View and DataSource objects itself, then we'd have no way to mock them, and would be stuck using real versions.
Then we'd have all the testing difficulties we listed above.

---

<a name="demo"></a>
## Demo: Set Up a Unit Test Class with Mockito (20 mins)
The [starter code](starter-code) contains the sample app from the MVP lesson, which shows trending Walmart products on one screen, and the user's favorite products on another screen.
Let's set up a unit test class to test the Presenter for the trending products screen: `TrendingPresenter`

1. Add `testCompile 'org.mockito:mockito-core:2.3.7'` to the `build.gradle` file for the `app` module with the keyword `testCompile` (not `androidTestCompile` - that's for instrumented tests like Espresso)
    ```
    dependencies {
      ...
      testCompile 'org.mockito:mockito-core:2.3.7'
    }
    ```
1. Create a new test class in the `test` package (not the androidTest package - instrumented tests like Espresso) with a sensible name, like `TestTrendingPresenter`
1. Add `@RunWith(MockitoJUnitRunner.class)` annotation to the class
    ```java
    @RunWith(MockitoJUnitRunner.class)
    public class TestTrendingPresenter {
      ...
    }
    ```
1. Add member variables for the dependencies of the class you will test, and give them the `@Mock` annotation
    ```java
    @Mock
    private TrendingContract.View mMockView;

    @Mock
    private ProductsDataSource mMockDataSource;
    ```
1. Add the following import line to your test class so we can use the powerful static methods Mockito provides:
    - `when()`, `thenReturn()`, and `doAnswer()` to tell the mock objects how to respond when their methods are called
    - `verify()` to test whether the class being tested has done its job properly (you can also use JUnit's assertions to help with this)
    ```java
    import static org.mockito.Mockito.*;
    ```

#### Additional Setup
Depending on what you're testing, you might want to add some code to be run _before_ each test method.

> Check: How does **JUnit** let you specify code to be run before each test method?

For our situation, we probably want to further setup `mMockDataSource` to respond to requests for trending products with a few fake products.
To do that, let's add a `setup()` method and tag it with JUnit's `@Before` annotation.

Then, inside the method, let's use Mockito to control how `mMockDataSource` will behave.
The simplest thing to do would be to use the static `when()` and `thenReturn()` to specify a return value, such as:
```java
// If `someMethod()` is called on `myMockObject`, have it return `5`
when(myMockObject.someMethod()).thenReturn(5);
```
Telling a mock how to respond to a particular method call is often referred to as _stubbing_ that method.

Unfortunately for us, our `ProductsDataSource` interface is a little trickier.
The methods don't return any values directly (they all have `void` return type), and instead take in _callback_ objects so it can do work asynchronously, then pass data back via the callback when done.

Not to worry though, Mockito can mock void methods via the `doAnswer()` method:
```java
@Before
public void setup() {
    mTestProducts = new ArrayList<>(3);
    mTestProducts.add(new Product(1, "Product 1", "Brand 1", "Url 1", 1.99f, true));
    mTestProducts.add(new Product(2, "Product 2", "Brand 2", "Url 2", 2.99f, false));
    mTestProducts.add(new Product(3, "Product 3", "Brand 3", "Url 3", 3.99f, false));

    // Stub the data source's `getTrendingProducts()` method
    doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
            // Access the callback object via getArgument()
            ProductsDataSource.GetProductsCallback callback = invocationOnMock.getArgument(0);
            callback.onProductsLoaded(mTestProducts);
            return null;
        }
      }).when(mMockDataSource)
          .getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));
    // This means do this "answer" whenever `getTrendingProducts()` is called with
    // ANY instance of `GetProductsCallback` as an argument

    // Stub the data source's `isProductInFavorites()` method
    doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
            // Access the product ID and callback via getArgument()
            int productId = invocationOnMock.getArgument(0);
            ProductsDataSource.GetFavoriteStatusCallback callback = invocationOnMock.getArgument(1);
            callback.onFavoriteStatusReturned(mTestProducts.get(productId - 1).isFavorite());
            return null;
        }
      }).when(mMockDataSource)
          .isProductInFavorites(anyInt(), any(ProductsDataSource.GetFavoriteStatusCallback.class));
    // This means do this "answer" whenever `isProductInFavorites()` is called with
    // ANY `int` and ANY instance of `GetFavoriteStatusCallback` as an argument

    ...
}
```

At some point, you also need to actually instantiate the class you're trying to test - the `TrendingPresenter`! We could do this separately in each test method, but since we're writing a `@Before` method anyway, why not just instantiate it there:
```java
@Before
public void setup() {
    ...

    // This is where we actualy inject the mock dependencies!
    mPresenterToTest = new TrendingPresenter(mMockView, mMockDataSource);
}
```

---

<a name="guided-practice"></a>
## Guided Practice: Writing Unit Tests with Mockito (15 mins)
Let's write the simplest test first. One of the methods in `TrendingPresenter` is called `onMenuFavoritesIconClicked()`.
The View uses this to notify the presenter when the user clicks on the heart icon in the toolbar.
The Presenter should respond by telling the view to launch the Favorites activity.

```java
@Test
public void testOnMenuFavoritesIconCLicked() {
    // Call the method we want to test
    mPresenterToTest.onMenuFavoritesIconCLicked();

    // Check if the presenter did it's job by verifying it called the
    // mock View's `launchFavoritesView()` method
    verify(mMockView).launchFavoritesView();
}
```

Test complete!

Next, let's test the Presenter's `onRefreshRequested()` method.
```java
@Test
public void testOnRefreshRequested() {
    // The presenter should call getTrendingProducts() during its construction. Verify this.
    verify(mMockDataSource).getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));

    // Call the method we want to test
    mPresenterToTest.onRefreshRequested();

    // The presenter should have made a second request to the data source
    verify(mMockDataSource, times(2))
            .getTrendingProducts(any(ProductsDataSource.GetProductsCallback.class));
    // if you don't specify a number of times(), then Mockito assumes once

    // Verify the presenter sent the update products to the view
    verify(mMockView).displayProducts(mTestProducts);
}
```

Up next, `onProductFavoriteIconClicked()`:
```java
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
```

Next, `onFavoriteStatusUpdateNeeded()`:
```java
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
```

Finally, let's test `onViewReady()`:
```java
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
```

---

<a name="ind-practice"></a>
## Independent Practice: Add a New Test Class (25 minutes)
> Note: This can be a pair programming activity or done independently.

Add a new unit test class to test `FavoritesPresenter`.
Follow the steps described above to create a new class in the proper package named `TestFavoritesPresenter` that is set up to use Mockito.

Write test methods to ensure that the following methods implemented by `FavoritesPresenter` are working correctly:
- `onViewReady()`
- `onProductUnFavoriteIconClicked()`
- `onProductRemovalReversed()`

> Check: Were students able to implement the contracts successfully?

---

<a name="conclusion"></a>
## Conclusion (5 mins)
Automated tests are an obvious way to help guarantee code quality, but all too often, developers skip them because they can be such a pain to write.
Using MVP architecture helps by moving logic out of classes that depend on the Android SDK (e.g. activities, fragments) and into unit-testable Presenter classes.

Mockito helps even further by providing a quick way to create fake/mock versions of the objects your Presenters depend on, like views and data sources.
This means you can write tests that don't need to mimic user input with Espresso, and don't have any side effects of changing databases or making actual network calls.

> Check: Can you use Mockito in apps that weren't built with MVP architecture? Can you mock Android-specific classes like `Context`?

---

### ADDITIONAL RESOURCES
- [Mocking Dependencies for Testing](https://developer.android.com/training/testing/unit-testing/local-unit-tests.html#mocking-dependencies)
- [Mockito Homepage](http://site.mockito.org/)
- [Mockito Documentation](http://static.javadoc.io/org.mockito/mockito-core/2.3.10/org/mockito/Mockito.html)
