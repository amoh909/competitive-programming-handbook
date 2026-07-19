## Level Order Traversal (Breadth First Search)

Level Order Traversal technique is a method to traverse a Tree such that all nodes present in the same level are traversed completely before traversing the next level.

### Java implementation Using Recursion

The idea is to traverse the tree recursively, starting from the root at level 0. When a node is visited, its value is added to the result array at the index corresponding to its level, and then its left and right children are recursively processed in the same way. This effectively performs a level-order traversal using recursion.

```java
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}

public class GfG {
    void levelOrderRec(Node root, int level,
                       ArrayList<ArrayList<Integer>> res)
    {
        // Base case
        if (root == null)
            return;

        // Add a new level to the result if needed
        if (res.size() <= level)
            res.add(new ArrayList<>());

        // Add current node's data to its corresponding
        // level
        res.get(level).add(root.data);

        // Recur for left and right children
        levelOrderRec(root.left, level + 1, res);
        levelOrderRec(root.right, level + 1, res);
    }

    // Function to perform level order traversal
    ArrayList<ArrayList<Integer>> levelOrder(Node root)
    {

        // Stores the result level by level
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        levelOrderRec(root, 0, res);
        return res;
    }
}
```

### Complexity

```text
Time: O(n)
Space: O(n)
```

### Java implementation Using Queue (Iterative)

The idea is to use a queue to traverse the tree level by level. Start by adding the root to the queue. Then, repeatedly remove a node from the queue, store its value in the result, and add its left and right children to the queue. Continue this process until the queue is empty.


```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;
    Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}

// Iterative method to perform level order traversal
    public static ArrayList<ArrayList<Integer>> levelOrder(Node root)
    {
        if (root == null)
            return new ArrayList<>();

        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Enqueue Root
        q.offer(root);
        int currLevel = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                // Add front of queue and remove it from
                // queue
                Node node = q.poll();
                res.get(currLevel).add(node.data);

                // Enqueue left child
                if (node.left != null)
                    q.offer(node.left);

                // Enqueue right child
                if (node.right != null)
                    q.offer(node.right);
            }
            currLevel++;
        }
        return res;
    }
```

### Complexity

```text
Time: O(n)
Space: O(n)
```

## DFS Traversal 

### InOrder Traversal Java Implementation

Traverse the left subtree, i.e., call Inorder(left-subtree)
Visit the root
Traverse the right subtree, i.e., call Inorder(right-subtree)


```java
class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

```

### Complexity

```text
Time: O(n)
Space: O(log(n))
```