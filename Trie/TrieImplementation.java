import java.util.ArrayList;
import java.util.List;

class Node {
    // Array to store child references
    Node[] links = new Node[26];

    // Flag to mark end of word
    boolean flag = false;

    // Check if a node contains a character
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Insert a node for character
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Get the node for a character
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Mark end of word
    void setEnd() {
        flag = true;
    }

    // Check if it is end of word
    boolean isEnd() {
        return flag;
    }
}

class Trie {
    private Node root;

    // Constructor
    public Trie() {
        root = new Node();
    }

    // Insert Word
    public void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // Search word
    public boolean search(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }

    // Check Prefix
    public boolean startsWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}

public class TrieImplementation {
    public static void main(String[] args) {
        Trie trie = new Trie();

        String[] operations = {
            "Trie", "insert", "search", "search", "startsWith", "insert", "search"
        };

        String[][] arguments = {
            {},
            {"apple"},
            {"apple"},
            {"app"},
            {"app"},
            {"app"},
            {"app"},
        };

        List<String> output = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie":
                    output.add("null");
                    break;

                case "insert":
                    trie.insert(arguments[i][0]);
                    output.add("null");
                    break;

                case "search":
                    output.add(trie.search(arguments[i][0]) ? "true" : "false");
                    break;

                case "startsWith":
                    output.add(trie.startsWith(arguments[i][0]) ? "true" : "false");
                    break;
            }
        }

        for (String res : output) {
            System.out.println(res);
        }
    }
}
