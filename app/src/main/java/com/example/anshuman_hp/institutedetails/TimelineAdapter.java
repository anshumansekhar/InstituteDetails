package com.example.anshuman_hp.institutedetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

/**
 * Created by Anshuman-HP on 31-03-2017.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimeLineHolder> {
    Context context;
    ArrayList<timeline> data;


    public TimelineAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>() ;
        data.add(new timeline("Anshuman",
                "IGIT Sarang",
                R.drawable.ic_launcher,
                R.drawable.waefd,
                "23",
                "12",
                "EDM Night Organized in IGIT Sarang",
                "4555"));
        data.add(new timeline("Abhaya",
                "IGIT Sarang",
                R.drawable.ic_launcher,
                R.drawable.images,
                "234",
                "12",
                "Sports Organized in IGIT Sarang",
                "45456"));
        data.add(new timeline("Ayushman",
                "IGIT Sarang",
                R.drawable.ic_launcher,
                R.drawable.download,
                "235",
                "12",
                "Halloween night Organized in IGIT Sarang",
                "45654"));
        data.add(new timeline("Abinash",
                "IGIT Sarang",
                R.drawable.ic_launcher,
                R.drawable.ewr,
                "52345",
                "3456",
                "Sports event Organized in IGIT Sarang",
                "56854"));
        data.add(new timeline("Ashutosh",
                "IGIT Sarang",
                R.drawable.ic_launcher,
                R.drawable.wer,
                "2345",
                "1236",
                "Blood donation camp Organized in IGIT Sarang",
                "45434335"));
        data.add(new timeline("Madhu",
                "IGIT Sarang",
                R.drawable.ic_launcher,
                R.drawable.dojodj,
                "2525",
                "12",
                "DJ Night Organized in IGIT Sarang",
                "4586"));
    }

    @Override

    public TimeLineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent,false);
        return new TimeLineHolder(view);

    }

    @Override
    public void onBindViewHolder(TimeLineHolder holder, int position) {
        timeline obj=data.get(position);
        holder.attending.setText(obj.getNumofviewers());
        holder.collegename.setText(obj.getCollegename());
        Glide.with(context).load(obj.getImageurl()).centerCrop().into(holder.image);
        holder.Description.setText(obj.getEventdetails());
        Glide.with(context).load(obj.getImageurl()).centerCrop().into(holder.profile);
        holder.username.setText(obj.getUsername());
        holder.numdislikes.setText(obj.getNumofdislikes());
        holder.numlikes.setText(obj.getNumoflikes());
    }


    @Override
    public int getItemCount() {
        Log.e("size",""+data.size());
        return data.size();
    }
}
