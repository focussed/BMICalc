package edu.icraig.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etkg, etcm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etkg = findViewById(R.id.etKg);
        etcm = findViewById(R.id.etCm);
    }

    /*
     * Clear the kg and the cm input fields
     */
    public void doReset(View view) {
        etkg.setText("0");
        etcm.setText("0");
    }

    public void doCalculate(View view) {
        String kgStr = etkg.getText().toString();
        int kg = Integer.valueOf(kgStr);
        String cmStr = etcm.getText().toString();
        int cm = Integer.valueOf(cmStr);

        if (kg < 20 || kg > 300) {
            Toast.makeText(this, "The kg entered is out of range", Toast.LENGTH_LONG).show();
        } else if (cm < 60 || cm > 300) {
            Toast.makeText(this, "The cm entered is out of range", Toast.LENGTH_LONG).show();
        } else {
            Intent A2 = new Intent(view.getContext(), BMIActivity.class);
            // putting the data for the second activity
            // down the common pipe
            A2.putExtra("userskg", kg);     // passing an integer
            A2.putExtra("userscm", cm);     // passing an integer
            startActivity(A2);      // call oncreate in second page
        }
    }
}