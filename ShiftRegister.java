///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////
/**
 * class ShiftRegister
 * @author
 * Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {
    private int[] shift_register;
    private int tap;

    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    public ShiftRegister(int size, int tap) {
        this.shift_register = new int[size];
        this.tap = tap;
    }

    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description:
     */
    @Override
    public void setSeed(int[] seed){
        shift_register = seed.clone();
    }

    /**
     * shift
     * @return
     * Description:
     */
    @Override
    public int shift(){
        int low_order_bit = 0;
        boolean b = shift_register[shift_register.length - 1] == shift_register[tap];
        if (b){
            low_order_bit = 0;
        }else{
            low_order_bit = 1;
        }
        for (int i = shift_register.length-1; i>0; i--){
            shift_register[i] = shift_register[i-1];
        }
        shift_register[0] = low_order_bit;
        return low_order_bit;
    }

    /**
     * generate
     * @param k
     * @return
     * Description:
     */
    @Override
    public int generate(int k){
        int number = 0;
        int[] newarray = new int[k];
        for (int i = 0; i<k; i++){
            int bit = shift();
            newarray[i] = bit;
        }
        number = toDecimal(newarray);
        return number;
    }

    /**
     * Returns the integer representation for a binary int array.
     * @param array
     * @return
     */
    private int toDecimal(int[] array) {
        int number = 0;
        for (int bit : array) {
            number = (number << 1) | bit;
        }
        return number;
    }
}
