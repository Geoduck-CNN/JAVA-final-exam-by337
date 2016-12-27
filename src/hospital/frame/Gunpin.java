package hospital.frame;
import java.awt.*;
import hospital.util.JdbcUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Gunpin implements ActionListener{
	
	Statement stmt = null;
	String sql;

	Frame frm3 = new Frame("挂号排队系统");

	// 处方管理界面
	Label labe9 = new Label(" 挂号等待");
	Label labe10 = new Label(" 科室名称：");
	Label labe11 = new Label(" 等待人员：");
	Label labe1 =new Label("等待人数：");
	Button qry = new Button("显示");

	TextField lst41 = new TextField();
	TextField txa1 = new TextField();
	TextField txt1 = new TextField();
	TextField txt2 =new TextField();
	TextField txt3 =new TextField();
	

	public void clearFrame() {
		lst41.setText("");
		txa1.setText("");
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
	}
	public Gunpin() {

		// 处方管理系统界面
		labe1.setBounds(250, 45, 90, 20);
		labe9.setBounds(5, 45, 100, 20);
		labe10.setBounds(5, 70, 90, 20);
		labe11.setBounds(5, 100, 90, 20);
		lst41.setBounds(100, 70, 100, 20);
		txa1.setBounds(20, 125, 50, 20);
		txt1.setBounds(75,125,50,20);
		txt2.setBounds(130,125,50,20);
		txt3.setBounds(250,70,20,20);
		qry.setBounds(250, 325, 50, 20);
		frm3.add(labe9);
		frm3.add(labe10);
		frm3.add(labe11);
		frm3.add(lst41);
		frm3.add(txa1);
		frm3.add(qry);
		frm3.add(txt1);
		frm3.add(txt2);
		frm3.add(txt3);
		frm3.add(labe1);

		qry.addActionListener(this);

		frm3.setLayout(null);
		frm3.setBounds(500, 200, 460, 400);
		frm3.setBackground(Color.LIGHT_GRAY);
		frm3.setVisible(true);

		// 实现窗口关闭按扭的事件
		frm3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm3.dispose();
			}
		});

		frm3.setResizable(false);// 固定窗口的大小

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		ResultSet a=null;
		String _id = lst41.getText().trim();
		if (soruce == qry) {
			try {

				if (_id.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的科室！");
					return;
				}

				sql = "select Pno,Pname,Dsubject from Guahao where Dsubject='" + _id + "'";

				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					txa1.setText(rs.getString(1));
					txt1.setText(rs.getString(2));
				    txt2.setText(rs.getString(3));
				} 
				else {
					JOptionPane.showMessageDialog(null, "没有查询到【" + _id + "】!");
				}
				sql ="select count(Pno) from Guahao group by Dsubject having Dsubject='" + _id + "'";
				a =stmt.executeQuery(sql);
				if(a.next())
					txt3.setText(a.getString(1));
				else {
					JOptionPane.showMessageDialog(null, "没有查询到【" + _id + "】!");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
	}
}


