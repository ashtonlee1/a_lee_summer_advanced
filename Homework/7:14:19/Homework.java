import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){

        //add forward edge
        list[source].addFirst(destination);
    }

    public void DFS(){
        System.out.print("Depth First Traversal: ");
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<Integer>();

        for(int startIndex=0; startIndex<vertex; startIndex++){
            if(visited[startIndex]==false) {
                stack.push(startIndex);
                visited[startIndex] = true;
                while (stack.isEmpty() == false) {
                    int nodeIndex = stack.pop();
                    System.out.print(nodeIndex + " ");
                    LinkedList<Integer> nodeList = list[nodeIndex];
                    for (int i = 0; i < nodeList.size(); i++) {
                        int dest = nodeList.get(i);
                        if (visited[dest] == false) {
                            stack.push(dest);
                            visited[dest] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(nodeList.isEmpty()==false) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.printGraph();
        graph.DFS();
    }
}
