package com.nahool.streetfightergame;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FMFlipper extends BaseAdapter {

	
	
	private Context mContext;

	private Integer[] mThumbIds;
	ImageView im;
	ImageView im2;
	
	public FMFlipper(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewFlipper imageView;
		if (convertView == null) {
			 imageView = new ViewFlipper(mContext);
			 im = new ImageView(mContext);
			 im2 = new ImageView(mContext);
			
			im2.setBackgroundResource(R.drawable.gradiant2);
			im2.setLayoutParams(new GridView.LayoutParams(100, 100));
			im2.setScaleType(ImageView.ScaleType.FIT_CENTER);
			im2.setId(1);
			im2.setTag(R.drawable.gradiant2);
			im2.setPadding(2, 2, 2, 2);
			
			im.setBackgroundResource(mThumbIds[position]);
			im.setLayoutParams(new GridView.LayoutParams(100, 100));
			im.setScaleType(ImageView.ScaleType.FIT_CENTER);
			im.setId(2);
			im2.setTag(mThumbIds[position]);
			im.setPadding(2, 2, 2, 2);
			
		
			imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
			imageView.setBackgroundResource(com.nahool.streetfightergame.R.drawable.backimg);
			imageView.addView(im);
			imageView.addView(im2);
			
			
			imageView.setPadding(1, 1, 1, 1);
		} else {
			imageView = (ViewFlipper) convertView;
		}
		
		//imageView.setImageResource(mThumbIds[position]);
		imageView.setTag(mThumbIds[position]);
		return imageView;
	}

	public void setThumbIds(Integer [] ids){
		mThumbIds = ids;
	}

}
