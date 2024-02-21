public class person {
    String name;
    int age;
    String isfemale, colorOfhair;
    boolean married;
    double height, salary, weight;
    person(String name,int age,String isfemale,double height,String colorOfhair,double salary, double weigth, boolean married){
        this.name = name;
        this.age = age;
        this.isfemale= isfemale;
        this.height= height;
        this.colorOfhair= colorOfhair;
        this.salary= salary;
        this.weight= weigth;
        this.married= married;



    }
    public void mostrar(){
        System.out.println("name: "+name);
        System.out.println("age: "+age);
        System.out.println("is female: "+isfemale);
        System.out.println("height: "+height);
        System.out.println("color of hair: "+colorOfhair);
        System.out.println("salary: "+salary);
        System.out.println("weight: "+weight);
        System.out.println("married: "+married);
    }
}
