public class Main {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 2);
        graph.addEdge("D", "E", 7);

        graph.dijkstra("A");
    }
}
