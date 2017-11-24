package mx.iteso.jaimeapp.pideseloajaime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import mx.iteso.jaimeapp.pideseloajaime.gui.ActivityTienda;

public class ActivityLogin extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        callbackManager = CallbackManager.Factory.create();
        //MUST be included before load a VIEW that includes Facebook API
        setContentView(R.layout.activity_login);

        loginButton = (LoginButton) findViewById(R.id.activity_login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "user_friends"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goActivitySideBar();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goActivitySideBar() {
        Intent intent = new Intent(ActivityLogin.this, ActivityTienda.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); //El usuario no regresa a login si le da para atras
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        fetchUserInfo();
    }

    private void fetchUserInfo() {
        final AccessToken token = AccessToken.getCurrentAccessToken();
        if(token != null) {
            Intent intent = new Intent(ActivityLogin.this, ActivityTienda.class);
            startActivity(intent);
            finish();
        }
    }
}
