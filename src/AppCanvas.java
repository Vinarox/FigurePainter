import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AppCanvas extends JPanel {
    private List<Figure> figures = new ArrayList<>();

    public void add(Figure figure) {
        figures.add(figure);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Figure figure : figures) {
            figure.draw(graphics);
        }

    }
}
