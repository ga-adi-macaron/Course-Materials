---
title: Fragments
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Fragments


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the purpose of a Fragment
- Give examples of when to use a Fragment
- Create an app that switches between Fragments

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe the purpose of an activity
- Describe the Activity Lifecycle

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Review pre-work, projects, or exit ticket, if applicable
- Review current lesson objectives
- Reference general course content or topics (e.g. code or concepts that have been used across multiple lessons)
- Include Hook / Real-world Relevance (why the content from this lesson is useful or important)

---
<a name="opening"></a>
## Opening (5 mins)

So far, all of our screens have been contained in separate activities. We can use something called a "Fragment" for showing multiple screens in one activity, or more than one layout on a single screen. This gives us much more flexibility with how we organize our Views, as well the overall design of the app.


***

<a name="introduction"></a>
## Introduction: What is a Fragment? (15 mins)

Fragments were introduced in version 3.0 of Android (Honeycomb) in order to allow for more flexible layouts on large screens. When the tablet and phone versions of Android were merged in Android 4.0 (Ice Cream Sandwich), Fragments were also available for phones.

With Fragments, you can swap out entire sections of the layout at runtime while the current Activity is still running. Fragments cannot be created on their own - they **must** be contained within an Activity. Due to the close relationship with the hosting Activity, they are also affected by the Activity's Lifecycle. In addition, each fragment has its own Lifecycle (something we will be discussing soon). Basically they are like a Sub-activity of the parent Activity.

<p align="center">
  <img src="./images/fragments.png">
</p>

#### Why Fragments?

The use Fragments in Android apps can be somewhat controversial. In reality, almost everything you do with Fragments you can also just do with an Activity. For instance, the example described above with swapping entire parts of the screen out without switching Activities can be done by manually showing or hiding multiple UI elements on the screen. However, with a complicated layout, this can be a very long progress, and can make your code confusing.

Some developers like using Fragments extensively, while others use them as sparingly as possible. It is important to understand how they work so you can decide whether or not they fit your particular situation. There is no universal guide for exactly when a Fragment is required, but as you grow in your development career, you will begin to understand when it is ideal to use them.

#### Fragment Lifecycle

<p align="center">
  <img src="./images/fragment_lifecycle.png">
</p>

While the Fragment Lifecycle is similar the Activity's, there are some key differences. Let's look at some of the important methods:

- `onCreate`: In Fragments, onCreate is used to initialize data, and retrieve data that might have been stored when the Fragment was stopped. **Don't use it to work with Views in the layout.**

- `onCreateView`: This method returns a View, which is the parent View you will be showing in the Fragment. This is the method where you will get references to your Views, and act on them.

- `onViewCreated`: This is another opportunity to get references to your Views, and act on them. While you can do this in onCreateView, it is also possible in onViewCreated. OnViewCreated performs some additional checks for us to make sure there weren't any problems inflating the view.

- `onPause`: This is just like onPause from the Activity, but it only applies to the current Fragment.



***

<a name="demo"></a>
## Demo: Creating a Fragment (20 mins)


To create a Fragment, we must make a new Java file and extend Fragment. There are some other specialized Fragments such as `ListFragment`, `DialogFragment`, and `PreferenceFragment`, but we will just concentrate on the base Fragment for now:

```java
public class ExampleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }
}
```

In your `activity_main.xml`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

fragment_example.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="I am a fragment!"/>
</LinearLayout>
```

> Check: Quickly, describe the steps needed to add a fragment based on what we saw above.

We can also add the Fragments through XML. There are some caveats to doing that though, so we will stick with creating them in Java.

This uses two classes - the `FragmentManager` and the `FragmentTransaction`.

**FragmentManager**

The [FragmentManager class](http://developer.android.com/guide/components/fragments.html#Managing), as the name implies, is used to manage your Fragments.

Its key features include:

- Finding fragments in your activity
- Removing fragments from the stack (like pressing the back button)
- Using FragmentTransactions (discussed below)

Basically, it is the top level management for everything Fragment-related in your apps.


**FragmentTransaction**

The [FragmentTransaction class](http://developer.android.com/guide/components/fragments.html#Transactions) is very closely tied to the FragmentManager. While Transactions can do many different things, it is mostly used for adding, removing, and replacing Fragments in your activities.

A Transaction is basically a sequence of commands you build up (such as adding and deleting), which you then commit to apply all at once. **Important:** These changes don't happen immediately, they are added to the backlog of items waiting to be run on the UI thread.

Now let's look at the code for using the FragmentManager and FragmentTransaction.

First, we need to add a container of some sort for the fragment. Put the following in your `activity_main.xml` (it doesn't have to be a frame layout):

```xml
<FrameLayout
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

Add the following to the `onCreate` of your `MainActivity`:

```java
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

ExampleFragment fragment = new ExampleFragment();
fragmentTransaction.add(R.id.fragment_container, fragment);
fragmentTransaction.commit();
```

As you can see, we use the `FragmentManager` to start a `FragmentTransaction`. With the `FragmentTransaction` we add a new Fragment and then commit the change.

Finally, you can call the following method to save the state of the fragment across activity recreation. It is recommended you call it `in onActivityCreated()` in your fragment.

```java
@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }
```

***

<a name="guided-practice"></a>
## Guided Practice: Replacing fragments (15 mins)


Let's create an app that shows a user's name in one fragment and swaps it for detailed user information on a button press.

First, we need to create our main layout with the button, and a frame to hold the fragment.


Then, we create our two fragments with their respective information, and add replace the old fragment with the new one on the button click. Luckily, Android provides us with an easy way to replace one fragment with another, using the replace method, which is a part of the `FragmentTransaction`. Give it the same id as before, and the new fragment as parameters.


If you want to be able to retrieve the fragment that was replaced when you press the back button, you need to call

```java
fragmentTransaction.addToBackStack(null);
```

***

<a name="ind-practice"></a>
## Independent Practice: Swapping Fragments (25 mins)

Create a weather forecast app that swaps between a fragment that shows today's weather (low temp, high temp, cloudy/sunny/raining/snowing, and precipitation chance), and a second fragment that shows the week's forecast, with the day name, high temp, and low temp. Make up your own data to show on the screen. You can use a button on the activity to swap out the fragments.

Remember to use the replace method to put the new fragment in place of the old one.

***

<a name="introduction"></a>
## Introduction: ViewPager and TabLayout (5 mins)

The ViewPager flow can accomplish a paging layout. It allows you to put screens that are related to each other together in what appears to be one screen, but are actually separate fragments. You can swipe side to side to switch between fragments on the screen.

ViewPager is often combined with a Tab Layout, which allows you to click or swipe between tabs, which swaps out a fragment for each tab. The Tab Layout simply adds labeled tabs for each page that exists in the ViewPager.

***

## Demo: ViewPager and TabLayout (10 mins)

The ViewPager and TabLayout consist of a few extra components beyond the required Fragments.

First we are going to implement the ViewPager, then add TabLayout.

**Open the ViewPagerDemo starter code.**

### ViewPager

Adding a ViewPager requires two components:

1. The ViewPager itself (XML and Java code)
2. PagerAdapter

The ViewPager represents the pages (fragments) on the screen, while the adapter decides which fragments should be shown on which page.

First we need to add the XML. It goes inside of the LinearLayout, below the AppBarLayout.

```xml
<android.support.v4.view.ViewPager
    android:id="@+id/viewpager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

Next, we need to create our PagerAdapter.

`getItem` determines which fragment should be shown for which page.

`getCount` returns the number of pages.

```java
public class ExamplePagerAdapter extends FragmentPagerAdapter {
    public ExamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
```

Finally, we have to get a reference to the ViewPager, create a PagerAdapter, and connect the two.

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        ...

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        ExamplePagerAdapter pagerAdapter = new ExamplePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }
```

### TabLayout

The TabLayout is part of the design support library, which we have to add to our dependencies:

```xml
compile 'com.android.support:design:25.0.0'
```

First, we need to add the TabLayout to the XML. This goes inside of the AppBarLayout, at the bottom.

```xml
<android.support.design.widget.TabLayout
            android:id="@+id/tablayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
```

Next, we need to add a method to the PagerAdapter so we know what the titles of the tabs are supposed to be.

```java
@Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Name";
            case 1:
                return "Details";
            default:
                return null;
        }
    }
```

Finally, we need to get a reference to the TabLayout in the Activity, and connect it to the adapter.

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        ...

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
```

***

<a name="ind-practice"></a>
## Independent Practice: ViewPager (10 mins)

Modify the Weather Example from before to switch between the fragments using a ViewPager instead of a button.

***

<a name="conclusion"></a>
## Conclusion (5 mins)

Fragments are very useful for certain situations, but you should probably avoid building your entire app out of them. They are extremely useful when you want to have entire parts of the screen you want to swap out on the fly. Carefully think through when you want to use them.

***

### ADDITIONAL RESOURCES
- [Fragments (Developer's Guide)](http://developer.android.com/guide/components/fragments.html)
- [Building a Dynamic UI with Fragments](http://developer.android.com/training/basics/fragments/index.html)
