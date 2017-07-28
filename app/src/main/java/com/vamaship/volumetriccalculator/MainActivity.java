package com.vamaship.volumetriccalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView volumetricWeightTextView;
    private EditText lEditText, bEditText, hEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volumetricWeightTextView = (TextView) findViewById(R.id.text_view_volumetric_weight);
        lEditText = (EditText) findViewById(R.id.edit_text_l);
        bEditText = (EditText) findViewById(R.id.edit_text_b);
        hEditText = (EditText) findViewById(R.id.edit_text_h);
        calculateButton = (Button) findViewById(R.id.button_calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lEditText!=null&&bEditText!=null&&hEditText!=null&&lEditText.length()>0&&bEditText.length()>0&&hEditText.length()>0) {
                    closeKeyboard();
                    double volumetricWeight = (Double.parseDouble(lEditText.getText().toString()) * Double.parseDouble(bEditText.getText().toString()) * Double.parseDouble(hEditText.getText().toString())) / 5000D;
                    Log.d(TAG, "volumetricWeight: " + volumetricWeight);
                    volumetricWeightTextView.setText(String.valueOf(volumetricWeight));
                }
            }
        });
    }

    public void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}
