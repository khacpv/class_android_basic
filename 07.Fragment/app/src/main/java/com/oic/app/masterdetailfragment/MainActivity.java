package com.oic.app.masterdetailfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity implements TitlesFragment.OnItemSelectedListener {

    TitlesFragment listFrag;
    DetailFragment detailFrag;

    DrawerLayout myDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = (DrawerLayout)findViewById(R.id.my_drawer);
        myDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        listFrag = (TitlesFragment) getFragmentManager().findFragmentById(R.id.list_frag);
        detailFrag = (DetailFragment) getFragmentManager().findFragmentById(R.id.details_frag);

        listFrag.setOnUpdateCountListener(detailFrag);
        /*
        // or check by code
        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_main_tablet);
        } else {
            setContentView(R.layout.activity_main);
        }
        */

    }

    /**
     * This is a callback that the list fragment (Fragment A)
     * calls when a list item is selected
     */
    @Override
    public void onItemSelected(int position) {
        DetailFragment displayFrag = (DetailFragment) getFragmentManager().findFragmentById(R.id.details_frag);
        if (displayFrag == null) {
            // DisplayFragment (Fragment B) is not in the layout (handset layout),
            // so start DisplayActivity (Activity B)
            // and pass it the info about the selected item
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            // DisplayFragment (Fragment B) is in the layout (tablet layout),
            // so tell the fragment to update
            displayFrag.updateContent(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
