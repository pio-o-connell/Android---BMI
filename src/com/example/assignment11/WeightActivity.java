package com.example.assignment11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WeightActivity extends Activity {
	Button bWeight;
	EditText imperialWeightET;
	double weightAmount=0;
	double height=0;
	double weight=0;
	double BMI=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);
		
		//this.setTitle(MainActivity.givenTitle + ": Height/m: " + MainActivity.height+":Weight/kg: "+ MainActivity.weight);
		
		 bWeight = (Button)findViewById(R.id.changeImperialWeight);
		 imperialWeightET =(EditText) findViewById(R.id.imperialWeightEditText);
		// weightAmount= (double)(weight)* 2.20462; // convert from kgs to pounds
		
		
		
	}
	   public void submitMessage(View V){
	    	 String message =imperialWeightET.getText().toString();
	    	Intent intentMessage=new Intent();
	    	 intentMessage.putExtra("MESSAGE",message);
	    	 System.out.println("Here");
	    	 setResult(4,intentMessage);
	    	 finish();
	     }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	
	
	
	
	
}
