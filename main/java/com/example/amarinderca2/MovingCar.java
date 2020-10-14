package com.example.amarinderca2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MovingCar extends View {
    Paint paint;
    int flag =0;
    int x1=500,x2=1000;
    int speed=5;
    public MovingCar(Context context) {
        super(context);
        paint=new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(x1,700,x2,1000,paint);

        if(flag==1)
        {
            if(x1>1550)
            {
                flag=0;
                x1=500;
                x2=1000;
            }
            else{
                x1+=speed;
                x2+=speed;
            }
            invalidate();
        }
        else if(flag==2)
        {
            if(x2<0)
            {
                flag=0;
                x1=500;
                x2=1000;
            }
            else{
                x1-=speed;
                x2-=speed;
            }
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_UP:
                int x=(int)event.getX();
                int y=(int)event.getY();

                if((x>750 && x<1000) && (y>=700 && y<=1000))
                {
                    flag=1;
                    invalidate();
                }
                else if((x<750 && x>500) && (y>=700 && y<=1000))
                {
                    flag=2;
                    invalidate();
                }
        }
        return true;
    }
}
