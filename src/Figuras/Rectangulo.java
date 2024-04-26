package Figuras;

public class Rectangulo implements Shape{
    public double weidth;
    public double height;
    public Rectangulo(double weidth, double height) {
        this.weidth = weidth;
        this.height = height;
    }

    @Override
    public void Calculateperimeter() {
        System.out.println("el perimetro del rectangulo es: " + (2*weidth )*(2*height));
    }

    @Override
    public void CalculateArea() {
        System.out.println("el area del Rectangulo es: "+weidth*height);
    }
}
