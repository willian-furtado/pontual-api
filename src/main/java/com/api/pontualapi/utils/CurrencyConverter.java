package com.api.pontualapi.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter {

    public static String formatCurrency(BigDecimal valor) {
        if (valor != null) {
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            return formatoMoeda.format(valor);
        }
        return "";
    }
}
