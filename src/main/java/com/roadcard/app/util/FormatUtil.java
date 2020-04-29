package com.roadcard.app.util;

public class FormatUtil {
    public static boolean validaCpf(String cpf) {
        if(Character.isDigit(cpf.charAt(0))){
            return true;
        }
        return false;
    }
}
