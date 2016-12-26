package hospital.frame;
import java.awt.*;
import java.awt.event.*;


public class Shoufeirenyuan implements ActionListener{
	
	Frame frmX = new Frame("医院管理系统");

	// 管理系统选择界面
	Label k1 = new Label("欢迎使用收费管理系统");
	Button patientInfo = new Button("挂号管理");
	Button price = new Button("收费管理");
	
	
	public Shoufeirenyuan() {
		// 选择界面配置
		k1.setBounds(110, 50, 150, 30);
		patientInfo.setBounds(70, 100, 90, 30);
		price.setBounds(210, 100, 90, 30);
		frmX.add(k1);
		frmX.add(patientInfo);
		frmX.add(price);

		patientInfo.addActionListener(this);
		price.addActionListener(this);


		frmX.setLayout(null);
		frmX.setBackground(Color.LIGHT_GRAY);
		frmX.setBounds(600, 300, 420, 320);
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
		if (soruce == patientInfo) {
			new Guahao();
		}
		if (soruce == price) {
			new ShoufeiFrame();
		}
	}



}
