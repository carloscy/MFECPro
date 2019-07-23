package ec.marcafut.marcafut0011;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ec.marcafut.marcafut0011.Acceso.ProfileActivity;
import ec.marcafut.marcafut0011.Acceso.RegistroActivity;
import ec.marcafut.marcafut0011.Noticias.CopaecActivity;
import ec.marcafut.marcafut0011.Noticias.SeriebActivity;
import ec.marcafut.marcafut0011.Noticias.SuperLigaActivity;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    private CardView cardView1, cardView2, cardView3, cardView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1 = findViewById(R.id.wv1);
        cardView2 = findViewById(R.id.wv2);
        cardView3 = findViewById(R.id.wv3);
        cardView4 = findViewById(R.id.wv4);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoticiasActivity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeriebActivity.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SuperLigaActivity.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CopaecActivity.class);
                startActivity(intent);
            }
        });

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Noticias de La Liga Pro");
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
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
    //Metódo de loadRSS


    ///////////////



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }






    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_noticias) {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_tabla) {
            Intent i = new Intent(this, Tabla.class);
            startActivity(i);
        } else if (id == R.id.nav_goleadores) {
            Intent i = new Intent(this, TablagoleadoresActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_resultados) {
            Intent i = new Intent(this,ResultadosActivity.class);
            startActivity(i);
            /*
        } else if (id == R.id.nav_acceso) {
            Intent i = new Intent(this, RegistroActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_invitado) {*/

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
