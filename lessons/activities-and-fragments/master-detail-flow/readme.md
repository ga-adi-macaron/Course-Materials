---
title: Master Detail Flow
duration: "1:30"
creator:
    name: Charlie Drews
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Master/Detail Flow

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the benefits Master/Detail flow
- Convert a detail activity to use a detail fragment
- Add multiple layouts for the same activity
- Determine which version of a layout has been inflated

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
| 10 min  | [Introduction](#introduction)  | Master/Detail Flow Pattern |
| 15 min  | [Guided Practice](#fragment)  | Add a Detail Fragment |
| 20 min  | [Demo](#demo)  | Adding Alternate Layouts |
| 30 min  | [Independent Practice](#independent-practice)  | Implement Master/Detail Flow |
| 5 min  | [Conclusion](#conclusion)  | Review / Recap |

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
## Introduction: The Master/Detail Flow Pattern (10 mins)

The navigation pattern shown in the image above is called **Master Detail Flow**, and it is very commonly used to take advantage of the space offered by large tablet screens.
In this pattern, the list of items is the _master_ view.
It is by itself on small screens, or on the left for large screens.

The other pane is the _detail_ view. This shows more information about whichever list item the use selects. This is shown by itself on small screens, and on the right side for large screens.

> Check: What examples have we seen or what labs have we built where the master/detail pattern might be useful?

The key to implementing this pattern is to have _more than one_ layout for your main activity - the activity that shows the list/master view.
We'll add a second version of the layout file intended just for large screens.
The system will then select which version to use on its own, and we can simply check which version it chose and act accordingly.

<a name="fragment"></a>
## Guided Practice: Adding a Detail Fragment (15 mins)

In the [starter code](starter-code) you'll find another version of the familiar "Planets" app we've used in previous examples.
This version has two activities:
1. `ListActivity` which shows a list of planets
2. `DetailActivity` which shows detail for the planet the user selected

All data is stored in a SQLite database, and both activities retrieve data from the database as needed. There is a FAB in the detail activity that indicates whether the user has "favorited" the planet. Tapping that button toggles the favorite status for that planet both on the screen and in the database.

If we're going to sometimes show the planet detail view in a separate activity (like it is now) and sometimes show it the same activity as the list, then we have a choice to make: duplicate the code from `DetailActivity` that shows the planet detail again in `ListActivity`, _or_ move that code to a fragment so we can use it in two activities without duplicating it. Let's go with the latter.

Steps to add a detail fragment:

- File > New > Fragment > Fragment (Blank)
  - Choose a name, for example `DetailFragment`
  - Check all 3 boxes


- Copy the _all_ the XML from `activity_detail.xml` into the new `fragment_detail.xml`.


- Update `activity_detail.xml` to have just a `FrameLayout` as a fragment container.
```xml
<!-- activity_detail.xml -->
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/detail_fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

- Update the automatically generated code in `DetailFragment.java`:
  - Change `newInstance()` and `onCreate()` to take the selected planet's ID as an input.
```java
public class DetailFragment extends Fragment {
        public static final String SELECTED_PLANET_ID = "selectedPlanetId";

        ...

        public static DetailFragment newInstance(int selectedPlanetId) {
            DetailFragment fragment = new DetailFragment();
            Bundle args = new Bundle();
            args.putInt(SELECTED_PLANET_ID, selectedPlanetId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mSelectedPlanetId = getArguments().getInt(SELECTED_PLANET_ID);
            }
        }

        ...
}
```
  - Rename the interface defined in `DetailFragment` for communication with the host activity to something more descriptive.
```java
public class DetailFragment extends Fragment {
        ...
        public interface OnFavoriteStatusChangeListener {
            void onFavoriteStatusChange(int planetId, boolean isFavorite);
        }
}
```
> Note: remember to use Refactor > Rename so all references to this interface are updated at once!

- Move the code to populate the detail views from `DetailActivity.onCreate()` to `DetailFragment.onViewCreated()`, and make sure the `OnClickListener` for the FAB calls the listener method that the host activity will implement.
```java
public class DetailFragment extends Fragment {
      ...
      @Override
      public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Get selected planet from database
            final PlanetDbHelper planetDbHelper = PlanetDbHelper.getInstance(getContext());
            final Planet selectedPlanet = planetDbHelper.getPlanetById(mSelectedPlanetId);

            // Populate views with planet details
            TextView nameView = (TextView) view.findViewById(R.id.planet_detail_name);
            TextView diameterView = (TextView) view.findViewById(R.id.planet_detail_diameter);
            TextView temperatureView = (TextView) view.findViewById(R.id.planet_detail_temperature);
            TextView ringsView = (TextView) view.findViewById(R.id.planet_detail_rings);
            TextView moonsView = (TextView) view.findViewById(R.id.planet_detail_moons);
            mFavoriteFab = (FloatingActionButton) view.findViewById(R.id.planet_detail_favorite_button);

            nameView.setText(selectedPlanet.getName());
            diameterView.setText(String.format(Locale.getDefault(), "Diameter: %,d km",
                    selectedPlanet.getDiameterInKm()));
            temperatureView.setText(String.format(Locale.getDefault(), "Average temperature: %d°C",
                    selectedPlanet.getAvgTempInC()));
            ringsView.setText(selectedPlanet.hasRings() ? "Has rings" : "Does not have rings");
            moonsView.setText(String.format(Locale.getDefault(), "Number of moons: %d",
                    selectedPlanet.getNumMoons()));
            setFavoriteFabIcon(selectedPlanet.isFavorite());

            // Update the favorite status when the user clicks the FAB
            mFavoriteFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  // Toggle the favorite status
                  selectedPlanet.setFavorite(!selectedPlanet.isFavorite());

                  // Update the database to reflect this change
                  planetDbHelper.updatePlanetFavoriteStatus(mSelectedPlanetId,
                          selectedPlanet.isFavorite());

                  // Update the FAB icon accordingly
                  setFavoriteFabIcon(selectedPlanet.isFavorite());

                  // Call the listener
                  mListener.onFavoriteStatusChange(mSelectedPlanetId, selectedPlanet.isFavorite());
                }
            });
      }
      ...
}
```
> Check: why can't we put this logic to populate the view inside the fragment's `onCreate()` method?


- Update `DetailActivity.java` to use the new detail fragment.
  - Use `FragmentManager` and `FragmentTransaction` (remember to select the support library versions of these) 
```java
public class DetailActivity implements OnFavoriteStatusChangeListener {
        ...
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            ...
            // Load an instance of the detail fragment into its container view
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            DetailFragment detailFragment = DetailFragment.newInstance(selectedPlanetId);
            fragmentTransaction.add(R.id.detail_fragment_container, detailFragment);
            fragmentTransaction.commit();
        }
}
```
  - All activities that host this fragment must implement the `OnFavoriteStatusChangeListener` interface. In `DetailActivity` there isn't anything else to update (since the list of planets isn't visible in that activity) but it must implement the interface anyway; the body of `onFavoriteStatusChange()` doesn't need to do anything.
```java
public class DetailActivity implements OnFavoriteStatusChangeListener {
        ...
        @Override
        public void onFavoriteStatusChange(int planetId, boolean isFavorite) {
            // Nothing to do
        }
}
```


<a name="demo"></a>
## Demo: Adding Alternate Layouts (20 mins)

In order to show the list of planets and the detail fragment side-by-side on large screens, we need an alternate layout file for `ListActivity` that specifies such a layout.
Here's how to add more than one layout file for a single activity, and specify when the new file should be used:
- In the Project explorer, right click the "res/layout" folder > New > Layout resource file
- The filename must _exactly_ match the existing layout file for the activity: `activity_list`
- Under "Available quantifiers" choose "Screen Width", hit >>, enter "900" as the screen width threshold

In the new XML file, copy all the contents of the existing `activity_list.xml`, then add a new `FrameLayout` to serve as a container for the detail fragment. You can use the `layout_weight` attribute to control how wide each element is within the `LinearLayout`.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_list"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    tools:context="com.charlesdrews.masterdetailflowdemo.list.ListActivity">

    <!-- the layout_weights below will make the recycler view take
          up 30% of the screen width, and the fragment the other 70% -->
    <android.support.v7.widget.RecyclerView
        android:id="@+id/planet_list_recycler_view"
        android:layout_width="0dp"
        android:layout_weight="0.3"
        android:layout_height="match_parent"/>

    <FrameLayout
        android:id="@+id/detail_fragment_container"
        android:layout_width="0dp"
        android:layout_weight="0.7"
        android:layout_height="match_parent"/>
</LinearLayout>
```

Now, anytime that criteria is met (screen width is 900dp or greater) then it will use the new version of `activity_list.xml`. If the screen is smaller, it will use the old version. Android checks the user's screen size and picks which XML file it needs on its own; you don't need to write code to determine the size of the user's screen.

But how do we know which XML file was selected? We can simply check whether or not the fragment container is present. Call `findViewById(R.id.detail_fragment_container)` and check if the result is `null`. Null means we've got the original version of the XML, with a single pane, and should launch `DetailActivity` when a planet is clicked.
If it's _not_ `null`, then we've got the new version of the XML with two panes, and should load the detail fragment when a planet is clicked.

```java
    // ListActivity.java

    @Override
    public void onPlanetSelected(int planetId) {

        //If two pane, update detail fragment here in this activity
        //Otherwise, if single pane, launch detail activity
        if (mTwoPane) {
              FragmentManager fragmentManager = getSupportFragmentManager();
              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

              DetailFragment detailFragment = DetailFragment.newInstance(planetId);
              fragmentTransaction.replace(R.id.detail_fragment_container, detailFragment);
              fragmentTransaction.commit();
        }
        else {
              Intent intent = new Intent(this, DetailActivity.class);
              intent.putExtra(DetailFragment.SELECTED_PLANET_ID, planetId);
              startActivity(intent);
        }
    }
```

Don't forget that `DetailFragment` demands that its host activity must implement the `OnFavoriteStatusChangeListener` interface.
In `ListActivity`'s implementation of this, we want to update whichever list item matches the ID of the planet shown in the detail fragment.
Loop through them and have the adapter update just that item.
You could also just call `notifyDataSetChange()` to have the adapter update _all_ the list items, but there's not need to have it do all that work when only one item changed.

```java
    // ListActivity.java

    @Override
    public void onFavoriteStatusChange(int planetId, boolean isFavorite) {
        for (int i = 0; i < mPlanets.size(); i++) {
            if (mPlanets.get(i).getId() == planetId) {
                    mPlanets.get(i).setFavorite(isFavorite);
                    mPlanetListAdapter.notifyItemChanged(i);
                    break;
            }
        }
    }
```

<a name="independent-practice"></a>
## Independent Practice: Implement Master/Detail Flow (30 mins)

Follow the process described above to implement master/detail flow in the Planets app found in the [starter code](starter-code).

> Check: were students able to implement the pattern successfully?

<a name="conclusion"></a>
## Conclusion (5 mins)

Developers often overlook the differences between tablet screens and phone screens, and the result is usually apps that look stretched-out on a tablet with too much white space.
The best way to combat this is to create alternate XML files with different layouts for large screens.
The master/detail flow pattern is the most common example of how alternate XML files are used, and it can drasically improve your users' experience with your app on large screens.

> Check: What are the main steps to implement master/detail flow? How does the detail fragment communicate with its host activity? How do you determine which XML file is being used?

## ADDITIONAL RESOURCES
- [Master/Detail Flow](https://developer.android.com/training/implementing-navigation/descendant.html#master-detail)
- [Supporting Tablets & Multi-Pane Layouts](https://developer.android.com/guide/practices/tablets-and-handsets.html#Fragments)
- [Fragments Developers Guide](http://developer.android.com/guide/components/fragments.html)
- [Adaptive UI Guide](http://developer.android.com/training/multiscreen/adaptui.html)
