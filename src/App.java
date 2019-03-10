import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {
    private int Unit = 3;
    private JFrame window;
    private JPanel canvas;
    private JList<Figure> figureJList;
    private DefaultListModel<Figure> figuresListModel;
    private AppMenu appMenu;
    private Color fill, outline;

    public App() {
        window = new JFrame("Application");
        window.setLayout(new BorderLayout());
        canvas = new JPanel();
        figuresListModel = new DefaultListModel<>();
        figureJList = new JList<>(figuresListModel);
        appMenu = new AppMenu(this);
        fill = Color.WHITE;
        outline = Color.BLACK;
    }

    public void init() {
        appMenu.setup(this);
        window.setFocusable(true);
        canvas.setFocusable(true);
        window.add(figureJList, BorderLayout.WEST);
        window.add(canvas, BorderLayout.CENTER);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                //canvas.repaint();
                //onKeyEvent(keyEvent);
            }
        });
    }

    public void start() {
        init();
        figuresListModel.addElement(new Circle());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void setJMenuBar(JMenuBar bar) {
        window.setJMenuBar(bar);
    }

    private void moveAll(int dx, int dy) {
        canvas.repaint();
        for (Figure figure : figureJList.getSelectedValuesList()) {
            figure.move(dx, dy);
            figure.draw(getDrawingContext());
        }
    }

    private void onKeyEvent(KeyEvent keyEvent) {
        int dx = 0, dy = 0;
        int keyCode = keyEvent.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT: dx -= Unit; break;
            case KeyEvent.VK_RIGHT: dx += Unit; break;
            case KeyEvent.VK_UP: dy -= Unit; break;
            case KeyEvent.VK_DOWN: dy += Unit; break;
        }
        moveAll(dx, dy);
    }

    private Graphics getDrawingContext() {
        return canvas.getGraphics();
    }

    public void drawEllipse() {
        Ellipse.draw(this, fill, outline);
    }

    public void drawCircle() {
        Circle.draw(this, fill, outline);
    }

    public void drawLine() {
        Line.draw(this, fill, outline);
    }

    public void drawLineSegment() {
        LineSegment.draw(this, fill, outline);
    }

    public void drawRay() {
        Ray.draw(this, fill, outline);
    }

    public void drawPolygon() {
        Polygon.draw(this, fill, outline);
    }

    public void drawRectangle() {
        Rectangle.draw(this, fill, outline);
    }

    public void drawRegular() {
        RegularSymmetric.draw(this, fill, outline);
    }

    public void drawRhomb() {
        Rhomb.draw(this, fill, outline);
    }

    public void fillColor() {
        Color color = JColorChooser.showDialog(null, "Выберите цвет", Color.blue);
        fill = color;
    }

    public void outlineColor() {
        Color color = JColorChooser.showDialog(null, "Выберите цвет", Color.blue);
        outline = color;
    }

    public void add(Figure figure) {
        figuresListModel.addElement(figure);
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public void test() {
        for (Figure figure : figureJList.getSelectedValuesList()) {
            System.out.println(figure);
        }
        System.out.println(String.format("%d:%d", window.getWidth(), window.getHeight()));
    }

}
