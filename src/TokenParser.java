import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel that holds the text pane and Token Parser
 * button.
 */
class TokenParser extends JPanel{

	private final JTextPane textPane;

	public TokenParser(ActionListener e) {
		setBorder(new TitledBorder(null, "Token Parser", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setLayout(null);

		textPane = new JTextPane();
		textPane.setBounds(100, 26, 255, 71);
		add(textPane);

		JButton tokenButton = new JButton("Token Parser");
		tokenButton.setBounds(140, 109, 173, 29);
		add(tokenButton);
		tokenButton.addActionListener(e);

	}


	public JTextPane getTextPane() {
		return textPane;
	}

	public String getText(){
		return textPane.getText();
	}

}
