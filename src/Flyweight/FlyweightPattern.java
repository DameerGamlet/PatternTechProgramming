package Flyweight;

/*
* Приспособленец — структурный шаблон проектирования, при котором объект, представляющий себя как уникальный экземпляр
*  в разных местах программы, по факту не является таковым.
*
* Применется: когда не хватает оператичвной памяти
*
* (+) - эконимит место
* (-) - расходует процессорное время - усложняет код
* */

import java.util.*;

interface Figure{
    void DrawFigure(int x, int y);
}

class Point implements Figure{

    @Override
    public void DrawFigure(int x, int y) {
        System.out.println(" Рисуем ТОЧКУ        с координатами х: " + x + ", y: " + y);
    }
}

class Circle implements Figure{

    Random rand_r = new Random();
    int radius = randomInRange(3, 30);

    public int randomInRange(int min, int max) {
        return this.rand_r.nextInt(max - min) + min;
    }
    @Override
    public void DrawFigure(int x, int y) {
        System.out.println(" Рисуем КРУГ        с координатами х: " + x + ", y: " + y + " и радиусом: " + radius);
    }
}

class Square implements Figure{

    Random rand_ss = new Random();
    int side_square = randomInRange(10, 50);

    public int randomInRange(int min, int max) {
        return this.rand_ss.nextInt(max - min) + min;
    }
    @Override
    public void DrawFigure(int x, int y) {
        System.out.println(" Рисуем КВАДРАТ      с координатами х: " + x + ", y: " + y
                + "\n                     со сторонами : " + side_square);
    }
}

class Rectangle implements Figure{

    Random rand_ss = new Random();
    int side_a = randomInRange(10, 50);
    int side_b = randomInRange(20, 40);

    public int randomInRange(int min, int max) {
        return this.rand_ss.nextInt(max - min) + min;
    }
    @Override
    public void DrawFigure(int x, int y) {
        System.out.println(" Рисуем ПРЯМОГУЛЬНИК с координатами х: " + x + ", y: " + y);
        System.out.println("                     со сторонами: a = " + side_a
                + " b = "+ side_b +
                "\n                     площадь фигуры: " + (side_a * side_b));
    }
}

class Triangle implements Figure{

    Random rand_ss = new Random();
    int heigth = randomInRange(2, 15);
    int side_b = randomInRange(5, 20);

    public int randomInRange(int min, int max) {
        return this.rand_ss.nextInt(max - min) + min;
    }
    @Override
    public void DrawFigure(int x, int y) {
        System.out.println(" Рисуем ТРЕУГОЛЬНИК  с координатами х: " + x + ", y: " + y
                + " \n                     c основанием: b = " + side_b + " и высотой = "+ heigth
                + "\n                     площадь фигуры: " + (((double)heigth * (double)side_b) / 2));
    }
}

class Rhombus implements Figure{

    Random rand_sr = new Random();
    int side_rhombus = randomInRange(5, 25);

    public int randomInRange(int min, int max) {
        return this.rand_sr.nextInt(max - min) + min;
    }

    @Override
    public void DrawFigure(int x, int y) {
        System.out.println(" Рисуем РОМБ         с координатами х: " + x + ", y: " + y + " со сторонами : " + side_rhombus);
    }
}

class FigureFabric{
    private static final Map<String, Figure> figureMap = new HashMap<>();

    public static Figure getFigure(String firureName){
        Figure figure = figureMap.get(firureName);
        if(figure == null){
            switch (firureName) {
                case "point" -> figure = new Point();
                case "circle" -> figure = new Circle();
                case "square" -> figure = new Square();
                case "rectangle" -> figure = new Rectangle();
                case "triangle" -> figure = new Triangle();
                case "rhombus" -> figure = new Rhombus();
                default -> System.out.println(" Такой фигуры нет ");
            }
            figureMap.put(firureName, figure);
        }
        return figure;
    }
}
public class FlyweightPattern {
    public static void main(String[] args) {
        String[] figname = new String[]{"point", "circle", "square", "rectangle", "triangle", "rhombus"};
        List<Figure> figureElements = new ArrayList<>();

        int n = 30;
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            String tempElement = figname[rand.nextInt(figname.length - 1)];
            figureElements.add(FigureFabric.getFigure(tempElement));
        }

        Random random_x_y = new Random();
        int x, y;
        int x_range = 80, y_range = 100;
        for (Figure figure: figureElements) {
            x = random_x_y.nextInt(x_range);
            y = random_x_y.nextInt(y_range);
            figure.DrawFigure(x, y);
        }
    }
}
