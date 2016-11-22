---
title: Git Team Workflow Part 2
type: lesson
duration: "1:20"
creator:
    name: Matt Brenzel / Brooks Swinnerton / Jay Nappy
    city: BOS / NYC
competencies: Workflow
---

#Git Team Workflow Part 2

### Objectives
*After this lesson, students will be able to:*
- Use branches to isolate changes tied to specific features
- Efficiently and correctly resolve merge conflicts
- Fetch changes from a remote without merging them into your own
- Explain how rebase combines two branches

### Prerequisites
*Before this lesson, students should already be able to:*
- Use Git/GitHub to fork, clone, push and pull
- Read through the following:
  1. https://www.atlassian.com/git/tutorials/using-branches
  2. https://www.atlassian.com/git/tutorials/comparing-workflows
  3. https://www.atlassian.com/git/tutorials/merging-vs-rebasing ('Conceptual Overview section)
  4. http://nvie.com/posts/a-successful-git-branching-model/

> ***Note:*** _This can be a pair programming activity or done independently._  Also, this lab builds on the [git-team-workflow-lesson](../git-team-workflow-1-lesson) and picks up where that lesson left off.


### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 10 min  | [Resolving Merge Conflicts - Intro](#resolving-merge-conflicts-intro-10-mins)  |   |
| 15 min  | [Set up your app for Merge Conflicts - Independent Practice](#set-up-your-app-for-merge-conflicts-independent-practice-15-mins)  |   |
| 15 min  | [Resolve your Merge Conflict - Independent Practice](#resolve-your-merge-conflict-independent-practice-15-mins)  |   |
| 15 min  | [Rebasing - Intro](#rebasing-intro-15-mins)  |   |
| 20 min  | [Team Workflows - Discussion](#team-workflows-discussion-20-mins)  |   |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Resolving Merge Conflicts - Intro (10 mins)

And we're back!  Previously we were learning about how merge conflicts worked, and now it's time to try it for ourselves.

## Set up your app for Merge Conflicts - Independent Practice (15 mins)

Ok, we're almost ready for our Actors app to be done. Now we just have to finish the Main Activity.  Be aware that we're setting you up to hit merge conflicts in this part of the lesson so don't be scared when you see these merge issues later!  And by the way, never, ever, work on the same files in different branches!  Follow this rule, and you're less likely to hit merge conflicts!

But to get you some practice, now, both partners are going to create new branches to build the Activity for this app using Git workflow:

__Student 1__ should create a new branch called `student1-main-activity` and __student 2__ should create a new branch called `student2-main-activity`.  Use the specs below to individually build the activity:

- __student 1__ Complete the app with three of your favorite actors, naming the ArrayList `actors`.
- __student 2__ Complete the app with three of your favorite actors and name the ArrayList `actorsList`.

 >Note: the point here is to get two different versions of the file so students will hit merge conflicts later on.

When you're finished, push your code up to GitHub with `git push origin <branch name>`. Again, notice a new remote branch has been created.

You and your partner are ready for the next lesson when your repo has pull requests from both of you:

<p align="center">
<img src='http://s16.postimg.org/fu91r8z05/Screen_Shot_2015_07_29_at_4_49_01_PM.png'>
</p>

Submit a pull request for student 1 and merge student 1's pull request. Then, try to create a pull request for student 2's work:

<p align='center'>
<img src='http://s2.postimg.org/p7md53bqx/Screen_Shot_2015_07_29_at_7_34_00_PM.png'>
</p>

Oh no! We're unable to merge this in because student 1 and student 2 worked on the same files and now we have different versions of the files we're trying to combine.  Let's create pull request anyway and sort this out.


## Resolve your Merge Conflict - Independent Practice (15 mins)

Now, since we hit a merge conflict, with your partner use the message to resolve the conflicts. Git will mark the conflicts in the working tree for us - our terminal showed us problems in the java file - so open the file being identified with your text editor, edit the files by choosing which version you want to keep - delete all the "extra stuff" (`<<<<<<<`, `=======`, HEAD, master) just like we practiced earlier - and then...

```bash
git add .
git commit -m 'your message'
git checkout master
git merge --no-ff student2-main-activity
git push origin master
```

...now, try running your app and it should work.

## Rebasing - Intro (15 mins)

While merging represents one path for combining different branches, there is another common path called `rebase`. Rebasing works differently than merging. Rather than combining the finished data from two different branches via a single commit, it combines the two branches _themselves_, rearranging them and, effectively, re-writing history.

Here's what a rebase looks like. Suppose we have two branches, like this.


One day, someone makes a commit onto the `master` branch. We want to include those changes into our feature branch so that our code doesn't conflict with theirs.


From our feature branch, if we run the command `git rebase master`, we can tell git to rewrite the history of our feature branch as if the new commit on `master` had __always been there__.

```
before rebase

      A---B---C topic
     /   
D---E---F---G master
```

```
after rebase

              A'--B'--C' topic
             /
D---E---F---G master

```

Rebase is extremely useful for cleaning up your commit history, but it also carries risk; when you rebase, you are in fact discarding your old commits and replacing them with new (though admittedly, similar) commits, and this can seriously screw up a collaborator if you're working in a shared repo.The golden rule for `git rebase` is "Only rebase **before** sharing your code, **never** after."

Like `git merge`, `git rebase` also sometimes runs into merge conflicts that need to be resolved. The procedure for doing this is almost the same; once you fix the conflicts, run `git rebase --continue` to complete the rebase.

> Check: What is the difference between rebasing and merging?

## Team Workflows - Discussion (20 mins)

So far, we've only talked about Rebase in the context of working alone. Here are a few examples of workflows - using both rebase and merge - that might get used in the field.

#### Single-Remote Workflows
One thing all of these approaches have in common is the necessity of staying on top of changes to a single shared repository. This is usually accomplished by running `git fetch`, which pulls updates from origin, and merging those updates; alternatively, you could use `git pull` to do both at once.

#### Centralized Workflow
**How It Works**: The remote repo has one single branch on it, `master`. All collaborators have separate clones of this repo. They can each work independently on separate things. However, before they push, they need to run `git fetch`/`git pull` (with the `--rebase` flag) to make sure that their master branch isn't out of date.

> Note: Discuss the pros and cons.

(+) Very simple

(-) Collaboration is kind of clunky.

#### Feature Branch Workflow

**How It Works**: This workflow is very similar to the 'Centralized' workflow. The biggest difference is that there are branches (which helps to keep feature-related commits isolated), and that instead of pushing changes up directly, collaborators (a) push up changes to a new remote branch rather than master, and (b) submit a pull request to ask for them to be added to the remote repo's `master` branch.

> Note: Discuss the pros and cons.

(+) Better isolation than Centralized model, but sharing is still easy. Very flexible.

(-) Sometimes it's too flexible - it doesn't distinguish in any meaningful way between different branches, and that lack of structure can be problematic for larger projects.

#### 'Gitflow' Workflow

<img src="assets/gitflow.png">

**How It Works**: Similar to the Feature Branch workflows, but with more rigidly-defined branches. For example:
- Historical Branches : `master` stores official releases, while `develop` serves as a living 'integration branch' that ties together all the standalone features.
- Release Branches : 'release' branches might exist for any given release, to keep all of those materials together.
- Feature Branches : pretty much the same as in the prior model.
- Maintenance/'Hotfix' Branches : branches used to quickly patch issues with production code.

> Note: Discuss the pros and cons.

(+) Highly structured - works well for large projects.

(-) Sometimes overkill for something small.

> Check: What are some pros and cons of this Single-Remote workflow?

#### Distributed Workflows
These approaches all use multiple remote repos; typically, everyone has their own fork of the 'original' project (the version of the repo that's publicly visible and is managed by the project maintainer), and changes are submitted via pull request.

- **Integration Manager Workflow**

**How It Works**: One collaborator plays the role of 'Integration Manager'. This means that they are responsible for managing the official repository and either accepting or rejecting pull requests as they come in.

> Note: Discuss the pros and cons.

(+) One student integrates all changes, so there's consistency.

(-) Could get overwhelming for large projects.

- **Dictator/Lieutenants Workflow**

**How It Works**: This workflow is very similar to the Integration Manager Workflow. The biggest difference is that rather than submitting all pull requests to a single integration manager, PRs are funneled through 'Lieutenants', who all report to the 'Dictator'. Only the Dictator has write access to the official repo.

(This workflow basically has the opposite trade-off of the previous one).

> Check: What are good situations for using a distributed workflow?

## Conclusion (5 mins)
- Explain the difference between `rebase` and `merge`
- Identify how pull requests work in the context of using Git/GitHub to collaborate
