package come.OOD_III.SingletonPatternPractice;

public class TestSingletonPattern {
    public static void main(String[] args) {
        SingletonUser user1 = SingletonUser.getInstance();
        SingletonUser user2 = SingletonUser.getInstance();

        System.out.println(user1.getUserName());
        System.out.println(user2.getUserName());
        if (user1 == user2) {
            System.out.println("user1 and user2 are the same reference.");
        } else {
            System.out.println("user1 and user2 are NOT the same reference.");
        }
    }
}
