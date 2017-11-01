package hub.herb;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 이동헌 on 2017-10-19.
 */

public class LoginRequest extends StringRequest {

    final static private String URL = "http://35.194.181.98/herb/login.php"; //DB
    private Map<String, String> parameters;


    public LoginRequest(int stuNum, String pwd,  Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("stuNum", stuNum + "");
        parameters.put("pwd", pwd);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}