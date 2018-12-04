package com.example.che.recyclerviewjsontwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Writer extends Activity {

    Button insert;
    RequestQueue requestQueue;
    String insertUrl = "http://open032.xyz/insertStudent.php";
    EditText firstname, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writer_activity);

        firstname = (EditText) findViewById(R.id.inputText);
        image = (EditText) findViewById(R.id.urlImage);
        insert = (Button) findViewById(R.id.button);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("firstname",firstname.getText().toString());
                        parameters.put("lastname",image.getText().toString());


                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });
    }
}

