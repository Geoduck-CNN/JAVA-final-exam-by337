package hospital.frame;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import hospital.util.JdbcUtil;

public class Guahao implements ActionListener{
	
	Statement stmt = null;
	String sql;
	Frame frm1 = new Frame("医院管理系统");

	// 管理系统病人资料界面
	// Ａ病人基本资料
	Label labe1 = new Label("    挂号");
	Button btn1 = new Button("病人编号");
	Button btn2 = new Button("姓名");
	Button btn3 = new Button("就医科别");
	Button btn4 = new Button("主治医师");


	Button addA = new Button("挂号");

	TextField txf1 = new TextField();
	TextField txf2 = new TextField();
	TextField txf3 = new TextField();
	TextField txf4 = new TextField();

	
	public void clearFrameA(){
		 txf1.setText("");
		 txf2.setText("");
		 txf3.setText("");
		 txf4.setText("");
	}
	public Guahao() {
		addA.addActionListener(this);

		// 病人资料管理界面
		labe1.setBounds(0, 50, 1024, 20);
		btn1.setBounds(5, 70, 95, 15);
		txf1.setBounds(5, 85, 95, 20);
		btn2.setBounds(100, 70, 80, 15);
		txf2.setBounds(100, 85, 80, 20);
		btn3.setBounds(180, 70, 80, 15);
		txf3.setBounds(180, 85, 80, 20);
		btn4.setBounds(260, 70, 60, 15);
		txf4.setBounds(260, 85, 60, 20);
		addA.setBounds(105, 115, 50, 20);

		
		frm1.add(labe1);
		frm1.add(btn1);
		frm1.add(btn2);
		frm1.add(btn3);
		frm1.add(btn4);
		frm1.add(addA);
		frm1.add(txf1);
		frm1.add(txf2);
		frm1.add(txf3);
		frm1.add(txf4);

		frm1.setLayout(null);
		frm1.setBounds(500, 200, 400,205);
		frm1.setBackground(Color.LIGHT_GRAY);
		frm1.setVisible(true);

		// 实现窗口关闭按扭的事件
		frm1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm1.dispose();
			}
		});

		frm1.setResizable(false);// 固定窗口的大小

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		if (soruce == addA) {
			try {
				if (txf1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "病人编号不能为空！");
					return;
				} else if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				}

				sql = "select * from Patient where Pno='"
						+ txf1.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "病人编号【"
							+ txf1.getText().trim() + "】已经存在，请重新输入！");
					return;
				}
				sql = "insert into Patient(Pno,Pname) values('"
						+ txf1.getText().trim()
						+ "','"
						+ txf2.getText().trim()
						+ "')";
				stmt.executeUpdate(sql);
				sql = "insert into Guahao(Pno,Pname,Dsubject,Dmdoctor) values('"
						+ txf1.getText().trim()
						+ "','"
						+ txf2.getText().trim()
						+ "','"
						+ txf3.getText().trim()
						+"','"
						+txf4.getText().trim()
						+ "')";
				stmt.executeUpdate(sql);
				sql = "insert into Hospitalize(Pno,Pname,Dsubject,Dmdoctor) values('"
						+ txf1.getText().trim()
						+ "','"
						+ txf2.getText().trim()
						+ "','"
						+ txf3.getText().trim()
						+"','"
						+txf4.getText().trim()
						+ "')";
				stmt.executeUpdate(sql);
				
				JOptionPane.showMessageDialog(null, "挂号成功！");
				clearFrameA();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 

		
		}
	}


