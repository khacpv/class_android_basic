package com.oic.app.masterdetailfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A fragment with a Google +1 button.
 */
public class DetailFragment extends Fragment implements UpdateCountListener {

    TextView tvCount;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCount = (TextView) view.findViewById(R.id.tv_count);
    }

    public void updateContent(int position) {

    }

    @Override
    public void updateCount(int count) {
        tvCount.setText("Count: " + count);
    }
}
