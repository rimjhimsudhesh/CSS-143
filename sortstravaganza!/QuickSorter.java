/**
 * QuickSorter is a subclass of Sorter that implements the QuickSort algorithm
 * for sorting an ArrayList of Strings.
 * 
 * @author Rimjhim Sudhesh
*/

package hw5;

import java.util.ArrayList;

public class QuickSorter extends Sorter {

    /**
    * Constructs a QuickSorter object with the given ArrayList of Strings
    * to be sorted.
    * @param words an ArrayList of Strings to be sorted.
    */

    public QuickSorter(ArrayList<String> words) {
        super(words);
    }

    /**
    * Sorts an ArrayList of Strings in lexicographic order using QuickSort algorithm.
    * @return the sorted ArrayList of Strings in lexicographic order.
    */

    @Override
    public ArrayList<String> sortLexicographically() {
        // TODO Implement sorting technique (lexicographic)
        ArrayList<String> words = getUnsortedWords();
        quickSort(words, 0, words.size()-1);
        return words;
    }

    /**
    * Sorts an ArrayList of Strings in lexicographic order using QuickSort algorithm.
    *
    * @return the sorted ArrayList of Strings in lexicographic order.
    */

    @Override
    public ArrayList<String> sortByLength() {
        // TODO Implement sorting technique (by length, w/lexicographic tie-breaking)
        ArrayList<String> words = getUnsortedWords();
        quickSortByLength(words, 0, words.size()-1);
        return words;
    }

    
    /**
    * Recursively sorts an ArrayList of Strings using the QuickSort algorithm
    * in lexicographic order.
    *
    * @param words the ArrayList of Strings to be sorted.
    * @param low the index of the first element of the sub-array to be sorted.
    * @param high the index of the last element of the sub-array to be sorted.
    */

    public  void quickSort(ArrayList<String> words, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(words, low, high);
            quickSort(words, low, pivotIndex - 1);
            quickSort(words, pivotIndex + 1, high);
        }
        
    }

    /**
    * Recursively sorts an ArrayList of Strings using the QuickSort algorithm
    * in ascending order of length with lexicographic tie-breaking.
    *
    * @param words the ArrayList of Strings to be sorted.
    * @param low the index of the first element of the sub-array to be sorted.
    * @param high the index of the last element of the sub-array to be sorted.
    */

    private void quickSortByLength(ArrayList<String> words, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByLength(words, low, high);
            quickSortByLength(words, low, pivotIndex - 1);
            quickSortByLength(words, pivotIndex + 1, high);
        }
    }
   
    /**
    * Partitions an ArrayList of Strings for QuickSort algorithm based on a pivot
    * in lexicographic order.
    *
    * @param words the ArrayList of Strings to be partitioned.
    * @param low the index of the first element of the sub-array to be partitioned.
    * @param high the index of the last element of the sub-array to be partitioned.
    * @return the index of the pivot after partitioning.
    */

    private  int partition(ArrayList<String> words, int low, int high) {
        String pivot = words.get(high);
        int i = low - 1;
        setLexComparisons(getLexComparisons() + (words.size() - 1));
        for (int j = low; j < high; j++) {
            if (words.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(words, i, j);
            }
        }
        swap(words, i + 1, high);
        return i + 1;
    }

    /**
     * Partitions the ArrayList of words based on the length of the strings, with the pivot being the last element.
     * Elements shorter than the pivot are moved to the left of the pivot and elements longer than the pivot are moved to the right.
     * In case of a tie in length, lexicographic order is used to break the tie.
     * @param words The ArrayList of words to partition
     * @param low The index of the first element of the partition
     * @param high The index of the last element of the partition
     * @return The index of the pivot after partitioning
     */
    private  int partitionByLength(ArrayList<String> words, int low, int high) {
        String pivot = words.get(high);
        int i = low - 1;
        setLengthComparisons(getLengthComparisons() + (words.size() - 1));
        for (int j = low; j < high; j++) {
            if (words.get(j).length() < pivot.length() || (words.get(j).length() == pivot.length() && words.get(j).compareTo(pivot) <= 0)) {
                i++;
                swap(words, i, j);
            }
        }
        swap(words, i + 1, high);
        return i + 1;
    }
    
    /**
     * Swaps two elements in the ArrayList of words.
     * @param words The ArrayList of words where the elements will be swapped
     * @param i The index of the first element to be swapped
     * @param j The index of the second element to be swapped
    */
    private  void swap(ArrayList<String> words, int i, int j) {
        String temp = words.get(i);
        words.set(i, words.get(j));
        words.set(j, temp);
    }
    
    
    
    
    
    
}
