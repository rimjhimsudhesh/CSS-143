### Summary
Build a class and a driver for use in searching your computer’s secondary storage (hard disk or flash memory) for a specific file from a set of files indicated by a starting path.

### Introduction and Driver
In this assignment, your job is to write a class that searches through a file hierarchy (a tree) for a specified file. Your FindFile class will search a directory (and all subdirectories) for a target file name.

For example, in the file hierarchy pictured above, the file “lesson.css” will be found once in a directory near the root or top-level drive name (e.g. “C:\”) . Your FindFile class will start at the path indicated and will search each directory and subdirectory looking for a file match. Consider the following code that could help you build your Driver.java:

String targetFile = “lesson.css”;
String pathToSearch =”
C:\\WCWC”; FindFile finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);
Finder.directorySearch(targetFile, pathToSearch);

### FindFile Class Interface
FindFile(int maxFiles): This constructor accepts the maximum number of files to find.
void directorySearch(String target, String dirName): The parameters are the target file name to look for and the directory to start in.
int getCount(): This accessor returns the number of matching files found
String[] getFiles(): This getter returns the array of file locations, up to maxFiles in size.
