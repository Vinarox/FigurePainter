import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class RegularSymmetric extends Polygon {

	protected Point additionalVertex;
	protected int vertexNumber;

	public RegularSymmetric(){

	}

	protected void calculateVertexes(Graphics g){
		//считаем и заполняем ArrayList
		double r = Math.sqrt(Math.pow(theCenter.x - additionalVertex.x, 2) + Math.pow(theCenter.y - additionalVertex.y, 2));
		double alpha = 2*Math.PI/vertexNumber;
        double beta = Math.acos((theCenter.y - additionalVertex.y)/r);

        for(int i = 0; i < vertexNumber; i++){
            Point tempPoint = new Point();
		    tempPoint.x = (int)(r*Math.cos(alpha*i + alpha - Math.PI/2 - beta) + theCenter.x);
		    tempPoint.y = (int)(r*Math.sin(alpha*i + alpha - Math.PI/2 - beta) + theCenter.y);
		    points.add(tempPoint);
        }
		//рисуем
        draw(g);
	}

	public static void draw(App app, Color fill, Color outline) {
		RegularSymmetric regularSymmetric = new RegularSymmetric();
		JPanel canvas = app.getCanvas();
		regularSymmetric.vertexNumber = Integer.parseInt(JOptionPane.showInputDialog(canvas, "Введите количество вершин"));
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(regularSymmetric.theCenter == null){
					regularSymmetric.theCenter = e.getPoint();
					regularSymmetric.theCenter.y -= 55;
					regularSymmetric.theCenter.x -= 10;
					System.out.println("Первая точка: " + regularSymmetric.theCenter.x + " " + regularSymmetric.theCenter.y);
				}
				else{
					regularSymmetric.additionalVertex = e.getPoint();
					regularSymmetric.additionalVertex.y -= 55;
					regularSymmetric.additionalVertex.x -= 10;
					System.out.println("Вторая точка: " + regularSymmetric.additionalVertex.x + " " + regularSymmetric.additionalVertex.y);
					System.out.println("рисуем");
					regularSymmetric.setColor(outline);
					regularSymmetric.setFillColor(fill);
					regularSymmetric.calculateVertexes(canvas.getGraphics());
					app.add(regularSymmetric);
					canvas.removeMouseListener(this);
				}
			}
		});
	}

}