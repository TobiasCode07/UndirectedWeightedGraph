import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private List<Node> nodes = new ArrayList<Node>();
    private List<Edge> edges = new ArrayList<Edge>();

    public int countNodes(){
        return nodes.size();
    }

    public int shortestPath(int id1, int id2){
        Node startNode = getNode(id1);
        Node endNode = getNode(id2);

        if (startNode != null) {
            if (endNode != null){
                Node currentNode = startNode;
                List<Node> Q = nodes;
                Node v, u;
                List <Edge> vEdges;
                Edge k;

                while (!Q.isEmpty()){
                    v = getNode(findMin(getEdgesWeights(currentNode.id)));
                    System.out.println(v.id);
                    Q.remove(v);
                    v.previousNode = currentNode;
                    currentNode = v;

                    vEdges = getEdges(v.id);
                    for (int i = 0; i < vEdges.size(); i++){
                        k = vEdges.get(i);
                        u = getOtherNode(v, k);

                        if (k.weight < u.pathCost){
                            u.pathCost = v.pathCost + k.weight;
                            u.previousNode = v;
                        }
                    }
                }
            }
            else{
                System.out.println("[Graph] Couldn't find node with id " + id2);
            }
        }
        else{
            System.out.println("[Graph] Couldn't find node with id " + id1);
        }

        return endNode.pathCost;
    }

    private Node getOtherNode(Node a, Edge b){
        if (b.v1 == a){
            return b.v2;
        }
        else{
            return b.v1;
        }
    }

    public void createNode(int id){
        if (getNode(id) == null){
            nodes.add(new Node(id));
            System.out.println("[Graph] Added node with id " + id);
        }
        else{
            System.out.println("[Graph] There already is a node with id " + id);
        }
    }

    public void createEdge(int id1, int id2, int weight){
        Node v1 = getNode(id1);
        Node v2 = getNode(id2);
        if (weight >= 0){
            if (v1 != null){
                if (v2 != null){
                    edges.add(new Edge(v1, v2, weight));
                    System.out.println("[Graph] Added edge with weight " + weight + ", and node ids " + id1 + " and " + id2);
                }
                else{
                    System.out.println("[Graph] Couldn't find node with id " + id2);
                }
            }
            else{
                System.out.println("[Graph] Couldn't find node with id " + id1);
            }
        }
        else{
            System.out.println("[Graph] Weight must be 0 or above");
        }

    }

    public void removeEdge(int id1, int id2){
        if (getEdge(id1, id2) != null){
            edges.remove(getEdge(id1, id2));
            System.out.println("[Graph] Removed edge with ids " + id1 + " and " + id2);
        }
        else if (getEdge(id2, id1) != null){
            edges.remove(getEdge(id2, id1));
            System.out.println("[Graph] Removed edge with ids " + id2 + " and " + id1);
        }
        else{
            System.out.println("[Graph] There is no edge with ids " + id1 + " and " + id2);
        }
    }

    public void removeNode(int id){
        Node node = getNode(id);

        if (node != null){
            List<Edge> edgesToRemove = getEdges(id);

            if (edgesToRemove != null){
                int i;
                for (i = 0; i < edgesToRemove.size(); i++){
                    System.out.println("[Graph] Removed edge with weight " + edgesToRemove.get(i).weight + " and ids " + edgesToRemove.get(i).v1.id + " and " + edgesToRemove.get(i).v2.id);
                    edges.remove(edgesToRemove.get(i));
                }
            }

            nodes.remove(node);
            System.out.println("[Graph] Removed node with id " + id);
        }
        else{
            System.out.println("[Graph] There is no node with id " + id);
        }
    }

    private Node getNode(int id){
        if (nodes != null){
            int i;
            for (i = 0; i < nodes.size(); i++){
                if (id == nodes.get(i).id){
                    return nodes.get(i);
                }
            }
        }

        // System.out.println("[Graph] No node found with that id");
        return null;
    }

    private List<Edge> getEdges(int id){
        List<Edge> edgesTemp = new ArrayList<Edge>();

        if (edges != null){
            int i;
            for (i = 0; i < edges.size(); i++){
                if (id == edges.get(i).v1.id || id == edges.get(i).v2.id){
                    edgesTemp.add(edges.get(i));
                }
            }
        }
        else{
            return null;
        }

        return edgesTemp;
    }

    private List<Integer> getEdgesWeights(int id){
        List <Edge> edgesTemp = getEdges(id);
        List <Integer> weights = new ArrayList<>();

        for (int i = 0; i < edgesTemp.size(); i++){
            weights.add(edgesTemp.get(i).weight);
        }

        return weights;
    }


    private Edge getEdge(int id1, int id2){
        if (edges != null){
            int i = 0;
            for (i = 0; i < edges.size(); i++){
                if (id1 == edges.get(i).v1.id && id2 == edges.get(i).v2.id){
                    return edges.get(i);
                }
            }
        }

        // System.out.println("[Graph] No edge found with that ids");
        return null;
    }

    private static Integer findMin(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        List<Integer> sortedlist = new ArrayList<>(list);

        Collections.sort(sortedlist);

        return sortedlist.get(0);
    }
}