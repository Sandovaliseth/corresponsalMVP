package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Corresponsal;

import java.util.ArrayList;

public interface InterfaceCorresponsal {

    interface View {
        void variables();
        void loginSucess();
        void error();
    }

    interface Presenter {
        void Login(Corresponsal corresponsal);
        void insertar(Corresponsal corresponsal);
        void consultar(Corresponsal corresponsal);
        void listado();
        void validarLogin();
        void error();
    }

    interface Model {
        boolean Iniciar(Corresponsal corresponsal);
        long registrarCorresponsal(Corresponsal corresponsal);
        ArrayList<Corresponsal> mostrarCorresponsal();
        Corresponsal consultarCorresponsal(Corresponsal corresponsal);
    }
}
