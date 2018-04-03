package com.example.dambakk.todooo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return view;
    }
}
