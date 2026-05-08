package Task3and5.Task5;

public class Dijkstra {
    static final int verticesCount = 5;

    int minDistance(int distance[], boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < verticesCount; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void Dijkstra(int graph[][], int sourceVertex) {
        int distance[] = new int[verticesCount];
        boolean[] visited = new boolean[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distance[sourceVertex] = 0;
        for (int i = 0; i < verticesCount; i++) {
            int currentVertex = minDistance(distance, visited);
            visited[currentVertex] = true;
            for (int j = 0; j < verticesCount; j++) {
                if (!visited[j] && graph[currentVertex][j] != 0
                && distance[currentVertex] != Integer.MAX_VALUE
                && distance[currentVertex] + graph[currentVertex][j] < distance[j]) {
                    distance[j] = distance[currentVertex] + graph[currentVertex][j];
                }
            }
        }
        System.out.println("Shortest distance from Edinburg to Dundee: " + distance[4]);
    }

    public static void main(String[] arg) {
        int graph[][] = {
                // S G E P D
                {0,50,50,40,0},
                {50,0,70,0,0},
                {50,70,0,100,0},
                {40,0,100,0,60},
                {0,0,0,60,0}
        };
        Dijkstra d = new Dijkstra();
        d.Dijkstra(graph,2);
    }
}
