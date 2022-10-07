package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.CorresponsalPrincipal;

public interface InterfaceCorresponsal {

    interface View {
        void variables();
        void loginSucess();
        void error();
    }

    interface Presenter {
        void Login(CorresponsalPrincipal corresponsal);
        void validarLogin();
        void error();
    }

    interface Model {
        boolean Iniciar(CorresponsalPrincipal corresponsal);
    }
}
