
---

| Title | Duration | Name | City |
| --- | --- | --- | --- |
| Designing for multiple devices | 3:00 | Yuliya Kaleda | NYC |

<!--  OUTSTANDING:
1. Checks
-->


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Designing for multiple devices

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Discuss SDK version support
- Create an application that can be launched in different languages
- Describe how to support portrait and landscape configurations
- Create an application that can support devices of different screen sizes and screen density


### STUDENT PRE-WORK
*Before this lesson, you should already:*
- Get familiar with a general project structure in Android Studio
- Get flexible with creating different layouts (Relative, Linear, Frame, Grid, Coordinate)

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Open and test the provided MultipleDevices app


### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 25 min  | [Introduction](#introduction-what-is-an-api-level-supporting-different-api-levels-25-mins)  | What is an API Level? Supporting Different API Levels |
| 10 min  | [Guided Practice](#guided-practice-check-system-version-at-runtime-10-mins)  | Check System Version at Runtime |
| 10 min  | [Introduction](#introduction-supporting-different-languages-10-mins)  | Supporting Different Languages |
| 20 min  | [Independent Practice](#independent-practice-creating-functional-apps-20-mins)  | Creating functional apps |
| 15 min  | [Introduction](#introduction-supporting-different-screens-15-mins)  | Supporting Different Screens |
| 20 min  | [Independent Practice](#independent-practice-support-different-screens-20-mins)  | Support different screens |
| 10 min  | [Introduction](#introduction-supporting-different-bitmaps-10-mins)  | Supporting different bitmaps |
| 15 min  | [Independent Practice](#independent-practice-supporting-different-bitmaps-15-mins)  | Supporting different bitmaps |
| 10 min  | [Introduction](#introduction-support-library-10-mins)  | Support Library |
| 5 min  | [Independent Practice](#independent-practice-supporting-multiple-apis-5-mins)  | Supporting multiple APIs |
| 10 min  | [Conclusion (10 mins)](#conclusion-10-mins)  |  |
---  
## Opening (5 mins)
Android devices come in many shapes and sizes all around the world. With a wide range of device types, you have an opportunity to reach
a huge audience with your app. In order to be as successful as possible on Android, your app needs to adapt to various device
configurations. Some of the important variations that you should consider include different languages, screen sizes, and versions of the
Android platform.

Let's go over some vocabulary important to this lesson:

*Drawable* - a general abstraction for "something that can be drawn." Most often you will deal with Drawable as the type of resource retrieved for drawing things to the screen. Unlike a View, a Drawable does not have any facility to receive events or otherwise interact with the user.

## Introduction: What is an API Level? Supporting Different API Levels (25 mins)

API Level is an integer value that uniquely identifies the framework API revision offered by a version of the Android platform. The API Level identifier serves a key role in ensuring the best possible experience for users and application developers:

* It lets the Android platform describe the maximum framework API revision that it supports
* It lets applications describe the framework API revision that they require
* It lets the system negotiate the installation of applications on the user's device, such that version-incompatible applications are not installed

While the latest versions of Android often provide great APIs for your app, you should continue to support older versions of Android until more devices get updated. Generally, it’s a good practice to support about **90% of the active devices**, while targeting your app to the latest version.  

##### Platform Versions
The chart below provides data about the relative number of devices running a given version of the Android platform.
![](https://cloud.githubusercontent.com/assets/10750398/11850985/6bfda560-a441-11e5-87f8-6ff9c6eccab4.jpg)

##### Specify Minimum, Maximum and Target API Levels

When talking about API Level, there are four main attributes to take into consideration:

1.  **android:minSdkVersion**

  An integer designating the minimum API Level required for the application to run. The Android system will prevent the user from installing the application if the system's API Level is lower than the value specified in this attribute. You should always declare this attribute.

  *Caution*: If you do not declare this attribute, the system assumes a default value of "1", which indicates that your application is compatible with all versions of Android. If your application is not compatible with all versions (for instance, it uses APIs introduced in API Level 3) and you have not declared the proper minSdkVersion, then when installed on a system with an API Level less than 3, the application will crash during runtime when attempting to access the unavailable APIs. For this reason, be certain to declare the appropriate API Level in the minSdkVersion attribute.

  2. **android:compileSdkVersion**

    compile SDK is simply telling the compiler what version of Android your app should build against. To access API features from newer versions of Android, your compile version must be at least the same number or higher.

3. **android:targetSdkVersion**

  An integer designating the API Level that the application targets. If not set, the default value equals that given to minSdkVersion.
  This attribute informs the system that you have tested against the target version and the system should not enable any compatibility behaviors to maintain your app's forward-compatibility with the target version. The application is still able to run on older versions (down to minSdkVersion). To maintain your application along with each Android release, you should increase the value of this attribute to match the latest API level, then thoroughly test your application on the corresponding platform version.

  One example of where this can affect behavior of your app is if you set the target sdk below marshmallow, the runtime permissions won't trigger.

4.  **android:maxSdkVersion**

  An integer designating the maximum API Level on which the application is designed to run.
  In Android 1.5, 1.6, 2.0, and 2.0.1, the system checks the value of this attribute when installing an application and when re-validating the application after a system update. In either case, if the application's maxSdkVersion attribute is lower than the API Level used by the system itself, then the system will not allow the application to be installed. In the case of re-validation after system update, this effectively removes your application from the device.

  Declaring this attribute is not recommended. There is no need to set the attribute as means of blocking deployment of your application onto new versions of the Android platform as they are released.

  Future versions of Android (beyond Android 2.0.1) will no longer check or enforce the maxSdkVersion attribute during installation or re-validation.


###### Example:

![](https://cloud.githubusercontent.com/assets/10750398/11851073/c9525e68-a441-11e5-896a-49b3021faa2c.png)  


##### Application forward compatibility
Android applications are generally forward-compatible with new versions of the Android platform. Each successive version of the Android platform can include updates to the Android application framework API that it delivers.
Updates to the framework API are designed so that the new API remains compatible with earlier versions of the API. That is, most changes in the API are additive and introduce new or replacement functionality. As parts of the API are upgraded, the older replaced parts are deprecated but are not removed, so that existing applications can still use them.

As new versions of Android are released, some style and behaviors may change. To allow your app to take advantage of these changes and ensure that your app fits the style of each user's device, you should set the targetSdkVersion value to match the latest Android version available.

##### Application backward compatibility
Android applications are not necessarily backward compatible with versions of the Android platform older than the version against which they were compiled. Each new version of the Android platform can include new framework APIs, such as those that give applications access to new platform capabilities or replace existing API parts. The new APIs are accessible to applications when running on the new platform and also when running on later versions of the platform, as specified by API Level. Conversely, because earlier versions of the platform do not include the new APIs, applications that use the new APIs are unable to run on those platforms.

Although it's unlikely that an Android-powered device would be downgraded to a previous version of the platform, it's important to realize that there are likely to be many devices in the field that run earlier versions of the platform. Even among devices that receive OTA updates, some might lag and might not receive an update for a significant amount of time.


## Demo: Check System Version at Runtime (10 mins)

**Start a new project**

Android provides a unique code for each platform version in the Build constants class. Below is an example of the code to build conditions that ensure the code that depends on higher API levels is executed only when those APIs are available on the system.

```java
private void setUpActionBar() {
    // Make sure we're running on Honeycomb or higher to use ActionBar APIs
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
```

## Introduction: Supporting Different Languages (10 mins)

It’s always a good practice to extract UI strings from your app code and keep them in an external file. Android makes this easy with a resources directory in each Android project. To add support for more languages, create additional values directories inside res/ that include a hyphen and the ISO language code at the end of the directory name. For example, values-es/ is the directory containing simple resources for the Locales with the language code "es".

Android loads the appropriate resources according to the locale settings of the
device at run time. The folder structure will look like this:

![](https://cloud.githubusercontent.com/assets/10750398/11850638/b00e7ef2-a43f-11e5-97d8-2edc99aca02e.png)

Add the string values for each locale into the appropriate file. At runtime, the Android system uses the appropriate set of string resources based on the locale currently set for the user's device. For example, the following are some different string resource files for different languages.

## Demo: Supporting Different Languages

**Have the students open a new project to follow along.**

English (default locale), /values/strings.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="portrait">Portrait Mode</string>
</resources>
```

Spanish, /values-es/strings.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="portrait">Modo Retrato</string>
</resources>
```

It is a good practice to reference your string resources in your source code and other XML files using the resource name defined by the ```<string>``` element's name attribute.

###### Example:

* Reference in code:

```java
    TextView textView = (TextView) findViewById(R.id.view);
    textView.setText(R.string.portrait);
```
* Reference in xml file:

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/portrait" />
```
## Independent Practice: Creating functional apps (10 mins)  
In the app created earlier add a button in `activity_main.xml`. The button should have a text "Submit". The app should be functional in Spanish ("Enviar") and Russian languages("Oтправить"), which can be done by creating separate folders values-es/ and values-ru/ with a strings file in each of them. Run the app and check if the button has the text "Submit". Go to the settings in your phone and change the language to Spanish, run the app and check if the text of the button gets changed to "Enviar". Then change the language to Russian and test if the text on the button gets changed to "Oтправить".


## Introduction: Supporting Different Screens (15 mins)

Android categorizes device screens using two general properties:
* size: small, normal, large, xlarge
* density: low (ldpi), medium (mdpi), high (hdpi), extra high (xhdpi), extra-extra high (xxhdpi), extra-extra-extra-high(xxxhdpi)
* exact: Specify an exact dp for width or height, and it is used for any screens at or above that size

To declare different layouts and bitmaps you'd like to use for different screens, you must place these alternative resources in separate directories, similar to how you do for different language strings.

Also be aware that the screens orientation (landscape or portrait) is considered a variation of screen size, so many apps should revise the layout to optimize the user experience in each orientation. By default, the layout xml files are used for portrait orientation. To reference a landscape orientation, the folder should add the suffix -land:

![](https://cloud.githubusercontent.com/assets/10750398/11794335/cd4f40f4-a27e-11e5-8fa4-2ea7a2f81316.png)

##### Create Different Layouts
To optimize user experience on different screen sizes, you should create a unique layout XML file for each screen size you want to support. Each layout should be saved into the appropriate resources directory, named with a ```-<screen_size>``` suffix. For example:

![](https://cloud.githubusercontent.com/assets/10750398/11787480/e1db3fac-a259-11e5-9874-de95420af6a3.png)

 This project includes a default layout and an alternative layout for large screens. The file names must be exactly the same, but their contents are different in order to provide an optimized UI for the corresponding screen size.


## Independent Practice: Support different screens (20 mins)   
In the app created earlier add a textView. In the portrait mode the textView should be above the button. In the landscape mode the TextView should be to the left of the button in a LinearLayout, and display the text "Landscape Mode". Make sure to add strings in values-ru and values-es so that your app should support Spanish and Russian as well.


## Introduction: Supporting different bitmaps (10 mins)

All bitmap resources should be properly scaled to each of the generalized density buckets: low, medium, high, extra-high density, extra-extra high (xxhdpi), extra-extra-extra-high(xxxhdpi). To generate images, you should start with your raw resource in vector format and generate the images for each density using the following size scale:

- ldpi (low) ~120dpi
- mdpi (medium) ~160dpi
- hdpi (high) ~240dpi
- xhdpi (extra-high) ~320dpi
- xxhdpi (extra-extra-high) ~480dpi
- xxxhdpi (extra-extra-extra-high) ~640dpi

After the images are ready, they are placed in the appropriate drawable resource directory. For example:

![](https://cloud.githubusercontent.com/assets/10750398/11794684/98b1926e-a280-11e5-8dbf-6750034c1b0a.png)

Any time you reference ```@drawable/android.png```, the system selects the appropriate bitmap based on the screen's density.  

## Guided Practice: Supporting different images (10 mins)
In the app created earlier add a new image for a launcher icon to the folder res/mipmap. The image should be scaled to the right dimensions and supported on all devices. Use ImageAsset functionality in Android Studio to generate images of different density for things like icons, which places them in your mipmap folder. You can choose any image you want to place as a launcher or use this one:
![](https://cloud.githubusercontent.com/assets/10750398/11934014/7749621a-a810-11e5-9942-9233aaa08bfc.jpg)

You can also generate drawables of different sizes with various tools. There is a useful plugin called Android Drawable Importer. Use the batch importer to select multiple images, and it will scale them appropriately into your drawable folder.

## Conclusion (10 mins):

1. What is the name of the resource folder and resource file where text in the code should be referenced from?
2. How can you make an app look different in landscape mode?
3. What is the name of the folder where we store images? How many of these folders should an application have?
4. In reference to the API Level which four attributes should be set in the manifest?
