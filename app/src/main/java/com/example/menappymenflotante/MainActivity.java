package com.example.menappymenflotante;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mt = findViewById(R.id.materialToolbar);
        setSupportActionBar(mt);

        registerForContextMenu(findViewById(R.id.lbl_Info));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.opc_Rojo){
            findViewById(R.id.main).setBackgroundColor(getColor(R.color.color_bacground1));
        }
        if (item.getItemId()==R.id.opc_Verde){
            findViewById(R.id.main).setBackgroundColor(getColor(R.color.color_bacground2));
        }
        if(item.getItemId()==R.id.opc_Azul){
            findViewById(R.id.main).setBackgroundColor(getColor(R.color.color_bacground3));
        }
        if (item.getItemId()==R.id.opcSalir){
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setCancelable(false)
                    .setTitle(R.string.ad_title)
                    .setMessage(R.string.ad_msg)
                    .setPositiveButton(R.string.ad_pos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                        }
                    })
                    .setNegativeButton(R.string.ad_neg,null)
                    .create()
                    .show();
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       MenuInflater menuInflater = getMenuInflater();
       menuInflater.inflate(R.menu.menu2,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.opc_Rojo){
            ((TextView)findViewById(R.id.lbl_Info)).setTextColor(getColor(R.color.color_bacground1));
        }

        if (item.getItemId()==R.id.opc_Verde){
            ((TextView)findViewById(R.id.lbl_Info)).setTextColor(getColor(R.color.color_bacground2));
        }
        if(item.getItemId()==R.id.opc_Azul){
            ((TextView)findViewById(R.id.lbl_Info)).setTextColor(getColor(R.color.color_bacground3));
        }

        return false;
    }
}