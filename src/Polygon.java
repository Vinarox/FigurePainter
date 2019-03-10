import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	public void move(int dx, int dy){

	}

	public void setVertex(){

	}

	public static void draw(App app, Color fill, Color outline) {
		JPanel canvas = app.getCanvas();
		Polygon polygon = new Polygon();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == 1){//левая
					System.out.println("Точка: " + e.getX() + " " + e.getY());
					Point temp = e.getPoint();
					temp.y -= 55;
					temp.x -= 10;
					polygon.points.add(temp);
				}
				if(e.getButton() == 3){//правая
					System.out.println("рисуем");
					polygon.setColor(outline);
					polygon.setFillColor(fill);
					polygon.draw(canvas.getGraphics());
					app.add(polygon);
					canvas.removeMouseListener(this);
				}
			}
		});
		//return polygon;
	}

}