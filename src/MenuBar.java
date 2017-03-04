import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
/**
 * Creates a menu bar that hols the clear and exit buttons
 * It also holds the parse menu for each type of data entry.
 */
class MenuBar extends JPanel{

	private final JRadioButtonMenuItem IP;
	private final ButtonGroup bg;
	
	public MenuBar(ActionListener e) {
		
		setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem clear = new JMenuItem("Clear");
		fileMenu.add(clear);
		clear.addActionListener(e);

		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		exit.addActionListener(e);

		JMenu parseMenu = new JMenu("Parse Type");
		menuBar.add(parseMenu);
		parseMenu.addActionListener(e);
		
		IP = new JRadioButtonMenuItem("IP Address");
		IP.setSelected(true);
		IP.setActionCommand("IP");
		parseMenu.add(IP);
		IP.addActionListener(e);

		JRadioButtonMenuItem email = new JRadioButtonMenuItem("Email");
		email.setActionCommand("Email");
		parseMenu.add(email);
		email.addActionListener(e);

		JRadioButtonMenuItem phone = new JRadioButtonMenuItem("Phone Number");
		phone.setActionCommand("Phone");
		parseMenu.add(phone);
		phone.addActionListener(e);

		JRadioButtonMenuItem credit = new JRadioButtonMenuItem("Credit Card");
		credit.setActionCommand("Credit");
		parseMenu.add(credit);
		credit.addActionListener(e);

		bg = new ButtonGroup();

		bg.add(IP);
		bg.add(email);
		bg.add(credit);
		bg.add(phone);

	}

	public void menuReset(){
		IP.setSelected(true);
	}

	/**
	 * Checks to see which button is selected
	 * and returns it
	 * @return
	 */
	public String getSelectedButtonText() {
		ButtonModel model = bg.getSelection();
		if (model == null) {
			return "";
		} else {
			return model.getActionCommand();
		}
	}
	
}
