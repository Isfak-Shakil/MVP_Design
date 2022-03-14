package com.example.mvpdesign.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpdesign.R;
import com.example.mvpdesign.presenter.ILoginPresenter;
import com.example.mvpdesign.presenter.LoginPresenter;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements ILoginView {
  private   TextInputEditText userName,pass;
    private Button button;
    private ProgressBar progressBar;

    private ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.userNameId);
        pass=findViewById(R.id.passId);
        button=findViewById(R.id.buttonId);
        progressBar=findViewById(R.id.progressBarId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoginPresenter.doLogin(userName.getText().toString().trim(),pass.getText().toString().trim());
            }
        });

        iLoginPresenter=new LoginPresenter(this);

    }

    @Override
    public void onLoginSuccess(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}