package hub.herb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }

    // 회원 가입 버튼을 눌렀을 경우, 회원가입 액티비티로 이동동
    public void register(View v){
        Intent intent = new Intent( getApplicationContext(), JoinActivity.class );
        startActivity( intent );
    }
    // 로그인 버튼을 눌렀을 경우
    public void login(View v){
        final String id = this._stuID.getText().toString();
        final String pw = this._pwd.getText().toString();
    }
}