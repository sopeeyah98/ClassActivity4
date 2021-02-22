package com.example.classActivity4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private View view;
    private TextView textView_title;
    private TextView textView_description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        textView_title = view.findViewById(R.id.textView_title);
        textView_description = view.findViewById(R.id.textView_description);

        String type = getArguments().getString("type");
        if (type.equals("personality")) {
            textView_title.setText("Smug");
            textView_description.setText(getString(R.string.smug));
        } else {
            textView_title.setText("House Information");
            textView_description.setText(getString(R.string.house));
        }
        return view;
    }
}
