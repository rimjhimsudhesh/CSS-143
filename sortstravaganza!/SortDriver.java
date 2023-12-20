/**
 * Driver file for HW5 - Sortstravaganza
 * 
 * 1. The most efficient sorting technique is Quick Sort Randomized. It has the
 * smallest runtime but more comparasions than Merge Sort. However, it is quickest 
 * because it has shorter loops and uses a more efficient 
 * divide and conquer method
 * 
 * 2. The least efficient is Insertion Sort. With the most comparasions and runtime. It is
 * the least efficient because it uses a loop within a loop which creates more runtime and
 * comparasions. 
 * 
 * 3. Reversed Data set: These are useful for testing sorting algos
 *    with the worst time complexities. Compare how much slower
 *    the algos are to each other
 *    
 *    Nearly Sorted Data set: Useful for testing sorting algos
 *    that take advantage of pre-existing order. Will compare 
 *    which one would be slower from that
 * 
 *    Small Data set: Test how the run times compare
 */
package hw5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortDriver {

    /**
     * Checks if the input ArrayList of Strings is sorted in non-descending order.
     * @param words the ArrayList of Strings to check for sortedness
     * @return true if the input ArrayList is sorted in non-descending order, false otherwise
     * */
    public static boolean isSorted(ArrayList<String> words) {
        ArrayList<String> sortedWords = new ArrayList<String>();
        sortedWords.addAll(words);
        Collections.sort(sortedWords);
        boolean sorted = true;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) != sortedWords.get(i)) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    /**
     * Checks if an ArrayList of strings is sorted by length in non-descending order.
     * @param words the ArrayList of strings to be checked
     * @return true if the ArrayList is sorted by length in non-descending order, false otherwise
     * */
    public static boolean isSortedLength(ArrayList<String> words) {
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                else if (s1.length() > s2.length())
                    return 1;
                else
                    return s1.compareTo(s2);
            }
        };
        ArrayList<String> sortedWords = new ArrayList<String>();
        sortedWords.addAll(words);
        Collections.sort(sortedWords, byLength);
        boolean sorted = true;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) != sortedWords.get(i)) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    
    /**
     * This method tests the sorting methods implemented by the studentSorter object.
     * It first attempts a lexicographical sort on the ArrayList of strings using studentSorter.sortLexicographically()
     * and then checks if the resulting list is sorted using isSorted() method.
     * It prints the results of the check as well as the number of comparisons performed and the time it took to sort.
     * It then attempts a sort by length on the ArrayList of strings using studentSorter.sortByLength()
     * and checks if the resulting list is sorted using isSortedLength() method.
     * It prints the results of the check as well as the number of comparisons performed and the time it took to sort.
     * @param studentSorter Sorter object containing sorting methods implemented by the student.
     * */
    static void testSorter(Sorter studentSorter) {
        System.out.println("Attempting lexicographical sort...");
        long startTime = System.currentTimeMillis();
        ArrayList<String> sortedWords1 = studentSorter.sortLexicographically();
        long endTime = System.currentTimeMillis();
        System.out.println("Checking if list is sorted: "
                + isSorted(sortedWords1));
        System.out.println("Sort took (comparisons): "
                + studentSorter.getLexComparisons());
        System.out.println("Sort took (milliseconds): " + (endTime - startTime)
                + "\n");

        System.out.println("Attempting by-length sort...");
        startTime = System.currentTimeMillis();
        
        ArrayList<String> sortedWords2 = studentSorter.sortByLength();
        endTime = System.currentTimeMillis();
        System.out.println("Checking if list is sorted: "
                + isSortedLength(sortedWords2));
        System.out.println("Sort took (comparisons): "
                + studentSorter.getLengthComparisons());
        System.out.println("Sort took (milliseconds): " + (endTime - startTime)
                + "\n");

    }
    /**
     * The main method reads a file containing unsorted words and sorts them using
     * different sorting algorithms implemented by the Sorter classes. It then
     * calls the testSorter method for each sorting algorithm and prints the
     * results to the console.
     * @param args an array of command-line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();

        Scanner s = null;
        try {
            s = new Scanner(new File("unsortedwords.txt"));
        } catch (IOException e) {
            System.out.println("Couldn't read the file!");
            System.exit(1);
        }

        while (s.hasNext()) {
            words.add(s.next());
        }

        System.out.println("Successfully read " + words.size()
                + " words, proceeding to sort...\n");

        Sorter insertionSorter = new InsertionSorter(words);
        Sorter mergeSorter = new MergeSorter(words);
        Sorter quickSorter = new QuickSorter(words);
        Sorter randomQuickSorter = new QuickSorterRandomized(words); 
        //Sorter bstSorter = new BinarySearchTreeSorter(words);

        System.out.println("INSERTION");
        testSorter(insertionSorter);

        System.out.println("MERGE");
        testSorter(mergeSorter);

        System.out.println("QUICK");
        testSorter(quickSorter);

        System.out.println("QUICK (RANDOMIZED)");
        testSorter(randomQuickSorter);

        /*System.out.println("BST"); */
        //testSorter(bstSorter);
    }

}
