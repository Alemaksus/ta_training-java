package com.epam.training.student_aleksandr_maksakov.validations_color_code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        // Put your code here
        if (color == null || color.isEmpty()) return false;
        Pattern pattern = Pattern.compile("#([a-fA-F\\d]{3}|[a-fA-F\\d]{6})");
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }
}





