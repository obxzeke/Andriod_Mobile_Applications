package edu.uncc.assignment01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //Variables
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        EditText editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView sliderPercentage = findViewById(R.id.sliderPercentage);
        RadioButton radioButton10 = findViewById(R.id.tenPercentRadioButton);
        TextView discount = findViewById(R.id.discountNum);
        TextView finalPrice = findViewById(R.id.finalPriceNum);

        seekBar.setProgress(25);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sliderPercentage.setText(String.valueOf(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.resetBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumberDecimal.setText("");

                radioButton10.setChecked(true);

                seekBar.setProgress(25);

                discount.setText("0.00");
                finalPrice.setText("0.00");
            }
        });

        findViewById(R.id.calcBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int checkedId = radioGroup.getCheckedRadioButtonId();
                    double percentDiscount = 0;
                    if (checkedId == R.id.tenPercentRadioButton){
                        percentDiscount = .10;
                    }
                    else if (checkedId == R.id.fifteenPercentRadioButton){
                        percentDiscount = .15;
                    }
                    else if (checkedId == R.id.eighteenPercentRadioButton){
                        percentDiscount = .18;
                    }
                    else if (checkedId == R.id.customPercentRadioButton){
                        percentDiscount = (double) seekBar.getProgress() / 100;
                    }
                    else{
                        throw new Exception();
                    }
                    double price = Double.parseDouble(String.valueOf(editTextNumberDecimal.getText()));
                    double totalPrice = price * (1 - percentDiscount);
                    double discountAmount = price * percentDiscount;

                    discount.setText(String.format("%.2f", discountAmount));
                    finalPrice.setText(String.format("%.2f", totalPrice));
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Input is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}