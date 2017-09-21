package com.nfs.libraryprojectv2.Interface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nfs.libraryprojectv2.Interface.AdminOptions.AddLibrarianScreen;
import com.nfs.libraryprojectv2.Interface.AdminOptions.DeleteLibrarianPopUp;
import com.nfs.libraryprojectv2.R;

/**
 * Created by nafis on 15/09/2017.
 */

public class AdminPanelActivity extends AppCompatActivity {

    private Button logoutButton;
    private Button bttnAddLibrarian;
    private Button bttnDeleteLibrarian;
    private Button bttnViewLibrarians;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);

        bttnAddLibrarian = (Button) findViewById(R.id.Add_Librarian_Button);
        bttnAddLibrarian.setOnClickListener(e -> startAddLibrarianActivity());

        bttnViewLibrarians = (Button) findViewById(R.id.View_Librarians_Button);
        //bttnViewLibrarians.setOnClickListener(e -> startViewLibrariansActivity());

        bttnDeleteLibrarian = (Button) findViewById(R.id.Delete_Librarian_Button);
        bttnDeleteLibrarian.setOnClickListener(e -> startDeleteLibrarianActivity());

        logoutButton = (Button) findViewById(R.id.Admin_LogOut_Button);
        logoutButton.setOnClickListener(e -> finish());
    }

    private void startAddLibrarianActivity() {
        Intent intent = new Intent(this, AddLibrarianScreen.class);
        startActivity(intent);
    }

    private void startViewLibrariansActivity() {
        Intent intent = new Intent(this, AddLibrarianScreen.class);
        startActivity(intent);
    }
    private void startDeleteLibrarianActivity() {
        Intent intent = new Intent(this, DeleteLibrarianPopUp.class);
        startActivity(intent);
    }



}
