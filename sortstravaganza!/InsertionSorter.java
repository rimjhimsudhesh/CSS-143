/**
 * The InsertionSorter class represents a sorting algorithm that implements insertion sort.
 * This class extends the Sorter class and overrides the methods sortLexicographically() and sortByLength().
 * @author Rimjhim Sudhesh
*/

package hw5;

import java.util.ArrayList;

public class InsertionSorter extends Sorter {

    /**
    * Constructs a new InsertionSorter object with the specified unsorted list of words.
    * @param words The unsorted list of words to be sorted.
    */

    public InsertionSorter(ArrayList<String> words) {
        super(words);
    }

    /**
    * Sorts the unsorted list of words in lexicographic order using insertion sort algorithm.
    * @return The sorted list of words in lexicographic order.
    */

    @Override
    public ArrayList<String> sortLexicographically() {
        // TODO Implement sorting technique (lexicographic)
        for(int i = 1; i < getUnsortedWords().size(); i++){
            String key = getUnsortedWords().get(i);
            int j = i - 1;
        

            while(j >= 0 && getUnsortedWords().get(j).compareTo(key) > 0){
                setLexComparisons(getLexComparisons() + 1);
                getUnsortedWords().set(j+1, getUnsortedWords().get(j));
                j--;
            }
       getUnsortedWords().set(j+1, key);
        }
        return getUnsortedWords();
    }

    /**
    * Sorts the unsorted list of words by length, with lexicographic tie-breaking using insertion sort algorithm.
    * @return The sorted list of words by length.
    */
    @Override
    public ArrayList<String> sortByLength() {
        // TODO Implement sorting technique (by length, w/lexicographic tie-breaking)
        for (int i = 1; i < getUnsortedWords().size(); i++) {
            String keyWord = getUnsortedWords().get(i);
            int j = i - 1;
            while (j >= 0 && getUnsortedWords().get(j).length() > keyWord.length()) {
                setLengthComparisons(getLengthComparisons() + 1);
                getUnsortedWords().set(j + 1, getUnsortedWords().get(j));
                j--;
            }
            getUnsortedWords().set(j + 1, keyWord);
        }
        return getUnsortedWords();
    }

}
