package www.math.uni.lodz.pl.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class Play extends AppCompatActivity {
    public boolean allChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkPlants);
        checkBox1.setEnabled(false);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setEnabled(false);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBody);
        checkBox3.setEnabled(false);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkAnimals);
        checkBox4.setEnabled(false);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBuilding);
        checkBox5.setEnabled(false);

        //Button button4 = (Button) findViewById(R.id.button4);
        //button4.setClickable(false);

    }

    @Override
    public void onResume() {
        super.onResume();
        //Toast.makeText(Play.this, "Resume!", Toast.LENGTH_SHORT).show();

        //database
        SimpleDatabaseHelper db = new SimpleDatabaseHelper(this);
        Cursor k = db.getAll();
        String path1 = null, path2 = null, path3 = null, path4 = null, path5 = null, path6 = null, path7 = null, path8 = null, path9 = null, path10 = null;
        boolean checked1 = false, checked2 = false, checked3 = false, checked4 = false, checked5 = false;
        int j = 0;
        while (k.moveToNext()) {
            j++;
            //1
            if (j == 1) {
                path1 = k.getString(2);
            }
            if (j == 2) {
                path2 = k.getString(2);
            }
            if (j == 3) {
                path3 = k.getString(2);
            }
            if (j == 4) {
                path4 = k.getString(2);
            }
            if (j == 5) {
                path5 = k.getString(2);
            }
            if (j == 6) {
                path6 = k.getString(2);
            }
            if (j == 7) {
                path7 = k.getString(2);
            }
            if (j == 8) {
                path8 = k.getString(2);
            }
            if (j == 9) {
                path9 = k.getString(2);
            }
            if (j == 10) {
                path10 = k.getString(2);
            }
            if (j == 10) break;
        }
        k.close();

        if (!path1.equals("TempPath") && !path2.equals("TempPath")) {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkPlants);
            checkBox1.setChecked(true);
            checked1 = true;
        } else {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkPlants);
            checkBox1.setChecked(false);
            checked1 = false;
        }
        if (!path3.equals("TempPath") && !path4.equals("TempPath")) {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox1.setChecked(true);
            checked2 = true;
        } else {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox1.setChecked(false);
            checked2 = false;
        }
        if (!path5.equals("TempPath") && !path6.equals("TempPath")) {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBody);
            checkBox1.setChecked(true);
            checked3 = true;
        } else {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBody);
            checkBox1.setChecked(false);
            checked3 = false;
        }
        if (!path7.equals("TempPath") && !path8.equals("TempPath")) {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkAnimals);
            checkBox1.setChecked(true);
            checked4 = true;
        } else {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkAnimals);
            checkBox1.setChecked(false);
            checked4 = false;
        }
        if (!path9.equals("TempPath") && !path10.equals("TempPath")) {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBuilding);
            checkBox1.setChecked(true);
            checked5 = true;
        } else {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBuilding);
            checkBox1.setChecked(false);
            checked5 = false;
        }

        if (checked1 && checked2 && checked3 && checked4 && checked5) {
            Button button4 = (Button) findViewById(R.id.button4);
            //button4.setClickable(true);
            allChecked = true;
        }


    }

    //wywolanie activity
    public void PicturePlants(View view) {
        //Intent move = new Intent (".gotoFirstCategory");
        //startActivity(move);
        //startActivity(new Intent(getApplicationContext(),gotoFirstCategory.class));
        AutoCompleteTextView firstCategory = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        String stringCategory = firstCategory.getText().toString();
        //przejscie do nowego activity o nazwie gotoFirstCategory
        Intent intent = new Intent(getApplicationContext(), gotoFirstCategory.class);
        intent.putExtra("CATEGORY", stringCategory);
        startActivity(intent);
    }

    //wywolanie activity
    public void PictureFurniture(View view) {
        AutoCompleteTextView secondCategory = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        String stringCategory = secondCategory.getText().toString();
        //przejscie do nowego activity o nazwie gotoFirstCategory
        Intent intent = new Intent(getApplicationContext(), gotoSecondCategory.class);
        intent.putExtra("CATEGORY", stringCategory);
        startActivity(intent);
    }

    //wywolanie activity
    public void PictureBody(View view) {

        AutoCompleteTextView thirdCategory = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView3);
        String stringCategory = thirdCategory.getText().toString();
        //przejscie do nowego activity o nazwie gotoFirstCategory
        Intent intent = new Intent(getApplicationContext(), gotoThirdCategory.class);
        intent.putExtra("CATEGORY", stringCategory);
        startActivity(intent);
    }

    public void PictureAnimals(View view) {

        AutoCompleteTextView fourthCategory = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView4);
        String stringCategory = fourthCategory.getText().toString();
        //przejscie do nowego activity o nazwie gotoFirstCategory
        Intent intent = new Intent(getApplicationContext(), gotoFourthCategory.class);
        intent.putExtra("CATEGORY", stringCategory);
        startActivity(intent);
    }

    public void PictureBuilding(View view) {

        AutoCompleteTextView fifthCategory = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView5);
        String stringCategory = fifthCategory.getText().toString();
        //przejscie do nowego activity o nazwie gotoFirstCategory
        Intent intent = new Intent(getApplicationContext(), gotoFifthCategory.class);
        intent.putExtra("CATEGORY", stringCategory);
        startActivity(intent);
    }

    public void gotoGame(View view) {
        if (allChecked) {
            startActivity(new Intent(getApplicationContext(), gotoGame.class));
        } else {
            Toast.makeText(Play.this, "Take all pictures!", Toast.LENGTH_SHORT).show();

        }
    }
}


