package com.lvt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import com.lvt.activity.R;
import com.lvt.model.NavDrawerItem;

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
	List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
 
    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.setContext(context);
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
 
    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
    }
 
    @Override
    public int getItemCount() {
        return data.size();
    }
 
    public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
 
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
