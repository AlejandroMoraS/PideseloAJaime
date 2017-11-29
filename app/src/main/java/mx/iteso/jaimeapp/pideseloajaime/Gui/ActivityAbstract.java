package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;

import org.json.JSONObject;

import mx.iteso.jaimeapp.pideseloajaime.R;

public abstract class ActivityAbstract extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String PICTURE = "picture";
    private static final String FIELDS = "fields";
    private static final String REQUEST_FIELDS = TextUtils.join(",", new String[]{ID, NAME, PICTURE});


    CallbackManager callbackManager;
    protected Toolbar toolbar;
    protected String[] activityTitles;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected ImageView userPicture;
    TextView userName;
    protected TextView userMail;
    protected View navHeader;
    AccessTokenTracker accessTokenTracker;
    JSONObject user;


    protected void onCreateDrawer(){
        FacebookSdk.sdkInitialize(this);

        callbackManager = CallbackManager.Factory.create();
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
        userName = (TextView) navHeader.findViewById(R.id.activity_profile_name);
        userMail = (TextView) navHeader.findViewById(R.id.correo_electronico) ;

        accessTokenTracker = new AccessTokenTracker() {

            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if(AccessToken.getCurrentAccessToken() == null) {
                    Intent intent = new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    fetchUserInfo();
                    updateUI();
                }
            }
        };

        loadNavHeader();
    }
    private void loadNavHeader() {
        // name, website
        Bitmap photo = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.logo);

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
            case R.id.sidebar_miCarrito:
                intent = new Intent(this, ActivityCarrito.class);
                startActivity(intent);
                finish();
                break;
            case R.id.sidebar_misPedidos:
                intent = new Intent(this, ActivityMisPedidos.class);
                startActivity(intent);
                finish();
                break;
            case R.id.sidebar_tienda:
                intent = new Intent(this, ActivityTienda.class);
                startActivity(intent);
                finish();
                break;
            case R.id.sidebar_cerrarSesion:
                logout();
                finish();
                break;
            case R.id.sidebar_miCuenta:
                intent = new Intent(this, ActivityProfile.class);
                startActivity(intent);
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fetchUserInfo() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null) {
            GraphRequest request = GraphRequest.newMeRequest(
                    accessToken, new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject me, GraphResponse response) {
                            user = me;
                            updateUI();
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString(FIELDS, REQUEST_FIELDS);
            request.setParameters(parameters);
            GraphRequest.executeBatchAsync(request);
        } else {
            user = null;
        }
    }

    private void updateUI() {
        if (AccessToken.getCurrentAccessToken() != null) {
            userName.setTextColor(getResources().getColor(R.color.white));
            //name.setTextColor(getResources().getColor(R.color.colorPrimary));
            userName.setShadowLayer(1f, 0f, -1f, getResources().getColor(R.color.colorPrimary));
            if (user != null) {
                try {
                    //profilePicture.setProfileId(user.getString("id"));
                } catch (Exception e) {
                }
                userName.setText(user.optString("name"));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchUserInfo();
        updateUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
