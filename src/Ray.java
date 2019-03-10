import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Ray extends LineSegment {

    public Ray(){

    }

    @Override
    public String toString() {
        return String.format("Ray: (%d, %d):(%d, %d)", theCenter.x, theCenter.y, vertex.x, vertex.y);
    }

    public void draw(Graphics g){
        //super.draw(g);
        Graphics2D g2 = (Graphics2D) g;
        int tempx = vertex.x - theCenter.x;
        double cos = Math.abs(tempx) / Math.sqrt(Math.pow(vertex.x - theCenter.x, 2) + Math.pow(vertex.y - theCenter.y, 2));
        Point tempP = new Point();
        double newHip = 0;
        if(tempx > 0){//двигаемся вправо
            tempP.x = 2000;
            newHip = (2000 - theCenter.x) / cos;
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

    public static void draw(App app, Color fill, Color outline) {
        Ray ray = new Ray();
        JPanel canvas = app.getCanvas();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(ray.theCenter == null){
                    ray.theCenter = e.getPoint();
                  //  ray.theCenter.y -= 55;
                //    ray.theCenter.x -= 10;
                    System.out.println("Первая точка: " + ray.theCenter.x + " " + ray.theCenter.y);
                }
                else {
                    ray.vertex = e.getPoint();
                //    ray.vertex.y -= 55;
                //    ray.vertex.x -= 10;
                    System.out.println("Вторая точка: " + ray.vertex.x + " " + ray.vertex.y);
                    System.out.println("рисуем");
                    ray.setColor(outline);
                    ray.draw(canvas.getGraphics());
                    app.add(ray);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }

}