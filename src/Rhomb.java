import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Rhomb extends Polygon {

	protected Point additionalVertex;

	public Rhomb(){

	}

	public void draw(Graphics g){
        //считаем и заполняем ArrayList
        int x = Math.abs(theCenter.x - additionalVertex.x);
        int y = Math.abs(theCenter.y - additionalVertex.y);
        points.add(new Point(theCenter.x, theCenter.y + y));
        points.add(new Point(theCenter.x - x, theCenter.y));
        points.add(new Point(theCenter.x, theCenter.y - y));
        points.add(new Point(theCenter.x + x, theCenter.y));
        //рисуем
        super.draw(g);
	}

	public ArrayList<Point> location(){
		return null;
	}

	public void move(){

	}

	public static void draw(App app, Color fill, Color outline) {
		Rhomb rhomb = new Rhomb();
		JPanel canvas = app.getCanvas();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rhomb.theCenter == null){
					rhomb.theCenter = e.getPoint();
					rhomb.theCenter.y -= 55;
					rhomb.theCenter.x -= 10;
					System.out.println("Первая точка: " + rhomb.theCenter.x + " " + rhomb.theCenter.y);
				}
				else{
					rhomb.additionalVertex = e.getPoint();
					rhomb.additionalVertex.y -= 55;
					rhomb.additionalVertex.x -= 10;
					System.out.println("Вторая точка: " + rhomb.additionalVertex.x + " " + rhomb.additionalVertex.y);
					System.out.println("рисуем");
					rhomb.setColor(outline);
					rhomb.setFillColor(fill);
					rhomb.draw(canvas.getGraphics());
					app.add(rhomb);
					canvas.removeMouseListener(this);
				}
			}
		});
		//return rhomb;
	}

}