# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Course Schedule

- [Week 1](schedule/week1.md) (10/3/ - 10/7)
- [Week 2](schedule/week2.md) (10/11 - 10/14)
- [Week 3](schedule/week3.md) (10/17 - 10/21)
- [Week 4](schedule/week4.md) (10/24 - 10/28)
- [Week 5](schedule/week5.md) (10/31 - 11/4)
- [Week 6](schedule/week6.md) (11/7 - 11/10)
- [Week 7](schedule/week7.md) (11/14-11/18)
- [Week 8](schedule/week8.md) (11/21 - 11/23)
- [Week 9](schedule/week9.md) (11/28 - 12/2)
- [Week 10](schedule/week10.md) (12/5 - 12/9)
- [Week 11](schedule/week11.md) (12/12 - 12/16)
- [Week 12](schedule/week12.md) (12/19 - 12/22)
- [Week 13](schedule/week13.md) (1/3 - 1/6)
- [Week 14](schedule/week14.md) (1/9)


---

#### How to download soution code posted to an assignment repo after you made your fork:

1. Navigate to your local repo from the command line
1. Run `git remote -v` and note there is only one remote listed, your fork with the name `origin`
1. Run `git remote add upstream <url of original repo, not your fork>` to add an additional remote named `upstream` which points to the original repo
1. Run `git remote -v` again to confirm that you now have two remotes, with `upstream` linked to the original repo
1. Run `git pull upstream master` to pull in changes from the `upstream` remote's `master` branch
1. You shouldn't encounter merge conflicts, but if you do, [resolve them](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line/) and do a commit after the resolution
1. Run `git push origin master` to push the changes you got from	`upstream` out to your fork on Github
