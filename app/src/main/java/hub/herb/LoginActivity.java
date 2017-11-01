package hub.herb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText _stuID;
    private EditText _pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this._stuID = (EditText)findViewById(R.id.et_stuNumber);
        this._pwd = (EditText)findViewById(R.id.et_loginPwd);
    }

    // 회원 가입 버튼을 눌렀을 경우, 회원가입 액티비티로 이동동
    public void register(View v){
        Intent intent = new Intent( getApplicationContext(), JoinActivity.class );
        startActivity( intent );
    }

    // 로그인 버튼을 눌렀을 경우, 로그인이 완료되면 날짜를 보여주는 액티비티로 이동
    public void login(View v){
        String stuNum = this._stuID.getText().toString();
        String pwd = this._pwd.getText().toString();
        final int stn = Integer.parseInt(stuNum);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        Intent intent = new Intent(getApplicationContext(), CalendarActivity.class );
                        intent.putExtra("stuNum", stn);
                        startActivity(intent);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("로그인에 실패하였습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                                .show();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest( stn, pwd, responseListener );
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);

        //Intent intent = new Intent( getApplicationContext(), CalendarActivity.class );
        //startActivity( intent );
    }
}