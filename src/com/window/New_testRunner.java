package com.window;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneLayout;
import javax.swing.UIManager;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenCommandLineBuilder;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.scijava.swing.checkboxtree.CheckBoxNodeData;
import org.scijava.swing.checkboxtree.CheckBoxNodeEditor;
import org.scijava.swing.checkboxtree.CheckBoxNodeRenderer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

public class New_testRunner {

	private JFrame frame;
	JLabel Suite_lable = new JLabel("No Suite Selected");
	File[] Suitefiles;
	static JFileChooser filechooser1 = new JFileChooser();
	static File dir;
	
	JPanel suite_Main_panel = new JPanel();
	static JPanel suite_left_panel = new JPanel();
	List<Element> _tests;
	 static JScrollPane scrollPanel;
	static JPanel suite_right_panel = new JPanel();
	 
	static JTree tree = new JTree();
	static DefaultMutableTreeNode root;
	static DefaultTreeModel treeModel = new DefaultTreeModel(root);
	static DefaultMutableTreeNode accessibility;
	static JTextArea consol_textArea = new JTextArea();
	
   //JTextArea _textarea = new JTextArea();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					New_testRunner window = new New_testRunner();

					Threadrunner thr = new Threadrunner(consol_textArea);
					thr.run();
					//suite_right_panel.repaint();
					//suite_right_panel.updateUI();
	
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
	public New_testRunner() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 928, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		tabbedPane.addTab("Suite Runner", null, suite_Main_panel, null);
		
		final JPanel suite_upper_panel = new JPanel();
		
		
		
		
		GroupLayout gl_suite_Main_panel = new GroupLayout(suite_Main_panel);
		gl_suite_Main_panel.setHorizontalGroup(
			gl_suite_Main_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_suite_Main_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_suite_Main_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_suite_Main_panel.createSequentialGroup()
							.addComponent(suite_left_panel, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(suite_right_panel, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
						.addComponent(suite_upper_panel, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_suite_Main_panel.setVerticalGroup(
			gl_suite_Main_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_suite_Main_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(suite_upper_panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_suite_Main_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(suite_left_panel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
						.addComponent(suite_right_panel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
					.addContainerGap())
		);
		suite_right_panel.setLayout(new BorderLayout(0, 0));
		
		final JScrollPane scrollPane = new JScrollPane();
		suite_right_panel.add(scrollPane, BorderLayout.CENTER);
		consol_textArea.setEditable(false);
		consol_textArea.setIgnoreRepaint(true);
		
	
		consol_textArea.setWrapStyleWord(true);
		//consol_textArea.setText("hgfghf");
		scrollPane.setViewportView(consol_textArea);
		suite_left_panel.setAutoscrolls(false);
		suite_left_panel.setMaximumSize(new Dimension(500, 32767));
		suite_left_panel.setLayout(new BorderLayout(0, 0));
		
		JButton suite_button = new JButton("Select Suite File");
		suite_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consol_textArea.setText("");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Suite File", "xml");
				
				dir = new File("E:\\Projects\\Genix\\OWLS\\Workspace\\OWLS_Automation_Final\\Build");
				filechooser1.setFileFilter(filter);
				filechooser1.setMultiSelectionEnabled(true);
				filechooser1.setCurrentDirectory(dir);
				
				//filechooser.setCurrentDirectory();
				filechooser1.showOpenDialog(suite_upper_panel);
			
				int retVal = filechooser1.APPROVE_OPTION; 
				if (retVal == JFileChooser.APPROVE_OPTION) {
					Suite_lable.setText(String.valueOf(filechooser1.getSelectedFiles().length));
					//System.out.println("Approve");
					//Suite_lable.setText("Ankit");
					Suitefiles = filechooser1.getSelectedFiles();
					System.out.println("No. of Suites Loded : "+Suitefiles.length);
				}
				
				
				
				suite_left_panel.removeAll();
				
				/* Display Tree View */
				/*Xml Parsing */
				
				root = new DefaultMutableTreeNode("Suites");
				
				int totaltests = 0;
				
				for(int filecount=0;filecount < Suitefiles.length;filecount++)
				{
					
					SAXBuilder builder = new SAXBuilder();
			        Document doc;
			        String suitename="";
					try {
						doc = (Document) builder.build(Suitefiles[filecount]);
						Element rootNode = doc.getRootElement();
						suitename=rootNode.getAttributeValue("name");
						
						
						  //System.out.println("Suite Name : "+ suitename);
						
						_tests = rootNode.getChildren("test");
						
						System.out.println("No. of test in '"+suitename+"' suite : "+_tests.size());
						
						
					} catch (JDOMException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				
				/* Xml Parsing */
				
				
				
				 

				 accessibility = new DefaultMutableTreeNode(suitename);
						//add(root, suitename, false);
				
				for (int i = 0; i < _tests.size(); i++) {
					//System.out.println("Test Name : "+_tests.get(i).getText());
					add(accessibility,_tests.get(i).getAttribute("name").getValue(),false);
				}
				
				//add(accessibility, "Move system caret with focus/selection changes", false);
				//add(accessibility, "Always expand alt text for images", true);
				
				root.add(accessibility);
			
				}
				/*
				final DefaultMutableTreeNode browsing =
					new DefaultMutableTreeNode("Browsing");
				add(browsing, "Notify when downloads complete", true);
				add(browsing, "Disable script debugging", true);
				add(browsing, "Use AutoComplete", true);
				add(browsing, "Browse in a new process", false);
				root.add(browsing);

				*/
				
				 treeModel = new DefaultTreeModel(root);
				tree = new JTree(treeModel);

				final CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
				tree.setCellRenderer(renderer);

				final CheckBoxNodeEditor editor = new CheckBoxNodeEditor(tree);
				tree.setCellEditor(editor);
				tree.setEditable(true);
					
				
				  
				
				scrollPanel = new JScrollPane(tree);
				scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
				//suite_left_panel.removeAll();
				scrollPanel.setLayout(new ScrollPaneLayout());
				//suite_left_panel.setLayout();
				scrollPanel.setPreferredSize(new Dimension(150, 400));
				
				suite_left_panel.setLayout(new BorderLayout());
				suite_left_panel.add(scrollPanel);
				
				
				
				suite_left_panel.repaint();
				suite_left_panel.updateUI();
				
				/* Display Tree View */
				
				
				
				
				
				
				
				
			}
		});
		
		
		
		JButton LoadTest_button = new JButton("Load Suite");
		LoadTest_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnRunSuites = new JButton("Run Suites");
		btnRunSuites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
	
				BufferedReader reader;
				String command="";
				try
				{

				
				 command="-DSuiteFile=";
				
				 
				for (int i = 0; i < Suitefiles.length; i++) {
					if(i==0)
					{
						command = command + Suitefiles[i].getAbsolutePath();
					    //System.out.println("command : "+command);
					}else
					{
						command = command + ","+Suitefiles[i].getAbsolutePath();
						//System.out.println("else command : "+command);
					}
					
				}
				
				
			//	System.out.println("last command : "+command);
			
				//System.out.println("Pom File path :"+Suitefiles[0].getAbsolutePath().replaceAll("(/Build/)(.*)", "")+"/pom.xml");
				System.setProperty("maven.home","E:\\Software\\apache-maven-3.2.5-bin\\apache-maven-3.2.5");
				try
				{
				InvocationRequest request = new DefaultInvocationRequest();
				System.err.println("POM Path:::: "+Suitefiles[0].getAbsolutePath().replaceAll("(Build)(.*)", "")+"/pom.xml");
				request.setPomFile( new File(Suitefiles[0].getAbsolutePath().replaceAll("(Build)(.*)", "")+"/pom.xml"));
				request.setGoals(Arrays.asList("clean","integration-test"));
				FileInputStream Fis = new FileInputStream(Suitefiles[0]);
			    request.setInputStream(Fis);
				
				Invoker invoker = new DefaultInvoker();
				//invoker.setMavenHome(new File("E:\\Software\\apache-maven-3.5.0-bin\\apache-maven-3.5.0"));
				
				  invoker.execute( request );
				 
				}
				catch (MavenInvocationException emaven)
				{
				  emaven.printStackTrace();
				}
				
				
				
				
				
				}catch(Exception exp)
				{
					exp.printStackTrace();
				}
				
			
				
			/*	StringBuffer output = new StringBuffer();
				Process p;
				try {
					p = Runtime.getRuntime().exec(command);
					p.waitFor();
					 reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 
		                        String line = "";			
					while ((line = reader.readLine())!= null) {
						output.append(line + "\n");
					}
		 
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			*/
				
				
				
			}
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(final TreeSelectionEvent e) {
				System.out.println(System.currentTimeMillis() + ": selection changed");
				//System.out.println("selction : "+t);
			}
		});
		
		treeModel.addTreeModelListener(new TreeModelListener() {

			@Override
			public void treeNodesChanged(final TreeModelEvent e) {
				Object[] ob =  e.getChildren();
				DefaultMutableTreeNode dm =  (DefaultMutableTreeNode) ob[0];
				CheckBoxNodeData data = (CheckBoxNodeData)dm.getUserObject();
				System.out.println("is checked : "+data.isChecked());
				System.out.println(System.currentTimeMillis() + ": nodes changed "+data.getText());
			}

			@Override
			public void treeNodesInserted(final TreeModelEvent e) {
				System.out.println(System.currentTimeMillis() + ": nodes inserted");
			}

			@Override
			public void treeNodesRemoved(final TreeModelEvent e) {
				System.out.println(System.currentTimeMillis() + ": nodes removed");
			}

			@Override
			public void treeStructureChanged(final TreeModelEvent e) {
				System.out.println(System.currentTimeMillis() + ": structure changed");
			}
		});
		
		
		
		GroupLayout gl_suite_upper_panel = new GroupLayout(suite_upper_panel);
		gl_suite_upper_panel.setHorizontalGroup(
			gl_suite_upper_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_suite_upper_panel.createSequentialGroup()
					.addGap(15)
					.addComponent(suite_button)
					.addGap(18)
					.addComponent(Suite_lable)
					.addGap(33)
					.addComponent(LoadTest_button)
					.addGap(18)
					.addComponent(btnRunSuites)
					.addContainerGap(319, Short.MAX_VALUE))
		);
		gl_suite_upper_panel.setVerticalGroup(
			gl_suite_upper_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_suite_upper_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_suite_upper_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(suite_button)
						.addComponent(Suite_lable)
						.addComponent(LoadTest_button)
						.addComponent(btnRunSuites))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		suite_upper_panel.setLayout(gl_suite_upper_panel);
		suite_Main_panel.setLayout(gl_suite_Main_panel);
		
		JPanel Setting_main_panel = new JPanel();
		tabbedPane.addTab("Setting", null, Setting_main_panel, null);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	
	
	private static DefaultMutableTreeNode add(final DefaultMutableTreeNode parent, final String text,final boolean checked)
		{
			final CheckBoxNodeData data = new CheckBoxNodeData(text, checked);
			final DefaultMutableTreeNode node = new DefaultMutableTreeNode(data);
			parent.add(node);
			return node;
		}
	

	class CheckBoxNodeRenderer implements TreeCellRenderer {
	  private JCheckBox leafRenderer = new JCheckBox();

		  private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();
			/*	
	 Color selectionBorderColor, selectionForeground, selectionBackground,
		      textForeground, textBackground;

		  protected JCheckBox getLeafRenderer() {
		    return leafRenderer;
		  }

		  public CheckBoxNodeRenderer() {
		    Font fontValue;
		    fontValue = UIManager.getFont("Tree.font");
		    if (fontValue != null) {
		      leafRenderer.setFont(fontValue);
		    }
		    Boolean booleanValue = (Boolean) UIManager
		        .get("Tree.drawsFocusBorderAroundIcon");
		    leafRenderer.setFocusPainted((booleanValue != null)
		        && (booleanValue.booleanValue()));

		    selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
		    selectionForeground = UIManager.getColor("Tree.selectionForeground");
		    selectionBackground = UIManager.getColor("Tree.selectionBackground");
		    textForeground = UIManager.getColor("Tree.textForeground");
		    textBackground = UIManager.getColor("Tree.textBackground");
		  }*/

		  public Component getTreeCellRendererComponent(JTree tree, Object value,
		      boolean selected, boolean expanded, boolean leaf, int row,
		      boolean hasFocus) {

		    Component returnValue;
		    if (leaf) {

	  /* String stringValue = tree.convertValueToText(value, selected,
		          expanded, leaf, row, false);*/
	   
		     /* leafRenderer.setText(stringValue);
		      leafRenderer.setSelected(false);

		      leafRenderer.setEnabled(true);*/

		     /* if (selected) {
		        leafRenderer.setForeground(selectionForeground);
		        leafRenderer.setBackground(selectionBackground);
		      } else {
		        leafRenderer.setForeground(textForeground);
		        leafRenderer.setBackground(textBackground);
		      }*/

		     /* if ((value != null) && (value instanceof DefaultMutableTreeNode)) */{
		        Object userObject = ((DefaultMutableTreeNode) value)
		            .getUserObject();
		        if (userObject instanceof CheckBoxNode) {
		          CheckBoxNode node = (CheckBoxNode) userObject;
		          System.out.println("==="+node.getText()+"is Selected ===  "+node.isSelected());
		          leafRenderer.setText(node.getText());
		          leafRenderer.setSelected(node.isSelected());
		        }
		      }
		      returnValue = leafRenderer;
		    } else {
		      returnValue = nonLeafRenderer.getTreeCellRendererComponent(tree,
		          value, selected, expanded, leaf, row, hasFocus);
		    }
		    return returnValue;
		  }
		}
	
	
	
}
