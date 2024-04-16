package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    // поля
    private TextView output; // вывод результата
    private Button buttonBack, buttonNew; // кнопки возврата назад

    private int count = 0; // количество рулонов обоев для оклейки
    private int costAll = 0; // стоимость комплекта обоев

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        // привязка полей к разметке
        output = findViewById(R.id.output);
        buttonBack = findViewById(R.id.calculateButton);
        buttonNew = findViewById(R.id.buttonNew);

        // извлечение данных из намерения
        Bundle bundle = getIntent().getExtras(); // контейнер с извлечёнными данными в виде ключ-значение

        if (bundle != null) {
            int squareInt = bundle.getInt("keySquare"); // извлечение параметра площади оклеиваемой поверхности
            Wallpaper wallpaper = (Wallpaper) bundle.getSerializable(Wallpaper.class.getSimpleName()); // извлечение объекта рулона обоев

            // расчёт рулонов обоев (площадь поверхности (м*м) / (длину (м) * ширину (см) / 100))
            count = squareInt / ((wallpaper.getHeightWallpaper() * wallpaper.getWidthWallpaper())/100);
            if (squareInt % ((wallpaper.getHeightWallpaper() * wallpaper.getWidthWallpaper())/100) > 0) { // если при делении образуется остаток, то нужен ещё один рулон
                count++;
            }
            // расчёт стоимости обоев
            costAll = count * wallpaper.getCostWallpaper();

            // вывод на экран результатов расчёта
            output.setText("Для строительства нужно " + count + " рулонов обоев\nИх стоимость " + costAll + " монет");
        }

        // обработка нажатия кнопок
        buttonBack.setOnClickListener(listener);
        buttonNew.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = null; // объявление намерения

            // инициализация намерения
            switch (view.getId()) {
                case R.id.calculateButton:
                    intent = new Intent(getApplicationContext(), WallpaperActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // удаление всех активностей кроме той на которую происходит переход
                    break;
                case R.id.buttonNew:
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // перемещение нужной активности на вершину стека
                    break;
            }
            startActivity(intent); // запуск намерения
        }
    };
}