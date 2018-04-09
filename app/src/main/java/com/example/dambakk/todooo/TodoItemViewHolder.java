package com.example.dambakk.todooo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class TodoItemViewHolder extends RecyclerView.ViewHolder {

    TextView itemTitle;
    LottieAnimationView doneAnimation;
    View clickArea;

    public TodoItemViewHolder(View itemView) {
        super(itemView);

        itemTitle = itemView.findViewById(R.id.todo_item_title);
        doneAnimation = itemView.findViewById(R.id.todo_item_done_animation);
        clickArea = itemView.findViewById(R.id.item_done_click_area);
    }

    public void populateItem(TodoItemModel item){
        itemTitle.setText(item.getTitle());

        doneAnimation.setProgress(0.5f);
    }
}
