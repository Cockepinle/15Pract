package com.example.a15pract;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private int counter = 0;
    @Nullable
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        view.setBackgroundResource(R.color.red); // Установите цвет для второго фрагмента
        view.setOnClickListener(v -> showPopupMenu(v));
        // Установите текст или другие элементы интерфейса
        // Например, вы можете использовать TextView для отображения текста

        return view;
    }
    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(getActivity(), view);
        MenuInflater inflater = popup.getMenuInflater();
        popup.getMenu().add("Увеличить счетчик");

        popup.setOnMenuItemClickListener(item -> {
            counter++;
            Toast.makeText(getActivity(), "Счетчик: " + counter, Toast.LENGTH_SHORT).show();
            return true;
        });

        popup.show();
    }
}
