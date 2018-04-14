package com.example.anshuman_hp.institutedetails;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {
    RecyclerView TimelineRecycler;
    Network network;
    timeline time;
    String url="http://technotracts.com/timeline.php";
    Cache cache;
    String about;
    List<timeline> data=new ArrayList<>();
    TextView tv1;
    RequestQueue rq;
    TimelineAdapter adapter;
    public TimelineFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TimelineRecycler=(RecyclerView)view.findViewById(R.id.timelinerecyeler);
        TimelineRecycler.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        adapter=new TimelineAdapter(this.getContext());
        TimelineRecycler.setAdapter(adapter);
        network=new BasicNetwork(new HurlStack());
        cache=new DiskBasedCache(this.getContext().getCacheDir(),1024*1024);
        rq=new RequestQueue(cache,network);
        rq.start();
        Log.v("aaaaaaaaaaa","aaaaaaaaaqqqqqqq");
//        gettimeline();
        adapter.notifyDataSetChanged();
    }
//    public void gettimeline(){
//        AsyncTask<Integer,Void,Void> task=new AsyncTask<Integer, Void, Void>() {
//            @Override
//            protected Void doInBackground(Integer... params) {
//                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.v("vhjm,",response.toString());
//                        for(int i=0;i<response.length();++i){
//                        try {
//                            JSONObject jsonObject=response.getJSONObject(i);
//                            time=new timeline(jsonObject.getString("User_name"),jsonObject.getString("College_name"),jsonObject.getString("Post_image"),
//                                    jsonObject.getString("Event_photo"),jsonObject.getString("Likes"),jsonObject.getString("Dislikes"),jsonObject.getString("Event_details"),
//                                    jsonObject.getString("View"));
//                            Log.v("aaaaaa",response.toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        data.add(time);
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//                rq.add(jsonArrayRequest);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                adapter.notifyDataSetChanged();
//
//            }
//        };
//        task.execute();
//    }
}
