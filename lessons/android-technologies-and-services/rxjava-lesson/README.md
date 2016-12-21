---
title: RxJava in Android
type: lesson
duration: "1:30"
creator:
    name: Jean Weatherwax
    city: San Francisco
---

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) RxJava in Android

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Understand basic RxJava syntax
- Use RxJava for Android networking

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Make network calls in Android
- Know Retrofix uses/syntax

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Review lesson and reference materials

---

## Opening (5 mins)

[RxJava](https://github.com/ReactiveX/RxJava) is an open-source implementation of ReactiveX. In human terms, it's a library for asynchronous and event-based programs. It uses what is called an *Observable Sequence*, and is hosted by Netflix.

RxJava has only been around for a couple of years (since 2014), but many app developers are already using it, especially for networking in Android. Although you can definitely do networking efficiently without RxJava (we've already learned about Retrofit and OkHttp), it's good to be aware of RxJava as a possibile option and optimization.

## Introduction : Basic Patterns (10 mins)

Before we get started, let's add the dependencies to our project.

```
compile 'io.reactivex:rxandroid:1.2.1'
compile 'io.reactivex:rxjava:1.1.6'
```

RxJava has two main classes: *Observable* and *Subscriber*.

* an Observable emits a stream of data or events.
* a Subscriber reacts to / acts upon the emitted items.

An Observable may have more than 1 Subscriber. For each item emitted by an Observable,  the item wil be sent to the Subscriber.onNext() method to be handled.

Once an Observable has finished emitting items, it will call the Subscriber.onCompleted() method. If there is an error the Observable will call the Subscriber.onError() method.

So what does this look like in code? In general, the pattern is something like this for creating the Observable:

```java
Observable<String> myObservable = Observable.create(
    new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> sub) {
            sub.onNext("I'm a String!");
            sub.onCompleted();
        }
    }
);
```

This is good if we have multiple things to send to the subscriber (by calling onNext multiple times), but if we only have one item to emit, there is an alternative way to create an Observable.

```java
Observable.fromCallable(new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "I'm a String!";
    }
});
```

And the pattern for the Subscriber will be something like:

```java
Subscriber<String> mySubscriber = new Subscriber<String>() {
    @Override
    public void onNext(String s) { System.out.println(s); }

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) { }
};
```

Here, the type is String, but this may be Integer, or any other Object.

The final piece here is to then call `subscribe`:

```java
myObservable.subscribe(mySubscriber);
```


This code is great, but it can be simplified by using the `just` method. The `just` method will create an Observable that emits only the values defined. The Subscriber will be an anonymous inner class. This will look something like so:

```java
Observable.just("I'm a String!")
    .subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
              System.out.println(s);
        }
    });
```

## Guided Practice: another example (5 mins)

Let's look at one more example to solidify our understanding. This example uses integers instead of Strings.

```java

//Observable
Observable myIntegerObservable = Observable.create(new Observable.OnSubscribe() {
   @Override
   public void call(Subscriber subscriber) {
       subscriber.onNext(11);
       subscriber.onNext(24);
       subscriber.onNext(18);
       subscriber.onCompleted();
   }
});

//Subscriber
Subscriber myIntegerSubscriber = new Subscriber() {
   @Override
   public void onCompleted() {
       System.out.println("Complete!");
   }

   @Override
   public void onError(Throwable e) {

   }

   @Override
   public void onNext(Integer value) {
       System.out.println("onNext: " + value);
   }
};

myIntegerObservable.subscribe(integerSubscriber);
```

This can be simplified to:

```java
Observable.just(11, 24 , 18).subscribe(new Subscriber() {
   @Override
   public void onCompleted() {
       System.out.println("Complete!");
   }

   @Override
   public void onError(Throwable e) {}

   @Override
   public void onNext(Integer value) {
       System.out.println("onNext: " + value);
   }
});
```


## Using Operators (20 mins)

Operators are used between Observers and Subscribers to manipulate the emitted objects. A popular operator is `map`, which is used for basic transformations for each emitted item.

![map](http://image.slidesharecdn.com/rxjavavivintpresentation-151021205419-lva1-app6891/95/rxjava-on-android-8-638.jpg?cb=1445461173)

Here's an example:

```java
Observable.just("Hello, ","Goodbye, ")
    .map(new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s + " Jean";
        }
    })
    .subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
              System.out.println(s);
        }
    });
```

This will print `"Hello, Jean"` and `"Goodbye, Jean"`.


Another popular operator is `filter`. This lets us pass only items from the Observable that pass a certain condition.

![filter](http://image.slidesharecdn.com/reactiveprogramming-usingrxjavaakkaactors-pdxscala-june2014-140516152655-phpapp01/95/reactive-programming-using-rx-java-akka-actors-pdxscala-june-2014-23-638.jpg?cb=1400254058)

For example:


```java
Observable.just(1, 2, 3, 4, 5)
          .filter(new Func1<Integer, Boolean>() {
              @Override
              public Boolean call(Integer item) {
                return( item < 4 );
              }
          }).subscribe(new Subscriber<Integer>() {
        @Override
        public void onNext(Integer item) {
            System.out.println("Next: " + item);
        }

        @Override
        public void onError(Throwable error) {
            System.err.println("Error: " + error.getMessage());
        }

        @Override
        public void onCompleted() {
            System.out.println("Sequence complete.");
        }
    });
```

This will print only 1, 2, and 3.


## Retrolamda (5 mins)

All of the code so far looks clear, but there's something we can do to make it even more concise. You may have noticed that in Android studio, some of your code is automatically shortened with lamdas (`->`). This is frequently done in practice with RxJava.

Add the following to the **TOP** of your gradle file.

```
plugins {
  id "me.tatarka.retrolambda" version "3.4.0"
}
```

For example, from our previous example:

```java
Observable.just("Hello!")
    .subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
              System.out.println(s);
        }
    });
```

Becomes:

```java
Observable.just("Hello!")
    .subscribe(s -> System.out.println(s));
```

This can be done for any functional interface, for example abstract methods.

There is a plethora of other operators you can use - let's take a few minutes to look through the list:

[Operators List](http://reactivex.io/documentation/operators.html#alphabetical)

## Networking with RxJava (20 mins)

All of this is great, but how is RxJava practically used in Android?

One of the best use cases is with networking. You can easily use Retrofit with RxJava to make streamlined networking code. Let's take a look. We'll use the GitHub API for an example. Let's assume we already have a custom model built.

First, make sure you've added the retrofit dependency:

```
compile 'com.squareup.retrofit2:retrofit:2.1.0'
compile 'com.squareup.retrofit2:converter-gson:2.1.0'
compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
```

The interface to our service will remain the same:

```java
public interface StarWarsService {
    @GET("people/{characterID}/")
    Observable<SWCharacter> getCharacterInfo(@Path("characterID")int id);
}
```

Now, let's use our RxJava knowledge!
THe StarWarsService Observable streams data when it becomes available. We need to have an Subscriber to watch for the data stream changes. For the purposed of this code, we can assume we've already made an adapter:

```java
Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://swapi.co/api/")
        .build();

StarWarsService starWarsService = retrofit.create(StarWarsService.class);

for(int i=1; i<10; i++) {
    starWarsService.getCharacterInfo(i)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(character -> mAdapter.addData(character));
}
```

Let's break this down.

What does this line of code do?

```java
starWarsService.getCharacterInfo(i)
```

Now, we use the method calls to get the REST response:

```java
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
```

This code:

1) Makes sure that the REST call will be made in a new thread.

2) When we get response returns, it calls the onNext method (or in the case of Action1, the call method)


The Subscriber responds to the Observable and call() is called when the REST call gets data.

## Conclusion (5 mins)

RxJava is relatively new, but it has numerous uses especially for streamlining networking in Android. You may or may not choose to use it, and that design choice may be a collective decision by your team if you're working with others or at a company. Regardless, it's good to be aware of RxJava basics and use cases. RxJava is great for threading/networking applications, and it can make your code much cleaner and more concise.


## Reference:

[RxJava](https://github.com/ReactiveX/RxJava)

[Dan Lew Codes](http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/)

[Operators List](http://reactivex.io/documentation/operators.html#alphabetical)

[Lamda support for Android](http://zserge.com/blog/android-lambda.html)

[GitHub Example](https://github.com/ruler88/GithubDemo)
