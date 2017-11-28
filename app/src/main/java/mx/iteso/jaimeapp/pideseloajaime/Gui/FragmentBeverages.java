package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterBeverages;
import mx.iteso.jaimeapp.pideseloajaime.Beans.BeverageCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class FragmentBeverages extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<BeverageCategories> myDataSet;
    private static int columns = 2;

    public FragmentBeverages() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bebidas, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_bebidas_recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        ArrayList<BeverageCategories> myDataSet = new ArrayList<BeverageCategories>();

        myDataSet.add(new BeverageCategories("Cervezas", getResources().getDrawable(R.drawable.icon_beer)));
        myDataSet.add(new BeverageCategories("Refrescos", getResources().getDrawable(R.drawable.icon_soda)));
        myDataSet.add(new BeverageCategories("Jugos", getResources().getDrawable(R.drawable.icon_juice)));
        myDataSet.add(new BeverageCategories("Tequila", getResources().getDrawable(R.drawable.icon_tequila)));
        myDataSet.add(new BeverageCategories("Vodka", getResources().getDrawable(R.drawable.icon_vodka)));
        myDataSet.add(new BeverageCategories("Whisky", getResources().getDrawable(R.drawable.icon_whisky)));
        myDataSet.add(new BeverageCategories("Vino", getResources().getDrawable(R.drawable.icon_wine)));

        mAdapter = new AdapterBeverages(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
