package dc2;

import java.io.BufferedReader;
import java.util.*;

public abstract class ReaderWriter {
	protected BufferedReader buffer;
	protected String line = "";
	protected String SplitBy = ",";
	protected String fileName;
	protected ArrayList<Task> fileTask = null;
	protected ArrayList<Event> fileEvent = null;
	
	
}
