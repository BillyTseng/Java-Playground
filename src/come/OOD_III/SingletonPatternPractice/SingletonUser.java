package come.OOD_III.SingletonPatternPractice;

public class SingletonUser {
    private static final SingletonUser INSTANCE = new SingletonUser();
    private final String USER_NAME;

    private SingletonUser() {
        this.USER_NAME = "JohnDoe";
    }
    public String getUserName() {
        return USER_NAME;
    }
    public static SingletonUser getInstance() {
        return INSTANCE;
    }
}
