package www.math.uni.lodz.pl.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class gotoThirdCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto_third_category);
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
            //5
            if (j == 5) {
                mImageView = (ImageView) findViewById(R.id.imageView5);
                String nr = k.getString(2);
                path = nr;
                mImageView.setImageBitmap(BitmapFactory.decodeFile(path));

            }

            //6
            if (j == 6) {
                mImageView = (ImageView) findViewById(R.id.imageView6);
                String nr = k.getString(2);
                path = nr;
                mImageView.setImageBitmap(BitmapFactory.decodeFile(path));
            }
            if(j==6)break;
        }
        k.close();
    }

    public void gotoCamera1(View view) {

        String filename = getIntent().getStringExtra("CATEGORY");//zczytanie putExtra z intentu
        String FirstOrSecondPic = "first";

        Intent intent = new Intent(getApplicationContext(),AndroidCameraApi.class);
        intent.putExtra("CATEGORY", filename );
        intent.putExtra("ORDER", FirstOrSecondPic );
        intent.putExtra("number",5);
        startActivity(intent);


    }
    public void gotoCamera2(View view) {

        String filename = getIntent().getStringExtra("CATEGORY");
        String FirstOrSecondPic = "second";

        Intent intent = new Intent(getApplicationContext(),AndroidCameraApi.class);
        intent.putExtra("CATEGORY", filename );
        intent.putExtra("ORDER", FirstOrSecondPic );
        intent.putExtra("number",6);
        startActivity(intent);

    }
}
