public class calculadoraDeImpuestos {
    int ingresos, ventas;
    double porcentajeImpuestos, dividendos,extencion;

    public double calcularImpuestos(int ingresos){
        this.ingresos=ingresos;
    return ingresos*0.15; }
    public double calcularImpuestos(int ventas, double porcentajeImpuestos){
this.ventas=ventas;
this.porcentajeImpuestos=porcentajeImpuestos;
    return  ventas*(porcentajeImpuestos/100);}

    public double calcularImpuestos(double dividendos,double porcentajeImpuestos, double extencion){
        this.dividendos=dividendos;
        this.porcentajeImpuestos=porcentajeImpuestos;
        this.extencion=extencion;
        double v=dividendos*(porcentajeImpuestos/100);
        if (v>extencion){
            return v-extencion;
        }else {
            return 0;
        }
    }
}
