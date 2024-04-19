/**
 * @author gilbert
 * Interface: ILFShiftRegister
 * Description: A linear feedback shift register based on XOR with one tap.
 */
public interface ILFShiftRegister {
    void setSeed(int[] seed);
    // Sets the value of the shift register to the specified seed.


    // Shifts the register one time, returning the low-order bit.
    public int shift();

    // Shifts the register k times, returning a k-bit integer.
    public int generate(int k);
}
