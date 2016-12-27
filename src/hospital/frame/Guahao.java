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
	Frame frm1 = new Frame("ҽԺ����ϵͳ");

	// ����ϵͳ�������Ͻ���
	// �����˻�������
	Label labe1 = new Label("    �Һ�");
	Button btn1 = new Button("���˱��");
	Button btn2 = new Button("����");
	Button btn3 = new Button("��ҽ�Ʊ�");
	Button btn4 = new Button("����ҽʦ");


	Button addA = new Button("�Һ�");

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

		// �������Ϲ������
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

		// ʵ�ִ��ڹرհ�Ť���¼�
		frm1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm1.dispose();
			}
		});

		frm1.setResizable(false);// �̶����ڵĴ�С

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
					JOptionPane.showMessageDialog(null, "���˱�Ų���Ϊ�գ�");
					return;
				} else if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
					return;
				}

				sql = "select * from Patient where Pno='"
						+ txf1.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "���˱�š�"
							+ txf1.getText().trim() + "���Ѿ����ڣ����������룡");
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
				
				JOptionPane.showMessageDialog(null, "�Һųɹ���");
				clearFrameA();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 

		
		}
	}


