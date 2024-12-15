public class Path {
    String path;
    int weight;
    Path next;

    Path(String path, int weight) {
        this.path = path;
        this.weight = weight;
        this.next = null;
    }
}