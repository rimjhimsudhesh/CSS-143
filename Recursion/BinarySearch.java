/**
 * The BinarySearch class implements a binary search algorithm to search for a given word
 * in an array of words. It extends the SearchAlgorithm class and overrides its methods.
 * 
 * @author Rimjhim Sudhesh
*/

public class BinarySearch extends SearchAlgorithm{
    
    /**
     * Searches for a word in an array of words using binary iterative search.
     * @param words the array of words to search in
     * @param wordToFind the word to search for
     * @return the index of the word if found
     * @throws ItemNotFoundException if the word is not found
    */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{
         int LowIndex = 0;
         int HighIndex = words.length - 1;

        while(LowIndex <= HighIndex){
            int MidIndex = (HighIndex + LowIndex)/2;
            incrementCount();
            if((words[MidIndex]).compareTo(wordToFind) < 0){
                LowIndex = MidIndex + 1;
            }
            else if(words[MidIndex].compareTo(wordToFind) > 0){
                HighIndex = MidIndex - 1;
                
            } 
            else{
                return MidIndex;
            }

        }
        throw new ItemNotFoundException();
    }

    public int recSearch(String [] words, String wordToFind) throws ItemNotFoundException {
        return recursiveSearch(words, wordToFind, 0, words.length -1);
    }

    /**
     * Recursively searches for a word in an array of words using binary search.
     * @param words the array of words to search in
     * @param wordToFind the word to search for
     * @return the index of the word if found
     * @throws ItemNotFoundException if the word is not found
    */
    private int recursiveSearch(String [] words, String wordToFind, int low, int high) throws ItemNotFoundException {
        if(low > high){
            throw new ItemNotFoundException();
        }

        int middle = (high + low)/2;
        incrementCount();

        if(words[middle].compareTo(wordToFind) < 0){
            return recursiveSearch(words, wordToFind, middle+1, high);
        }
        else if(words[middle].compareTo(wordToFind) > 0){
            return recursiveSearch(words, wordToFind, low, middle -1);
        }
        else{
            return middle;
        }
    }
}
