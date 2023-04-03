package co.sophea.mvcapp;

import co.sophea.mvcapp.contronller.IndexController;

public class MainProgram {
    public static void main(String[] args) {
        IndexController indexController = new IndexController();
        indexController.handleIndex();
    }
}
