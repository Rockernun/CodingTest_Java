import java.util.*;

class Solution {
    Map<String, List<int[]>> adjList;
    String[][] tickets;
    boolean[] used;
    List<String> result;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        used = new boolean[tickets.length];
        adjList = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            adjList.putIfAbsent(tickets[i][0], new ArrayList<>());
            adjList.get(tickets[i][0]).add(new int[]{i});
        }

        for (String key : adjList.keySet()) {
            adjList.get(key).sort((a, b) ->
                tickets[a[0]][1].compareTo(tickets[b[0]][1])
            );
        }

        result = null;
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path);

        return result.toArray(new String[0]);
    }

    private void dfs(String current, List<String> path) {
        if (path.size() == tickets.length + 1) {
            if (result == null) result = new ArrayList<>(path);
            return;
        }
        if (!adjList.containsKey(current)) return;

        for (int[] entry : adjList.get(current)) {
            int ticketIdx = entry[0];
            if (used[ticketIdx]) continue; 

            used[ticketIdx] = true;  
            String dest = tickets[ticketIdx][1];
            path.add(dest);

            dfs(dest, path);
            if (result != null) return; 

            path.remove(path.size() - 1);
            used[ticketIdx] = false;
        }
    }
}