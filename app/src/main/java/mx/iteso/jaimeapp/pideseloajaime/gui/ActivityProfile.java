package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONObject;

import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProfile extends AppCompatActivity {

    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String PICTURE = "picture";
    private static final String FIELDS = "fields";
    private static final String REQUEST_FIELDS = TextUtils.join(",", new String[]{ID, NAME, PICTURE});

    ProfilePictureView profilePicture;
    TextView name;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    JSONObject user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);

        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_profile);
        name = (TextView) findViewById(R.id.activity_profile_name);
        profilePicture = (ProfilePictureView) findViewById(R.id.activity_profile_picture);

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if(AccessToken.getCurrentAccessToken() == null) {
                    Intent intent = new Intent(ActivityProfile.this, ActivityTienda.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    fetchUserInfo();
                    updateUI();
                }
            }
        };


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

    @SuppressWarnings("deprecation")
    private void updateUI() {
        if (AccessToken.getCurrentAccessToken() != null) {
            name.setTextColor(getColor(R.color.colorPrimary));
            //name.setTextColor(getResources().getColor(R.color.colorPrimary));
            //name.setShadowLayer(1f, 0f, -1f, getResources().getColor(R.color.colorPrimary));
            if (user != null) {
                try {
                    profilePicture.setProfileId(user.getString("id"));
                } catch (Exception e) {
                }
                name.setText(user.optString("name"));
            }
        }
    }

}
