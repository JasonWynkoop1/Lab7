import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
/**
 * Creating the label panels that holds
 * the individual tokens when the user hits the
 * Token Parser button
 */
class LabelPanel extends JPanel{
	
	private final JLabel l1;
	private final JLabel l2;
	private final JLabel l3;
	private final JLabel l4;
	private final JLabel l5;
	
	public LabelPanel() {
		
		setLayout(new GridLayout(5, 1, 0, 0));
		
		l1 = new JLabel("");
		l1.setPreferredSize(new Dimension(150, 16));
		l1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.GREEN, null, null));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		add(l1);
		
		l2 = new JLabel(".......");
		l2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.BLUE, null, null));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		add(l2);
		
		l3 = new JLabel(".......");
		l3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.YELLOW, null, null));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		add(l3);
		
		l4 = new JLabel(".......");
		l4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.CYAN, null, null));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		add(l4);
		
		l5 = new JLabel(".......");
		l5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.ORANGE, null, null));
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		add(l5);
		
	}

	public JLabel getL1() {
		return l1;
	}

	public JLabel getL2() {
		return l2;
	}

	public JLabel getL3() {
		return l3;
	}

	public JLabel getL4() {
		return l4;
	}

	public JLabel getL5() {
		return l5;
	}

}
