import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class KmerCountTable {

    int capacity;
    int numberOfElements;
    ArrayList<LinkedList<KmerCount>> table;

    // Constructs an initially empty hash table with capacity of 7
    public KmerCountTable() {
        // Declare needed arrays and linked lists and initialize
        // variables as appropriate

        // Initially the table is holding no data elements
        numberOfElements = 0;

        // Initially, the capacity is 7.
        // That means there are seven spots in the array holding linked lists
        // and thus 7 possible indices that hash values can get mapped to
        capacity = 7;

        // Make the array be an ArrayList holding up to capacity linked lists
        table = new ArrayList<LinkedList<KmerCount>>(capacity);
        // Allocate each of the linked lists
        for (int index = 0; index < capacity; index = index + 1) {
            table.add(new LinkedList<KmerCount>());
        }
    }

    // Returns the size of the hash table in terms of how many items have
    // been stored in the table
    public int size() {
        // Return how many elements have been added to the table
        return numberOfElements;
    }

    // Returns the load factor (size / capacity) for the hash table
    private double getLoadFactor() {
        // Compute the load factor as the ratio of the number of elements
        // held in the table over the capacity value
        return (1.0 * numberOfElements)/capacity;
    }

    // See project guidelines for description
    public void increment(String keyKmerArg) {
        // TODO: Complete the increment method as per the project guidelines
    }

    // See project guidelines for description
    public Integer retrieve(String keyKmerArg) {
        // TODO: Complete the retrieve method as per the project guidelines
        return null;
    }

    // See project guidelines for description
    private void resize() {
        // TODO: Complete the resize method as per the project guidelines
    }

    // Prints descriptive information about and the contents of the hash table
    public void print() {
        // This method does the following:
        // Print some information about the hashtable
        System.out.println("==> Hashtable Dump <== ");
        System.out.println("Number of elements: " + numberOfElements);
        System.out.println("Capacity: " + capacity);
        System.out.println("Load Factor: " + getLoadFactor());

        // Declare variables that will be useful in visiting
        // all data in the hashtable
        LinkedList<KmerCount> list;
        KmerCount kmerCount;

        // For each linked list (at each index in the table)
        for (int index = 0; index < capacity; index = index + 1) {
            System.out.print("" + index + ":");

            // Get the linked list at that index
            list = table.get(index);

            // If the linked list is empty, print as such
            if (list.isEmpty()) {
                System.out.println(" --> empty <-- ");
            }
            else {
                // Otherwise, iterate down the linked list,
                // starting at position 0 and going until
                // there is no more data, printing the data
                // held for each kmer and count in the table
                System.out.println(" --> list has " + list.size() + " entries <-- ");
                ListIterator<KmerCount> iterator = list.listIterator(0);
                while (iterator.hasNext()) {
                    kmerCount = iterator.next();
                    System.out.println("\t" + kmerCount.toString());
                }
            }
        }
    }
}
