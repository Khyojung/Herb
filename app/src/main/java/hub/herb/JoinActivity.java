package hub.herb;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinActivity extends AppCompatActivity {
    EditText stuNumText;
    EditText nameText;
    EditText passwordText;
    EditText chkPwdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        stuNumText = (EditText) findViewById( R.id.et_stuNum);
        nameText = (EditText) findViewById(R.id.et_name);
        passwordText = (EditText) findViewById(R.id.et_pwd);
        chkPwdText= (EditText) findViewById(R.id.et_chk_pwd);
    }

    public void registerComplete(View v){
        String userName = nameText.getText().toString();
        String userPassword = passwordText.getText().toString();
        int userStudentNumber = Integer.parseInt(stuNumText.getText().toString());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response){
                try
                {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                        builder.setMessage("회원 등록에 성공했습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();
                        //finish();
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                        builder.setMessage("회원 등록에 실패했습니다.")
                                .setNegativeButton("확인", null)
                                .create()
                                .show();
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };
        RegisterRequest registerRequest = new RegisterRequest(userStudentNumber, userPassword, userName, responseListener);
        RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
        queue.add(registerRequest);
    }

}