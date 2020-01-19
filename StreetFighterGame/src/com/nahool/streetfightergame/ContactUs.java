package com.nahool.streetfightergame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ContactUs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_me);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_us, menu);
		return true;
	}

}

/*
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
 
public class Email extends Activity {
        Button send;
        EditText address, subject, emailtext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        send=(Button) findViewById(R.id.emailsendbutton);
        address=(EditText) findViewById(R.id.emailaddress);
        subject=(EditText) findViewById(R.id.emailsubject);
        emailtext=(EditText) findViewById(R.id.emailtext);
       
        send.setOnClickListener(new OnClickListener() {
                       
                        @Override
                        public void onClick(View v) {
                                // TODO Auto-generated method stub
                                 
                                      final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                               
                                      emailIntent.setType("plain/text");
                                 
                                      emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ address.getText().toString()});
                               
                                      emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText());
                               
                                      emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailtext.getText());
                       
                                    Email.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
 
                        }
                });
    }
}
*/