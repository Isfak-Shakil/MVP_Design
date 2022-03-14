package com.example.mvpdesign.presenter;

import com.example.mvpdesign.model.IUser;
import com.example.mvpdesign.model.User;
import com.example.mvpdesign.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    @Override
    public void doLogin(String email, String password) {
        IUser iUser=new User(email,password);
        int login_code=iUser.checkUserValidity();

        if (login_code==0){
            iLoginView.onLoginError("enter email");
        }
        else if (login_code==1){
            iLoginView.onLoginError("enter valid email");
        }
        else if (login_code==2){
            iLoginView.onLoginError("enter password");
        }
        else if (login_code==3){
            iLoginView.onLoginError("password should be more than 6 character");
        }
        else {
            iLoginView.onLoginSuccess("Success");
        }

    }
    private ILoginView iLoginView;
    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }
}
