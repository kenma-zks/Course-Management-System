package GUI;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import admin.Admin;
import conn.Conn;
import student.StudentPage;
import teacher.TeacherPage;

public class Login implements ActionListener {

	// JFrame is a GUI window to add components to
	JFrame frame = new JFrame(); // creates frame
	Font myFont = new Font("Abadi", Font.PLAIN, 16);

	private static JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel roleLabel = new JLabel("Role: ");

	// Dropdown
	final String[] list = { "Student", "Teacher", "Admin" };
	JComboBox<String> combo = new JComboBox<String>(list);

	JButton loginBtn = new JButton();
	JButton registerBtn = new JButton();

	public Login() {
		userIDLabel.setBounds(50, 60, 105, 30);
		userIDLabel.setFont(myFont);
		userIDLabel.setForeground(Color.white);

		userPasswordLabel.setBounds(50, 125, 130, 30);
		userPasswordLabel.setFont(myFont);
		userPasswordLabel.setForeground(Color.white);

		userIDField.setBounds(170, 55, 365, 35);
		userIDField.setFont(myFont);

		userPasswordField.setBounds(170, 125, 365, 35);
		userPasswordField.setFont(myFont);

		roleLabel.setBounds(50, 190, 105, 30);
		roleLabel.setFont(myFont);
		roleLabel.setForeground(Color.white);

		combo.setBounds(170, 190, 365, 35);
		combo.setFont(myFont);

		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(roleLabel);
		frame.add(combo);
		frame.add(loginBtn);
		frame.add(registerBtn);

		loginBtn.setBounds(170, 270, 130, 35);
		loginBtn.setText("Login");
		loginBtn.setFocusable(false);
		loginBtn.setFont(myFont);
		loginBtn.setBackground(Color.lightGray);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginBtn.addActionListener(this);
		loginBtn.setForeground(Color.white);
		loginBtn.setBackground(new Color(32, 53, 73));

		registerBtn.setBounds(350, 270, 130, 35);
		registerBtn.setText("Register");
		registerBtn.setFocusable(false);
		registerBtn.setFont(myFont);
		registerBtn.setBackground(Color.lightGray);
		registerBtn.addActionListener(this);
		registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerBtn.setForeground(Color.white);
		registerBtn.setBackground(new Color(32, 53, 73));

		frame.getContentPane().setBackground(new Color(40, 66, 98));
		frame.setTitle("Course Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(650, 420);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = getUserIDField();

		if (e.getSource() == registerBtn) {
			frame.dispose();
			Register reg = new Register();
		}

		if (e.getSource() == loginBtn) {

			if (text.isEmpty() == true && userPasswordField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "Username & password field cannot be empty.");
			} else if (text.isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Username cannot be empty.");
			} else if (userPasswordField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "Password field cannot be empty.");
			}

			try {

				String sql;
				ResultSet rs;
				switch (combo.getSelectedIndex()) {
				case 0:
					Conn conn = new Conn();
					sql = "Select * from student where username='" + getUserIDField() + "'and Password='"
							+ String.valueOf(userPasswordField.getPassword()) + "'";
					rs = conn.s.executeQuery(sql);
					if (rs.next()) {
						frame.dispose();
						StudentPage std = new StudentPage();
					} else {
						JOptionPane.showMessageDialog(null, "User doesn't exist.");
					}
					break;
				case 1:
					Conn conn2 = new Conn();
					sql = "Select * from instructor where username='" + getUserIDField() + "'and Password='"
							+ String.valueOf(userPasswordField.getPassword()) + "'";
					rs = conn2.s.executeQuery(sql);
					if (rs.next()) {
						frame.dispose();
						TeacherPage teacherpg = new TeacherPage();
					} else {
						JOptionPane.showMessageDialog(null, "User doesn't exist.");
					}
					break;
				case 2:
					if ((userIDField.getText().equals("admin"))
							&& (String.valueOf(userPasswordField.getPassword()).equals("admin"))) {
						frame.dispose();
						Admin admin = new Admin();
					} else {
						JOptionPane.showMessageDialog(null, "User doesn't exist.");
					}
					break;

				default:
					JOptionPane.showMessageDialog(null, "User doesn't exist.");
					break;
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

	public static String getUserIDField() {
		return userIDField.getText();
	}

}
