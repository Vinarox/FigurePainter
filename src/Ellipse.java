import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Ellipse extends Figure2D {

	protected Point additionalVertex;

	public Ellipse(){

	}

	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(fillColor);
		g2.fillOval(theCenter.x > additionalVertex.x ? additionalVertex.x : theCenter.x,
                theCenter.y > additionalVertex.y ? additionalVertex.y : theCenter.y,
                Math.abs(theCenter.x - additionalVertex.x),
                Math.abs(theCenter.y - additionalVertex.y));
		g2.setColor(line_color);
		g2.drawOval(theCenter.x > additionalVertex.x ? additionalVertex.x : theCenter.x,
                theCenter.y > additionalVertex.y ? additionalVertex.y : theCenter.y,
                Math.abs(theCenter.x - additionalVertex.x),
                Math.abs(theCenter.y - additionalVertex.y));
	}

	public Point getAdditionalVertex(){
		return null;
	}

	public ArrayList<Point> location(){
		return null;
	}

	public void move(int dx, int dy){

	}

	public void setAdditionalVertex(){

	}

	public static void draw(App app, Color fill, Color outline) {
		JPanel canvas = app.getCanvas();
		Ellipse ellipse = new Ellipse();

		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ellipse.theCenter == null){
					ellipse.theCenter = e.getPoint();
					ellipse.theCenter.y -= 55;
					ellipse.theCenter.x -= 10;
					System.out.println("Первая точка: " + ellipse.theCenter.x + " " + ellipse.theCenter.y);
				}
				else{
					ellipse.additionalVertex = e.getPoint();
					ellipse.additionalVertex.y -= 55;
					ellipse.additionalVertex.x -= 10;
					System.out.println("Вторая точка: " + ellipse.additionalVertex.x + " " + ellipse.additionalVertex.y);
					System.out.println("рисуем");
					ellipse.setColor(outline);
					ellipse.setFillColor(fill);
					ellipse.draw(canvas.getGraphics());
					app.add(ellipse);
					canvas.removeMouseListener(this);
				}
			}
		});
	}

}