package Figuras;

public class Triangulo extends Shape{
    double width;
    double height;
public Triangulo(double width, double height) {
    this.width = width;
    this.height = height;
}
    @Override
    public void Calculateperimeter(){
        System.out.println("the perimeter is: "+width*3);
    }
    @Override
    public void CalculateArea(){
        double Area=(width*height)/2;
        System.out.println("the area is: "+Area);
    }
}
