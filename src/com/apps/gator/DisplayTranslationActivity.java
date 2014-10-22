package com.apps.gator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.gator.translator.Translator;
import com.apps.gator.translator.Translator.TranslateType;
import com.apps.gator.translator.impl.TranslatorResponse;

public class DisplayTranslationActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// retrieve the shared preferences file which has stored the radio
		// buttons state information.
		SharedPreferences prefs = this.getSharedPreferences(
				MainActivity.PREFS_NAME, Context.MODE_PRIVATE);

		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		// Create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);

		// Logic to determine if the user selected to translate from English to
		// Malayalam or Malayalam to English.
		if (prefs.getBoolean(MainActivity.RADIO_BUTTON_MALAYALAM, false)) {
			Log.d("DisplayMessageActivity.onCreate",
					"Translate to Malayalam was selected.");
			final Translator translator = Translator.Factory
					.create(TranslateType.ENGLISH_TO_MALAYALAM);
			TranslatorResponse response = translator.translate(message);
			textView.setText(response.getLookupResponse());
		} else if (prefs.getBoolean(MainActivity.RADIO_BUTTON_ENGLISH, false)) {
			Log.d("DisplayMessageActivity.onCreate",
					"Translate to English was selected.");
			final Translator translator = Translator.Factory
					.create(TranslateType.MALAYALM_TO_ENGLISH);
			TranslatorResponse response = translator.translate(message);
			textView.setText(response.getLookupResponse());

		}
		// Just fall back logic to make sure the User experience is not
		// affected.
		else {
			textView.setText("Please select if you would like to translate to Malayalam or English on the Home View");
		}
		// Set the text view as the activity layout
		setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings_display_translation) {
			openReportError();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void openReportError() {
		Toast.makeText(getBaseContext(), "Report Error", Toast.LENGTH_LONG).show();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_display_translation,
					container, false);
			return rootView;
		}
	}
}
