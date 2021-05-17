package com.creatures.mysqlrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.recycler_view_holder> {

    @NonNull
    ArrayList<model_new> arrayList;
    OnItemClickListener mListener;
    boolean flag=false;
    int a=1;

    //Onclick Interface
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    //Constructor
    public RecyclerViewAdapter(@NonNull ArrayList<model_new> arrayList) {
        this.arrayList = arrayList;
    }

    // Override Methods for Recycler View Holder
    @Override
    public recycler_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent,false);
        return new recycler_view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.recycler_view_holder holder, int position) {

        holder.tv_D_e_n.setText(arrayList.get(position).getE_N());
        holder.tv_D_e_d.setText(arrayList.get(position).getE_D());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    // recycler View Holder Class which extends View Holder
    class recycler_view_holder extends RecyclerView.ViewHolder
    {
        TextView tv_D_e_n,tv_D_e_d;
        public recycler_view_holder(@NonNull View itemView) {
            super(itemView);
            tv_D_e_d = (TextView)itemView.findViewById(R.id.recycler_view_event_description_display);
            tv_D_e_n= (TextView)itemView.findViewById(R.id.recycler_view_event_name_display);
            ImageView imageView_notification;

            imageView_notification=(ImageView)itemView.findViewById(R.id.notification_image_view);
            imageView_notification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (!flag) {
                        imageView_notification.setBackgroundResource(R.drawable.ic_on_notifications_active);
                        flag=true;
                        Toast.makeText(v.getContext(), "Notifications is ON for that Event "+pos, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        imageView_notification.setBackgroundResource(R.drawable.ic_off_notifications);
                        flag=false;
                        Toast.makeText(v.getContext(), "Notifications is OFF for that Event "+pos, Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }





}
