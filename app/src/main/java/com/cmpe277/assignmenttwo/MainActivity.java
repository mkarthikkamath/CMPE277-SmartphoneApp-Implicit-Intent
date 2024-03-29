package com.cmpe277.assignmenttwo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends Activity {
    EditText addurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addurl = findViewById(R.id.urlInput);
        addurl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Patterns.WEB_URL.matcher(addurl.getText().toString()).matches()) {
                    //
                } else {
                    addurl.setError("Invalid Url");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void link(View view) {
        EditText edit = (EditText) findViewById(R.id.urlInput);
        String result = edit.getText().toString();
        Uri uri = Uri.parse(result);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void dial(View view) {
        EditText edit = (EditText) findViewById(R.id.phoneInput);
        String result = edit.getText().toString();
        Uri uri = Uri.parse("tel:" + result);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

}