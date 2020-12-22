package edu.icraig.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    TextView bmiValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        bmiValue = findViewById(R.id.tvDisplay);

        // reads the put data from the pipe
        int mykg = getIntent().getIntExtra("userskg", -1);
        int mycm = getIntent().getIntExtra("userscm", -1);

        double mybmi = 0.0;
        double mymetres = 0.0;

        mymetres = (double) mycm/ (double) 100.0;
        mybmi = mykg / (mymetres * mymetres);

        String bmiStr = String.valueOf(mybmi);

        bmiValue.setText(bmiStr);

    }

    public void doFinish(View view) {
        finish();       // go back to first page
    }
}