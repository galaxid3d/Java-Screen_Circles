package com.GalaxId.Screen_Circles;
import android.graphics.*;
import org.apache.http.*;

public class Circle
{
	private float x, y, size;
	int alpha;
	private boolean isGrow;
	private Paint paint;
	
	public Circle() {
		x = y = size = alpha = 0;
		isGrow = true;
		paint = new Paint();
	}
	
	public Circle(float x, float y, float size, int alpha, Paint paint) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.alpha = alpha;
		this.isGrow = true;
		this.paint = paint;
	}
	
	public float getX() {return this.x;}

	public float getY() {return this.y;}

	public float getSize() {return this.size;}
	
	public int getAlpha() {return this.alpha;}

	public Paint getPaint() {return this.paint;}
	
	public void setX(float x) {this.x = x;}

	public void setY(float y) {this.y = y;}

	public void setSize(float size) {this.size = size;}
	
	public void setAlpha(int alpha) {this.alpha = alpha;}

	public void setPaint(Paint paint) {this.paint = paint;}
	
	public boolean isDelete(int width, int height, float p) {
		if (width < height) p *= width;
		else p *= height;
		if (size*2 > p) alpha -= 5;
		if (alpha < 1) return true;
		else return false;
	}
	
	public void grow(int width, int height) {
		if (size < 1) isGrow = true;
		else if ((x + size >= width)||(x - size < 1)||(y + size >= height)||(y - size < 1)) isGrow = false;
		//isGrow = (x + size >= width)&&(y + size >= height);
		if (isGrow) size += 1;
		else size -= 1;
	}
	
	public void Draw(Canvas canvas) {
		if (size > 0) {
			paint.setAlpha(alpha);
			canvas.drawCircle(x, y, size, paint);
			//canvas.drawArc(2*x+size,2*y+size, x-size,y-size, 0,360,true,paint);
			//canvas.drawRoundRect(xCentr, yCentr, xCentr+size, yCentr + size, 2, 3, paint); 
			//canvas.drawRoundRect(xCentr-size, yCentr-size, xCentr+size, yCentr + size, rx, rx, paint); 
			//canvas.drawRoundRect(xCentr-size, yCentr-size, size*2, size*2, rx, rx, paint);
			//canvas.drawText(Integer.toString(score), xCentr+size/2, yCentr+size/2, new Paint());
		}
	}
	
}
