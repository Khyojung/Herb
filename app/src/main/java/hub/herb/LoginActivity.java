package hub.herb;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    String Link = "";
    private EditText _stuID;
    private EditText _pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this._stuID = (EditText)findViewById(R.id.et_stuNumber);
        this._pwd = (EditText)findViewById(R.id.et_pwd);


        Typeface face = Typeface.createFromAsset(getAssets(),"나눔바른펜+ttf.ttf");

        TextView loginButton = (TextView)findViewById(R.id.loginButton);
        TextView registerButton = (TextView)findViewById(R.id.registerButton);
        TextView password = (TextView)findViewById(R.id.passwwordText);
        TextView stdNumber = (TextView)findViewById(R.id.et_stuNumber);


        loginButton.setTypeface(face);
        registerButton.setTypeface(face);
        password.setTypeface(face);
        stdNumber.setTypeface(face);



    }

    // 회원 가입 버튼을 눌렀을 경우, 회원가입 액티비티로 이동동
    public void register(View v){
        Intent intent = new Intent( getApplicationContext(), JoinActivity.class );
        startActivity( intent );
    }

    // 로그인 버튼을 눌렀을 경우, 로그인이 완료되면 날짜를 보여주는 액티비티로 이동
    public void login(View v){
        //final String id = this._stuID.getText().toString();
        //final String pw = this._pwd.getText().toString();
        Intent intent = new Intent( getApplicationContext(), CalendarActivity.class );
        startActivity( intent );
    }

    // 테스트용으로 바로 reserve로 넘어가도록,추후에 삭제
    /*public void test(View v){
        Intent intent = new Intent( getApplicationContext(), ReservActivity.class );
        startActivity( intent );
    }*/
}