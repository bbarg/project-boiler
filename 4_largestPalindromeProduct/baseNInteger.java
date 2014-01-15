package tmp.projectEuler;

public class baseNInteger {

    final private int n;
    private int base;
    // Digits are stored little-endian
    private int[] digits;

    public baseNInteger(int n, int base) {
	this.n = n;
	changeBase(base);
    }

    public void changeBase(int newbase) {
	this.base = newbase;
	this.digits = new int[this.howManyDigits()];
	buildDigits();
    }

    public boolean isPalindrome() {
	// Compare each pair of front and back integers
	for( int offset = 0; offset <= digits.length / 2; offset++) {
	    if( digits[offset] != digits[digits.length - offset - 1] )
		return false;
	}
	return true;
    }

    public int howManyDigits() {
	int digits = 0;
	int temp = n;
	while( (temp = temp / base) != 0 ) digits++;
	return digits;
    }

    private void buildDigits() {
	int temp = n;
	for( int i = 0; temp >=0; i++) {
	    digits[i] = temp % base;
	    temp = temp / base;
	}
    }

    public String toString() {
	String out = "";
	for( int i = digits.length - 1; i >= 0; i++ ) {
	    out = out + digits[i];
	}
	return out;
    }
}
