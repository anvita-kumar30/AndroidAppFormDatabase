package com.example.exp4myapplication;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    // Initialize views
    private EditText editTextName = findViewById(R.id.editTextName), editTextEmail = findViewById(R.id.editTextEmail), editTextAge, editTextDateOfBirth;
    private Spinner spinnerCountry;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxAgree;
    private DatabaseHelper databaseHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextAge = findViewById(R.id.editTextAge);
        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);
        // Set click listener for the Submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserData();
            }
        });
    }
    private void saveUserData() {
        // Get user input
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        String country = spinnerCountry.getSelectedItem().toString();
        String dateOfBirth = editTextDateOfBirth.getText().toString();
        String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        boolean agreeTerms = checkBoxAgree.isChecked();
        // Create User object
        User user = new User(name, email, age, country, dateOfBirth, gender, agreeTerms);
        // Add user to the database
        long result = databaseHelper.addUser(user);
        // Display result
        if (result != -1) {
            Toast.makeText(this, "User data saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error saving user data", Toast.LENGTH_SHORT).show();
        }
    }
    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // Note: month is zero-based, so you may need to add 1 to it
                        String selectedDate = year + "-" + (month + 1) + "-" + day;
                        editTextDateOfBirth.setText(selectedDate);
                    }
                },
                // Set default date values (optional)
                2000, 0, 1
        );
        datePickerDialog.show();
    }
}

