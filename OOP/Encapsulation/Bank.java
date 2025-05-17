package Java_Bootcamp.OOP.Encapsulation;

public class Bank {

    private double money;
    private int pin;


    Bank(double money,int pin){
        if(money % 500 == 0)
            this.money = money;
        else
            System.out.println("Must be multiples of 500");
        this.pin = pin;
    }

//    void setMoney(double money){
//        if(money % 5 == 0)
//            this.money = money;
//    }
//
//    void setPin (int pin){
//        this.pin = pin;
//    }

    double getMoney(int pin){
        if(this.pin == pin){
            return this.money;
        }
        else{
            System.out.println("Invalid Pin");
        }
        return 0;
    }
}

