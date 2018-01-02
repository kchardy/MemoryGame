package www.math.uni.lodz.pl.myapplication;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
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
                if(clickCount==1)
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
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched1 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path1));
                    swap1 = false;

                    firstClicked = 1;
                    clickCount++;
                }
            }
            else
            {
                swap1 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==1)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==1)
                {
                    firstClicked = 0;
                }
                // Toast.makeText(getApplication(), "Checl:"+firstClicked+" "+secondClicked, Toast.LENGTH_SHORT).show();
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
                if(clickCount==1)
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
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched1 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path2));
                    swap2 = false;

                    firstClicked = 2;
                    clickCount++;
                }
            }
            else
            {
                swap2 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==2)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==2)
                {
                    firstClicked = 0;
                }
                //Toast.makeText(getApplication(), "Checl:"+firstClicked+" "+secondClicked, Toast.LENGTH_SHORT).show();
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
                if(clickCount==1)
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
                       // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched2 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path3));
                    swap3 = false;

                    firstClicked = 3;
                    clickCount++;
                }
            }
            else
            {
                swap3 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==3)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==3)
                {
                    firstClicked = 0;
                }
                //Toast.makeText(getApplication(), "Checl:"+firstClicked+" "+secondClicked, Toast.LENGTH_SHORT).show();
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
                if(clickCount==1)
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
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched2 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path4));
                    swap4 = false;

                    firstClicked = 4;
                    clickCount++;
                }
            }
            else
            {
                swap4 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==4)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==4)
                {
                    firstClicked = 0;
                }

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
                if(clickCount==1)
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
                       // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched3 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path5));
                    swap5 = false;

                    firstClicked = 5;
                    clickCount++;
                }
            }
            else
            {
                swap5 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==5)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==5)
                {
                    firstClicked = 0;
                }

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
                if(clickCount==1)
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
                       // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched3 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path6));
                    swap6 = false;

                    firstClicked = 6;
                    clickCount++;
                }
            }
            else
            {
                swap6 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==6)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==6)
                {
                    firstClicked = 0;
                }

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
                if(clickCount==1)
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
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched4 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path7));
                    swap7 = false;

                    firstClicked = 7;
                    clickCount++;
                }
            }
            else
            {
                swap7 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==7)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==7)
                {
                    firstClicked = 0;
                }

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
                if(clickCount==1)
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
                       // Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched4 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path8));
                    swap8 = false;

                    firstClicked = 8;
                    clickCount++;
                }
            }
            else
            {
                swap8 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==8)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==8)
                {
                    firstClicked = 0;
                }


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
                if(clickCount==1)
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
                       // Toast.makeText(getApplication(), "Try again!"+firstClicked+" "+secondClicked, Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched5 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path9));
                    swap9 = false;

                    firstClicked = 9;
                    clickCount++;
                }
            }
            else
            {
                swap9 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==9)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==9)
                {
                    firstClicked = 0;
                }

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
                if(clickCount==1)
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
                        //Toast.makeText(getApplication(), "Try again!", Toast.LENGTH_SHORT).show();
                        TextView tv3 = (TextView)findViewById(R.id.textView5);
                        tv3.setTextColor(Color.parseColor("#FF0000"));
                        tv3.setText("Try again :(");
                    }
                }
                if(clickCount==0 && matched5 == false)
                {
                    i.setImageBitmap(BitmapFactory.decodeFile(path10));
                    swap10 = false;

                    firstClicked = 10;
                    clickCount++;
                }
            }
            else
            {
                //Toast.makeText(getApplication(), "!!!1", Toast.LENGTH_SHORT).show();
                swap10 = true;
                i.setImageResource(R.drawable.pudzian);
                clickCount--;

                if(secondClicked!=0)
                {
                    if(secondClicked==10)
                    {
                        secondClicked=0;
                    }
                    else
                    {
                        firstClicked = secondClicked;
                        secondClicked = 0;
                    }
                }
                else if(firstClicked==10)
                {
                    firstClicked = 0;
                }

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
        if(!swap1)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap2)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton2);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap3)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton3);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap4)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton4);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap5)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton5);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap6)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton6);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap7)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton7);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap8)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton8);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap9)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton9);
            i.setImageResource(R.drawable.pudzian);
        }
        if(!swap10)
        {
            ImageButton i = (ImageButton) findViewById(R.id.imageButton10);
            i.setImageResource(R.drawable.pudzian);
        }

    }


}