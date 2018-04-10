package com.example.dambakk.todooo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FrontpageFragment extends Fragment{


    View mainView, loadingView, errorView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frontpage_fragment, container, false);

        mainView = (View) view.findViewById(R.id.frontpage_main_view);
        errorView = (View) view.findViewById(R.id.frontpage_error_view);
        loadingView = (View) view.findViewById(R.id.frontpage_loading_view);

        mainView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);




        listenForDatabaseChanges();

        return view;
    }

    private void listenForDatabaseChanges() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference()
                .child("user")
                .child(user.getUid())
                .child("todoItems");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    //Got reponse!

                    mainView.setVisibility(View.VISIBLE);
                    errorView.setVisibility(View.GONE);
                    loadingView.setVisibility(View.GONE);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
