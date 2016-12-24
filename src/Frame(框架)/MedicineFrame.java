package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MedicineFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm2 = new Frame("医院管理系统");

	// 药品,化验收费
	Label labe6 = new Label("    Ｄ收费价格管理");
	Label labe7 = new Label("    药物价格：(单位:元)(注：查询，删除时请输入药物编号)");
	Label labe8 = new Label("    化验价格：(单位:元)(注：查询，删除时请输入化验编号)");
	Button btnh1 = new Button("药物名称：");
	Button btnh2 = new Button("药物价格：");
	Button btnh3 = new Button("化验类型：");
	Button btnh4 = new Button("化验价格：");

	Button qry1 = new Button("D1查询");
	Button del1 = new Button("D1删除");
	Button add1 = new Button("D1录入");
	Button qry2 = new Button("D2查询");
	Button del2 = new Button("D2删除");
	Button add2 = new Button("D2录入");

	Button btnh13 = new Button("药物编号");
	Button btnh14 = new Button("化验编号");
	TextField lst35 = new TextField();
	TextField lst31 = new TextField();
	TextField lst32 = new TextField();

	TextField lst36 = new TextField();
	TextField lst33 = new TextField();
	TextField lst34 = new TextField();



	public void clearFrameM() {
		lst35.setText("");
		lst31.setText("");
		lst32.setText("");
	}

	public void clearFrameH() {
		lst36.setText("");
		lst33.setText("");
		lst34.setText("");
	}

	public MedicineFrame() {

		// 药品,化验价格查询系统
		labe6.setBounds(0, 35, 300, 20);
		labe7.setBounds(0, 55, 350, 15);
		labe8.setBounds(0, 130, 350, 15);
		btnh1.setBounds(125, 70, 100, 20);
		btnh2.setBounds(230, 70, 100, 20);
		btnh3.setBounds(125, 145, 100, 20);
		btnh4.setBounds(230, 145, 100, 20);

		add1.setBounds(380, 70, 50, 18);
		qry1.setBounds(380, 92, 50, 18);
		del1.setBounds(431, 92, 50, 18);

		add2.setBounds(380, 145, 50, 18);
		qry2.setBounds(380, 167, 50, 18);
		del2.setBounds(431, 167, 50, 18);

		lst31.setBounds(125, 90, 100, 20);
		lst32.setBounds(230, 90, 100, 20);
		lst33.setBounds(125, 165, 100, 20);
		lst34.setBounds(230, 165, 100, 20);

		btnh13.setBounds(25, 70, 100, 20);
		btnh14.setBounds(25, 145, 100, 20);
		lst35.setBounds(25, 90, 100, 20);
		lst36.setBounds(25, 165, 100, 20);
		frm2.add(btnh13);
		frm2.add(btnh14);
		frm2.add(lst35);
		frm2.add(lst36);

		frm2.add(labe6);
		frm2.add(labe7);
		frm2.add(labe8);
		frm2.add(btnh1);
		frm2.add(btnh2);
		frm2.add(btnh3);
		frm2.add(btnh4);
		frm2.add(qry1);
		frm2.add(del1);
		frm2.add(qry2);
		frm2.add(del2);
		frm2.add(add1);
		frm2.add(add2);
		frm2.add(lst31);
		frm2.add(lst32);
		frm2.add(lst33);
		frm2.add(lst34);

		qry1.addActionListener(this);
		del1.addActionListener(this);
		qry2.addActionListener(this);
		del2.addActionListener(this);
		add1.addActionListener(this);
		add2.addActionListener(this);
		btnh13.addActionListener(this);
		btnh14.addActionListener(this);

		frm2.setLayout(null);
		frm2.setBounds(500, 200, 510, 270);
		frm2.setBackground(Color.ORANGE);
		frm2.setVisible(true);

		frm2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm2.dispose();
			}
		});

		frm2.setResizable(false);// 固定窗口的大小

		try {
			Connection conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
	}

}
