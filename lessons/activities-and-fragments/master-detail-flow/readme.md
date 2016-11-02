---
title: Master Detail Flow
duration: "2:00"
creator:
    name: Charlie Drews
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Master/Detail Flow

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the benefits Master/Detail flow
- Add multiple layouts for the same activity
- Determine which version of a layout has been inflated
- Implement Master/Detail flow by showing a detail view in either a second pane of the current screen, or on a whole new screen

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe and implement basic fragments
- Communicate between a fragment and its parent activity

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Run the solution code to ensure it runs and that you agree with how it was implemented

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening)  | Discuss lesson objectives |
| 5 min  | [Introduction](#introduction)  | Master/Detail Flow |
| 15 min  | [Guided Practice](#fragment)  | Add a Detail Fragment |
| 30 min  | [Demo](#demo-sharing-events-with-an-activity-30-mins)  | Sharing Events with an Activity |
| 20 min  | [Independent Practice](#independent-practice-topic-20-mins)  | Topic |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

<a name="opening"></a>
## Opening (5 mins)

When we introduced fragments, we showed you the image below as an example of how they are useful.
Once you set up a fragment to show information to the user, you then have the flexibility to use that fragment in multiple different activities.
No need to repeat your code to display the information in two activities, just write it once in a fragment.

In addition, fragments give you a way to fill up space on a screen that might otherwise be empty.
Tablets, especially in landscape orientation, give you plenty of space to fill with content. 
Using fragments makes it easy to shuffle content around when necessary to fill all the space you have available.

<p align="center">
  <img src="./images/fragments.png">
</p>

> Check: Why do you think it is worthwhile to design differently for small phone screens vs. large tablet screens?

<a name="introduction"></a>
## Introduction: The Master/Detail Flow Pattern (5 mins)

The navigation pattern shown in the image above is called **Master Detail Flow**, and it is very commonly used to take advantage of the space offered by large tablet screens.
In this pattern, the list of items is the _master_ view.
It is by itself on small screens, or on the left for large screens.

The other pane is the _detail_ view. This shows more information about whichever list item the use selects. This is shown by itself on small screens, and on the right side for large screens.

> Check: What examples have we seen or what labs have we built where the master/detail pattern might be useful?

The key to implementing this pattern is to have _more than one_ layout for your main activity - the activity that shows the list/master view.
We'll add a second version of the layout file intended just for large screens.
The system will then select which version to use on its own, and we can simply check which version it chose and act accordingly.

<a name="fragment"></a>
## Guided Practice: Sharing Events with an Activity (30 mins)

> Instructor note: Encourage students to follow along if they're comfortable.

> Check: Can anyone predict what you must do when you'd like a fragment to talk to its hosting Activity.

When a fragment needs to talk back to its hosting Activity, you must perform the following steps:

1. Define an interface in the Fragment
2. Implement the interface in the parent Activity
3. Call the implemented method using a reference to the parent Activity

From that callback, you can perform some action in the Activity, or pass on information to a different Fragment.

We need to create a new project where we will have two Fragments: A ListFragment and a normal Fragment. When we click on an item in the ListFragment, it will change text in the other Fragment.

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

Now we can create the Java file for the Fragment.

MyListFragment.java
```java
public class MyListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Planets));
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT)
                .show();
    }
}
```

Finally, let's add the fragment to our activity and test it out.

activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="horizontal"
    tools:context="ly.generalassemb.drewmahrt.morefragments.MainActivity">

    <fragment
        android:id="@+id/list_fragment"
        android:name="ly.generalassemb.drewmahrt.morefragments.MyListFragment"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.5"/>
</LinearLayout>
```
It works so far!

Now it's time to add our second fragment, and try communicating with it.

The layout for this fragment will be simple, it will just have a TextView we can set.

fragment_detail.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select a planet!" />
</LinearLayout>
```

Now we need to create our DetailFragment.java

```java
public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }
}
```

> Check: Turn to the person next to you and explain the steps we went through, so far.

Now comes our final two steps. We need to set up the communication from the list fragment back to the activity, and from the activity to the detail fragment.

Remember, we need to set up an interface in the ListFragment since that is where the Activity will be listening for the action. Then we need to allow the fragment to call on the activity.

In MyListFragment.java
```java
OnPlanetSelectedListener mListener;
...

public interface OnPlanetSelectedListener {
  public void onPlanetSelected(String selectedPlanet);
}

@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnPlanetSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnPlanetSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mListener.onPlanetSelected(l.getAdapter().getItem(position).toString());
    }
```

Overriding `onAttach` lets us check to make sure the parent activity implemented the callback needed for the interaction to be successful.

Now let's add a method in the detail fragment to accept the String we are going to put in the TextView.

```java
public void setPlanetText(String planet){
        TextView text = (TextView)getView().findViewById(R.id.text);
        text.setText("Planet selected: "+planet);
}
```

Finally, we need to add the detail fragment, and make the connection by implementing our callback interface in the MainActivity.

```xml
<fragment
        android:id="@+id/detail_fragment"
        android:name="ly.generalassemb.drewmahrt.morefragments.DetailFragment"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_toRightOf="@id/list_fragment"
        android:layout_weight="0.5"
        />
```

```java
@Override
    public void onPlanetSelected(String selectedPlanet) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        detailFragment.setPlanetText(selectedPlanet);
    }
```

> Check: Turn to the person next to you and explain the steps we went through to make the two fragments interact with each other.

***

<a name="demo"></a>
## Guided Practice: Master-Detail Flow (15 mins)

The master/detail flow can accomplish a similar two-pane layout, but only uses one fragment.

Start a new project, and choose the Master/Detail Flow from the templates. The Master/Detail flow sets up a two-pane layout for us to use that automatically adapts to fit phones or tablets. On tablets, it displays the two panes side by side. On a phone, it makes each a separate screen.

Let's walk through all of the parts of the master detail flow to understand how it works.

***

<a name="ind-practice"></a>
## Independent Practice: Topic (20 mins)

Take our demo from earlier in the lesson, and adapt it to act more like the Master-Detail flow. Instead of using one fragment like the template, ours will use two fragments. On a phone, have it display the detail text in a separate activity (but still in a fragment), and on a tablet have it display in a second pane next to the list.

> Check: Were students able to create the desired deliverable(s)? Did it meet all necessary requirements / constraints?

***

<a name="conclusion"></a>
## Conclusion (5 mins)

Now that we have a more complete understanding of how fragments work, and how they interact with the activity as well as each other, we get a better idea of when they are appropriate to use. Setting up the interaction between a fragment and an activity might seem like a lot of work at first, but with practice it becomes easier.

- Describe the steps needed to make the two fragments interact with each other.


***

### ADDITIONAL RESOURCES
- [Fragments Developers Guide](http://developer.android.com/guide/components/fragments.html)
- [Adaptive UI Guide](http://developer.android.com/training/multiscreen/adaptui.html)
