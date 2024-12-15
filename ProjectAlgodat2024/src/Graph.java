public class Graph {
    GraphNode head;
    Path pathHead;

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

    public void dijkstra(String startVertex) {
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

        collectPaths(startVertex);
        printPaths();
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

    private void collectPaths(String startVertex) {
        GraphNode current = head;
        while (current != null) {
            if (!current.vertex.equals(startVertex) && current.distance != Integer.MAX_VALUE) {
                String path = buildPath(current, startVertex);
                addPath(path, current.distance);
            }
            current = current.next;
        }
    }

    private String buildPath(GraphNode node, String startVertex) {
        if (node.prev != null) {
            GraphNode prevNode = findNode(node.prev);
            return buildPath(prevNode, startVertex) + " -> " + node.vertex + "(" + (node.distance - prevNode.distance) + ")";
        } else {
            return startVertex;
        }
    }

    private void addPath(String path, int weight) {
        Path newPath = new Path(path, weight);
        if (pathHead == null || pathHead.weight > weight) {
            newPath.next = pathHead;
            pathHead = newPath;
        } else {
            Path current = pathHead;
            while (current.next != null && current.next.weight <= weight) {
                current = current.next;
            }
            newPath.next = current.next;
            current.next = newPath;
        }
    }

    private void printPaths() {
        Path current = pathHead;
        while (current != null) {
            System.out.println("From " + current.path);
            current = current.next;
        }
    }
}
