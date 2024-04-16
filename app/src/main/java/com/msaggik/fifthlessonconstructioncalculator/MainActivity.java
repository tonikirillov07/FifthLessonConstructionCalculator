package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка полей к разметке
        // поля
        Button buttonWallpaper = findViewById(R.id.buttonWallpaper);
        Button buttonDrywall = findViewById(R.id.buttonDrywall);
        Button buttonElectricalWiring = findViewById(R.id.buttonElectricalWiring);
        Button buttonPaint = findViewById(R.id.buttonPaint);
        Button buttonHeatingRadiators = findViewById(R.id.buttonHeatingRadiators);
        Button buttonRoomVolume = findViewById(R.id.buttonRoomVolume);

        // обработка нажатия кнопок
        buttonWallpaper.setOnClickListener(listener);
        buttonDrywall.setOnClickListener(listener);
        buttonElectricalWiring.setOnClickListener(listener);
        buttonPaint.setOnClickListener(listener);
        buttonHeatingRadiators.setOnClickListener(listener);
        buttonRoomVolume.setOnClickListener(listener);
    }

    // создание слушателя
    private final View.OnClickListener listener = view -> {
        switch (view.getId()) {
            case R.id.buttonWallpaper:
                Intent intent = new Intent(getApplicationContext(), WallpaperActivity.class); // создание намерения переключения в активность калькулятора обоев
                startActivity(intent); // запуск намерения
                break;
            case R.id.buttonDrywall:
                break;
            case R.id.buttonElectricalWiring:
                break;
            case R.id.buttonPaint:
                break;
            case R.id.buttonHeatingRadiators:
                break;
            case R.id.buttonRoomVolume:
                startActivity(new Intent(this, RoomVolumeActivity.class));
                break;
        }
    };
}