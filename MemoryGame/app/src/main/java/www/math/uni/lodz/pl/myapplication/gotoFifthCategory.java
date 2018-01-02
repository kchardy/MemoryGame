package www.math.uni.lodz.pl.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class gotoFifthCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto_fifth_category);
    }
    @Override
    public void onResume(){
        super.onResume();
        SimpleDatabaseHelper db = new SimpleDatabaseHelper(this);
        Cursor k = db.getAll();

        ImageView mImageView;

        int counter = 0;

        while(k.moveToNext())
        {
            counter ++;

            if(counter == 9)
            {
                mImageView = (ImageView) findViewById(R.id.imageView9);
                String path = k.getString(2);
                mImageView.setImageBitmap(BitmapFactory.decodeFile(path));
            }
            if(counter == 10)
            {
                mImageView = (ImageView) findViewById(R.id.imageView10);
                String path = k.getString(2);
                mImageView.setImageBitmap(BitmapFactory.decodeFile(path));
            }
            if(counter == 10) break;
        }
        k.close();
    }
    public void gotoCamera1(View view) {

        String filename = getIntent().getStringExtra("CATEGORY");//zczytanie putExtra z intentu
        String FirstOrSecondPic = "first";

        Intent intent = new Intent(getApplicationContext(),AndroidCameraApi.class);
        intent.putExtra("CATEGORY", filename );
        intent.putExtra("ORDER", FirstOrSecondPic );
        intent.putExtra("number",9);
        startActivity(intent);
    }
    public void gotoCamera2(View view)
    {
        String filename = getIntent().getStringExtra("CATEGORY");
        String FirstOrSecondPic = "second";

        Intent intent = new Intent(getApplicationContext(), AndroidCameraApi.class);
        intent.putExtra("CATEGORY", filename);
        intent.putExtra("ORDER", FirstOrSecondPic);
        intent.putExtra("number", 10);
        startActivity(intent);
    }
}
