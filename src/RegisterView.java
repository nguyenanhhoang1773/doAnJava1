
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public RegisterView() {
		this.init();
        this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
        panel.setBackground(new Color(231, 248, 247));
        panel.setBounds(0, 0, 571, 428);
        contentPane.add(panel);
        panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(256, 70, 230, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(256, 120, 230, 35);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(256, 170, 230, 35);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(256, 220, 230, 35);
		panel.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("Đăng Ký");
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD, 30));
		lblNewLabel.setBounds(198, 10, 154, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Và Tên");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(47, 120, 168, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(47, 170, 168, 35);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mật Khẩu");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(47, 270, 168, 35);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập Lại Mật Khẩu");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(47, 320, 168, 35);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Đăng Ký");
		btnNewButton.setForeground(new Color(246, 245, 244));
		btnNewButton.setBackground(new Color(53, 132, 228));
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNewButton.setBounds(331, 380, 143, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quay Lại");
		btnNewButton_1.setForeground(new Color(246, 245, 244));
		btnNewButton_1.setBackground(new Color(53, 132, 228));
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bteQuayLai(e);
			}
		});
		btnNewButton_1.setBounds(83, 380, 143, 40);
		panel.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(256, 270, 230, 35);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(256, 320, 230, 35);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID Người Dùng");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(47, 70, 168, 35);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(47, 220, 168, 35);
		panel.add(lblNewLabel_1_2);
	}
	
	public void bteQuayLai(ActionEvent e) {
		try {
			this.dispose();
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			LogIn frame = new LogIn();
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
