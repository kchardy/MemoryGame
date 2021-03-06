package www.math.uni.lodz.pl.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MemoryGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_memory_game, menu);
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
            Reset_database();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //wywołanie nowego activity
    public void ChooseCategory(View view){
        Intent move = new Intent (".Play");
        startActivity(move);
    }

    //zamykanie aplikacji przyciskiem exit
    public void wyjscie(View view){
        finish();
        System.exit(0);
    }

    public void Reset_database()
    {
        SimpleDatabaseHelper databaseHelper = new SimpleDatabaseHelper(this);

        for(int i=0;i<11;i++)
        {
            databaseHelper.update(i,"tempCategory","TempPath");
        }
        Toast.makeText(MemoryGame.this, "Done", Toast.LENGTH_SHORT).show();
    }

}
