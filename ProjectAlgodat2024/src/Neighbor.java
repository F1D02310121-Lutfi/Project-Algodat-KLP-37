public class Neighbor {
    String vertex;
    int weight;
    Neighbor next;

    Neighbor(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
        this.next = null;
    }
}