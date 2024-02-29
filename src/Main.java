public class Main {

    public static void main(String[] args) {
        producto producto1 = new producto("frijples", 343.34,23);
        producto1.aumentarStock(12);
        producto1.reducirStock(11);

        producto producto2= new producto("tac",0);
        producto2.setPrecio(34.3);
        producto2.aumentarStock(4);



    }
}
