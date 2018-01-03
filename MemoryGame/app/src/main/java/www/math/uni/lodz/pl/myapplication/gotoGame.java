package www.math.uni.lodz.pl.myapplication;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class gotoGame extends AppCompatActivity {
    public boolean swap1 = true;
    public boolean swap2 = true;
    public boolean swap3 = true;
    public boolean swap4 = true;
    public boolean swap5 = true;
    public boolean swap6 = true;
    public boolean swap7 = true;
    public boolean swap8 = true;
    public boolean swap9 = true;
    public boolean swap10 = true;

    public boolean clicked1 = false;
    public boolean clicked2 = false;
    public boolean clicked3 = false;
    public boolean clicked4 = false;
    public boolean clicked5 = false;
    public boolean clicked6 = false;
    public boolean clicked7 = false;
    public boolean clicked8 = false;
    public boolean clicked9 = false;
    public boolean clicked10 = false;

    public boolean lose = true;
    //Button button = (Button) findViewById(R.id.imageButton);
    String path1,path2,path3,path4,path5,path6,path7,path8,path9,path10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto_game);

        TextView tv = (TextView)findViewById(R.id.textView3);

        tv.setText(tv.getText() +""+ GlobalCountOfTap);



        //database
        SimpleDatabaseHelper db = new SimpleDatabaseHelper(this);
        Cursor k = db.getAll();


        int j=0;
        while(k.moveToNext())
        {
            j++;
            //1
            if (j == 1)
            {
                path1 = k.getString(2);
            }
            if (j == 2)
            {
                path2 = k.getString(2);
            }
            if (j == 3)
            {
                path3 = k.getString(2);
            }
            if (j == 4)
            {
                path4 = k.getString(2);
            }
            if (j == 5)
            {
                path5 = k.getString(2);
            }
            if (j == 6)
            {
                path6 = k.getString(2);
            }
            if (j == 7)
            {
                path7 = k.getString(2);
            }
            if (j == 8)
            {
                path8 = k.getString(2);
            }
            if (j == 9)
            {
                path9 = k.getString(2);
            }
            if (j == 10)
            {
                path10 = k.getString(2);
            }
            if(j==10)break;
        }
        k.close();

    }




    public boolean matched1 = false;
    public boolean matched2 = false;
    public boolean matched3 = false;
    public boolean matched4 = false;
    public boolean matched5 = false;

    //nowe
    public int clickCount = 0;
    public int firstClicked = 0;
    public int secondClicked = 0;


    public int GlobalCountOfTap = 0;


    public  void change1(View view) {
        if(!matched1)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            //Toast.makeText(getApplication(), "Checl:"+firstClicked+" "+secondClicked, Toast.LENGTH_SHORT).show();
            ImageButton i = (ImageButton) findViewById(R.id.imageButton);
            if (swap1 || clickCount>2)
            {
                //i.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() +
                //        File.separator + "MemoryGamePictures" + File.separator + "Noga" + "/pic1.jpg"));
                if(clickCount==1 && clicked1 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path1));
                    swap1 = false;

                    secondClicked = 1;
                    clickCount++;
                    if((firstClicked==1 && secondClicked==2)||(firstClicked==2 && secondClicked==1))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                        tv3.setText("Jeeee");
                        matched1 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path1));
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap1 = false;
                    firstClicked = 1;
                    clicked1 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path1));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change2(View view) {
        if(!matched1)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton2);
            if (swap2 || clickCount>2)
            {
                if(clickCount==1 && clicked2==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path2));
                    swap2 = false;

                    secondClicked = 2;
                    clickCount++;
                    if((firstClicked==1 && secondClicked==2)||(firstClicked==2 && secondClicked==1))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched1 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path2));
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds

                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap2 = false;
                    firstClicked = 2;
                    clicked2 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path2));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }

    public  void change3(View view) {
        if(!matched2)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton3);
            if (swap3 || clickCount>2)
            {
                if(clickCount==1&& clicked3==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path3));
                    swap3 = false;

                    secondClicked = 3;
                    clickCount++;
                    if((firstClicked==3 && secondClicked==4)||(firstClicked==4 && secondClicked==3))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched2 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path3));
                        // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap3 = false;
                    firstClicked = 3;
                    clicked3 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path3));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change4(View view) {
        if(!matched2)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton4);
            if (swap4 || clickCount>2)
            {
                if(clickCount==1&& clicked4==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path4));
                    swap4 = false;

                    secondClicked = 4;
                    clickCount++;
                    if((firstClicked==3 && secondClicked==4)||(firstClicked==4 && secondClicked==3))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched2 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path4));
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap4 = false;
                    firstClicked = 4;
                    clicked4 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path4));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change5(View view) {
        if(!matched3)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton5);
            if (swap5 || clickCount>2)
            {
                if(clickCount==1&& clicked5==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path5));
                    swap5 = false;

                    secondClicked = 5;
                    clickCount++;
                    if((firstClicked==5 && secondClicked==6)||(firstClicked==6 && secondClicked==5))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched3 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path5));
                        // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap5 = false;
                    firstClicked = 5;
                    clicked5 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path5));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change6(View view) {
        if(!matched3)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton6);
            if (swap6 || clickCount>2)
            {
                if(clickCount==1&& clicked6==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path6));
                    swap6 = false;

                    secondClicked = 6;
                    clickCount++;
                    if((firstClicked==5 && secondClicked==6)||(firstClicked==6 && secondClicked==5))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched3 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path6));
                        // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap6 = false;
                    firstClicked = 6;
                    clicked6 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path6));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change7(View view) {
        if(!matched4)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton7);
            if (swap7 || clickCount>2)
            {
                if(clickCount==1&& clicked7==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path7));
                    swap7 = false;

                    secondClicked = 7;
                    clickCount++;
                    if((firstClicked==7 && secondClicked==8)||(firstClicked==8 && secondClicked==7))
                    {
                       // Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched4 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path7));
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap7 = false;
                    firstClicked = 7;
                    clicked7 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path7));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change8(View view) {
        if(!matched4)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton8);
            if (swap8 || clickCount>2)
            {
                if(clickCount==1&& clicked8==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path8));
                    swap8 = false;

                    secondClicked = 8;
                    clickCount++;
                    if((firstClicked==7 && secondClicked==8)||(firstClicked==8 && secondClicked==7))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched4 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path8));
                        // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose ==true)
                {
                    lose = false;
                    swap8 = false;
                    firstClicked = 8;
                    clicked8 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path8));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change9(View view) {
        if(!matched5)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            ImageButton i = (ImageButton) findViewById(R.id.imageButton9);
            if (swap9 || clickCount>2)
            {
                if(clickCount==1&& clicked9==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path9));
                    swap9 = false;

                    secondClicked = 9;
                    clickCount++;
                    if((firstClicked==9 && secondClicked==10)||(firstClicked==10 && secondClicked==9))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched5 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path9));
                        // Toast.makeText(getApplication(), "Try again!"+firstClicked+" "+secondClicked, Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap9 = false;
                    firstClicked = 9;
                    clicked9 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path9));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }
    public  void change10(View view) {
        if(!matched5)
        {
            TextView tv = (TextView)findViewById(R.id.textView3);
            GlobalCountOfTap++;
            tv.setText("Taps:"+ GlobalCountOfTap);
            //Toast.makeText(getApplication(), "!!!", Toast.LENGTH_SHORT).show();
            ImageButton i = (ImageButton) findViewById(R.id.imageButton10);
            if (swap10 || clickCount>2)
            {
                if(clickCount==1 && clicked10==false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path10));
                    swap10 = false;

                    secondClicked = 10;
                    clickCount++;
                    if((firstClicked==9 && secondClicked==10)||(firstClicked==10 && secondClicked==9))
                    {
                        //Toast.makeText(getApplication(), "Its a match!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#00FF00"));
                                tv3.setText("Jeeee");
                        matched5 = true;
                        clickCount = 0;
                        firstClicked = 0;
                        secondClicked = 0;
                        if(matched1 && matched2 && matched3 && matched4 && matched5)
                        {
                            Win();
                        }
                    }
                    else
                    {
                        i.setImageBitmap(BitmapFactory.decodeFile(path10));
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // yourMethod();
                                swapWhenLose();
                                lose = false;
                            }
                        }, 2000);   //2 seconds
                    }
                }
                else if(clickCount==0 && lose == true)
                {
                    lose = false;
                    swap10 = false;
                    firstClicked = 10;
                    clicked10 = true;
                    clickCount++;
                    i.setImageBitmap(BitmapFactory.decodeFile(path10));
                }
                lose = true;

            }
            TextView tv2 = (TextView)findViewById(R.id.textView4);
            tv2.setText("("+firstClicked+","+secondClicked+")");
        }
    }

    public void Win()
    {
        TextView tv3 = (TextView)findViewById(R.id.textView5);
        tv3.setText("You Win!");
    }
    public void swapWhenLose()
    {
        clickCount = 0;
        firstClicked = 0;
        secondClicked = 0;


        clicked1 = false;
        clicked2 = false;
        clicked3 = false;
        clicked4 = false;
        clicked5 = false;
        clicked6 = false;
        clicked7 = false;
        clicked8 = false;
        clicked9 = false;
        clicked10 = false;

        if(!swap1 && matched1==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap2 && matched1==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton2);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap3 && matched1==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton3);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap4 && matched1==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton4);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap5 && matched3==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton5);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap6 && matched3==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton6);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap7 && matched4==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton7);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap8 && matched4==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton8);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap9 && matched5==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton9);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap10 && matched5==false)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton10);
            i.setImageResource(R.drawable.pudzian);
        }
         swap1 = true;
        swap2 = true;
        swap3 = true;
        swap4 = true;
        swap5 = true;
        swap6 = true;
         swap7 = true;
         swap8 = true;
        swap9 = true;
        swap10 = true;
    }


}