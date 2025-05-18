package Java_Bootcamp.OOPs.Enums;

// Enum with abstract method
enum Operation {
    ADD {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    };

    // Abstract method
    abstract double apply(double x, double y);
}
