package hospital.frame;
import java.awt.*;
import java.awt.event.*;

public class Yisheng implements ActionListener{
	
	Frame frmX = new Frame("医院管理系统");

	// 管理系统选择界面
	Label k1 = new Label("欢迎使用医院管理系统");
	Button patientInfo = new Button("看病");
	Button chufang = new Button("医生处方管理");


	public Yisheng() {
		// 选择界面配置
		k1.setBounds(110, 50, 150, 30);
		patientInfo.setBounds(70, 100, 90, 30);
		chufang.setBounds(70, 180, 90, 30);
		frmX.add(k1);
		frmX.add(patientInfo);
		frmX.add(chufang);

		patientInfo.addActionListener(this);
		chufang.addActionListener(this);

		frmX.setLayout(null);
		frmX.setBackground(Color.WHITE);
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
			new Jiuyi();
		}
		if (soruce == chufang) {
			new ChufangFrame();
		}
	}
	


   }
