package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;


public class RoundedTextField extends JTextField{
	private Shape shape;
	
	public RoundedTextField(int size) {
		super(size);
        setOpaque(false); // As suggested by @AVD in comment.
        setEditable(false);
        setBackground(new Color(31, 34, 38));
        setBorder(null);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        setForeground(Color.WHITE);
	}
	protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	}
	public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
	}
}
