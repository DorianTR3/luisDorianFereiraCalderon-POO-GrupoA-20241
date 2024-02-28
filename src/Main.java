public class Main {

    public static void main(String[] args) {
        rectangulo rectand= new rectangulo();
        System.out.println(rectand.perimetro(12.23,3.2));
        System.out.println(rectand.area(12.23,3.2));

        empleado empleado= new empleado();
        System.out.println(empleado.calcularsalario(1100,400, 8));
        System.out.println(empleado.calcularsalario(2300,600));
        System.out.println(1600);

        calculadoraDeImpuestos calculadoraDeImpuestos= new calculadoraDeImpuestos();
        System.out.println(calculadoraDeImpuestos.calcularImpuestos(3300, 34,12));
        System.out.println(calculadoraDeImpuestos.calcularImpuestos(1200,13));
        System.out.println(calculadoraDeImpuestos.calcularImpuestos(589));


    }
}