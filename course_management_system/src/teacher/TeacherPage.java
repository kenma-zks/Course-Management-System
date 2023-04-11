package teacher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GUI.Login;
import conn.Conn;

public class TeacherPage implements ActionListener {

	JFrame frame = new JFrame();
	Font myFont = new Font("Abadi", Font.PLAIN, 16);
	Font myFont2 = new Font("Abadi", Font.PLAIN, 20);
	Font myFont3 = new Font("Abadi", Font.PLAIN, 18);

	JPanel topPanel = new JPanel();

	JLabel teacherName = new JLabel("Name: ");
	JLabel teacherNameField = new JLabel();

	JLabel courseOnField = new JLabel();
	JLabel courseOnLabel = new JLabel("Course: ");

	JButton logoutBtn = new JButton();
	JButton detailsBtn = new JButton();

	JPanel leftPanel = new JPanel();
	JLabel moduleAvailableLabel = new JLabel("Modules Available:");

	JButton module1 = new JButton();
	JButton module2 = new JButton();
	JButton module3 = new JButton();
	JButton module4 = new JButton();

	JPanel contentPanel = new JPanel();

	JPanel detailsPanel = new JPanel();
	JLabel detailsName = new JLabel("First Name:");
	JLabel detailsEmail = new JLabel("Email:");
	JLabel detailsLastName = new JLabel("Last name:");
	JLabel detailsUserName = new JLabel("Username: ");
	JTextField nameField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField lastnameField = new JTextField();
	JTextField usernameField = new JTextField();
	JButton updateButton = new JButton("Update: ");

	JPanel module1Panel = new JPanel();
	JLabel module1NameLabel = new JLabel("Module Name:");
	JLabel module1Label = new JLabel();
	JLabel module1Student = new JLabel("Students enrolled:");
	JComboBox<String> modules1Studentcombo = new JComboBox<String>();
	JLabel marksLabel = new JLabel("Add marks :");
	JTextField marksTextField = new JTextField();
	JButton addMarksBtn = new JButton();

	JPanel module2Panel = new JPanel();
	JLabel module2NameLabel = new JLabel("Module Name:");
	JLabel module2Label = new JLabel();
	JLabel module2Student = new JLabel("Students enrolled:");
	JComboBox<String> modules2Studentcombo = new JComboBox<String>();
	JLabel marksLabel2 = new JLabel("Add marks :");
	JTextField marksTextField2 = new JTextField();
	JButton addMarksBtn2 = new JButton();

	JPanel module3Panel = new JPanel();
	JLabel module3NameLabel = new JLabel("Module Name:");
	JLabel module3Label = new JLabel();
	JLabel module3Student = new JLabel("Students enrolled:");
	JComboBox<String> modules3Studentcombo = new JComboBox<String>();
	JLabel marksLabel3 = new JLabel("Add marks :");
	JTextField marksTextField3 = new JTextField();
	JButton addMarksBtn3 = new JButton();

	JPanel module4Panel = new JPanel();
	JLabel module4NameLabel = new JLabel("Module Name:");
	JLabel module4Label = new JLabel();
	JLabel module4Student = new JLabel("Students enrolled:");
	JComboBox<String> modules4Studentcombo = new JComboBox<String>();
	JLabel marksLabel4 = new JLabel("Add marks :");
	JTextField marksTextField4 = new JTextField();
	JButton addMarksBtn4 = new JButton();

	public TeacherPage() {
		teacherName.setBounds(20, 20, 80, 50);
		teacherName.setFont(myFont2);

		teacherNameField.setBounds(110, 20, 380, 50);
		teacherNameField.setFont(myFont2);

		courseOnLabel.setBounds(450, 20, 80, 50);
		courseOnLabel.setFont(myFont2);

		courseOnField.setBounds(540, 20, 60, 50);
		courseOnField.setFont(myFont2);

		detailsBtn.setBounds(630, 25, 100, 35);
		detailsBtn.setText("Details");
		detailsBtn.setFont(myFont2);
		detailsBtn.setFocusable(false);
		detailsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		detailsBtn.setBackground(new Color(95, 158, 160));
		detailsBtn.addActionListener(this);

		logoutBtn.setBounds(760, 25, 100, 35);
		logoutBtn.setText("Logout");
		logoutBtn.setFont(myFont2);
		logoutBtn.setFocusable(false);
		logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutBtn.setBackground(new Color(95, 158, 160));
		logoutBtn.addActionListener(this);

		topPanel.setBounds(0, 0, 900, 80);
		topPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
		topPanel.add(teacherName);
		topPanel.add(teacherNameField);
		topPanel.add(courseOnField);
		topPanel.add(courseOnLabel);
		topPanel.add(logoutBtn);
		topPanel.add(detailsBtn);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(128, 128, 128));

		moduleAvailableLabel.setBounds(20, 10, 180, 40);
		moduleAvailableLabel.setFont(myFont2);

		module1.setBounds(20, 70, 160, 40);
		module1.setText("module 1");
		module1.setFont(myFont2);
		module1.setFocusable(false);
		module1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		module1.setBackground(new Color(95, 158, 160));
		module1.addActionListener(this);

		module2.setBounds(20, 140, 160, 40);
		module2.setText("module 2");
		module2.setFont(myFont2);
		module2.setFocusable(false);
		module2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		module2.setBackground(new Color(95, 158, 160));
		module2.addActionListener(this);

		module3.setBounds(20, 210, 160, 40);
		module3.setText("module 3");
		module3.setFont(myFont2);
		module3.setFocusable(false);
		module3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		module3.setBackground(new Color(95, 158, 160));

		module3.addActionListener(this);

		module4.setBounds(20, 280, 160, 40);
		module4.setText("module 4");
		module4.setFont(myFont2);
		module4.setFocusable(false);
		module4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		module4.setBackground(new Color(95, 158, 160));
		module4.addActionListener(this);

		leftPanel.setBounds(0, 80, 210, 520);
		leftPanel.setBackground(new Color(128, 128, 128));
		leftPanel.add(moduleAvailableLabel);
		leftPanel.add(module1);
		leftPanel.add(module2);
		leftPanel.add(module3);
		leftPanel.add(module4);
		leftPanel.setLayout(null);
		leftPanel.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));

		contentPanel.setBounds(210, 80, 690, 520);

		contentPanel.setLayout(null);
		contentPanel.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));

		module1Panel.setBounds(0, 0, 690, 520);
		module1Panel.add(module1NameLabel);
		module1Panel.add(module1Label);
		module1Panel.add(module1Student);
		module1Panel.add(modules1Studentcombo);
		module1Panel.add(marksLabel);
		module1Panel.add(marksTextField);
		module1Panel.add(addMarksBtn);
		module1Panel.setBackground(new Color(211, 211, 211));
		module1Panel.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
		module1Panel.setLayout(null);

		module1NameLabel.setBounds(15, 30, 145, 40);
		module1NameLabel.setFont(myFont3);

		module1Label.setBounds(180, 30, 400, 40);
		module1Label.setFont(myFont3);

		module1Student.setBounds(15, 100, 145, 40);
		module1Student.setFont(myFont3);

		modules1Studentcombo.setBounds(180, 100, 400, 40);
		modules1Studentcombo.setFont(myFont3);

		marksLabel.setBounds(15, 170, 145, 40);
		marksLabel.setFont(myFont3);

		marksTextField.setBounds(180, 170, 145, 40);
		marksTextField.setFont(myFont3);

		marksTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});

		addMarksBtn.setBounds(180, 240, 120, 40);
		addMarksBtn.setText("Add");
		addMarksBtn.setFont(myFont3);
		addMarksBtn.setBackground(new Color(95, 158, 160));
		addMarksBtn.setFocusable(false);
		addMarksBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMarksBtn.addActionListener(this);

		module2Panel.setBounds(0, 0, 690, 520);
		module2Panel.add(module2NameLabel);
		module2Panel.add(module2Label);
		module2Panel.add(module2Student);
		module2Panel.add(modules2Studentcombo);
		module2Panel.add(marksLabel2);
		module2Panel.add(marksTextField2);
		module2Panel.add(addMarksBtn2);
		module2Panel.setBackground(new Color(211, 211, 211));
		module2Panel.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
		module2Panel.setLayout(null);

		module2NameLabel.setBounds(15, 30, 145, 40);
		module2NameLabel.setFont(myFont3);

		module2Label.setBounds(180, 30, 400, 40);
		module2Label.setFont(myFont3);

		module2Student.setBounds(15, 100, 145, 40);
		module2Student.setFont(myFont3);

		modules2Studentcombo.setBounds(180, 100, 400, 40);
		modules2Studentcombo.setFont(myFont3);

		marksLabel2.setBounds(15, 170, 145, 40);
		marksLabel2.setFont(myFont3);

		marksTextField2.setBounds(180, 170, 145, 40);
		marksTextField2.setFont(myFont3);

		marksTextField2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});

		addMarksBtn2.setBounds(180, 240, 120, 40);
		addMarksBtn2.setText("Add");
		addMarksBtn2.setFont(myFont3);
		addMarksBtn2.setBackground(new Color(95, 158, 160));
		addMarksBtn2.setFocusable(false);
		addMarksBtn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMarksBtn2.addActionListener(this);

		module3Panel.setBounds(0, 0, 690, 520);
		module3Panel.add(module3NameLabel);
		module3Panel.add(module3Label);
		module3Panel.add(module3Student);
		module3Panel.add(modules3Studentcombo);
		module3Panel.setBackground(new Color(211, 211, 211));
		module3Panel.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
		module3Panel.setLayout(null);
		module3Panel.add(marksLabel3);
		module3Panel.add(marksTextField3);
		module3Panel.add(addMarksBtn3);

		module3NameLabel.setBounds(15, 30, 145, 40);
		module3NameLabel.setFont(myFont3);

		module3Label.setBounds(180, 30, 400, 40);
		module3Label.setFont(myFont3);

		module3Student.setBounds(15, 100, 145, 40);
		module3Student.setFont(myFont3);

		modules3Studentcombo.setBounds(180, 100, 400, 40);
		modules3Studentcombo.setFont(myFont3);

		marksLabel3.setBounds(15, 170, 145, 40);
		marksLabel3.setFont(myFont3);

		marksTextField3.setBounds(180, 170, 145, 40);
		marksTextField3.setFont(myFont3);

		marksTextField3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});

		addMarksBtn3.setBounds(180, 240, 120, 40);
		addMarksBtn3.setText("Add");
		addMarksBtn3.setFont(myFont3);
		addMarksBtn3.setBackground(new Color(95, 158, 160));
		addMarksBtn3.setFocusable(false);
		addMarksBtn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMarksBtn3.addActionListener(this);

		module4Panel.setBounds(0, 0, 690, 520);
		module4Panel.add(module4NameLabel);
		module4Panel.add(module4Label);
		module4Panel.add(module4Student);
		module4Panel.add(modules4Studentcombo);
		module4Panel.setBackground(new Color(211, 211, 211));
		module4Panel.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
		module4Panel.setLayout(null);
		module4Panel.add(marksLabel4);
		module4Panel.add(marksTextField4);
		module4Panel.add(addMarksBtn4);

		module4NameLabel.setBounds(15, 30, 145, 40);
		module4NameLabel.setFont(myFont3);

		module4Label.setBounds(180, 30, 400, 40);
		module4Label.setFont(myFont3);

		module4Student.setBounds(15, 100, 145, 40);
		module4Student.setFont(myFont3);

		modules4Studentcombo.setBounds(180, 100, 400, 40);
		modules4Studentcombo.setFont(myFont3);

		marksLabel4.setBounds(15, 170, 145, 40);
		marksLabel4.setFont(myFont3);

		marksTextField4.setBounds(180, 170, 145, 40);
		marksTextField4.setFont(myFont3);

		marksTextField4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});

		addMarksBtn4.setBounds(180, 240, 120, 40);
		addMarksBtn4.setText("Add");
		addMarksBtn4.setFont(myFont3);
		addMarksBtn4.setBackground(new Color(95, 158, 160));
		addMarksBtn4.setFocusable(false);
		addMarksBtn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMarksBtn4.addActionListener(this);

		detailsPanel.setBounds(0, 0, 690, 520);
		detailsPanel.setBackground(new Color(211, 211, 211));
		detailsPanel.setLayout(null);
		detailsPanel.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
		detailsPanel.add(detailsName);
		detailsPanel.add(detailsLastName);
		detailsPanel.add(detailsEmail);
		detailsPanel.add(detailsUserName);
		detailsPanel.add(nameField);
		detailsPanel.add(lastnameField);
		detailsPanel.add(emailField);
		detailsPanel.add(usernameField);
		detailsPanel.add(updateButton);

		detailsName.setBounds(30, 50, 160, 40);
		detailsName.setFont(myFont2);
		nameField.setBounds(190, 50, 300, 40);
		nameField.setFont(myFont2);
		nameField.setBackground(new Color(211, 211, 211));

		updateButton.setBounds(500, 50, 140, 40);
		updateButton.setFont(myFont2);
		updateButton.addActionListener(this);
		updateButton.setFocusable(false);
		updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateButton.setBackground(new Color(95, 158, 160));
		
		detailsLastName.setBounds(30, 150, 160, 40);
		detailsLastName.setFont(myFont2);
		lastnameField.setBounds(190, 150, 300, 40);
		lastnameField.setFont(myFont2);
		lastnameField.setBackground(new Color(211, 211, 211));

		detailsEmail.setBounds(30, 240, 100, 40);
		detailsEmail.setFont(myFont2);
		emailField.setBounds(190, 240, 300, 40);
		emailField.setFont(myFont2);
		emailField.setBackground(new Color(211, 211, 211));

		detailsUserName.setBounds(30, 340, 120, 40);
		detailsUserName.setFont(myFont2);
		usernameField.setBounds(190, 340, 300, 40);
		usernameField.setFont(myFont2);
		usernameField.setBackground(new Color(211, 211, 211));
		usernameField.setEditable(false);

		frame.add(topPanel);
		frame.add(leftPanel);
		frame.add(contentPanel);

		frame.setTitle("Teacher's Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private void showDetailsPanel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (module1Panel != null) {
			contentPanel.remove(module1Panel);
		}
		if (module2Panel != null) {
			contentPanel.remove(module2Panel);
		}
		if (module3Panel != null) {
			contentPanel.remove(module3Panel);
		}
		if (module4Panel != null) {
			contentPanel.remove(module4Panel);
		}
		contentPanel.add(detailsPanel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	private void showModule1Panel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (module1Panel != null) {
			contentPanel.remove(module1Panel);
		}
		if (module2Panel != null) {
			contentPanel.remove(module2Panel);
		}
		if (module3Panel != null) {
			contentPanel.remove(module3Panel);
		}
		if (module4Panel != null) {
			contentPanel.remove(module4Panel);
		}
		contentPanel.add(module1Panel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	private void showModule2Panel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (module1Panel != null) {
			contentPanel.remove(module1Panel);
		}
		if (module2Panel != null) {
			contentPanel.remove(module2Panel);
		}
		if (module3Panel != null) {
			contentPanel.remove(module3Panel);
		}
		if (module4Panel != null) {
			contentPanel.remove(module4Panel);
		}
		contentPanel.add(module2Panel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	private void showModule3Panel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (module1Panel != null) {
			contentPanel.remove(module1Panel);
		}
		if (module2Panel != null) {
			contentPanel.remove(module2Panel);
		}
		if (module3Panel != null) {
			contentPanel.remove(module3Panel);
		}
		if (module4Panel != null) {
			contentPanel.remove(module4Panel);
		}
		contentPanel.add(module3Panel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	private void showModule4Panel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (module1Panel != null) {
			contentPanel.remove(module1Panel);
		}
		if (module2Panel != null) {
			contentPanel.remove(module2Panel);
		}
		if (module3Panel != null) {
			contentPanel.remove(module3Panel);
		}
		if (module4Panel != null) {
			contentPanel.remove(module4Panel);
		}
		contentPanel.add(module4Panel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	{
		try {
			Conn conn = new Conn();
			String sql, sql2, sql3;
			ResultSet rs, rs2, rs3;

			sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			rs = conn.s.executeQuery(sql);

			if (rs.next()) {
				nameField.setText(rs.getString("first_name"));
				lastnameField.setText(rs.getString("last_name"));
				emailField.setText(rs.getString("Email"));
				usernameField.setText(rs.getString("username"));
				courseOnField.setText(rs.getString("Course"));
				teacherNameField.setText(rs.getString("first_name")+ " " + rs.getString("last_name"));
				sql2 = "Select * from course where ID='" + rs.getString("module1") + "'";
				rs2 = conn.s.executeQuery(sql2);
				if (rs2.next()) {
					module1Label.setText(rs2.getString("Name"));
					sql3 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs2.getString("level"), rs2.getString("semester"), rs2.getString("course_name"));
					rs3 = conn.s.executeQuery(sql3);
					while (rs3.next()) {
						String result = rs3.getString(1);
						modules1Studentcombo.addItem(result);
					}

				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Conn conn = new Conn();

			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql2 = "Select * from course where ID='" + rs.getString("module2") + "'";
				ResultSet rs2 = conn.s.executeQuery(sql2);
				if (rs2.next()) {
					module2Label.setText(rs2.getString("Name"));
					String sql3 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs2.getString("level"), rs2.getString("semester"), rs2.getString("course_name"));
					ResultSet rs3 = conn.s.executeQuery(sql3);
					while (rs3.next()) {
						String result = rs3.getString(1);
						modules2Studentcombo.addItem(result);
					}
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Conn conn = new Conn();

			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql2 = "Select * from course where ID='" + rs.getString("module3") + "'";
				ResultSet rs2 = conn.s.executeQuery(sql2);
				if (rs2.next()) {
					module3Label.setText(rs2.getString("Name"));
					String sql3 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs2.getString("level"), rs2.getString("semester"), rs2.getString("course_name"));
					ResultSet rs3 = conn.s.executeQuery(sql3);
					while (rs3.next()) {
						String result = rs3.getString(1);
						modules3Studentcombo.addItem(result);

					}
				}			
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			Conn conn = new Conn();

			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql2 = "Select * from course where ID='" + rs.getString("module4") + "'";
				ResultSet rs2 = conn.s.executeQuery(sql2);
				if (rs2.next()) {
					module4Label.setText(rs2.getString("Name"));
					String sql3 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs2.getString("level"), rs2.getString("semester") , rs2.getString("course_name"));
					ResultSet rs3 = conn.s.executeQuery(sql3);
					while (rs3.next()) {
						String result = rs3.getString(1);
						modules4Studentcombo.addItem(result);
					}
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	{
		try {
			Conn conn = new Conn();
			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);

			if (rs.next()) {
				String sql4 = "Select * from level6 where ID='" + rs.getString("module1") + "'";
				ResultSet rs4 = conn.s.executeQuery(sql4);
				if (rs4.next()) {
					module1Label.setText(rs4.getString("Name"));
					String sql5 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs4.getString("level"), rs4.getString("semester"), rs4.getString("course_name"));
					ResultSet rs5 = conn.s.executeQuery(sql5);
					while (rs5.next()) {
						String result = rs5.getString(1);
						modules1Studentcombo.addItem(result);
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Conn conn = new Conn();
			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql4 = "Select * from level6 where ID='" + rs.getString("module2") + "'";
				ResultSet rs4 = conn.s.executeQuery(sql4);
				if (rs4.next()) {
					module2Label.setText(rs4.getString("Name"));
					String sql5 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs4.getString("level"), rs4.getString("semester") , rs4.getString("course_name"));
					ResultSet rs5 = conn.s.executeQuery(sql5);
					while (rs5.next()) {
						String result = rs5.getString(1);
						modules2Studentcombo.addItem(result);
					}
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Conn conn = new Conn();
			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql4 = "Select * from level6 where ID='" + rs.getString("module3") + "'";
				ResultSet rs4 = conn.s.executeQuery(sql4);
				if (rs4.next()) {
					module3Label.setText(rs4.getString("Name"));
					String sql5 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs4.getString("level"), rs4.getString("semester") , rs4.getString("course_name"));
					ResultSet rs5 = conn.s.executeQuery(sql5);
					while (rs5.next()) {
						String result = rs5.getString(1);
						modules3Studentcombo.addItem(result);
					}
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Conn conn = new Conn();
			String sql = "Select * from instructor where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql4 = "Select * from level6 where ID='" + rs.getString("module4") + "'";
				ResultSet rs4 = conn.s.executeQuery(sql4);
				if (rs4.next()) {
					module4Label.setText(rs4.getString("Name"));
					String sql5 = String.format("Select username from student where level ='%s' AND semester ='%s' AND course = '%s'",
							rs4.getString("level"), rs4.getString("semester"), rs4.getString("course_name"));
					ResultSet rs5 = conn.s.executeQuery(sql5);
					while (rs5.next()) {
						String result = rs5.getString(1);
						modules4Studentcombo.addItem(result);
					}
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == logoutBtn) {
				frame.dispose();
				Login log = new Login();
			} else if (e.getSource() == detailsBtn) {
				showDetailsPanel();
			}
			if (e.getSource() == module1) {
				showModule1Panel();
			}
			if (e.getSource() == module2) {
				showModule2Panel();
			}
			if (e.getSource() == module3) {
				showModule3Panel();
			}
			if (e.getSource() == module4) {
				showModule4Panel();
			}
		} catch (Exception er) {
			er.printStackTrace();
		}
		if(e.getSource() == updateButton) {
			try {
				Conn conn = new Conn();
				if (emailField.getText().indexOf("@") == -1 || emailField.getText().indexOf(".com") == -1) {
					JOptionPane.showMessageDialog(null, "Invalid email. Please try again.");
				}else {
					String sql = String.format("Update instructor SET first_name = '%s', last_name ='%s', Email = '%s' where username = '%s'", nameField.getText()
							,lastnameField.getText(), emailField.getText(), Login.getUserIDField());
					conn.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Details Updated");
				}	
			} catch (Exception er) {
				er.printStackTrace();
			}
		}
		
		if (e.getSource() == addMarksBtn) {
			try {
				Conn conn = new Conn();
				String sql = "Select * from student where username ='" + modules1Studentcombo.getSelectedItem() + "'";
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					int marksInt = Integer.parseInt(marksTextField.getText());

					if (marksInt > 100) {
						JOptionPane.showMessageDialog(null, "Marks should not be greater than 100!");
					} else {

						if (rs.getString("module1").equals("TBD")) {
							if (marksInt >= 40) {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 ='PASSED' where username = '%s'",
										module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							} else {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 ='FAILED' where username = '%s'",
										module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							}

						} else if (rs.getString("module2").equals("TBD")) {
							if (!rs.getString("module1").equals(module1Label.getText())) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 ='PASSED' where username = '%s'",
											module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 ='FAILED' where username = '%s'",
											module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}

						} else if (rs.getString("module3").equals("TBD")) {
							if ((!rs.getString("module1").equals(module1Label.getText()))
									&& (!rs.getString("module2").equals(module1Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 = 'PASSED' where username = '%s'",
											module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 = 'FAILED' where username = '%s'",
											module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module4").equals("TBD")) {
							if ((!rs.getString("module1").equals(module1Label.getText()))
									&& (!rs.getString("module2").equals(module1Label.getText()))
									&& (!rs.getString("module3").equals(module1Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 = 'PASSED' where username = '%s'",
											module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 = 'FAILED' where username = '%s'",
											module1Label.getText(), marksInt, modules1Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Marks already added");
						}

					}
				}
			} catch (

			Exception er) {
				er.printStackTrace();
			}
		}

		if (e.getSource() == addMarksBtn2) {
			try {
				Conn conn = new Conn();
				String sql = "Select * from student where username ='" + modules2Studentcombo.getSelectedItem() + "'";
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					int marksInt = Integer.parseInt(marksTextField2.getText());

					if (marksInt > 100) {
						JOptionPane.showMessageDialog(null, "Marks should not be greater than 100!");
					} else {

						if (rs.getString("module1").equals("TBD")) {
							if (marksInt >= 40) {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 ='PASSED' where username = '%s'",
										module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
										modules2Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							} else {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 ='FAILED' where username = '%s'",
										module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
										modules2Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							}

						} else if (rs.getString("module2").equals("TBD")) {
							if (!rs.getString("module1").equals(module2Label.getText())) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 ='PASSED' where username = '%s'",
											module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
											modules2Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 ='FAILED' where username = '%s'",
											module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
											modules2Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module3").equals("TBD")) {
							if ((!rs.getString("module1").equals(module2Label.getText()))
									&& (!rs.getString("module2").equals(module2Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 ='PASSED' where username = '%s'",
											module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
											modules2Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 ='FAILED' where username = '%s'",
											module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
											modules2Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module4").equals("TBD")) {
							if ((!rs.getString("module1").equals(module2Label.getText()))
									&& (!rs.getString("module2").equals(module2Label.getText()))
									&& (!rs.getString("module3").equals(module2Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 ='PASSED' where username = '%s'",
											module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
											modules2Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 ='FAILED' where username = '%s'",
											module2Label.getText(), Integer.parseInt(marksTextField2.getText()),
											modules2Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Marks already added");
						}
					}

				}
			} catch (

			Exception er) {
				er.printStackTrace();
			}

		}
		if (e.getSource() == addMarksBtn3) {
			try {
				Conn conn = new Conn();
				String sql = "Select * from student where username ='" + modules3Studentcombo.getSelectedItem() + "'";
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					int marksInt = Integer.parseInt(marksTextField3.getText());

					if (marksInt > 100) {
						JOptionPane.showMessageDialog(null, "Marks should not be greater than 100!");
					} else {

						if (rs.getString("module1").equals("TBD")) {
							if (marksInt >= 40) {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 = 'PASSED' where username = '%s'",
										module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
										modules3Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							} else {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 = 'FAILED' where username = '%s'",
										module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
										modules3Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							}

						} else if (rs.getString("module2").equals("TBD")) {
							if (!rs.getString("module1").equals(module3Label.getText())) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 = 'PASSED' where username = '%s'",
											module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
											modules3Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 = 'FAILED' where username = '%s'",
											module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
											modules3Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module3").equals("TBD")) {
							if ((!rs.getString("module1").equals(module3Label.getText()))
									&& (!rs.getString("module2").equals(module3Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 = 'PASSED' where username = '%s'",
											module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
											modules3Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 = 'FAILED' where username = '%s'",
											module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
											modules3Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module4").equals("TBD")) {
							if ((!rs.getString("module1").equals(module3Label.getText()))
									&& (!rs.getString("module2").equals(module3Label.getText()))
									&& (!rs.getString("module3").equals(module3Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 = 'PASSED' where username = '%s'",
											module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
											modules3Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 = 'FAILED' where username = '%s'",
											module3Label.getText(), Integer.parseInt(marksTextField3.getText()),
											modules3Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Marks already added");
						}
					}

				}
			} catch (

			Exception er) {
				er.printStackTrace();
			}
		}
		if (e.getSource() == addMarksBtn4) {
			try {
				Conn conn = new Conn();
				String sql = "Select * from student where username ='" + modules4Studentcombo.getSelectedItem() + "'";
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					int marksInt = Integer.parseInt(marksTextField4.getText());

					if (marksInt > 100) {
						JOptionPane.showMessageDialog(null, "Marks should not be greater than 100!");
					} else {

						if (rs.getString("module1").equals("TBD")) {
							if (marksInt >= 40) {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 = 'PASSED' where username = '%s'",
										module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
										modules4Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							} else {
								String sql2 = String.format(
										"UPDATE student SET module1 = '%s', marks1 = '%s', remarks1 = 'FAILED' where username = '%s'",
										module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
										modules4Studentcombo.getSelectedItem());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Marks Added");
							}

						} else if (rs.getString("module2").equals("TBD")) {
							if (!rs.getString("module1").equals(module4Label.getText())) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 = 'PASSED' where username = '%s'",
											module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
											modules4Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module2 = '%s', marks2 = '%s', remarks2 = 'FAILED' where username = '%s'",
											module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
											modules4Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module3").equals("TBD")) {
							if ((!rs.getString("module1").equals(module4Label.getText()))
									&& (!rs.getString("module2").equals(module4Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 = 'PASSED' where username = '%s'",
											module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
											modules4Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module3 = '%s', marks3 = '%s', remarks3 = 'FAILED' where username = '%s'",
											module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
											modules4Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Marks already added");
							}
						} else if (rs.getString("module4").equals("TBD")) {
							if ((!rs.getString("module1").equals(module4Label.getText()))
									&& (!rs.getString("module2").equals(module4Label.getText()))
									&& (!rs.getString("module3").equals(module4Label.getText()))) {
								if (marksInt >= 40) {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 = 'PASSED' where username = '%s'",
											module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
											modules4Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								} else {
									String sql2 = String.format(
											"UPDATE student SET module4 = '%s', marks4 = '%s', remarks4 = 'FAILED' where username = '%s'",
											module4Label.getText(), Integer.parseInt(marksTextField4.getText()),
											modules4Studentcombo.getSelectedItem());
									conn.s.executeUpdate(sql2);
									JOptionPane.showMessageDialog(null, "Marks Added");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Marks already added");
						}
					}

				}
			} catch (

			Exception er) {
				er.printStackTrace();
			}
		}

	}
}
