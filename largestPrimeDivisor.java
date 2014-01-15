import java.lang.Math;
import java.util.ArrayList;

public class largestPrimeDivisor {
    
    /**
     * Finds the largest prime divisor of an integer n. n is
     * long-valued to permit larger values.
     * @param n the integer in question
     * @return the largest prime divisor of n
     */
    public static long largestPrimeDivisor(long n) {

	ArrayList<Long> divisors = new ArrayList<Long>();
	// Find all divisors less than sqrt(n)
	for(long i=1L; i<Math.sqrt(n)+1; i++) {
	    if(n%i == 0) divisors.add(i);
	}
	
	// For each divisor, find its larger cousin and then check
	// that cousin for primality. Stop once a prime is
	// found. Continue into the actual divisors if you have to
	for(Long divisor : divisors) {
	    Long bigCousin = n/divisor;
	    if(isPrime(bigCousin)) return bigCousin;
	}
	for(int i=divisors.size()-1; i>=0; i--) {
	    if( isPrime(divisors.get(i)) ) return divisors.get(i);
	}
	 
	// At this point the number just has to be 1
	return n;
    }
    
    /**
     * Standard O(sqrt(N)) primality test.
     * @param n Is n prime?
     */
    public static boolean isPrime(Long n) {
	for(long i=2L; i<Math.sqrt(n)+1; i++) {
	    if(n%i == 0) return false;
	}
	return true;
    }

    public static void main(String args[]) {
	try {
	    Long n = new Long(args[0]);
	    long lpd = largestPrimeDivisor(n);
	    System.out.printf("The largest prime divisor of %d is %d.\n",
			      n, lpd);
	    if(isPrime(lpd)) {
		System.out.printf("Yes, %d really is prime!\n", lpd);
	    }
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("usage: largestPrimeDivisor <of this integer>");
	    System.exit(1);
	}


    }

}
