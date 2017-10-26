package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;

import mx.iteso.jaimeapp.pideseloajaime.ActivityLogin;
import mx.iteso.jaimeapp.pideseloajaime.R;

public abstract class ActivityAbstract extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    protected Toolbar toolbar;
    protected String[] activityTitles;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected ImageView userPicture;
    protected TextView userName;
    protected TextView userMail;
    protected View navHeader;

    protected void onCreateDrawer(){
        activityTitles = getResources().getStringArray(R.array.titles);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbarBase);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navHeader = navigationView.getHeaderView(0);


        userPicture = (ImageView) navHeader.findViewById(R.id.logo);
        userName = (TextView) navHeader.findViewById(R.id.nombre_usuario);
        userMail = (TextView) navHeader.findViewById(R.id.correo_electronico) ;

        loadNavHeader();

    }
    private void loadNavHeader() {
        // name, website
        Bitmap photo = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.logo);

        userName.setText("Nombre de usuario");
        userMail.setText("uncorreo@hotmail.com");
    }
    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }
    private void goLoginScreen() {
        Intent intent = new Intent(this, ActivityLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        switch (item.getItemId()){
            case R.id.sidebar_tienda:
                intent = new Intent(this, ActivityTienda.class);
                startActivity(intent);
                break;
            case R.id.sidebar_cerrarSesion:
                logout();
                break;
            case R.id.sidebar_miCuenta:
                intent = new Intent(this, ActivityProfile.class);
                startActivity(intent);
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
