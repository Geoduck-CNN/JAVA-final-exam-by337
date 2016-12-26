package hospital.frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoFrame implements ActionListener{
	
	Frame frmX = new Frame("病人信息管理");
	
	Label k1 = new Label("欢迎使用病人信息管理系统");
	Button patientInfo = new Button("病人资料管理");
	Button jiuyi = new Button("病人就医档案");
	Button shoufei = new Button("病人收费管理");
	
	public InfoFrame() {
		// 选择界面配置
		k1.setBounds(110, 50, 150, 30);
		patientInfo.setBounds(70, 100, 90, 30);
		jiuyi.setBounds(210, 100, 90, 30);
		shoufei.setBounds(70, 180, 90, 30);
		frmX.add(k1);
		frmX.add(patientInfo);
		frmX.add(jiuyi);
		frmX.add(shoufei);
		
		patientInfo.addActionListener(this);
		jiuyi.addActionListener(this);
		shoufei.addActionListener(this);

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
			new PatientFrame();
		}
		if (soruce == jiuyi) {
			new JiuyiFrame();
		}
		if (soruce == shoufei) {
			new ShoufeiFrame();
		}
		
		
	}
}

	


