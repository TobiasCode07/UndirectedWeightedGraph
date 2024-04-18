public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.createNode(1);
        graph.createNode(2);
        graph.createNode(3);
        graph.createNode(4);
        graph.createNode(5);
        graph.createNode(6);
        graph.createNode(7);
        graph.createEdge(1, 4, 9);
        graph.createEdge(1, 3, 6);
        graph.createEdge(4, 5, 2);
        graph.createEdge(5, 3, 4);
        graph.createEdge(5, 7, 3);
        graph.createEdge(7, 6, 1);
        graph.createEdge(6, 2, 2);
        graph.createEdge(6, 5, 3);
        graph.createEdge(7, 3, 5);

        System.out.println("[Main] Shortest path cost: " + graph.shortestPath(1, 7));
        System.out.println("[Main] Shortest path cost: " + graph.shortestPath(1, 4));
        System.out.println("[Main] Shortest path cost: " + graph.shortestPath(3, 6));
    }
}