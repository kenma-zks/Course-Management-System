package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.ResultSet;

import admin.Admin;

import conn.Conn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;

public class RegisterTeacher implements ActionListener {

	JFrame frame = new JFrame();
	Font myFont = new Font("Abadi", Font.PLAIN, 16);

	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JTextField userNameField = new JTextField();
	JTextField emailField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();

	JLabel title = new JLabel("Teacher Registration Form");
	JLabel firstNameLabel = new JLabel("First name:");
	JLabel lastNameLabel = new JLabel("Last name:");
	JLabel userNameLabel = new JLabel("Username:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
	JLabel courseLabel = new JLabel("Course: ");

	JButton backBtn = new JButton();
	JButton registerBtn = new JButton();

	JComboBox<String> combo = new JComboBox<String>();

	public RegisterTeacher() {
		title.setBounds(155, 10, 300, 40);
		title.setFont(new Font("Abadi", Font.BOLD, 20));
		title.setForeground(Color.white);

		firstNameLabel.setBounds(50, 70, 115, 30);
		firstNameLabel.setFont(myFont);
		firstNameLabel.setForeground(Color.white);

		lastNameLabel.setBounds(50, 135, 130, 30);
		lastNameLabel.setFont(myFont);
		lastNameLabel.setForeground(Color.white);

		userNameLabel.setBounds(50, 195, 115, 30);
		userNameLabel.setFont(myFont);
		userNameLabel.setForeground(Color.white);

		emailLabel.setBounds(50, 255, 425, 30);
		emailLabel.setFont(myFont);
		emailLabel.setForeground(Color.white);

		userPasswordLabel.setBounds(50, 315, 425, 30);
		userPasswordLabel.setFont(myFont);
		userPasswordLabel.setForeground(Color.white);

		confirmPasswordLabel.setBounds(50, 375, 225, 30);
		confirmPasswordLabel.setFont(myFont);
		confirmPasswordLabel.setForeground(Color.white);

		courseLabel.setBounds(50, 435, 225, 30);
		courseLabel.setFont(myFont);
		courseLabel.setForeground(Color.white);

		firstNameField.setBounds(190, 70, 285, 35);
		firstNameField.setFont(myFont);

		lastNameField.setBounds(190, 135, 285, 35);
		lastNameField.setFont(myFont);

		userNameField.setBounds(190, 195, 285, 35);
		userNameField.setFont(myFont);

		emailField.setBounds(190, 255, 285, 35);
		emailField.setFont(myFont);

		userPasswordField.setBounds(190, 315, 285, 35);
		userPasswordField.setFont(myFont);

		confirmPasswordField.setBounds(190, 375, 285, 35);
		confirmPasswordField.setFont(myFont);

		combo.setBounds(190, 435, 285, 35);
		combo.setFont(myFont);

		backBtn.setBounds(140, 515, 130, 35);
		backBtn.setText("Back");
		backBtn.setFocusable(false);
		backBtn.setFont(myFont);
		backBtn.setBackground(new Color(162, 51, 42));
		backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backBtn.addActionListener(this);
		backBtn.setForeground(Color.white);

		registerBtn.setBounds(300, 515, 130, 35);
		registerBtn.setText("Register");
		registerBtn.setFocusable(false);
		registerBtn.setFont(myFont);
		registerBtn.setBackground(new Color(32, 53, 73));
		registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerBtn.setForeground(Color.white);
		registerBtn.addActionListener(this);

		frame.getContentPane().setBackground(new Color(40, 66, 98));
		frame.add(title);
		frame.add(firstNameLabel);
		frame.add(lastNameLabel);
		frame.add(userNameLabel);
		frame.add(emailLabel);
		frame.add(userPasswordLabel);
		frame.add(confirmPasswordLabel);
		frame.add(courseLabel);
		frame.add(firstNameField);
		frame.add(lastNameField);
		frame.add(emailField);
		frame.add(userNameField);
		frame.add(userPasswordField);
		frame.add(confirmPasswordField);
		frame.add(combo);
		frame.add(backBtn);
		frame.add(registerBtn);

		frame.setTitle("Register");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // exit out of application
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(550, 640);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}


	{
		try {
			String sql;
			ResultSet rs;
			Conn conn = new Conn();
			sql = "Select DISTINCT name from coursename";
			rs = conn.s.executeQuery(sql);
			while(rs.next()) {
				String result = rs.getString(1);
				combo.addItem(result);
			}
		}catch (Exception er) {
			er.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) {
			

			
			frame.dispose();
			Admin.frameCheck();
			
		
			
		}
		if (e.getSource() == registerBtn) {
			try {
				Conn conn = new Conn();
				
			
				String query = "SELECT * FROM instructor WHERE username = '" + userNameField.getText() + "'";
				ResultSet rs = conn.s.executeQuery(query);
				
				if ((firstNameField.getText().length() == 0 ) || (lastNameField.getText().length() == 0)|| (emailField.getText().length() == 0) || (userNameField.getText().length() == 0) || (userPasswordField.getPassword().length == 0) || (confirmPasswordField.getPassword().length == 0)) {
					JOptionPane.showMessageDialog(null, "None of the fields can be left empty!");
				}else if ((!Arrays.equals(userPasswordField.getPassword(), confirmPasswordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Password doesn't match.");
				}else if(userPasswordField.getPassword().length < 7) {
					JOptionPane.showMessageDialog(null, "The length of the password must be greater than 7!");
				}else if(emailField.getText().indexOf("@") == -1 || emailField.getText().indexOf(".com") == -1) {
					JOptionPane.showMessageDialog(null, "Invalid email. Please try again.");
				}else if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already exists.");
                }
				else {
					try {

						String sql = String.format("insert into instructor (username, first_name, last_name, Email, Password, Course, module1, module2, module3, module4) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', 'TBD', 'TBD', 'TBD', 'TBD')", userNameField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), String.valueOf(userPasswordField.getPassword()), combo.getSelectedItem());
						conn.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Registered Successfully.");
						frame.dispose();		
						Admin admin = new Admin();
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			
		}
	

}

	public void close() {
		frame.dispose();
		
	
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	}
