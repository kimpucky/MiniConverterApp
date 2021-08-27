package com.example.miniconverterapp;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private RadioButton radioButtonFromKm;
    private RadioButton radioButtonFromMiles;
    private EditText textValue;
    private EditText textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonFromKm = (RadioButton) findViewById(R.id.fromKmButton);
        radioButtonFromMiles = (RadioButton) findViewById(R.id.fromMilesButton);
        textValue = (EditText) findViewById(R.id.numberInput);
        textResult = (EditText) findViewById(R.id.numberOutput);
    }

    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.buttonConvert:
                String result;
                String value = textValue.getText().toString();
                if (value.length() == 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Error: empty value!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (radioButtonFromMiles.isChecked()) {
                        result = milesToKm(value);
                    } else {
                        result = kmToMiles(value);
                    }
                    textResult.setText(result);
                }
                break;

            case R.id.buttonReset:
                radioButtonFromMiles.setChecked(false);
                radioButtonFromKm.setChecked(true);
                textValue.setText("");
                textResult.setText("");
                break;
        }
    }

    private String milesToKm(String miles) {
        double m_value = Double.parseDouble(miles);
        double km_value = m_value * 1.60934;
        return String.valueOf(km_value);
    }

    private String kmToMiles(String km) {
        double km_value = Double.parseDouble(km);
        double miles_value = km_value / 1.60934;
        return String.valueOf(miles_value);
    }
}