import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainwindow {
    private JFrame mainFrame;
    private JButton stackButton;
    private JButton button;
    private JButton Que;
        private JButton tree;



    public mainwindow() {
        mainFrame = new JFrame("Main Window");
        stackButton = new JButton(" Stack ");
        button = new JButton("LinkedList");
        Que = new JButton("Queue");
        tree = new JButton("Tree");

        stackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStackWindow();
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenLin();

            }
        });
        Que.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               OpenQ();
            }
            
        });
        tree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new BSTVisualizer());
            }
            
        });
        mainFrame.setLayout(new FlowLayout()); // Set the layout to FlowLayout
        mainFrame.add(stackButton);
        mainFrame.add(button);
mainFrame.add(Que);
mainFrame.add(tree);
        mainFrame.setSize(600, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void openStackWindow() {
        
        GUIDemoStack stackWindow = new GUIDemoStack(400, 300);
        stackWindow.SetUp();
        stackWindow.SetUpbutton();
    }
    private void OpenLin(){
        GUIDemoLink l2=new GUIDemoLink(800, 300);
        l2.runLink();
    }
    private void OpenQ(){
        GUIQu q1=new GUIQu(400, 300);
        q1.runQ();
    }
}
