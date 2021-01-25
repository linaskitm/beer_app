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

import static com.R.layout.activity_new_entry;

public class NewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_new_entry);
        setTitle("New Entry");

        Intent intent = getIntent();
        Beer beer = (Beer) intent.getSerializableExtra(Adapter.ENTRY);
        Toast.makeText(this, "Beers: " + beer.getDrinkName(), Toast.LENGTH_SHORT).show();

        // pasiimsim visus elementus is xml
        final CheckBox checkBoxLithuania = findViewById(R.id.beer_pilsner);
        final CheckBox checkBoxLatvia = findViewById(R.id.beer_bohamian);
        final CheckBox checkBoxEstonia = findViewById(R.id.beer_belgian);
        final CheckBox checkBoxPoland = findViewById(R.id.beer_buzz);

        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        final RadioButton radio500 = findViewById(R.id.radio2);

        final Spinner spinner = findViewById(R.id.first_brewed_id);
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

        final EditText editTextDescription = findViewById(R.id.description_input);

        Button btnNewEntry = findViewById(R.id.new_entry_btn);

        // uzpildysime visus elementus alaus informacija

        checkBoxLithuania.setText(beer.getDrinkName());
        radio500.setText(beer.getDrinkTagline());
        editTextDescription.setText(beer.getDrinkDescription());

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
                String drinkDescription = editTextDescription.getText().toString();

                editTextDescription.setError(null);


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