package com.example.anshuman_hp.institutedetails;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutInstituteFragment extends Fragment {

    TextView about_Institute;
    Institue institue;
    Network network;
    Cache cache;
    RequestQueue rq;
    String url="http://technotracts.com/instituteretrieve.php?state=odisha&institute=igit";
    String state="odisha",institute="igit";
    public AboutInstituteFragment() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_about_institute, container, false);
        Log.e("About","");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        about_Institute=(TextView)view.findViewById(R.id.about);
        Log.e("About","");
        institue=new Institue("","","","","");
        network=new BasicNetwork(new HurlStack());
        cache=new DiskBasedCache(view.getContext().getCacheDir(),1024*1024);
        rq=new RequestQueue(cache,network);
        rq.start();
        about_Institute.setText("The Indira Gandhi Institute of Technology (IGIT)(Odia: ଇନ୍ଦିରା ଗାନ୍ଧୀ ବୈଷୟିକ ମହାବିଦ୍ୟାଳୟ) is located at Sarang in the industrial belt of Talcher, Angul district in the Indian state of Odisha. It was established in 1982 by the government of Odisha. In addition to four year undergraduate degree courses, it offers three year Diploma courses in technical disciplines and a 3-year postgraduate degree in computer applications. It offers postgraduate degree courses in engineering. The college has 179 acres (0.72 km2) of land and it is situated near the Brahmani River. Currently, Dr. B.C.Panda is the director of the institute.\n" +
                "\n" +
                "Five branches in undergraduate courses of the institute are accredited by the NBA in the year 2016. It is affiliated to Biju Patnaik University of Technology and the State Council for Technical Education & Vocational Training");
        getinstitute();
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
                            about_Institute.setText(institue.about);
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
