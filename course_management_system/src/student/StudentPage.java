package student;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conn.Conn;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import GUI.Login;
import GUI.Register;

public class StudentPage implements ActionListener {

	JFrame frame = new JFrame();
	Font myFont = new Font("Abadi", Font.PLAIN, 16);
	Font myFont2 = new Font("Abadi", Font.PLAIN, 20);

	JButton logoutBtn = new JButton();
	JButton detailsBtn = new JButton();
	JPanel panel = new JPanel();

	JPanel contentPanel = new JPanel();
	JPanel homePanel = new JPanel();

	JLabel studentName = new JLabel("Name: ");
	JLabel studentNameField = new JLabel();

	JLabel courseOnField = new JLabel();
	JLabel courseOnLabel = new JLabel("Course: ");
	JLabel studentLevel = new JLabel("Level: ");
	JLabel studentLevelField = new JLabel();

	JLabel modulesEnrolled = new JLabel("Modules enrolled: ");

	JLabel moduleTeacher = new JLabel("Instructor: ");
	JLabel moduleTeacherField = new JLabel();

	JLabel semesterOn = new JLabel("Semester: ");
	JLabel semesterOnField = new JLabel();

	JLabel moduleCode = new JLabel("Module Code: ");
	JLabel moduleCodeField = new JLabel();

	JComboBox<String> modulesEnrolledField = new JComboBox<String>();

	JTextArea refreshModule = new JTextArea();

	JLabel resultLabel = new JLabel("Marks Obtained");
	JLabel marksObtained = new JLabel();
	JLabel passOrFail = new JLabel();

	JPanel detailsPanel = new JPanel();
	JLabel detailsName = new JLabel("First Name:");
	JLabel detailsEmail = new JLabel("Email:");
	JLabel detailsLastName = new JLabel("Last name:");
	JLabel detailsUserName = new JLabel("Username: ");
	JTextField nameField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField lastnameField = new JTextField();
	JTextField usernameField = new JTextField();
	JButton backBtn = new JButton();
	JButton updateBtn = new JButton();
	JLabel optionalLabel = new JLabel("Optional Module:");
	JLabel forlvl6 = new JLabel("(For lvl 6 only)");
	JButton selectmd = new JButton();

	JComboBox<String> optModule = new JComboBox<String>();

	private static String[] name = {};

	public StudentPage() {

		detailsBtn.setBounds(630, 25, 100, 35);
		detailsBtn.setText("Details");
		detailsBtn.setFont(myFont2);
		detailsBtn.setFocusable(false);
		detailsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		detailsBtn.setBackground(new Color(169, 169, 169));
		detailsBtn.addActionListener(this);

		logoutBtn.setBounds(760, 25, 100, 35);
		logoutBtn.setFont(myFont2);
		logoutBtn.addActionListener(this);
		logoutBtn.setText("Logout");
		logoutBtn.setFocusable(false);
		logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutBtn.setBackground(new Color(169, 169, 169));

		studentName.setBounds(20, 20, 80, 50);
		studentName.setFont(myFont2);

		studentNameField.setBounds(110, 20, 380, 50);
		studentNameField.setFont(myFont2);

		courseOnLabel.setBounds(450, 20, 80, 50);
		courseOnLabel.setFont(myFont2);

		courseOnField.setBounds(540, 20, 80, 50);
		courseOnField.setFont(myFont2);

		panel.setBounds(0, 0, 1200, 80);
		panel.add(studentName);
		panel.add(studentNameField);
		panel.add(courseOnField);
		panel.add(courseOnLabel);
		panel.add(logoutBtn);
		panel.add(detailsBtn);
		panel.setOpaque(true);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
		panel.setBackground(new Color(95, 158, 160));

		panel.setLayout(null);

		modulesEnrolled.setBounds(20, 20, 200, 50);
		modulesEnrolled.setFont(myFont2);

		modulesEnrolledField.setBounds(240, 20, 420, 50);
		modulesEnrolledField.setFont(myFont);
		modulesEnrolledField.setEditable(false);
		modulesEnrolledField.addActionListener(this);

		refreshModule.setBounds(670, 20, 200, 50);
		refreshModule.setFont(new Font("Abadi", Font.PLAIN, 13));
		refreshModule.setForeground(Color.red);
		refreshModule.setText("(Please login again to see \n the new enrolled module)");
		refreshModule.setEditable(false);
		refreshModule.setBackground((new Color(192, 192, 192)));

		semesterOn.setBounds(20, 120, 100, 50);
		semesterOn.setFont(myFont2);

		semesterOnField.setBounds(140, 120, 100, 50);
		semesterOnField.setFont(myFont2);

		studentLevel.setBounds(340, 120, 100, 50);
		studentLevel.setFont(myFont2);

		studentLevelField.setBounds(460, 120, 100, 50);
		studentLevelField.setFont(myFont2);

		moduleCode.setBounds(20, 200, 150, 50);
		moduleCode.setFont(myFont2);

		moduleCodeField.setBounds(170, 200, 150, 50);
		moduleCodeField.setFont(myFont2);

		moduleTeacher.setBounds(340, 200, 100, 60);
		moduleTeacher.setFont(myFont2);

		moduleTeacherField.setBounds(460, 200, 265, 60);
		moduleTeacherField.setFont(myFont2);

		resultLabel.setBounds(20, 300, 150, 60);
		resultLabel.setFont(myFont2);

		marksObtained.setBounds(240, 300, 100, 60);
		marksObtained.setFont(myFont2);

		passOrFail.setBounds(400, 300, 100, 60);
		passOrFail.setFont(myFont2);


		contentPanel.setBounds(0, 80, 1200, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.add(homePanel);

		homePanel.setBounds(0, 0, 1200, 520);
		homePanel.setLayout(null);
		homePanel.setBackground(new Color(192, 192, 192));

		homePanel.add(studentLevel);
		homePanel.add(studentLevelField);
		homePanel.add(modulesEnrolled);
		homePanel.add(modulesEnrolledField);
		homePanel.add(semesterOn);
		homePanel.add(semesterOnField);
		homePanel.add(moduleCode);
		homePanel.add(moduleCodeField);
		homePanel.add(moduleTeacher);
		homePanel.add(moduleTeacherField);
		homePanel.add(refreshModule);
		homePanel.add(resultLabel);
		homePanel.add(marksObtained);
		homePanel.add(passOrFail);

		detailsPanel.setBounds(0, 0, 900, 520);
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
		detailsPanel.add(backBtn);
		detailsPanel.add(updateBtn);
		detailsPanel.add(optionalLabel);
		detailsPanel.add(forlvl6);
		detailsPanel.add(optModule);
		detailsPanel.add(selectmd);

		detailsName.setBounds(20, 20, 160, 40);
		detailsName.setFont(myFont2);
		nameField.setBounds(180, 20, 400, 40);
		nameField.setFont(myFont2);
		nameField.setBackground(new Color(211, 211, 211));

		detailsLastName.setBounds(20, 70, 160, 40);
		detailsLastName.setFont(myFont2);
		lastnameField.setBounds(180, 70, 400, 40);
		lastnameField.setFont(myFont2);
		lastnameField.setBackground(new Color(211, 211, 211));

		detailsEmail.setBounds(20, 150, 100, 40);
		detailsEmail.setFont(myFont2);
		emailField.setBounds(180, 150, 400, 40);
		emailField.setFont(myFont2);
		emailField.setBackground(new Color(211, 211, 211));

		detailsUserName.setBounds(20, 200, 120, 40);
		detailsUserName.setFont(myFont2);

		usernameField.setBounds(180, 200, 400, 40);
		usernameField.setFont(myFont2);
		usernameField.setBackground(new Color(211, 211, 211));
		usernameField.setEditable(false);

		optionalLabel.setBounds(20, 250, 160, 40);
		optionalLabel.setFont(myFont2);

		optModule.setBounds(180, 250, 420, 40);
		optModule.setFont(myFont);

		forlvl6.setBounds(20, 295, 120, 20);
		forlvl6.setFont(myFont);

		backBtn.setBounds(760, 20, 100, 40);
		backBtn.setText("Back");
		backBtn.setFont(myFont2);
		backBtn.setFocusable(false);
		backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backBtn.setBackground(new Color(169, 169, 169));
		backBtn.addActionListener(this);

		updateBtn.setBounds(630, 20, 100, 40);
		updateBtn.setText("Update");
		updateBtn.setFont(myFont2);
		updateBtn.setFocusable(false);
		updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateBtn.setBackground(new Color(169, 169, 169));
		updateBtn.addActionListener(this);

		selectmd.setBounds(700, 250, 100, 40);
		selectmd.addActionListener(this);
		selectmd.setText("Enroll");
		selectmd.setFont(myFont2);
		selectmd.setFocusable(false);
		selectmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectmd.setBackground(new Color(169, 169, 169));

		frame.add(panel);
		frame.add(contentPanel);

		frame.setTitle("Student's Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}


	{
		try {
			Conn conn = new Conn();
			String sql, sql2, sql_course;

			ResultSet rs, rs2, rs_course;

			sql = "Select * from student where username='" + Login.getUserIDField() + "'";
			rs = conn.s.executeQuery(sql);

			if (rs.next()) {

				frame.dispose();
				studentNameField.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
				studentLevelField.setText(rs.getString("level"));
				semesterOnField.setText(rs.getString("semester"));
				nameField.setText(rs.getString("first_name"));
				lastnameField.setText(rs.getString("last_name"));
				emailField.setText(rs.getString("Email"));
				usernameField.setText(rs.getString("username"));
				courseOnField.setText(rs.getString("course"));
			}

			String sql7 = "Select * from student where username = '" + Login.getUserIDField() + "'";
			ResultSet rs7 = conn.s.executeQuery(sql7);
			if (rs7.next()) {
				if (!rs7.getString("optmodule1").equals("TBD")) {
					modulesEnrolledField.addItem(rs7.getString("optmodule1"));
				}
				if (!rs7.getString("optmodule2").equals("TBD")) {
					modulesEnrolledField.addItem(rs7.getString("optmodule2"));
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	{
		try {
			Conn conn = new Conn();
			String sql = "Select * from student where username='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql2 = String.format(
						"Select Name from course where level = '%s' AND semester = '%s' AND course_name = '%s'",
						rs.getInt("level"), rs.getString("semester"), rs.getString("course"));
				ResultSet rs2 = conn.s.executeQuery(sql2);
				while (rs2.next()) {
					String result = rs2.getString(1);
					modulesEnrolledField.addItem(result);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	{
		try {

			Conn conn = new Conn();

			String sql = "Select * from student where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql_op = String.format(
						"Select  Name from level6 where level = '%s' AND course_name = '%s' AND semester = '%s'",
						rs.getInt("level"), rs.getString("course"),  rs.getString("semester"));
				ResultSet rs_op = conn.s.executeQuery(sql_op);

				while (rs_op.next()) {
					String result = rs_op.getString(1);
					modulesEnrolledField.addItem(result);
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	{
		try {
			Conn conn = new Conn();

			String sql = "Select * from student where username ='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql_op = String.format(
						"Select Name from level6 where level = '%s' AND course_name = '%s' AND Optional = '%s' AND semester = '%s'",
						rs.getInt("level"), rs.getString("course"), "Yes", rs.getString("semester"));
				ResultSet rs_op = conn.s.executeQuery(sql_op);
				while (rs_op.next()) {
					String result = rs_op.getString(1);
					optModule.addItem(result);
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	{
		try {
			Conn conn = new Conn();
			String sql = "Select * from student where username='" + Login.getUserIDField() + "'";
			ResultSet rs = conn.s.executeQuery(sql);
			if (rs.next()) {
				String sql_course2 = String.format("Select * from course where level = '%s' AND course_name = '%s'",
						rs.getInt("level"), rs.getString("course"));
				ResultSet rs_course2 = conn.s.executeQuery(sql_course2);
				if (rs_course2.next()) {
					moduleCodeField.setText(rs_course2.getString("ID"));
					String sql_teacher = String.format(
							"SELECT * FROM instructor WHERE module1 = '%s' OR module2 ='%s' OR module3= '%s' OR module4 = '%s'",
							rs_course2.getString("ID"), rs_course2.getString("ID"), rs_course2.getString("ID"),
							rs_course2.getString("ID"));
					ResultSet rs_teacher = conn.s.executeQuery(sql_teacher);
					if (rs_teacher.next()) {
						moduleTeacherField
								.setText(rs_teacher.getString("first_name") + " " + rs_teacher.getString("last_name"));
					} else {
						moduleTeacherField.setText("");
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
			String moduleMarks_sql = "Select * from student where username = '" + Login.getUserIDField() + "'";
			ResultSet rs_Marks = conn.s.executeQuery(moduleMarks_sql);
			if (rs_Marks.next()) {
				if (rs_Marks.getString("module1").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks1"));
					passOrFail.setText(rs_Marks.getString("remarks1"));
				} else if (rs_Marks.getString("module2").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks2"));
					passOrFail.setText(rs_Marks.getString("remarks2"));
				} else if (rs_Marks.getString("module3").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks3"));
					passOrFail.setText(rs_Marks.getString("remarks3"));
				} else if (rs_Marks.getString("module4").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks4"));
					passOrFail.setText(rs_Marks.getString("remarks4"));
				} else {
					marksObtained.setText("");
					passOrFail.setText("");
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void showDetailsPanel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (homePanel != null) {
			contentPanel.remove(homePanel);
		}
		contentPanel.add(detailsPanel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	private void showHomePanel() throws SQLException {
		if (detailsPanel != null) {
			contentPanel.remove(detailsPanel);
		}
		if (homePanel != null) {
			contentPanel.remove(homePanel);
		}
		contentPanel.add(homePanel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Conn conn = new Conn();
		ResultSet rs3, rs_teacher, rs_Marks;
		String semester_sql, sql_teacher, moduleMarks_sql;
		try {
			semester_sql = "Select * from course where Name='" + modulesEnrolledField.getSelectedItem() + "'";
			rs3 = conn.s.executeQuery(semester_sql);
			if (rs3.next()) {
				moduleCodeField.setText(rs3.getString("ID"));
				semesterOnField.setText(rs3.getString("semester"));
				sql_teacher = String.format(
						"SELECT * FROM instructor WHERE module1 = '%s' OR module2 ='%s' OR module3= '%s' OR module4 = '%s'",
						rs3.getString("ID"), rs3.getString("ID"), rs3.getString("ID"), rs3.getString("ID"));
				rs_teacher = conn.s.executeQuery(sql_teacher);
				if (rs_teacher.next()) {
					moduleTeacherField
							.setText(rs_teacher.getString("first_name") + " " + rs_teacher.getString("last_name"));
				} else {
					moduleTeacherField.setText("");
				}

			}
			semester_sql = "Select * from level6 where Name='" + modulesEnrolledField.getSelectedItem() + "'";
			rs3 = conn.s.executeQuery(semester_sql);
			if (rs3.next()) {
				moduleCodeField.setText(rs3.getString("ID"));
				semesterOnField.setText(rs3.getString("semester"));
				sql_teacher = String.format(
						"SELECT * FROM instructor WHERE module1 = '%s' OR module2 ='%s' OR module3= '%s' OR module4 = '%s'",
						rs3.getString("ID"), rs3.getString("ID"), rs3.getString("ID"), rs3.getString("ID"));
				rs_teacher = conn.s.executeQuery(sql_teacher);
				if (rs_teacher.next()) {
					moduleTeacherField
							.setText(rs_teacher.getString("first_name") + " " + rs_teacher.getString("last_name"));
				} else {
					moduleTeacherField.setText("");
				}
			}
			moduleMarks_sql = "Select * from student where username = '" + Login.getUserIDField() + "'";
			rs_Marks = conn.s.executeQuery(moduleMarks_sql);
			if (rs_Marks.next()) {
				if (rs_Marks.getString("module1").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks1"));
					passOrFail.setText(rs_Marks.getString("remarks1"));
				} else if (rs_Marks.getString("module2").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks2"));
					passOrFail.setText(rs_Marks.getString("remarks2"));
				} else if (rs_Marks.getString("module3").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks3"));
					passOrFail.setText(rs_Marks.getString("remarks3"));
				} else if (rs_Marks.getString("module4").equals(modulesEnrolledField.getSelectedItem())) {
					marksObtained.setText(rs_Marks.getString("marks4"));
					passOrFail.setText(rs_Marks.getString("remarks4"));
				} else {
					marksObtained.setText("");
					passOrFail.setText("");
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			if (e.getSource() == detailsBtn) {
				showDetailsPanel();
			}
			if (e.getSource() == logoutBtn) {
				frame.dispose();
				Login log = new Login();
			}
			if (e.getSource() == backBtn) {
				showHomePanel();
			}
			if (e.getSource() == updateBtn) {
				try {
					if (emailField.getText().indexOf("@") == -1 || emailField.getText().indexOf(".com") == -1) {
						JOptionPane.showMessageDialog(null, "Invalid email. Please try again.");
					} else {
						String sql = String.format(
								"Update student SET first_name = '%s', last_name ='%s', Email = '%s' where username = '%s'",
								nameField.getText(), lastnameField.getText(), emailField.getText(),
								Login.getUserIDField());
						conn.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Details Updated");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			if (e.getSource() == selectmd) {
				String sql = "Select * from student where username = '" + Login.getUserIDField() + "'";
				ResultSet rs = conn.s.executeQuery(sql);
				if (rs.next()) {
					if (rs.getInt("level") == 6) {
						if (rs.getString("optmodule1").equals("TBD")) {
							String sql2 = String.format("UPDATE student SET optmodule1 = '%s' where username = '%s'",
									optModule.getSelectedItem(), Login.getUserIDField());
							conn.s.executeUpdate(sql2);
							JOptionPane.showMessageDialog(null, "Registered Successfully.");
						} else if (rs.getString("optmodule2").equals("TBD")) {
							if (!optModule.getSelectedItem().equals(rs.getString("optmodule1"))) {
								String sql2 = String.format(
										"UPDATE student SET optmodule2 = '%s' where username = '%s'",
										optModule.getSelectedItem(), Login.getUserIDField());
								conn.s.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Registered Successfully.");
							} else {
								JOptionPane.showMessageDialog(null, "Module already registered.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "All optional modules are selected.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No option.");
					}
				}

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
