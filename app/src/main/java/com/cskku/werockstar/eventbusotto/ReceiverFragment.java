package com.cskku.werockstar.eventbusotto;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiverFragment extends Fragment {

    private TextView text;

    public ReceiverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        text = (TextView) view.findViewById(R.id.fragment_receiver_text);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getBus().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getBus().register(this);
    }


    @Subscribe
    public void nameAnything(MessageEvent event) {
        text.setText("Got the message : " + event.getMessage());
    }
}
