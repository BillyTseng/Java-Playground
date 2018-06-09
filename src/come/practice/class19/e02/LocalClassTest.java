package come.practice.class19.e02;

public class LocalClassTest {
}

class LocalInnerClassTest {
    private int i = 0;
    private final int k = 0;

    private static int j = 0;
    private static final int m = 0;

    public static void test() {
        final int a = 0;
        int b = 0;

        //local inner class cannot have access modifier.
        class LocalClass {
            // local inner class dose not have static member
            // private static int c;

            private int d = 0;

            // constructor
            public LocalClass() {
                // can visit final variables.
                System.out.println(a);

                System.out.println(b);
                // Variable 'b' is accessed from within inner class, needs to be final or effectively final
                // b++;

                // non-static is not allowed.
                // System.out.println(i);
                // System.out.println(k);
                System.out.println(j);
                System.out.println(m);
            }
            // local inner class has no static methods.
            // public static void test() {}
        }
    }

    public void test2() {
        final class LocalClass2 {
            // constructor
            public LocalClass2() {
                // non-static local inner class can access all members.
                System.out.println(i);
                System.out.println(k);
                System.out.println(j);
                System.out.println(m);
            }
        }
    }
}
