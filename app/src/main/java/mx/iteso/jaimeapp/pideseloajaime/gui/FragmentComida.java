package mx.iteso.jaimeapp.pideseloajaime.gui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import mx.iteso.jaimeapp.pideseloajaime.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentComida extends Fragment {


    public FragmentComida() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comida, container, false);
    }

}