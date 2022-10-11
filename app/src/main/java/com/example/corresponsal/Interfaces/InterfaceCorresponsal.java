package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.CorresponsalPrincipal;

import java.util.ArrayList;

public interface InterfaceCorresponsal {

    interface View {
        void variables();
        void loginSucess();
        void error();
    }

    interface Presenter {
        void Login(CorresponsalPrincipal corresponsal);
        void insertar(CorresponsalPrincipal corresponsal);
        void consultar(CorresponsalPrincipal corresponsal);
        void listado();
        void validarLogin();
        void error();
    }

    interface Model {
        boolean Iniciar(CorresponsalPrincipal corresponsal);
        long registrarCorresponsal(CorresponsalPrincipal corresponsal);
        ArrayList<CorresponsalPrincipal> mostrarCorresponsal();
        CorresponsalPrincipal consultarCorresponsal(CorresponsalPrincipal corresponsal);
    }
}
