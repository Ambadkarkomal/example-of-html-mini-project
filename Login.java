package JavaProgram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 102, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setSize(1378, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeHvpmFarming = new JLabel("Welcome HVPM Farming Process Management System");
		lblWelcomeHvpmFarming.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblWelcomeHvpmFarming.setBounds(262, 41, 739, 41);
		frame.getContentPane().add(lblWelcomeHvpmFarming);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(356, 168, 165, 35);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(498, 168, 318, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(356, 214, 171, 25);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.addActionListener(new ActionListener() {
			private Object query;
			private String  name ;

			public void actionPerformed(ActionEvent e) {
				String password =passwordField.getText();
      			String username =textField.getText();
      			

      			
      			
      			try {
    				
      				
					Class.forName("com.mysql.jdbc.Driver");

					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/farmer","root","hvpm");
					 Statement stmt = con.createStatement();
					 String sql="SELECT username,confirm_password from registration_form  WHERE username ='"+username+"' && confirm_password ='"+password+"'";
					//String sql = "SeLECT * FROM registration_form WHERE username ='"+ username +"'";
					//String sqll = "SELECT * FROM registration_form Where confirm_password ='"+password+"'";
					ResultSet rs =stmt.executeQuery(sql);
					System.out.println(rs);
				//ResultSet rs1=stmt.executeQuery(sqll);
	      			//String username =textField.getText();
	      			if(rs.next()) {
	      				
	      				System.out.println("success");

	      				home hom = new home();
	      				home.main(null);
	      				
	      				
	      			}
	      			else {
	      				System.out.println("fail");
	      				JOptionPane.showMessageDialog(null, "Username and password is incorrect");
	      				textField.setText(null);
	      				passwordField.setText(null);
	      			}
	      			
      			}
					
			 catch(Exception e1)
		    {
			System.out.println("Error");	 
		    }
		    }
      			
      			
      			
      			}
			
      			
      		        
      			
      			
			
		);
		
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogIn.setForeground(Color.BLUE);
		btnLogIn.setBounds(508, 293, 96, 35);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBackground(new Color(192, 192, 192));
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
          			regstracion info = new regstracion();
          			regstracion.main(null); 
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 17));               
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setBounds(649, 293, 105, 35);
		frame.getContentPane().add(btnSignUp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(498, 214, 318, 31);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(128, 128, 128));
		label.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\project\\Grass-Sky-Wallpaper-16.jpg"));
		label.setBounds(0, -450, 1387, 1172);
		frame.getContentPane().add(label);
		
	}

}
