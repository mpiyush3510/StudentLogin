package com.mpiyush3510.studentlogin.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mpiyush3510.studentlogin.R;
import com.mpiyush3510.studentlogin.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {
ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Listeners();
    }

    private void Listeners() {
        binding.CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this, SignUp.class);
                ShowToast("😁");
                startActivity(intent);
            }
        });
    }

    private void ShowToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}