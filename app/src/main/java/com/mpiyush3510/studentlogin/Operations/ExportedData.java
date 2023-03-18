package com.mpiyush3510.studentlogin.Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.mpiyush3510.studentlogin.R;
import com.mpiyush3510.studentlogin.databinding.ActivityExportedDataBinding;

public class ExportedData extends AppCompatActivity {
ActivityExportedDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExportedDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getExportedData();
    }

    private void getExportedData() {
        final Bundle bundle=getIntent().getExtras();
        final String FName=bundle.getString("FName");
        final String LName=bundle.getString("LName");
        final String Email=bundle.getString("Email");
        final String BirthDate=bundle.getString("BirthDate");
        final String PhoneNumber=bundle.getString("PhoneNumber");
        final String Designation=bundle.getString("Designation");
        final String Gender=bundle.getString("Gender");

        binding.FirstName.setText(String.valueOf(FName));
        binding.LastName.setText(String.valueOf(LName));
        binding.Email.setText(String.valueOf(Email));
        binding.BirthDate.setText(String.valueOf(BirthDate));
        binding.PhoneNumber.setText(String.valueOf(PhoneNumber));
        binding.Designation.setText(String.valueOf(Designation));
        binding.Gender.setText(String.valueOf(Gender));
        ShowToast("SuccessFully DataLoad");
    }
    private void ShowToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}