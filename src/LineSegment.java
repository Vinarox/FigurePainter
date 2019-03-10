import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	public void move(int dx, int dy){

	}

	public static void draw(App app, Color fill, Color outline) {
		JPanel canvas = app.getCanvas();
		LineSegment lineSegment = new LineSegment();

		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lineSegment.theCenter == null){
					lineSegment.theCenter = e.getPoint();
				//	lineSegment.theCenter.y -= 55;
					//lineSegment.theCenter.x -= 10;
					System.out.println("Первая точка: " + lineSegment.theCenter.x + " " + lineSegment.theCenter.y);
				}
				else{
					lineSegment.vertex = e.getPoint();
				//	lineSegment.vertex.y -= 55;
				//	lineSegment.vertex.x -= 10;
					System.out.println("Вторая точка: " + lineSegment.vertex.x + " " + lineSegment.vertex.y);
					System.out.println("рисуем");
					lineSegment.setColor(outline);
					lineSegment.draw(canvas.getGraphics());
					app.add(lineSegment);
					canvas.removeMouseListener(this);
				}
			}
		});
	}

}