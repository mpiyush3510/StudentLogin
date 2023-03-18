package com.mpiyush3510.studentlogin.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mpiyush3510.studentlogin.MainActivity;
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
        binding.BtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate()){
                    Intent intent=new Intent(SignIn.this, MainActivity.class);
                    ShowToast("SuccessFully signIn ✅");
                    startActivity(intent);
                }
            }
        });
    }
    private Boolean isValidate(){
        if (binding.EmailOrPhone.getText().toString().isEmpty()){
            ShowToast("Enter User id");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.EmailOrPhone.getText().toString()).matches() && !Patterns.PHONE.matcher(binding.EmailOrPhone.getText().toString()).matches()) {
            ShowToast("Enter Correct  User Id");
            return false;
        } else if (binding.Password.getText().toString().isEmpty()) {
            ShowToast("PassWord Can't Be Empty");
            return false;
        } else if (binding.Password.length()<3) {
            ShowToast("Password Length AtLeast 3 ");
            return false;
        }else{
            return true;
        }
    }

    private void ShowToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}