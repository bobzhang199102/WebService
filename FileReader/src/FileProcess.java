

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author xiaobozhang
 *
 */
public class FileProcess {
	

	//use arraylist to save all the numbers
	ArrayList<Float> numbers = new ArrayList<Float>();
	private int count;
	private double sum;
	
	public void processFile(String fileName)
	{
		// Create a file through
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
				reader = new BufferedReader(new FileReader(file));
				String line = null;
				
				// Read until there is no line
				while ((line=reader.readLine()) != null){
					String[] words=line.split(" ");
				
				for(int i=0;i<words.length;i++){
					if(words.length > 0){
			    		String aword=words[i];
			    		
					    // Judge if it's a number
			    		String a1=aword.charAt(0)+"";
			    		String a2=aword.charAt(aword.length() - 1)+"";	 
			    		
			    		// Create a pattern
			    		Pattern pattern = Pattern.compile("[0-9]{1,}");  
			    		
				        Matcher matcher1 = pattern.matcher(a1);  
				        Matcher matcher2=pattern.matcher(a2);
				   if( matcher1.matches() && matcher2.matches())
				   {
					   // If it is a number, add it to the arraylist
					   numbers.add(Float.parseFloat(aword));  
				   }
				 
			    }
	
			}
    }
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e1) {
			}
		}
	}	
	
	count = numbers.size();
	for (int j=0;j < numbers.size();j++)
	{
		Float number = numbers.get(j);
		sum += number;
	}

	// Print out the count and sum
	System.out.println("count = "+ count);
	System.out.println("sum = "+ sum);
	
	}

}