import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
/**
 * Creates a panel that holds the results in
 * a text area.
 */
class ResultsPanel extends JPanel{

	private final JTextArea textArea;

	public ResultsPanel() {
		setBorder(new TitledBorder(null, "Results:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setLayout(new GridLayout(1, 1, 0, 0));

		textArea = new JTextArea();
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

}
