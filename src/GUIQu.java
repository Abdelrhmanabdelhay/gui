import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIQu {
    private JButton enqueue;
    private JButton dequeue;
    private JPanel panel;
    private JTextArea texta;
    private JFrame frame;
    private queue q;
    int w;
    int h;

    public GUIQu(int w, int h) {
        this.w = w;
        this.h = h;
        enqueue = new JButton("enqueue");
        dequeue = new JButton("dequeue");
        panel = new JPanel(new FlowLayout());
        texta = new JTextArea();
        frame = new JFrame();
        q = new queue(5); // Initialize your queue with an appropriate size
    }

    public void runQ() {
        Container cp = frame.getContentPane();
        cp.setLayout(new BorderLayout());
        panel.add(enqueue);
        panel.add(dequeue);
        cp.add(panel, BorderLayout.WEST);
        cp.add(new JScrollPane(texta), BorderLayout.CENTER); // Wrap texta in a JScrollPane
        texta.setEditable(false);
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Queue");
        frame.setVisible(true);

        enqueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("enter value to enqueue");
                int n = Integer.parseInt(s);
                q.enqueue(n);
                updateQueueText();
            }
        });

        dequeue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!q.isEmpty()) {
                    q.dequeue(1);
                    updateQueueText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Queue is empty. Cannot dequeue.");
                }
            }
        });
    }

    private void updateQueueText() {
        StringBuilder queueText = new StringBuilder();

        for (int i = 0; i < q.size(); i++) {
            int item = q.dequeue(1);
            queueText.append(item).append(" -> ");
            q.enqueue(item);
        }

        queueText.append("null");
        texta.setText(queueText.toString());
    }

}
