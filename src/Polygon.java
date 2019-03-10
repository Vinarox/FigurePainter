import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Polygon extends Figure2D {

	protected ArrayList<Point> points;

	public Polygon(){
		points = new ArrayList<>();
	}

	public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int[] pointsX = new int[points.size()];
		int[] pointsY = new int[points.size()];

		for(int i = 0; i < points.size(); i++){
			pointsX[i] = points.get(i).x;
			pointsY[i] = points.get(i).y;
        }

		java.awt.Polygon poly = new java.awt.Polygon(pointsX, pointsY, points.size());

		g2.setColor(fillColor);
		g2.fillPolygon(poly);
        g2.setColor(line_color);
        g2.drawPolygon(poly);
    }

	public Point getVertex(){
		return null;
	}

	public ArrayList<Point> location(){
		return null;
	}

	public void move(){

	}

	public void setVertex(){

	}

}