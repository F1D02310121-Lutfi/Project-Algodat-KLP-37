public class Graph {
    GraphNode head;

    public void addNode(String vertex) {
        GraphNode newNode = new GraphNode(vertex, Integer.MAX_VALUE);
        newNode.next = head;
        head = newNode;
    }

    public void addEdge(String source, String destination, int weight) {
        GraphNode sourceNode = findNode(source);
        GraphNode destNode = findNode(destination);
        if (sourceNode != null && destNode != null) {
            Neighbor newNeighbor = new Neighbor(destination, weight);
            newNeighbor.next = sourceNode.neighbors;
            sourceNode.neighbors = newNeighbor;

            newNeighbor = new Neighbor(source, weight);
            newNeighbor.next = destNode.neighbors;
            destNode.neighbors = newNeighbor;
        }
    }

    private GraphNode findNode(String vertex) {
        GraphNode current = head;
        while (current != null) {
            if (current.vertex.equals(vertex)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayRute(String startVertex) {
        GraphNode startNode = findNode(startVertex);
        if (startNode == null) return;

        startNode.distance = 0;
        GraphNode current = head;
        while (current != null) {
            GraphNode minNode = findMinDistanceNode();
            if (minNode == null) break;

            minNode.visited = true;
            Neighbor neighbor = minNode.neighbors;
            while (neighbor != null) {
                GraphNode neighborNode = findNode(neighbor.vertex);
                if (!neighborNode.visited && minNode.distance != Integer.MAX_VALUE) {
                    int newDist = minNode.distance + neighbor.weight;
                    if (newDist < neighborNode.distance) {
                        neighborNode.distance = newDist;
                        neighborNode.prev = minNode.vertex;
                    }
                }
                neighbor = neighbor.next;
            }
            current = current.next;
        }
        printPathsSorted(startVertex);
    }

    private GraphNode findMinDistanceNode() {
        GraphNode current = head;
        GraphNode minNode = null;
        int minDistance = Integer.MAX_VALUE;
        while (current != null) {
            if (!current.visited && current.distance < minDistance) {
                minDistance = current.distance;
                minNode = current;
            }
            current = current.next;
        }
        return minNode;
    }

    private void printPathsSorted(String startVertex) {
        GraphNode sortedHead = null;
        GraphNode current = head;
        while (current != null) {
            if (!current.vertex.equals(startVertex) && current.distance != Integer.MAX_VALUE) {
                sortedHead = insertSorted(sortedHead, current);
            }
            current = current.next;
        }

        current = sortedHead;
        while (current != null) {
            String path = buildPath(current);
            System.out.println("Dari " + path);
            current = current.nextSorted;
        }
    }

    private GraphNode insertSorted(GraphNode sortedHead, GraphNode node) {
        if (sortedHead == null || node.distance < sortedHead.distance) {
            node.nextSorted = sortedHead;
            return node;
        }

        GraphNode current = sortedHead;
        while (current.nextSorted != null && current.nextSorted.distance <= node.distance) {
            current = current.nextSorted;
        }

        node.nextSorted = current.nextSorted;
        current.nextSorted = node;
        return sortedHead;
    }

    private String buildPath(GraphNode node) {
        if (node.prev == null) {
            return node.vertex;
        }
        GraphNode prevNode = findNode(node.prev);
        return buildPath(prevNode) + " -> " + node.vertex + " (" + (node.distance - prevNode.distance) + " km)";
    }
}
