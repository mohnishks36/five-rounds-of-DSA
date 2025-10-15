/*
 297. Serialize and Deserialize Binary Tree
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeDeserealize {
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] order = data.split(",");
        index = 0;
        return deserializeHelper(order);
    }

    private TreeNode deserializeHelper(String[] order) {
        if (index >= order.length || order[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(order[index]));
        index++;
        root.left = deserializeHelper(order);
        root.right = deserializeHelper(order);

        return root;
    }
}
