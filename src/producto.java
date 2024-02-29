public class producto {
    double cantidad;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name!=null){
            if (name != " "){
                this.name = name;
            }
        }

    }

    private String name;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio>0){
            this.precio = precio;
        }
    }

    private double precio;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock;
    public producto(String name, Double precio,int Stock){
        this.name=name;
        this.precio=precio;
        this.stock=stock;


    }
    public producto(String name, double precio){
        stock=0;
    }

    void aumentarStock (int cantidad){
        if (cantidad>0){
            stock=stock+cantidad;

        }

    }

    void reducirStock(int cantidad){
        if (stock>cantidad){
            stock=stock-cantidad;

        }
    }

}

