package coen352.tut8;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
/******************************************************************************
 *  Compilation:  javac FrequencyCounter.java
 *  Execution:    java FrequencyCounter L < input.txt
 *  Dependencies: ST.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/31elementary/tinyTale.txt
 *                https://algs4.cs.princeton.edu/31elementary/tale.txt
 *                https://algs4.cs.princeton.edu/31elementary/leipzig100K.txt
 *                https://algs4.cs.princeton.edu/31elementary/leipzig300K.txt
 *                https://algs4.cs.princeton.edu/31elementary/leipzig1M.txt
 *
 *  Read in a list of words from standard input and print out
 *  the most frequently occurring word that has length greater than
 *  a given threshold.
 *
 *  % java FrequencyCounter 1 < tinyTale.txt
 *  it 10
 *
 *  % java FrequencyCounter 8 < tale.txt
 *  business 122
 *
 *  % java FrequencyCounter 10 < leipzig1M.txt
 *  government 24763
 *
 *
 ******************************************************************************/

import org.jetbrains.annotations.NotNull;

/**
 *  The {@code FrequencyCounter} class provides a client for
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class FrequencyCounter {

    // Do not instantiate.
    private FrequencyCounter() { }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     */

    public static void main( String [] args) {
        String s = getString();
        String[] arrWords = s.split("\\s+");
        int distinct = 0, words = 0;
        int minlen = 1;

        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        int i=0;
        while (i<arrWords.length) {
            String key = arrWords[i++];
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }
        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }

    private static String getString() {
        return "it was the best of times it was the worst of times\n" +
                "it was the age of wisdom it was the age of foolishness\n" +
                "it was the epoch of belief it was the epoch of incredulity\n" +
                "it was the season of light it was the season of darkness\n" +
                "it was the spring of hope it was the winter of despair\n" +
                "we had everything before us we had nothing before us\n" +
                "we were all going direct to heaven we were all going direct\n" +
                "the other wayin short the period was so far like the present\n" +
                "period that some of its noisiest authorities insisted on its\n" +
                "being received for good or for evil in the superlative degree\n" +
                "of comparison only\n" +
                "\n" +
                "there were a king with a large jaw and a queen with a plain face\n" +
                "on the throne of england there were a king with a large jaw and\n" +
                "a queen with a fair face on the throne of france  in both\n" +
                "countries it was clearer than crystal to the lords of the state\n" +
                "preserves of loaves and fishes that things in general were\n" +
                "settled for ever\n" +
                "\n" +
                "it was the year of our lord one thousand seven hundred and\n" +
                "seventyfive  spiritual revelations were conceded to england at\n" +
                "that favoured period as at this  mrs southcott had recently\n" +
                "attained her fiveandtwentieth blessed birthday of whom a\n" +
                "prophetic private in the life guards had heralded the sublime\n" +
                "appearance by announcing that arrangements were made for the\n" +
                "swallowing up of london and westminster  even the cocklane\n" +
                "ghost had been laid only a round dozen of years after rapping\n" +
                "out its messages as the spirits of this very year last past\n" +
                "supernaturally deficient in originality rapped out theirs\n" +
                "mere messages in the earthly order of events had lately come to\n" +
                "the english crown and people from a congress of british subjects\n" +
                "in america  which strange to relate have proved more important\n" +
                "to the human race than any communications yet received through\n" +
                "any of the chickens of the cocklane brood";
    }
}
