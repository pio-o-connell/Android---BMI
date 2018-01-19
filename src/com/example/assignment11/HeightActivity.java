package com.example.assignment11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HeightActivity extends Activity {
	
	Button bHeight;
	EditText imperialHeightET;
	double heightAmount=0;
	double height=0;
	double weight=0;
	double BMI=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_height);

	//	this.setTitle(MainActivity.givenTitle + ": Height/m: " + MainActivity.height+":Weight/kg: "+ MainActivity.weight);
		 
		 bHeight = (Button)findViewById(R.id.changeImperialHeight);
		 imperialHeightET =(EditText) findViewById(R.id.imperialHeightEditText);
		
	 //    heightAmount= (double)height * 39.3701; // convert from metres to inches
	//     imperialHeightET.setText(String.format("%.02", heightAmount));
	     
	 /*    bHeight.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
				    height = Double.parseDouble(imperialHeightET.getText().toString());
				     height *= 0.0254;  // convert from inches to metres
					try{
						startWeightWindow();
					}
					catch(Exception r){
						r.printStackTrace();
					}
					finally{
						finish();
					}
					
					
					
				}
	        	
	        });*/
	     
	  
		  
		 
	}
	   public void submitMessage(View V){
	    	 String message =imperialHeightET.getText().toString();
	    	Intent intentMessage=new Intent();
	    	 intentMessage.putExtra("MESSAGE",message);
	    	 System.out.println("Here");
	    	 setResult(2,intentMessage);
	    	 finish();
	     }
	   
	   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.height, menu);
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
	
	/* private void startWeightWindow() throws ClassNotFoundException {
			
		 		
		 System.out.println(MainActivity.givenTitle + ": Height/m: " + height+":Weight/kg: "+weight);
			Intent launchHeightWindow = new Intent(this, WeightActivity.class);
			launchHeightWindow.putExtra("Height",height);
			launchHeightWindow.putExtra("Weight",weight);
			startActivity(launchHeightWindow);
			setResult(RESULT_OK,launchHeightWindow);
			finish();

			}*/
	
	
	
	
	
	
}
