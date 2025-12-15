package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sceen_SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private JTextField txtaddress;
	private JTextField txtphone;
	private JTextField txtbirth;
	private JTextField txtname_admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sceen_SignIn frame = new Sceen_SignIn();
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
	public Sceen_SignIn() {
		setTitle("Đăng ký");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(610, 565);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 76, 118, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(20, 114, 118, 33);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnlogin = new JButton("Đăng ký");
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnlogin.setBounds(72, 439, 132, 48);
		getContentPane().add(btnlogin);
		
		txtemail = new JTextField();
		txtemail.setBounds(185, 81, 371, 27);
		getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(185, 119, 371, 27);
		getContentPane().add(txtpassword);
		
		JButton btnreset = new JButton("Nhập lại");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnreset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnreset.setBounds(380, 439, 142, 48);
		getContentPane().add(btnreset);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên NV");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(20, 211, 118, 33);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox CBrole = new JComboBox();
		CBrole.setBounds(466, 157, 90, 27);
		getContentPane().add(CBrole);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(20, 240, 118, 33);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(20, 322, 142, 33);
		getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(20, 284, 118, 33);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1.setBounds(20, 360, 142, 33);
		getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		JRadioButton rdonam = new JRadioButton("Nam");
		rdonam.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rdonam.setBounds(232, 250, 109, 23);
		getContentPane().add(rdonam);
		
		JRadioButton rdonu = new JRadioButton("Nữ");
		rdonu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rdonu.setBounds(403, 250, 109, 23);
		getContentPane().add(rdonu);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(185, 368, 371, 27);
		getContentPane().add(txtaddress);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(185, 330, 371, 27);
		getContentPane().add(txtphone);
		
		txtbirth = new JTextField();
		txtbirth.setColumns(10);
		txtbirth.setBounds(185, 292, 371, 27);
		getContentPane().add(txtbirth);
		
		txtname_admin = new JTextField();
		txtname_admin.setColumns(10);
		txtname_admin.setBounds(185, 219, 371, 27);
		getContentPane().add(txtname_admin);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(20, 11, 564, 54);
		getContentPane().add(lblNewLabel);

	}
}
