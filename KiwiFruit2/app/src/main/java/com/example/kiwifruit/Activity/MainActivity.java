package com.example.kiwifruit.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kiwifruit.R;
import com.example.kiwifruit.fragment.placefragment;
import com.example.kiwifruit.fragment.productfragment;
import java.io.Console;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        NavigationView navigationView = findViewById(R.id.nav_view);
        MenuItem productmenuItem = navigationView.getMenu().findItem(R.id.product);
        MenuItem placemenuItem = navigationView.getMenu().findItem(R.id.foundition);
        Menu productmenu = productmenuItem.getSubMenu();
        Menu placemenu = placemenuItem.getSubMenu();
        MenuItem productitem;
        MenuItem placeitem;
        int id = item.getItemId();
        if (id == R.id.introduce) {
            // Handle the camera action
            Fragment fragment = new placefragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.manyproduct) {
            placeitem = placemenu.findItem(R.id.manyfoundition);
            placeitem.setVisible(true);
            productitem = productmenu.findItem(R.id.manyproduct);
            productitem.setVisible(false);
            for(int i=R.id.kiwifoudition;i<=R.id.orangefoundition;i++) {
                placeitem =placemenu.findItem(i);
                placeitem.setVisible(false);
            }
            for(int i=R.id.kiwifruit;i<=R.id.Navelorange;i++) {
                productitem = productmenu.findItem(i);
                productitem.setVisible(true);
                productitem.setOnMenuItemClickListener(
                        new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Fragment fragment = new productfragment();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, fragment);
                                transaction.commit();
                                Log.d("sd", "onMenuItemClick:product ");
                                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer.closeDrawer(GravityCompat.START);
                                return true;
                            }
                        }
                );
            }

        } else if (id == R.id.manyfoundition) {
            placeitem = placemenu.findItem(R.id.manyfoundition);
            placeitem.setVisible(false);
            productitem = productmenu.findItem(R.id.manyproduct);
            productitem.setVisible(true);
            for(int i=R.id.kiwifruit;i<=R.id.Navelorange;i++) {
                productitem = productmenu.findItem(i);
                Log.d("1", "1: ");
                productitem.setVisible(false);
            }
            for(int i=R.id.kiwifoudition;i<=R.id.orangefoundition;i++) {
                Log.d("1", "2: ");
                placeitem = placemenu.findItem(i);
                placeitem.setVisible(true);
                placeitem.setOnMenuItemClickListener(
                        new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Fragment fragment = new placefragment();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, fragment);
                                transaction.commit();
                                Log.d("sd", "onMenuItemClick:place ");
                                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer.closeDrawer(GravityCompat.START);
                                return true;
                            }
                        }
                );
            }

        } else if (id == R.id.contact) {

        }


        return true;
    }
}

