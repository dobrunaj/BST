import java.util.Scanner;
import java.util.StringTokenizer;

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, String data) {
        if (current == null) {
            return new Node(data);
        }
        if (data.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, data);
        } else {
            
        }
        return current;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node current) {
        if (current != null) {
            inorderRecursive(current.left);
            System.out.print(current.data + " ");
            inorderRecursive(current.right);
        }
    }
    
     public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preorderRecursive(current.left);
            preorderRecursive(current.right);
        }
    }
    
      public void postorder() {
        postorderRecursive(root);
    }

    private void postorderRecursive(Node current) {
        if (current != null) {
            postorderRecursive(current.left);
            postorderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("Enter a sentence: ");
        String input = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            tree.insert(token);
        }

        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();
        
         System.out.print("Preorder traversal: ");
        tree.preorder();
        System.out.println();
        
        System.out.print("Postorder traversal: ");
        tree.postorder();
        
    }
}
