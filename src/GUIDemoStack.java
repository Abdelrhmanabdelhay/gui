import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIDemoStack {
    private JButton button1;
    JTextArea textArea;
    private JButton button2;
    private JButton button3;

    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private Stack s;
    private int w;
    private int h;

    GUIDemoStack(int wid, int he) {
        frame = new JFrame();
        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        textArea = new JTextArea();
        button1 = new JButton("push");
        button2 = new JButton("remove");
        button3 = new JButton("Pop");

        w = wid;
        h = he;
        s = new Stack(10);
    }

    public void SetUp() {
        Container cp = frame.getContentPane();
        BorderLayout bord = new BorderLayout();
        textArea.setEditable(false);
        panel.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        cp.setLayout(bord);
        cp.add(textArea, BorderLayout.CENTER);
        cp.add(panel, BorderLayout.WEST);
        cp.add(panel2, BorderLayout.EAST);
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Stack");
        frame.setVisible(true);
    }

    public void SetUpbutton() {
        ActionListener buttonlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();
                if (o == button1) {
                    String pus = JOptionPane.showInputDialog("Enter number to Push");
                    if (pus != null) {
                        try {
                            int n = Integer.parseInt(pus);
                            s.push(n);
                            updateStackText();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                        }
                    }
                } else if (o == button2) {
                    String rem = JOptionPane.showInputDialog("Enter number to remove");
                    if (!s.isEmpty()) {
                        int n2 = Integer.parseInt(rem);
                        s.remove(n2);
                        updateStackText();
                    }
                } else if (o == button3) {
                    if (!s.isEmpty()) {
                        s.pop();
                        updateStackText();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Stack is empty. Cannot pop.");
                    }
                }
            }
        };
        button1.addActionListener(buttonlistener);
        button2.addActionListener(buttonlistener);
        button3.addActionListener(buttonlistener);
    }

    void updateStackText() {
        StringBuilder stackText = new StringBuilder();

        // Using a simple for loop to iterate through each element in the stack
        for (int i = 0; i <= s.top; i++) {
            // Get the current element at index i
            int element = s.arrs[i];

            // Append the current element and add a newline character ("\n") for formatting
            stackText.append(element).append("\n");
        }

        textArea.setText(stackText.toString());
    }
}
