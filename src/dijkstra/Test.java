package dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by davlet on 8/2/17.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex node = new Vertex("Node_" + i, "Node_" + i);
            vertices.add(node);
        }

        List<Edge> edges = new ArrayList<>();
        test.addEdge("Edge_0", 0, 1, 85, edges, vertices);
        test.addEdge("Edge_1", 0, 2, 217, edges, vertices);
        test.addEdge("Edge_2", 0, 4, 173, edges, vertices);
        test.addEdge("Edge_3", 2, 6, 186, edges, vertices);
        test.addEdge("Edge_4", 2, 7, 103, edges, vertices);
        test.addEdge("Edge_5", 3, 7, 183, edges, vertices);
        test.addEdge("Edge_6", 5, 8, 250, edges, vertices);
        test.addEdge("Edge_7", 8, 9, 84, edges, vertices);
        test.addEdge("Edge_8", 7, 9, 167, edges, vertices);
        test.addEdge("Edge_9", 4, 9, 502, edges, vertices);
        test.addEdge("Edge_10", 9, 10, 40, edges, vertices);
        test.addEdge("Edge_11", 1, 10, 600, edges, vertices);

        Graph graph = new Graph(vertices, edges);
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
        dijkstraAlgorithm.execute(vertices.get(0));
        LinkedList<Vertex> path = dijkstraAlgorithm.getPath(vertices.get(10));
        for (Vertex vertex : path){
            System.out.println(vertex);
        }
    }

    private void addEdge(String edgeId, int sourceLocNo, int destLocNo,
                         int weight, List<Edge> edges, List<Vertex> vertices) {
        Edge edge = new Edge(edgeId,
                vertices.get(sourceLocNo), vertices.get(destLocNo), weight);
        edges.add(edge);
    }
}
