public class rectangulo {
    double lado1d,lado2d;
    int lado1,lado2;

    double area(double lado1d,double lado2d){
        this.lado2d= lado2d;
        this.lado1d= lado1d;
        return lado1d*lado2;
    }
    public int area (int lado1, int lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
        return lado1*lado2;
    }

    public double perimetro(double lado1d, double lado2d){
        this.lado2d= lado2d;
        this.lado1d= lado1d;
        return 2*lado1d+2*lado2d;
    }
    public int perimetro(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        return 2 * lado1 + 2 * lado2;
    }

}