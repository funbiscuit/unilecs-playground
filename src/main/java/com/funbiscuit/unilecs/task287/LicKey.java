package com.funbiscuit.unilecs.task287;

import java.util.Locale;

public class LicKey {
    public static String updateLicenseKey(String key, int k) {
        char[] chars = key.replaceAll("-", "").toCharArray();

        int charsTillDash = chars.length % k;
        if (charsTillDash == 0) {
            charsTillDash += k;
        }

        StringBuilder builder = new StringBuilder();

        for (char ch : chars) {
            if (charsTillDash == 0) {
                charsTillDash += k;
                builder.append('-');
            }
            builder.append(ch);
            charsTillDash--;
        }

        return builder.toString().toUpperCase(Locale.ROOT);
    }
}
