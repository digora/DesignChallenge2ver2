package dc2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderWriter extends ReaderWriter{
	

	public ArrayList<Task> readT()
	{
		return fileTask;
	}
	public ArrayList<Event> readE()
	{
		return fileEvent;
	}
	public void write(Task toAdd)
	{
		FileWriter fw = null;
		try {
			if(fileTask == null)
			{

				fw = new FileWriter(fileName);
				fileTask = new ArrayList<>();	
				fw.append(String.valueOf(toAdd.getDate()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getName()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getStartTime()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getColor()));
				fw.append("\n");
				
				fileTask.add(toAdd);
				
			}
			else{
				fw = new FileWriter(fileName, true);
				fw.append(String.valueOf(toAdd.getDate()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getName()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getStartTime()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getColor()));
				fw.append("\n");
				
				fileTask.add(toAdd);
				
			}
				
			fw.close();
			
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
		try {
			if(fileTask == null)
			{

				fw = new FileWriter(fileName);
				fileEvent = new ArrayList<>();	
				fw.append(String.valueOf(toAdd.getDate()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getName()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getStartTime()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getColor()));
				fw.append("\n");
				
				fileEvent.add(toAdd);
				
			}
			else{
				fw = new FileWriter(fileName, true);
				fw.append(String.valueOf(toAdd.getDate()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getName()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getStartTime()));
				fw.append(",");
				fw.append(String.valueOf(toAdd.getColor()));
				fw.append("\n");
				
				fileEvent.add(toAdd);
				
			}
			fw.close();
			
				
				
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
