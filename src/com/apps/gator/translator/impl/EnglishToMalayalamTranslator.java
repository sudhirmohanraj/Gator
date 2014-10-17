package com.apps.gator.translator.impl;

import java.util.HashMap;
import java.util.Map;

import com.apps.gator.translator.Translator;
import com.apps.gator.translator.util.ReadFile;

/**
 * Converts a given word from English to Malayalam.
 * <ol>If a word exists in the look up file {@link #fileName}</ol>
 * <ol>else returns {@link #MESSAGE}</ol>
 * @author sudhir mohanraj
 * 
 */
public class EnglishToMalayalamTranslator implements Translator {

	public static String fileName = "EnglishToMalayalam.txt";
	public static String MESSAGE = "Sorry the given word could not be translated to Malayalam";
	public ReadFile readFile = new ReadFile();

	@SuppressWarnings("static-access")
	@Override
	public TranslatorResponse translate(String inputText) {
		HashMap<String, String> result = new HashMap<String, String>();
		Boolean textFound = false;
		result = readFile.read(fileName);
		String matchingText = null;
		for (Map.Entry<String, String> entry : result.entrySet()) {
			// to accommodate for input that can be the same word but might have
			// a different case for e.g. 'nee' is the same as 'Nee' or any
			// variation of this. And all of them mean You.
			if (entry.getKey().equalsIgnoreCase(inputText)) {
				matchingText = entry.getValue();
				textFound = true;
			}
		}

		// To handle the case where the given word by the user could not be
		// found in the data used by the application.
		if (textFound == false) {
			matchingText = MESSAGE;
		}
		TranslatorResponse response = new TranslatorResponse();
		response.setLookupResponse(matchingText);
		return response;
	}
}
