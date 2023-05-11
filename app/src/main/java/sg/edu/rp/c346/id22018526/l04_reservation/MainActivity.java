package sg.edu.rp.c346.id22018526.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText fname;
    EditText lname;
    EditText mail;
    EditText pnum;
    EditText size;
    ToggleButton smoke;
    Button sub;
    Button res;

    TextView display;

    DatePicker date;

    TimePicker time;

    String firstname = "";
    String lastname = "";
    String email = "";
    String phonenumber = "";




    int grouping = 0;

    boolean smoking = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.firstNameInput);
        lname = findViewById(R.id.lastNameInput);
        mail = findViewById(R.id.emailInput);
        pnum = findViewById(R.id.phoneInput);
        size = findViewById(R.id.groupInput);
        smoke = findViewById(R.id.smokebtn);
        sub = findViewById(R.id.submitBtn);
        res = findViewById(R.id.resetBtn);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        display = findViewById(R.id.tvdisplay);


        fname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = fname.getText().toString();
            }
        });
        lname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastname = lname.getText().toString();
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mail.getText().toString();
            }
        });
        pnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonenumber = pnum.getText().toString();
            }
        });
        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grouping = Integer.parseInt(size.getText().toString());
            }
        });
        smoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(smoke.isChecked()) {
                    smoking = true;
                }
                else {
                    smoking = false;
                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int dateday = date.getDayOfMonth();
                    int datemonth = date.getMonth() + 1;
                    int dateyear = date.getYear();
                    int timeminute = time.getCurrentMinute();
                    int timehour = time.getCurrentHour();
                    firstname = fname.getText().toString();
                    lastname = lname.getText().toString();
                    phonenumber = pnum.getText().toString();
                    email = mail.getText().toString();
                    String fullname = String.format(Locale.ENGLISH,"%s %s",firstname,lastname);
                    String fulldate = String.format(Locale.ENGLISH,"%d/%d/%d",dateday,datemonth,dateyear);
                    String smokechoice;
                    String fulltime;
                    if(timeminute < 10) {
                        fulltime = String.format(Locale.ENGLISH,"%d:0%d",timehour,timeminute);
                    }
                    else {
                        fulltime = String.format(Locale.ENGLISH,"%d:%d",timehour,timeminute);
                    }
                    String stringsize = Integer.toString(grouping);
                    if(smoking == true) {
                        smokechoice = "True";
                    }
                    else {
                        smokechoice = "False";
                    }

                    Toast.makeText(getApplicationContext(),"Successfully created Reservation", Toast.LENGTH_LONG).show();

                    String finaloutput = String.format("Full Name : %s \n Phone Number : %s \n Email : %s \n Group Size : %s \n Smoking : %s \n Date : %s \n Timing : %s",
                            fullname,phonenumber,email,stringsize,smokechoice,fulldate,fulltime);

                    display.setText(finaloutput);






            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.updateDate(2020, 6, 1);
                time.setCurrentHour(7);
                time.setCurrentMinute(30);
                fname.getText().clear();
                lname.getText().clear();
                pnum.getText().clear();
                mail.getText().clear();
                size.getText().clear();
                smoke.setChecked(false);

            }
        });









    }
}