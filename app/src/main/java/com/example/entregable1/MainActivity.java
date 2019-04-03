package com.example.entregable1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    CardView cardView;
    EnlaceAdapter adapter;

    Enlace[] enlaces = {new Enlace("Explora", "Date un paseo por nuestro catálogo", "http://icons.iconarchive.com/icons/webalys/kameleon.pics/512/Shop-icon.png", MainActivity.class)
            , new Enlace("Carrito", "Date un paseo por nuestro catálogo", "https://checkout.advancedshippingmanager.com/wp-content/uploads/2015/10/Cart-Icon-PNG-Graphic-Cave-e1461785088730-300x300.png", MainActivity.class)
            , new Enlace("Pedidos", "Date un paseo por nuestro catálogo", "https://www.mageworx.com/media/catalog/product/cache/1/image/265x265/9df78eab33525d08d6e5fb8d27136e95/o/r/order_editor.png", MainActivity.class)
            , new Enlace("Contacto", "Date un paseo por nuestro catálogo", "http://marrybd.com/assets/icon/about.png", MainActivity.class)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = findViewById(R.id.shortcut_gridview);
        cardView = findViewById(R.id.shortcut_cardview);


        final EnlaceAdapter enlaceAdapter = new EnlaceAdapter(this, enlaces, R.layout.shortcut_cardview);
        gridView.setAdapter(enlaceAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent ps;
                switch (position) {
                    case 0: {
                        ps = new Intent(MainActivity.this, Explora.class);
                        ps.putExtra("Nombre",position);
                        break;
                    }
                    case 1: {
                        ps = new Intent(MainActivity.this, Carrito.class);
                        ps.putExtra("Nombre", enlaceAdapter.getItem(position).Nombre);
                        break;
                    }
                    case 2: {
                        ps = new Intent(MainActivity.this, Pedidos.class);
                        ps.putExtra("Nombre", enlaceAdapter.getItem(position).Nombre);
                        break;
                    }
                    case 3: {
                        ps = new Intent(MainActivity.this, Contracto.class);
                        ps.putExtra("Nombre", enlaceAdapter.getItem(position).Nombre);
                        break;
                    }
                    default: {
                        ps = new Intent(MainActivity.this, Explorador.class);
                        break;
                    }

                }
                startActivity(ps);
                finish();
                Toast.makeText(MainActivity.this, "click => " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
