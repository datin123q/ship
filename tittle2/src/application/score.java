package application;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
   
public class score {
	static String a[]=new String[21];
	static String filePath = "C:/Users/Admin/Downloads/tittle2/src/application/history.txt"; 
//    public static void main(String []args) {
//    	addlose();
//    }
	public static void addscore(int score, int count) {
		String b[] = new String[21];
		laymang(b);
		changearray(b,score,count);
		addbxh(b);
		
	}
	public static void addlose() {
		String a[] = new String[21];
		laymang(a);
		for(int j=19;j>=0;j--) {
			a[j+1]=a[j];
			
		}
       a[0]= "LOSE                ";
       addbxh(a);
		//printbxh();
	}
	public static void reset() {
		String a[]= new String [21];
		resarray(a);
		addbxh(a);
		printbxh();
	}
	public static void resarray(String a[]) {
		
		for(int i=0;i<20;i++) {
			a[i]="                    ";
		}
	}
	public static void addbxh(String a[]) {
		for(int i=0;i<20;i++) {
			
			try {
				writeData(filePath, a[i], 22*i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void printbxh() {
		try {
			System.out.println(new String(readCharsFromFile(filePath, 0, 10000)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void laymang(String a[]){
		for(int i=0;i<20;i++) {
			String s;
			try {
				s = new String(readCharsFromFile(filePath, 22*i,20));
				  a[i] = s;  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void changearray(String a[],int score,int count) {
		Integer y = new Integer(score);
		String z=y.toString();
		if(z.length()==2) z=" "+z;
		Integer t = new Integer(count);
		String w=t.toString();
		if(z.length()==2) z=" "+z;
		for(int j=19;j>=0;j--) {
					a[j+1]=a[j];
					
				}
		a[0]= "score: "+z+",count="+ w;
				
		}
	

	private static void writeData(String filePath, String data, int seek) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(seek);
		file.write(data.getBytes());
		file.close();
	}

	private static byte[] readCharsFromFile(String filePath, int seek, int chars) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "r");
		file.seek(seek);
		byte[] bytes = new byte[chars];
		file.read(bytes);
		file.close();
		return bytes;
	}

}