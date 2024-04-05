public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode(1);
        graph.addNode(7);
        graph.addNode(7);
        graph.addNode(3);
        graph.createEdge(1, 7, 3);
        graph.createEdge(1, 7, 3);
        graph.createEdge(7, 1, 3);
        graph.createEdge(3, 7, 3);
        graph.removeEdge(7, 1);
        graph.removeEdge(2, 7);
        graph.removeNode(1);
        graph.removeNode(2);

    }
}