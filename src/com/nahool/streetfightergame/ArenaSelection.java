package com.nahool.streetfightergame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class ArenaSelection extends Activity implements OnItemClickListener {

	int ImgSelectedCount = 0;
	int img1 =0;
	int img2=0;
	Activity me = this;
	Integer [] arenas;
	
	Integer []images ={R.drawable.arenaicon1,R.drawable.arenaicon2,R.drawable.arenaicon3,
					   R.drawable.arenaicon4,R.drawable.arenaicon5,R.drawable.arenaicon6,
			           R.drawable.arenaicon7,R.drawable.arenaicon8};
	
	String []discription ={"Hanging Gardens","Pyramids","taj mahal",
			  "Jerusalem","Eiffel Tower","Louvre",
	           "Egypt","Saudi desert","Arab market"};
	
	GridView ArenaGrid ;
	ImageButton nextbtn;
	FMFlipper adapter;
	Intent in ;
	Integer background1;
	Integer background2;
	Integer background3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arena_selection);
		
		ArenaGrid = (GridView) this.findViewById(R.id.arenagrid);
		nextbtn = (ImageButton) this.findViewById(R.id.arenanextbtn);
		
		adapter = new FMFlipper(this);
		//ArenaGrid.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		adapter.setThumbIds(images);
		ArenaGrid.setAdapter(adapter);
		
		ArenaGrid.setOnItemClickListener(this);
		nextbtn.setEnabled(false);
		nextbtn.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(me,FightersSelection.class);
				
				in.putExtra("background1", background1);
				in.putExtra("background2", background2);
				in.putExtra("background3", background3);
				//in.putExtra("background4", background3);
				
			    me.startActivity(in);
				me.finish();
				
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arena_selection, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		// TODO Auto-generated method stub
		
		ViewFlipper m  = (ViewFlipper)view;
		
		if(m.getCurrentView().getId()== 2 && ImgSelectedCount<3)
		{
			Toast.makeText(this, discription[position], Toast.LENGTH_SHORT).show();
			ImgSelectedCount++;
			//Toast.makeText(this, " first flip " +m.getCurrentView().getId(), Toast.LENGTH_LONG).show();
			m.showNext();
			if(ImgSelectedCount==1){
				background1=images[position];
			}
			if(ImgSelectedCount==2){
				background2=images[position];
			}
			if(ImgSelectedCount==3)	{
				background3=images[position];
			}
			
			
		}
		else if(m.getCurrentView().getId() == 1 && ImgSelectedCount<=3)
		{
			//Toast.makeText(this, " first flip ", Toast.LENGTH_LONG).show();	
			ImgSelectedCount--;
			m.showNext();
			
		}
		else 
		{
			Toast.makeText(this, "you only need at maximum three stages in your game \n deselect one of your stages and choose again   ", Toast.LENGTH_LONG).show();
		}
		
		
		if(ImgSelectedCount==3)
		{
			nextbtn.setEnabled(true);
		}
		else 
		{
			nextbtn.setEnabled(false);
		}
		}
		
		

	}


