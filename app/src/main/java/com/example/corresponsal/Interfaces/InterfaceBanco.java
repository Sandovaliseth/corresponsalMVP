package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Banco;

public interface InterfaceBanco {

    interface View {
        void variables();
        void loginSucess();
        void error();
    }

    interface Presenter {
        void Login(Banco banco);
        void validarLogin();
        void error();
    }

    interface Model {
        boolean Iniciar(Banco banco);
    }

}
