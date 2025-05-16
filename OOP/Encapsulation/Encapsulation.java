package Java_Bootcamp.OOP.Encapsulation;

public class Encapsulation {
    public static void main(String[] args)
    {
        Person p = new Person();
        p.setName("John");
        p.setAge(30);

        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
    }
}
// Java program to demonstrate the Encapsulation.
class Person {
    // Encapsulating the name and age
    // only approachable and used using
    // methods defined
    private String name;
    private int age;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age > 18)
            this.age = age;
    }

}


class Demo {
    private double price;
    void setPrice(double price){
        if(price>0)
            this.price =price;
    }
    double getPrice(){
        return price;
    }

    Demo(double price){
        setPrice(price);
    }



}

class Test{
    public static void main(String[] args) {
        Demo e= new Demo(-1000);
        System.out.println(e.getPrice());
        Demo e1= new Demo(2000);
        System.out.println(e1.getPrice());


        EncapFB fb = new EncapFB("ABC","123",794823499);
        System.out.println(fb.getPhone("ABCsd","123"));
    }
}


class EncapFB {
    private String username;
    private String password;
    private long phno;


    EncapFB(String username,String password,long phno){
        this.username=username;
        this.password=password;
        setPhone(phno);
    }

    void setPhone (long phno){
        this.phno=phno;
    }

    long getPhone(String username,String password){
        if(this.username == username&&this.password == password){
            return phno;
        }
        else{
            System.out.println("Invalid Credential");
        }
        return 0;
    }
}