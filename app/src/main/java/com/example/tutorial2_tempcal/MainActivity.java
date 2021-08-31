package com.example.tutorial2_tempcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_temp;
    RadioButton radioButtonCel;
    RadioButton radioButtonFah;
    Button button_cal;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        radioButtonCel = findViewById(R.id.radioButtonCel);
        radioButtonFah = findViewById(R.id.radioButtonFah);
        button_cal = findViewById(R.id.button_cal);
        tv_answer = findViewById(R.id.tv_answer);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        button_cal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculateAnswer();
//            }
//        });
//    }

    public void calculateAnswer(View view) {
        Calculate cal = new Calculate();
        String value = et_temp.getText().toString();
        if (TextUtils.isEmpty(value)) {
            Toast.makeText(this, "Enter the Temperature!", Toast.LENGTH_SHORT).show();
        } else {
            Float temp = Float.parseFloat(value); //convert float to string
            if (radioButtonCel.isChecked()) {
                temp = cal.convertCelciusToFahrenheit(temp);
            } else if (radioButtonFah.isChecked()) {
                temp = cal.convertFahrenheitToCelcius((temp));
                Toast.makeText(this, "Select the radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            tv_answer.setText(new Float(temp).toString());
        }
    }
}