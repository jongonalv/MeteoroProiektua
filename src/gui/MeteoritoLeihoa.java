package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MeteoritoLeihoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel lehioPrintzipala;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeteoritoLeihoa frame = new MeteoritoLeihoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MeteoritoLeihoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 377);
		lehioPrintzipala = new JPanel();
		lehioPrintzipala.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(lehioPrintzipala);
		lehioPrintzipala.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metoro Kudeaketa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 36, 498, 31);
		lehioPrintzipala.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Meteoro berria gehitu");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(50, 103, 153, 39);
		lehioPrintzipala.add(btnNewButton);
		
		JButton btnMeteoroaEzabatu = new JButton("Meteoroa ezabatu");
		btnMeteoroaEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMeteoroaEzabatu.setBounds(338, 103, 137, 39);
		lehioPrintzipala.add(btnMeteoroaEzabatu);
		
		JButton btnDatuBidezListatu = new JButton("Datu bidez listatu");
		btnDatuBidezListatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDatuBidezListatu.setBounds(50, 213, 153, 39);
		lehioPrintzipala.add(btnDatuBidezListatu);
		
		JButton btnNewButton_2_1 = new JButton("Eguneratu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(324, 213, 143, 39);
		lehioPrintzipala.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Irten");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(216, 286, 89, 23);
		lehioPrintzipala.add(btnNewButton_3);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
