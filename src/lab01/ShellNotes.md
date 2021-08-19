-----------------------------
**Shell Notes**
-----------------------------
The shell is a powerful tool that lets its users execute commands that interface with the operating system. From the shell you can execute already written tools as well as write executable scripts in the shell's language. This is useful for automating frequently repeated tasks. java is one such tool, it runs Java programs.

**Shell Basics**
The canonical Hello World in the bash shell language:
```
> echo 'hello world'
```
Shell commands are often written with a <code>></code> or $ prefix to represent the prompt. The user does not type the prompt character(s).

A great deal of tasks involve inspecting and manipulating the filesystem. Some commands that do this are:
| Command | Meaning |
| :-- | :-- |
| ls | list info about FILEs, or current directory if none given |
| ls [FILE...] | list info about FILEs, or current directory if none given |
| ls -al [FILE...] | more detailed list, including hidden files, about FILEs, or current directory if none given |
| mkdir DIR... | make directory(s) |
| rmdir DIR... | remove directory(s) |
| rm FILE... | remove file(s) |
| cp SRC DEST | copy SRC to DEST |
| mv SRC DEST | move SRC to DEST (can be used to rename a file) |
| cd DIR | change directory to DIR, or home directory if none given |

When denoting a command's usage, items within square braces means those items are optional. The ellipsis means a variable number. Since commands tends to have a lot of options and long formats, commands typically provide a manual page documenting usage. To get a tool's documentation, type man, followed by that command. The man page is brought up in what is called a pager, a tool that paginates long output within the terminal. Arrow keys can be used to scroll, Home key to go to top, End key to go to bottom, and / to search for a string, q to quit.

Since one of the goals of shell scripting language is terseness (expressing commands in few characters), shells typically provide several characters with special meanings, several of which we'll use in this class.

| Symbol | Meaning |
| :-: | :-- |
| . | stands for the current directory. Hence ls and ls . output the same thing |
| .. | stands for the parent directory, the directory one level above the one you're currently in (.) |
| ~ | stands for a user's home directory - in Linux it is the top-level directory for all of a user's files, which fall in subdirectoris of this one |
| `*` | is the wildcard character that matches any sequence of characters |
| & | execute the command in a separate background process, so control returns to the terminal |

Putting this together, what the following command would do?
```
> cp ~/*.txt ..
```
This copies all files under the home directory that end in the extension .txt to the parent directory, that is, the directory above our current directory.
```
> gedit Hello.java &
[1] 29988
> javac -d . Hello.java
```
This calls the gedit program, a simple Linux text editor, and tells it to open the Hello.java program. To create a file, simply provide the filename you want to gedit, it will create and open that file for you to edit. The & tells the shell to execute this program in a background process so the user can go on entering commands without waiting for the program to complete. It outputs the process id (pid) in case you later need to kill the process. & is especially useful for text editing programs that open a stand-alone application window (GUI) so the file can remain open for editing while you compile and run from the same terminal.

`javac` and `java` usage is described in the Compiling Notes

(Prepared by previous TA Matthew Hems, 2016-17)
