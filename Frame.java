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
    private JPanel dealerBar;
    private JLabel dealerTotal;
    private JPanel profitBar;
    private JLabel profit;
    private JLabel msg;
    private JTextField status;

    private ImageIcon back;
    private ImageIcon A;

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
        loadImages();
        createTitle();
        

    }

    private void createTitle() {
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

    private void loadImages() {
        back = new ImageIcon("Assets\\back.png");
        A = new ImageIcon("Assets\\A.png");
    }

    private JLabel drawCard(int x, int y, int width, int height, String name) {
        JLabel card = new JLabel();

        switch(name) {
            case "back":
                card.setIcon(back);
                break;
            case "A":
                card.setIcon(A);
                break;
        }

        card.setBounds(x, y, width, height);
        card.setBorder(BorderFactory.createEtchedBorder());
        System.out.println(x + ", " + y);

        return card;

    }

    private void mainPanel() {
        mainPanel.setBackground(new Color(78, 106, 84));
        mainPanel.setLayout(null);
        

        //Dealer Total
        dealerTotal = new JLabel("Total: S16");
        dealerTotal.setFont(new Font("Arial", Font.PLAIN, 30));
        dealerTotal.setForeground(Color.BLACK);
        dealerTotal.setBounds(20, 30, frame.getWidth()/4, 50);
        mainPanel.add(dealerTotal);

        //Dealer bar
        dealerBar = new JPanel();
        dealerBar.setBackground(Color.WHITE);
        dealerBar.setBounds(0, 0, frame.getWidth()/4 - 50, 125);
        mainPanel.add(dealerBar);

        //Dealer cards
        JLabel open = drawCard(3 * frame.getWidth()/4 - 150, 20, 150, 200, "A");
        JLabel faceDown = drawCard(3 * frame.getWidth()/4 - 310, 20, 150, 200, "back");
        mainPanel.add(faceDown);
        mainPanel.add(open);

        //Profit
        profit = new JLabel("Profit: $9999");
        profit.setFont(new Font("Arial", Font.PLAIN, 30));
        profit.setForeground(new Color(35, 158, 55));
        profit.setBounds(1300, 30, frame.getWidth()/4, 50);
        mainPanel.add(profit);

        //Profit Bar
        profitBar = new JPanel();
        profitBar.setBackground(Color.WHITE);
        profitBar.setBounds(3 * frame.getWidth()/4 + 50, 0, frame.getWidth()/4 - 50, 125);
        mainPanel.add(profitBar);





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
        status.addActionListener(this);
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
        
        if(e.getSource() == status) {
            msg.setText(status.getText() + ": ");
        }
    }

    
}
