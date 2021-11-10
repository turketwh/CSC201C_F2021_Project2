import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int kmerLength = 3;

        String kmer;
        Integer count;

        String sequence = null;
        int sequenceLength = -1;
        int stoppingPoint = -1;

        int index;

        KmerCountTable hashTable = new KmerCountTable();

        Scanner scanner = new Scanner(new File("prx1.txt"));
        while (scanner.hasNextLine()) {
            sequence = scanner.nextLine();
            sequenceLength = sequence.length();
            stoppingPoint = sequenceLength - kmerLength + 1;

            for (index = 0; index < stoppingPoint; index = index + 1) {
                kmer = sequence.substring(index,index+kmerLength);
                System.out.println(kmer + " " + kmer.hashCode());
                hashTable.increment(kmer);
            }
        }
        scanner.close();

        hashTable.print();

        scanner = new Scanner(new File("query.txt"));
        while (scanner.hasNextLine()) {
            kmer = scanner.nextLine();
            count = hashTable.retrieve(kmer);
            if (count == null) {
                System.out.println("Queried kmer " + kmer + " not in sequence data.");
            }
            else {
                System.out.println("Queried kmer " + kmer + " appeared " + count + " times in sequence data.");
            }
        }
        scanner.close();
    }
}
