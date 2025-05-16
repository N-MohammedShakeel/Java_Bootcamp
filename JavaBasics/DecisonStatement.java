package Java_Bootcamp.JavaBasics;

public class DecisonStatement {

    public static void main(String[] args) {


//        Types of Decision-Making Statements
//        if
//        if-else
//        nested-if
//        if-else-if
//        switch-case
//        jump – break, continue, return


//1. Java if Statement

        int i = 20;

        if (i < 15)

            // part of if block(immediate one statement
            // after if condition)
            System.out.println("Inside If block");

        // always executes as it is outside of if block
        System.out.println("10 is less than 15");

        // This statement will be executed
        // as if considers one statement by default again
        // below statement is outside of if block
        System.out.println("I am Not in if");


//2. Java if-else Statement

        if (i < 15)
            System.out.println("i is smaller than 15");
        else
            System.out.println("i is greater than 15");


//3. Java nested-if Statement

        if (i == 10 || i < 15) {

            // First if statement
            if (i < 15)
                System.out.println("i is smaller than 15");

            // Nested - if statement
            // Will only be executed if statement above
            // it is true
            if (i < 12)
                System.out.println(
                        "i is smaller than 12 too");
        }
        else {
            System.out.println("i is greater than 15");
        }


// 4. Java if-else-if ladder

        if (i == 10)
            System.out.println("i is 10");
        else if (i == 15)
            System.out.println("i is 15");
        else if (i == 20)
            System.out.println("i is 20");
        else
            System.out.println("i is not present");

//5. Java Switch Case
        int num = 20;
        switch (num) {
            case 5:
                System.out.println("It is 5");
                break;
            case 10:
                System.out.println("It is 10");
                break;
            case 15:
                System.out.println("It is 15");
                break;
            case 20:
                System.out.println("It is 20");
                break;
            default:
                System.out.println("Not present");
        }

//6. jump Statements


        // continue
        for (i = 0; i < 10; i++) {

            // If the number is even
            // skip and continue
            if (i % 2 == 0)
                continue;

            // If number is odd, print it
            System.out.print(i + " ");
        }

        //return
        boolean t = true;
        System.out.println("Before the return.");

        if (t)
            return;

        // Compiler will bypass every statement
        // after return
        System.out.println("This won't execute.");


    }
}
