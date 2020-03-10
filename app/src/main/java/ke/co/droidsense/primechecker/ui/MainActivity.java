package ke.co.droidsense.primechecker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import ke.co.droidsense.primechecker.PrimeNumberChcker.Prime;
import ke.co.droidsense.primechecker.R;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Views
    Button checkPrimeNumbers;
    EditText inputStart;
    EditText inputEnd;
    TextView header_text;

    //Intent
    Intent intent;

    //Input Integers.
    String inputStartInt;
    String inputEndInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Initialization.
        header_text = findViewById( R.id.header_text );
        checkPrimeNumbers = findViewById( R.id.checkPrimeButton );
        inputStart = findViewById( R.id.inputStart );
        inputEnd = findViewById( R.id.inputEnd );

        //Set int.
        inputStartInt = inputStart.getText().toString();
        inputEndInt = inputEnd.getText().toString();

        //Log
        Timber.plant(new Timber.DebugTree());

        //Set Click Listener on button.
        checkPrimeNumbers.setOnClickListener( this );

    }

    //Handle Click Events.
    @Override
    public void onClick(View view) {
        //Verify View Clicked.
        if (view.getId() == R.id.checkPrimeButton){
            //Fire Explicit Intent.
            intent = new Intent( this, ListNumbersActivity.class );

            //Add String Extras.
            intent.putExtra( "inputStart", inputStartInt);
            intent.putExtra( "inputEnd", inputEndInt);
            startActivity( intent );
        }
    }
}
