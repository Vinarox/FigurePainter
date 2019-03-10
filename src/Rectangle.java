import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * @author fpm.koba
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Rectangle extends Polygon {

	protected Point additionalVertex;

	public Rectangle(){

	}

	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(fillColor);
		g2.fillRect(theCenter.x > additionalVertex.x ? additionalVertex.x : theCenter.x,
				theCenter.y > additionalVertex.y ? additionalVertex.y : theCenter.y,
				Math.abs(theCenter.x - additionalVertex.x),
				Math.abs(theCenter.y - additionalVertex.y));
		g2.setColor(line_color);
        g2.drawRect(theCenter.x > additionalVertex.x ? additionalVertex.x : theCenter.x,
                theCenter.y > additionalVertex.y ? additionalVertex.y : theCenter.y,
                Math.abs(theCenter.x - additionalVertex.x),
                Math.abs(theCenter.y - additionalVertex.y));
	}

	public ArrayList<Point> location(){
		return null;
	}

	public void move(){

	}

}