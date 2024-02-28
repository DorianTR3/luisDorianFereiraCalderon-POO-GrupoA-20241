public class empleado {
    double sueldoBase, bonos;
    int horasExtras;
    public double calcularsalario(double sueldoBase, double bonos, int horasExtras){
        this.sueldoBase=sueldoBase;
        this.bonos=bonos;
        this.horasExtras=horasExtras;
        return sueldoBase+bonos+(horasExtras*20);
    }
    public double calcularsalario(double sueldoBase,double bonos){
        this.sueldoBase=sueldoBase;
        this.bonos=bonos;
    return sueldoBase+bonos;}

    public double calcualrsalario(double sueldoBase){
        this.sueldoBase=sueldoBase;
        return sueldoBase;
    }
}
