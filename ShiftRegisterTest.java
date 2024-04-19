import org.junit.Test;

import static org.junit.Assert.*;


/**
 * ShiftRegisterTest
 * @author dcsslg
 * Description: set of tests for a shift register implementation
 */
public class ShiftRegisterTest {
    /**
     * Returns a shift register to test.
     * @param size
     * @param tap
     * @return a new shift register
     */
    ILFShiftRegister getRegister(int size, int tap) {
        return new ShiftRegister(size, tap);
    }

    /**
     * Tests shift with simple example.
     */
    @Test
    public void testShift1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        int[] expected = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], r.shift());
        }
    }

    /**
     * Tests generate with simple example.
     */
    @Test
    public void testGenerate1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        int[] expected = { 6, 1, 7, 2, 2, 1, 6, 6, 2, 3 };
        for (int i = 0; i < 10; i++) {
            assertEquals("GenerateTest", expected[i], r.generate(3));
        }
    }

    /**
     * Tests register of length 1.
     */
    @Test
    public void testOneLength() {
        ILFShiftRegister r = getRegister(1, 0);
        int[] seed = { 1 };
        r.setSeed(seed);
        int[] expected = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], r.generate(3));
        }
    }

    /**
     * Tests with erroneous seed.
     */
    @Test
    public void testError() {
        ILFShiftRegister r = getRegister(4, 1);
        int[] seed = { 1, 0, 0, 0, 1, 1, 0 };
        r.setSeed(seed);
        r.shift();
        r.generate(4);
    }
    /*
    to this kind of error, the system is going to stop running because of index exceeds the range of the array,
    to deal with this kind of test we'd better use arraylist instead of array,
     so that we won't be limited by the declared length problem
     */

    @Test
    public void myCases(){
        ILFShiftRegister r = getRegister(6, 0);
        int[] seed = { 0, 0, 0, 0, 0, 0 };
        r.setSeed(seed);
        int[] expected = { 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < 6; i++) {
            assertEquals(expected[i], r.generate(3));
        }
    }
    @Test
    public void smallerseed() {
        ILFShiftRegister r = getRegister(4, 1);
        int[] seed = { 1, 0};
        r.setSeed(seed);
        r.shift();
        r.generate(2);
    }
    @Test
    public void largertap() {
        ILFShiftRegister r = getRegister(4, 5);
        int[] seed = { 1, 0, 0, 0};
        r.setSeed(seed);
        r.shift();
        r.generate(2);
    }
}
