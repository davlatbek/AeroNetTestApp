/**
 * Created by davlet on 8/1/17.
 */
public class DejkstraAlgo {
    int[][] graph;

    public DejkstraAlgo(int iLength, int jLength) {
        this.graph = new int[iLength][jLength];
    }

    public void fill(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = 0;
            }
        }
    }

    public void print(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void findShortPath(){

    }

    public static void main(String[] args) {
        DejkstraAlgo dejkstraAlgo = new DejkstraAlgo(4,4);
        dejkstraAlgo.fill();
        dejkstraAlgo.print();
    }
}
