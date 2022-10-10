package com.example.corresponsal.Presenter;

import android.content.Context;

import com.example.corresponsal.Interfaces.InterfaceBanco;
import com.example.corresponsal.Models.ModelBanco;
import com.example.corresponsal.entidades.Banco;

public class PresentBanco implements InterfaceBanco.Presenter {

    InterfaceBanco.View view;
    InterfaceBanco.Model model;
    Context context;

    public PresentBanco (InterfaceBanco.View view, Context context) {
        this.view = view;
        this.context = context;
        this.model = new ModelBanco(this, context);
    }

    @Override
    public void Login(Banco banco) {
        if(this.model.Iniciar(banco)){
            validarLogin();
        }else{
            error();
        }
    }

    @Override
    public void validarLogin() {
        this.view.loginSucessB();
    }

    @Override
    public void error() {
        this.view.error();
    }
}
