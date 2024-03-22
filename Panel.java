import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Font title = new Font("Arial", Font.PLAIN, 60);

    public Panel() {
        setSize(1500, 1000);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(78, 106, 84));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.setFont(title);
        g.drawString("BLACKJACK", 570, 300);
    }
}
