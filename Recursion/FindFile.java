import java.io.File;

/**
 * A class that recursively searches for a file in a given directory and all its subdirectories.
 * It provides a method to search for the file and return its absolute path, and a method to retrieve
 * an array of all files found.
 * 
 * @author Rimjhim Sudhesh
 */

public class FindFile {
    /**
     * The maximum number of files to be found.
     */
    private final int maxFiles; 

     /**
     * The number of files found.
     */
    private int countFiles;

    /**
     * An array of the absolute paths of all files found.
     */
    private String[] filesName;

     /**
     * Creates a new FindFile object with the specified maximum number of files to be found.
     * 
     * @param maxFiles the maximum number of files to be found
     */
    public FindFile(int maxFiles){
        this.maxFiles = maxFiles;
        this.countFiles = 0;
        this.filesName = new String[maxFiles];

    }

    /**
     * Searches the specified directory and its subdirectories for a file with the specified name,
     * and returns its absolute path. Throws an ExceptionClass if the specified directory is invalid.
     * 
     * @param target the name of the file to search for
     * @param dirName the name of the directory to search in
     * @throws ExceptionClass if the specified directory is invalid
     */
    public void directorySearch(String target, String dirName){
        File file = new File(dirName);
        if(!file.isDirectory()){
            throw new ExceptionClass("Invalid Directory");
        }
        search(file, target);
    }
   
    /**
     * Recursively searches the specified directory and its subdirectories for a file with the specified name,
     * and adds its absolute path to the filesName array if found. Stops searching if the maximum number of files
     * has been reached.
     * 
     * @param directory the directory to search in
     * @param target the name of the file to search for
     */
    private void search(File directory, String target){
        if(countFiles >= maxFiles){
            throw new ExceptionClass("Max Files have been exceeded");
        }

        File[] filesInDirectory = directory.listFiles();
        if(filesInDirectory == null){
            return;
        }

        for(File file:filesInDirectory){
            if(file.isDirectory()){
                search(file, target);
            } 
            else if(file.getName().equals(target)){
                filesName[countFiles] = file.getAbsolutePath();
                countFiles++;
            }

            if(countFiles >= maxFiles){
                return;
            }

        }

    }
     
    /**
     * Returns the number of files found.
     * 
     * @return the number of files found
     */
    public int getCount(){
        return countFiles; 
    }

    /**
     * Returns an array of the absolute paths of all files found.
     * 
     * @return an array of the absolute paths of all files found
     */
    public String[] getFiles(){
        return filesName;
    }
}
