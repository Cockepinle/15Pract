package com.example.a15pract;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textView = view.findViewById(R.id.textView);
        registerForContextMenu(textView); // Регистрация для контекстного меню
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Выберите действие");
        menu.add(0, v.getId(), 0, "Сменить на 'Привет'");
        menu.add(0, v.getId(), 0, "Сменить на 'До свидания'");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Сменить на 'Привет'":
                textView.setText("Привет");
                break;
            case "Сменить на 'До свидания'":
                textView.setText("До свидания");
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}