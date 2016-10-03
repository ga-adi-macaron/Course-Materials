---
title: Terminal Basics + Navigating the Filesystem
type: lesson
duration: "1:30"
creator:
    name: Gerry Mathe
    city: London
competencies: Workflow
---

# Terminal Basics + Navigating the Filesystem

### Objectives
*After this lesson, students will be able to:*

- Summarize a basic filesystem structure, including absolute and relative paths
- Use the most common commands to navigate and modify files / directories via the Terminal window (`cd`, `pwd`, `mkdir`, `rm -r`, `mv`, `cp`, `touch`)
- Describe a basic UNIX permissions system
- Differentiate between navigating the file system using the CLI vs. the GUI

### Preparation
*Before this lesson, students should already be able to:*

- Open the terminal
- Issue one or more commands on the command line
- Be comfortable navigating between folders on the command line
- Take a look at some simple keyboard shortcuts to practice: [CLI Shortcuts](https://gist.github.com/alexpchin/01caa027b825d5f98871)

> Note: Much of this content will be review from the pre-work students completed before the course began. We'll be practicing and reviewing some of the things they've learned, and diving into some additional ways to customize their command line.


## Opening: What is a GUI (pronounced gooey) (5 mins)

There was a point when computers didn't come with a **G**raphical **U**ser **I**nterface (GUI). Instead, everyone interacted with the computer using text commands in what we call a **C**ommand **L**ine **I**nterface (CLI).

![Dos](https://upload.wikimedia.org/wikipedia/commons/9/94/FreeDOS_Beta_9_pre-release5_%28command_line_interface%29_on_Bochs_sshot20040912.png)
*Image from Wikimedia*

Today, the command line still exists, even though you may have never seen it as a casual computer user. In this course, we are going to spend a lot of time in the command line, and we will use it every day to manage our files and tell our computer how to run our programs. It will greatly speed up our development process and help us take ownership of our computer at a deeper level. There is so much that your computer will do for you if you know how to speak its language!

#### What is a shell?

A shell is simply a type of command line program, which contains a very simple, text-based user interface enabling us to access all of an operating system's services. It is, very simply, a program that accepts text as input and translates that text into the appropriate functions that you want your computer to run.

*Taken from Just for fun: [Type like a hacker](http://hackertyper.com/)*

## Demo: Forget Finder, get fast at using your laptop (25 mins)

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| pronounced gooey) (5 min  | [Opening](#opening-what-is-a-gui-pronounced-gooey-5-mins)  | Discuss lesson objectives |
| 25 min  | [Demo](#demo-forget-finder,-get-fast-at-using-your-laptop-25-mins)  | Forget Finder, get fast at using your laptop |
| 5 min  | [Independent Practice](#independent-practice-look-around-your-os-5-mins)  | Look around your OS |
| 20 min  | [Demo](#demo-creating,-copying,-and-removing-files-and-folders-20-mins)  | Creating, copying, and removing files and folders |
| 15 min  | [Introduction](#introduction-unix-permissions-and-chmod-15-mins)  | UNIX permissions and Chmod |
| 15 min  | [Demo](#demo-customize-the-terminal-15-mins)  | Customize The terminal |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

#### Opening & Closing Terminal

First, we need to launch the command prompt. We do this by using spotlight:

- ⌘ (Command) + Space
- "*Te*rminal"
- Enter

Notice that you can actually hit enter as soon as the field autocompletes. Get used to taking shortcuts – don't type the whole word out if you don't have to and avoid using your mouse if you can open or use an app with just keyboard shortcuts. It may seem harder now, but when you get used to it, it will save you literally hours of cumulative time.

#### Getting Comfortable

1. For many programs, you can open multiple tabs by pressing **⌘-T**.
  - Try it in your terminal!
2. You can close the current tab or window with **⌘-W**. This goes for most applications on a Mac.
  - Try _that_ in your terminal!
3. If you have a process running, you can quit it by pressing **Ctrl-C**. Let's try that now.

  - At the command line, type `ping 127.0.0.1`. This basically sends a message to your own computer asking if it's awake.
  - Notice that it will keep pinging, even if you type something.
  - To stop the currently-running script, press **Ctrl-C**.

4. To quit the command line altogether, you can press **⌘-Q**.

---

#### Paths

Every file or folder in a file system can be read, written, and deleted by referencing its position inside the filesystem. When we talk about the position of a file or a folder in a file system, we refer to its "path". There are a couple of different kinds of paths we can use to refer to a file – **absolute paths** and **relative paths**.

*Directory* is an important term that's used interchangeably with *folder*. Though they are not exactly the same thing, when we say "navigate to your project directory" think of this as "navigate to your project folder".  Here's a little more information:

_Strictly speaking, there is a difference between a directory which is a file system concept, and the graphical user interface metaphor that is used to represent it (a folder)...If one is referring to a container of documents, the term folder is more appropriate. The term directory refers to the way a structured list of document files and folders is stored on the computer. It is comparable to a telephone directory that contains lists of names, numbers and addresses and does not contain the actual documents themselves._

*Taken from [Close-To-Open Cache Consistency in the Linux NFS Client](http://www.citi.umich.edu/projects/nfs-perf/results/cel/dnlc.html)*

#### What is an absolute path?

An absolute path is defined as the specific location of a file or folder from the root directory, typically shown as `/`. The root directory is the starting point from which all other folders are defined and is not normally the same as your **Home** directory, which is normally found at `/Users/[Your Username]`.

#### Working with UNIX commands and file paths

Typing `cd` - a command for "change directory" with no parameters takes us to our home directory.

```bash
cd
```

If we type in `pwd` - a command for "print working directory" from that folder, we can see where we are in relation to the root directory.

Some examples of absolute path:

```bash
/usr/local/bin/git
/etc/example.ext
/var/data/database.db

```

Notice, all these paths started from `/` directory which is a root directory for every Linux/Unix machines.

#### What is a relative path?
> *Note:* Instructors – customize this lesson to demo with folders that you have present on your filesystem, or alternatively create a similar file structure on the fly.

A relative path is a reference to a file or folder **relative** to the current position, or the present working directory(pwd).

#### Navigating through the command prompt

The tilde `~` character is an alias to your home directory. Use it to quickly return home.

```
cd ~/
```

Another shortcut, if we want to go up one directory from where we currently are, we can use `..`

```
cd ..
```

If we are in the folder `~/a/b/` and we want to open the file that has the absolute path `~/a/b/c/file.txt`, we can just type:

```bash
open c/file.txt
```

or

```bash
open ./c/file.txt
```

At any time, we can also use the absolute path, by adding a slash to the beginning of the path. The absolute path is the same for a file or a folder regardless of the current working directory, but relative paths are different, depending on what directory we are in.  Directory structures are laid out like `directory/subdirectory/subsubdirectory`.

Below are some examples of using relative and absolute path for the same action:


1. My present location is `~/command-line-lesson/ADI/labs` and now I want to change directory to `/ADI`.

  * Using relative path: `cd ..`
  * Using absolute path: `cd ~/command-line-lesson/ADI`

2. My present location is `~/command-line-lesson/ADI/labs` and I want to change the location to `/ADI/lessons`

  * Using relative path: `cd ../labs`
  * Using absolute path: `cd ~/command-line-lesson/ADI/lessons`

By the way, your terminal is located in:

```bash
/Applications/Utilities/Terminal.app
```



Pressing **Up** scrolls through previously entered commands.


What if you're wondering what's in a directory? Typing `ls` and hitting enter is like asking the computer the question "what stuff is in this directory?"  It stands for `list directory contents`. Try it in your current directory and share what you see!

## Independent Practice: Look around your OS (5 mins)

Practice the UNIX commands we just learned with the bullets below:

- Use the `cd` command to go to your home folder.
- Use the `ls` command see what is in your home directory.
- Use the `cd [directory]` command to go into any folder that you spot.
- In the above command, replace `[directory]` with the directory name you intend to move to.
- Use the `ls` command to see what files and directories exist there.
- Use the `cd` command to go to your home folder.

## Demo: Creating, copying, and removing files and folders (20 mins)

What if we want to create files and folders?  The command `mkdir directory-name` creates a new directory with the name “directory-name”.

Try it out. From your current directory, `ls` to look around and then `mkdir my-project` to create a new directory with the name “my-project”.  This new directory will be created within the current parent directory. `ls` again to see it's there.

From the same directory, to create a file, `touch file-name` creates a new file with the name “file-name”.  Try it out - `touch my-file` creates a new file with the name “my-file”.  Again, this new file will be created within the current parent directory.  You can also use different file paths to create files within directories:

```bash
touch my-project/this-new-file.txt
```

Then if you `ls my-project` you'll notice the `this-new-file.txt` is within.

Copying files and folders? No problem - `cp file new-file1` creates a copy of the “file” and calls it “new-file” in your current directory.  If you're looking to copy directories you'll have to pass in a `-r`, which stands for "recursive" - to copy the directory and everything inside of it:

```bash
cp -r my-project my-project-copy
```

Create a copy of the entire "my-project” directory and call it “my-project-copy".  You could always chain a file path onto the second argument and create the copy elsewhere:

```bash
cp -r my-project my-project-copy/copy-within-a-copy
```

How about removing files and folders? Well, we talked about that earlier, but let's practice - `cd` to your root directory and do the following:

```bash
touch some-file.txt
mkdir some-directory
touch some-directory/inner-file.txt
ls
```

Now, you should see a `some-file.txt` and a `some-directory` in your root directory.  But let's get rid of them:

```bash
rm some-file.txt
rm -rf some-directory
```

The first command removes the file `junk-file.txt`; the second removes the directory `junk-directory` and everything inside of it - `inner-junk-file.txt` - because we passed the `-r`, which stands for "recursive".  You could also accomplish this with `-rf` - the `f` stands for force but use with caution and make sure you are in the right place. You can imagine how bad the results could be if you did that to your home folder!

#### Modifying multiple files at the same time

Now, if you're making a whole bunch of files/folders, `mkdir` `rm` and `touch` can be used to create and remove more than one file/directory at the same time.

Try it out.  First, `ls` to see what you have in there and then:

- `mkdir directory01 directory02 directory03`
- `touch file01 file02 file03`
- `rm file01 file03`

Thinking about this command with relative and absolute paths:

1. If my present location is `~/command-line-lesson/a/b/`, and I am want to remove `~/command-line-lesson/a/b/folder/file.txt` file

  * Using relative path: `rm folder/file.txt`
  * Using absolute path: `rm ~/command-line-lesson/a/b/folder/file.txt`

2. If my present location is `~/command-line-lesson/ADI/labs`, and I want to remove a `a.txt` file located in this directory

  * Using relative path: `rm a.txt`
  * Using absolute path: `rm ~/command-line-lesson/ADI/labs/a.txt`

Finally, we can rename and move files and folders with this syntax:

```
mv file-name file-name2
```

The first argument is the file or folder being moved or renamed, and the second argument is the directory destination you can use to also rename the file/folder if you want.  For example, from your root directory:

```bash
mkdir this-folder that-folder
touch this-file.txt that-file.txt
mv this-file.txt this-folder
mv that-file.txt that-folder/that-file.txt
```

Notice now, `this-folder` has a `this-file.txt` within it and `that-folder` has a `that-file.txt`.

A few other helpful commands you can try on your own:

| Command   | Explanation                                                           |
|-----------|-----------------------------------------------------------------------|
| `ls -a`   | Lists all items in current directory including hidden files           |
| `ls -l`   | Gives a long list of items in current directory including permissions |


## Introduction: UNIX permissions and Chmod (15 mins)

> Note: Update the narrative to reflect your own OS.

An OS is meant to serve many users, A user may correspond to a real-world person, but also a program that acts as a specific user. In my laptop OS, I am "bob" and with bob goes a set of permissions and restrictions on all files and folders, But I can also act for some specific program as the user "www" which corresponds to the privileges necessary to operate a local web server. Every User on the OS has a User ID - the name "bob" or "www" is just an alias for a User ID.

Users can be organized in groups. A user may be in one or several groups. A group will have the same set of permissions for every user assigned to this group.

Every file has an owner user and an owner group. So, for any file in the system, user 'bob' may have one of the following ownership relations:

* bob owns the file, i.e. the file's owner is 'bob'.
* bob is a member of the group that owns the file, i.e. the file's owner group is 'ADI'.
* bob is neither the owner, nor belonging to the group that owns the file.

Every file on the system has associated with it a set of permissions. Permissions tell UNIX what can be done with that file and by whom. There are three things you can do with a given file:

* read it.
* write it.
* execute it.

Permissions for a file will specify which of the three actions above can be performed for groups an users in an OS.

For every file, there is 3 types of permissions: permissions for the owner, for the group owner and for everyone else. Remember that there are three possibles actions a user can take on a file - read (r), write (w), execute (x) - so for each of the three permissions we need three actions.


If you change the present working directory to the root (`cd /`) and then show the folder content with the details by typing `ls -l` on the command prompt, you will get something like this:

```bash
 0 drwxrwxr-x+ 93 root  admin  3162 Aug 15 19:37 Applications
 0 drwxr-xr-x+ 66 root  wheel  2244 Jan 18  2015 Library
 0 drwxr-xr-x@  2 root  wheel    68 Sep  9  2014 Network
 0 drwxr-xr-x+  4 root  wheel   136 Jan 18  2015 System
 8 lrwxr-xr-x   1 root  wheel    49 Apr 14  2014 User Information -> /Library/Documentation/User Information.localized
 0 drwxr-xr-x   6 root  admin   204 Jan 18  2015 Users
 0 drwxrwxrwt@  5 root  admin   170 Aug 15 16:35 Volumes
 0 drwxr-xr-x@ 39 root  wheel  1326 Apr 28 21:05 bin
 0 drwxrwxr-t@  2 root  admin    68 Sep  9  2014 cores
 0 drwxr-xr-x   3 root  wheel   102 Sep  8  2014 data
10 dr-xr-xr-x   3 root  wheel  4805 Aug 14 11:45 dev
 8 lrwxr-xr-x@  1 root  wheel    11 Jan 18  2015 etc -> private/etc
 2 dr-xr-xr-x   2 root  wheel     1 Aug 15 19:42 home
 2 dr-xr-xr-x   2 root  wheel     1 Aug 15 19:42 net
 0 drwxr-xr-x@  6 root  wheel   204 Jan 18  2015 private
 0 drwxr-xr-x@ 59 root  wheel  2006 Apr 28 21:05 sbin
 8 lrwxr-xr-x@  1 root  wheel    11 Jan 18  2015 tmp -> private/tmp
 0 drwxr-xr-x@ 12 root  wheel   408 Jan 18  2015 usr
 8 lrwxr-xr-x@  1 root  wheel    11 Jan 18  2015 var -> private/var

```

The second column corresponds to the permissions details for each file/folder. For the first line:

```
drwxrwxr-x+
```
We're not going to talk about the `d` letter at the start or the `+` at the end of each line for the moment. Just pay attention to the nine letters between.

The important part in this set of characters is:

```
rwxrwxr-x
```

This can be read:
```
rwx rwx r-x
```
This breaks down like this:

- first group of three letters corresponds to the owner permission,
- the second group of three letters corresponds to the owner group permission,
- the last group of three letters corresponds to others permission,

#### `chmod`

To modify a file's permissions you need to use the `chmod` command.

Only the owner of a file may use chmod to alter a file's permissions.

chmod has the following syntax:

```
chmod [options] mode file(s)
```

The 'mode' part specifies the new permissions for the file(s) that follow as arguments. A mode specifies which user's permissions should be changed, and afterwards which access types should be changed. Let's say for example:

```
chmod a-x file.txt
```

This means that the execute bit should be cleared (-) for all users - owner, group and the rest of the world. The permissions start with a letter specifying what users should be affected by the change, and this might be any of the following:


* u the owner user
* g the owner group
* o others (neither u, nor g)
* a all users

You might have encountered things like `chmod 755 a_file.txt`.

You can change the entire permission pattern of a file in one go using one number like the one in this example. Every mode has a corresponding code number, and as we shall see, there is a very simple way to figure out what number corresponds to any mode.


Every single digit in the triplet corresponds to the level of authorization for a group (user, group and others). Every digit is the addition of the rights for this group, and every level of permission corresponds to a number:

* 4 for r.
* 2 for w.
* 1 for x.

So if a file has rwxr-xr-x permissions we do the following calculation:

* Triplet for u: rwx => 4 + 2 + 1 = *7*
* Triplet for g: r-x => 4 + 0 + 1 = *5*
* Triplet for o: r-x => 4 + 0 + 1 = *5*
Which makes : 755

So, 755 in UNIX permissions means 'I don't mind if other people read or run this file, but only I should be able to modify it' while 777 means 'everyone has full access to this file'

For practice, what would I do if I only wanted a file to be executable, but not readable or writeable?


## Independent Practice: Get comfortable with chmod

Take 5 minutes to do the following:

1. Create a new directory.
2. Create 3 files in that directory.
3. Make one file readable, writeable, and executable by everyone
4. Make the second file readable by everyone, executable by the user and group, and writeable by the user
5. Make the third file readable and executable by the user and group, and only writeable by the user.

## Conclusion (5 mins)

We will use the command line several hours every day, because is makes all files and folders manipulations more easy. A lot of software programs that we will use during the course also only have a CLI interface and can only be used with commands. Always remember that every action you'll do in a GUI can be done in the CLI.
