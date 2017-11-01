package hub.herb;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinActivity extends AppCompatActivity {
    private EditText _stuNumText;
    private EditText _nameText;
    private EditText _passwordText;
    private EditText _chkPwdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        this._stuNumText = (EditText) findViewById( R.id.et_stuNum);
        this._nameText = (EditText) findViewById(R.id.et_name);
        this._passwordText = (EditText) findViewById(R.id.et_pwd);
        this._chkPwdText= (EditText) findViewById(R.id.et_chk_pwd);
    }

    // 회원가입 버튼을 누를 경우
    public void registerComplete(View v){
        String userStudentNumber = this._stuNumText.getText().toString();
        String userName = this._nameText.getText().toString();
        String userPassword = this._passwordText.getText().toString();
        String chkPassword = this._chkPwdText.getText().toString();

        // 사용자가 입력한 두개의 패스워드가 동일한지 확인
        if( userPassword.equals(chkPassword) ){
            if(userName.getBytes().length > 0 && userStudentNumber.getBytes().length > 0 ){
                int stn = Integer.parseInt(userStudentNumber);
                inputMember2DB(stn, userName, userPassword);
            }else{
                Toast.makeText(this,"ID와 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"비밀번호 확인이 다릅니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private void inputMember2DB(int stn, String name, String pwd){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response){
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                        builder.setMessage("회원 등록에 성공했습니다.")
                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .create()
                                .show();
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                        builder.setMessage("이미 등록된 학번 입니다.")
                                .setNegativeButton("확인", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };
        RegisterRequest registerRequest = new RegisterRequest(stn, pwd, name, responseListener);
        RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
        queue.add(registerRequest);
    }
}