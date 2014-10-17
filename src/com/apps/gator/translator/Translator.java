package com.apps.gator.translator;

import android.content.Context;

import com.apps.gator.translator.impl.EnglishToMalayalamTranslator;
import com.apps.gator.translator.impl.MalayalamToEnglishTranslator;
import com.apps.gator.translator.impl.TranslatorResponse;

/**
 * Performs Translation of a single word from malayalam to english and
 * vice-versa depending on the type of translation required. Type of translation
 * is defined by {@link TranslateType}
 * 
 * @author sudhir mohanraj
 * 
 */
public interface Translator {

	public TranslatorResponse translate(String inputText);

	/**
	 * Creates an instance of:
	 * <ol>
	 * {@link MalayalamToEnglishTranslator} if the
	 * {@link TranslateType#MALAYALM_TO_ENGLISH}
	 * </ol>
	 * <ol>
	 * {@link EnglishToMalayalamTranslator} if the
	 * {@link TranslateType#ENGLISH_TO_MALAYALAM}
	 * </ol>
	 * 
	 * @author sudhir mohanraj
	 * 
	 */
	public static class Factory {
		public static Translator create(TranslateType translateType) {
			switch (translateType) {
			case MALAYALM_TO_ENGLISH:
				return new MalayalamToEnglishTranslator();
			case ENGLISH_TO_MALAYALAM:
				return new EnglishToMalayalamTranslator();
			default:
				final String message = String.format(
						"The rendition type of [%s] is unsupported",
						translateType);
				throw new UnsupportedOperationException(message);
			}
		}
	}

	/**
	 * Enum indicating whether the translation
	 * <ol>
	 * MALAYALM_TO_ENGLISH - input is in malayalam and translated to english.
	 * </ol>
	 * <ol>
	 * ENGLISH_TO_MALAYALAM - input is in english and translated to malayalam.
	 * </ol>
	 * 
	 * @author sudhir mohanraj
	 */
	public enum TranslateType {

		MALAYALM_TO_ENGLISH,

		ENGLISH_TO_MALAYALAM;

	}

}
