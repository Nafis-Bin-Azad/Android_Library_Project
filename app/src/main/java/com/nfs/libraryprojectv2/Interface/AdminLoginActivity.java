package com.nfs.libraryprojectv2.Interface;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nfs.libraryprojectv2.Data.Admin;
import com.nfs.libraryprojectv2.Data.User;
import com.nfs.libraryprojectv2.R;

/**
 * Created by nafis on 15/09/2017.
 */

public class AdminLoginActivity extends Activity {

    private EditText editUsername, editPassword;
    private Button mBtGoBack,mBtLogin;
    FirebaseDatabase database;
    DatabaseReference userTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        editUsername = (EditText) findViewById(R.id.username_input_field);
        editPassword = (EditText) findViewById(R.id.password_input_field);


        mBtLogin = (Button) findViewById(R.id.AdminLoginButton);
        mBtLogin.setOnClickListener(e -> login2());

        mBtGoBack = (Button) findViewById(R.id.AdminLoginGoBackButton);
        mBtGoBack.setOnClickListener(e -> finish());

        database = FirebaseDatabase.getInstance();
        userTable = database.getReference("Admin");

    }

    private void login() {
        Intent intent = new Intent(this, AdminPanelActivity.class);
        startActivity(intent);
    }

    private void login2() {
        ProgressDialog dialog = new ProgressDialog(AdminLoginActivity.this);
        dialog.setMessage("Please Wait....");
        dialog.show();

        userTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get User Information
                if(!editUsername.getText().toString().isEmpty()) {
                    if (dataSnapshot.child(editUsername.getText().toString()).exists()) {
                        dialog.dismiss();
                        //Toast.makeText(AdminLoginActivity.this,"hello" , Toast.LENGTH_SHORT).show();

                        Admin admin= dataSnapshot.child(editUsername.getText().toString()).getValue(Admin.class);
                        if (admin.getPassword().equals(editPassword.getText().toString())) {
                            Toast.makeText(AdminLoginActivity.this, "Signed In Succesfully", Toast.LENGTH_SHORT).show();
                            login();
                        } else {
                            Toast.makeText(AdminLoginActivity.this, "Sign In Failed, Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        dialog.dismiss();
                        Toast.makeText(AdminLoginActivity.this, "Sign In Failed, Username does not exist", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    dialog.dismiss();
                    Toast.makeText(AdminLoginActivity.this, "Fill in Username and Password details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
