package hospital.frame;
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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PatientFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm1 = new Frame("医院管理系统");

	// 管理系统病人资料界面
	// Ａ病人基本资料
	Label labe1 = new Label("    病人基本资料：  （注意：查询，删除请输入病人者姓名）");
	Button btn1 = new Button("病人编号");
	Button btn2 = new Button("姓名");
	Button btn3 = new Button("性别");
	Button btn4 = new Button("出生年月");
	Button btn5 = new Button("出生地");
	Button btn6 = new Button("籍贯");
	Button btn7 = new Button("住院情况");
	Button btn8 = new Button("预交住院费(元)");

	Button addA = new Button("录入");
	Button delA = new Button("删除");
	Button qryA = new Button("查询");

	TextField txf1 = new TextField();
	TextField txf2 = new TextField();
	TextField txf3 = new TextField();
	TextField txf4 = new TextField();
	TextField txf5 = new TextField();
	TextField txf6 = new TextField();
	TextField txf7 = new TextField();
	TextField txf8 = new TextField();



	
	public void clearFrameA(){
		 txf1.setText("");
		 txf2.setText("");
		 txf3.setText("");
		 txf4.setText("");
		 txf5.setText("");
		 txf6.setText("");
		 txf7.setText("");
		 txf8.setText("");
	}
	public PatientFrame() {
		addA.addActionListener(this);
		delA.addActionListener(this);
		// updateA.addActionListener(this);
		qryA.addActionListener(this);

		// 病人资料管理界面
		labe1.setBounds(0, 50, 1024, 20);
		btn1.setBounds(5, 70, 95, 15);
		txf1.setBounds(5, 85, 95, 20);
		btn2.setBounds(100, 70, 80, 15);
		txf2.setBounds(100, 85, 80, 20);
		btn3.setBounds(180, 70, 40, 15);
		txf3.setBounds(180, 85, 40, 20);
		btn4.setBounds(220, 70, 100, 15);
		txf4.setBounds(220, 85, 100, 20);
		btn5.setBounds(320, 70, 120, 15);
		txf5.setBounds(320, 85, 120, 20);
		btn6.setBounds(440, 70, 80, 15);
		txf6.setBounds(440, 85, 80, 20);
		btn7.setBounds(520, 70, 100, 15);
		txf7.setBounds(520, 85, 100, 20);
		btn8.setBounds(620, 70, 100, 15);
		txf8.setBounds(620, 85, 100, 20);
		addA.setBounds(105, 115, 50, 20);
		delA.setBounds(260, 115, 50, 20);
		qryA.setBounds(415, 115, 50, 20);

		
		frm1.add(labe1);
		frm1.add(btn1);
		frm1.add(btn2);
		frm1.add(btn3);
		frm1.add(btn4);
		frm1.add(btn5);
		frm1.add(btn6);
		frm1.add(btn7);
		frm1.add(btn8);
		frm1.add(addA);
		frm1.add(delA);
		// frm1.add(updateA);
		frm1.add(qryA);

		frm1.add(txf1);
		frm1.add(txf2);
		frm1.add(txf3);
		frm1.add(txf4);
		frm1.add(txf5);
		frm1.add(txf6);
		frm1.add(txf7);
		frm1.add(txf8);

		frm1.setLayout(null);
		frm1.setBounds(500, 200, 725,255);
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
				sql = "insert into Patient(Pno,Pname,Psex,Pbirthday,Pplace,Pbirthplace,Pcondition,Pbudget) values('"
						+ txf1.getText().trim()
						+ "','"
						+ txf2.getText().trim()
						+ "','"
						+ txf3.getText().trim()
						+ "','"
						+ txf4.getText().trim()
						+ "','"
						+ txf5.getText().trim()
						+ "','"
						+ txf6.getText().trim()
						+ "','"
						+ txf7.getText().trim()
						+ "','"
						+ txf8.getText().trim()
						+ "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "录入信息成功！");
				clearFrameA();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == delA) {
			try {

				if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要删除的病人姓名！");
					return;
				}

				sql = "delete from Patient where Pname='"
						+ txf2.getText().trim() + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "没有查询到【"
							+ txf2.getText().trim() + "】");
				} else {
					JOptionPane.showMessageDialog(null, "已删除【"
							+ txf2.getText().trim() + "】的信息");
					clearFrameA();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == qryA) {
			try {

				if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的病人姓名！");
					return;
				}

				sql = "select * from Patient where Pname='"
						+ txf2.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					txf1.setText(rs.getString(1));
					txf2.setText(rs.getString(2));
					txf3.setText(rs.getString(3));
					txf4.setText(rs.getString(4));
					txf5.setText(rs.getString(5));
					txf6.setText(rs.getString(6));
					txf7.setText(rs.getString(7));
					txf8.setText(rs.getString(8));
				} else {
					JOptionPane.showMessageDialog(null, "没有查询到【"
							+ txf2.getText().trim() + "】的信息！");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		
		}
	}

