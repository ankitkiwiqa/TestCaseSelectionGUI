package com.temp;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.JPanel;
import javax.swing.JButton;

import com.jidesoft.swing.CheckBoxList;
import com.jidesoft.swing.CheckBoxTree;
import com.window.CustomOutputStream;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class treeview {

	private JFrame frame;
	JTextArea textArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					treeview window = new treeview();
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
	public treeview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 745, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSeparator separator = new JSeparator();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"new", "new1"}));
		comboBox.setSelectedIndex(1);
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		final JPanel chk_panel = new JPanel();
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultMutableTreeNode nodes = new DefaultMutableTreeNode();
				PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
				System.setOut(printStream);
				System.setErr(printStream); 
				
				
				DefaultListModel model = new DefaultListModel();
				
				//CheckBoxTree chk_tree = new CheckBoxTree();
				TreeNode yourRoot = new DefaultMutableTreeNode("foo"); 
				CheckBoxTree checkboxTree = new CheckBoxTree(yourRoot);
			
		/*		for (int i = 0; i < 5; i++) {
					JCheckBox chk = new JCheckBox("new"+i);
					model.addElement("new"+i);
					System.out.println("new "+i);
					//list.add(chk);
				}  */
				//final CheckBoxList list1 = new CheckBoxList(model);
				//TreeModel treemodel = new 
				
				chk_panel.add(checkboxTree);
				chk_panel.repaint();
				chk_panel.updateUI();

				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(chk_panel, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(143))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(126)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
					.addComponent(btnGenerate)
					.addGap(166))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGenerate)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(277))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chk_panel, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_chk_panel = new GroupLayout(chk_panel);
		gl_chk_panel.setHorizontalGroup(
			gl_chk_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chk_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_chk_panel.setVerticalGroup(
			gl_chk_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chk_panel.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		scrollPane.setViewportView(textArea);
		chk_panel.setLayout(gl_chk_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
