public class Main {
    public static void main(String[] args){
        person firstPerson = new person("dorian", 19, "M", 1.75, "black", 13445, 67, false);
        firstPerson.mostrar();
        System.out.println("****************************");
        person secondPerson = new person("pedro", 45, "M", 1.87, "green", 50000, 87, true);
        secondPerson.mostrar();

        System.out.println("****************************");
        person terceraperson = new person("roberto", 13, "M", 1.35, "white", 0, 50, false);
        terceraperson.mostrar();
        System.out.println("****************************");

        //empieza trabajo de libros
        libro book1 = new libro();
        book1.mostrar();
        System.out.println("****************+************");

        libro book2 = new libro();
        book2.author = "jose antonio";
        book2.title = "las cabañas del monte";
        book2.yearofPublication = 1998;
        book2.pages = 78;
        book2.mostrar();
        System.out.println("****************+************");

        libro book3 = new libro();
        book3.title = "la rata con tiner";
        book3.author = "Omar Ramirez";
        book3.yearofPublication = 2004;
        book3.pages = 354;
        book3.mostrar();
        System.out.println("****************+************");
        libro book4 = new libro();
        book4.title = "aprende a cocinar vegetales";
        book4.author = "ramon verduga";
        book4.yearofPublication = 2017;
        book4.pages = 132;
        book4.mostrar();
        System.out.println("****************+************");
        Rectangulo rectangulo = new Rectangulo(5.0, 10.0);

        rectangulo.calcular();
        rectangulo.mostrar();
        System.out.println("****************+************");
        Rectangulo rectangulo2= new Rectangulo(12,7);
        rectangulo2.calcular();
        rectangulo2.mostrar();
        System.out.println("****************+************");
        Rectangulo rectangulo3= new Rectangulo(34,3);
        rectangulo3.calcular();
        rectangulo3.mostrar();




    }
}
