package ke.co.droidsense.primechecker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ke.co.droidsense.primechecker.PrimeNumberChcker.Prime;
import ke.co.droidsense.primechecker.R;
import timber.log.Timber;

public class ListNumbersActivity extends AppCompatActivity {
    //Member Variables.
    ListView mListView;
    TextView mListHeader;
    List<Integer> createdList = new ArrayList<>();
    String inputStart;
    String inputEnd;
    Boolean primeNumber;
    ArrayList<Integer> isPrimeArray;
    ArrayList<Integer> notPrimeArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_numbers );

        //Initializations.
        mListView = findViewById( R.id.listNumbers );
        mListHeader = findViewById( R.id.list_header );

        //Get intent from MainActivity.
        Intent inputIntent = getIntent();
        inputStart = inputIntent.getStringExtra( "inputStart" );
        inputEnd = inputIntent.getStringExtra( "inputEnd" );

        //Set Integers.
        int start = Integer.parseInt( inputStart );
        int end = Integer.parseInt( inputEnd );

        //Create List from inputs.
        //Loop.
        for (int i = start; i <= end; i++){
            //Add to list of numbers in the createdList.
            createdList.add( i );

            Timber.tag("Added to Created List: ").e( String.valueOf( i ) );
        }

        //Use Prime Number Checker to verify if numbers are prime in the Created List.
        for (int i : createdList){
            //Check.
            primeNumber = Prime.isPrime( i );
            String num = String.valueOf( i );

            //checker.
            if (primeNumber){
                //True.

                //Set TextView Text.
                mListHeader.setText( "These are your Prime Numbers:" );

                //Initialize ArrayAdapter.
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, isPrimeArray );

                //Set Adapter.
                mListView.setAdapter( arrayAdapter );

            } else {
                //False.

                //Set TextView Text.
                mListHeader.setText( "These are your Prime Numbers:" );

                //Initialize ArrayAdapter.
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, notPrimeArray );

                //Set Adapter.
                mListView.setAdapter( arrayAdapter );
            }
        }
    }
}
