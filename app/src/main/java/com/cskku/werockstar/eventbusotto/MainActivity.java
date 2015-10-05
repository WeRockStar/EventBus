package com.cskku.werockstar.eventbusotto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.activity_main_button);
        ButtonFragment buttonFragment = (ButtonFragment)fragment;
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getBus().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getBus().register(this);
    }

    @Subscribe
    public void getMessage(MessageEvent event) {
        Toast.makeText(this, "Got message " + event.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
