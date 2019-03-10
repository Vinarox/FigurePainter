import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-март-2019 17:56:22
 */
public class Circle extends Ellipse {

	public Circle(){

	}

	@Override
	public String toString() {
		return String.format("Circle:(%d,%d)", theCenter.x, theCenter.y);
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

	public static void draw(App app, Color fill, Color outline) {
		JPanel canvas = app.getCanvas();
	    Circle circle = new Circle();

		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(circle.theCenter == null){
					circle.theCenter = e.getPoint();
				//	circle.theCenter.y -= 55;
				//	circle.theCenter.x -= 10;
					System.out.println("Первая точка: " + circle.theCenter.x + " " + circle.theCenter.y);
				}
				else{
					circle.additionalVertex = e.getPoint();
				//	circle.additionalVertex.y -= 55;
				//	circle.additionalVertex.x -= 10;
					System.out.println("Вторая точка: " + circle.additionalVertex.x + " " + circle.additionalVertex.y);
					System.out.println("рисуем");
					circle.setColor(outline);
					circle.setFillColor(fill);
					circle.draw(canvas.getGraphics());
					app.add(circle);
					canvas.removeMouseListener(this);
				}
			}
		});
	}

}