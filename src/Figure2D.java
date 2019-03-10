import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public abstract class Figure2D extends Figure {

	protected Color fillColor;

	public Figure2D(){

	}

	public Color getFillColor(){
		return fillColor;
	}

	public void setFillColor(Color color){
	    fillColor = color;
	}

}