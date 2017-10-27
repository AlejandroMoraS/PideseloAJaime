package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.FoodAdapter;
import mx.iteso.jaimeapp.pideseloajaime.Beans.FoodCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentComida extends Fragment {

    private RecyclerView mRecyclerFood;
    private FoodAdapter mFoodAdapter;
    private ArrayList<FoodCategories> mFoodList = new ArrayList();
    private View mRootView;

    public FragmentComida() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_comida, container, false);
        mRecyclerFood = mRootView.findViewById(R.id.fragment_food_recycler);
        RecyclerView.LayoutManager layoutManager = (new GridLayoutManager(getActivity(), 2));

        mFoodAdapter = new FoodAdapter(getActivity(), mFoodList);
        mRecyclerFood.setHasFixedSize(true);
        mRecyclerFood.setItemViewCacheSize(20);
        mRecyclerFood.setDrawingCacheEnabled(true);
        mRecyclerFood.setLayoutManager(layoutManager);
        mRecyclerFood.setAdapter(mFoodAdapter);


        FoodCategories category1 = new FoodCategories("Hamburguesas", getResources().getDrawable(R.drawable.icon_burguer));
        FoodCategories category2 = new FoodCategories("Verduras", getResources().getDrawable(R.drawable.icon_carrot));
        FoodCategories category3 = new FoodCategories("Complementos", getResources().getDrawable(R.drawable.icon_ketchup));
        FoodCategories category4 = new FoodCategories("Sushi", getResources().getDrawable(R.drawable.icon_sushi));
        mFoodList.add(category1);
        mFoodList.add(category2);
        mFoodList.add(category3);
        mFoodList.add(category4);

        return mRootView;
    }

}
