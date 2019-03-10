import java.awt.*;
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

}