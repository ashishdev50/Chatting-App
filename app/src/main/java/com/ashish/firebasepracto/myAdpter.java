package com.ashish.firebasepracto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdpter extends RecyclerView.Adapter<myAdpter.Myviewholder> {

ArrayList<Model> mlist;
Context context;

public myAdpter(Context context, ArrayList<Model> mlist)
{


    this.context = context;
    this.mlist = mlist;


}
    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
 View v = LayoutInflater.from(context).inflate(R.layout.item4,parent,false);
 return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
 Model model= mlist.get(position);
 holder.name.setText(model.getName());
 holder.surname.setText(model.getSurname());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static  class Myviewholder extends RecyclerView.ViewHolder {

                      TextView name ,surname;



        public Myviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.text_name);
            surname = itemView.findViewById(R.id.text_surname);


        }
    }
}
