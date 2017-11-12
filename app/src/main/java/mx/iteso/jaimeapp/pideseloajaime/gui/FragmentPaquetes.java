package mx.iteso.jaimeapp.pideseloajaime.gui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterPaquetes;
import mx.iteso.jaimeapp.pideseloajaime.Beans.PaquetesCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPaquetes extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<PaquetesCategories> myDataSet;
    private static int columns = 2;

    public FragmentPaquetes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_paquetes, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_paquetesRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        ArrayList<PaquetesCategories> myDataSet = new ArrayList<PaquetesCategories>();


        PaquetesCategories paquete1 = new PaquetesCategories(getResources().getDrawable(R.drawable.icon_beerpack), "Paquete cerveza");
        PaquetesCategories paquete2 = new PaquetesCategories(getResources().getDrawable(R.drawable.icon_sodapack), "Paquete Refresco");
        PaquetesCategories paquete3 = new PaquetesCategories(getResources().getDrawable(R.drawable.icon_burgerpack), "Paquete Hamburguesa");
        PaquetesCategories paquete4 = new PaquetesCategories(getResources().getDrawable(R.drawable.icon_cutlery), "Desechables");
        myDataSet.add(paquete1);
        myDataSet.add(paquete2);
        myDataSet.add(paquete3);
        myDataSet.add(paquete4);


        mAdapter = new AdapterPaquetes(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
