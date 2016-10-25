# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Lessons and Assignments by Week

- [Week 1 (10/3 - 10/7)](schedule/wk1.md)
- [Week 2 (10/10 - 10/14)](schedule/wk2.md)
- [Week 3 (10/17 - 10/21)](schedule/wk3.md)
- [Week 4 (10/24 - 10/28)](schedule/wk4.md)
- [Week 5 (10/31 - 11/4)](schedule/wk5.md)


---

#### How to download soution code posted to an assignment repo after you made your fork:

1. Navigate to your local repo from the command line
1. Run `git remote -v` and note there is only one remote listed, your fork with the name `origin`
1. Run `git remote add upstream <url of original repo, not your fork>` to add an additional remote named `upstream` which points to the original repo
1. Run `git remote -v` again to confirm that you now have two remotes, with `upstream` linked to the original repo
1. Run `git pull upstream master` to pull in changes from the `upstream` remote's `master` branch
1. You shouldn't encounter merge conflicts, but if you do, [resolve them](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line/) and do a commit after the resolution
1. Run `git push origin master` to push the changes you got from	`upstream` out to your fork on Github
