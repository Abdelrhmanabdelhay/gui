import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDemoLink {
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;

    private JTextArea texta;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;


    private LinkedList linkedList; // Assuming you have a linkedlist class

    int w;
    int h;

    GUIDemoLink(int width, int height) {
        w = width;
        h = height;
        frame = new JFrame();
        panel = new JPanel(new FlowLayout());
        panel2=new JPanel(new FlowLayout());
        texta = new JTextArea();
        button1 = new JButton("insertf");
        button2 = new JButton("insertlast");
        button3 = new JButton("insert at postion" );
        button4 = new JButton("remove" );


        linkedList = new LinkedList(); // Initialize your linked list here
    }

    public void runLink() {
        Container cp = frame.getContentPane();
        BorderLayout bdr = new BorderLayout();
        texta.setEditable(false);
        cp.setLayout(bdr);
        panel.add(button1);
        panel.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        cp.add(new JScrollPane(texta), BorderLayout.CENTER); // Wrap texta in a JScrollPane
        cp.add(panel, BorderLayout.WEST);
        cp.add(panel2, BorderLayout.EAST);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("enter number to insert");
                int n = Integer.parseInt(s);
                linkedList.insertf(n);
                updateLinkedListText();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("enter number to insertlast");
                int n = Integer.parseInt(s);
                linkedList.inserte(n);
                updateLinkedListText();
            }
        });
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("enter number to insert at postion ");
                String s1 = JOptionPane.showInputDialog("enter the postion number");
                int n1 = Integer.parseInt(s1);
                int n = Integer.parseInt(s);
                linkedList.insertatPos(n1, n);
                updateLinkedListText();
            }
            
        } );

        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("enter number to remove ");
                int n = Integer.parseInt(s);
                linkedList.remove(n);
                updateLinkedListText();

            }
            
        });
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Linked List");
        frame.setVisible(true);
    }
private void updateLinkedListText() {
    StringBuilder linkedListText = new StringBuilder();

    LinkedList.Node curr = linkedList.head;
    while (curr != null) {
        linkedListText.append(curr.item).append(" -> ");
        curr = curr.next;
    }

    linkedListText.append("null");
    texta.setText(linkedListText.toString());
    
}


   
}
