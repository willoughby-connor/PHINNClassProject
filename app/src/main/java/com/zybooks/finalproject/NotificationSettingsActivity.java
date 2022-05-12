package com.zybooks.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Switch;

public class NotificationSettingsActivity extends AppCompatActivity implements OnItemSelectedListener {
    private Switch friendlyNotifications;
    private Switch exerciseReminders;
    private Switch breakReminders;
    private Switch surveyReminders;
    private Switch friendReminders;
    private Activity myActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

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

        myActivity = this;
        Button saveButton = (Button) findViewById(R.id.saveNotificationButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            //Pre-conditions: the saveButton is clicked
            //Post-conditions: the Profile is the current activity and preferences are saved
            public void onClick(View view) { ;

                Settings settings = ((PHINN)getApplication()).getSettings();
                Switch friendlyNotifications = (Switch) findViewById(R.id.switch1);
                Switch exerciseReminders = (Switch) findViewById(R.id.switch2);
                Switch breakReminders = (Switch) findViewById(R.id.switch3);
                Switch surveyReminders = (Switch) findViewById(R.id.switch4);
                Switch friendReminders = (Switch) findViewById(R.id.switch5);


                settings.setFriendlyNotificationsOn(myActivity, friendlyNotifications.isChecked());
                settings.setExerciseRemindersOn(myActivity, exerciseReminders.isChecked());
                settings.setBreakRemindersOn(myActivity, breakReminders.isChecked());
                settings.setSurveyRemindersOn(myActivity, surveyReminders.isChecked());
                settings.setFriendRemindersOn(myActivity, friendReminders.isChecked());

                Intent myIntent = new Intent(view.getContext(), ProfileActivity.class);
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

        //Update all switches based on settings
        Settings settings = ((PHINN)getApplication()).getSettings();

        Switch friendlyNotifications = (Switch) findViewById(R.id.switch1);
        Switch exerciseReminders = (Switch) findViewById(R.id.switch2);
        Switch breakReminders = (Switch) findViewById(R.id.switch3);
        Switch surveyReminders = (Switch) findViewById(R.id.switch4);
        Switch friendReminders = (Switch) findViewById(R.id.switch5);

        friendlyNotifications.setChecked(settings.areFriendlyNotificationsOn(this));
        exerciseReminders.setChecked(settings.areExerciseRemindersOn(this));
        breakReminders.setChecked(settings.areBreakRemindersOn(this));
        surveyReminders.setChecked(settings.areSurveyRemindersOn(this));
        friendReminders.setChecked(settings.areFriendRemindersOn(this));

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