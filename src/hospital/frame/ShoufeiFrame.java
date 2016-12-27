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
	Frame frm1 = new Frame("医院管理系统");
	
	Label labe3 = new Label("    病人收费管理：（注意：查询请输入病人编号）　　单位：元");
	Button btnk1 = new Button("病人编号");
	Button btnk2 = new Button("药物费用");
	Button btnk3 = new Button("挂号费");
	Button btnk5 = new Button("姓名：");

	Button qryC = new Button("查询");

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
		
	   
		 
		 if (soruce == qryC) {
			try {

				if (lst21.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的病人编号！");
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
					JOptionPane.showMessageDialog(null, "没有查询到【"
							+ lst21.getText().trim() + "】的信息！");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}


}
}