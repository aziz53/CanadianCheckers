import javax.swing.JFrame;
import javax.swing.JPanel;


public class CanadianCheckers extends JFrame {
	
	public static CanadianCheckers frame;
	
	/**
	 * Method that sets the content panel for the JFrame.
	 * @param panel the panel that users will see.
	 */
	public static void setContent(JPanel panel){
		frame.setContentPane(panel);
		frame.revalidate();
	}
	
	public CanadianCheckers(){
		setTitle("Canadian Checkers");
		setVisible(true);
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		System.out.println("> Starting Canadian Checkers...");
		frame = new CanadianCheckers();
		setContent(new MainMenu());
	}
	
}
