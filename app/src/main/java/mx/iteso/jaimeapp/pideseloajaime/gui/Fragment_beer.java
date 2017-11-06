package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_beer extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;


    public Fragment_beer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_beerRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        ArrayList<Product> myDataSet = new ArrayList<Product>();


        Product product1 = new Product(getResources().getDrawable(R.drawable.icon_beer), "cerveza", "1000", "add to cart");
        Product product2 = new Product(getResources().getDrawable(R.drawable.icon_beer), "cerveza", "1000", "add to cart");
        myDataSet.add(product1);
        myDataSet.add(product2);

        mAdapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }





}
