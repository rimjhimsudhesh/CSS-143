/*
 * Searches for a file in a specified directory and its sub-directories
 * using the FindFile class
 * 
 * @author Rimjhim Sudhesh
 */

public class Driver {

    /*
     * creates an instance of the FindFile class and uses it search
     */
    public static void main(String [] args){
        String targetFile = "test.java";
        String pathToSearch = "/Users/rimjhimsudhesh/CSS 143";
        FindFile finder = new FindFile(1);
        finder.directorySearch(targetFile, pathToSearch);
        System.out.println("Number of files found:" + finder.getCount());
        String [] files = finder.getFiles();
        for(String file : files){
            if(file != null){
                System.out.println(file);
            }
        }
    }
   
}
