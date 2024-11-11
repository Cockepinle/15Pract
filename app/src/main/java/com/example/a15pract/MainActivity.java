package com.example.a15pract;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView displayText; // Текстовое поле для отображения текста

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        displayText = findViewById(R.id.display_text); // Получаем ссылку на TextView

        setFragment(new FirstFragment());

        // Обработка нажатий на элементы нижнего меню
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.first_item) {
                setFragment(new FirstFragment());
                updateDisplayText("Выбран первый фрагмент"); // Изменяем текст
                return true;
            } else if (id == R.id.second_item) {
                setFragment(new SecondFragment());
                updateDisplayText("Выбран второй фрагмент"); // Изменяем текст
                return true;
            }
            return false;
        });

        // Обработка нажатий на элементы бокового меню
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.first_item) {
                setFragment(new FirstFragment());
                updateDisplayText("Выбран первый элемент бокового меню"); // Изменяем текст
                return true;
            } else if (id == R.id.second_item) {
                setFragment(new SecondFragment());
                updateDisplayText("Выбран второй элемент бокового меню"); // Изменяем текст
                return true;
            }
            drawerLayout.closeDrawers(); // Закрываем бокое меню после выбора
            return true;
        });
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .commit();
    }

    private void updateDisplayText(String text) {
        displayText.setText(text); // Устанавливаем текст в TextView
        displayText.setTextColor(getResources().getColor(R.color.black)); // Установите нужный цвет
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.firstFrag) {
            setFragment(new FirstFragment());
            updateDisplayText("Выбран первый фрагмент из меню"); // Изменяем текст
            return true;
        } else if (id == R.id.twoFrag) {
            setFragment(new SecondFragment());
            updateDisplayText("Выбран второй фрагмент из меню"); // Изменяем текст
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}