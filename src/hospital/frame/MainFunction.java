package hospital.frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Label;

public class MainFunction implements ActionListener {

	Frame frmX = new Frame("医院管理系统");

	// 管理系统选择界面
	Label k1 = new Label("欢迎院长使用医院管理系统");
	Button emp = new Button("医院员工管理");


	public MainFunction() {
		// 选择界面配置
		k1.setBounds(110, 50, 150, 30);
		emp.setBounds(120, 140, 90, 30);
		frmX.add(k1);
		frmX.add(emp);

		emp.addActionListener(this);

		frmX.setLayout(null);
		frmX.setBackground(Color.LIGHT_GRAY);
		frmX.setBounds(600, 300, 320, 260);
		frmX.setVisible(true);

		// 实现窗口关闭按扭的事件
		frmX.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmX.setResizable(false);// 固定窗口的大小

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		if (soruce == emp) {
			new EmpFrame();
		}
	}
}
