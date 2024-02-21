public class Rectangulo {
    double ancho, altura;
    double area, perimetro;

    Rectangulo(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    public void calcular() {
        perimetro = (2 * ancho) + (2 * altura);
        area = ancho * altura;
    }

    public void mostrar() {
        System.out.println("Area: " + area);
        System.out.println("Perimetro: " + perimetro);
    }
}
