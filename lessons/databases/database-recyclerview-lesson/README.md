---
title: Cursor Adapters
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Cursor Adapters
Week 4 | Lesson 4

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Convert data from the cursor into a List
- Create a RecyclerView Adapter to use data from the database

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Understand the code supporting Cursor behavior
- Be able to perform basic SQLite queries in an Android app

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction-cursor-adapters-15-mins)  | Cursor Adapters |
| 10 min  | [Demo](#demo-cursor-adapters-10-mins)  | Cursor Adapters |
| 15 min  | [Guided Practice](#guided-practice-cursor-adapters-15-mins)  | Cursor Adapters |
| 10 min  | [Introduction](#introduction-simple-cursor-adapters-10-mins)  | Simple Cursor Adapters |
| 5 min  | [Demo](#demo-simplecursoradapter-5-mins)  | SimpleCursorAdapter |
| 10 min  | [Guided Practice](#guided-practice-simplecursoradapter-10-mins)  | SimpleCursorAdapter |
| 15 min  | [Independent Practice](#independent-practice-topic-15-minutes)  | Topic |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

Now that we've covered the basics of SQL, integrating SQLite databases into your apps, and Cursor behavior, we are finally ready to cover combining RecyclerViews with databases. Databases are a very important part to many popular apps, and knowing how to work with them is crucial. We will expand our understanding of querying the database and how to effectively display the data from those queries on the screen.   


***

<a name="introduction"></a>
## Introduction: Converting Cursors into Lists (15 mins)

We've already seen Adapters when working with ListViews and RecyclerViews, and how important they are for displaying your collections in your app. Until now, our adapters have been using Lists to display our data. We have the option of modifying our adapters to use the updated cursor, or creating the ability to turn the cursor into a List to be used in the adapter; we will be doing the latter. Each time a new query is made, a new cursor is returned, and our adapter should be updated with its data.


One important item to note is that your table in the database should have an id column that contains a unique id value for each entry. The exception to this is if you have some sort of other uniquely identifying column.


***

<a name="demo"></a>
## Demo: Converting Cursors into Lists (20 mins)

Now that we know what our goal is, let's create and implement a very basic cursor to list method. We can start with the CursorAdapterDemo project.


We need to do the following:

1. Open a **readable** connection to the database
2. Query the database to get a Cursor
3. Create a List to store the data
4. Check the cursor to see if data exists
5. If it does, loop through the Cursor and add an object to the list for each row
6. Return the completed list

First, we need to make a custom object that represents a single row in the database. Take a look at the SQLiteOpenHelper, and notice it contains a title and description column.

```java
public class CustomObject {
  private String mTitle, mDescription;

  public CustomObject(String title, String description) {
      mTitle = title;
      mDescription = description;
  }

  //Getters and setters
}
```

Then, we need to write our method in the Helper to query the database and create a list.

```java
public List<CustomObject> getAllRowsAsList(){
  SQLiteDatabase db = getReadableDatabase();

  Cursor cursor = db.query(EXAMPLE_LIST_TABLE_NAME,
          null,
          null,
          null,
          null,
          null,
          null);

  List<CustomObject> objectList = new ArrayList<>();

  //Check if data exists
  if(cursor.moveToFirst()){
    //Loop through the cursor
    while (!cursor.isAfterLast()){
        //Retrieve name and description from cursor
        String name = cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME));
        String description = cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
        //Create new object with retrieved data
        CustomObject object = new CustomObject(name,description);
        //Add object, representing a row from the database, to the list
        objectList.add(object);

        //Move cursor to next position
        cursor.moveToNext();
    }
  }

  return objectList;
}
```

Now that we've retrieved the data, let's check it in the console to make sure it is working.


```java
//In MainActivity.java
protected void onCreate(Bundle savedInstanceState) {
  ...

  ExampleSQLiteOpenHelper helper = ExampleSQLiteOpenHelper.getInstance(this);

  List<CustomObject> objectList = helper.getAllRowsAsList();

  for (CustomObject object:objectList) {
    System.out.println(object.getTitle()+": "+object.getDescription());
  }
}
```


***

<a name="independent-practice"></a>
## Independent Practice: Create the RecyclerView (40 mins)

Now that we've successfully retrieved the data and turned it into a list, we need to display it on the screen with a RecyclerView.

Take 30 minutes to create the ViewHolder, Item Layout, and Adapter.

**Bonus**: Add in functionality for adding and deleting items in the database, and have it reflect on the RecyclerView.

First, we can create our new layout, if we don't want to use a built in layout such as simple_list_item_2.

```xml
//XML Layout
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical" android:layout_width="match_parent"
              android:layout_height="wrap_content">
    <TextView
        android:id="@+id/name_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textStyle="bold"/>
    <TextView
        android:id="@+id/description_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
</LinearLayout>
```

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
  ...
  RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

  recyclerView.setLayoutManager(linearLayoutManager);

  recyclerView.setAdapter(new CustomRecyclerViewAdapter(objectList));
}
```

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    List<CustomObject> mObjectList;

    public CustomRecyclerViewAdapter(List<CustomObject> objectList) {
        mObjectList = objectList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CustomViewHolder(inflater.inflate(R.layout.custom_item,parent,false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.mTextView1.setText(mObjectList.get(position).getTitle());
        holder.mTextView2.setText(mObjectList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }
}
```

```java
public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView1, mTextView2;

    public CustomViewHolder(View itemView) {
        super(itemView);

        mTextView1 = (TextView)itemView.findViewById(R.id.name_text_view);
        mTextView2 = (TextView)itemView.findViewById(R.id.description_text_view);
    }
}
```



***

<a name="conclusion"></a>
## Conclusion (5 mins)

Databases play a large part in many modern apps, which means integrating cursors with RecyclerViews is crucial. Soon, we are going to add the ability to search into our apps.

***

### ADDITIONAL RESOURCES
