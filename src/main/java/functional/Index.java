package functional;

/**
 * Created by Robert Burek
 */
final public class Index {

    private String indexNumber;

    public Index(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    @Override
    public String toString() {
        return "Index{" +
                "indexNumber='" + indexNumber + '\'' +
                '}';
    }
}
