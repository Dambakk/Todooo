package com.example.dambakk.todooo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FrontpageRecyclerAdapter extends RecyclerView.Adapter<TodoItemViewHolder> {

    ArrayList<TodoItemModel> items;

    public FrontpageRecyclerAdapter(){

    }

    public FrontpageRecyclerAdapter(ArrayList<TodoItemModel> items){
        this.items = items;
    }

    public void updateItems(ArrayList<TodoItemModel> newItems){
        newItems.removeIf(e -> e.isDone());
        this.items = newItems;
        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TodoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_view_holder, parent, false);
        TodoItemViewHolder viewHolder = new TodoItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoItemViewHolder holder, int position) {
        holder.populateItem(items.get(position));
        holder.clickArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.doneAnimation.setProgress(0f);
                holder.doneAnimation.setSpeed(1f);
                holder.doneAnimation.loop(false);
                holder.doneAnimation.playAnimation();

            }
        });
    }

    @Override
    public int getItemCount() {
        if(items == null) return 0;
        return items.size();
    }
}
