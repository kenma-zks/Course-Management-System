package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import GUI.Login;
import GUI.RegisterTeacher;
import conn.Conn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Admin implements ActionListener {
	JFrame frame = new JFrame();
	Font myFont = new Font("Abadi", Font.PLAIN, 16);
	Font myFont2 = new Font("Abadi", Font.PLAIN, 20);
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JButton menuButton = new JButton();
	JButton coursesButton = new JButton();
	JButton teacherRegister = new JButton();
	JButton reportCard = new JButton();
	JButton logoutBtn = new JButton();
	JLabel welcomeLabel = new JLabel("Admin Panel");

	JButton assignBtn = new JButton();
	JLabel teacherPresent = new JLabel("Teacher's available: ");
	JComboBox<String> teacherHere = new JComboBox<String>();
	JLabel addModule = new JLabel("Enter Module code:");
	JTextField modulecodeField = new JTextField();
	JButton addModuleBtn = new JButton();
	JButton unassignBtn = new JButton();
	JPanel assignPanel = new JPanel();

	JPanel addCourseJPanel = new JPanel();
	JLabel addmoduleJLabel = new JLabel("Add Module");

	JComboBox<String> addcoursecombo = new JComboBox<String>();
	JLabel addselectCourse = new JLabel("Select a course: ");

	JPanel coursesPanel = new JPanel();

	JPanel editCourseJPanel = new JPanel();
	JLabel courseAvailable = new JLabel("Courses Available");
	JLabel selectCourse = new JLabel("Select a course: ");

	JLabel addmdID = new JLabel("ID: ");
	JLabel addmdName = new JLabel("Name: ");
	JLabel addmdlevel = new JLabel("Level: ");
	JLabel addmdSem = new JLabel("Semester: ");
	JLabel addmdOpt = new JLabel("Optional: ");
	JTextArea lvl6only = new JTextArea("(For lvl 6 only)");
	
	
	JTextField addmdIDField = new JTextField();
	JTextField addmdNameField = new JTextField();
	final String[] list = { "4", "5", "6" };
	JComboBox<String> addmdlevelField = new JComboBox<String>(list);

	final String[] list2 = { "1", "2" };
	JComboBox<String> addmdsemField = new JComboBox<String>(list2);

	final String[] list3 = { "Yes", "No" };
	JComboBox<String> addmdoptField = new JComboBox<String>(list3);
	
	JComboBox<String> courseCombo = new JComboBox<String>();
	JButton addCourse = new JButton();
	JButton delCourse = new JButton();

	JComboBox<String> moduleComboBox = new JComboBox<String>();
	JLabel selectModule = new JLabel("Select a module: ");
	JButton addModuleButton = new JButton();

	JLabel courseLabel = new JLabel("Course name:");
	JButton editcourseName = new JButton();
	JTextField courseNameField = new JTextField();

	JTextField addnewCourse = new JTextField();

	JLabel moduleLabel = new JLabel("Module name:");
	JTextField moduleNameField = new JTextField();

	JButton editmoduleName = new JButton();

	JPanel reportCardPanel = new JPanel();

	JLabel result = new JLabel("Result");
	JLabel studentLabel = new JLabel("Student: ");
	JComboBox<String> studentLabelCombo = new JComboBox<String>();


	JLabel module1Label = new JLabel("Module: ");
	JLabel module1o = new JLabel();

	JLabel marks1Label = new JLabel("Marks: ");
	JLabel marks1o = new JLabel();

	JLabel module2Label = new JLabel("Module: ");
	JLabel module2o = new JLabel();

	JLabel marks2Label = new JLabel("Marks: ");
	JLabel marks2o = new JLabel();

	JLabel module3Label = new JLabel("Module: ");
	JLabel module3o = new JLabel();

	JLabel marks3Label = new JLabel("Marks: ");
	JLabel marks3o = new JLabel();

	JLabel module4Label = new JLabel("Module: ");
	JLabel module4o = new JLabel();

	JLabel marks4Label = new JLabel("Marks: ");
	JLabel marks4o = new JLabel();

	JLabel passOrFail = new JLabel("");

	Border emptyBorder = BorderFactory.createEmptyBorder();

	public Admin() {

		topPanel.setBounds(0, 0, 900, 80);
		topPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
		topPanel.add(logoutBtn);
		topPanel.add(welcomeLabel);
		topPanel.setBackground(new Color(128, 128, 128));
		topPanel.setLayout(null);

		welcomeLabel.setBounds(30, 25, 200, 40);
		welcomeLabel.setFont(myFont2);

		logoutBtn.setBounds(760, 25, 100, 35);
		logoutBtn.setText("Logout");
		logoutBtn.setFont(myFont2);
		logoutBtn.setFocusable(false);
		logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutBtn.setBackground(new Color(95, 158, 160));
		logoutBtn.addActionListener(this);

		leftPanel.setBounds(0, 80, 180, 520);
		leftPanel.add(menuButton);
		leftPanel.add(coursesButton);
		leftPanel.add(teacherRegister);
		leftPanel.add(reportCard);
		leftPanel.add(assignBtn);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(128, 128, 128));

		menuButton.setText("Add module");
		menuButton.setFocusable(false);
		menuButton.setBounds(20, 30, 140, 40);
		menuButton.setFont(myFont);
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuButton.setBorder(null);
		menuButton.setBackground(new Color(95, 158, 160));
		menuButton.addActionListener(this);

		coursesButton.setText("Courses");
		coursesButton.setFocusable(false);
		coursesButton.setBounds(20, 90, 140, 40);
		coursesButton.setFont(myFont2);
		coursesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		coursesButton.setBorder(null);
		coursesButton.setBackground(new Color(95, 158, 160));
		coursesButton.addActionListener(this);

		teacherRegister.setText("Register");
		teacherRegister.setFocusable(false);
		teacherRegister.setBounds(20, 150, 140, 40);
		teacherRegister.setFont(myFont2);
		teacherRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		teacherRegister.setBorder(null);
		teacherRegister.setBackground(new Color(95, 158, 160));
		teacherRegister.addActionListener(this);

		reportCard.setText("Result");
		reportCard.setFocusable(false);
		reportCard.setBounds(20, 210, 140, 40);
		reportCard.setFont(myFont2);
		reportCard.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reportCard.setBorder(null);
		reportCard.setBackground(new Color(95, 158, 160));
		reportCard.addActionListener(this);

		assignBtn.setText("Assign");
		assignBtn.setFocusable(false);
		assignBtn.setBounds(20, 270, 140, 40);
		assignBtn.setFont(myFont2);
		assignBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		assignBtn.setBorder(null);
		assignBtn.setBackground(new Color(95, 158, 160));
		assignBtn.addActionListener(this);

		rightPanel.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
		rightPanel.setBounds(180, 80, 720, 520);

		rightPanel.setLayout(null);

		addCourseJPanel.setBounds(0, 0, 720, 520);
		addCourseJPanel.add(addmoduleJLabel);
		addCourseJPanel.add(addcoursecombo);
		addCourseJPanel.add(addselectCourse);
		addCourseJPanel.add(addModuleButton);
		addCourseJPanel.add(addmdID);
		addCourseJPanel.add(addmdName);
		addCourseJPanel.add(addmdlevel);
		addCourseJPanel.add(addmdSem);
		addCourseJPanel.add(addmdIDField);
		addCourseJPanel.add(addmdNameField);
		addCourseJPanel.add(addmdlevelField);
		addCourseJPanel.add(addmdsemField);
		addCourseJPanel.add(addmdoptField);
		addCourseJPanel.add(addmdOpt);
		addCourseJPanel.add(lvl6only);
		addCourseJPanel.setBackground(new Color(220, 220, 220));
		addCourseJPanel.setLayout(null);

		addmoduleJLabel.setBounds(250, 10, 220, 40);
		addmoduleJLabel.setFont(myFont2);

		addselectCourse.setBounds(10, 60, 160, 40);
		addselectCourse.setFont(myFont2);

		addcoursecombo.setBounds(180, 60, 200, 40);
		addcoursecombo.setFont(myFont2);
		addcoursecombo.addActionListener(this);

		addModuleButton.setText("Add Module");
		addModuleButton.setBounds(180, 360, 130, 40);
		addModuleButton.setFont(myFont);
		addModuleButton.setFocusable(false);
		addModuleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addModuleButton.setBackground(new Color(8, 143, 143));
		addModuleButton.setForeground(Color.white);
		addModuleButton.addActionListener(this);

		addmdID.setBounds(10, 110, 160, 40);
		addmdID.setFont(myFont2);

		addmdName.setBounds(10, 160, 160, 40);
		addmdName.setFont(myFont2);

		addmdlevel.setBounds(10, 210, 160, 40);
		addmdlevel.setFont(myFont2);

		addmdSem.setBounds(10, 260, 160, 40);
		addmdSem.setFont(myFont2);

		addmdOpt.setBounds(10, 310, 160, 40);
		addmdOpt.setFont(myFont2);
		
		addmdIDField.setBounds(180, 110, 400, 40);
		addmdIDField.setFont(myFont2);

		addmdNameField.setBounds(180, 160, 400, 40);
		addmdNameField.setFont(myFont);
		addmdNameField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					addmdNameField.setEditable(true);
				} else {
					addmdNameField.setEditable(false);
				}
			}
		});

		addmdlevelField.setBounds(180, 210, 200, 40);
		addmdlevelField.setFont(myFont2);

		addmdsemField.setBounds(180, 260, 200, 40);
		addmdsemField.setFont(myFont2);

		addmdoptField.setBounds(180, 310, 200, 40);
		addmdoptField.setFont(myFont2);
		
		lvl6only.setBounds(390, 310, 200, 40);
		lvl6only.setFont(myFont);
		lvl6only.setForeground(Color.red);
		lvl6only.setBackground(new Color(220, 220, 220));
		
		coursesPanel.setBounds(0, 0, 720, 520);
		coursesPanel.setBackground(new Color(220, 220, 220));
		coursesPanel.add(editCourseJPanel);
		coursesPanel.setLayout(null);

		editCourseJPanel.setBounds(0, 0, 720, 520);
		editCourseJPanel.setBackground(new Color(220, 220, 220));
		editCourseJPanel.add(courseAvailable);
		editCourseJPanel.add(selectCourse);
		editCourseJPanel.add(courseCombo);
		editCourseJPanel.add(selectModule);
		editCourseJPanel.add(moduleComboBox);
		editCourseJPanel.add(addCourse);
		editCourseJPanel.add(delCourse);
		editCourseJPanel.add(moduleNameField);
		editCourseJPanel.add(editmoduleName);
		editCourseJPanel.add(courseLabel);
		editCourseJPanel.add(editcourseName);
		editCourseJPanel.add(courseNameField);
		editCourseJPanel.add(moduleLabel);
		editCourseJPanel.add(addnewCourse);
		editCourseJPanel.setLayout(null);

		courseAvailable.setBounds(250, 10, 220, 40);
		courseAvailable.setFont(myFont2);

		selectCourse.setBounds(10, 60, 160, 40);
		selectCourse.setFont(myFont2);

		courseCombo.setBounds(180, 60, 200, 40);
		courseCombo.setFont(myFont2);
		courseCombo.addActionListener(this);

		addCourse.setText("Add Course");
		addCourse.setBounds(10, 220, 160, 40);
		addCourse.setFont(myFont);
		addCourse.setFocusable(false);
		addCourse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addCourse.setBackground(new Color(8, 143, 143));
		addCourse.setForeground(Color.white);
		addCourse.addActionListener(this);

		addnewCourse.setBounds(180, 220, 350, 40);
		addnewCourse.setFont(myFont2);
		addnewCourse.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					addnewCourse.setEditable(true);
				} else {
					addnewCourse.setEditable(false);
				}
			}
		});

		delCourse.setText("Delete Course");
		delCourse.setBounds(550, 220, 140, 40);
		delCourse.setFont(myFont);
		delCourse.setFocusable(false);
		delCourse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		delCourse.setBackground(new Color(8, 143, 143));
		delCourse.setForeground(Color.white);
		delCourse.addActionListener(this);

		selectModule.setBounds(10, 290, 160, 40);
		selectModule.setFont(myFont2);

		moduleComboBox.setBounds(180, 290, 370, 40);
		moduleComboBox.setFont(myFont);
		moduleComboBox.addActionListener(this);

		courseLabel.setBounds(10, 110, 160, 40);
		courseLabel.setFont(myFont2);

		editcourseName.setText("Update Name");
		editcourseName.setBounds(10, 160, 160, 40);
		editcourseName.setFont(myFont);
		editcourseName.setFocusable(false);
		editcourseName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editcourseName.setBackground(new Color(8, 143, 143));
		editcourseName.setForeground(Color.white);
		editcourseName.addActionListener(this);

		courseNameField.setBounds(180, 160, 500, 40);
		courseNameField.setFont(myFont);
		courseNameField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					courseNameField.setEditable(true);
				} else {
					courseNameField.setEditable(false);
				}
			}
		});

		moduleLabel.setBounds(10, 340, 160, 40);
		moduleLabel.setFont(myFont2);

		editmoduleName.setText("Update Name");
		editmoduleName.setBounds(10, 390, 160, 40);
		editmoduleName.setFont(myFont);
		editmoduleName.setFocusable(false);
		editmoduleName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editmoduleName.setBackground(new Color(8, 143, 143));
		editmoduleName.setForeground(Color.white);
		editmoduleName.addActionListener(this);

		moduleNameField.setBounds(180, 390, 500, 40);
		moduleNameField.setFont(myFont);
		moduleNameField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					moduleNameField.setEditable(true);
				} else {
					moduleNameField.setEditable(false);
				}
			}
		});

		reportCardPanel.setBounds(0, 0, 720, 520);
		reportCardPanel.add(result);
		reportCardPanel.add(studentLabel);
		reportCardPanel.add(studentLabelCombo);
		reportCardPanel.add(module1Label);
		reportCardPanel.add(module2Label);
		reportCardPanel.add(module3Label);
		reportCardPanel.add(module4Label);
		reportCardPanel.add(module1o);
		reportCardPanel.add(module2o);
		reportCardPanel.add(module3o);
		reportCardPanel.add(module4o);

		reportCardPanel.add(marks1Label);
		reportCardPanel.add(marks2Label);
		reportCardPanel.add(marks3Label);
		reportCardPanel.add(marks4Label);
		reportCardPanel.add(marks1o);
		reportCardPanel.add(marks2o);
		reportCardPanel.add(marks3o);
		reportCardPanel.add(marks4o);
		reportCardPanel.add(passOrFail);
		reportCardPanel.setBackground(new Color(220, 220, 220));
		reportCardPanel.setLayout(null);

		studentLabel.setBounds(20, 20, 200, 40);
		studentLabel.setFont(myFont2);

		studentLabelCombo.setBounds(260, 20, 250, 40);
		studentLabelCombo.setFont(myFont2);
		studentLabelCombo.addActionListener(this);
		try {
			Conn conn = new Conn();
			String sql;
			ResultSet rs;

			sql = "Select username from student";
			rs = conn.s.executeQuery(sql);

			while (rs.next()) {
				String result = rs.getString(1);
				studentLabelCombo.addItem(result);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		module1Label.setBounds(20, 70, 70, 40);
		module1Label.setFont(myFont);

		module1o.setBounds(90, 70, 450, 40);
		module1o.setFont(myFont);

		marks1Label.setBounds(20, 110, 70, 40);
		marks1Label.setFont(myFont);

		marks1o.setBounds(90, 110, 100, 40);
		marks1o.setFont(myFont);

		module2Label.setBounds(20, 150, 70, 40);
		module2Label.setFont(myFont);

		module2o.setFont(myFont);
		module2o.setBounds(90, 150, 450, 40);

		marks2Label.setBounds(20, 190, 70, 40);
		marks2Label.setFont(myFont);

		marks2o.setBounds(90, 190, 100, 40);
		marks2o.setFont(myFont);

		module3Label.setBounds(20, 230, 70, 40);
		module3Label.setFont(myFont);

		module3o.setBounds(90, 230, 450, 40);
		module3o.setFont(myFont);

		marks3Label.setBounds(20, 270, 70, 40);
		marks3Label.setFont(myFont);

		marks3o.setBounds(90, 270, 100, 40);
		marks3o.setFont(myFont);

		module4Label.setBounds(20, 310, 70, 40);
		module4Label.setFont(myFont);

		module4o.setFont(myFont);
		module4o.setBounds(90, 310, 450, 40);

		marks4Label.setBounds(20, 350, 70, 40);
		marks4Label.setFont(myFont);

		marks4o.setBounds(90, 350, 100, 40);
		marks4o.setFont(myFont);

		passOrFail.setBounds(20, 390, 200, 40);
		passOrFail.setFont(myFont2);

		teacherPresent.setBounds(20, 30, 200, 40);
		teacherPresent.setFont(myFont2);

		teacherHere.setBounds(280, 30, 250, 40);
		teacherHere.setFont(myFont2);
		teacherHere.addActionListener(this);

		addModule.setBounds(20, 120, 260, 40);
		addModule.setFont(myFont2);

		modulecodeField.setBounds(280, 120, 200, 50);
		modulecodeField.setFont(myFont2);

		addModuleBtn.setBounds(20, 210, 200, 40);
		addModuleBtn.setFont(myFont2);
		addModuleBtn.setFocusable(false);
		addModuleBtn.setText("Assign Module");
		addModuleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addModuleBtn.setBackground(new Color(8, 143, 143));
		addModuleBtn.setForeground(Color.white);
		addModuleBtn.addActionListener(this);

		unassignBtn.setBounds(280, 210, 200, 40);
		unassignBtn.setFont(myFont2);
		unassignBtn.setFocusable(false);
		unassignBtn.setText("Unassign Module");
		unassignBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		unassignBtn.setBackground(new Color(8, 143, 143));
		unassignBtn.setForeground(Color.white);
		unassignBtn.addActionListener(this);

		assignPanel.setBounds(0, 0, 720, 520);
		assignPanel.add(teacherPresent);
		assignPanel.add(teacherHere);
		assignPanel.add(addModule);
		assignPanel.add(modulecodeField);
		assignPanel.add(addModuleBtn);
		assignPanel.add(unassignBtn);
		assignPanel.setLayout(null);

		frame.add(topPanel);
		frame.add(leftPanel);
		frame.add(rightPanel);

		frame.setTitle("Admin Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	// functions to add a panel to another panel while removing the previous panel

	private void showMenuPanel() throws SQLException {
		if (addCourseJPanel != null) {
			rightPanel.remove(addCourseJPanel);
		}
		if (coursesPanel != null) {
			rightPanel.remove(coursesPanel);
		}
		if (reportCardPanel != null) {
			rightPanel.remove(reportCardPanel);
		}
		if (assignPanel != null) {
			rightPanel.remove(assignPanel);
		}

		rightPanel.add(addCourseJPanel);
		SwingUtilities.updateComponentTreeUI(frame);

	}

	private void showCoursesPanel() throws SQLException {
		if (addCourseJPanel != null) {
			rightPanel.remove(addCourseJPanel);
		}
		if (coursesPanel != null) {
			rightPanel.remove(coursesPanel);
		}
		if (reportCardPanel != null) {
			rightPanel.remove(reportCardPanel);
		}
		if (assignPanel != null) {
			rightPanel.remove(assignPanel);
		}
		rightPanel.add(coursesPanel);

		SwingUtilities.updateComponentTreeUI(frame);

	}

	private void showResultPanel() throws SQLException {
		if (addCourseJPanel != null) {
			rightPanel.remove(addCourseJPanel);
		}
		if (coursesPanel != null) {
			rightPanel.remove(coursesPanel);
		}
		if (reportCardPanel != null) {
			rightPanel.remove(reportCardPanel);
		}
		if (assignPanel != null) {
			rightPanel.remove(assignPanel);
		}
		rightPanel.add(reportCardPanel);
		SwingUtilities.updateComponentTreeUI(frame);

	}

	private void showAssignPanel() throws SQLException {
		if (addCourseJPanel != null) {
			rightPanel.remove(addCourseJPanel);
		}
		if (coursesPanel != null) {
			rightPanel.remove(coursesPanel);
		}
		if (reportCardPanel != null) {
			rightPanel.remove(reportCardPanel);
		}
		if (assignPanel != null) {
			rightPanel.remove(assignPanel);
		}
		rightPanel.add(assignPanel);
		SwingUtilities.updateComponentTreeUI(frame);

	}

	static boolean frameOpened = false;


	{
		try {
			Conn conn = new Conn();
			String sql;
			ResultSet rs;

			sql = "Select username  from instructor";
			rs = conn.s.executeQuery(sql);

			while (rs.next()) {
				String result = rs.getString(1);
				teacherHere.addItem(result);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	{
		try {
			Conn conn = new Conn();
			String sql;
			ResultSet rs;
			sql = "Select DISTINCT name from coursename";
			rs = conn.s.executeQuery(sql);
			while (rs.next()) {
				String result = rs.getString(1);
				courseCombo.addItem(result);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	{
		try {
			Conn conn = new Conn();
			String sql;
			ResultSet rs;
			sql = "Select DISTINCT name from coursename";
			rs = conn.s.executeQuery(sql);
			while (rs.next()) {
				String result = rs.getString(1);
				addcoursecombo.addItem(result);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logoutBtn) {
			frame.dispose();
			Login log = new Login();
		}

		int tempSize = 0;

		try {
			Conn conn = new Conn();
			String sql = "Select * from course where course_name ='" + addcoursecombo.getSelectedItem() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			int size = 0;
			if (rs != null) {
				rs.last();
				size = rs.getRow();
			}
			String sql2 = "Select * from level6 where course_name ='" + addcoursecombo.getSelectedItem() + "'";
			ResultSet rs2 = conn.s.executeQuery(sql2);
			int size2 = 0;
			if (rs2 != null) {
				rs2.last();
				size2 = rs2.getRow();
				int finalSize = size + size2;

				tempSize = finalSize;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (e.getSource() == addModuleButton) {
			try {
				if (tempSize <= 25) {
					Conn conn = new Conn();
					if (!addmdlevelField.getSelectedItem().equals("6")) {
						String sql = String.format(
								"Insert into course (ID, course_name, Name, level, semester) VALUES('%s', '%s', '%s', '%s', '%s')",
								addmdIDField.getText(), addcoursecombo.getSelectedItem(), addmdNameField.getText(),
								addmdlevelField.getSelectedItem(), addmdsemField.getSelectedItem());
						conn.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Registered");
					} else {
						String sql = String.format(
								"Insert into level6 (ID, course_name, Name, level, semester, Optional) VALUES('%s', '%s', '%s', '%s', '%s', '%s')",
								addmdIDField.getText(), addcoursecombo.getSelectedItem(), addmdNameField.getText(),
								addmdlevelField.getSelectedItem(), addmdsemField.getSelectedItem(), addmdoptField.getSelectedItem());
						conn.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Registered");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Max module reached.");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		try {
			if (e.getSource() instanceof JButton) {
				if (e.getSource() == menuButton) {
					showMenuPanel();

				} else if (e.getSource() == coursesButton) {
					showCoursesPanel();

				} else if (e.getSource() == teacherRegister) {

					RegisterTeacher regteacher = new RegisterTeacher();
					try {
						if (frameOpened == false) {
							regteacher.setVisible(true);
							frameOpened = true;

						} else {
							regteacher.close();
							JOptionPane.showMessageDialog(null, "Already opened.");
						}
					} catch (Exception er) {
						er.printStackTrace();
					}
				}

				else if (e.getSource() == reportCard) {
					showResultPanel();

				} else if (e.getSource() == assignBtn) {
					showAssignPanel();
				}

			}

		} catch (SQLException er) {
			er.printStackTrace();
		}

		if (e.getSource() == courseCombo) {
			try {
				moduleComboBox.removeAllItems();
				String sql;
				ResultSet rs;
				Conn conn = new Conn();
				sql = "Select Name from course where course_name ='" + courseCombo.getSelectedItem() + "'";
				rs = conn.s.executeQuery(sql);
				while (rs.next()) {
					String result = rs.getString(1);
					moduleComboBox.addItem(result);
				}
				sql = "Select Name from level6 where course_name ='" + courseCombo.getSelectedItem() + "'";
				rs = conn.s.executeQuery(sql);
				while (rs.next()) {
					String result = rs.getString(1);
					moduleComboBox.addItem(result);
				}
				String sql2 = "Select course_name from course where course_name ='" + courseCombo.getSelectedItem()
						+ "'";
				rs = conn.s.executeQuery(sql2);
				if (rs.next()) {
					courseNameField.setText(rs.getString("course_name"));
				} else {
					courseNameField.setText("");
				}

			} catch (Exception er) {
				er.printStackTrace();
			}
		}

		if (e.getSource() == addCourse) {
			try {
				String sql;
				Conn conn = new Conn();
				sql = String.format("insert into coursename (name) VALUES ('%s')", addnewCourse.getText());
				conn.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Course added");
			} catch (Exception er) {
				er.printStackTrace();
			}
		}

		if (e.getSource() == delCourse) {
			try {
				String sql;
				Conn conn = new Conn();
				sql = String.format("DELETE FROM coursename where name='%s'", addnewCourse.getText());
				conn.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Course deleted");
			} catch (Exception er) {
				er.printStackTrace();
			}
		}

		if (e.getSource() == moduleComboBox) {
			try {
				String sql;
				ResultSet rs;
				Conn conn = new Conn();
				sql = "Select Name from course where Name ='" + moduleComboBox.getSelectedItem() + "'";
				rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					moduleNameField.setText(rs.getString("Name"));
				} else {
					String sql2 = "Select Name from level6 where Name ='" + moduleComboBox.getSelectedItem() + "'";
					ResultSet rs2 = conn.s.executeQuery(sql2);
					if (rs2.next()) {
						moduleNameField.setText(rs2.getString("Name"));
					} else {
						moduleNameField.setText("");
					}
				}

			} catch (Exception er) {
				er.printStackTrace();
			}
		}

		if (e.getSource() == editcourseName) {
			try {
				Conn conn = new Conn();
				String sql2 = String.format("Update course SET course_name = '%s' where course_name = '%s'",
						courseNameField.getText(), courseCombo.getSelectedItem());
				conn.s.executeUpdate(sql2);
				String sql3 = String.format("Update level6 SET course_name = '%s' where course_name = '%s'",
						courseNameField.getText(), courseCombo.getSelectedItem());
				conn.s.executeUpdate(sql3);
				String sql4 = String.format("Update coursename SET name = '%s' where name = '%s'",
						courseNameField.getText(), courseCombo.getSelectedItem());
				conn.s.executeUpdate(sql4);
				String sql5 = String.format("Update instructor SET Course = '%s' where Course = '%s'",
						courseNameField.getText(), courseCombo.getSelectedItem());
				conn.s.executeUpdate(sql5);
				String sql6 = String.format("Update student SET course = '%s' where course = '%s'",
						courseNameField.getText(), courseCombo.getSelectedItem());
				conn.s.executeUpdate(sql6);
				JOptionPane.showMessageDialog(null, "Name changed");

			} catch (Exception er) {
				er.printStackTrace();
			}
		}

		if (e.getSource() == editmoduleName) {
			try {
				Conn conn = new Conn();
				String sql = String.format("Update course SET Name = '%s' where Name = '%s'", moduleNameField.getText(),
						moduleComboBox.getSelectedItem());
				conn.s.executeUpdate(sql);
				String sql2 = String.format("Update level6 SET Name = '%s' where Name = '%s'",
						moduleNameField.getText(), moduleComboBox.getSelectedItem());
				conn.s.executeUpdate(sql2);
				JOptionPane.showMessageDialog(null, "Name changed");

			} catch (Exception er) {
				er.printStackTrace();
			}
		}

		try {

			Conn conn = new Conn();
			ResultSet rs;
			String sql;

			sql = "Select * from student where username ='" + studentLabelCombo.getSelectedItem() + "'";
			rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				module1o.setText(rs.getString("module1"));
				marks1o.setText(rs.getString("marks1"));
				module2o.setText(rs.getString("module2"));
				marks2o.setText(rs.getString("marks2"));
				module3o.setText(rs.getString("module3"));
				marks3o.setText(rs.getString("marks3"));
				module4o.setText(rs.getString("module4"));
				marks4o.setText(rs.getString("marks4"));
				if (rs.getInt("marks1") >= 40 && rs.getInt("marks2") >= 40 && rs.getInt("marks3") >= 40
						&& rs.getInt("marks4") >= 40) {
					passOrFail.setText("PASSED");
				} else if (rs.getInt("marks1") == 0 || rs.getInt("marks2") == 0 || rs.getInt("marks3") == 0
						|| rs.getInt("marks4") == 0) {
					passOrFail.setText("TBD");
				} else {
					passOrFail.setText("FAILED");
				}
			}
		} catch (Exception er) {
			er.printStackTrace();
		}

		if (e.getSource() == unassignBtn) {
			try {
				Conn conn = new Conn();
				String sql = String.format("SELECT * from instructor where username = '%s'",
						teacherHere.getSelectedItem());
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {

					if (rs.getString("module1").equals(modulecodeField.getText())) {
						String sql2 = String.format("Update instructor SET module1 = 'TBD' where username = '%s'",
								teacherHere.getSelectedItem());
						conn.s.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "Teacher removed.");
					} else if (rs.getString("module2").equals(modulecodeField.getText())) {
						String sql2 = String.format("Update instructor SET module2 = 'TBD' where username = '%s'",
								teacherHere.getSelectedItem());
						conn.s.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "Teacher removed.");
					} else if (rs.getString("module3").equals(modulecodeField.getText())) {
						String sql2 = String.format("Update instructor SET module3 = 'TBD' where username = '%s'",
								teacherHere.getSelectedItem());
						conn.s.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "Teacher removed.");
					} else if (rs.getString("module4").equals(modulecodeField.getText())) {
						String sql2 = String.format("Update instructor SET module4 = 'TBD' where username = '%s'",
								teacherHere.getSelectedItem());
						conn.s.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "Teacher removed.");
					} else {
						JOptionPane.showMessageDialog(null, "Invalid");
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == addModuleBtn) {
			try {
				Conn conn = new Conn();
				String sql = String.format("SELECT * from instructor where username = '%s'",
						teacherHere.getSelectedItem());

				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					if (rs.getString("module1").equals("TBD")) {
						String sql3 = String.format("select ID from course where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));
//						String sql3 = "select ID from course where ID ='" + modulecodeField.getText() + "'";
						ResultSet rs3 = conn.s.executeQuery(sql3);
						if (rs3.next()) {
							String sql2 = String.format("UPDATE instructor SET module1 = '%s' where username = '%s'",
									modulecodeField.getText(), teacherHere.getSelectedItem());
							conn.s.executeUpdate(sql2);
							JOptionPane.showMessageDialog(null, "Registered.");
						}
					} else if (rs.getString("module2").equals("TBD")) {
						if (!modulecodeField.getText().equals(rs.getString("module1"))) {
							String sql3 = String.format("select ID from course where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));

//							String sql3 = "select ID from course where ID ='" + modulecodeField.getText() + "'";
							ResultSet rs3 = conn.s.executeQuery(sql3);
							if (rs3.next()) {
								String sql2 = String.format(
										"UPDATE instructor SET module2 = '%s' where username = '%s'",
										modulecodeField.getText(), teacherHere.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered.");
							}
						} 

					} else if (rs.getString("module3").equals("TBD")) {
						if (!modulecodeField.getText().equals(rs.getString("module2"))) {
//							String sql3 = "select ID from course where ID ='" + modulecodeField.getText() + "'";
							String sql3 = String.format("select ID from course where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));

							ResultSet rs3 = conn.s.executeQuery(sql3);
							if (rs3.next()) {
								String sql2 = String.format(
										"UPDATE instructor SET module3 = '%s' where username = '%s'",
										modulecodeField.getText(), teacherHere.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered.");
							}
						} 

					} else if (rs.getString("module4").equals("TBD")) {
						if (!modulecodeField.getText().equals(rs.getString("module3"))) {
//							String sql3 = "select ID from course where ID ='" + modulecodeField.getText() + "'";
							String sql3 = String.format("select ID from course where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));

							ResultSet rs3 = conn.s.executeQuery(sql3);
							if (rs3.next()) {
								String sql2 = String.format(
										"UPDATE instructor SET module4 = '%s' where username = '%s'",
										modulecodeField.getText(), teacherHere.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered.");
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid course.");
							}
						} 
//						else {
//							JOptionPane.showMessageDialog(null, "Module already registered");
//						}

					} 
//					else {
//						JOptionPane.showMessageDialog(null, "All modules are already registered.");
//					}

				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			try {
				Conn conn = new Conn();
				String sql = String.format("SELECT * from instructor where username = '%s'",
						teacherHere.getSelectedItem());
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					if (rs.getString("module1").equals("TBD")) {
						String sql3 = String.format("select ID from level6 where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));
						ResultSet rs3 = conn.s.executeQuery(sql3);
						if (rs3.next()) {
							String sql2 = String.format("UPDATE instructor SET module1 = '%s' where username = '%s'",
									modulecodeField.getText(), teacherHere.getSelectedItem());
							conn.s.executeUpdate(sql2);
							JOptionPane.showMessageDialog(null, "Registered.");
						}
					} else if (rs.getString("module2").equals("TBD")) {
						if (!modulecodeField.getText().equals(rs.getString("module1"))) {
//							String sql3 = "select ID from level6 where ID ='" + modulecodeField.getText() + "'";
							String sql3 = String.format("select ID from level6 where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));
							ResultSet rs3 = conn.s.executeQuery(sql3);
							if (rs3.next()) {
								String sql2 = String.format(
										"UPDATE instructor SET module2 = '%s' where username = '%s'",
										modulecodeField.getText(), teacherHere.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered.");
							}
						}

					} else if (rs.getString("module3").equals("TBD")) {
						if (!modulecodeField.getText().equals(rs.getString("module2"))) {
//							String sql3 = "select ID from level6 where ID ='" + modulecodeField.getText() + "'";
							String sql3 = String.format("select ID from level6 where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));
							ResultSet rs3 = conn.s.executeQuery(sql3);
							if (rs3.next()) {
								String sql2 = String.format(
										"UPDATE instructor SET module3 = '%s' where username = '%s'",
										modulecodeField.getText(), teacherHere.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered.");
							}
						}

					} else if (rs.getString("module4").equals("TBD")) {
						if (!modulecodeField.getText().equals(rs.getString("module3"))) {
//							String sql3 = "select ID from level6 where ID ='" + modulecodeField.getText() + "'";
							String sql3 = String.format("select ID from level6 where ID ='%s' AND course_name = '%s'", modulecodeField.getText(), rs.getString("Course"));
							ResultSet rs3 = conn.s.executeQuery(sql3);
							if (rs3.next()) {
								String sql2 = String.format(
										"UPDATE instructor SET module4 = '%s' where username = '%s'",
										modulecodeField.getText(), teacherHere.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered.");
							}else {
								JOptionPane.showMessageDialog(null, "Invalid course.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Module already registered");
						}

					} else {
						JOptionPane.showMessageDialog(null, "All modules are already registered.");
					}

				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void frameCheck() {
		frameOpened = false;
	}

}
