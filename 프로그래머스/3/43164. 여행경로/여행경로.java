import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    static class Ticket {
        String departure;
        String arrival;

        public Ticket(String departure, String arrival) {
            this.departure = departure;
            this.arrival = arrival;
        }
    }

    private Ticket[] ticketList;
    private boolean[] used;
    private List<String> path;
    private List<String> answer;

    public List<String> solution(String[][] tickets) {
        ticketList = new Ticket[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            ticketList[i] = new Ticket(tickets[i][0], tickets[i][1]);
        }

        Arrays.sort(ticketList, (a, b) -> {
            if (!a.departure.equals(b.departure)) {
                return a.departure.compareTo(b.departure);
            }

            return a.arrival.compareTo(b.arrival);
        });

        used = new boolean[tickets.length];
        path = new ArrayList<>();
        answer = null;

        path.add("ICN");
        dfs("ICN", 0);
        return answer;
    }

    private boolean dfs(String current, int count) {
        if (count == ticketList.length) {
            answer = new ArrayList<>(path);
            return true;
        }

        for (int i = 0; i < ticketList.length; i++) {
            if (used[i]) {
                continue;
            }

            Ticket ticket = ticketList[i];
            if (!ticket.departure.equals(current)) {
                continue;
            }

            used[i] = true;
            path.add(ticket.arrival);

            if (dfs(ticket.arrival, count + 1)) {
                return true;
            }

            path.remove(path.size() - 1);
            used[i] = false;
        }

        return false;
    }
}