//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Figuras.Cuadrado;
import Figuras.Rectangulo;
import Figuras.Triangulo;
import  Figuras.rhombus;
public class Main {
    public static void main(String[] args) {
        Cuadrado cuadrado=new Cuadrado(23);
        cuadrado.Calculateperimeter();
        cuadrado.CalculateArea();
        System.out.println("*******************************************************+");
        Rectangulo rectangulo=new Rectangulo(23,28);
        rectangulo.Calculateperimeter();
        rectangulo.CalculateArea();
        System.out.println("********************************************************");
        Triangulo triangulo=new Triangulo(10,28);
        triangulo.Calculateperimeter();
        triangulo.CalculateArea();
        System.out.println("********************************************************");
        rhombus rhombus=new rhombus(5, 5,10);
        rhombus.Calculateperimeter();
        rhombus.CalculateArea();



    }
}