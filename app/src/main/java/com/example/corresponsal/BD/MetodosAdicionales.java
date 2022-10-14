package com.example.corresponsal.BD;

import android.widget.Toast;

import java.util.regex.Pattern;

public class MetodosAdicionales {

    public static boolean vacioValidar(String dato) {
        return !dato.equals("");
    }

    public static boolean validarMayusculas(String dato) {
        Pattern mayusculas = Pattern.compile("^" + "[A-Z\\s]+" + "$");
        if (mayusculas.matcher(dato).matches()) {
            return true;
        }
        return false;
    }

}
