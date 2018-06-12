package come.practice.class19.e04;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String str = it.next();
            if (str.equals("bbb")) {
                it.remove();
                break;
            }
        }
        System.out.println(list);
        System.out.println("----------------------------------------------------");

        List<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            list1.add(i);
        }
        for (ListIterator<Integer> it = list1.listIterator(); it.hasNext();) {
            System.out.print("    One step forward: " + it.next());
            System.out.println(", PrevIndex = " + it.previousIndex() + ", NextIndex = " + it.nextIndex());
            if (it.hasNext()) {
                System.out.print("Another step forward: " + it.next());
                System.out.println(", PrevIndex = " + it.previousIndex() + ", NextIndex = " + it.nextIndex());
                System.out.print("   One step backward: " + it.previous());
                System.out.println(", PrevIndex = " + it.previousIndex() + ", NextIndex = " + it.nextIndex());
            }
        }
    }
}
