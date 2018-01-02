package www.math.uni.lodz.pl.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class gotoFirstCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto_first_category);
        //database
        SimpleDatabaseHelper db = new SimpleDatabaseHelper(this);



        //baza danych
        TextView tv = (TextView)findViewById(R.id.textView2);

        //SimpleDatabaseHelper db = new SimpleDatabaseHelper(this);
        /*
        for(int i=0;i<10;i++)
        {
            db.add("tempCategory","TempPath");
        }
        */
        Cursor p = db.getAll();
        int y=0;
        while(p.moveToNext())
        {
            y++;
            int id = p.getInt(0);
            String tytul = p.getString(1);
            String nr = p.getString(2);
            tv.setText(tv.getText()+"\n"+"ID:"+id+" Category:"+tytul+" "+"Path:"+nr);
            if(y==10)break;
        }
        y=0;
    }
    @Override
    public void onResume() {
        super.onResume();
        SimpleDatabaseHelper db = new SimpleDatabaseHelper(this);
        Cursor k = db.getAll();

        ImageView mImageView;
        String path;
        int j=0;
        while(k.moveToNext()) {
            j++;
            //1
            if (j == 1) {
                mImageView = (ImageView) findViewById(R.id.imageView);
                String nr = k.getString(2);
                path = nr;
                mImageView.setImageBitmap(BitmapFactory.decodeFile(path));

            }

            //2
            if (j == 2) {
                mImageView = (ImageView) findViewById(R.id.imageView2);
                String nr = k.getString(2);
                path = nr;
                mImageView.setImageBitmap(BitmapFactory.decodeFile(path));
            }
            if(j==2)break;
        }
        k.close();
    }

    public void gotoCamera1(View view) {
        //startActivity(new Intent(getApplicationContext(),AndroidCameraApi.class));
        //Intent intent = new Intent(getApplicationContext(), AndroidCameraApi.class);
        //startActivity(intent);

        String filename = getIntent().getStringExtra("CATEGORY");//zczytanie putExtra z intentu
        String FirstOrSecondPic = "first";
        //int number = getIntent().getIntExtra("number",1);

        Intent intent = new Intent(getApplicationContext(),AndroidCameraApi.class);
        intent.putExtra("CATEGORY", filename );
        intent.putExtra("ORDER", FirstOrSecondPic );
        intent.putExtra("number",1);
        startActivity(intent);


    }
    public void gotoCamera2(View view) {
        //startActivity(new Intent(getApplicationContext(),AndroidCameraApi.class));
        //Intent intent = new Intent(getApplicationContext(), AndroidCameraApi.class);
        //startActivity(intent);

        String filename = getIntent().getStringExtra("CATEGORY");
        String FirstOrSecondPic = "second";
        //int number = getIntent().getIntExtra("number",1);

        Intent intent = new Intent(getApplicationContext(),AndroidCameraApi.class);
        intent.putExtra("CATEGORY", filename );
        intent.putExtra("ORDER", FirstOrSecondPic );
        intent.putExtra("number",2);
        startActivity(intent);


    }
}