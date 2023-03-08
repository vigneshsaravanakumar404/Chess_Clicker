package com.example.chessclicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


public class UpgradesFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Upgrades upgrades = new Upgrades(getActivity());
        View view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        listView = view.findViewById(R.id.list_view);


        return view;

    }
}
