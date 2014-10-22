package com.apps.gator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.apps.gator.translator.util.ReadFile;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.apps.gator.input";
	public final static String PREFS_NAME = "Gator_Prefs_File";
	public final static String RADIO_BUTTON_MALAYALAM = "RADIO_BUTTON_MALAYALAM";
	public final static String RADIO_BUTTON_ENGLISH = "RADIO_BUTTON_ENGLISH";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// If your minSdkVersion is 11 or higher, instead use:
		// getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create a shared preference file to store the state of various
		// variables so that it can be shared throughout the app. Currently only
		// the two radio buttons state are stored.
		SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		// by default both radio buttons state is set to false.
		editor.putBoolean(RADIO_BUTTON_MALAYALAM, false);
		editor.putBoolean(RADIO_BUTTON_ENGLISH, false);
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_about:
			openAbout();
			return true;
		case R.id.action_refresh:
			openRefresh();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Open a Custom Dialog that shows basic information about the app.
	 * <ol>
	 * Developer Information
	 * </ol>
	 * <ol>
	 * Licensing Information
	 * </ol>
	 */
	private void openAbout() {
		Log.d("MainActivity.openAbout",
				"About Option from Overflow Action Menu is Selected.");
		AlertDialog.Builder alertboxBuilder = new AlertDialog.Builder(this);
		ReadFile readFile = new ReadFile();
		alertboxBuilder
				.setMessage(readFile.read())
				.setTitle("About Gator-Translator")
				.setNegativeButton(R.string.action_about,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// Once the OK button is clicked close the
								// dialog box.
								dialog.cancel();
							}
						});
		AlertDialog alertDialog = alertboxBuilder.create();
		alertDialog.show();
	}

	/**
	 * Clears the {@link EditText} which accepts the input from the user.
	 */
	private void openRefresh() {
		EditText editText = (EditText) findViewById(R.id.user_input_edit_message);
		editText.setText("");
	}

	/**
	 * Accepts the input from {@link EditText} view, trims it and sends it to
	 * {@link DisplayMessageActivity} activity.
	 * 
	 * @param view
	 *            current view.
	 */
	public void sendMessage(View view) {
		Log.i("MainActivity.sendMessage()",
				"Translate fucntionality was called.");
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.user_input_edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message.trim());
		Log.d("MainActivity.sendMessage",
				"The input received is: %s" + message.trim());
		startActivity(intent);
	}

	/**
	 * Updates {@link SharedPreferences} for the app of whether the
	 * {@value #RADIO_BUTTON_ENGLISH} or {@value #RADIO_BUTTON_MALAYALAM} is
	 * selected.
	 * 
	 * @param view
	 *            current view.
	 */
	public void languageRadioButtonClicked(View view) {
		Log.d("MainActivity.languageRadioButtonClicked",
				"A Language was selected.");

		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// We need an Editor object to make preference changes.
		// All objects are from android.context.Context
		SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,
				0);
		SharedPreferences.Editor editor = sharedPreferences.edit();

		switch (view.getId()) {
		case R.id.Malayalam:
			if (checked) {
				editor.putBoolean(RADIO_BUTTON_MALAYALAM, true);
			}
			break;
		case R.id.English:
			if (checked) {
				editor.putBoolean(RADIO_BUTTON_ENGLISH, true);
			}
			break;
		}
		editor.commit();
	}
}
