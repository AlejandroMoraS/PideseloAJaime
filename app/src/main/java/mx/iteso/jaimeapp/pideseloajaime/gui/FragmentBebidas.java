package mx.iteso.jaimeapp.pideseloajaime.gui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterCategories;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Categories;
import mx.iteso.jaimeapp.pideseloajaime.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBebidas extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Categories> myDataSet;
    private static int columns = 2;


    public FragmentBebidas() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bebidas, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_bebidasRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        ArrayList<Categories> myDataSet = new ArrayList<Categories>();


        Categories category1 = new Categories("imagen chida", "Tequila");
        Categories category2 = new Categories("imagen chida", "Tequila");
        Categories category3 = new Categories("imagen chida", "Tequila");
        myDataSet.add(category1);
        myDataSet.add(category2);
        myDataSet.add(category3);

        mAdapter = new AdapterCategories(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
