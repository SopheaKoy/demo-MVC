package co.sophea.mvcapp.contronller;

import co.sophea.mvcapp.view.WelcomeView;

public class IndexController {
    public void handleIndex(){
        new WelcomeView().render();
    }
}
