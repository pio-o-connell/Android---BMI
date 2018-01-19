package com.example.assignment11;

import com.example.assignment11.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	private static final String BMI_STR="BMI";
	private static final String CURRENT_HEIGHT="CURRENT HEIGHT";
	private static final String CURRENT_WEIGHT="CURRENT WEIGHT";
	public static String givenTitle; // visible to PlayGame class
	public final MainActivity mainActivityPointer=this;
	Button bCalculateButton,bImperialConverter;
//	public static double height,weight,BMI;
	private static double height,weight,BMI;
	private static final int HEIGHTACTIVITY =1010;
	private static final int WEIGHTACTIVITY = 2020;
	EditText heightBeforeET,weightBeforeET,bmiBeforeET;
	

	
	
	
	
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.activity_main);  
        givenTitle = (String) this.getTitle(); // get App title 
        bCalculateButton = (Button)findViewById(R.id.calulateButton);
        bImperialConverter = (Button)findViewById(R.id.imperialButton);
        
        if(savedInstanceState==null){	// just started,set default values to match controls
        			
        	///SharedPreferences getData= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        	//		Editor mEditor=prefs.edit();
         	//		height = Double.parseDouble(getData.getString("height",""));
        	//	    weight = Double.parseDouble(getData.getString("weight"," "));
        	//		BMI = Double.parseDouble(getData.getString("BMI", " "));
       // kludge 			
        			height=1.88;
        			weight=85;
        			BMI=24.07;	
        		}
        		
        else
		{
        	height= savedInstanceState.getDouble(CURRENT_WEIGHT);
        	weight = savedInstanceState.getDouble(CURRENT_WEIGHT);
        	BMI = savedInstanceState.getDouble(BMI_STR);
	
        }
        heightBeforeET = (EditText) findViewById(R.id.heightEditText);
        weightBeforeET = (EditText) findViewById(R.id.weightEditText);
        bmiBeforeET = (EditText) findViewById(R.id.bmiEditText);
        
        bCalculateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double weightAmount = Double.parseDouble(weightBeforeET.getText().toString());
				double heightAmount = Double.parseDouble(heightBeforeET.getText().toString());
				double bmiAmount = Double.parseDouble(bmiBeforeET.getText().toString());;
				if (heightAmount !=0){
					bmiAmount= weightAmount / (height * height);
					bmiBeforeET.setText(String.format("%.02f", bmiAmount));
					
					AlertDialog alert = new AlertDialog.Builder(mainActivityPointer).create();
		        	if(bmiAmount > 24)
		        		alert.setMessage("You might need to shed a few pounds");
		        	else
		        		alert.setMessage("You might need to gain a few pounds");
		        	alert.setButton(DialogInterface.BUTTON_POSITIVE,"Try another height/weight",
		        			new DialogInterface.OnClickListener() {
		        				
		    					@Override
		    					public void onClick(DialogInterface dialog, int which) {
		    						// TODO Auto-generated method stub
		    						return;
		    					}
		        	});
		        	
		        	alert.setButton(DialogInterface.BUTTON_NEGATIVE,"Return to main menu", 
		        			new DialogInterface.OnClickListener() {
		    			
		    		
		    			public void onClick(DialogInterface dialog, int which) {
		    				// TODO Auto-generated method stub
		    		//		SharedPreferences prefs=getSharedPreferences("myData",MODE_PRIVATE);
		    		//		Editor mEditor= prefs.edit();
		    		//		mEditor.putString("height",Double.toString(height) );
		    		//		mEditor.putString("weight", Double.toString(weight));
		    		//		mEditor.putString("BMI", Double.toString(BMI));
		    		//		mEditor.commit();
		    				
		    				
		    				
		    					finish();
		    			}
		    		});
		        		
		        	alert.show();
					
					
					
					
					
					
					
					
				}
				else
				{	
				bmiBeforeET.setText("Cannot divide by zero");
				bmiBeforeET.setText(String.format("%.02", bmiAmount));
				}
				
			}
		});
        
   /*     bImperialConverter.setOnClickListener(new View.OnClickListener() {
        
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				try {
					startHeightWindow();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//		System.out.println("hi  there stones -- not here");
		
       
        	
			}
		});*/
        
    }
    
    
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
    	
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==2){
    		if(data!=null){
    			 String message=data.getStringExtra("MESSAGE");
                 // Set the message string in textView
              //   textViewMessage.setText("Message from second Activity: " + message);
    		//	 height = (double)height * 0.0254; // convert from metres to inches
    		//	 heightBeforeET.setText(String.format("%.02", height));
    			 heightBeforeET.setText(message);
    		//	  height = Double.parseDouble(message); 
    		//	  height = height*0.0254;
    		//	  heightBeforeET.setText(String.format("%.02", height));
    		}
    	} else if(requestCode == 4){
    		if(data!=null){
    			String message=data.getStringExtra("MESSAGE");
    			weightBeforeET.setText(message);
    		}
    	}
    	        
    }
    
    
    
    protected void onSaveInstanceState(Bundle outState){
    	super.onSaveInstanceState(outState);
    	
    	outState.putDouble(BMI_STR, BMI);
    	outState.putDouble(CURRENT_HEIGHT, height);
    	outState.putDouble(CURRENT_WEIGHT, weight);
    }


    
    public void getMessage(View V){
    	Intent intentGetMessage = new  Intent(this,HeightActivity.class);
    	startActivityForResult(intentGetMessage,2);
    }
    
    public void getMessageWeight(View V){
    	Intent intentGetMessage = new Intent(this,WeightActivity.class);
    	startActivityForResult(intentGetMessage,4);
    }
    
    
}
