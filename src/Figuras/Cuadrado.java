package Figuras;

public class Cuadrado implements Shape{
    double lado;
    public Cuadrado(double lado){
        this.lado=lado;
    }
    @Override
    public void Calculateperimeter() {
        System.out.println("El cuadrado tiene un perimetro de: "+lado*4);
    }

    @Override
    public void CalculateArea() {
        System.out.println("El cuadrado tiene un area" +lado*lado);
    }
}
