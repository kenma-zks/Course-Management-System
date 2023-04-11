package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	private final String url = "jdbc:mysql://localhost:3306/";
	private final String user = "root";
	private final String password = "";
	private final String DbName = "cms";
	
	
	public Connection c;
	public Statement s;

	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
//        establishing connection
			s = c.createStatement();
//        helps execute mySQL queries
		} catch (Exception e) {
			System.out.println("Failed to connect to the database");
		}
		try {

			String query = "CREATE DATABASE " + DbName;
			s.executeUpdate(query);

			System.out.println("Database has been created. Filling in dummy datas....");
			
			String useDbQuery = "USE " + DbName;
			s.executeUpdate(useDbQuery);
			createTables();
		} catch (SQLException e) {
			System.out.println("Database already exists!");
			String useDbQuery = "USE " + DbName;
			try {
				s.executeUpdate(useDbQuery);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}

	private void createTables() {
		course();
		coursename();
		instructor();
		level6();
		student();
	}

	private void course() {
		String query = "CREATE TABLE `course` (\r\n"
				+ "  `ID` varchar(20) NOT NULL,\r\n"
				+ "  `course_name` varchar(256) NOT NULL,\r\n"
				+ "  `Name` varchar(75) NOT NULL,\r\n"
				+ "  `level` int(20) NOT NULL,\r\n"
				+ "  `semester` varchar(20) NOT NULL,\r\n"
				+ "  `a_id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  UNIQUE KEY `a_id` (`a_id`)\r\n"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4\r\n"
				+ "";
		try {
			s.executeUpdate(query);
			insertIntoCourse();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void insertIntoCourse() {
		String query = "INSERT INTO `course` (`ID`, `course_name`, `Name`, `level`, `semester`, `a_id`) VALUES "
				+ "('4CI018', 'BIT', 'Academic Skills and Team Based Learning', '4', '1', NULL),"
				+ "('4CS015', 'BIT', 'Fundamentals of Computing ', '4', '1', NULL), "
				+ "('4CS016', 'BIT', 'Embedded System Programming ', '4', '2', NULL), "
				+ "('4CS017', 'BIT', 'Internet Software Architecture', '4', '2', NULL), "
				+ "('4MM013', 'BIT', 'Computational Mathematics', '4', '2', NULL), "
				+ "('5CS037', 'BIT', 'Concepts and Technologies of AI', '5', '1', NULL), "
				+ "('5CS019', 'BIT', 'Object-Oriented Design and Programming', '5', '1', NULL), "
				+ "('5CS021', 'BIT', 'Numerical Methods and Concurrency', '5', '1', NULL), "
				+ "('5CS022', 'BIT', 'Distributed and Cloud System Programming', '5', '2', NULL), "
				+ "('5CS024', 'BIT', 'Collaborative Development', '5', '2', NULL), "
				+ "('5CS020', 'BIT', 'Human Computer Interaction', '5', '2', NULL), "
				+ "('4CS012', 'BIT', 'Server Management and Virtualisation', '4', '2', NULL), "
				+ "('4CS020', 'BIT', 'Server development', '4', '1', NULL), "
				+ "('5CS038', 'BIT', 'Enterprise Network Systems', '5', '1', NULL), "
				+ "('5CS031', 'BIT', 'Network Security', '5', '2', NULL), "
				+ "('4CS001', 'BIT', 'Introductory Programming and Problem Solving', '4', '1', NULL), "
				+ "('4CC021', 'BBAA', 'Temporary', '4', '1', NULL), "
				+ "('4JJ0C9', 'BBAA', 'Project management', '4', '2', NULL), "
				+ "('5KKI9L', 'BBAA', 'Business', '5', '2', NULL)";
		try {
			s.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void coursename() {
		String query = "CREATE TABLE `coursename` (\r\n" + "  `name` varchar(50) NOT NULL,\r\n"
				+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" + "  PRIMARY KEY (`id`)\r\n"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4\r\n" + "";
		try {
			s.executeUpdate(query);
			insertIntocourseName();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void insertIntocourseName() {
		String query = "INSERT INTO `coursename` (`name`, `id`) VALUES " + "('BBAA', NULL), " + "('BIT', NULL)";
		try {
			s.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void instructor() {
		String query = "CREATE TABLE `instructor` (\r\n" + "  `ID` int(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `username` varchar(30) DEFAULT NULL,\r\n" + "  `first_name` varchar(50) NOT NULL,\r\n"
				+ "  `last_name` varchar(50) NOT NULL,\r\n" + "  `Email` varchar(75) NOT NULL,\r\n"
				+ "  `Password` varchar(50) NOT NULL,\r\n" + "  `Course` varchar(256) NOT NULL,\r\n"
				+ "  `module1` varchar(200) NOT NULL,\r\n" + "  `module2` varchar(200) NOT NULL,\r\n"
				+ "  `module3` varchar(200) NOT NULL,\r\n" + "  `module4` varchar(200) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`ID`),\r\n" + "  UNIQUE KEY `Email` (`Email`)\r\n"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4\r\n" + "";
		try {
			s.executeUpdate(query);
			insertIntoInstructor();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void insertIntoInstructor() {
		String query = "INSERT INTO `instructor` (`ID`, `username`, `first_name`, `last_name`, `Email`, `Password`, `Course`, `module1`, `module2`, `module3`, `module4`) VALUES "
				+ "(NULL, 'Aashish', 'Aashish', 'Tuladhar', 'aashish@gmail.com', 'aashish1', 'BIT', '6CS007', '5CS019', '5CS022', '5CS021'), "
				+ "(NULL, 'Ozone', 'Ozone', 'Bhat', 'ozone@gmail.com', 'bhatbhat1', 'BIT', '5CS038', '5CS037', '6CS029', '4CI018'), "
				+ "(NULL, 'Genjen', 'Phurpa', 'Lama', 'phurpa@gmail.com', 'phurpalama1', 'BBAA', '6K56K', '6K09L', '4JJ0C9', '5KKI9L'), "
				+ "(NULL, 'Hari', 'Hari', 'Maharjan', 'hari@gmail.com', 'harihari1', 'BIT', '4CS015', '4CS001', '4CS020', '4CS016')\r\n"
				+ "";
		try {
			s.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void level6() {
		String query = "CREATE TABLE `level6` (\r\n" + "  `ID` varchar(20) NOT NULL,\r\n"
				+ "  `course_name` varchar(256) NOT NULL,\r\n" + "  `Name` varchar(75) NOT NULL,\r\n"
				+ "  `semester` varchar(20) NOT NULL,\r\n" + "  `Optional` varchar(20) NOT NULL,\r\n"
				+ "  `level` int(11) NOT NULL,\r\n" + "  `a_id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  PRIMARY KEY (`a_id`)\r\n" + ") ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4\r\n" + "";
		try {
			s.executeUpdate(query);
			insertIntoLevel6();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void insertIntoLevel6() {
		String query = "INSERT INTO `level6` (`ID`, `course_name`, `Name`, `semester`, `Optional`, `level`, `a_id`) VALUES "
				+ "('6CS014', 'BIT', 'Complex System', '1', 'No', '6', NULL), "
				+ "('6CS005', 'BIT', 'High Performance Computing', '1', 'No', '6', NULL), "
				+ "('6CS007', 'BIT', 'Project and Professionalism', '1', 'Yes', '6', NULL), "
				+ "('6CS012', 'BIT', 'Artificial Intelligence and Machine Learning', '1', 'Yes', '6', NULL), "
				+ "('6CS030', 'BIT', 'Big Data', '2', 'Yes', '6', NULL), "
				+ "('6CS025', 'BIT', 'Advanced Games Technologies and Programming', '1', 'Yes', '6', NULL), "
				+ "('6CS028', 'BIT', 'Advanced Web Development', '2', 'No', '6', NULL),"
				+ " ('6CS027', 'BIT', 'Secure Mobile Application Development', '2', 'No', '6', NULL), "
				+ "('6CS013', 'BIT', 'Emerging Interactive Technologies', '2', 'Yes', '6', NULL),"
				+ " ('6CS029', 'BIT', 'Advanced Networks', '2', 'Yes', '6', NULL),"
				+ " ('498LO', 'BBAA', 'Digital work', '2', 'No', '6', NULL), "
				+ "('4LLI66', 'BBAA', 'Accounting', '1', 'No', '6', NULL), "
				+ "('6K09L', 'BBAA', 'Principles of business', '2', 'Yes', '6', NULL), "
				+ "('6K56K', 'BBAA', 'Working principle', '1', 'Yes', '6', NULL)\r\n" + "";
		try {
			s.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void student() {
		String query = "CREATE TABLE `student` (\r\n" + "  `ID` int(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `username` varchar(70) NOT NULL,\r\n" + "  `first_name` varchar(50) NOT NULL,\r\n"
				+ "  `last_name` varchar(50) NOT NULL,\r\n" + "  `Email` varchar(75) NOT NULL,\r\n"
				+ "  `Password` varchar(50) NOT NULL,\r\n" + "  `level` int(30) NOT NULL,\r\n"
				+ "  `semester` varchar(30) NOT NULL,\r\n" + "  `course` varchar(50) NOT NULL,\r\n"
				+ "  `module1` varchar(75) NOT NULL,\r\n" + "  `marks1` int(100) NOT NULL,\r\n"
				+ "  `remarks1` varchar(20) NOT NULL,\r\n" + "  `module2` varchar(75) NOT NULL,\r\n"
				+ "  `marks2` int(100) NOT NULL,\r\n" + "  `remarks2` varchar(20) NOT NULL,\r\n"
				+ "  `module3` varchar(75) NOT NULL,\r\n" + "  `marks3` int(100) NOT NULL,\r\n"
				+ "  `remarks3` varchar(20) NOT NULL,\r\n" + "  `module4` varchar(75) NOT NULL,\r\n"
				+ "  `marks4` int(100) NOT NULL,\r\n" + "  `remarks4` varchar(20) NOT NULL,\r\n"
				+ "  `optmodule1` varchar(75) NOT NULL,\r\n" + "  `optmodule2` varchar(75) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`ID`),\r\n" + "  UNIQUE KEY `Email` (`Email`)\r\n"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4\r\n" + "";
		try {
			s.executeUpdate(query);
			insertIntoStudent();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void insertIntoStudent() {
		String query = "INSERT INTO `student` (`ID`, `username`, `first_name`, `last_name`, `Email`, `Password`, `level`, `semester`, `course`, `module1`, `marks1`, `remarks1`, `module2`, `marks2`, `remarks2`, `module3`, `marks3`, `remarks3`, `module4`, `marks4`, `remarks4`, `optmodule1`, `optmodule2`) VALUES "
				+ "(NULL, 'Pallaw', 'Pallaw', 'Magar', 'pallaw@gmail.com', 'pallawmagar1', '5', '1', 'BIT', 'Object-Oriented Design and Programming', '89', 'PASSED', 'Numerical Methods and Concurrency', '73', 'PASSED', 'Enterprise Network Systems', '60', 'PASSED', 'Concepts and Technologies of AI', '70', 'PASSED', 'TBD', 'TBD'),"
				+ " (NULL, 'Sohit', 'Sohit', 'Shrestha', 'sohit@gmail.com', 'sohitsohit1', '4', '1', 'BIT', 'Academic Skills and Team Based Learning', '2', 'FAILED', 'Fundamentals of Computing ', '30', 'FAILED', 'Introductory Programming and Problem Solving', '39', 'FAILED', 'Server development', '45', 'PASSED', 'TBD', 'TBD'),"
				+ " (NULL, 'Dangol', 'Ayush', 'Dangol', 'dangol@gmail.com', 'dangoldangol1', '6', '1', 'BIT', 'Project and Professionalism', '30', 'FAILED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD'), "
				+ "(NULL, 'Sujen', 'Sujen', 'Shrestha', 'sujen@gmail.com', 'sujensujen1', '5', '2', 'BIT', 'Distributed and Cloud System Programming', '19', 'FAILED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD'),"
				+ "(NULL, 'Kuber', 'Kuber', 'Shakya', 'kuber@gmail.com', 'kuberkuber1', '6', '2', 'BIT', 'TBD', '0', 'TBD', 'Advanced Networks', '55', 'PASSED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD'), "
				+ "(NULL, 'Raku', 'Ricky', 'Rana', 'rickyrana@gmail.com', 'rickyricky1', '5', '2', 'BBAA', 'Business', '55', 'PASSED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD'), "
				+ "(NULL, 'Daen', 'Daen', 'Basnet', 'daen@gmail.com', 'daendaen1', '6', '2', 'BBAA', 'Principles of business', '66', 'PASSED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD'), "
				+ "(NULL, 'Rain', 'Shreeyog', 'Shrestha', 'rain@gmail.com', 'rainrain1', '6', '1', 'BBAA', 'Working principle', '70', 'PASSED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD'),"
				+ " (NULL, 'Ashim', 'Ashim', 'Maharjan', 'ashim@gmail.com', 'ashimashim1', '4', '2', 'BBAA', 'Project management', '9', 'FAILED', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', '0', 'TBD', 'TBD', 'TBD')\r\n"
				+ "";
		try {
			s.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
