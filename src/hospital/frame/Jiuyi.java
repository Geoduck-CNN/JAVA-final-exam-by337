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

public class Jiuyi implements ActionListener{
	
	Statement stmt = null;
	String sql;
	Frame frm1 = new Frame("ҽԺ����ϵͳ");
	
	
	Label labe2 = new Label("   ���˾�ҽ��������ע�⣺��ѯ��ɾ�������벡��������");
	Button btn1 = new Button("���˱��");
	Button btn2 = new Button("��������");
	Button btn3 = new Button("��ҽ����");
	Button btn4 = new Button("����ҽ��");
	Button btn5 = new Button("����");
	Button btn6 = new Button("�������");
	Button btn7 = new Button("��ҩ���");
	Button btn8 = new Button("����ѡ��");

	Button addB = new Button("¼��");

	TextField txf1 = new TextField();
	TextField txf2 = new TextField();
	TextField txf3 = new TextField();
	TextField txf4 = new TextField();
	TextField txf5 = new TextField();
	TextField txf6 = new TextField();
	TextField txf7 = new TextField();
	TextField txf8 = new TextField();


	
	public void clearFrameB(){

		 txf1.setText("");
		 txf2.setText("");
		 txf3.setText("");
		 txf4.setText("");
		 txf5.setText("");
		 txf6.setText("");
		 txf7.setText("");
		 txf8.setText("");
	}
	public Jiuyi() {
		addB.addActionListener(this);
		btn8.addActionListener(this);
	
	labe2.setBounds(0, 50, 1024, 20);
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
	addB.setBounds(105, 115, 50, 20);
	txf8.setBounds(5,150, 100,20);
	btn8.setBounds(120, 150, 50, 20);


	frm1.add(labe2);
	frm1.add(btn1);
	frm1.add(btn2);
	frm1.add(btn3);
	frm1.add(btn4);
	frm1.add(btn5);
	frm1.add(btn6);
	frm1.add(btn7);
	frm1.add(addB);
	frm1.add(btn8);

	frm1.add(txf1);
	frm1.add(txf2);
	frm1.add(txf3);
	frm1.add(txf4);
	frm1.add(txf5);
	frm1.add(txf6);
	frm1.add(txf7);
	frm1.add(txf8);
	
	frm1.setLayout(null);
	frm1.setBounds(500, 200, 725, 255);
	frm1.setBackground(Color.LIGHT_GRAY);
	frm1.setVisible(true);

	
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
		ResultSet a = null;
		String _id = txf8.getText().trim();
		if (soruce == btn8){
			try {

				if (_id.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫѡ��Ŀ��ң�");
					return;
				}
				sql = "select Pno,Pname,Dsubject,Dmdoctor from Guahao where Dsubject='" + _id + "'";

				a = stmt.executeQuery(sql);
				if (a.next()) {
					txf1.setText(a.getString(1));
					txf2.setText(a.getString(2));
				    txf3.setText(a.getString(3));
				    txf4.setText(a.getString(4));
				} 
				else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����" + _id + "��!");
				}}catch (Exception e1) {
			        e1.printStackTrace();
						}}
		        if (soruce == addB) {
		         try {

			        sql = "insert into Hospitalize(Dcause,Dpresno,Dpill) values('"
			       // + txf1.getText().trim()
					//+ "','"
					//+ txf2.getText().trim()
					//+ "','"
					//+ txf3.getText().trim()
					//+"','"
					//+ txf4.getText().trim()
					//+"','"
			        + txf5.getText().trim()
					+ "','"
					+ txf6.getText().trim()
					+ "','"
					+ txf7.getText().trim() + "')";
			        stmt.executeUpdate(sql);
			        
			        sql ="delete from Guahao where Pname='"+txf2.getText().trim()+"'";
			        stmt.executeUpdate(sql);

			JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
			clearFrameB();
		} catch (Exception e1) {
			e1.printStackTrace();
		}}
			}
			}
		
		        
			

		
	
	    


