package hub.herb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
    }
    public void registerComplete(View v){
        Intent intent = new Intent( getApplicationContext(), LoginActivity.class );
        startActivity( intent );
    }
}
