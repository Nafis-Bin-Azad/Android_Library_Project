package com.nfs.libraryprojectv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import com.nfs.libraryprojectv2.Interface.AdminLoginActivity;
import com.nfs.libraryprojectv2.Interface.LibrarianLoginActivity;
import com.nfs.libraryprojectv2.Data.Library;

public class MainActivity extends AppCompatActivity{

    Library library;
    private Button
            AdminLaunchActivityButton,
            LibrarianLaunchActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        initiateData();
        initiateInterface();
    }

    private void initiateData() {
        //library = new Library();
    }

    private void initiateInterface() {
        AdminLaunchActivityButton = (Button) findViewById(R.id.Admin_Login_Button);
        AdminLaunchActivityButton.setOnClickListener(e -> launchActivity(true));
        LibrarianLaunchActivityButton = (Button) findViewById(R.id.Librarian_Login_Button);
        LibrarianLaunchActivityButton.setOnClickListener(e -> launchActivity(false));
    }


    private void launchActivity(boolean Admin) {
        Intent intent;
        if (Admin) intent = new Intent(this, AdminLoginActivity.class);
        else intent = new Intent(this, LibrarianLoginActivity.class);
        startActivity(intent);
    }
}