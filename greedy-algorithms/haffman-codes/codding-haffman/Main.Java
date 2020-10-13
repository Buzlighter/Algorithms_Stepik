import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Integer> freqAndLetters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (freqAndLetters.containsKey(k)) {
                freqAndLetters.put(k, freqAndLetters.get(k) + 1);
            } else {
                freqAndLetters.put(k, 1);
            }
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Map<Character, Node> charNode = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : freqAndLetters.entrySet()) {
            Leaf  node = new Leaf(entry.getKey(), entry.getValue());
            charNode.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int count = 0;
        if(freqAndLetters.size() == 1) {
            count+=s.length();
        }
        while(priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            count += node.priority;
            priorityQueue.add(node);
        }

        System.out.println(freqAndLetters.size() + " " + count);
        Node root = priorityQueue.poll();
        if(freqAndLetters.size() == 1) {
            root.buildCode("0");
        }
        else {
            root.buildCode("");
        }
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            encodedString.append(charNode.get(c).code);
        }
        System.out.println(encodedString.toString());
    }

    public static class Node implements Comparable<Node>{
        int priority = 0;
        String code;

        public void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
    public static class InternalNode extends Node {
        Node leftLeaf;
        Node rightLeaf;

        public InternalNode(Node leftLeaf, Node rightLeaf) {
            this.leftLeaf = leftLeaf;
            this.rightLeaf = rightLeaf;
            priority = leftLeaf.priority + rightLeaf.priority;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            leftLeaf.buildCode(code + "0");
            rightLeaf.buildCode(code + "1");
        }
    }
    public static class Leaf extends Node {
        char letter;

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            System.out.println(letter + ": " + code);
        }

        public Leaf(char letter, int frequency) {
            this.letter = letter;
            priority = frequency;
        }
    }
}