/**
 * The LinearSearch class implements a linear search algorithm to search for a given word
 * in an array of words. It extends the SearchAlgorithm class and overrides its methods.
 * 
 * @author Rimjhim Sudhesh
*/

import java.util.Scanner;
import java.io.File;

public class LinearSearch extends SearchAlgorithm {
    /**
     * Searches for a word in an array of words using linear search.
     * @param words the array of words to search in
     * @param wordToFind the word to search for
     * @return the index of the word if found
     * @throws ItemNotFoundException if the word is not found
    */

    public int search(String[] words, String wordToFind) throws ItemNotFoundException{
        for(int i = 0; i < words.length; i++){
            super.incrementCount();
            if(words[i].equals(wordToFind)){
               return i;
            } 

        }
        throw new ItemNotFoundException();
      
        
    }
    /**
     * Recursively searches for a word in an array of words using linear search.
     * @param words the array of words to search in
     * @param wordToFind the word to search for
     * @return the index of the word if found
     * @throws ItemNotFoundException if the word is not found
    */

    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
        if(words.length == 0){
            throw new ItemNotFoundException();
        }
        super.incrementCount();

        if(words[0].equals(wordToFind)){
            return 0;
        }
       
        else{
            String [] otherWords = new String[words.length-1];
            for(int i = 0; i < otherWords.length; i++){
                otherWords[i] = words[i];
            }

            return recSearch(otherWords, wordToFind);
        }


    }



}

