package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterFood;
import mx.iteso.jaimeapp.pideseloajaime.Beans.FoodCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentComida extends Fragment {

    private RecyclerView mRecyclerFood;
    private AdapterFood mAdapterFood;
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

        mAdapterFood = new AdapterFood(getActivity(), mFoodList);
        mRecyclerFood.setHasFixedSize(true);
        mRecyclerFood.setItemViewCacheSize(20);
        mRecyclerFood.setDrawingCacheEnabled(true);
        mRecyclerFood.setLayoutManager(layoutManager);
        mRecyclerFood.setAdapter(mAdapterFood);

        mFoodList.add(new FoodCategories("Papas Fritas", getResources().getDrawable(R.drawable.icon_chips)));
        mFoodList.add(new FoodCategories("Hamburguesas", getResources().getDrawable(R.drawable.icon_burguer)));
        mFoodList.add(new FoodCategories("Hot Dog", getResources().getDrawable(R.drawable.icon_hot_dog)));
        mFoodList.add(new FoodCategories("Carne", getResources().getDrawable(R.drawable.icon_steak)));
        mFoodList.add(new FoodCategories("Sandwich", getResources().getDrawable(R.drawable.icon_sandwich)));
        mFoodList.add(new FoodCategories("Frutas y Verduras", getResources().getDrawable(R.drawable.icon_frutas_vegetales)));
        mFoodList.add(new FoodCategories("Complementos", getResources().getDrawable(R.drawable.icon_ketchup)));
        mFoodList.add(new FoodCategories("Sushi", getResources().getDrawable(R.drawable.icon_sushi)));
        mFoodList.add(new FoodCategories("Pasta", getResources().getDrawable(R.drawable.icon_pasta)));
        mFoodList.add(new FoodCategories("Pizza", getResources().getDrawable(R.drawable.icon_pizza)));
        mFoodList.add(new FoodCategories("Comida China", getResources().getDrawable(R.drawable.icon_chinese_food)));
        mFoodList.add(new FoodCategories("Mariscos", getResources().getDrawable(R.drawable.icon_shrimp)));
        mFoodList.add(new FoodCategories("Ensaladas", getResources().getDrawable(R.drawable.icon_salad)));
        mFoodList.add(new FoodCategories("Kebab", getResources().getDrawable(R.drawable.icon_kebab)));
        mFoodList.add(new FoodCategories("Pastel", getResources().getDrawable(R.drawable.icon_cake)));
        mFoodList.add(new FoodCategories("Postre", getResources().getDrawable(R.drawable.icon_cupcake)));

        return mRootView;
    }

}
