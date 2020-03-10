package ke.co.droidsense.primechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    //ArrayList to Loop through.
    Integer[] primeList = { 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218,
            219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241,
            242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263 };

    //Prime Numbers List.
    ArrayList<Integer> isprime = new ArrayList<>();

    //None Prime Numbers List.
    ArrayList<Integer> notPrime = new ArrayList<>();

    //List View
    ListView listView;

    //Other Member Variables.
    private Boolean primeNumber;
    private TextView textView;
    private String num;
    private String message = "----is a Prime Number";
    private String notPrimeMsg = "----is NOT a Prime Number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Initialization.
        textView = findViewById( R.id.textView );

        //Log
        Timber.plant(new Timber.DebugTree());

        //ListView.
        listView  = findViewById( R.id.listView );

        //Loop through numbers.
        for (int i : primeList){
            Prime.checkPrime(i);
            primeNumber = Prime.isPrime(i);
            num = String.valueOf(i);

            //Check if isPrime.
            if(primeNumber){
                //Add Prime Number to list.
                isprime.add( i );

                //Set TextView.
                textView.setText("This are your Prime numbers");

                //Array Adapter.
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, isprime);
                listView.setAdapter( arrayAdapter );

                //Print out.
                Timber.e( num + message);
            } else {
                //Add Prime Number to list.
                notPrime.add( i );

                //Set TextView.
                textView.setText("This are your none Prime numbers");

                //Array Adapter.
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notPrime);
                listView.setAdapter( arrayAdapter );

                //Print out number.
                Timber.e(num + notPrimeMsg);
            }



        }

    }

    //Check Prime numbers...
    public static class Prime {

        //Check range of numbers.
        static void checkPrime(int... numbers) {

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
        static boolean isPrime(int n) {

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
}
