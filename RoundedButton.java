import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private Color normalColor;
    private Color hoverColor;

    public RoundedButton(String text,
                         Color normalColor,
                         Color hoverColor) {

        super(text);

        this.normalColor = normalColor;
        this.hoverColor = hoverColor;

// Button text
        setFont(new Font("SansSerif", Font.BOLD, 14));
        setForeground(Color.WHITE);

// Remove default button appearance
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

// Initial color
        setBackground(normalColor);

// Mouse cursor
        setCursor(new Cursor(Cursor.HAND_CURSOR));

// Hover effect
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

// Smooth edges
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

// Draw rounded button
        g2.setColor(getBackground());

        g2.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                25,
                25
        );

        g2.dispose();

// Draw the button text
        super.paintComponent(g);
    }
}

