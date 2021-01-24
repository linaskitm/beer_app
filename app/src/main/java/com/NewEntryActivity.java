package com;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class NewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        setTitle("New Entry");

        Intent intent = getIntent();
        Beer beer = (Beer) intent.getSerializableExtra(Adapter.ENTRY);
        Toast.makeText(this, "Beers: " + beer.getDrinkName(), Toast.LENGTH_SHORT).show();

        // pasiimsim visus elementus is xml
        final CheckBox checkBoxLithuania = findViewById(R.id.counrty_lithuania);
        final CheckBox checkBoxLatvia = findViewById(R.id.counrty_latvia);
        final CheckBox checkBoxEstonia = findViewById(R.id.counrty_estonia);
        final CheckBox checkBoxPoland = findViewById(R.id.counrty_poland);

        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        final RadioButton radio500 = findViewById(R.id.radio500);

        final Spinner spinner = findViewById(R.id.last_updated_id);
        ArrayList <String> updateList = new ArrayList<String>();
        updateList.add(beer.getDrinkFirstBrewed());
        updateList.add(getResources().getString(R.string.new_entry_date1));
        updateList.add(getResources().getString(R.string.new_entry_date2));
        updateList.add(getResources().getString(R.string.new_entry_date3));
        updateList.add(getResources().getString(R.string.new_entry_date4));

        //adapteris reikalingas sujungti isdestyma su sarasu
        ArrayAdapter <String> dataAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                updateList
        );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapateri idedame-susiejame i spineri
        spinner.setAdapter(dataAdapter);

        final EditText editTextConfirmed = findViewById(R.id.confirmed_input);

        Button btnNewEntry = findViewById(R.id.new_entry_btn);

        // uzpildysime visus elementus coronos informacija

        checkBoxLithuania.setText(beer.getDrinkName());
        radio500.setText(String.valueOf(beer.getDrinkTagline()));// konvertuojame int i string
        editTextConfirmed.setText(String.valueOf(beer.getDrinkDescription()));

        // ant mygtuko paspaudimo parodysime vartotojo ivesta- koreguota informacija

        btnNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String beers = "";
                if(checkBoxLithuania.isChecked()) {
                    beers+= checkBoxLithuania.getText().toString() + ", ";
                }
                if(checkBoxLatvia.isChecked()) {
                    beers+= checkBoxLatvia.getText().toString() + ", ";
                }
                if(checkBoxEstonia.isChecked()) {
                    beers+= checkBoxEstonia.getText().toString() + ", ";
                }
                if(checkBoxPoland.isChecked()) {
                    beers+= checkBoxPoland.getText().toString() + " ";
                }

                //gauname pasirinta radio buttona is radio groupo
                int selectedRadioGroupId = radioGroup.getCheckedRadioButtonId();
                //surandame radio butona pagal grazinta id is radio grupes
                RadioButton selectedButton = (RadioButton) findViewById(selectedRadioGroupId);
                // buuton yra tagline
                String drinkTagline = selectedButton.getText().toString();
                // spiineri first brewed
                String drinkFirstBrewed = String.valueOf(spinner.getSelectedItem());
                // is confirmed i description
                String drinkDescription = editTextConfirmed.getText().toString();

                editTextConfirmed.setError(null);


                    Beer beer = new Beer(drinkFirstBrewed, beers, drinkDescription, drinkTagline);
                    //atvaizduojame vartotojui objekto informacija
                    Toast.makeText(
                            NewEntryActivity.this,
                            "Beer: " + beer.getDrinkName() + "\n" +
                                    "First Brewwed: " + beer.getDrinkFirstBrewed()+ "\n" +
                                    "Tagline: " + beer.getDrinkTagline()+ "\n" +
                                    "Description: " + beer.getDrinkDescription(),
                            Toast.LENGTH_SHORT
                    ).show();

            }
        });

    }

}