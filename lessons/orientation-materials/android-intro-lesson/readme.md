---
title: Intro to Android
type: Lesson
duration: "1:05"
creator:
    name: James Davis
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Introduction to Android

### LEARNING OBJECTIVES
*After this lesson, students will be able to:*
* Understand the basic history and concepts of Android
* Open Android Studio and run a pre-supplied app

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Make sure you have Android Studio installed and configured for the demos and guided practice in this lesson.
- Make sure students are signed up on Github and have access to the student-facing repo.
- Locate and look through the[supplied app](starter-code) for the guided practice.

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction-welcome-to-android-15-mins)  | Welcome to Android! |
| 20 min  | [Demo](#demo-developing-for-android-20-mins)  | Developing for Android |
| 20 min  | [Guided Practice](#guided-practice-exploring-android-studio-20-mins)  | Exploring Android Studio |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Opening (5 mins)

#### What is Android?

Android is an mobile operating system maintained by Google. It's an open source project, meaning that [anyone can download the source code of the operating system](https://source.android.com/source/index.html) and modify it for free.

Android is not based on Apple or Microsoft technologies; it's a distribution of Linux.

## Introduction: Welcome to Android! (15 mins)

#### Many Devices

Android is known for having many devices created by manufacturers (as opposed to iOS having a handful of devices and one manufacturer).


**Pros**

* More choices for the consumer
* Can get different devices at different price points
* Much like a laptop, you can buy devices with a wider variety of specifications (better RAM, more storage, etc)
* Brand loyalty. For example, if you are a Samsung fan and can buy everything Samsung, then you're in luck!

**Cons**

* Too much choice for the consumer! There's such a large number of devices which makes it confusing for the consumer to decide which device is best for their needs.
	* [The burden of choice](https://www.psychologytoday.com/blog/more-tech-support/201011/the-burden-choice): Psychologically, too much choice can be paralyzing.
		* When you look at a menu with a lot of choices, the brain keeps bouncing back and forth, indecisively, looking for the best food to eat. This isn't a huge issue for menus with only a few choices.
	* **Pro?**: If you can afford them, there are a handful of _really really_ good, [well advertised Android phones](http://www.androidauthority.com/best-android-phones-568001) to choose from.
		* This limits the consumer's choices from hundreds to less than ten, but only if you have the funds for them.

#### Versions

You may have heard of Android referred to as Lollipop, Marshmallow, or KitKat.

These are the names of all of the versions. Think of how domain names represent IP addresses.  It's easier to remember Facebook.com instead of 69.63.176.13!

Google probably thought it was more difficult to remember "Android 5.0, 5.1, 4.2" or any of the other version numbers. As of today, there have been 10 major releases of Android, with Marshmallow being the most recent.

Yes, all of the versions have the names of candies or sweets! But the thing to take away is that they are named in alphabetical order!

Donut, Eclair, Froyo, Gingerbread, Honeycomb, Ice Cream Sandwich, Jellybean, KitKat, Lollipop, Marshmallow.

[Here's how the versions are broken down, and how many people own each version.](http://developer.android.com/about/dashboards/index.html) As of today, most people own KitKat and Lollipop devices (as Marshmallow is still new).

## Demo: Developing for Android (20 mins)

There are two things required to be a successful Android developer: Android Studio, and at least one device to install your app.

#### Android Studio


An IDE ([Integrated development environment](https://en.wikipedia.org/wiki/Integrated_development_environment)) is an application that provides a way to program applications.

Some popular ones are Visual Studio, Eclipse, and IntelliJ IDEA.

[Android Studio](http://developer.android.com/sdk/index.html) is an IDE that is used to develop Android apps. It's a specialized version of IntelliJ and will be the program used throughout this course.

Note: Eclipse was the IDE previously used for Android app development. However, Android Studio is backed by Google directly and has more support in general; it also comes prepackaged with almost everything you will need for this course.

#### Running your app on a device

As you build and test your app, you have to run it on a device to make sure it behaves as expected. There are two ways to do that:

**1. Use a physical device** -  It's *almost always* best to use an actual phone or tablet to test your app. The users would be using your app on a phone, so testing on one is ideal. Try to have at least one phone nearby to test on.

However, as mentioned in previous sections, there are many devices with varying screen sizes and a handful of versions for each device. Realistically, it's not possible to have access to every combination of device and version.


 Not everyone has the latest phones or versions.  You would be excluding a subset of people with older devices and versions who might be experiencing problems with you app that newer phones aren't experiencing.

 This is especially true for customers in developing countries, where the latest phones either are not available or not as popular as their cheaper counterparts.

 One way of attempting to test multiple devices that you have no physical access to is to use virtual devices. Read on to see how you can do this!

**2. Using a virtual device** - You can emulate many Android devices on your computer!

Android provided a Virtual Device Manager that allows you to configure a virtual Android device. You can make one from scratch by defining things like ram, screen size, etc., or you can use predefined virtual devices based on actual devices. For instance, you can have a virtual version of the Nexus 5 or the Samsung Galaxy devices.

You can also run an application called [Genymotion](https://www.genymotion.com/), which is another, faster version of the official Android Virtual Device Manager. It's not supported by Google, but it is a great resource.

One drawback is that because these are virtual, there are some things you can't test easily, like using Google Maps, GPS, or other Google Play-related services. However, if you don't have access to a physical device, a virtual one is your best option.

## Guided Practice: Exploring Android Studio (20 mins)

Now that we know all of the tools, let's open and run an app in Android Studio.

* Together, let's open the [supplied app](starter-code) in Android Studio.
* Let's discuss the major parts of the IDE:
	* Project View and Structure
	* Java Code Editor
	* View > Tool Windows - General overview
* Finally, let's run the app and build it to a device


## Conclusion (5 mins)

- What is Android Studio?
- What are the versions of Android named after?
