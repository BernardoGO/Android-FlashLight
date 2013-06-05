package com.go.lightflashlight;

import android.app.Activity;
import android.os.Bundle;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	
	Camera camera = null;
	 Parameters parameters;
	
	 @Override
	 public void onDestroy() {
		 super.onDestroy();
		 try{
		 parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
	     camera.setParameters(parameters);
	     camera.stopPreview();
	     camera.release();
	     camera = null;}
		 catch(Exception E){}
	     //FlashLightControl.setText("Set FLASH_MODE_TORCH");
	 }
	
	 
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button FlashLightControl = (Button)findViewById(R.id.flashcontrol);
        //FlashLightControl.setText("Set FLASH_MODE_TORCH");
        
        FlashLightControl.setOnClickListener(new Button.OnClickListener(){

   @Override
   public void onClick(View arg0) {
    // TODO Auto-generated method stub
	  
	   
	   
    if(camera == null)
    {
    	
    	
    	try{
     camera = Camera.open();
     
     camera.startPreview();
     
     parameters = camera.getParameters();
     parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
     camera.setParameters(parameters);
     
     FlashLightControl.setBackgroundResource(R.drawable.lighton);
   //FlashLightControl.setText("Set FLASH_MODE_OFF");
    	
    	}catch(Exception e)
        {
       	 
        
        }
    }else{
     parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
     camera.setParameters(parameters);
     camera.stopPreview();
     camera.release();
     camera = null;
     
     FlashLightControl.setBackgroundResource(R.drawable.lightoff);
     //FlashLightControl.setText("Set FLASH_MODE_TORCH");
    }
	  
    
   }});
    }



}