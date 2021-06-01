package com.debacharya.jflow.util;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public final class Utility {

	private static final String UPPERCASE_ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE_ALPHABETS = UPPERCASE_ALPHABETS.toLowerCase(Locale.ROOT);
	private static final String DIGITS = "0123456789";
	private static final String ALPHA_NUMERIC = UPPERCASE_ALPHABETS + LOWERCASE_ALPHABETS + DIGITS;
	private static final char[] ALPHA_NUMERIC_CHARACTERS = ALPHA_NUMERIC.toCharArray();

	private Utility() {}

	public static int generateRandomInteger() {
		return ThreadLocalRandom.current().nextInt();
	}

	public static String generateRandomLabel() {
		return Utility.generateRandomAlphanumericString(12);
	}

	public static String generateRandomAlphanumericString(int length) {

		final char[] buffer = new char[length];

		for(int i = 0; i < length; i++)
			buffer[i] = ALPHA_NUMERIC_CHARACTERS[ThreadLocalRandom.current().nextInt(ALPHA_NUMERIC_CHARACTERS.length)];

		return new String(buffer);
	}

	public static double roundOff(double value, double decimalPlace) {

		if(value == Double.MAX_VALUE || value == Double.MIN_VALUE) return value;

		decimalPlace = Math.pow(10, decimalPlace);

		return (Math.round(value * decimalPlace) / decimalPlace);
	}
}
