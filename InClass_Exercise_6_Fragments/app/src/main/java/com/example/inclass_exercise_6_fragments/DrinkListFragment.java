package com.example.inclass_exercise_6_fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class DrinkListFragment extends ListFragment {

    static interface DrinkListener {
        void itemClicked(long id);
    }

    private DrinkListener l;

    public DrinkListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        int len = Drink.drinks.length;
        String[] drink_names = new String[len];
        for (int i = 0; i < len; i++) {
            drink_names[i] = Drink.drinks[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, drink_names);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            l = (DrinkListener) activity;
        }
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        if (l != null) {
            l.itemClicked(id);
        }

    }
}
