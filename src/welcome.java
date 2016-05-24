import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome!!!!!");
		lblWelcome.setBounds(276, 72, 125, 14);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblFirstPerformData = new JLabel("First perform data mining on data");
		lblFirstPerformData.setBounds(113, 116, 216, 14);
		frame.getContentPane().add(lblFirstPerformData);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datamine ob = new datamine();
				ob.Datamin();
			}
		});
		btnOk.setBounds(339, 112, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(276, 165, 46, 14);
		frame.getContentPane().add(lblOr);
		
		JLabel lblGoToOntology = new JLabel("GO TO ONTOLOGY CREATION");
		lblGoToOntology.setBounds(129, 232, 171, 14);
		frame.getContentPane().add(lblGoToOntology);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schema obj2 = new schema();
				obj2.schem();
			}
		});
		btnOk_1.setBounds(339, 228, 89, 23);
		frame.getContentPane().add(btnOk_1);
	}
}
