package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterPacks;
import mx.iteso.jaimeapp.pideseloajaime.Beans.PacksCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class FragmentPaquetes extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<PacksCategories> myDataSet;
    private static int columns = 2;

    public FragmentPaquetes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_paquetes, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_paquetesRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        ArrayList<PacksCategories> myDataSet = new ArrayList<PacksCategories>();

        myDataSet.add(new PacksCategories(getResources().getDrawable(R.drawable.icon_beerpack), "Paquete cerveza"));
        myDataSet.add(new PacksCategories(getResources().getDrawable(R.drawable.icon_sodapack), "Paquete Refresco"));
        myDataSet.add(new PacksCategories(getResources().getDrawable(R.drawable.icon_burgerpack), "Paquete Hamburguesa"));
        myDataSet.add(new PacksCategories(getResources().getDrawable(R.drawable.icon_cutlery), "Desechables"));

        mAdapter = new AdapterPacks(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
