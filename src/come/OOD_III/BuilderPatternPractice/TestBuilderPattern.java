package come.OOD_III.BuilderPatternPractice;

public class TestBuilderPattern {
    public static void main(String[] args) {
        User alice = new User.UserBuilder("Alice", "Wang")
                             .setAddress("Alice's new address1")
                             .setAge(18)
                             .setPhone("123456789")
                             .build();

        User bob = new User.UserBuilder("Bob", "Huang")
                           .setAddress("Bob's new address1")
                           .setAge(81)
                           .setPhone("987654321")
                           .build();

        printUser(alice);
        printUser(bob);
    }

    private static void printUser(User user) {
        System.out.print(user.getFirstName() + " " + user.getLastName());
        System.out.println(", " + user.getAge() + ", " + user.getPhone() + ", " + user.getAddress());
    }
}
