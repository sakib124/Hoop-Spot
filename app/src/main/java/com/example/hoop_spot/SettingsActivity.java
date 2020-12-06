package com.example.hoop_spot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = findViewById(R.id.btnLogout);
        spinner = (Spinner) findViewById(R.id.spinner);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        spinner.setOnItemSelectedListener(this);
        List<String> list = new ArrayList<String>();
        list.add("Please select a radius...");
        list.add("1km");
        list.add("2km");
        list.add("5km");
        list.add("10km");
        list.add("50km");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
String stringToPassBack;
Intent intent = new Intent();
        switch (position) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                stringToPassBack = spinner.getSelectedItem().toString();
                intent.putExtra("keyName", stringToPassBack);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onBackPressed() {
    }

}
