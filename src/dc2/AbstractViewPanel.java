package dc2;

import javax.swing.*;

public abstract class AbstractViewPanel  extends JPanel{
	private ProductivityTool PT;
	private int dayFocused;
	private String monthFocused;
	private int yearFocused;
	private boolean checkTask;
	private boolean checkEvent;
	

	
	abstract void update(ProductivityTool PT, int dayFocused, String monthFocused, int yearFocused, boolean checkTask, boolean checkEvent);
}
