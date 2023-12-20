/**
 * A class that implements QuickSorterRandomized algorithm to sort a list of words.
 * @author Rimjhim Sudhesh
*/

package hw5;

import java.util.ArrayList;
import java.util.Random;

public class QuickSorterRandomized extends Sorter {

    /**
    * Constructor for QuickSorterRandomized.
    *
    * @param words an ArrayList of unsorted words
    */

    public QuickSorterRandomized(ArrayList<String> words) {
        super(words);
    }

    /**
    * Sorts the words in lexicographic order.
    *
    * @return an ArrayList of sorted words in lexicographic order
    */

    @Override
    public ArrayList<String> sortLexicographically() {
        // TODO Implement sorting technique (lexicographic)
        ArrayList<String> words = getUnsortedWords();
        quickSort(words, 0, words.size() - 1);
        return words;
    }
    
    /**
    * Sorts the words by length, with lexicographic tie-breaking.
    *
    * @return an ArrayList of sorted words by length, with lexicographic tie-breaking
    */

    @Override
    public ArrayList<String> sortByLength() {
        // TODO Implement sorting technique (by length, w/lexicographic tie-breaking)
        ArrayList<String> words = getUnsortedWords();
        quickSortByLength(words, 0, words.size() - 1);
        return words;
    }

    
    /**
    * Sorts the words using the QuickSort algorithm in lexicographic order.
    *
    * @param words an ArrayList of unsorted words
    * @param low   the index of the lowest element of the sublist to be sorted
    * @param high  the index of the highest element of the sublist to be sorted
    */

    private void quickSort(ArrayList<String> words, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(words, low, high);
            quickSort(words, low, pivotIndex - 1);
            quickSort(words, pivotIndex + 1, high);
        }
    }
    
    /**
    * Partitions the words array around a randomly chosen pivot element.
    *
    * @param words an ArrayList of words to be partitioned
    * @param low   the index of the lowest element of the sublist to be partitioned
    * @param high  the index of the highest element of the sublist to be partitioned
    * @return the index of the pivot element after partitioning
    */

    private int randomizedPartition(ArrayList<String> words, int low, int high) {
        Random random = new Random();
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(words, randomIndex, high);
        return partition(words, low, high);
    }

    /**
    * Partitions the words array around a given pivot element.
    *
    * @param words an ArrayList of words to be partitioned
    * @param low   the index of the lowest element of the sublist to be partitioned
    * @param high  the index of the highest element of the sublist to be partitioned
    * @return the index of the pivot element after partitioning
    */

    private int partition(ArrayList<String> words, int low, int high) {
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
     * Sorts the given list of words by length using the quicksort algorithm.
     * The sorting is done in place, meaning that the original list is modified.
     * The algorithm partitions the list around a pivot element, and recursively sorts the two sub-lists
     * created by the partitioning until the whole list is sorted.
     * The partitioning is done randomly to improve performance in the average case.
     * @param words the list of words to be sorted
     * @param low the index of the first element in the sublist to be sorted
     * @param high the index of the last element in the sublist to be sorted
    */

    private void quickSortByLength(ArrayList<String> words, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartitionByLength(words, low, high);
            quickSortByLength(words, low, pivotIndex - 1);
            quickSortByLength(words, pivotIndex + 1, high);
        }
    }

    
    /**
     * Randomly selects a pivot element in the ArrayList and partitions it by length.
     * @param words the ArrayList of Strings to be sorted
     * @param low the lower index of the current partition
     * @param high the upper index of the current partition
     * @return the index of the pivot element after partitioning
     * */
    
     private int randomizedPartitionByLength(ArrayList<String> words, int low, int high) {
        Random random = new Random();
        //setLengthComparisons(getLengthComparisons() + (words.size() - 1));
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(words, randomIndex, high);
        return partitionByLength(words, low, high);
    }

    /**
     * Partitions the ArrayList of strings based on string length, with lexicographic tie-breaking.
     * @param words the ArrayList of strings to partition
     * @param low the lower index of the sub-array to partition
     * @param high the upper index of the sub-array to partition
     * @return the index of the pivot element after partitioning
     * */
    private int partitionByLength(ArrayList<String> words, int low, int high) {
        String pivot = words.get(high);
        int i = low - 1;
        setLengthComparisons(getLengthComparisons() + (words.size() - 1));
        for (int j = low; j < high; j++) {
            if (words.get(j).length() < pivot.length() ||
                    (words.get(j).length() == pivot.length() && words.get(j).compareTo(pivot) <= 0)) {
                i++;
                swap(words, i, j);
            }
        }
        swap(words, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps the positions of two elements in an ArrayList of Strings.
     * @param words the ArrayList of Strings to swap elements in
     *@param i the index of the first element to swap
     @param j the index of the second element to swap
     */
    private void swap(ArrayList<String> words, int i, int j) {
        String temp = words.get(i);
        words.set(i, words.get(j));
        words.set(j, temp);
    }

}
