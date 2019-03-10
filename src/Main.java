import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    JFrame jFrame;
    Color line_color, fill_color;
    Main(){
        super("Рисовалка");
        setBounds(300, 100, 1000, 500);

        jFrame = this;

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Фигура");
        JMenu fig1d = new JMenu("Одномерная");
        JMenu fig2d = new JMenu("Двумерная");
        JMenu col = new JMenu("Цвет");
        JMenuItem lineSegment = new JMenuItem("Отрезок");
        JMenuItem ray = new JMenuItem("Луч");
        JMenuItem line = new JMenuItem("Прямая");
        JMenuItem ellipse = new JMenuItem("Эллипс");
        JMenuItem circle = new JMenuItem("Круг");
        JMenuItem polygon = new JMenuItem("Полигон");
        JMenuItem rectangle = new JMenuItem("Прямоугольник");
        JMenuItem regularSymmetric = new JMenuItem("Правильный");
        JMenuItem rhomb = new JMenuItem("Ромб");
        JMenuItem line_col = new JMenuItem("Контур");
        JMenuItem fill_col = new JMenuItem("Заливка");
        JMenuItem test = new JMenuItem("test");

        setJMenuBar(jMenuBar);
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

        JPanel jPanel = new JPanel();
        add(jPanel);

        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jFrame.getHeight());
                System.out.println(jPanel.getHeight());
            }
        });

        line_col.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(jPanel, "Выберите цвет", Color.blue);
                line_color = color;
            }
        });

        fill_col.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(jPanel, "Выберите цвет", Color.blue);
                fill_color = color;
            }
        });

        lineSegment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LineSegment lineSegment = new LineSegment();

                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(lineSegment.theCenter == null){
                            lineSegment.theCenter = e.getPoint();
                            lineSegment.theCenter.y -= 55;
                            lineSegment.theCenter.x -= 10;
                            System.out.println("Первая точка: " + lineSegment.theCenter.x + " " + lineSegment.theCenter.y);
                        }
                        else{
                            lineSegment.vertex = e.getPoint();
                            lineSegment.vertex.y -= 55;
                            lineSegment.vertex.x -= 10;
                            System.out.println("Вторая точка: " + lineSegment.vertex.x + " " + lineSegment.vertex.y);
                            System.out.println("рисуем");
                            lineSegment.setColor(line_color);
                            lineSegment.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        ray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ray ray = new Ray();

                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(ray.theCenter == null){
                            ray.theCenter = e.getPoint();
                            ray.theCenter.y -= 55;
                            ray.theCenter.x -= 10;
                            System.out.println("Первая точка: " + ray.theCenter.x + " " + ray.theCenter.y);
                        }
                        else{
                            ray.vertex = e.getPoint();
                            ray.vertex.y -= 55;
                            ray.vertex.x -= 10;
                            System.out.println("Вторая точка: " + ray.vertex.x + " " + ray.vertex.y);
                            System.out.println("рисуем");
                            ray.setColor(line_color);
                            ray.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Line line = new Line();

                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(line.theCenter == null){
                            line.theCenter = e.getPoint();
                            line.theCenter.y -= 55;
                            line.theCenter.x -= 10;
                            System.out.println("Первая точка: " + line.theCenter.x + " " + line.theCenter.y);
                        }
                        else{
                            line.vertex = e.getPoint();
                            line.vertex.y -= 55;
                            line.vertex.x -= 10;
                            System.out.println("Вторая точка: " + line.vertex.x + " " + line.vertex.y);
                            System.out.println("рисуем");
                            line.setColor(line_color);
                            line.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        ellipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ellipse ellipse = new Ellipse();

                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(ellipse.theCenter == null){
                            ellipse.theCenter = e.getPoint();
                            ellipse.theCenter.y -= 55;
                            ellipse.theCenter.x -= 10;
                            System.out.println("Первая точка: " + ellipse.theCenter.x + " " + ellipse.theCenter.y);
                        }
                        else{
                            ellipse.additionalVertex = e.getPoint();
                            ellipse.additionalVertex.y -= 55;
                            ellipse.additionalVertex.x -= 10;
                            System.out.println("Вторая точка: " + ellipse.additionalVertex.x + " " + ellipse.additionalVertex.y);
                            System.out.println("рисуем");
                            ellipse.setColor(line_color);
                            ellipse.setFillColor(fill_color);
                            ellipse.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle circle = new Circle();

                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(circle.theCenter == null){
                            circle.theCenter = e.getPoint();
                            circle.theCenter.y -= 55;
                            circle.theCenter.x -= 10;
                            System.out.println("Первая точка: " + circle.theCenter.x + " " + circle.theCenter.y);
                        }
                        else{
                            circle.additionalVertex = e.getPoint();
                            circle.additionalVertex.y -= 55;
                            circle.additionalVertex.x -= 10;
                            System.out.println("Вторая точка: " + circle.additionalVertex.x + " " + circle.additionalVertex.y);
                            System.out.println("рисуем");
                            circle.setColor(line_color);
                            circle.setFillColor(fill_color);
                            circle.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rectangle = new Rectangle();

                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(rectangle.theCenter == null){
                            rectangle.theCenter = e.getPoint();
                            rectangle.theCenter.y -= 55;
                            rectangle.theCenter.x -= 10;
                            System.out.println("Первая точка: " + rectangle.theCenter.x + " " + rectangle.theCenter.y);
                        }
                        else{
                            rectangle.additionalVertex = e.getPoint();
                            rectangle.additionalVertex.y -= 55;
                            rectangle.additionalVertex.x -= 10;
                            System.out.println("Вторая точка: " + rectangle.additionalVertex.x + " " + rectangle.additionalVertex.y);
                            System.out.println("рисуем");
                            rectangle.setColor(line_color);
                            rectangle.setFillColor(fill_color);
                            rectangle.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        polygon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polygon polygon = new Polygon();
                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getButton() == 1){//левая
                            System.out.println("Точка: " + e.getX() + " " + e.getY());
                            Point temp = e.getPoint();
                            temp.y -= 55;
                            temp.x -= 10;
                            polygon.points.add(temp);
                        }
                        if(e.getButton() == 3){//правая
                            System.out.println("рисуем");
                            polygon.setColor(line_color);
                            polygon.setFillColor(fill_color);
                            polygon.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        regularSymmetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegularSymmetric regularSymmetric = new RegularSymmetric();
                regularSymmetric.vertexNumber = Integer.parseInt(JOptionPane.showInputDialog(jPanel, "Введите количество вершин"));
                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(regularSymmetric.theCenter == null){
                            regularSymmetric.theCenter = e.getPoint();
                            regularSymmetric.theCenter.y -= 55;
                            regularSymmetric.theCenter.x -= 10;
                            System.out.println("Первая точка: " + regularSymmetric.theCenter.x + " " + regularSymmetric.theCenter.y);
                        }
                        else{
                            regularSymmetric.additionalVertex = e.getPoint();
                            regularSymmetric.additionalVertex.y -= 55;
                            regularSymmetric.additionalVertex.x -= 10;
                            System.out.println("Вторая точка: " + regularSymmetric.additionalVertex.x + " " + regularSymmetric.additionalVertex.y);
                            System.out.println("рисуем");
                            regularSymmetric.setColor(line_color);
                            regularSymmetric.setFillColor(fill_color);
                            regularSymmetric.calculateVertexes(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        rhomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rhomb rhomb = new Rhomb();
                jFrame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(rhomb.theCenter == null){
                            rhomb.theCenter = e.getPoint();
                            rhomb.theCenter.y -= 55;
                            rhomb.theCenter.x -= 10;
                            System.out.println("Первая точка: " + rhomb.theCenter.x + " " + rhomb.theCenter.y);
                        }
                        else{
                            rhomb.additionalVertex = e.getPoint();
                            rhomb.additionalVertex.y -= 55;
                            rhomb.additionalVertex.x -= 10;
                            System.out.println("Вторая точка: " + rhomb.additionalVertex.x + " " + rhomb.additionalVertex.y);
                            System.out.println("рисуем");
                            rhomb.setColor(line_color);
                            rhomb.setFillColor(fill_color);
                            rhomb.draw(jPanel.getGraphics());
                            jFrame.removeMouseListener(this);
                        }
                    }
                });
            }
        });

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}