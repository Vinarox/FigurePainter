import javax.swing.*;

public class AppMenu {

    private App app;
    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu jMenu = new JMenu("Фигура");
    private JMenu fig1d = new JMenu("Одномерная");
    private JMenu fig2d = new JMenu("Двумерная");
    private JMenu col = new JMenu("Цвет");
    private JMenuItem lineSegment = new JMenuItem("Отрезок");
    private JMenuItem ray = new JMenuItem("Луч");
    private JMenuItem line = new JMenuItem("Прямая");
    private JMenuItem ellipse = new JMenuItem("Эллипс");
    private JMenuItem circle = new JMenuItem("Круг");
    private JMenuItem polygon = new JMenuItem("Полигон");
    private JMenuItem rectangle = new JMenuItem("Прямоугольник");
    private JMenuItem regularSymmetric = new JMenuItem("Правильный");
    private JMenuItem rhomb = new JMenuItem("Ромб");
    private JMenuItem line_col = new JMenuItem("Контур");
    private JMenuItem fill_col = new JMenuItem("Заливка");
    private JMenuItem test = new JMenuItem("test");

    AppMenu(App app) {
        this.app = app;
        jMenuBar.add(jMenu);
        jMenuBar.add(col);
        jMenu.add(fig1d);
        jMenu.add(fig2d);
        fig1d.add(lineSegment);
        fig1d.add(ray);
        fig1d.add(line);
        fig2d.add(ellipse);
        fig2d.add(circle);
        fig2d.add(polygon);
        fig2d.add(rectangle);
        fig2d.add(regularSymmetric);
        fig2d.add(rhomb);
        col.add(line_col);
        col.add(fill_col);
        col.add(test);
        lineSegment.addActionListener(x -> app.drawLineSegment());
        ray.addActionListener(x -> app.drawRay());
        line.addActionListener(x -> app.drawLine());
        ellipse.addActionListener(x -> app.drawEllipse());
        circle.addActionListener(x -> app.drawCircle());
        polygon.addActionListener(x -> app.drawPolygon());
        rectangle.addActionListener(x -> app.drawRectangle());
        regularSymmetric.addActionListener(x -> app.drawRegular());
        rhomb.addActionListener(x -> app.drawRhomb());
        line_col.addActionListener(x -> app.outlineColor());
        fill_col.addActionListener(x -> app.fillColor());
        test.addActionListener(x -> app.test());
    }

    public void setup(App app) {
        app.setJMenuBar(jMenuBar);
    }

}
