## Things to improve in the app:

1. Floating action button is present in the app, but does not have any functionality added to it. It is redundant in the app. Moreover, its color is too vibrant for this dark-theme app. It can be just removed.

2. When the phone gets rotated, the animal images get stretched and do not get proportionally scaled. The solution to this problem will be either to lock the phone in the portrait mode or to create a separate layout for the landscape mode, in which the images will get adjusted to the dimensions of the app.  

3. To improve user experience it is a good practice to keep widgets that have the same functionality in the same place across different activities. Thus, users know what to expect and how to navigate in the app. In our example, the button “Next” is located in different places in different activities. It should be moved to the same place in every activity because it carries the same functionality: “go to the next page”.  

4. All the clickable elements should be big enough not to cause any trouble for users to click them. Test the app on different devices and you will see that the size of the button will look different because it is a hard-coded value (“20p”, “40p” in the MainActivity, “wrap_content” in the other activity). Make sure you provide relative sizes for such widgets and they will be big enough to click.  

5. In our example the button “Next” in the MainActivity covers the head of the bird, while the corners in the app are empty. Move the button to the bottom of the app. It is considered a good practice not to overlay important parts and elements of the app with other elements.   

6. Make sure you will create a string resource for the button “Next” and the TextView with the name of the animals rather than use a hardcoded value.  

7. The main functionality of the app is to demo images of animals. The text of the names is located in the very center of the activity, thus preventing users from enjoying the image. There are 3 other corners where the text can be placed. Move the text to the top right corner of the app, where it will not distract the users.  

8. The primary color of the app is black and grey. To make the text stand out and not get lost on the image, make it of white color.  

9. The names of the animals should be of decent size so that users should not flex their eye muscles to read them.  

10. In the last activity there is no exit point from the app to the beginning except the system back button. It is like a dead end where the users will not get a way out. In our example the app has just 3 images. Imagine if it had 100 images, the user will have to click the back button 100 times to get back to the first image. It will be very annoying. It is considered to be a great practice to think about how many clicks the user will have to perform to achieve something. It makes a lot of sense to add a button in our last activity that will bring the users to the fist image.  
