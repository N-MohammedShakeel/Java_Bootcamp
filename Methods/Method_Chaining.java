package Java_Bootcamp.Methods;

import java.lang.String;

public class Method_Chaining {

    private int id;
    private java.lang.String name;

    public int getId(){
        return id;
    }

    public Method_Chaining setId(int id){
        this.id = id;
        return this;
    }

    public java.lang.String getName(){
        return name;
    }

    public Method_Chaining setName(java.lang.String name){
        this.name = name;
        return this;
    }
}

class Main{
    public static void main(String[] args) {

        Method_Chaining m = new Method_Chaining();

        int id = m.setId(1).setName("ms").getId();
        System.out.println(id);
    }
}
