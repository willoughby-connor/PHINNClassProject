package com.zybooks.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements OnItemSelectedListener{

    private EditText username;
    private Context myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Assigning Listeners for the Navigation Bar at the Top of the Screen
        Button homeButton = (Button) findViewById(R.id.button1);
        homeButton.setOnClickListener(new View.OnClickListener()
        {
            //Pre-conditions: the homeButton is clicked
            //Post-conditions: the HomeActivity is the current activity
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), HomeActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
        Button goalsButton = (Button) findViewById(R.id.button2);
        goalsButton.setOnClickListener(new View.OnClickListener()
        {
            //Pre-conditions: the surveyButton is clicked
            //Post-conditions: the QuestionnaireActivity is the current activity
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), GoalsActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
        Button moodButton = (Button) findViewById(R.id.button3);
        moodButton.setOnClickListener(new View.OnClickListener()
        {
            //Pre-conditions: the moodButton is clicked
            //Post-conditions: the MoodTrackerActivity is the current activity
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MoodTrackerActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

        Spinner menuSpinner = (Spinner) findViewById(R.id.menuSpinner);

        // Spinner click listener
        menuSpinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,

                R.array.menuOptions, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        menuSpinner.setAdapter(adapter);

        Button notificationButton = (Button) findViewById(R.id.notificationsButton);
        notificationButton.setOnClickListener(new View.OnClickListener()
        {
            //Pre-conditions: the notificationButton is clicked
            //Post-conditions: the NotificationSettingsActivity is the current activity
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),NotificationSettingsActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
        myContext = this;
        Button testButton = (Button) findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener()
        {
            //Pre-conditions: the testButton is clicked
            //Post-conditions: a notification is sent as a proof of concept
            public void onClick(View view) {
                NotificationController controller = new NotificationController(myContext);
                controller.sendFriendlyNotification(myContext, view);
            }

        });

        Settings settings = ((PHINN)getApplication()).getSettings();
        username = (EditText) findViewById(R.id.preferredNameInput);
        if(settings.getPreferredName(this) != null) {
            username.setText(settings.getPreferredName(this));
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        Settings settings = ((PHINN) getApplication()).getSettings();
        username = (EditText) findViewById(R.id.preferredNameInput);
        settings.setPreferredName(this, username.getText().toString());
    }
    //Controls the menu dropdown
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(item.equals("Resources"))
        {
            Intent intent = new Intent(view.getContext(), ResourcesActivity.class);
            startActivityForResult(intent, 0);
        }
        else if(item.equals("Profile"))
        {
            Intent intent = new Intent(view.getContext(), ProfileActivity.class);
            startActivityForResult(intent, 0);
        }

    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}