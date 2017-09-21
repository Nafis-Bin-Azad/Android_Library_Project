package com.nfs.libraryprojectv2.Interface;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nfs.libraryprojectv2.Data.Admin;
import com.nfs.libraryprojectv2.R;

/**
 * Created by nafis on 15/09/2017.
 */

public class LibrarianLoginActivity extends AppCompatActivity {

    private EditText editUsername, editPassword;
    private Button mBtGoBack,mBtLogin;
    private FirebaseDatabase database;
    private DatabaseReference userTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian_login);

        editUsername = (EditText) findViewById(R.id.lib_username_input_field);
        editPassword = (EditText) findViewById(R.id.lib_password_input_field);

        mBtLogin  = (Button) findViewById(R.id.LibrarianLoginButton);
        mBtLogin.setOnClickListener(e -> login2());
        mBtGoBack = (Button) findViewById(R.id.LibrarianLoginGoBackButton);
        mBtGoBack.setOnClickListener(e -> finish());


        database = FirebaseDatabase.getInstance();
        userTable = database.getReference("Librarian");
    }



    private void login() {
        Intent intent = new Intent(this, LibrarianPanelActivity.class);
        startActivity(intent);
    }

    private void login2() {
        ProgressDialog dialog = new ProgressDialog( LibrarianLoginActivity.this);
        dialog.setMessage("Please Wait....");
        dialog.show();

        userTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get User Information
                if(!editUsername.getText().toString().isEmpty()) {
                    if (dataSnapshot.child(editUsername.getText().toString()).exists()) {
                        dialog.dismiss();

                        Admin admin= dataSnapshot.child(editUsername.getText().toString()).getValue(Admin.class);
                        if (admin.getPassword().equals(editPassword.getText().toString())) {
                            Toast.makeText(LibrarianLoginActivity.this, "Signed In Succesfully", Toast.LENGTH_SHORT).show();
                            login();
                        } else {
                            Toast.makeText(LibrarianLoginActivity.this, "Sign In Failed, Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        dialog.dismiss();
                        Toast.makeText(LibrarianLoginActivity.this, "Sign In Failed, Username does not exist", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    dialog.dismiss();
                    Toast.makeText(LibrarianLoginActivity.this, "Fill in Username and Password details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
