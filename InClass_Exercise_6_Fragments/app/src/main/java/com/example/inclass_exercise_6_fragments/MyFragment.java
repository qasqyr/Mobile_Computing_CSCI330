package com.example.inclass_exercise_6_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private long drinkId;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    public void setID(long i) {
        this.drinkId = i;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView nameText = view.findViewById(R.id.drink_name);
            TextView tempText =  view.findViewById(R.id.drink_temp);
            ImageView imageView = view.findViewById(R.id.drink_image);
            Drink drink = Drink.drinks[(int) drinkId];
            nameText.setText(drink.getName());
            tempText.setText("Temperature: " + drink.getTemp());
            imageView.setImageResource(drink.getImage());
        }


    }
}
