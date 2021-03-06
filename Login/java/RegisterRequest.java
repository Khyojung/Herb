package com.example.management;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 이동헌 on 2017-10-19.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = ""; //DB
    private Map<String, String> parameters;


    public RegisterRequest(String userID, String userPassword, String userName, int userStudentnumber, Response.Listener<String> listener){
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);
            parameters.put("userPassword", userPassword);
            parameters.put("userName", userName);
            parameters.put("userStudentnumber", userStudentnumber + "");

        }

        @Override
        public Map<String, String> getParams() {
            return parameters;
        }
}
