package Parser;
import java.io.FileOutputStream;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  




import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
/**
 * @author bessghaiernarjess
 */
public class JSONParser {
	private static String Filename="/Users/bessghaiernarjess/Desktop/JSONS/7.json";
	private static String UIXFilePath = "/Users/bessghaiernarjess/Desktop/"
			+Filename;
     public static String data_File= UIXFilePath+"file.xls";//name of excel file

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader(Filename)); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
          
        // getting clickable and pressed 
        String clickable = (String) jo.get("clickable"); 
        String pressed = (String) jo.get("pressed"); 
          
        System.out.println(clickable); 
        System.out.println(pressed); 
          
        // getting age 
        long focusable = (long) jo.get("focusable"); 
        System.out.println(focusable); 
          
        // getting ancestors 
        Map ancestors = ((Map)jo.get("ancestors")); 
          
        // iterating ancestors Map 
        Iterator<Map.Entry> itr1 = ancestors.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
          
        // getting ancestors 
        JSONArray ja = (JSONArray) jo.get("ancestors"); 
          
        // iterating ancestors 
        Iterator itr2 = ja.iterator(); 
          int i=0;
        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                i++;
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
		
		
        // getting bounds 
        Map bounds = ((Map)jo.get("bounds")); 
          
        // iterating bounds map 
        Iterator<Map.Entry> itr11 = bounds.entrySet().iterator(); 
        while (itr11.hasNext()) { 
            Map.Entry pair = itr11.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
          
        // getting bounds 
        JSONArray ja1 = (JSONArray) jo.get("bounds"); 
          
        // iterating bounds 
        Iterator itr21 = ja1.iterator(); 
          int r=0;
        while (itr21.hasNext())  
        { 
            itr11 = ((Map) itr21.next()).entrySet().iterator(); 
            while (itr11.hasNext()) { 
                Map.Entry pair = itr11.next(); 
                r++;
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
		
       String[] ancestorsdata=new String[i];
       String[] ancestorsdataFinal=new String[i];
       int s=0;
       while (itr2.hasNext())  
       { 
           itr1 = ((Map) itr2.next()).entrySet().iterator(); 
           while (itr1.hasNext()) { 
               Map.Entry pair = itr1.next(); 
              
               System.out.println(pair.getKey() + " : " + pair.getValue());
               ancestorsdata[s]=(String) pair.getValue();
               s++;
           } 
       } 
       
       for (int i1=0; i<ancestorsdata.length;i++)
       {
    	   String values=ancestorsdata[i1];
	       String result="";
	       String result1="";
	       String Globe="";
	        Pattern pattern = Pattern.compile("\"android.widget.(.*)\",");
	        Matcher matcher = pattern.matcher(values);
	        if (matcher.find()) {
	        	 ancestorsdataFinal[i1]=matcher.group(1);
	        	result1=result1+matcher.group(1);
	        	 }
	        System.out.println(result1);
	       
	}


       
       String[] boundsdata=new String[r];
       String[] boundsX=new String[r];
       String[] boundsY=new String[r];
       String[] boundsW=new String[r];
       String[] boundsH=new String[r];
        int k=0;
       while (itr21.hasNext())  
       { 
           itr11 = ((Map) itr21.next()).entrySet().iterator(); 
           while (itr11.hasNext()) { 
               Map.Entry pair = itr11.next(); 
               r++;
               System.out.println(pair.getKey() + " : " + pair.getValue()); 
               boundsdata[k]=(String) pair.getValue();
               k++;
           } 
       } 
        
		
       for (int i1=0; i<boundsdata.length;i++)
       {
    	   String values=boundsdata[i1];
	       String result="";
	       String result1="";
	       String Globe="";
	       
	       //X
	        Pattern pattern = Pattern.compile("^([0-9])");
	        Matcher matcher = pattern.matcher(values);
	        if (matcher.find()) {
	        	boundsX[i1]=matcher.group(1);
	        }
	        //Y	
	        	 Pattern pattern1 = Pattern.compile(",([0-9]+),");
	 	        Matcher matcher1 = pattern1.matcher(values);
	 	        if (matcher1.find()) {
	 	        	boundsY[i1]=matcher1.group(1);}
	 	      //W  	
	 	        	 Pattern pattern11 = Pattern.compile("0,0,([0-9]+),");
	 		        Matcher matcher11 = pattern11.matcher(values);
	 		        if (matcher11.find()) {
	 		        	boundsW[i1]=matcher11.group(1);}
	 		    //H    	
	 		        	 Pattern pattern111 = Pattern.compile("([0-9]+)$");
	 			        Matcher matcher111 = pattern111.matcher(values);
	 			        if (matcher111.find()) {
	 			        	boundsH[i1]=matcher111.group(1);
	        	result1=result1+matcher111.group(1);
	        	 }
	        System.out.println(result1);
	       
	}
       //#######################
		 //#########################
		//write in xls file
		//#######################
		 //######################### 
		 
		 String[] header= {"nature","x","y","width","height"};
		 
		 //write data into xls file

	        
			String sheetName = "Sheet1";//name of sheet1

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName) ;
			 // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int t = 0; t < header.length; t++) {
	            Cell cell = headerRow.createCell(t);
	            cell.setCellValue(header[t]);
	           
	        }
			//iterating r number of rows
	      //iterating r number of rows
	        int k1=1;
			for (int r1=k1;r1 < ancestorsdataFinal.length+1 ; r1++ )
			{
				HSSFRow row = sheet.createRow(r1);
		
				//fill the nature columns
				
					HSSFCell cell = row.createCell(0);
					
					
						 cell.setCellValue(ancestorsdataFinal[r1-1]);
						 
						//fill the x columns
				    		
						 HSSFCell cell1 = row.createCell(1);
	    					
    					 
						 cell1.setCellValue(boundsX[r1-1]);	 
						//fill the y columns
                         HSSFCell cell2 = row.createCell(2);
                         cell2.setCellValue(boundsY[r1-1]);	
                         
                       //fill the w columns
				    		
						 HSSFCell cell3 = row.createCell(1);
	    					
    					 
						 cell3.setCellValue(boundsW[r1-1]);
						 
						 
						//fill the h columns
				    		
						 HSSFCell cell4 = row.createCell(1);
	    					
    					 
						 cell4.setCellValue(boundsH[r1-1]);
    					 
						
							 
			}
			
			
			FileOutputStream fileOut = new FileOutputStream(data_File);
			
			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
	        
	        
			
			System.out.println("----");
			System.out.println("--------");
			System.out.println("------------");
			System.out.println("----------------");
			System.out.println("Final file has been generated!");
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
	}

	
}
