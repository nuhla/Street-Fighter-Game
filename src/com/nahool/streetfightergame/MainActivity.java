package com.nahool.streetfightergame;




import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends Activity implements  OnClickListener {

	/**
	 * main attributes
	 */
	ImageButton ContactUs ;
	ImageButton AboutUs ;
	ImageButton Soundbtn ;
	ImageButton PlayBtn ;
	MediaPlayer backbeeb;
	boolean IfMute=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * get all buttons from layout 
		 */
		ContactUs = (ImageButton) this.findViewById(R.id.aboutus);
		AboutUs = (ImageButton) this.findViewById(R.id.contactus);
		Soundbtn = (ImageButton) this.findViewById(R.id.soundon);
		PlayBtn = (ImageButton) this.findViewById(R.id.play);
		
		/**
		 * set all click event's to our buttons
		 */
		AboutUs.setOnClickListener(this);
		PlayBtn.setOnClickListener(this);
		Soundbtn.setOnClickListener(this);
		ContactUs.setOnClickListener(this);

		
	}

	public void onStart()
	{
		/**
		 * start's all resources needed 
		 */
		super.onStart();
		// backbeeb = MediaPlayer.create(this, R.raw.backgroundmusic);
		
		// backbeeb.start();
		// backbeeb.setLooping(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent in;
		//Toast.makeText(getApplicationContext(), v.getId(), Toast.LENGTH_LONG).show();
		switch (v.getId())
		{
		case R.id.aboutus:
			 in = new Intent(MainActivity.this , AboutUs.class);
			MainActivity.this.startActivity(in);
			break;
		case R.id.contactus:
			 in = new Intent(MainActivity.this , ContactUs.class);
			MainActivity.this.startActivity(in);
			break;
		case R.id.soundon:
			/**
			 * inverse the value of sound - on/off
			 * set suitable image background for it's situation
			 * turn music on or off
			 */
			IfMute=(!IfMute);
			if(IfMute && backbeeb!=null){
				//Soundbtn.setBackgroundResource(R.drawable.soundon);
				backbeeb.pause();
			}
			else{
				//Soundbtn.setBackgroundResource(R.drawable.soundof);
				backbeeb.start();
			}
			
			break;
		case R.id.play:
			/**
			 * start applying game setting's
			 */
			//Toast.makeText(this, "i am in ", Toast.LENGTH_LONG).show();
			 in = new Intent(MainActivity.this , ArenaSelection.class);
				MainActivity.this.startActivity(in);
			break;
			
		}
		
	}

	

}
