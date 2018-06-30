package come.class11_BitOperations;

import static org.junit.Assert.*;

public class Q4_ReverseBitsTest {

    @org.junit.Test
    public void test1() {
        Q4_ReverseBits rb = new Q4_ReverseBits();
        int res = rb.reverseBits(0b10100010);
        assertEquals(0x45000000, res);
    }
}