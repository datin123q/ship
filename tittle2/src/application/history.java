package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class history {
	public void start(Stage primaryStage) {
		   Label secondLabel = new Label();
		  
		   BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(new File(
						"C:/Users/Admin/Downloads/tittle2/src/application/history.txt")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String str = "";
			String line = "";
			try {
				while((line=br.readLine())!=null){
					str=str+line+"\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block   
				e.printStackTrace();
			}
	  

		secondLabel.setText("    HISTORY\n"+str);
	    secondLabel.setFont(new Font(20));
       
       Pane secondaryLayout = new Pane();
       Button reset= new Button("Reset");
       reset.setFont(new Font(20));
       reset.setLayoutX(400);
       reset.setLayoutY(300);
       secondaryLayout.getChildren().addAll(secondLabel, reset);

       Scene secondScene = new Scene(secondaryLayout, 600, 600);

       primaryStage.setScene(secondScene);
           reset.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	            	 score scoree= new score();
	            	 scoree.reset();
	            	 BufferedReader br = null;
		    			try {
		    				br = new BufferedReader(new FileReader(new File(
		    						"C:/Users/Admin/Downloads/tittle2/src/application/history.txt")));
		    			} catch (FileNotFoundException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    			String str = "";
		    			String line = "";
		    			try {
		    				while((line=br.readLine())!=null){
		    					str=str+line+"\n";
		    				}
		    			} catch (IOException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    			try {
		    				br.close();
		    			} catch (IOException e) {
		    				// TODO Auto-generated catch block   
		    				e.printStackTrace();
		    			}
	     		  

	     			secondLabel.setText("    HISTORY\n"+str);
	     		    secondLabel.setFont(new Font(20));
	                
	                Pane secondaryLayout = new Pane();
	                Button reset= new Button("Reset");
	                reset.setFont(new Font(20));
	                reset.setLayoutX(400);
	                reset.setLayoutY(300);
	                secondaryLayout.getChildren().addAll(secondLabel, reset);

	                Scene secondScene = new Scene(secondaryLayout, 600, 600);

	                primaryStage.setScene(secondScene);
	            	
	            }
	        });

           primaryStage.setX(primaryStage.getX() + 200);
           primaryStage.setY(primaryStage.getY() );

           primaryStage.show();
	}
}
