import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public abstract class Figure {

	protected Color line_color;
	protected Point theCenter;

	public Figure(){

	}

	public abstract void draw(Graphics g);

	public Point getCenter(){
		return null;
	}

	public Color getLineColor(){
		return null;
	}

	public abstract ArrayList<Point> location();

	public abstract void move(int dx, int dy);

	public void setCenter(){

	}

	public void setColor(Color color){
		line_color = color;
	}

}