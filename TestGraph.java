import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGraph {

    Graph graph;

    @BeforeEach
    void initTests(){
        graph = new Graph();
        addNodes();
        addEdges();
    }

    void addNodes(){
        graph.createNode(1);
        graph.createNode(2);
        graph.createNode(3);
        graph.createNode(4);
        graph.createNode(5);
        graph.createNode(6);
        graph.createNode(7);
    }

    void addEdges(){
        graph.createEdge(1, 4, 9);
        graph.createEdge(1, 3, 6);
        graph.createEdge(4, 5, 2);
        graph.createEdge(5, 3, 4);
        graph.createEdge(5, 7, 3);
        graph.createEdge(7, 6, 1);
        graph.createEdge(6, 2, 2);
        graph.createEdge(6, 5, 3);
        graph.createEdge(7, 3, 5);
    }

    @Test
    void ShouldAddNodes(){
        final int expectedNodes = 7;
        Assertions.assertEquals(expectedNodes, graph.countNodes());
    }

    @Test
    void ShouldAddEdges(){
        final int expectedEdges = 9;
        Assertions.assertEquals(expectedEdges, graph.countEdges());
    }

    @Test
    void ShouldFindShortestPath(){
        final int expectedPathCost = 12;
        Assertions.assertEquals(expectedPathCost, graph.shortestPath(6, 1));
    }

}
