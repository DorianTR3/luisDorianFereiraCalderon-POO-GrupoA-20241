package Figuras;

public class rhombus extends Shape {
    public double DiagonalMenor;
    public double DiagonalMayor;
    public double lado;
public rhombus(double lado, double diagonalMayor, double diagonalMenor){
    this.DiagonalMenor = diagonalMenor;
    this.DiagonalMayor = diagonalMayor;
    this.lado = lado;
}

    @Override
    public void Calculateperimeter() {
        System.out.println("el perimetro del Rhombus es " + lado*4);
    }

    @Override
    public void CalculateArea() {
        System.out.println("el area del Rhombus es " + (DiagonalMenor*DiagonalMayor)/2);
    }
}