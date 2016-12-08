---
title: Sync Adapters
duration: "1:20"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Sync Adapters


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Define use cases for a Sync Adapter
- Compare and contrast Sync Adapter and Job Scheduler
- Implement a Sync Adapter

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe Content Providers

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction-what-is-a-syncadapter-15-mins)  | What is a SyncAdapter |
| 20 min  | [Demo](#demo-setting-up-the-sync-adapter-20-mins)  | Setting up the Sync Adapter |
| 10 min  | [Introduction](#introduction-using-the-syncadapter-10-mins)  | Using the SyncAdapter |
| 10 min  | [Guided Practice](#guided-practice-performing-the-sync-10-mins)  | Performing the Sync |
| 5 min  | [Independent Practice](#independent-practice-interacting-with-the-content-provider-5-mins)  | Interacting with the Content Provider |
| 5 min  | [Guided Practice](#guided-practice-content-observer-10-minutes)  | CursorLoader |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

So far we've been able to incorporate a lot of really cool features into our apps, including sending and receiving data from our device. This is very useful with today's constantly connected world. Unfortunately, we've had to do all of this manually, so far. Luckily, Android provides a very handy feature called the `SyncAdapter` that works to run synchronization operations without a bunch of manual work.


***

<a name="introduction"></a>
## Introduction: What is a SyncAdapter (15 mins)

Basically, a `SyncAdapter` is a helper class to handle background syncing in an efficient and easy manner. It registers with the system to only run syncs at specific times.

Here are some key features Sync Adapters have (from the Android documentation):

- **Automated execution** - Allows you to automate data transfer based on a variety of criteria, including data changes, elapsed time, or time of day. In addition, the system adds transfers that are unable to run to a queue, and runs them when possible.
- **Automated network checking** - The system only runs your data transfer when the device has network connectivity.
- **Improved battery performance** - Allows you to centralize all of your app's data transfer tasks in one place, so that they all run at the same time. Your data transfer is also scheduled in conjunction with data transfers from other apps. These factors reduce the number of times the system has to switch on the network, which reduces battery usage.
- **Account management and authentication** - If your app requires user credentials or server login, you can optionally integrate account management and authentication into your data transfer.


There are three ways of setting up syncs: Automated, Periodic, and Manual

#### Automatic Sync

For automated syncing, you can have data sync in response to another event. As we learned previously, it is possible to monitor Content Providers for changes in data. It is possible to schedule synchronization when your app detects a change in the data!

Another way to schedule syncs is to have an external service, such as Google Cloud Messaging, notify your device that there is data to sync remotely, so your device will attempt to start a sync.

#### Periodic Sync

You can also have the app register with the system to sync at certain intervals. You need to be careful with this, because you are simply telling the system you want to sync at that interval, but the system decides when it actually happens, so there could be a delay.

#### Manual Sync

The final option is to tell the device manually that you want to sync, such as on a button press. This is the least ideal situation, since syncs should ideally be a seamless, behind-the-scenes process.


***

<a name="demo"></a>
## Demo: Setting up the Sync Adapter (20 mins)

Creating a Sync Adapter can be broken down into five steps:

1. Creating the account authenticator (if needed)
2. Creating the Content Provider (if needed)
3. Creating the SyncAdapter class
4. Creating the Sync Service
5. Connecting everything together in your Activity!

While the first two aren't mandatory, the SyncAdapter requires them to be present, even if all they do is act as a placeholder.

#### Step 1

Since we aren't going to be authenticating with anything in our example, the starter-code contains the [stub authenticator code provided by Google](http://developer.android.com/training/sync-adapters/creating-authenticator.html).


#### Step 2

Today, the content provider is written for you, along with its database. It will hold the titles of news articles.

#### Step 3

Now we're finally at step where we create our SyncAdapter

```java
public class SyncAdapter extends AbstractThreadedSyncAdapter {

    // Global variables
    // Define a variable to contain a content resolver instance
    ContentResolver mContentResolver;

    /**
     * Set up the sync adapter
     */
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();
    }



    /**
     * Set up the sync adapter. This form of the
     * constructor maintains compatibility with Android 3.0
     * and later platform versions
     */
    public SyncAdapter(
            Context context,
            boolean autoInitialize,
            boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();

    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {

    }
}
```

The second constructor allows for compatibility to sync if there are multiple accounts signed in on the device.

`onPerformSync` is where the real magic happens. Android automatically runs this in a background thread, so any work we do here will be handled without interrupting our UI thread.

Next, we need to set up some configuration options for the SyncAdapter. Create `syncadapter.xml` in your xml folder.

```xml
<?xml version="1.0" encoding="utf-8"?>
<sync-adapter
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:contentAuthority="ly.generalassemb.drewmahrt.syncadapterexample.StubProvider"
    android:accountType="example.com"
    android:userVisible="false"
    android:supportsUploading="true"
    android:allowParallelSyncs="false"
    android:isAlwaysSyncable="true"/>
```

The last thing in this step is to add our permissions.


```xml
<uses-permission
        android:name="android.permission.INTERNET"/>
    <uses-permission
        android:name="android.permission.READ_SYNC_SETTINGS"/>
    <uses-permission
        android:name="android.permission.WRITE_SYNC_SETTINGS"/>
    <uses-permission
        android:name="android.permission.AUTHENTICATE_ACCOUNTS"/>
```

**INTERNET**: You can upload and download data.
**READ_SYNC_SETTINGS**: Needed to check if the account is syncable
**WRITE_SYNC_SETTINGS**: Needed to add periodic syncs
**AUTHENTICATE_ACCOUNTS**: Needed for any account authentication purposes

#### Step 4

Just like the authenticator, we need to set up a service for the SyncAdapter to work in.

```java
public class MySyncService extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static SyncAdapter sSyncAdapter = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null)
                sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
```
...and we need to add it to our manifest.

```xml
<service
    android:name="ly.generalassemb.drewmahrt.syncadapterexample.MySyncService">
            <intent-filter>
                <action android:name="android.content.SyncAdapter"/>
            </intent-filter>
            <meta-data
                android:name="android.content.SyncAdapter"
                android:resource="@xml/syncadapter" />
        </service>
```

The `android:name="android.content.SyncAdapter"` code is telling the system that this `SyncService` needs to be registered with the system's Sync Manager so all syncing can be handled automatically.

#### Step 5

Now it's time to put all of the pieces together. First, let's take a look through the provided starter code.

```java
public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getName();

    private RecyclerView mArticlesRecyclerView;
    NewsRecyclerViewAdapter mAdapter;

    //TODO: Create constant to identify the Cursor Loader

    // Constants
    // Account type
    public static final String ACCOUNT_TYPE = "example.com";
    // Account
    public static final String ACCOUNT = "default_account";

    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccount = createSyncAccount(this);
        mArticlesRecyclerView = (RecyclerView) findViewById(R.id.articles_list);
        mArticlesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        mAdapter = new NewsRecyclerViewAdapter(new ArrayList<String>());
        mArticlesRecyclerView.setAdapter(mAdapter);


    }

    /**
     * Create a new dummy account for the sync adapter
     *
     * @param context The application context
     */
    public static Account createSyncAccount(Context context) {
        // Create the account type and default account
        Account newAccount = new Account(
                ACCOUNT, ACCOUNT_TYPE);
        // Get an instance of the Android account manager
        AccountManager accountManager =
                (AccountManager) context.getSystemService(
                        ACCOUNT_SERVICE);
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }
        return newAccount;
    }

    //TODO: Complete Loader callbacks
}
```


***

<a name="introduction"></a>
## Introduction: Using the SyncAdapter (10 mins)

Now that we have everything set up, we can start syncing! Let's look at how to set up a periodic sync, and how to request a sync on demand.


```java

//Manual sync
Bundle settingsBundle = new Bundle();
settingsBundle.putBoolean(
        ContentResolver.SYNC_EXTRAS_MANUAL, true);
settingsBundle.putBoolean(
        ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        /*
         * Request the sync for the default account, authority, and
         * manual sync settings
         */
ContentResolver.requestSync(mAccount, NewsContract.AUTHORITY, settingsBundle);
```
We can start the app off by creating a manual sync. Creating a manual sync involves passing two settings. The first tells the system that this is a manual sync, and the second tries to move it further up in the list of items waiting to be synced.

To set up a periodic sync, it is extremely simple. In your onCreate (or wherever you want to activate syncing), call the following:

```java
//Periodic sync
ContentResolver.setSyncAutomatically(mAccount,NewsContract.AUTHORITY,true);
ContentResolver.addPeriodicSync(
        mAccount,
        NewsContract.AUTHORITY,
        Bundle.EMPTY,
        60);
```
The first line only needs to be called once, it turns on the ability for your app to automatically sync.

The last parameter in the second method call is how often you want the sync to occur in seconds. So 60 is every minute.


***

<a name="guided-practice"></a>
## Guided Practice: Performing the Sync (10 mins)

Let's use the New York Times Newswire API to get the latest stories. We can sync this every minute to show any new stories that come in. http://developer.nytimes.com/

To get the latest 20 stories, we can make the following call:

http://api.nytimes.com/svc/news/v3/content/all/all/all.json?limit=20&api-key=YOURAPIKEY


Objects to hold the search results have been provided for use with GSON. We are going to use these search results to store the news article titles in the database.

For our build.gradle

```
compile 'com.google.code.gson:gson:2.6'
```

In onPerformSync

```java
@Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
      mContentResolver.delete(NewsContract.Articles.CONTENT_URI,null,null);

      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder()
              .url("http://api.nytimes.com/svc/news/v3/content/all/all/all.json?limit=20&api-key=d1934738c85789ae6e8dac61ddca1abc%3A12%3A74602111")
              .build();

      Response response = null;
      try {
          response = client.newCall(request).execute();
          if (!response.isSuccessful())
              throw new IOException("Unexpected code " + response);

          Gson gson = new Gson();
          SearchResult result = gson.fromJson(response.body().string(),SearchResult.class);

          for (int i = 0; i < result.getResults().size(); i++) {
              //TODO: Complete onPerformSync for the Independent Practice
              Log.d(TAG,"Latest story: "+result.getResults().get(i).getTitle());
          }

      } catch (IOException e) {
          e.printStackTrace();
      }
    }
```


***

<a name="ind-practice"></a>
## Independent Practice: Interacting with the Content Provider and CursorLoader (10 mins)

In this practice, you will be completing the onPerformSync method to add the news articles to the Content Provider. Think about what action you need to perform on the Content Provider to put our search results in the database.

Additionally, we need to reflect those changes in our UI. Previously we have used CursorLoaders to interact with ContentProviders to show our data. Work with a partner to add a CursorLoader to display the content.


***

<a name="conclusion"></a>
## Conclusion (5 mins)

SyncAdapters can be very useful for setting up syncing operations without having to worry about the details of how and when the syncing will happen. Since the system takes care of all of the management for you, all that is left is the actual syncing operation. Also, the close tie-ins with Content Providers makes it easy to make sure your most up to date data is displayed across your app as well as anyone else who might access data from the app.

***

### ADDITIONAL RESOURCES
- [Sync Adapters](http://developer.android.com/training/sync-adapters/index.html)
