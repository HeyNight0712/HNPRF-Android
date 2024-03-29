package com.example.hnprf;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Set;

public class MainConnect extends AppCompatActivity {
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_main);

        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();

        TextView connectionStatsTextView = findViewById(R.id.connect_main_connect_stats);
        if (bluetoothAdapter == null) {
            if (toast != null) {toast.cancel();}

            toast = Toast.makeText(this, "此設備不支援藍芽", Toast.LENGTH_SHORT);
            toast.show();

            connectionStatsTextView.setText("非藍芽設備!");
        } else {
            if (toast != null) {toast.cancel();}

            toast = Toast.makeText(this, "藍芽已開啟", Toast.LENGTH_SHORT);
            toast.show();

            checkBluetoothConnection(bluetoothAdapter, connectionStatsTextView);
        }
    }

    private void checkBluetoothConnection(BluetoothAdapter bluetoothAdapter, TextView textView) {
        if (bluetoothAdapter.isEnabled()) {
            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
            if (!pairedDevices.isEmpty()) {
                textView.setText("已連接");
            } else {
                textView.setText("未連接");
            }
        }else {
            textView.setText("未開啟");
        }
    }
}