package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.JavaBasics;

public class Operators {
    public static void main(String[] args) {

    }

    public static void arithmetic() {
        // Arithmetic operators on integers
        int a = 10;
        int b = 3;

        // Arithmetic operators on Strings
        String n1 = "15";
        String n2 = "25";

        // Convert Strings to integers
        int a1 = Integer.parseInt(n1);
        int b1 = Integer.parseInt(n2);

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        System.out.println("a1 + b1 = " + (a1 + b1));

        /*
        a + b = 13
        a - b = 7
        a * b = 30
        a / b = 3
        a % b = 1
        a1 + b1 = 40
         */

    }

    public static void unary() {

        // Interger declared
        int a = 10;
        int b = 10;

        // Using unary operators
        System.out.println("Postincrement : " + (a++));
        System.out.println("Preincrement : " + (++a));

        System.out.println("Postdecrement : " + (b--));
        System.out.println("Predecrement : " + (--b));

        /*
        Postincrement : 10
        Preincrement : 12
        Postdecrement : 10
        Predecrement : 8
         */

    }

    public static void assignment() {

        // Assignment operators
        int f = 7;
        System.out.println("f += 3: " + (f += 3));
        System.out.println("f -= 2: " + (f -= 2));
        System.out.println("f *= 4: " + (f *= 4));
        System.out.println("f /= 3: " + (f /= 3));
        System.out.println("f %= 2: " + (f %= 2));
        System.out.println("f &= 0b1010: " + (f &= 0b1010));
        System.out.println("f |= 0b1100: " + (f |= 0b1100));
        System.out.println("f ^= 0b1010: " + (f ^= 0b1010));
        System.out.println("f <<= 2: " + (f <<= 2));
        System.out.println("f >>= 1: " + (f >>= 1));
        System.out.println("f >>>= 1: " + (f >>>= 1));

        /*
        f += 3: 10
        f -= 2: 8
        f *= 4: 32
        f /= 3: 10
        f %= 2: 0
        f &= 0b1010: 0
        f |= 0b1100: 12
        f ^= 0b1010: 6
        f <<= 2: 24
        f >>= 1: 12
        f >>>= 1: 6
         */
    }
    public static void relational() {

        // Comparison operators
        int a = 10;
        int b = 3;
        int c = 5;

        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a != c: " + (a != c));

        /*
        a > b: true
        a < b: false
        a >= b: true
        a <= b: false
        a == c: false
        a != c: true
         */
    }
    public static void logical() {

        // Logical operators
        boolean x = true;
        boolean y = false;

        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
        /*
        x && y: false
        x || y: true
        !x: false
         */

    }
    public static void ternary() {

        int a = 20, b = 10, c = 30, result;

        // result holds max of three
        // numbers
        result = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
        System.out.println("Max of three numbers = "+ result);

        //Max of three numbers = 30
    }
    public static void bitwise_op() {

        int d = 0b1010;
        int e = 0b1100;

        System.out.println("d & e : " + (d & e));
        System.out.println("d | e : " + (d | e));
        System.out.println("d ^ e : " + (d ^ e));
        System.out.println("~d : " + (~d));
        System.out.println("d << 2 : " + (d << 2));
        System.out.println("e >> 1 : " + (e >> 1));
        System.out.println("e >>> 1 : " + (e >>> 1));

        /*
        d & e : 8
        d | e : 14
        d ^ e : 6
        ~d : -11
        d << 2 : 40
        e >> 1 : 6
        e >>> 1 : 6
         */

    }
    public static void shift() {

        int a = 10;

        // Using left shift
        System.out.println("a<<1 : " + (a << 1));

        // Using right shift
        System.out.println("a>>1 : " + (a >> 1));

        //a<<1 : 20
        //a>>1 : 5

    }
    public static void instanceof_op() {

        Person obj1 = new Person();
        Person obj2 = new Boy();

        // As obj is of type person, it is not an
        // instance of Boy or interface
        System.out.println("obj1 instanceof Person: "
                + (obj1 instanceof Person));
        System.out.println("obj1 instanceof Boy: "
                + (obj1 instanceof Boy));
        System.out.println("obj1 instanceof MyInterface: "
                + (obj1 instanceof MyInterface));

        // Since obj2 is of type boy,
        // whose parent class is person
        // and it implements the interface Myinterface
        // it is instance of all of these classes
        System.out.println("obj2 instanceof Person: "
                + (obj2 instanceof Person));
        System.out.println("obj2 instanceof Boy: "
                + (obj2 instanceof Boy));
        System.out.println("obj2 instanceof MyInterface: "
                + (obj2 instanceof MyInterface));



        /*
        obj1 instanceof Person: true
        obj1 instanceof Boy: false
        obj1 instanceof MyInterface: false
        obj2 instanceof Person: true
        obj2 instanceof Boy: true
        obj2 instanceof MyInterface: true
         */
    }
}

class Person {
}

class Boy extends Person implements MyInterface {
}

interface MyInterface {
}