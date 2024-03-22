import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel titlePanel;
    private JButton newRound;
    private JPanel mainPanel;
    private JLabel msg;
    private JTextField status;

    public Frame(String frameName)
    {
        //Initial frame setup
        frame = new JFrame();
        frame.setTitle(frameName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        titlePanel = new JPanel();
        mainPanel = new JPanel();
        mainPanel.setEnabled(false);
        mainPanel.setVisible(false);
        createTitle();

    }

    public void createTitle() {
        //Display title at start
        titlePanel.setBackground(new Color(78, 106, 84));
        titlePanel.setLayout(null);
        JLabel title = new JLabel("BLACKJACK");
        titlePanel.add(title);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.PLAIN, 60));
        title.setBounds(575, 200, 380, 200);
        newRound = new JButton("New Round");
        titlePanel.add(newRound);
        newRound.setBounds(650, 400, 200, 100);
        newRound.setFont(new Font("Arial", Font.PLAIN, 30));
        newRound.setFocusable(false);
        newRound.addActionListener(this);
        titlePanel.setEnabled(true);
        titlePanel.setVisible(true);
        frame.add(titlePanel);
        

    }

    public void mainPanel() {
        mainPanel.setBackground(new Color(78, 106, 84));
        mainPanel.setLayout(null);
        
        
        
        
        //Status msg
        msg = new JLabel("Double Down (y or n):");
        msg.setFont(new Font("Arial", Font.PLAIN, 30));
        msg.setForeground(Color.BLACK);
        msg.setBounds(20, frame.getHeight() - 110, frame.getWidth()/4, 50);
        mainPanel.add(msg);

        //User status response
        status = new JTextField();
        status.setFont(new Font("Arial", Font.PLAIN, 30));
        status.setForeground(Color.BLACK);
        status.setMargin(new Insets(5, 5, 5, 5));
        status.setBounds(frame.getWidth()/4, frame.getHeight()-110, 3* frame.getWidth()/4 - 50, 50);
        mainPanel.add(status);
        
        //Status bar
        JPanel statusBar = new JPanel();
        statusBar.setBackground(Color.WHITE);
        statusBar.setBounds(0, frame.getHeight()-125, frame.getWidth(), 125);
        mainPanel.add(statusBar);
        
        

        mainPanel.setEnabled(true);
        mainPanel.setVisible(true);
        frame.add(mainPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newRound) {
            titlePanel.setEnabled(false);
            titlePanel.setVisible(false);
            mainPanel();
            System.out.println("Selected New Round");
        } 
    }

    
}
