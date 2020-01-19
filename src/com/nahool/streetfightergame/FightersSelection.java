package com.nahool.streetfightergame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
/**
 * 
 * @author nuhla al masri
 * 
 */
public class FightersSelection extends Activity implements OnItemClickListener {

	/**
	 * class parameters 
	 */
	Integer []images ={R.drawable.img1,R.drawable.img2,R.drawable.img3,
			   R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7
			   ,R.drawable.img8,R.drawable.img9
	};
	
	int fighter1;
	int fighter2;
	int fighterplace1;
	int fighterplace2;
	
	Activity me= this;
	GridView FightersGrid ;
	FMFlipper flipper;
	
	ImageView fighterimg1;
	ImageView fighterimg2;
	ImageButton nextbuton;
	
	int ImgSelectedCount=0;
	Integer background1;
	Integer background2;
	Integer background3;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fighters_selection);
		
		/**
		 * gets extras from  arena activity
		 */
		Intent intent = this.getIntent();
        background1=intent.getIntExtra("background1", 1);
        background2=intent.getIntExtra("background2", 1);
        background3=intent.getIntExtra("background3", 1);
        
        /**
         * get views from layout 
         */
		FightersGrid = (GridView) this.findViewById(R.id.fightersgridview);
	 	fighterimg1 = (ImageView) this.findViewById(R.id.fighter1imagv);
		fighterimg2 = (ImageView) this.findViewById(R.id.fighter2imagv);
		nextbuton = (ImageButton) this.findViewById(R.id.fighternextbtn);
		
		/**
		 * Initialize contents 
		 */
		fighterimg1.setBackgroundResource(R.drawable.backimg2);
		fighterimg2.setBackgroundResource(R.drawable.backimg2);
		nextbuton.setEnabled(false);
		
		/**
		 * Initialize grid view content 
		 */
		flipper= new FMFlipper(this);
		flipper.setThumbIds(images);
		FightersGrid.setAdapter(flipper);
		
		/**
		 * add view listener's
		 */
		FightersGrid.setOnItemClickListener(this);
		nextbuton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(me,FightersSelection.class);
				
				in.putExtra("fighter1", fighter1);
				in.putExtra("fighter2", fighter2);
				in.putExtra("background1", background1);
				in.putExtra("background2", background2);
				in.putExtra("background3", background3);
				
			    me.startActivity(in);
				me.finish();
			}} );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fighters_selection, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		// TODO Auto-generated method stub
		
		ViewFlipper m  = (ViewFlipper)view;
		if(m.getCurrentView().getId()== 2 && ImgSelectedCount<2)
		{
			
			Toast.makeText(this, images[position], Toast.LENGTH_SHORT).show();
			
			//Toast.makeText(this, " first flip " +m.getCurrentView().getId(), Toast.LENGTH_LONG).show();
			m.showNext();
			if(ImgSelectedCount==0){
				fighter1=images[position];
				fighterimg1.setBackgroundResource(fighter1);
				fighterimg1.setTag(images[position]);
				
			}else if(ImgSelectedCount==1){
				
				Toast.makeText(this, fighterimg1.getTag()+""+R.drawable.backimg2+" mm", Toast.LENGTH_LONG).show();
				if(fighterimg1.getTag().equals(R.drawable.backimg2))
				{
					fighter1=images[position];
					fighterimg1.setBackgroundResource(fighter1);
					fighterimg1.setTag(images[position]);
				}
				else
				{
				fighter2=images[position];
				fighterimg2.setBackgroundResource(fighter2);
				fighterimg2.setTag(images[position]);
				}
				
			}
			
			ImgSelectedCount++;
			
		}
		/**
		 * reset chosen characters
		 */
		else if(m.getCurrentView().getId() == 1 && ImgSelectedCount<=2)
		{
			
			if(((ImageView) m.getCurrentView()).getTag().equals(fighterimg1.getTag()))
			{
				fighterimg1.setBackgroundResource(R.drawable.backimg2);
				fighterimg1.setTag(R.drawable.backimg2);
			}
			else if(((ImageView) m.getCurrentView()).getTag().equals(fighterimg2.getTag()))
			{
				fighterimg2.setBackgroundResource(R.drawable.backimg2);	
				fighterimg2.setTag(R.drawable.backimg2);
			}
			ImgSelectedCount--;
			m.showNext();
			
			
		}
		else 
		{
			Toast.makeText(this, 
	       "you only need at maximum three stages in your game" +
	       " \n deselect one of your stages and choose again"
			, Toast.LENGTH_LONG).show();
		}
		
		
		if(ImgSelectedCount==2)
		{
			nextbuton.setEnabled(true);
		}
		else 
		{
			nextbuton.setEnabled(false);
		}
		
		}

}
