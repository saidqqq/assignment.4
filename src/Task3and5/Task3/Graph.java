import java.util.*;

public class Graph {
   int verticesCount;
   LinkedList<Integer>[] adjacencyList;
   String[] names = {"A" , "B" ,"C" ,"D" ,"E" , "F" , "G"};

   Graph(int vertex) {
       verticesCount = vertex;
       adjacencyList = new LinkedList[verticesCount];
       for (int i = 0; i < verticesCount; i++) {
           adjacencyList[i] = new LinkedList<>();
       }
   }

   void addEdge(int vertex, int neighbor) {
       adjacencyList[vertex].add(neighbor);
   }

   //BFS
    void BFS(int start) {
       boolean[] visited = new boolean[verticesCount];
       Queue<Integer> queue = new LinkedList<>();
       visited[start] = true;
       queue.add(start);

       while (!queue.isEmpty()) {
           int current = queue.poll();
           System.out.print(names[current] + " ");
           for (int i = 0; i < adjacencyList[current].size(); i++) {
               int neighbor = adjacencyList[current].get(i);
               if (!visited[neighbor]) {
                   visited[neighbor] = true;
                   queue.add(neighbor);
               }
           }
       }
    }

    //DFS
    void DFS(int vertex, boolean[] visited) {
       visited[vertex] = true;
       System.out.print(names[vertex] + " ");
       for (int i = 0; i < adjacencyList[vertex].size(); i++) {
           int neighbor = adjacencyList[vertex].get(i);
           if (!visited[neighbor]) {
               DFS(neighbor, visited);
           }
       }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        // A B C D E F G
        // 0 1 2 3 4 5 6
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);

        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        graph.addEdge(3, 2);
        graph.addEdge(3, 0);

        graph.addEdge(4, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 1);

        graph.addEdge(5, 6);
        graph.addEdge(5, 4);

        graph.addEdge(6, 5);
        graph.addEdge(6, 1);

        System.out.print("DFS: ");

        boolean[] visited = new boolean[7];
        graph.DFS(0, visited);
        System.out.println();
        System.out.print("BFS: ");
        graph.BFS(0);

    }

}
