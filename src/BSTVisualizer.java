import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}



class BSTVisualizer extends JFrame {
    public BinarySearchTree bst;

    public BSTVisualizer() {
        bst = new BinarySearchTree();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("BST Visualizer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        BSTPanel bstPanel = new BSTPanel();
        add(bstPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Node");
        JButton removeButton = new JButton("Remove Node");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog("Enter node value:"));
                bst.insert(value);
                bstPanel.repaint();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog("Enter node value to remove:"));
                bst.remove(value);
                bstPanel.repaint();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class BSTPanel extends JPanel {
        private final int nodeRadius = 20;
        private final int xOffset = 80;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTree(g, getWidth() / 2, 30, bst.getRoot(), xOffset);
        }

        private void drawTree(Graphics g, int x, int y, Node root, int xOffset) {
    if (root != null) {
        g.drawOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
        g.drawString(String.valueOf(root.data), x, y);

        if (root.left != null) {
            int childX = x - xOffset;
            drawLine(g, x, y + nodeRadius, childX, y + 60 - nodeRadius);
            drawTree(g, childX, y + 60, root.left, xOffset / 2);
        }

        if (root.right != null) {
            int childX = x + xOffset;
            drawLine(g, x, y + nodeRadius, childX, y + 60 - nodeRadius);
            drawTree(g, childX, y + 60, root.right, xOffset / 2);
        }
    }
}


        private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
