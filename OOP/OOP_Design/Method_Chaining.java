package Java_Bootcamp.OOP.OOP_Design;

public class Method_Chaining {

    private int id;
    private String name;

    public int getId(){
        return id;
    }

    public Method_Chaining setId(int id){
        this.id = id;
        return this;
    }

    public String getName(){
        return name;
    }

    public Method_Chaining setName(String name){
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
