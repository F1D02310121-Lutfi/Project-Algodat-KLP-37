public class GraphNode {
    String vertex;
    int distance;
    boolean visited;
    String prev;
    GraphNode next;
    GraphNode nextSorted;
    Neighbor neighbors;

    public GraphNode(String vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
        this.visited = false;
        this.prev = null;
        this.next = null;
        this.nextSorted = null;
        this.neighbors = null;
    }
}