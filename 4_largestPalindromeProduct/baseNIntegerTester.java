package tmp.projectEuler;

import tmp.projectEuler.baseNInteger;

/** TODO: figure out how to work classpath
 */
public class baseNIntegerTester {

    public static void main( String args[] ) {

	try {

	    int n = Integer.parseInt(args[1]);
	    int base = Integer.parseInt(args[2]);

	    // Create new baseNInteger
	    baseNInteger myBaseNInt = new baseNInteger(n, base);

	    // Test positional representation
	    System.out.printf("My integer is %d base %d\n", myBaseNInt, myBaseNInt.base);
	    // Test palindrome function
	    if( myBaseNInt.isPalindrome() )
		System.out.printf("It is a palindrome.\n");
	    else
		System.out.printf("It is not a palindrome.\n");

	} catch (NumberFormatException e) {
	    System.out.println("Both n and base must be integers.");
	    System.exit(1);
	}

    }

}
