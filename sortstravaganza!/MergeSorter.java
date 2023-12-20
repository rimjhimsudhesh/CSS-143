/**
 * A class representing a Merge Sorter that can sort an ArrayList of Strings either
 * lexicographically or by length with lexicographic tie-breaking.
 * Extends the Sorter class.
 * @author Rimjhim Sudhesh
*/

package hw5;

import java.util.ArrayList;

public class MergeSorter extends Sorter {

    /**
    * Constructor for the MergeSorter class.
    *
    * @param words an ArrayList of Strings to be sorted.
    */
    public MergeSorter(ArrayList<String> words) {
        super(words);
    }
    
    
    /**
    * Sorts the ArrayList of Strings lexicographically using merge sort algorithm.
    *
    * @return the sorted ArrayList of Strings.
    */

    @Override
    public ArrayList<String> sortLexicographically() {
        // TODO Implement sorting technique (lexicographic)
        ArrayList<String> words = getUnsortedWords();
        mergeSort(words, 0, words.size() - 1);
        return words;
    }

    /**
    * Sorts the ArrayList of Strings by length, with lexicographic tie-breaking
    * using merge sort algorithm.
    *
    * @return the sorted ArrayList of Strings.
    */
    @Override
    public ArrayList<String> sortByLength() {
        // TODO Implement sorting technique (by length, w/lexicographic tie-breaking)
        ArrayList<String> words = getUnsortedWords();
        mergeSortByLength(words, 0, words.size() - 1);
        return words;
    }

    /**
    * Helper method that sorts the ArrayList of Strings by length, with lexicographic tie-breaking
    * using merge sort algorithm.
    *
    * @param words the ArrayList of Strings to be sorted.
    * @param low the starting index of the sublist to be sorted.
    * @param high the ending index of the sublist to be sorted.
    */
    private  void mergeSortByLength(ArrayList<String> words, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortByLength(words, low, mid);
            mergeSortByLength(words, mid + 1, high);
            mergeByLength(words, low, mid, high);
        }
    }

    /**
     * Helper method that merges the sublists sorted by length, with lexicographic tie-breaking.
     * @param words the ArrayList of Strings to be merged.
     * @param low the starting index of the first sublist.
     * @param mid the ending index of the first sublist.
     * @param high the ending index of the second sublist.
    */
    private void mergeByLength(ArrayList<String> words, int low, int mid, int high) {
        ArrayList<String> temp = new ArrayList<>();
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            setLengthComparisons(getLengthComparisons() + 1);
            if (words.get(i).length() < words.get(j).length()) {
                temp.add(words.get(i++));
            } else if (words.get(i).length() > words.get(j).length()) {
                temp.add(words.get(j++));
            } else {
                if (words.get(i).compareTo(words.get(j)) <= 0) {
                    temp.add(words.get(i++));
                } else {
                    temp.add(words.get(j++));
                }
            }
        }

        while (i <= mid) {
            temp.add(words.get(i++));
        }

        while (j <= high) {
            temp.add(words.get(j++));
        }

        for (i = low; i <= high; i++) {
            words.set(i, temp.get(k++));
        }
    }
    
    /**
    Recursively sorts the given ArrayList of Strings using the merge sort algorithm.
    @param words the ArrayList of Strings to be sorted
    @param low the starting index of the range of elements to be sorted
    @param high the ending index of the range of elements to be sorted
    */
    private void mergeSort(ArrayList<String> words, int low, int high) {
        if (low < high) {
            //setLengthComparisons(getLengthComparisons() + 1);
            int mid = low + (high - low) / 2;
            mergeSort(words, low, mid);
            mergeSort(words, mid + 1, high);
            merge(words, low, mid, high);
        }
    }
    /**
     * This method performs the merge operation on the two sorted sub-arrays
     * of the given ArrayList of Strings from the given low index to the high index.
     * It creates a temporary ArrayList to hold the merged sub-array and iterates
     * through the two sub-arrays, comparing their elements and adding them to
     * the temporary ArrayList in the appropriate order.
     * @param words the ArrayList of Strings to be sorted
     * @param low the starting index of the first sub-array
     * @param mid the ending index of the first sub-array and the starting index of the second sub-array
     * @param high the ending index of the second sub-array
    */
    private void merge(ArrayList<String> words, int low, int mid, int high) {
        ArrayList<String> temp = new ArrayList<>();
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            setLexComparisons(getLexComparisons() + 1);
            if (words.get(i).compareTo(words.get(j)) <= 0) {
                temp.add(words.get(i++));
            } else {
                temp.add(words.get(j++));
            }
        }

        while (i <= mid) {
            temp.add(words.get(i++));
        }

        while (j <= high) {
            temp.add(words.get(j++));
        }

        for (i = low; i <= high; i++) {
            words.set(i, temp.get(k++));
        }
    }

}
