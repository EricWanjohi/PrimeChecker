package ke.co.droidsense.primechecker.PrimeNumberChcker;

//Check Prime numbers...
public class Prime {

    //Check range of numbers.
    public static void checkPrime(int... numbers) {

        //Loop through list of numbers to check if isPrime.
        for (int num : numbers) {

            //If number is Prime Print it out.
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        // Timber.tag( "Number: " ).e( String.valueOf( numbers ) );
    }

    //Boolean to check if number is Prime.
    public static boolean isPrime(int n) {

        /*
         * Numbers 1, 2, 3 are all divisible by 1 and themselves so check for numbers above 3
         * Check number 2 to verify that number is prime.
         *
         **/

        if (n < 2) {
            return false;
        } else if (n == 2) {    //Return true because number is prime.
            return true;
        } else if (n % 2 == 0) {    //Check multiples of 2.
            return false;
        }
        int sqrt = (int) Math.sqrt(n);

        //Loop through numbers adding 2 to the previous number in an incremental fashion.
        for (int i = 3; i <= sqrt; i += 2) {

            //Check to confirm number is not prime.
            if (n % i == 0) {
                return false;
            }
        }

        //Return true if the number is verified to be prime.
        return true;
    }
}
