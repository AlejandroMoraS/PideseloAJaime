package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;

import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProfile extends ActivityAbstract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        onCreateDrawer();
    }
}
