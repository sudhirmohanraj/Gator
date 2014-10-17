package com.apps.gator.translator.impl;

import com.apps.gator.translator.Translator;

/**
 * Response for the {@link Translator}
 * <ol>
 * A String containing the translated output.
 * </ol>
 * 
 * @author sudhir mohanraj
 * 
 */
public class TranslatorResponse {

	String lookupResponse;

	public void setLookupResponse(String lookupResponse) {
		this.lookupResponse = lookupResponse;
	}

	public String getLookupResponse() {
		return lookupResponse;
	}
}
