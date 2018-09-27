package com.temp;

import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class newTestwindow {

	private JFrame frame;
	JPanel panel = new JPanel();
	JScrollPane che_scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newTestwindow window = new newTestwindow();
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
	public newTestwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnGenerat = new JButton("Submit");
		
		btnGenerat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setLayout(new GridLayout(1,1));
			
			che_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			che_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				//panel.add(new Label("new lable "+i));
				
			JPanel newpanel = new JPanel();
				newpanel.setLayout(new GridLayout(1000,1));
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
					Label lbl = new Label("new lbl"+i);
					//panel.add(new Label("new lable "+i));
					//che_scrollPane.add(lbl);
					//che_scrollPane.getViewport().add(lbl, i);
				newpanel.add(lbl);
					//che_scrollPane.add(new Checkbox("New Check box"+i));
				}
				che_scrollPane.setViewportView(newpanel);
				che_scrollPane.updateUI();
				che_scrollPane.repaint();
				//panel.add(che_scrollPane);
				panel.updateUI();
				panel.repaint();
				frame.add(panel);
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(btnGenerat)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnGenerat)
					.addGap(47))
		);
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(che_scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(che_scrollPane, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
