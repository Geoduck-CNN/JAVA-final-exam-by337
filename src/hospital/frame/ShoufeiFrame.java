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

public class ShoufeiFrame implements ActionListener{
	
	Statement stmt = null;
	String sql;
	Frame frm1 = new Frame("ҽԺ����ϵͳ");
	
	Label labe3 = new Label("    �����շѹ�����ע�⣺��ѯ�����벡�˱�ţ�������λ��Ԫ");
	Button btnk1 = new Button("���˱��");
	Button btnk2 = new Button("ҩ�����");
	Button btnk3 = new Button("�Һŷ�");
	Button btnk5 = new Button("������");

	Button qryC = new Button("��ѯ");

	TextField lst21 = new TextField();
	TextField lst22 = new TextField();
	TextField lst23 = new TextField();
	TextField lst25 =new TextField();

	
	public void clearFrameC(){
		 lst21.setText("");
		 lst22.setText("");
		 lst23.setText("");
		 lst25.setText("");
	}
	public ShoufeiFrame() {

		qryC.addActionListener(this);

	
	labe3.setBounds(0, 50, 1024, 20);
	btnk1.setBounds(5, 70, 95, 15);
	btnk2.setBounds(220, 70, 120, 15);
	btnk3.setBounds(340, 70, 120, 15);
	btnk5.setBounds(100, 70, 120, 15);
	qryC.setBounds(215, 115, 50, 20);
	lst21.setBounds(5, 85, 95, 20);
	lst22.setBounds(220, 85, 120, 20);
	lst23.setBounds(340, 85, 120, 20);
	lst25.setBounds(100,85,120, 20);

	frm1.add(labe3);
	frm1.add(btnk1);
	frm1.add(btnk2);
	frm1.add(btnk3);
	frm1.add(qryC);
	frm1.add(lst21);
	frm1.add(lst22);
	frm1.add(lst23);
	frm1.add(btnk5);
	frm1.add(lst25);

	frm1.setLayout(null);
	frm1.setBounds(500, 200,625, 205);
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
		
	   
		 
		 if (soruce == qryC) {
			try {

				if (lst21.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�Ĳ��˱�ţ�");
					return;
				}
				sql = "select charge.Pno,Hospitalize.Pname,Medicine.Mprice from Hospitalize join Charge on Hospitalize.Pno = Charge.Pno join Medicine on Medicine.Mno=Charge.Mno where Hospitalize.Pno='"
						+ lst21.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst22.setText(rs.getString(3));
					lst23.setText("5");
					lst25.setText(rs.getString(2));
				} else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ lst21.getText().trim() + "������Ϣ��");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}


}
}