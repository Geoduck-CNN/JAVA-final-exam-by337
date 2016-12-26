package hospital.frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoFrame implements ActionListener{
	
	Frame frmX = new Frame("������Ϣ����");
	
	Label k1 = new Label("��ӭʹ�ò�����Ϣ����ϵͳ");
	Button patientInfo = new Button("�������Ϲ���");
	Button jiuyi = new Button("���˾�ҽ����");
	Button shoufei = new Button("�����շѹ���");
	
	public InfoFrame() {
		// ѡ���������
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

		// ʵ�ִ��ڹرհ�Ť���¼�
		frmX.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmX.setResizable(false);// �̶����ڵĴ�С

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

	


