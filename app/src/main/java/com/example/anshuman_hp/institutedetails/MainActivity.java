package com.example.anshuman_hp.institutedetails;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity  {
    TabLayout tabLayout;
    ViewPager pager;
    ImageView institueimage;
    TextView instituename;
    Institue institue;
    Network network;
    Cache cache;
    pagerAdapter pagerAdapter;
    String about;
    TextView tv1;
    RequestQueue rq;
    timeline time;
    String url="http://technotracts.com/instituteretrieve.php?state=odisha&institute=igit";
    String state="odisha",institute="igit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        pager=(ViewPager)findViewById(R.id.pager);
        institue=new Institue("","","","","");
        network=new BasicNetwork(new HurlStack());
        cache=new DiskBasedCache(getCacheDir(),1024*1024);
        rq=new RequestQueue(cache,network);
        rq.start();
        pagerAdapter=new pagerAdapter(getSupportFragmentManager());
        institueimage=(ImageView)findViewById(R.id.instituephoto);
        instituename=(TextView)findViewById(R.id.instutename);
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);
        getinstitute();
        //gettimeline();
        Glide.with(this).load(R.drawable.igit).into(institueimage);
        pagerAdapter.notifyDataSetChanged();
    }

    public void didTapButton(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        view.startAnimation(myAnim);
    }
   public void getinstitute(){
       AsyncTask<Integer,Void,Void> task=new AsyncTask<Integer, Void, Void>() {
           @Override
           protected Void doInBackground(Integer... params) {
               JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                   @Override
                   public void onResponse(JSONArray response) {
                       Log.v("vhjm,",response.toString());
                       try {
                           JSONObject jsonObject=response.getJSONObject(0);
                           institue=new Institue(jsonObject.getString("institute_name"),jsonObject.getString("state"),jsonObject.getString("instituteimage"),
                                   jsonObject.getString("id"),jsonObject.getString("about"));
                           Glide.with(getApplicationContext()).load(institue.institue_img_url).centerCrop().into(institueimage);
                           instituename.setText(institue.instiute_name);
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               });
               rq.add(jsonArrayRequest);
               return null;
           }

           @Override
           protected void onPostExecute(Void aVoid) {
               super.onPostExecute(aVoid);
           }
       };
       task.execute();
    }

}
