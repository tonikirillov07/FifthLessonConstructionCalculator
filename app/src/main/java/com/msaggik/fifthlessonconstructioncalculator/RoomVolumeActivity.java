package com.msaggik.fifthlessonconstructioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RoomVolumeActivity extends AppCompatActivity {
    private EditText roomWidthEditText, roomHeightEditText, roomLengthEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room_volume);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button calculateButton = findViewById(R.id.calculateButton);
        roomWidthEditText = findViewById(R.id.roomWidth);
        roomHeightEditText = findViewById(R.id.roomHeight);
        roomLengthEditText = findViewById(R.id.roomLength);

        calculateButton.setOnClickListener(view -> {
            double result = Double.parseDouble(roomWidthEditText.getText().toString()) * Double.parseDouble(roomLengthEditText.getText().toString())
                    * Double.parseDouble(roomHeightEditText.getText().toString());

            Toast.makeText(this, "Объем помещения: " + result, Toast.LENGTH_LONG).show();
        });
    }
}