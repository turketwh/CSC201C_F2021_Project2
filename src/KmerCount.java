public class KmerCount {

    private String kmer;
    private Integer count;

    public KmerCount(String kmerArg) {
        kmer = kmerArg;
        count = 1;
    }

    public String getKmer() {
        return kmer;
    }

    public void incrementCount() {
        count = count + 1;
    }

    public Integer getCount() {
        return count;
    }

    public String toString() {
        return "(" + kmer + "," + count.toString() + ")";
    }
}
