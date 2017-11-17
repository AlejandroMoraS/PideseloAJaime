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

        FoodCategories category1 = new FoodCategories("Papas Fritas", getResources().getDrawable(R.drawable.icon_chips));
        FoodCategories category2 = new FoodCategories("Hamburguesas", getResources().getDrawable(R.drawable.icon_burguer));
        FoodCategories category3 = new FoodCategories("Hot Dog", getResources().getDrawable(R.drawable.icon_hot_dog));
        FoodCategories category4 = new FoodCategories("Carne", getResources().getDrawable(R.drawable.icon_steak));
        FoodCategories category5 = new FoodCategories("Sandwich", getResources().getDrawable(R.drawable.icon_sandwich));
        FoodCategories category6 = new FoodCategories("Frutas y Verduras", getResources().getDrawable(R.drawable.icon_frutas_vegetales));
        FoodCategories category7 = new FoodCategories("Complementos", getResources().getDrawable(R.drawable.icon_ketchup));
        FoodCategories category8 = new FoodCategories("Sushi", getResources().getDrawable(R.drawable.icon_sushi));
        FoodCategories category9 = new FoodCategories("Pasta", getResources().getDrawable(R.drawable.icon_pasta));
        FoodCategories category10 = new FoodCategories("Pizza", getResources().getDrawable(R.drawable.icon_pizza));
        FoodCategories category11 = new FoodCategories("Comida China", getResources().getDrawable(R.drawable.icon_chinese_food));
        FoodCategories category12 = new FoodCategories("Mariscos", getResources().getDrawable(R.drawable.icon_shrimp));
        FoodCategories category13 = new FoodCategories("Ensaladas", getResources().getDrawable(R.drawable.icon_salad));
        FoodCategories category14 = new FoodCategories("Kebab", getResources().getDrawable(R.drawable.icon_kebab));
        FoodCategories category15 = new FoodCategories("Pastel", getResources().getDrawable(R.drawable.icon_cake));
        FoodCategories category16 = new FoodCategories("Postre", getResources().getDrawable(R.drawable.icon_cupcake));



        mFoodList.add(category1);
        mFoodList.add(category2);
        mFoodList.add(category3);
        mFoodList.add(category4);
        mFoodList.add(category5);
        mFoodList.add(category6);
        mFoodList.add(category7);
        mFoodList.add(category8);
        mFoodList.add(category9);
        mFoodList.add(category10);
        mFoodList.add(category11);
        mFoodList.add(category12);
        mFoodList.add(category13);
        mFoodList.add(category14);
        mFoodList.add(category15);
        mFoodList.add(category16);
        return mRootView;
    }

}
