package dc2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReaderWriter extends ReaderWriter{
	
	
	
	public ArrayList<Task> readT(String fileName)
	{
		
		ArrayList<Task> fileTask = new ArrayList<Task>();
		ArrayList<String> parse = new ArrayList<String>();
		
		try{
			buffer = new BufferedReader(new FileReader(fileName));
			line = buffer.readLine();
			
			if(line == null){
				System.out.println("Empty");
			}
			else{
				while(line != null){
					parse = new ArrayList<>();
					for(int i = 0; i < line.split(",").length; i++){
						parse.add(line.split(",")[i]);
					
					
					//day, month, year, name, start time, color
					}
					fileTask.add(new Task(Integer.parseInt(parse.get(0)), parse.get(1), Integer.parseInt(parse.get(2)), parse.get(3), parse.get(4), parse.get(5)));
					
					line = buffer.readLine();
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			if(buffer != null){
				try{
					buffer.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		return fileTask;
	}

	public ArrayList<Event> readE(String fileName)
	{
		
		ArrayList<Event> fileEvent = new ArrayList<Event>();
		ArrayList<String> parse = new ArrayList<String>();
		
		try{
			buffer = new BufferedReader(new FileReader(fileName));
			line = buffer.readLine();
			
			if(line == null){
				System.out.println("Empty");
			}
			else{
				while(line != null){
					parse = new ArrayList<>();
					for(int i = 0; i < line.split(",").length; i++){
						System.out.println("i == " + i);
						parse.add(line.split(",")[i]);
					
					
					// day, month, year, name, start time, end time, color
					}
					fileEvent.add(new Event(Integer.parseInt(parse.get(0)), parse.get(1), Integer.parseInt(parse.get(2)), parse.get(3), parse.get(4), parse.get(5), parse.get(6)));
					 
					line = buffer.readLine();
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			
			if(buffer != null){
				
				try{
					buffer.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		return fileEvent;
	}
	
	public void write(Task toAdd)
	{
		
		fileName = "C:/Users/h12/Documents/gggg.csv";
		FileWriter fw = null;
		try {

			fw = new FileWriter(fileName, true);

			fw.append(String.valueOf(toAdd.getDay()));
			fw.append(",");
			fw.append(toAdd.getMonth());
			fw.append(",");
			fw.append(String.valueOf(toAdd.getYear()));
			fw.append(",");
			fw.append(String.valueOf(toAdd.getName()));
			fw.append(",");
			fw.append(String.valueOf(toAdd.getStartTime()));
			fw.append(",");
			fw.append("GREEN");
			fw.append("\n");

			
		} catch(Exception x) {
			x.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch(IOException x)
			{
				x.printStackTrace();
			}
		}
	}
	
	public void write(Event toAdd)
	{
		FileWriter fw = null;
		fileName = "C:/Users/h12/Documents/stuffstuffsss - Copy.csv";
		try {
		
			fw = new FileWriter(fileName, true);
			fw.append(String.valueOf(toAdd.getDay()));
			fw.append(",");
			fw.append(toAdd.getMonth());
			fw.append(",");
			fw.append(String.valueOf(toAdd.getYear()));
			fw.append(",");
			fw.append(String.valueOf(toAdd.getName()));
			fw.append(",");
			fw.append(String.valueOf(toAdd.getStartTime()));
			fw.append(",");
			fw.append(String.valueOf(toAdd.getEndTime()));
			fw.append(",");			
			fw.append("BLUE");
			fw.append("\n");
			
			
			
				
				
		} catch(Exception x) {
			x.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch(IOException x)
			{
				x.printStackTrace();
			}
		}
	}
	
}
