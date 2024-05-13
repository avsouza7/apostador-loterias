package br.com.avsouza7.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormataMonetario {

	private static final Locale PT_BR = new Locale("pt", "BR");

	private FormataMonetario() {
	}

	public static String brasileiro(Number valor) {
		NumberFormat.getInstance(PT_BR);
		return NumberFormat.getCurrencyInstance().format(valor);
	}

}
