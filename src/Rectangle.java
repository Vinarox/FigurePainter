import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    @Override
    public String toString() {
        return String.format("Rect: (%d,%d)", theCenter.x, theCenter.y);
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

	public void move(int dx, int dy){
        theCenter.x += dx; theCenter.y += dy;
        additionalVertex.x += dx; additionalVertex.y += dy;
	}

	public static void draw(App app, Color fill, Color outline) {
        JPanel canvas = app.getCanvas();
	    Rectangle rectangle = new Rectangle();

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(rectangle.theCenter == null){
                    rectangle.theCenter = e.getPoint();
                   // rectangle.theCenter.y -= 55;
                   // rectangle.theCenter.x -= 10;
                    System.out.println("Первая точка: " + rectangle.theCenter.x + " " + rectangle.theCenter.y);
                }
                else{
                    rectangle.additionalVertex = e.getPoint();
                  //  rectangle.additionalVertex.y -= 55;
                  //  rectangle.additionalVertex.x -= 10;
                    System.out.println("Вторая точка: " + rectangle.additionalVertex.x + " " + rectangle.additionalVertex.y);
                    System.out.println("рисуем");
                    rectangle.setColor(outline);
                    rectangle.setFillColor(fill);
                    rectangle.draw(canvas.getGraphics());
                    app.add(rectangle);
                    canvas.removeMouseListener(this);
                }
            }
        });
	}

}