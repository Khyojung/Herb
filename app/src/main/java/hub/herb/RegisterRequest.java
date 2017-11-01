package hub.herb;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 이동헌 on 2017-10-19.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://35.194.181.98/herb/join.php"; //DB
    private Map<String, String> parameters;


    public RegisterRequest( int userStudentNumber, String userPassword, String userName , Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userStudentNumber", userStudentNumber + "");
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}