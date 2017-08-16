package com.oic.app.masterdetailfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends Fragment {

    UpdateCountListener listener;

    int count = 0;

    public TitlesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_titles, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = (Button)view.findViewById(R.id.btn_click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.updateCount(++count);
                //MainActivity activity = (MainActivity)getActivity();
                //activity.addCount();
            }
        });
    }

    public void setOnUpdateCountListener(UpdateCountListener listener){
        this.listener = listener;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }
}
