package com.example.hnprf;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connectButton = (Button) findViewById(R.id.activity_main_connect_button);
        Button selectButton = (Button) findViewById(R.id.activity_main_select_button);
        Button settingButton = (Button) findViewById(R.id.activity_main_setting_button);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {toast.cancel();}

                Intent intent = new Intent(MainActivity.this, MainConnect.class);
                startActivity(intent);
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {toast.cancel();}

                toast = Toast.makeText(MainActivity.this, "你點擊了 " + selectButton.getText()  , Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {toast.cancel();}

                toast = Toast.makeText(MainActivity.this, "你點擊了 " + settingButton.getText()  , Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


}