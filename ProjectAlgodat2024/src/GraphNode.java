public class GraphNode {
    String vertex;
    int distance;
    boolean visited;
    Neighbor neighbors;
    GraphNode next;
    String prev;

    GraphNode(String vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
        this.visited = false;
        this.neighbors = null;
        this.next = null;
        this.prev = null;
    }
}
