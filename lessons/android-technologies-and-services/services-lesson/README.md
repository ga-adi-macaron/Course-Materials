---
title: Services
duration: "1:35"
creator:
    name: Aleksandr Tomak
    city: SF
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Services


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe why we use Services
- Describe Service lifecycle
- Write your own custom service
- Write an Intent Service

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Extend classes and implement interfaces

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through each lesson section and add or edit content as needed

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 10 min  | [Introduction](#introduction-services-10-mins)  | Services |
| 15 min  | [Introduction](#introduction-types-of-services-started-and-bound-15-mins)  | Types of Services - Started and Bound |
| 15 min  | [Demo](#demo-create-a-service-15-mins)  | Create a Service |
| 5 min  | [Guided Practice](#guided-practice-too-much-going-on-5-mins)  | Too Much Going On |
| 15 min  | [Demo](#demo-creating-a-new-thread-15-mins)  | Creating a New Thread |
| 20 min  | [Independent Practice](#independent-practice-write-your-own-custom-service-20-mins)  | Write Your Own Custom Service |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

Snapchat and Instagram continue to upload your video/photo even after you terminate the app.  Spotify and Pandora can play music even if your app is backgrounded and you use another app.


***

<a name="introduction"></a>
## Introduction: Services (10 mins)

A Service is an application component that can perform long-running operations in the background and does not provide a user interface.


For example, a service might handle network transactions, play music, perform file I/O, or interact with a content provider, all from the background.

A Service is **not** a separate process. The Service object itself does not imply it is running in its own process; unless otherwise specified, it runs in the same process as the application it is part of.

A Service is **not** a thread. It is not a means itself to do work off of the main thread (to avoid Application Not Responding errors).


#### Service class methods

<p align="center">
  <img src="assets/service_lifecycle.png">
</p>

There are a number of important methods in the service class, they are:

[`onCreate()`](http://developer.android.com/reference/android/app/Service.html#onCreate()): The system calls this method when the service is first created, to perform one-time setup procedures (before it calls either `onStartCommand()` or `onBind()`). If the service is already running, this method is not called.

[`onStartCommand()`](http://developer.android.com/reference/android/app/Service.html#onStartCommand(android.content.Intent, int, int)): The system calls this method when another component, such as an activity, requests that the service be started, by calling startService(). Once this method executes, the service is started and can run in the background indefinitely. If you implement this, it is your responsibility to stop the service when its work is done, by calling `stopSelf()` or `stopService()`. (**If you only want to provide binding, you don't need to implement this method.**)

This method returns an int that describes how the service should restart if it needed to be stopped. There are three commonly used options:
  - **START_STICKY**: The service will be restarted with null data passed to it.
  - **START_NOT_STICKY**: The service will not be restarted unless there are pending startService calls.
  - **START_REDELIVER_INTENT**: Similar to START_STICKY, but the original Intent is also redelivered.

[`onBind()`](http://developer.android.com/reference/android/app/Service.html#onBind(android.content.Intent)): The system calls this method when another component wants to bind with the service, by calling `bindService()`. In your implementation of this method, you must provide an interface that clients use to communicate with the service, by returning an `IBinder`. **You must always implement this method, but if you don't want to allow binding, then you should return null**.

[`onDestroy()`](http://developer.android.com/reference/android/app/Service.html#onDestroy()): The system calls this method when the service is no longer used and is being destroyed. Your service should implement this to clean up any resources such as threads, registered listeners, receivers, etc. **This is the last call the service receives**.

> Check: Ask students to guess what order would the methods be called.

For services started by `Context.startService()`, `onCreate()` is called first, and then `onStartCommand()`.

For services that are bound via `Context.bindService()`, `onCreate()` is called first, and then `onBind()`. Note that `onStartCommand()` **is not called**.

***

## Introduction: Types of Services - Started and Bound (15 mins)

#### Started Services

A service is "started" when an application component (such as an activity) starts it by calling `startService()`. Once started, a service can run in the background **indefinitely**, even if the component that started it is destroyed. Usually, a started service performs a single operation and does not return a result to the caller. For example, it might download or upload a file over the network. When the operation is done, the service should stop itself via `stopSelf()`.

The service continues running until `Context.stopService()` or `stopSelf()` is called. Note that multiple calls to `Context.startService()` do not nest (though they do result in multiple corresponding calls to `onStartCommand()`), so no matter how many times it is started, a service will be stopped once `Context.stopService()` or `stopSelf()` is called; however, services can use the `stopSelf(int)` method to ensure the service is not stopped until started intents have been processed.



#### Bound Services

A service is "bound" when an application component binds to it by calling `bindService()`. A bound service offers a client-server interface that allows components to interact with the service, send requests, get results, and even do so across processes with interprocess communication (IPC). A bound service runs only as long as another application component is bound to it. Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed.


***

#### Started and Bound Services

A service can be both started and have connections bound to it. In such a case, the system will keep the service running as long as either it is started or there are one or more connections to it with the `Context.BIND_AUTO_CREATE` flag. If neither of these situations hold, the service's `onDestroy()` method is called and the service is effectively terminated. All cleanup (stopping threads, unregistering receivers) should be complete upon returning from `onDestroy()`.


***

<a name="guided demo"></a>
## Demo: Create a Service (15 mins)

Code along, if you want!

#### Add permissions to Manifest file

Like activities (and other components), you must declare all services in your application's manifest file.

To declare your service, add a `<service>` element as a child of the `<application>` element. For example:

```xml
<manifest ... >
  ...
  <application ... >
      <service android:name=".MyService" />
      ...
  </application>
</manifest>
```

The `android:name` attribute is the only required attribute — it specifies the class name of the service. Once you publish your application, you should not change this name because if you do, you risk breaking code that is dependent on explicit intents to start or bind the service (read the blog post, [Things That Cannot Change](http://android-developers.blogspot.com/2011/06/things-that-cannot-change.html)).

Additionally, you can ensure that your service is only available to your app by including the `android:exported` attribute and setting it to "false". This effectively stops other apps from starting your service, even when using an explicit intent.

If we want to make this service run in a remote process, instead of the standard one for its .apk, we can use `android:process` in its manifest tag to specify one:

```xml
<service android:name=".MyService"
        android:exported="false"
        android:process=":remote" />
```

#### Subclass Service

```java
public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service Started, should do some work");

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service Destroyed");
    }
}
```

You are **required** to implement the `onBind()` method. Return null if you don't want to bind to the Service.

Override `onCreate()` method and setup the Service.

Override `onStartCommand()` method and give the Service work to do.



#### Starting a Service

```java
Intent intent = new Intent(MainActivity.this, MyService.class);
startService(intent);
```

The `startService()` method returns immediately, and the Android system calls the service's `onStartCommand()` method. If the service is not already running, the system first calls `onCreate()`, then calls `onStartCommand()`.


Don't forget to stop a service when you're done with it. We can add the following code to stop the service when we leave the activity.

```java
@Override
protected void onStop() {
    super.onStop();
    stopService(new Intent(MainActivity.this,MyService.class));
}
```

***

## Guided Practice: Too Much Going On (5 mins)

**Caution**: A service runs in the same process as the application in which it is declared, and in the main thread of that application, by default. So, if your service performs intensive or blocking operations while the user interacts with an activity from the same application, the service will slow down activity performance.

## Demo: Using HandlerThreads (15 mins)

There are a few basic components terms we need to define:

- **Looper**: A Looper takes in a queue of Message objects, and sends them to the correct place to be processed.
- **Handler**: A Handler receives Messages from a Looper, and processes them.
- **HandlerThread**: A HandlerThread is a special type of Handler provided to us that automatically creates a Looper on a new Thread, so we don't have to take care of the threading ourselves.

In our onCreate method for the Service, we need to create our HandlerThread, get the Looper from it, and use it to make our custom Handler.

```java
private HandlerThread mHandlerThread;
private Handler mHandler;

@Override
public void onCreate() {
    super.onCreate();
    Log.i(TAG, "onCreate: ");
    mHandlerThread = new HandlerThread("My Thread");
    mHandlerThread.start();
    Looper looper = mHandlerThread.getLooper();      
    mHandler = new Handler(looper) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String name = (String) msg.obj;
            Log.i(TAG, "The handler is doing something...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "The name in the message is: " + name);
        }
    };
}
```

Then, in onStartCommand, we need to send data to our Handler to be processed.

```java
@Override
public int onStartCommand(Intent intent, int flags, int startId) {
  Message msg = mHandler.obtainMessage();
  msg.obj = intent.getStringExtra("name");
  mHandler.sendMessage(msg);
  return START_NOT_STICKY;
}
```

## Demo: Creating a New Thread/Runnable(15 mins)

**This is an alternative to HandlerThreads, they accomplish the same task.**

To avoid impacting application performance, you should:

- Start a new thread inside the service
- Use an Intent Service that subclasses Service and uses a thread to run the task for you

To create a new instance of Thread class: ` Thread customThread = new Thread()`. Note, the thread constructor requires a `Runnable` object.

To create a new `Runnable` instance:

```java
Runnable customRunnable = new Runnable() {
    @Override
    public void run() {
        // This is where the real work happens
        try {
            // sleep the thread for 5 seconds instead of doing work
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
};
```

Putting the two steps together we get:

```java
// create thread and pass in a runnable task
Thread customThread = new Thread(new Runnable() {
    @Override
    public void run() {
        // this is where the real work happens
        try {
            // sleep the thread for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
});
```
***

#### Intent Service

The IntentService does the following:

- Creates a default worker thread that executes all intents delivered to `onStartCommand()` separate from your application's main thread
- Creates a work queue that passes one intent at a time to your `onHandleIntent()` implementation, so you never have to worry about multi-threading
- Stops the service after all start requests have been handled, so you never have to call `stopSelf()`
- Provides default implementation of `onBind()` that returns null
- Provides a default implementation of `onStartCommand()` that sends the intent to the work queue and then to your `onHandleIntent()` implementation

The code below is an example of implementation that requires us to override `onHandleIntent()`:

```java
public class HelloIntentService extends IntentService {

  /**
   * A constructor is required, and must call the super IntentService(String)
   * constructor with a name for the worker thread.
   */
  public MyIntentService() {
      super("MyIntentService");
  }

  /**
   * The IntentService calls this method from the default worker thread with
   * the intent that started the service. When this method returns, IntentService
   * stops the service, as appropriate.
   */
  @Override
  protected void onHandleIntent(Intent intent) {
      // Normally we would do some work here, like download a file.
      // For our sample, we just sleep for 5 seconds.
      try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          // Restore interrupt status.
          Thread.currentThread().interrupt();
      }
  }
}
```

## Guided Practice: Use an IntentService (5 mins)

Let's accomplish the same thing we did before, but using an IntentService.

First, we need to extend IntentService, then put our actions in onHandleIntent.
```java
public class MyIntentService extends IntentService{
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String name = intent.getStringExtra("name");
        Log.i(TAG, "The intent service is doing something...");
        try {
            //Sleep the thread for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "The name in the intent is: " + name);
    }
}
```

Last, we need to start the service.

```java
Intent intent2 = new Intent(MainActivity.this, MyIntentService.class);
intent2.putExtra("name","Drew");
startService(intent2);
```

## Independent Practice: Write Your Own Custom Service (20 mins)

Open [provided sample code](starter-code). Refer to the [provided solutions](solution-code) to check your answers.


Your job is to create two classes inside the ```service``` package:
- `CustomService` which extends `Service` class.
- `CustomIntentService` which extends `IntentService` class.

In each Service, call `Thread.sleep(10000);` to pause the **worker thread**. This simulates some work being done (ie downloading a file). Log a message once the thread is done sleeping.

Fill in the ```TODO's``` in ```MainActivity.java``` to:
- Start custom service
- Stop custom service
- Start intent service
- Stop intent service

Make sure to add logs with info level in each method override **to see the service lifecycle!**
```java
@Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service Destroyed");
    }
```

**Bonus:**

- Use Thread and Runnable to do work inside of CustomService. The "work" is to sleep the Thread's runnable.


<a name="conclusion"></a>
## Conclusion (5 mins)

- Why do we use Services?
- What is the difference between a started Service and a bound Service? Can you have both?
- How can you use a Service to perform long operations such a networking or writing to a file?

***

### ADDITIONAL RESOURCES
- [Services](http://developer.android.com/guide/components/services.html)
- [More on Services](http://developer.android.com/reference/android/app/Service.html)
- [Example of a Bound Service](http://www.truiton.com/2014/11/bound-service-example-android/)
