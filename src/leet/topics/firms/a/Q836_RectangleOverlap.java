package leet.topics.firms.a;

public class Q836_RectangleOverlap {
    private final int X1 = 0;
    private final int Y1 = 1;
    private final int X2 = 2;
    private final int Y2 = 3;
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[X1] >= rec2[X2] || rec1[Y1] >= rec2[Y2] || rec1[X2] <= rec2[X1] || rec1[Y2] <= rec2[Y1]);
    }
}
