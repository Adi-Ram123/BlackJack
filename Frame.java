import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Frame extends JFrame
{
    private JFrame frame;
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

        
        
        //Display title at start
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(78, 106, 84));
        titlePanel.setLayout(null);
        frame.add(titlePanel);
        JLabel title = new JLabel("BLACKJACK");
        titlePanel.add(title);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.PLAIN, 60));
        title.setBounds(550, 200, 380, 200);
        // Border blackline = BorderFactory.createLineBorder(Color.black);
        // title.setBorder(blackline);
        JButton newRound = new JButton("New Round");
        titlePanel.add(newRound);
        newRound.setBounds(625, 400, 200, 100);
        newRound.setFont(new Font("Arial", Font.PLAIN, 30));
        newRound.setFocusable(false);
        
            
        
    }

    
}
