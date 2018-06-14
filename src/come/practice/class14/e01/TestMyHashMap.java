package come.practice.class14.e01;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> testmap1 = new MyHashMap<>();
        for (int i = 0; i < 20; i++) {
            testmap1.put(i, i);
        }

        for (int i = 0; i < testmap1.size(); i++) {
            if (testmap1.containsKey(i)) {
                System.out.println("testmap1 key value pair <" + i + ", " + testmap1.get(i) + ">");
            }
        }

        testmap1.remove(5);
        for (int i = 0; i < testmap1.size(); i++) {
            if (testmap1.containsKey(i)) {
                System.out.println("testmap1 key value pair <" + i + ", " + testmap1.get(i) + ">");
            }
        }
    }
}
