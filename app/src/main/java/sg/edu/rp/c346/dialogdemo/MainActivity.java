package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnExercise3;
    Button btnDemo4;
    Button btnDemo5;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvExercise3;
    TextView tvDemo4;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnExercise3 = findViewById(R.id.buttonExercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvExercise3 = findViewById(R.id.textViewExercise3);
        tvDemo5 = findViewById(R.id.textViewDemo5);
        tvDemo4 = findViewById(R.id.textViewDemo4);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the Dialog Builder (Instantiate an AlertDialog.Builder with its constructor)
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);*/

                //Chain together various setter methods to set the dialog characteristics
                myBuilder.setTitle("Congratulation").setMessage("You have completed a simple Dialog Box").setCancelable(false).setPositiveButton("DISMISS",null);

                //Get the AlertDialog from create()
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below.");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected positive");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });

                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);

                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "final", so that it can be used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3,null);

                final EditText etInput1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int num1 = Integer.parseInt(etInput1.getText().toString());
                        int num2 = Integer.parseInt(etInput2.getText().toString());

                        tvExercise3.setText("The sum is " + String.valueOf(num1 + num2));
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthofYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthofYear+1) + "/" + year);
                    }
                };
                //Create the Date Picker Dialog
                DatePicker date = new DatePicker(getBaseContext());
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,date.getYear(),date.getMonth(),date.getDayOfMonth());
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                //Create the Time Picker Dialog
                TimePicker time = new TimePicker(MainActivity.this);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,time.getCurrentHour(),time.getCurrentMinute(),true);

                myTimeDialog.show();
            }
        });
    }
}
