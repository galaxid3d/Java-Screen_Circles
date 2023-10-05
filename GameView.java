package com.GalaxId.Screen_Circles;

import android.view.*;
import android.graphics.*;
import java.util.*;
import android.content.*;

public class GameView extends View 
{
	//Bitmap bmp;
	Paint p;
	int count = 0; //кол-во волн 
	Random random = new Random(System.currentTimeMillis());
	List <Circle> circles = new ArrayList<Circle>();
	
	public GameView(Context ctx) {
		super(ctx);
		//bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		p = new Paint();
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		/*try {
			Thread.sleep(30);
		} catch(InterruptedException e) {}*/
		
		canvas.drawColor(Color.BLACK);
		
		for (int i=0; i<count; i++) {
			if (circles.get(i).isDelete(canvas.getWidth(), canvas.getHeight(), 1.1f)) {
				circles.remove(i);
				count -= 1;
				continue;
			}
			circles.get(i).grow(canvas.getWidth(), canvas.getHeight());
			circles.get(i).Draw(canvas);
		}
		invalidate();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_MOVE)
			for (int i=0; i<event.getPointerCount(); i++)
				addCircle(event.getX(i), event.getY(i));
		return true;
	}
	
	public void addCircle(float x, float y) {
		count += 1;
		Paint paint = new Paint();
		paint.setARGB(random.nextInt(127)+127, random.nextInt(255), random.nextInt(255), random.nextInt(255));
		circles.add(new Circle(x, y, 0, paint.getAlpha(), paint));
	}
}
