package hub.herb;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Typeface face = Typeface.createFromAsset(getAssets(),"나눔바른펜+ttf.ttf");

        TextView register = (TextView)findViewById(R.id.btn_register);
        TextView pwd = (TextView)findViewById(R.id.et_pwd);
        TextView chk_pwd = (TextView)findViewById(R.id.et_chk_pwd);
        TextView std_num = (TextView)findViewById(R.id.et_stuNum);

        std_num.setTypeface(face);
        register.setTypeface(face);
        pwd.setTypeface(face);
        chk_pwd.setTypeface(face);
    }
    public void registerComplete(View v){
        Intent intent = new Intent( getApplicationContext(), LoginActivity.class );
        startActivity( intent );
    }
}
