import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Ray extends LineSegment {

    public Ray(){

    }

    public void draw(Graphics g){
        //super.draw(g);
        Graphics2D g2 = (Graphics2D) g;
        int tempx = vertex.x - theCenter.x;
        double cos = Math.abs(tempx) / Math.sqrt(Math.pow(vertex.x - theCenter.x, 2) + Math.pow(vertex.y - theCenter.y, 2));
        Point tempP = new Point();
        double newHip = 0;
        if(tempx > 0){//двигаемся вправо
            tempP.x = 984;
            newHip = (984 - theCenter.x) / cos;
        }
        else{//двигаемся влево
            tempP.x = 0;
            newHip = theCenter.x / cos;
        }
        if(theCenter.y < vertex.y)
            tempP.y = theCenter.y + (int)(newHip * (Math.sin(Math.acos(cos))));
        else
            tempP.y = theCenter.y - (int)(newHip * (Math.sin(Math.acos(cos))));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Line2D l2 = new Line2D.Double(theCenter, tempP);
        g2.draw(l2);
    }

}