---
title: Using External Content Providers
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Using External Content Providers

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Use the Content Providers from UserDictionary and Contacts

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create a Content Provider

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Open and test the provided starter and solution code

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction-content-providers-and-contracts-15-mins)  | Content Providers and Contracts |
| 15 min  | [Demo](#demo-contracts-15-mins)  | Contracts |
| 10 min  | [Codealong](#codealong-userdictionary-10-mins)  | UserDictionary |
| 10 min  | [Independent Practice](#independent-practice-adding-words-to-the-dictionary-10-minutes)  | Adding Words to the Dictionary |
| 15 min  | [Guided Practice](#guided-practice-retrieving-contacts-15-mins)  | Retrieving Contacts |
| 15 min  | [Independent Practice](#independent-practice-contacts-15-mins)  | Contacts |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

As we saw in our previous lesson, we can use a Content Provider to add a layer of abstraction between our data, and being able to access it from within our own app. While this is very useful for internal use, Content Providers allow us to expose our data to other apps as well.


***

<a name="introduction"></a>
## Introduction: Content Providers and Contracts (15 mins)


#### How to expose a Content Provider's data

First, let's look at how we allow other apps to access our data.

```xml
<provider
  android:name=".MyContentProvider"
  android:authorities="com.example.content.MyContentProvider"
  android:exported="true"/>
```

Notice the last line, where exported is set to true. This property allows other apps to use the authority you provide to form a URI, just like we did internally in our app.

#### Contracts

While directly accessing our Content Provider URI will work, Android provides a much more streamlined process through Contracts. In a broad description, a Contract is a Java file that contains definitions of URIs, columns names for the database, permissions, and MIME types.

The permission mentioned above is what requires you to use the `<uses-permission>` tag in your Manifest. It is set as a the writePermission and readPermission properties in the Provider tag in the app containing the Content Provider. While this isn't required if you are exposing you app's data, it lets the user know they are granting this permission upon installing the app.

Today, we will be using permissions required by other Content Providers.



***

<a name="demo"></a>
## Demo: UserDictionary (10 mins)

We're going to take a look at a basic example using the UserDictionary contract used for predictive text in Android.

[UserDictionary](https://github.com/android/platform_frameworks_base/blob/master/core/java/android/provider/UserDictionary.java)

The UserDictionary provides access the Authority, Content URI, all of the columns contained in the table, as well as a helper method for adding new words to the dictionary.

Let's try reading from the User Dictionary! We want to show the words from the user dictionary in a list on the screen.

**You must manually add words to the dictionary if it is empty.** Go to Settings -> Language and Input -> Personal Dictionary.

Take 5 minutes with a partner and try to figure out the steps of what we need to do.

First, let's take a look through the starter code.


#### CursorLoaders

Android provides us with a handy tool to access data stored in ContentProviders called a **CursorLoader**. CursorLoaders take a URI, query it, and provides you the Cursor afterwards. It performs its work in the background, and handles screen rotations too!

Do you remember how we notified the system when data was changed in our Content Provider? CursorLoaders respond to those notifications and update the data being displayed in your app.

First we need to create a constant that will be used to identify our loader (since it's possible to have more than one).

```java
private static final int WORD_LOADER = 0;
```

Next, we have to implement the callback interface used with Loaders, and then implement the methods it requires.

```java
implements LoaderManager.LoaderCallbacks<Cursor>
```

We need to complete three methods:
- onCreateLoader
- onLoadFinished
- onLoaderReset

```java
@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    switch (id){
        case WORD_LOADER:
            return new CursorLoader(this,
                    UserDictionary.Words.CONTENT_URI,
                    new String[]{UserDictionary.Words.WORD},
                    null,
                    null,
                    null
            );
        default:
            return null;
    }
}

@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
    mAdapter.swapData(cursor);
}

@Override
public void onLoaderReset(Loader loader) {
    mAdapter.swapData(null);
}
```

Finally, we have to initialize the Loader using the SupportLoaderManager.

```java
getSupportLoaderManager().initLoader(WORD_LOADER,null,this);
```

***

Let's try to run the app!

If you notice, we have an error that we need to set the correct permission in our Manifest.

```xml
<uses-permission android:name="android.permission.READ_USER_DICTIONARY" />
<uses-permission android:name="android.permission.WRITE_USER_DICTIONARY"/>
```

That's it! We just used the User Dictionary Content Provider to retrieve information.


***

## Independent Practice: Adding Words to the Dictionary (10 minutes)

Next, you will have to figure out how to add words to the dictionary. Using the link provided to the User Dictionary, or through the API documentation, write the code needed to add your own words. Complete the click listener provided in MainActivity.


***

<a name="guided-practice"></a>
## Guided Practice: Retrieving Contacts (15 mins)

Another popular built-in Content Provider is for the Contacts. Android provides a Contacts Contract to access nearly every aspect of the contacts you have stored in your phone. We are going to build an app that displays the names of our Contacts.

Just like with the User Dictionary, we have to add in the permission to read from our contacts list.

```xml
<uses-permission android:name="android.permission.READ_CONTACTS"/>
```

Let's look through the starter code.


Now, we have to start using the [Contacts Contract](http://developer.android.com/reference/android/provider/ContactsContract.html). We are going to need the DISPLAY_NAME column because we want the names of our contacts. Also from the documentation, we know we need the CONTENT_URI.

Let's use a CursorLoader again!

```java
private static final int CONTACTS_LOADER = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
  ...
  getSupportLoaderManager().initLoader(CONTACTS_LOADER,null,this);
}

@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {
  switch (id){
      case CONTACTS_LOADER:
          return new CursorLoader(
                  this,
                  ContactsContract.Contacts.CONTENT_URI,
                  new String[]{ContactsContract.Contacts._ID,
                                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY},
                  null,
                  null,
                  null
          );
      default:
          return null;
  }
}

@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
  mAdapter.swapData(cursor);
}

@Override
public void onLoaderReset(Loader<Cursor> loader) {
  mAdapter.swapData(null);
}
```

That's it! Now when we run the app, it should show our contacts.


***

<a name="ind-practice"></a>
## Independent Practice: Contacts (15 mins)

Modify the Contacts code you have written so far to allow you to delete contacts from your Contact list when you long press on them. This code needs to be written in the RecyclerView adapter. If you have extra time, add the ability to add and edit your contacts.

**Hint:** The URI required to delete is CONTENT_URI/id


***

<a name="conclusion"></a>
## Conclusion (5 mins)

Accessing other apps' Content Providers through Contracts makes it very easy to work with data from all over your phone. It's important to know how to leverage the other data stored on your user's device and not feel the need to contain everything within your app.

***

### ADDITIONAL RESOURCES
- [Content Providers](http://developer.android.com/guide/topics/providers/content-providers.html)
- [Contacts Content Provider](http://developer.android.com/guide/topics/providers/contacts-provider.html)
