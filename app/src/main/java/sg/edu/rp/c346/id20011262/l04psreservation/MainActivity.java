package sg.edu.rp.c346.id20011262.l04psreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTelephone;
    EditText etSize;
    CheckBox cb;
    DatePicker dp;
    TimePicker tp;
    Button btnreset;
    Button btnreserve;
    TextView tvOuput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextTextPersonName);
        etTelephone = findViewById(R.id.editTextTelephone);
        etSize = findViewById(R.id.editTextSize);
        cb = findViewById(R.id.checkBoxSmoking);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnreset = findViewById(R.id.buttonReset);
        btnreserve = findViewById(R.id.buttonReserve);
        tvOuput = findViewById(R.id.textViewOutput);

        etName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = etName.getText().toString();
                int ilength = Integer.parseInt(length);
                if(ilength == 0) {
                    Toast.makeText(MainActivity.this,"Cannot have a blank field", Toast.LENGTH_LONG).show();
                    etTelephone.setText("");
                }
            }
        });

        etTelephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = etTelephone.getText().toString();
                int ilength = Integer.parseInt(length);
                if(ilength > 8) {
                    Toast.makeText(MainActivity.this,"Invalid Telephone Number.", Toast.LENGTH_LONG).show();
                    etTelephone.setText("");
                } else if(ilength == 0) {
                    Toast.makeText(MainActivity.this,"Cannot have a blank field.", Toast.LENGTH_LONG).show();
                    etTelephone.setText("");
                }
            }
        });

        etSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = etSize.getText().toString();
                int isize = Integer.parseInt(size);
                if(isize > 5) {
                    Toast.makeText(MainActivity.this,"The number of people attending is over the limit.", Toast.LENGTH_LONG).show();
                    etSize.setText("");
                } else if(isize < 1) {
                    Toast.makeText(MainActivity.this,"The number of people attending is Invalid.", Toast.LENGTH_LONG).show();
                    etSize.setText("");
                }
            }
        });

        btnreserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();
                String timeset = "Time Reserve is " + tp.getCurrentHour() +":" + String.format("%2f",tp.getCurrentMinute());

                tvOuput.setText("Hi" + etName.getText() + ", ");

                if(cb.isChecked()) {
                    tvOuput.setText("The sitting size is " + etSize.getText() + " and it has a smoking area.");
                } else {
                    tvOuput.setText("The sitting size is " + etSize.getText() + " and it does not have a smoking area.");
                }

                tvOuput.setText(timeset + " on " + day + "/" + month + "/" + year + " is now being reserved by you.");
            }
        });

        /*btnreserve.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            int hourofday = 8;
            int min = 0;
            public void onTimeChanged(TimePicker v , int hourOfDay, int min) {
                v.setCurrentHour(hourOfDay);
                v.setCurrentMinute(min);
            }
         });
         */

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");
                cb.setChecked(false);
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2021, 5,1);
            }
        });
    }
}