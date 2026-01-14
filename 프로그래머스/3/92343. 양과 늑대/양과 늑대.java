import java.util.Arrays;

class Solution {
    int[] tInfo;
    int[][] edgesInfo;
    int maxSheepCount = 0;

    public int solution(int[] info, int[][] edges) {
        tInfo = info;
        edgesInfo = edges;
        boolean[] initVisited = new boolean[info.length];
        dfs(0, initVisited, 0, 0);

        return maxSheepCount;
    }

    private void dfs(int start, boolean[] visited, int sheepCount, int wolfCount) {
        boolean[] copiedVisited = Arrays.copyOf(visited, visited.length);
        copiedVisited[start] = true;
        if (tInfo[start] == 0) {
            sheepCount++;
            maxSheepCount = Math.max(maxSheepCount, sheepCount);
        } else {
            wolfCount++;
        }

        if (sheepCount <= wolfCount) {
            return;
        }

        for (int[] parentAndChild : edgesInfo) {
            int parent = parentAndChild[0];
            int child = parentAndChild[1];
            if (copiedVisited[parent] && !copiedVisited[child]) {
                dfs(child, copiedVisited, sheepCount, wolfCount);
            }
        }
    }
}