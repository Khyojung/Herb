package hub.herb;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
/*
    2017-10-24 심예인
 */
public class ReservActiivity extends AppCompatActivity {
    String LINK = "http://35.194.181.98/herb/getReservation.php";
    String JsonResult;
    TableLayout timetable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_actiivity);
        timetable = (TableLayout)findViewById(R.id.timetable);
        createTableRowColumn(timetable);
        /*for(int i = 0 ; i < 5 ; i++ ){

        }*/
        // 서버와 연결 시작
        Connect2Server c2s = new Connect2Server();
        c2s.execute();
    }
    private void createTableRowColumn(TableLayout tableLayout){
        TableRow tableRow = new TableRow(this);
        for( int i = 0 ; i < 6 ; i++) {
            TextView tv = new TextView(this);
            tv.setText("1");
            tv.setGravity(Gravity.CENTER);
            tableRow.addView(tv);
        }
        tableLayout.addView(tableRow, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    class Connect2Server extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(LINK);
                URLConnection conn = url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null)
                    sb.append(line);
                reader.close();

                return sb.toString();
            } catch (Exception e) {
                Log.e("ERROR", "Error");
                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.v("Temp", s);
            if(s == null) {
                Toast.makeText(ReservActiivity.this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                JsonResult = s;
                //Log.d("debuggg", s.toString());

            }
        }
    }
    // 결과로 받은 json은 문자열을 파싱
    private void parse(){
        try{
            JSONObject jsonObject = new JSONObject(JsonResult);
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            for( int i = 0 ; i < jsonArray.length() ; i++ ){
                JSONObject item = jsonArray.getJSONObject(i);

            }
        }catch (JSONException e){
            Log.d("ERROR", "ERROR");
        }
    }
}
