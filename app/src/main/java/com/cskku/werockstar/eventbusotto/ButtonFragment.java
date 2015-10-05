package com.cskku.werockstar.eventbusotto;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {

    private EditText text;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        view.findViewById(R.id.fragment_button_send).setOnClickListener(this);
        text = (EditText) view.findViewById(R.id.fragment_button_text);
        return view;
    }


    @Override
    public void onClick(View v) {
        //EventBus.getBus().post(new MessageEvent(text.getText().toString()));
        MessageEvent event = new MessageEvent(text.getText().toString());
        EventBus.getBus().post(event);
    }
}
