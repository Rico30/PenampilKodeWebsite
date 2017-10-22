package com.example.rico.penampilkodeweb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    static TextView mytext;
    static EditText edittxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytext = (TextView)findViewById(R.id.myResult);
        edittxt = (EditText)findViewById(R.id.input);
    }

    public void doSomething(View view) {
        ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            c1 = new ConnectInternetTask(this);

            String inputan = edittxt.getText().toString();
            c1.execute(inputan);
        } else {
            Toast.makeText(getApplication(), "Periksa Jaringan Internet", Toast.LENGTH_SHORT).show();
        }

    }
}
