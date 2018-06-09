package come.practice.class19.e03;

public class AnonymousClassTest {
    public static void main(String[] args) {
        AnonymousInnerClass object = new AnonymousInnerClass();
        object.test();
    }
}

class AnonymousInnerClass {
    public void test() {
        // anonymous
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous");
            }
        }).start();

        // non anonymous
        class NonAnonymousClass implements Runnable {
            @Override
            public void run() {
                System.out.println("non anonymous");
            }
        }
        NonAnonymousClass t = new NonAnonymousClass();
        new Thread(t).start();
    }
}
