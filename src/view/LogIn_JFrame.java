package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LogIn_JFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtemail;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn_JFrame frame = new LogIn_JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn_JFrame() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(389, 240);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 353, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmail.setBounds(30, 61, 85, 25);
		getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(30, 97, 85, 28);
		getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(40, 152, 115, 34);
		getContentPane().add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng ký");
		btnngK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnngK.setBounds(218, 152, 115, 34);
		getContentPane().add(btnngK);
		
		JLabel lblToTiKhon = new JLabel("Tạo tài khoản?");
		lblToTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTiKhon.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblToTiKhon.setBounds(218, 136, 100, 14);
		getContentPane().add(lblToTiKhon);
		
		txtemail = new JTextField();
		txtemail.setBounds(140, 64, 193, 23);
		getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 102, 193, 23);
		getContentPane().add(passwordField);
		
	}

}
