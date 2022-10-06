package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Corresponsal;

public interface InterfaceCorresponsal {

    interface View {
        void variables();
        void loginSucess();
        void error();
    }

    interface Presenter {
        void Login(Corresponsal corresponsal);
        void validarLogin();
        void error();
    }

    interface Model {
        boolean Iniciar(Corresponsal corresponsal);
    }
}
