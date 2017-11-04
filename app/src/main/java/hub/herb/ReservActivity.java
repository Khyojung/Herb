package hub.herb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/*
    2017-10-24 심예인
 */
public class ReservActivity extends AppCompatActivity {
   // String LINK = "http://35.194.181.98/herb/getReservation.php";
    String JsonResult;
    TableLayout timetable;

    Activity act = this;
    GridView gridView;
    private List<ResolveInfo> apps;
    private PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv);

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        pm = getPackageManager();
        apps = pm.queryIntentActivities(mainIntent, 0);

        gridView =(GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new gridAdapter());

        //글꼴
        Typeface face = Typeface.createFromAsset(getAssets(),"나눔바른펜+ttf.ttf");
        TextView timeTable = (TextView)findViewById(R.id.tv_top);

        timeTable.setTypeface(face);


       // timetable = (TableLayout)findViewById(R.id.timetable);
        //createTableRowColumn(timetable);

        // 서버와 연결 시작
        //Connect2Server c2s = new Connect2Server();
        //c2s.execute();
    }

    public class gridAdapter extends BaseAdapter{
        LayoutInflater inflater;

        public gridAdapter(){
            inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public final int getCount(){
            return apps.size();
        }
        public final Object getItem(int position){
            return apps.get(position);
        }
        public final long getItemId(int position){
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = inflater.inflate(R.layout.time_table, parent, false);
            }
            final ResolveInfo info = apps.get(position);
            TextView textView = (TextView) convertView.findViewById(R.id.res_status);
            Button button = (Button) convertView.findViewById(R.id.reserv);

            textView.setText(info.activityInfo.loadLabel(pm).toString());
            button.setText(info.activityInfo.loadLabel(pm).toString());

            return convertView;
        }
    }

    /*class Connect2Server extends AsyncTask<String, Void, String> {
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
                Toast.makeText(ReservActivity.this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                JsonResult = s;
                CreateTable(s);
                //Log.d("debuggg", s.toString());
            }
        }
    }*/
   /* private void CreateTable(String s){
        for( int i = 9 ; i < 24 ; i++ ){
            TableRow tableRow = new TableRow(this);
            // 시간 세팅
            String stime = Integer.toString(i);
            TextView t = new TextView(this);
            t.setText(stime);
            t.setGravity(Gravity.CENTER);
            tableRow.addView(t);
            for( int j = 0 ; j < 5 ; j++) {
                TextView tv = new TextView(this);
                tv.setText("1");
                tv.setGravity(Gravity.CENTER);
                tableRow.addView(tv);
            }
            timetable.addView(tableRow, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

    }*/
    /*private void createTableRowColumn(TableLayout tableLayout,TableRow tr){
        for( int i = 0 ; i < 5 ; i++) {
            TextView tv = new TextView(this);
            tv.setText(i);
            tv.setGravity(Gravity.CENTER);
            tr.addView(tv);
        }
        tableLayout.addView(tr, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }*/

    // 결과로 받은 json은 문자열을 파싱
    private void parse(){
        try{
            JSONObject jsonObject = new JSONObject(JsonResult);
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            for( int i = 0 ; i < jsonArray.length() ; i++ ){
                JSONObject item = jsonArray.getJSONObject(i);
                String location;
            }
        }catch (JSONException e){
            Log.d("ERROR", "ERROR");
        }
    }


}
