package com.zybooks.finalproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Settings
{
    private static String CLASS_NAME;

    private static String FRIENDLY_NOTIFICATIONS = "friendlyNotifications";
    private static String EXERCISE_REMINDERS = "exerciseReminders";
    private static String BREAK_REMINDERS = "breakReminders";
    private static String SURVEY_REMINDERS = "surveyReminders";
    private static String FRIEND_REMINDERS = "friendReminders";
    private static String PREFERRED_NAME = "preferredName";

    protected boolean friendlyNotificationsOn;
    protected boolean exerciseRemindersOn;
    protected boolean breakRemindersOn;
    protected boolean surveyRemindersOn;
    protected boolean friendRemindersOn;
    protected String preferredName;


    public Settings()
    {
        CLASS_NAME = getClass().getName();
    }

    public void setPreferredName(Activity activity, String name)
    {
        preferredName = name;
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(PREFERRED_NAME, name);
        editor.apply();
    }

    public void setFriendlyNotificationsOn(Activity activity, boolean friendlyNotifications)
    {
        friendlyNotificationsOn = friendlyNotifications;
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putBoolean(FRIENDLY_NOTIFICATIONS, friendlyNotifications);
        editor.apply();
    }

    public void setExerciseRemindersOn(Activity activity, boolean exerciseReminders)
    {
        exerciseRemindersOn = exerciseReminders;
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putBoolean(EXERCISE_REMINDERS, exerciseReminders);
        editor.apply();
    }

    public void setBreakRemindersOn(Activity activity, boolean breakReminders)
    {
        breakRemindersOn = breakReminders;
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putBoolean(BREAK_REMINDERS, breakReminders);
        editor.apply();
    }

    public void setSurveyRemindersOn(Activity activity, boolean surveyReminders)
    {
        surveyRemindersOn = surveyReminders;
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putBoolean(SURVEY_REMINDERS, surveyReminders);
        editor.apply();
    }

    public void setFriendRemindersOn(Activity activity, boolean friendReminders)
    {
        friendRemindersOn = friendReminders;
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putBoolean(FRIEND_REMINDERS, friendReminders);
        editor.apply();
    }

    public String getPreferredName(Activity activity)
    {
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        if(preferences.contains(PREFERRED_NAME))
        {
            preferredName = preferences.getString(PREFERRED_NAME, "User");
        }
        return preferredName;
    }

    public boolean areFriendlyNotificationsOn(Activity activity)
    {
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        if(preferences.contains(FRIENDLY_NOTIFICATIONS))
        {
            friendlyNotificationsOn = preferences.getBoolean(FRIENDLY_NOTIFICATIONS, false);
        }
        return friendlyNotificationsOn;
    }

    public boolean areBreakRemindersOn(Activity activity)
    {
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        if(preferences.contains(BREAK_REMINDERS))
        {
            breakRemindersOn = preferences.getBoolean(BREAK_REMINDERS, false);
        }
        return breakRemindersOn;
    }

    public boolean areExerciseRemindersOn(Activity activity)
    {
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        if(preferences.contains(EXERCISE_REMINDERS))
        {
            exerciseRemindersOn = preferences.getBoolean(EXERCISE_REMINDERS, false);
        }
        return exerciseRemindersOn;
    }

    public boolean areSurveyRemindersOn(Activity activity)
    {
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        if(preferences.contains(SURVEY_REMINDERS))
        {
            surveyRemindersOn = preferences.getBoolean(SURVEY_REMINDERS, false);
        }
        return surveyRemindersOn;
    }

    public boolean areFriendRemindersOn(Activity activity)
    {
        SharedPreferences preferences = activity.getPreferences(Activity.MODE_PRIVATE);
        if(preferences.contains(FRIEND_REMINDERS))
        {
            friendRemindersOn = preferences.getBoolean(FRIEND_REMINDERS, false);
        }
        return friendRemindersOn;
    }




}
