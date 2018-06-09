package come.practice.class19.e01;

public class OuterClassTest {
    public static void main(String[] args) {
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        printer.printMessage();

        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();
        innerObject.display();
    }
}

class OuterClass {
    private static String msg = "Static Message";
    private String msg2 = "Non-Static Message";

    public static class NestedStaticClass {
        public void printMessage() {
            // if msg is non-static, there is a compile error.
            System.out.println("Message from nested static class: " + msg);
        }

        public static void printOut() {
            System.out.println("Message from static printOut");
        }
    }

    public class InnerClass {
        public void display() {
            System.out.println("Message from nested non-static class: " + msg + " | " + msg2);
        }

        // Cannot declare a static method in a non-static class.
        // public static void printOut() {}

        public OuterClass getOuterClass() {
            return OuterClass.this;
        }
    }
}
