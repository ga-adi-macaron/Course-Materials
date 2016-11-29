---
title: Job Scheduler
duration: "1:30"
creator:
    name: Alan Caceres
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Using JobSchedulers to improve the performance of our apps

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the components of a JobScheduler
- Set up a task and schedule it to run under certain conditions

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Implement a Service class

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction)  | What is a JobScheduler |
| 5 min  | [Demo](#demo-job-scheduler-components-5-mins)  | The components of a JobScheduler |
| 10 min  | [Guided Practice](#guided-practice-implementing-a-job-service-10-mins)  | Setting up a JobService class |
| 30 min  | [Guided Practice](#guided-practice-setting-up-job-constraints-with-job-info-30-mins)  | Setting up job constraints using a JobInfo object|
| 20 min  | [Independent Practice](#independent-practice-topic-20-mins)  | Topic |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

We've learned a lot of Android stuff so far, but we haven't gone into
learning optimization techniques. JobScheduler is a class that helps us optimize
our apps so that we can perform tasks based on certain conditions. In this lesson,
we will be learning about the different components needed to successfully use the
JobScheduler in our apps, and implementing them to perform a certain task.
***

<a name="introduction"></a>
## Introduction: What is a JobScheduler (15 mins)

In API version 21, aka Android Lollipop, Google introduced the JobScheduler.
JobSchedulers allow your app to schedule different tasks to take place under specific
requirements. For example, you can have your app perform tasks only when the device
is using a Wi-Fi connection, charging, and is not currently being handled by the user.
Using the JobScheduler, you can improve the battery life of your user's device
by only performing tasks when they meet these requirements. A great way to encourage
your user to keep your app installed on their device.

***


<a name="demo-job-scheduler-components-5"></a>
## Demo: Components used with JobScheduler (5 mins)

- `JobScheduler`
  - This is the component that handles the various jobs that get scheduled in your application. You will use this to schedule the jobs you set up.
- `JobInfo`
  - This is the component that you will use to set up the various conditions you want to run you tasks. We will be using `JobInfo.Builder` to aid us in creating our jobs.
- `JobService`
  - This is the component that will actually do the work. It is similar to creating a Service but with different methods to implement.

***

<a name="guided-practice-implementing-a-job-service-10-mins"></a>
## Guided Practice: Setting up a JobService class (20 mins)

Now that we have our Android projects up let's create a new class that extends the `JobService`
class. Make sure to implement the required methods `onStartJob` and `onStopJob` in the class.

```java
public class MyJobService extends JobService {

  @Override
    public boolean onStartJob(JobParameters jobParameters) {
      //Implement task in here

      //Set to true if job needs to be rescheduled
      jobFinished(mParameters, false); //tell the JobScheduler we have completed the job

      //return true if the job will take a long time to complete, or it will be rescheduled
      //return false if the job is very short
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
      //Stop any tasks that are currently running in here
      //return true if this job needs to be rescheduled
      //return false if this job does not need to be rescheduled
        return false;
    }

}
```

We also need to add this `Service` to our AndroidManifest.

```xml
<service android:name=".MyJobService"
            android:permission="android.permission.BIND_JOB_SERVICE"/>
```

***

<a name="guided-practice-setting-up-job-constraints-with-job-info-30-mins"></a>
## Guided Practice: Setting up a JobInfo object for certain conditions (30 mins)

  Let us now switch over to our `MainActivity` to build our `JobInfo` object for our `JobScheduler` to use.

Inside the `onCreate()` let us instantiate a `JobInfo.Builder` to help us build our `JobInfo` object.

```java
public static final int JOB_ID = 1;
//The jobId can be any integer you want it to be
//The class name should be the name
//of the JobService you created
JobInfo job = new JobInfo.Builder(JOB_ID,
  new ComponentName(getPackageName(),
  MyJobService.class.getName()))
```
 We can now set the conditions we want our job to run under.

 ```java
 //The jobId can be any integer you want it to be
 //The class name should be the name
 //of the JobService you created
 JobInfo job = new JobInfo.Builder(12321,
   new ComponentName(this,
   MyJobService.class))
        .setPeriodic(5000) //This ensures our job runs every 5 seconds.
        .build();
 ```

 We can also pass extra data into our jobs using a PersistedBundle

 ```java
 //Near where you create the JobInfo
 PersistableBundle periodicBundle = new PersistableBundle();
         periodicBundle.putString("type","Periodic");

//Added call in JobInfo Builder
.setExtras(periodicBundle)

//Retrieve data in JobService
jobParameters.getExtras().getString("type")
 ```



 ***

 <a name="guided-practice-scheduling"></a>
 ## Guided Practice: Using the JobScheduler to schedule our job (10 mins)

 Now that we have set up our `JobInfo` object we now need to schedule that job to be run. This is where the `JobScheduler` comes in. `JobScheduler` is a system provided service; so we need to get a reference to that by using `getSystemService(JOB_SCHEDULER_SERVICE)`

 ```java
 JobScheduler jobScheduler =
 (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
 ```

 Now we can call the `schedule()` method on the `JobScheduler` to schedule our job.

 ```java
 jobScheduler.schedule(job);
 ```
 And now our job will be run every 5 seconds.

***

## Guided Practice: Running tasks in the background

Let us now add an AsyncTask to perform some work in the background.

Let's add a member variable to our class.
```java
private AsyncTask mTask;
```

Now in our `onStartJob` method let's set up our AsyncTask.

```java
@Override
  public boolean onStartJob(JobParameters jobParameters) {
      mTask = new AsyncTask<Void,Void,String>(){

        @Override
           protected String doInBackground(Void... voids) {

             //get an instance of a Calendar object
             //NOT the ContentProvider Calendar.
              Calendar cal = Calendar.getInstance();

              cal.setTimeInMillis(System.currentTimeMillis());

              //A helper class to format the time we get into human readable Strings
              SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

              String newText = "Current Time: " + format.format(cal.getTime());

              return newText;
           }

        @Override
           protected void onPostExecute(String string) {
            super.onPostExecute(string);
            DataSingleton.getInstance().updateMyText(string); //update data in our singleton
            jobFinished(mParameters, false); //tell the JobScheduler we have completed the job
        }
    };
       mTask.execute();
       return false;
  }
  ```
We need to take care of the `onStopJob()` implementation now.

```java
@Override
   public boolean onStopJob(JobParameters jobParameters) {
       if(mTask != null && mTask.getStatus().equals(AsyncTask.Status.RUNNING)){ //check if task is running
           mTask.cancel(false); //cancel task as soon as possible without actually interrupting it
       }
       return false;
   }
```

***

<a name="guided-practice-testing"></a>
## Guided Practice: Testing that our job runs only under our conditions (15 mins)

If we look at our conditions it should run every 5 seconds.

It looks like the job is being run every 5 seconds. Success!
Let's change some of the criteria so it doesn't run every 5 seconds but runs once under different criteria. Let's change some things in the `JobInfo` object.

```java
//The jobId can be any integer you want it to be
//The class name should be the name
//of the JobService you created
JobInfo job = new JobInfo.Builder(12321,
  new ComponentName(getPackageName(),
  MyJobService.class.getName()))
       .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY) //This ensures our job only runs when the user has a Wi-Fi connection
       .build();
```

***

<a name="ind-practice"></a>
## Independent Practice: Topic (15 mins)

Now that you know how to set up the components of the `JobScheduler` let's get some more practice.

Create another job that runs every 15 seconds when the device is charging and idle.

***

<a name="conclusion"></a>
## Conclusion (5 mins)

The JobScheduler API is a very powerful component of the Android framework. You can schedule tasks to run only when necessary and only when it is in the best interest of the user. Being a good app citizen is crucial to making great applications that people will want to keep on their devices.

- What are the two required methods of the `JobService`
- What happens when we set the last parameter of `jobFinished` to be true? false?
- How do we provide information to our job so we can perform different things?

***

### ADDITIONAL RESOURCES
- [JobInfo reference](https://developer.android.com/reference/android/app/job/package-summary.html)
- [Background Optimization with JobScheduler](https://developer.android.com/preview/features/background-optimization.html)
