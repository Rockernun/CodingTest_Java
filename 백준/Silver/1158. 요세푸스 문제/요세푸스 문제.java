import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.addLast(i);
        }

        int nextIndex = 0;
        while (list.size != 0) {
            nextIndex = (nextIndex + (k - 1)) % list.size;
            result.add(list.remove(nextIndex));
        }

        String finalResult = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));
        System.out.println(finalResult);
    }

    static class Node {
        int element;
        Node next;

        public Node(int element) {
            this.element = element;
        }
    }

    static class MyLinkedList {
        Node head;
        int size = 0;

        Node getLastNode() {
            Node x = head;
            while (x.next != null) {
                x = x.next;
            }

            return x;
        }

        Node getNode(int index) {
            Node x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }

            return x;
        }


        void addLast(int element) {
            Node newNode = new Node(element);
            if (head == null) {
                head = newNode;
            } else {
                Node prevNode = getLastNode();
                prevNode.next = newNode;
            }

            this.size++;
        }

        int remove(int index) {
            Node removeNode = getNode(index);
            if (index == 0) {
                head = removeNode.next;
            } else {
                Node prevNode = getNode(index - 1);
                prevNode.next = removeNode.next;
            }

            this.size--;
            return removeNode.element;
        }
    }
}
