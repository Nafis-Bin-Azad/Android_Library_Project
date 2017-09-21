package com.nfs.libraryprojectv2.Interface.AdminOptions;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nfs.libraryprojectv2.R;

/**
 * Created by nafis on 15/09/2017.
 */

public class AddLibrarianScreen extends Activity {


    private Button mBtGoBack;
    private Button mBtAddLibrarian;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_librarian);

        mBtAddLibrarian = (Button) findViewById(R.id.AddLibrarianButton);
        mBtAddLibrarian.setOnClickListener(e -> addLibrarian());

        mBtGoBack = (Button) findViewById(R.id.return_button);
        mBtGoBack.setOnClickListener(e -> finish());
    }

    private void addLibrarian() {

    }
}
