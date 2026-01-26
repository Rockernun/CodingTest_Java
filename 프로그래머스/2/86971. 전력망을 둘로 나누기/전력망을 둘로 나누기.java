import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int count = 0;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            adjList[wires[i][0]].add(wires[i][1]);
            adjList[wires[i][1]].add(wires[i][0]);
        }

        for (int[] wire : wires) {
            adjList[wire[0]].remove(Integer.valueOf(wire[1]));
            adjList[wire[1]].remove(Integer.valueOf(wire[0]));

            dfs(1);
            answer = Math.min(answer, Math.abs(count - (n - count)));
            
            count = 0;
            Arrays.fill(visited, false);
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        return answer;
    }

    private void dfs(int node) {
        visited[node] = true;
        count++;
        for (int nextNode : adjList[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
