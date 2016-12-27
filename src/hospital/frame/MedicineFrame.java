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
	Label labe6 = new Label("    收费价格管理");
	Label labe7 = new Label("    药物价格：(单位:元)(注：查询，删除时请输入药物编号)");
	Button btnh1 = new Button("药物名称：");
	Button btnh2 = new Button("药物价格：");

	Button qry1 = new Button("查询");
	Button del1 = new Button("删除");
	Button add1 = new Button("录入");

	Button btnh13 = new Button("药物编号");
	TextField lst35 = new TextField();
	TextField lst31 = new TextField();
	TextField lst32 = new TextField();



	public void clearFrameM() {
		lst35.setText("");
		lst31.setText("");
		lst32.setText("");
	}

	public MedicineFrame() {

		// 药品,化验价格查询系统
		labe6.setBounds(0, 35, 300, 20);
		labe7.setBounds(0, 55, 350, 15);
		btnh1.setBounds(125, 70, 100, 20);
		btnh2.setBounds(230, 70, 100, 20);

		add1.setBounds(380, 70, 50, 18);
		qry1.setBounds(380, 92, 50, 18);
		del1.setBounds(431, 92, 50, 18);


		lst31.setBounds(125, 90, 100, 20);
		lst32.setBounds(230, 90, 100, 20);

		btnh13.setBounds(25, 70, 100, 20);
		lst35.setBounds(25, 90, 100, 20);
		frm2.add(btnh13);
		frm2.add(lst35);

		frm2.add(labe6);
		frm2.add(labe7);
		frm2.add(btnh1);
		frm2.add(btnh2);
		frm2.add(qry1);
		frm2.add(del1);
		frm2.add(add1);
		frm2.add(lst31);
		frm2.add(lst32);

		qry1.addActionListener(this);
		del1.addActionListener(this);
		add1.addActionListener(this);
		btnh13.addActionListener(this);

		frm2.setLayout(null);
		frm2.setBounds(500, 200, 510, 200);
		frm2.setBackground(Color.LIGHT_GRAY);
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
		Object soruce = e.getSource();
		ResultSet rs = null;
		String mId = lst35.getText().trim();

		if (soruce == qry1) {
			try {
				if (mId.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的药物编号！");
					return;
				}
				sql = "select * from Medicine where Mno='" + mId + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst31.setText(rs.getString(2));
					lst32.setText(rs.getString(3));
					lst35.setText(rs.getString(1));
				} else {
					JOptionPane.showMessageDialog(null, "没有查询到【" + mId + "】！");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == del1) {
			try {
				if (mId.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要删除的药物编号！");
					return;
				}
				sql = "delete from Medicine where Mno='" + mId + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "没有查询到【" + mId + "】！");
				} else {
					JOptionPane.showMessageDialog(null, "已删除【" + mId + "】的信息！");
					clearFrameM();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == add1) {
			try {
				if (mId.equals("")) {
					JOptionPane.showMessageDialog(null, "药物编号不能为空！");
					return;
				}

				sql = "select * from Medicine where Mno='" + mId + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "药物编号【" + mId
							+ "】已经存在，请重新输入！");
					return;
				}

				sql = "insert into Medicine(Mno,Mname,Mprice) values('"
						+ lst35.getText().trim() + "','"
						+ lst31.getText().trim() + "','"
						+ lst32.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "录入信息成功！");
				clearFrameM();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} 

		}

	}

