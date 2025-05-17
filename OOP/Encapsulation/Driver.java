package Java_Bootcamp.OOP.Encapsulation;

class Driver{
    public static void main(String[] args) {

        //Person
        Person p = new Person();
        p.setName("John");
        p.setAge(30);
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());


        //Facebook
        FaceBook fb = new FaceBook("ABC","123",794823499);
        System.out.println(fb.getPhone("ABCsd","123"));


        //Branch
        Branch b = new Branch();
        b.setManager_name("Smith");
        b.setIfsc(10121);
        System.out.println("Manager Name: " + b.getManager_name() + "\nIFSC code: " + b.getIfsc());

        //Bag
        Bag b1 = new Bag();
        b1.setColor("Green");
        b1.setPrice(2500);
        System.out.println(b1.getColor()+"\n"+b1.getPrice());

        //Bank
        Bank bank = new Bank(10800 , 2004);
//        b.setPin(2004);
//        b.setMoney(1000);
        System.out.println(bank.getMoney(2004));


        //Order
        Order order1 = new Order();
        order1.setProductId("twqeh78321575");
        order1.setPayment("phonepay");
        order1.setPrice(60000);
        order1.setProductName("Camera");
        System.out.println(order1.getProductId()+"\n"+order1.getProductName()+"\n"+order1.getPrice()+"\n"+order1.getPayment());
    }
}
