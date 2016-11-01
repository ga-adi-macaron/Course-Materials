---
title: Fragments (part 2)
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Fragments (part 2)

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Communicate between a fragment and its parent activity
- Communicate between fragments

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe and implement basic fragments

---
<a name="opening"></a>
## Opening (5 mins)

We've covered the very basics of fragments so far, but there are many other things you can do with them. Until this point, our fragments have been isolated, performing work in their own section of the activity. Now we will talk about fragments communicating with other parts of the app.


***

<a name="introduction"></a>
## Introduction: Communicating with an activity (5 mins)

Previously, we have viewed fragments as independent modules that are part of an Activity. While this is still true, Android provides the ability for a fragment to communicate back to its parent activity, and therefore to another fragment as well.

Since fragments are directly tied to a specific activity, they can easily make the activity listen for actions using an interface.


***

<a name="demo"></a>
## Demo: Sharing Events with an Activity (30 mins)


When a fragment needs to talk back to its hosting Activity, you must perform the following steps:

1. Define an interface in the Fragment
2. Implement the interface in the parent Activity
3. Call the implemented method using a reference to the  class implementing the interface

From that callback, you can perform some action in the Activity, or pass on information to a different Fragment.

We need to open the project in the starter code where we will create two Fragments: A PlanetListFragment and a Detail Fragment. When we click on an item in the ListFragment, it will change text in the other Fragment and display it.

Let's start by adding some data to show in the List. In your strings.xml, add the following

```xml
<string-array name="Planets">
        <item>Mercury</item>
        <item>Venus</item>
        <item>Earth</item>
        <item>Mars</item>
        <item>Jupiter</item>
        <item>Saturn</item>
        <item>Uranus</item>
        <item>Neptune</item>
    </string-array>
```

Let's start by creating our fragment containing the list of planets.

fragment_planet_list.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.RecyclerView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/recyclerview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

Now we can create the Java file for the Fragment.

MyListFragment.java
```java
public class PlanetListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planet_list, container, false);
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        String[] planetArray = getResources().getStringArray(R.array.Planets);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        //Adapter will be added soon
    }
}
```

Finally, let's add the fragment to our activity and test it out.

First we need to set up the container for our fragment.
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout      
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:id="@+id/fragment_container"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  />

```

Next, we need to get the FragmentManager and begin a transaction to add the fragment
to the container.

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This line will change soon
        Fragment planetListFragment = new PlanetListFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, planetListFragment).commit();
    }
```


It works so far!

Now it's time to add our second fragment, and try communicating with it.

The layout for this fragment will be simple, it will just have a TextView we can set.

fragment_detail.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    >
    <TextView
        android:id="@+id/textview_selectedPlanet"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select a planet!"
        android:textSize="30sp"
        android:textStyle="bold"/>
</LinearLayout>
```

Now we need to create our DetailFragment.java

```java
public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_detail, container, false);
        return parentView;
    }
}
```


Now comes our final two steps. We need to set up the communication from the list fragment back to the activity, and from the activity to the detail fragment.

Remember, we need to set up an interface in the `PlanetListFragment` since that is where the `Activity` will be listening for the action. Then we need to allow the fragment to call on the activity.

In MyListFragment.java
```java
OnPlanetSelectedListener mListener;
...

public interface OnPlanetSelectedListener {
  public void onPlanetSelected(String selectedPlanet);
}

//@Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
//        try {
//            mListener = (onPlanetSelectedListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnPlanetSelectedListener");
//        }
//    }

public static Fragment newInstance(Bundle bundle, OnPlanetSelectedListener listener){
    PlanetListFragment fragment = new PlanetListFragment();
    fragment.setArguments(bundle);
    fragment.mListener = listener;
    return fragment;
}

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_planet_list, container, false);
    return v;

}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

    String[] planetArray = getResources().getStringArray(R.array.Planets);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    mRecyclerView.setAdapter(new PlanetRecyclerViewAdapter(planetArray,mListener));
}
```

`onAttach` is the recommended way to set up your OnPlanetSelectedListener but I found it is not very reliable in some cases. We'd much rather prefer to allow the Fragment to communicate to anyone having to listen to it.

Adding a static newInstance method allows us to provide the Fragment a reference to what ever class decides to implement our OnPlanetSelectedListener interface.

**Let's go back and fix MainActivity to use newInstance**

```java
Fragment planetListFragment = PlanetListFragment.newInstance(null, this);
```

**Now let's add the adapter for our RecyclerView**

```java
mRecyclerView.setAdapter(new PlanetRecyclerViewAdapter(planetArray,mListener));
```

Next we need to set the click listener for each item in the adapter using the OnPlanetSelectedListener.

```java
holder.mPlanetItem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        mListener.onPlanetSelected(mPlanetArray[position]);
    }
});
```

Now let's add a method in the detail fragment to accept the String we are going to put in the TextView.

```java
public class DetailFragment extends Fragment {

    public static Fragment newInstance(Bundle bundle){
        Fragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_detail, container, false);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        TextView selectedPlanetTextView = (TextView) view.findViewById(R.id.textview_selectedPlanet);

        selectedPlanetTextView.setText(
                    bundle.getString("selected_planet"));
    }
}
```

Finally, we need to implement our callback interface in the `MainActivity` and then replace our MyListFragment with the DetailFragment.

```java
@Override
    public void onPlanetSelected(String selectedPlanet) {
      Bundle bundle = new Bundle();
      bundle.putString("selected_planet", selectedPlanet);
        Fragment detailFragment = DetailFragment.newInstance(bundle);
        FragmentManager supportManager =
        getSupportFragmentManager();
        FragmentTransaction transaction = supportManager.beginTransaction();

        transaction.replace(R.id.fragment_container, detailFragment).commit();

    }
```


***


<a name="conclusion"></a>
## Conclusion (5 mins)

Now that we have a more complete understanding of how fragments work, and how they interact with the activity as well as each other, we get a better idea of when they are appropriate to use. Setting up the interaction between a fragment and an activity might seem like a lot of work at first, but with practice it becomes easier.

- Describe the steps needed to make the two fragments interact with each other.


***

### ADDITIONAL RESOURCES
- [Fragments Developers Guide](http://developer.android.com/guide/components/fragments.html)
- [Adaptive UI Guide](http://developer.android.com/training/multiscreen/adaptui.html)
