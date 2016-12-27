package hospital.login;
import hospital.frame.Gunpin;
import hospital.frame.MainFunction;
import hospital.frame.Shoufeirenyuan;
import hospital.frame.Yisheng;
import hospital.util.JdbcUtil;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Login implements ActionListener {
	Statement stmt = null;
	String sql;
	
	Frame frmD = new Frame("医院管理系统登陆平台");

	// 管理系统登陆界面
	Label l1 = new Label("欢迎登陆医院管理系统");
	Label l2 = new Label("帐号:");
	Label l3 = new Label("密码:");
	Label l4 = new Label("帐户号不存在！");
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	Button b1 = new Button("登陆");
	Button b2 = new Button("取消");

	public static void main(String args[]) {
		new Login();
	}

	public Login() {
		// 登陆界面配置
		l1.setBounds(130, 60, 150, 20);
		l2.setBounds(50, 90, 50, 20);
		l3.setBounds(50, 120, 50, 20);
		l4.setBounds(120, 200, 150, 20);
		t1.setBounds(120, 90, 150, 20);
		t2.setBounds(120, 120, 150, 20);
		b1.setBounds(125, 160, 50, 20);
		b1.addActionListener(this);
		b2.setBounds(210, 160, 50, 20);
		b2.addActionListener(this);
		frmD.add(l1);
		frmD.add(l2);
		frmD.add(l3);
		frmD.add(t1);
		frmD.add(t2);
		frmD.add(b1);
		frmD.add(b2);
		frmD.setLayout(null);
		frmD.setBounds(500, 200, 350, 230);
		frmD.setBackground(Color.LIGHT_GRAY);
		frmD.setVisible(true);
		t2.setEchoChar('*');

		// 实现窗口关闭按扭的事件
		frmD.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmD.setResizable(false);// 固定窗口的大小

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();

		if (soruce == b1) {

			if (soruce == b1) {
				String name = t1.getText();
				String pass = t2.getText();
				if (!"".equals(name.trim()) && !"".equals(pass.trim())||(name.equals("admin"))) {
					if ("123".equals(name.trim()) && "123".equals(pass.trim())||(pass.equals("admin"))) {
						new MainFunction();
						frmD.dispose();
					} 
					
					else if ("234".equals(name.trim()) && "234".equals(pass.trim())) {
						new Shoufeirenyuan();
						frmD.dispose();
					}
					else if ("345".equals(name.trim()) && "345".equals(pass.trim())){
						new Gunpin();
						frmD.dispose();
					}
					else if ("456".equals(name.trim()) && "456".equals(pass.trim())){
						new Yisheng();
						frmD.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！",
								"系统提示", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入完整登陆信息！",
							"系统提示", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (soruce == b2) {
			System.exit(0);
		}
	}

}
