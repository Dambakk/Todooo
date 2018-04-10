package com.example.dambakk.todooo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TodoItemRecyclerAdapter extends RecyclerView.Adapter<TodoItemViewHolder>{

    ArrayList<TodoItemModel> items;


    public void updateItems(ArrayList<TodoItemModel> newItems){
        newItems.removeIf(e -> e.isDone());
        this.items = newItems;
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        this.items.remove(position);
        notifyItemRemoved(position);
    }


    @NonNull
    @Override
    public TodoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_view, parent, false);
        TodoItemViewHolder viewHolder = new TodoItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoItemViewHolder holder, int position) {
        TodoItemModel item = items.get(position);
        holder.populateItem(item);

        holder.clickArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.doneAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                                .child("user")
                                .child(user.getUid())
                                .child("todoItems")
                                .child(item.getTimestampCreated())
                                .child("done");
                        ref.setValue(true);
                        removeItem(position);

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                holder.doneAnimation.setProgress(0f);
                holder.doneAnimation.setSpeed(1f);
                holder.doneAnimation.loop(false);
                holder.doneAnimation.playAnimation();
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
