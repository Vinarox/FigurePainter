import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-март-2019 17:56:22
 */
public class Circle extends Ellipse {

	public Circle(){

	}

	public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = Math.abs(theCenter.x-additionalVertex.x);
        int y = Math.abs(theCenter.y-additionalVertex.y);
        int r = (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        g2.setColor(fillColor);
        g2.fillOval(theCenter.x - r, theCenter.y - r, 2*r, 2*r);
        g2.setColor(line_color);
        g2.drawOval(theCenter.x - r, theCenter.y - r, 2*r, 2*r);
	}

	public ArrayList<Point> location(){
		return null;
	}

	public void move(){

	}

}