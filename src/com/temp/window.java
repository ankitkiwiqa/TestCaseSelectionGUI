package com.temp;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.LineBorder;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

public class window {

	private JFrame frame;
	static JFileChooser filechooser = new JFileChooser();
	static File indexsuite = new File("c:/");
	static List<Element> nodes = new ArrayList<Element>();
	static ArrayList<String> xmlread = new ArrayList<String>();
	static ArrayList<String> testname = new ArrayList<String>();
	static ArrayList<JCheckBox> box = new ArrayList<JCheckBox>();
	static JScrollPane scrollpanel_checkbox = new JScrollPane();
	
	
	JScrollBar bar = new JScrollBar();
	/**
	 * Launch the application.
	 */
	static JPanel panel_Test_cases = new JPanel();
	static JLabel label_test_case_val = new JLabel("0");
	static JLabel label_select_file = new JLabel("No file Selected");
	static JPanel panel_checkbox = new JPanel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
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
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocationByPlatform(true);
		frame.setBounds(100, 100, 745, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Test Runner", null, panel, null);
		
		JPanel panel_select_file = new JPanel();
		panel_select_file.setAlignmentY(0.0f);
		panel_select_file.setAlignmentX(0.0f);
		
		JButton btn_select_file = new JButton("Select TestCase File");
		btn_select_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("c:/");
				filechooser.setCurrentDirectory(file);
				filechooser.showOpenDialog(panel_Test_cases);
				int retVal = filechooser.APPROVE_OPTION;
				if (retVal == JFileChooser.APPROVE_OPTION) {
					label_select_file.setText(filechooser.getSelectedFile().getAbsolutePath());
					indexsuite = filechooser.getSelectedFile();
				}

			
			}
		});
		
		
		label_select_file.setName("lbl_file_select");
		GroupLayout gl_panel_select_file = new GroupLayout(panel_select_file);
		gl_panel_select_file.setHorizontalGroup(
			gl_panel_select_file.createParallelGroup(Alignment.LEADING)
				.addGap(0, 666, Short.MAX_VALUE)
				.addGroup(gl_panel_select_file.createSequentialGroup()
					.addGap(74)
					.addComponent(btn_select_file)
					.addGap(79)
					.addComponent(label_select_file)
					.addContainerGap(247, Short.MAX_VALUE))
		);
		gl_panel_select_file.setVerticalGroup(
			gl_panel_select_file.createParallelGroup(Alignment.LEADING)
				.addGap(0, 75, Short.MAX_VALUE)
				.addGroup(gl_panel_select_file.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_select_file.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_select_file)
						.addComponent(btn_select_file))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_select_file.setLayout(gl_panel_select_file);
		
		
		panel_Test_cases.setAlignmentY(0.0f);
		panel_Test_cases.setAlignmentX(0.0f);
		
		JLabel label_test_case = new JLabel("Total TestCases");
		
		
		
		
		GroupLayout gl_panel_Test_cases = new GroupLayout(panel_Test_cases);
		gl_panel_Test_cases.setHorizontalGroup(
			gl_panel_Test_cases.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Test_cases.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_Test_cases.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_checkbox, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Test_cases.createSequentialGroup()
							.addComponent(label_test_case)
							.addGap(47)
							.addComponent(label_test_case_val)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_Test_cases.setVerticalGroup(
			gl_panel_Test_cases.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Test_cases.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Test_cases.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_test_case)
						.addComponent(label_test_case_val))
					.addGap(28)
					.addComponent(panel_checkbox, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		
		GroupLayout gl_panel_checkbox = new GroupLayout(panel_checkbox);
		gl_panel_checkbox.setHorizontalGroup(
			gl_panel_checkbox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_checkbox.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollpanel_checkbox, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_checkbox.setVerticalGroup(
			gl_panel_checkbox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_checkbox.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollpanel_checkbox, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_checkbox.setLayout(gl_panel_checkbox);
		panel_Test_cases.setLayout(gl_panel_Test_cases);
		
		JPanel panel_btns = new JPanel();
		
		JButton btn_load_test = new JButton("Load Tests");
		btn_load_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DocumentFactory df = new DocumentFactory().getInstance();
					SAXReader reader = new SAXReader(df);
					Document doc = reader.read(indexsuite);
					Element root = doc.getRootElement();
					// lbl_select.setText(root.getName());
					nodes = root.selectNodes("test");

					label_test_case_val.setText(String.valueOf(nodes.size()));

					// final JFrame frame = new JFrame("Test");
					//panel_CheckBox.setLayout(new ScrollPaneLayout());
				
					JPanel chk_panel = new  JPanel();
					
					scrollpanel_checkbox.setLayout(new ScrollPaneLayout());
					//scrollpanel_checkbox.add( Box.createVerticalStrut(1000) );
					scrollpanel_checkbox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			        scrollpanel_checkbox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			        panel_checkbox.setLayout(new GridLayout(nodes.size(),1));
			        System.out.println("nodes size :"+nodes.size());
			        
					
					chk_panel.setLayout(new GridLayout(nodes.size(),1));
				
					for (int i = 0; i < nodes.size(); i++) {
						System.out.println(nodes.get(i).attribute("name")
								.getValue());

						JCheckBox j_cb = new JCheckBox(nodes.get(i)
								.attribute("name").getValue());
						box.add(j_cb);
						//checkbol_jpanel.add(j_cb);
						//scrollpanel_checkbox.getViewport().add(j_cb);
						chk_panel.add(j_cb);
						//scrollpanel_checkbox.add(j_cb);
					}
					
					/*JCheckBox j_cb1 = new JCheckBox("Abc");
					scrollpanel_checkbox.getViewport().add(j_cb1,1);
					JCheckBox j_cb2 = new JCheckBox("Abcd");
					scrollpanel_checkbox.getViewport().add(j_cb2,2);
					JCheckBox j_cb3 = new JCheckBox("Abcde");
					scrollpanel_checkbox.getViewport().add(j_cb3,3);
					JCheckBox j_cb4 = new JCheckBox("Abcdef");
					scrollpanel_checkbox.getViewport().add(j_cb4,4);
					JCheckBox j_cb5 = new JCheckBox("Abcdefg");
					scrollpanel_checkbox.getViewport().add(j_cb5,5);*/
				
					//chk_panel.setPreferredSize(new Dimension(500,500));
					
					scrollpanel_checkbox.setSize(new Dimension(1500,1500));
					scrollpanel_checkbox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					scrollpanel_checkbox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					
					scrollpanel_checkbox.setWheelScrollingEnabled(true);
					
					
					//panel_checkbox.add(scrollpanel_checkbox);
					chk_panel.setSize(new Dimension(1500, 1500));
					scrollpanel_checkbox.setViewportView(chk_panel);
					scrollpanel_checkbox.revalidate();
					scrollpanel_checkbox.repaint();
					// System.out.println("here");
					
					
					panel_checkbox.setPreferredSize(new Dimension(500,500));
					panel_checkbox.revalidate();
					panel_checkbox.repaint();

					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					// frame.setSize(400, 800);
					frame.setVisible(true);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				
		
				
			}
		});
		
		JButton btn_Build = new JButton("Build");
		btn_Build.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = 0;
				for (int i = 0; i < box.size(); i++) {
					if (box.get(i).isSelected()) {
						testname.add(box.get(i).getText());
					}
				}

				try {
					String line = "";
					BufferedReader br = new BufferedReader(new FileReader(
							indexsuite));
					FileWriter fw = new FileWriter(
							"E:\\Projects\\Genix\\OWLS\\Workspace\\OWLS_Automation_Final\\Build\\New_indexSuite.xml");
					// line = br.readLine();
					String pattern1 = "(<test)(.*)";

					while ((line = br.readLine()) != null) {
						Pattern p = Pattern.compile(pattern1);
						Matcher m = p.matcher(line);
						if (m.find()) {
							break;
						}
						fw.write(line + "\n");
						System.out.println("line : " + line);
					}

				
					int testcount =testname.size();
					
					while (line != null ) {

						System.out.println("testname size =============================== "+testcount);
						
						if(testcount>0)
						{
							System.out.println("testname size in loop =============================== "+testcount);
						try {

							String pattern2 = "(.*)(" + testname.get(k)
									+ ")(.*)";
						//	System.out.println("pattern Line :"+line);
				//System.out.println("pattern "+pattern2);
							Pattern p = Pattern.compile(pattern2);
							Matcher m = p.matcher(line);

						if(!line.trim().equals(""))
						{
							if (m.find()) {
								System.out.println("match : " + line);
								String pattern3 = "(.*)(</test>)(.*)";
								Pattern p2 = Pattern.compile(pattern3);
								Matcher m2 = p2.matcher(line);
								while (!m2.find()) {

									// System.out.println("========found=== "+line);

									System.out.println("Line Writen : "+line);
									fw.write(line + "\n");
									m2 = p2.matcher(line);
									line = br.readLine();
									
								}
								k++;
								testcount--;
								
							} else {
								System.out.println("in Else code===========");
								System.out.println("match : " + line);
								String pattern3 = "(.*)(</test>)(.*)";
								Pattern p2 = Pattern.compile(pattern3);
								Matcher m2 = p2.matcher(line);
								while (!m2.find()) {

									// System.out.println("========found=== "+line);

									 System.out.println("not writen : "+line);

									m2 = p2.matcher(line);
									line = br.readLine();

								}

							}
							
							
						}
						
						
						} catch (IndexOutOfBoundsException ex) {
							System.out.println("Index out of bund is thrown");
						}
					
					}// end of testname if	
						line = br.readLine();
						if(line!=null)
						{
						 //fw.write(line+"\n");
						}
					}

					
					fw.close();
					br.close();
					for (int j = 0; j < box.size(); j++) {
						if (box.get(j).isSelected()) {
							System.out.println("is :" + box.get(j).getText());
						}
					}

				} catch (FileNotFoundException exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				} catch (IOException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_btns = new GroupLayout(panel_btns);
		gl_panel_btns.setHorizontalGroup(
			gl_panel_btns.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_btns.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_btns.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_Build, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(btn_load_test, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(36))
		);
		gl_panel_btns.setVerticalGroup(
			gl_panel_btns.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_btns.createSequentialGroup()
					.addGap(24)
					.addComponent(btn_load_test, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_Build, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(386, Short.MAX_VALUE))
		);
		panel_btns.setLayout(gl_panel_btns);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_select_file, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(panel_Test_cases, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_btns, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_select_file, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Test_cases, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
						.addComponent(panel_btns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_settings = new JPanel();
		tabbedPane.addTab("Settings", null, panel_settings, null);
		GroupLayout gl_panel_settings = new GroupLayout(panel_settings);
		gl_panel_settings.setHorizontalGroup(
			gl_panel_settings.createParallelGroup(Alignment.LEADING)
				.addGap(0, 712, Short.MAX_VALUE)
		);
		gl_panel_settings.setVerticalGroup(
			gl_panel_settings.createParallelGroup(Alignment.LEADING)
				.addGap(0, 587, Short.MAX_VALUE)
		);
		panel_settings.setLayout(gl_panel_settings);
		frame.getContentPane().setLayout(groupLayout);
	}
}
