package com.mpiyush3510.studentlogin.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mpiyush3510.studentlogin.R;
import com.mpiyush3510.studentlogin.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    String[] Designation={"Ceo","Admin","Technician","Developer","Engineer","Manager","Student"};
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.lst_item,Designation);
        binding.Designation.setAdapter(arrayAdapter);
        binding.Designation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();
                ShowToast(item);
            }
        });
        Listeners();
    }

    private void Listeners() {
        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this, SignIn.class);
                ShowToast("😁");
                startActivity(intent);
            }
        });
        binding.BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate()){
                    Intent intent=new Intent(SignUp.this, SignIn.class);
                    ShowToast("Successfully SignUp ✅");
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isValidate() {
        if (binding.FirstName.getText().toString().isEmpty()) {
            ShowToast("Please Enter First Name");
            return false;
        } else if (binding.LastName.getText().toString().isEmpty()) {
            ShowToast("Please Enter Your Surname");
            return false;
        } else if (binding.Email.getText().toString().isEmpty()) {
            ShowToast("Please Enter Your Mail");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.Email.getText().toString()).matches()) {
            ShowToast("Enter Correct Email");
            return false;
        } else if (binding.PhoneNumber.getText().toString().isEmpty()) {
            ShowToast("Please Enter Your Phone");
            return false;
        } else if (!Patterns.PHONE.matcher(binding.PhoneNumber.getText().toString()).matches()) {
            ShowToast("Enter Correct Phone");
            return false;
        } else if (binding.BirthDate.getText().toString().isEmpty()) {
            ShowToast("Enter Your BDate");
            return false;
        } else if (!binding.Male.isChecked() && !binding.Female.isChecked()) {
            ShowToast("Please Choose Gender");
            return false;
        } else if (binding.Designation.getText().toString().isEmpty()) {
            ShowToast("Designation Must Be Selected");
            return false;
        } else {
            return true;
        }
    }
    private void ShowToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}