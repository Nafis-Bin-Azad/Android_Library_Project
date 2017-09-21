package com.nfs.libraryprojectv2.Interface.AdminOptions;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import com.nfs.libraryprojectv2.R;

/**
 * Created by nafis on 19/09/2017.
 */

public class DeleteLibrarianPopUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_librarian);

        DisplayMetrics displaySize = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaySize);
        int width = displaySize.widthPixels;
        int height = displaySize.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.5));
    }
}
