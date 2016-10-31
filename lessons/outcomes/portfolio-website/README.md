---
title: Portfolio Website Lesson
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Portfolio Site - GitHub Pages

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain the value of a project portfolio website
- Describe the difference between static and dynamic websites
- Implement a static website via GitHub Pages using a template

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Have a GitHub account
- Fork and clone repositories
- Edit markdown files

---
<a name="opening"></a>
## Opening (5 mins)

Recruiters and employers all want to know one thing for sure - that you've built plenty of apps and have a passion for Android development. The best way to demonstrate this to them is via a portfolio website. You can highlight your major projects - both from class and personal projects - and prove that you have real experience. A portfolio site also demonstrates your professionalism and attention to detail.

<a name="introduction"></a>
## Introduction: Static Websites (5 mins)

For a typical modern website, you need to write html/css/javascript for the front end, and use a separate language and framework to build out a back end that will run on a server, like Ruby and Rails, Python and Django, Javascript and Node, etc. This type of website is called _**dynamic**_, because the back end system generates the html the user sees on demand, dynamically. This is obviously a pretty complicated process - you shouldn't have to take the WDI course just to build yourself a simple website!

Fortunately, there's an alternative. The [Jekyll](http://jekyllrb.com/) framework can take a bunch of simple markdown files (like the readme files for GitHub repos) and transform them automatically into a static website. This type of site is _**static**_ because all the html files the user will see are generated once, whenever you create or update your site, then just sit there ready to be served up to viewers.

A Jekyll-powered site still needs a few more components, but the good news is you don't need to build them yourself!
- You'll need some html templates, but no need to write them yourself - there are plenty of [freely available themes](https://github.com/jekyll/jekyll/wiki/themes) you can use as a starting point
- You'll still need to host your site somewhere so people can visit it via the web - fortunately, [GitHub will do this for you for free!](https://pages.github.com/)

<a name="demo"></a>
## Demo: Sample Portfolio Sites (5 mins)

To make this more concrete and realistic, here are two sample portfolio websites from members of your instructional team:
- [http://www.charlesdrews.com/](http://www.charlesdrews.com/)
- [http://chris-shum.github.io/](http://chris-shum.github.io/)

<a name="guided-practice"></a>
## Guided Practice: Set Up Your Own Site - Right Now! (40 mins)

The quickest and simplest way to get your own portfolio up and running is to follow [this great tutorial](https://www.smashingmagazine.com/2014/08/build-blog-jekyll-github-pages/) from Smashing Magazine. Read the detail there, but here are the basic steps:

1. Go to [this list of website themes](https://github.com/jekyll/jekyll/wiki/themes)
  - For this lesson, select the "Freelancer" theme, and follow the link to it's [source repository](https://github.com/jeromelachaud/freelancer-theme)
  - Later, you can browse all the themes and do this process over with the theme you like best

2. Fork your theme's repository - in this case the [Freelancer theme repo](https://github.com/jeromelachaud/freelancer-theme)

3. Go to the Settings tab of your new fork, and change the repository name to `yourusername.github.io`, replacing `yourusername` with your GitHub username
  - This is how GitHub knows you want this to be your personal website, and not just another repo
  - Your website will be hosted at `http://yourusername.github.io` - that's where you can go to see it! It might not be ready to view yet; it will be after the following steps.

4. Click on the `_config.yml` file in your repo, then click the pencil icon to edit the file right in the browser
  - Update this file with your personal details
  - Once you commit your changes, your website will be built and in a moment should be viewable at the `http://yourusername.github.io`
  - If you don't like editing files in the browser, you can also clone your repo, edit this file in a text editor, then commit and push back up to your repo on GitHub

5. Go to the `_posts` folder in your repo
  - Open and edit one of the markdown files - they each represent a "post" or a project that you want to include on your site
  - Make some changes to one or more post, commit, wait a moment, and view your site to make sure the changes show up

6. Add images for your site - go to the `img` folder
  - Replace `profile.png` with a picture of you - give your new image file the same name though, since that's what the Jekyll framework is looking for - `profile.png`
  - In the `img/portfolio` folder you can add screenshots of your projects, then you can refer to those screenshot images in the markdown files in your `_posts` folder

Optional additional steps:
- Use a custom domain, like `www.yourname.com` - see the [section in the tutorial](https://www.smashingmagazine.com/2014/08/build-blog-jekyll-github-pages/#use-your-own-domain) on this
- Build your website _locally_ so you can preview and test any updates in your browser using your local clone of the repo, before those updates are pushed to GitHub and become visible to anyone visiting your site - see the [section in the tutorial](https://www.smashingmagazine.com/2014/08/build-blog-jekyll-github-pages/#building-your-website-locally) on this

---

<a name="conclusion"></a>
## Conclusion (5 mins)

You've built your first portfolio site! If you want a different theme, you can simply delete the repository, pick out a different theme, fork it, and follow the same process to set it up. Once you get a theme you really like, you can experiment with the html templates and css to really customize it.

Once you are comfortable with the look of your site, you'll be ready to start adding content. Your projects for this course are ideal candidates for work to feature on your site. Use the screenshot tool in Android Studio and write up a description. If you do this each time a project is completed, it will be a lot easier than adding them all at once later!

---

### ADDITIONAL RESOURCES

- [Charlie's repository](https://github.com/charlesdrews/charlesdrews.github.io) and [Chris's repository](https://github.com/chris-shum/chris-shum.github.io) containing all the files for their portfolio sites - you can use these as references
- [Instructions from GitHub on how to build Jekyll sites locally](https://help.github.com/articles/setting-up-your-github-pages-site-locally-with-jekyll/)
- [Jekyll documentation](http://jekyllrb.com/docs/home/) - handy if you want to really customize things
- [Markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) - you probably won't need too much complicated formatting in your markdown files, but just in case
