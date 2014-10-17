package com.apps.gator.translator.impl;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.apps.gator.translator.Translator;
import com.apps.gator.translator.util.ReadFile;

public class EnglishToMalayalamTranslator implements Translator {

	public static String fileName = "EnglishToMalayalam.txt";
	public ReadFile readFile = new ReadFile();

	@Override
	public TranslatorResponse translate(String inputText) {
		HashMap<String, String> result = new HashMap<String, String>();
		result = readFile.read(fileName);
		String matchingText = null;
		for (Map.Entry<String, String> entry : result.entrySet()) {
			if (entry.getKey().equals(inputText)) {
				matchingText = entry.getValue();
			}
		}
		TranslatorResponse response = new TranslatorResponse();
		response.setLookupResponse(matchingText);
		return response;
	}

}
