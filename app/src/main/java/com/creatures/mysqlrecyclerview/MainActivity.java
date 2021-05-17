package com.creatures.mysqlrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText ti_et_1,ti_et_2;
    Button btn_add_data;
    FloatingActionButton fab_open_rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ti_et_1=(TextInputEditText)findViewById(R.id.text_input_et_one);
        ti_et_2=(TextInputEditText)findViewById(R.id.text_input_et_two);

        fab_open_rv=(FloatingActionButton)findViewById(R.id.floating_action_button_show_rv);

        btn_add_data=(Button)findViewById(R.id.button_add_data_on_sql);

        btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checktext();
            }
        });

        fab_open_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RecyclerViewListActivity.class));
            }
        });

    }

    public void checktext()
    {
        String et_1,et_2;

        et_1=ti_et_1.getText().toString();
        et_2=ti_et_2.getText().toString();

        if (et_1.isEmpty() || et_2.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Fill all the details", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String result = new DatabaseManager(this).add_info(et_1,et_2);
            ti_et_2.setText("");
            ti_et_1.setText("");
            Toast.makeText(MainActivity.this, ""+result, Toast.LENGTH_SHORT).show();
        }
    }
}