package hospital.frame;
import java.awt.*;
import java.awt.event.*;

public class Yisheng implements ActionListener{
	
	Frame frmX = new Frame("ҽԺ����ϵͳ");

	// ����ϵͳѡ�����
	Label k1 = new Label("��ӭʹ��ҽԺ����ϵͳ");
	Button patientInfo = new Button("����");
	Button chufang = new Button("ҽ����������");


	public Yisheng() {
		// ѡ���������
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
			new Jiuyi();
		}
		if (soruce == chufang) {
			new ChufangFrame();
		}
	}
	


   }
