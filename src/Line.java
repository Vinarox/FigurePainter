import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/**
 * @version 1.0
 * @created 03-����-2019 17:56:22
 */
public class Line extends Ray {

    public Line(){ }

    public void draw(Graphics g){
        //super.draw(g);
        Graphics2D g2 = (Graphics2D) g;
        int tempx = vertex.x - theCenter.x;
        double cos = Math.abs(tempx) / Math.sqrt(Math.pow(vertex.x - theCenter.x, 2) + Math.pow(vertex.y - theCenter.y, 2));
        Point tempP1 = new Point();
        Point tempP2 = new Point();
        double newHip1 = theCenter.x / cos;
        double newHip2 = (984 - theCenter.x) / cos;
        tempP1.x = 0;
        tempP2.x = 984;
        if(theCenter.y < vertex.y) {
            tempP1.y = theCenter.y - (int) (newHip1 * (Math.sin(Math.acos(cos))));
            tempP2.y = theCenter.y + (int) (newHip2 * (Math.sin(Math.acos(cos))));
        }
        else {
            tempP1.y = theCenter.y + (int) (newHip1 * (Math.sin(Math.acos(cos))));
            tempP2.y = theCenter.y - (int) (newHip2 * (Math.sin(Math.acos(cos))));
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Line2D l2 = new Line2D.Double(tempP1, tempP2);
        g2.draw(l2);
    }

    public static void draw(App app, Color fill, Color outline) {
        JPanel canvas = app.getCanvas();
        Line line = new Line();

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(line.theCenter == null){
                    line.theCenter = e.getPoint();
                   // line.theCenter.y -= 55;
                   // line.theCenter.x -= 10;
                    System.out.println("Первая точка: " + line.theCenter.x + " " + line.theCenter.y);
                }
                else{
                    line.vertex = e.getPoint();
                   // line.vertex.y -= 55;
                   // line.vertex.x -= 10;
                    System.out.println("Вторая точка: " + line.vertex.x + " " + line.vertex.y);
                    System.out.println("рисуем");
                    line.setColor(outline);
                    line.draw(canvas.getGraphics());
                    app.add(line);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }

}