package sg.edu.rp.soi.c346_p08quiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    Spinner ClassRoom;
    CheckBox locals;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etAge = findViewById(R.id.editAge);
        ClassRoom = findViewById(R.id.spinner);
        locals =findViewById(R.id.checkBox);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Step 1a: Get the user input from the EditText and store it in a variable
                String strName = etName.getText().toString();
                String strAge = etAge.getText().toString();
                boolean local = locals.isChecked();
                int selected = ClassRoom.getSelectedItemPosition();



                //Step 1b: Obtain an instance of the SharedPreference
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                //Step 1c: Obtain an instance of the SharedPreference Editor for update later
                SharedPreferences.Editor preEdit = prefs.edit();
                //Step 1d: Add the key-value pair
                preEdit.putString("name", strName);
                preEdit.putString("age", strAge);
                preEdit.putBoolean("local", local);
                preEdit.putInt("class", selected);

            }
        });
    }
}