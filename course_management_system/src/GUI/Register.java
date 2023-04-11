package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import conn.Conn;

public class Register implements ActionListener {

	JFrame frame = new JFrame();
	Font myFont = new Font("Abadi", Font.PLAIN, 16);

	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JTextField userNameField = new JTextField();
	JTextField emailField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JRadioButton oneButton = new JRadioButton("4");
	JRadioButton twoButton = new JRadioButton("5");
	JRadioButton threeButton = new JRadioButton("6");
	ButtonGroup group = new ButtonGroup();
	JTextField semesterField = new JTextField();

	JLabel title = new JLabel("Student Registration Form");
	JLabel firstNameLabel = new JLabel("First name:");
	JLabel lastNameLabel = new JLabel("Last name:");
	JLabel userNameLabel = new JLabel("Username:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
	JLabel levelLabel = new JLabel("Level: ");
	JLabel semesterLabel = new JLabel("Semester :");
	JLabel courseLabel = new JLabel("Course: ");

	final String[] list = { "1", "2" };
	JComboBox<String> combo = new JComboBox<String>(list);

//	final String[] list2 = { "BIT", "BBA" };
	JComboBox<String> combo2 = new JComboBox<String>();

	JButton backBtn = new JButton();
	JButton registerBtn = new JButton();

	Register() {
		title.setBounds(165, 10, 250, 40);
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

		levelLabel.setBounds(50, 435, 225, 30);
		levelLabel.setFont(myFont);
		levelLabel.setForeground(Color.white);

		group.add(oneButton);
		group.add(twoButton);
		group.add(threeButton);

		oneButton.setBounds(190, 435, 50, 40);
		oneButton.setBackground(new Color(40, 66, 98));
		oneButton.setForeground(Color.white);
		oneButton.setFocusable(false);
		oneButton.setActionCommand("4");

		twoButton.setBounds(260, 435, 50, 40);
		twoButton.setBackground(new Color(40, 66, 98));
		twoButton.setForeground(Color.white);
		twoButton.setFocusable(false);
		twoButton.setActionCommand("5");

		threeButton.setBounds(330, 435, 50, 40);
		threeButton.setBackground(new Color(40, 66, 98));
		threeButton.setForeground(Color.white);
		threeButton.setFocusable(false);
		threeButton.setActionCommand("6");

		semesterLabel.setBounds(50, 495, 225, 30);
		semesterLabel.setFont(myFont);
		semesterLabel.setForeground(Color.white);

		courseLabel.setBounds(50, 555, 225, 30);
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

		combo.setBounds(190, 495, 285, 35);
		combo.setFont(myFont);

		combo2.setBounds(190, 555, 285, 35);
		combo2.setFont(myFont);

		frame.getContentPane().setBackground(new Color(40, 66, 98));
		frame.add(title);
		frame.add(firstNameLabel);
		frame.add(firstNameField);
		frame.add(lastNameLabel);
		frame.add(lastNameField);
		frame.add(userNameLabel);
		frame.add(userNameField);
		frame.add(combo2);
		frame.add(emailLabel);
		frame.add(userPasswordLabel);
		frame.add(emailField);
		frame.add(userPasswordField);
		frame.add(confirmPasswordLabel);
		frame.add(confirmPasswordField);
		frame.add(levelLabel);
		frame.add(oneButton);
		frame.add(twoButton);
		frame.add(threeButton);
		frame.add(semesterLabel);
		frame.add(combo);
		frame.add(courseLabel);
		frame.add(backBtn);
		frame.add(registerBtn);

		backBtn.setBounds(160, 615, 130, 35);
		backBtn.setText("Back");
		backBtn.setFocusable(false);
		backBtn.setFont(myFont);
		backBtn.setBackground(new Color(162, 51, 42));
		backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backBtn.addActionListener(this);
		backBtn.setForeground(Color.white);

		registerBtn.setBounds(310, 615, 130, 35);
		registerBtn.setText("Register");
		registerBtn.setFocusable(false);
		registerBtn.setFont(myFont);
		registerBtn.setBackground(new Color(32, 53, 73));
		registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerBtn.setForeground(Color.white);
		registerBtn.addActionListener(this);

		frame.setTitle("Register");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(550, 720);
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
				combo2.addItem(result);
			}
		}catch (Exception er) {
			er.printStackTrace();
		}
	}
	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) {
			frame.dispose();
			Login log = new Login();
		}
		
		
		
		if (e.getSource() == registerBtn) {
			try {

				Conn conn = new Conn();

				String query = "SELECT * FROM student WHERE username = '" + userNameField.getText() + "'";
				ResultSet rs = conn.s.executeQuery(query);


				if ((firstNameField.getText().length() == 0) || (lastNameField.getText().length() == 0)
						|| (emailField.getText().length() == 0) || (userNameField.getText().length() == 0)
						|| (userPasswordField.getPassword().length == 0)
						|| (confirmPasswordField.getPassword().length == 0) || (group.getSelection() == null)) {
					JOptionPane.showMessageDialog(null, "None of the fields can be left empty!");
				} else if ((!Arrays.equals(userPasswordField.getPassword(), confirmPasswordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Password doesn't match.");
				} else if (userPasswordField.getPassword().length < 7) {
					JOptionPane.showMessageDialog(null, "The length of the password must be greater than 7!");
				} else if (emailField.getText().indexOf("@") == -1 || emailField.getText().indexOf(".com") == -1) {
					JOptionPane.showMessageDialog(null, "Invalid email. Please try again.");
				}
				else if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Username already exists.");
				}

				else {
					try {
						String sql = String.format("insert into student (username, first_name, last_name, Email, Password, level, semester, course, module1, marks1, remarks1, module2, marks2, remarks2, module3, marks3, remarks3, module4, marks4, remarks4, optmodule1, optmodule2) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD')", 
								userNameField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), String.valueOf(userPasswordField.getPassword()), 
								group.getSelection().getActionCommand(), combo.getSelectedItem(), combo2.getSelectedItem());

						conn.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Registered Successfully.");
						frame.dispose();
						Login log = new Login();	
				}
					catch(Exception er) {
						er.printStackTrace();
					}
					
				}
			}

			catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			

		}
	}
}
