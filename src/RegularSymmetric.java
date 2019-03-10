import java.awt.*;
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

}