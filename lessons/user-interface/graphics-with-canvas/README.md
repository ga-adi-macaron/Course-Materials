---
title: Graphics with Canvas
duration: "1:30"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) 2D Graphics in Android with Canvas

This is a very informal mini-lesson about drawing 2D graphics in Android. To create animated graphics, you have a couple basic options:

- Use [simple animations](../simple-animation) to apply pre-defined animations to individual views

- Use a [`Canvas`](https://developer.android.com/reference/android/graphics/Canvas.html) object which provides a variety of drawing methods (`drawLine()`, `drawCircle()`, `drawRect()`, etc.) to build up a scene from scratch


For something like a game, which will re-draw itself repeatedly and rapidly, `Canvas` is a more flexible option\*. There's another choice to make though, between two ways of working with `Canvas`:

- Extend the `View` class and override the `onDraw()` method which receives a `Canvas` as a parameter. To trigger `onDraw()`, you have to call the view's `invalidate()` method every time you want to update the screen. This only guarantees `onDraw()` will be called sometime in the future, and not necessarily immediately.

- Extend the [`SurfaceView`](https://developer.android.com/reference/android/view/SurfaceView.html) class, and use the `SurfaceHolder` it contains in order to access the `Canvas`. Special bonus: you can draw to the `Canvas` from a background thread! This is (as far as I know) the only situation where Android lets you update the UI from a secondary thread.

The example we'll look at is a Pong clone that re-draws itself over and over as fast as it can. `SurfaceView` is the best option for this type of app, since it can re-draw itself as soon as it's done calculating the movements of each object since the previous frame. You don't have to wait for Android to re-draw the view for you like you would after calling `invalidate()` on a regular view.

#### How to Draw Graphics with SurfaceView and Canvas

The basic process for drawing to a `Canvas` using `SurfaceView` is as follows:

1. Have your class that extends `SurfaceView` also implement the [`SurfaceHolder.Callback`](https://developer.android.com/reference/android/view/SurfaceHolder.Callback.html) interface. You'll know the surface is ready for drawing when `surfaceCreated()` and `surfaceChanged()` are called.

2. Once the callback indicates that the surface is ready, call `SurfaceView`'s `getHolder()` method to get its `SurfaceHolder`. You can do this, and everything that follows, on a new thread if you'd like to improve performance by not relying on the UI thread.

3. Call the `SurfaceHolder`'s `lockCanvas()` method to retrieve the `Canvas`.

4. Use the `Canvas`'s various `draw...()` methods to render your frame. The `Canvas` retains its state from the previous frame, so unless you want to see all your frames layered on top of each other, start out by drawing over the whole `Canvas` with `drawColor()` or `drawBitmap()`.

5. After drawing all the elements you want, call `unlockCanvasAndPost()` on the `SurfaceHolder`. This causes the `Canvas` to draw itself onto an underlying `Bitmap` which is then displayed on the screen.

6. Rinse and repeat. Over and over. If you're making a game, you might want to build a simple **_game engine_** with a **_game loop_** that repeats steps 3-5 for every frame of animation. Ideally, your app will draw at least [60 frames per second](https://www.youtube.com/watch?v=CaMTIgxCSqU).


_\* There are, of course, numerous popular game engine frameworks available to make fully-features 2D and 3D games for Android, like [Unity](http://unity3d.com/) or [libGDX](https://github.com/libgdx/libgdx/). These are what big, fancy games are made with, and they're like learning a whole new language that doesn't really have anything to do with Android. This lesson is about using tools from the Android SDK to handle graphics yourself._

---

### ADDITIONAL RESOURCES

- [Google's Guide to Canvas and Drawables](https://developer.android.com/guide/topics/graphics/2d-graphics.html)
- [Charlie's Simple Pong Clone](https://github.com/charlesdrews/pongish)
