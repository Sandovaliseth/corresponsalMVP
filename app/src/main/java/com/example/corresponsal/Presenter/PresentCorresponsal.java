package com.example.corresponsal.Presenter;

import android.content.Context;

import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.Models.ModelCorresponsal;
import com.example.corresponsal.entidades.Corresponsal;

public class PresentCorresponsal implements InterfaceCorresponsal.Presenter {

    InterfaceCorresponsal.View view;
    InterfaceCorresponsal.Model model;
    Context context;

    public PresentCorresponsal (InterfaceCorresponsal.View view, Context context) {
        this.view = view;
        this.context = context;
        this.model = new ModelCorresponsal(this, context);
    }

    @Override
    public void Login(Corresponsal corresponsal) {
        if(this.model.Iniciar(corresponsal)){
            validarLogin();
        }else{
            error();
        }
    }

    @Override
    public void insertar(Corresponsal corresponsal) {
        this.model.registrarCorresponsal(corresponsal);
    }

    @Override
    public void consultar(Corresponsal corresponsal) {
        this.model.consultarCorresponsal(corresponsal);
    }

    @Override
    public void listado() {
        this.model.mostrarCorresponsal();
    }

    @Override
    public void validarLogin() {
        this.view.loginSucess();
    }

    @Override
    public void error() {
        this.view.error();
    }
}
