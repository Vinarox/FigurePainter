import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class LineSegment extends Figure1D {

	public LineSegment(){
		/*theCenter = new Point();
		vertex = new Point();*/
	}

	public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    Line2D l2 = new Line2D.Double(theCenter, vertex);
	    g2.draw(l2);
	}

	public ArrayList<Point> location(){
		ArrayList<Point> points = new ArrayList<>();
		points.add(theCenter);
		points.add(vertex);
		return points;
	}

	public void move(){

	}

}