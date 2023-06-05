import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class LogIn extends JFrame {
	private Socket clientSocket;
	private BufferedReader reader;
	private PrintWriter writer;
	private JPanel contentPane;
	private JTextField userName;
	private JTextField password;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
								}
			}
		});
		
	}
	
	public class ServerHandle extends Thread{
		@Override
		public void run() {
			 Boolean isValid ;
			 String line;
			try {
	         while ((line = reader.readLine()) != null) {
	             if(line.equals("valid")) {
	           	  EventQueue.invokeLater(new Runnable() {
	         			public void run() {
	         				try {
	         					ClientView frame = new ClientView();
	         					frame.setVisible(true);
	         				} catch (Exception e) {
	         					e.printStackTrace();
	         				}
	         			}
	         		});
	             };
	         }
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
		}
		}

	public LogIn() {
		  try {
              clientSocket = new Socket("localhost", 8888);
              reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
              writer = new PrintWriter(clientSocket.getOutputStream(), true);
              System.out.println("Connected to server.");

          } catch (IOException e) {
              e.printStackTrace();
          }
		  ServerHandle sh = new ServerHandle();
		  sh.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userName = new JTextField();
		userName.setFont(new Font("Dialog", Font.PLAIN, 14));
		userName.setBounds(118, 71, 264, 41);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblngNhp = new JLabel("Đăng nhập");
		lblngNhp.setFont(new Font("Dialog", Font.BOLD, 22));
		lblngNhp.setBounds(157, 12, 176, 36);
		contentPane.add(lblngNhp);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		
		btnNewButton.setForeground(new Color(246, 245, 244));
		btnNewButton.setBackground(new Color(53, 132, 228));
		
		btnNewButton.setBounds(118, 210, 117, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tài Khoản:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 83, 82, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu:");
		lblMtKhu.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMtKhu.setBounds(26, 148, 82, 15);
		contentPane.add(lblMtKhu);
		
		password = new JTextField();
		password.setFont(new Font("Dialog", Font.PLAIN, 14));
		password.setColumns(10);
		password.setBounds(118, 136, 264, 41);
		contentPane.add(password);
		
		JButton btnNewButton_1 = new JButton("Đăng ký");
		btnNewButton_1.setForeground(new Color(246, 245, 244));
		btnNewButton_1.setBackground(new Color(53, 132, 228));
		btnNewButton_1.setBounds(270, 210, 117, 38);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            bteDangKy(e);
	        }
	    });
		ActionListener buttonListener = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	writer.println(userName.getText());
		    	writer.println(password.getText());
		    	writer.println("user");
		    	System.out.println("truyen thanh cong");
		    	
		    }
		};
		btnNewButton.addActionListener(buttonListener);
		
	}
	
	public void bteDangKy(ActionEvent e) {
		try {
			this.dispose();
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new RegisterView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
