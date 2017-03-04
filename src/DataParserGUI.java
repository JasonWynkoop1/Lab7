import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

/**
 * JFrame that holds each of the JPanels and an Action
 * Listener that checks for button pressed and calls ParseSetup
 * when registering what radio button is selected
 */
class DataParserGUI extends JFrame{

	private final MenuBar mb;
	private final ParseSetup ps;

	public DataParserGUI(){
		
		setSize(600, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		LabelPanel lp = new LabelPanel();
		
		mb = new MenuBar(new MenuListener());
		add(mb, BorderLayout.NORTH);

		JPanel east = new JPanel(new GridLayout(1, 1));
		east.add(lp);
		
		add(east, BorderLayout.EAST);

		JPanel center = new JPanel(new GridLayout(2, 0));

		TokenParser tp = new TokenParser(new MenuListener());
		center.add(tp);

		ResultsPanel rp = new ResultsPanel();
		center.add(rp);
		
		add(center, BorderLayout.CENTER);
		ps = new ParseSetup(rp, lp, tp);
	}

	public class MenuListener implements ActionListener{

		/**
		 * Invoked when an action occurs.
		 *
		 * @param e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals("Exit")){

				System.exit(0);

			}else if(e.getActionCommand().equals("Clear")){

				ps.clear();
				mb.menuReset();
				ps.setSuccessfulCount();

			}else if(e.getActionCommand().equals("Token Parser")){

				String selected = mb.getSelectedButtonText();

				if(Objects.equals(selected, "IP")){
					ps.parsedIP();
				}else if(Objects.equals(selected, "Email")){
					ps.parsedEmail();
				}else if(Objects.equals(selected, "Phone")){
					ps.parsedPhone();
				}else if(Objects.equals(selected, "Credit")){
					ps.parsedCredit();
				}
			}
		}
	}
}
