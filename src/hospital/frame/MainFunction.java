package hospital.frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Label;

public class MainFunction implements ActionListener {

	Frame frmX = new Frame("ҽԺ����ϵͳ");

	// ����ϵͳѡ�����
	Label k1 = new Label("��ӭԺ��ʹ��ҽԺ����ϵͳ");
	Button emp = new Button("ҽԺԱ������");
	Button yaopin = new Button("ҩƷ����");


	public MainFunction() {
		// ѡ���������
		k1.setBounds(110, 50, 150, 30);
		emp.setBounds(120, 100, 90, 30);
		yaopin.setBounds(120, 180, 90, 30);
		frmX.add(k1);
		frmX.add(emp);
		frmX.add(yaopin);

		emp.addActionListener(this);
		yaopin.addActionListener(this);

		frmX.setLayout(null);
		frmX.setBackground(Color.LIGHT_GRAY);
		frmX.setBounds(600, 300, 320, 260);
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
		if (soruce == emp) {
			new EmpFrame();
		}
		if (soruce == yaopin){
			new MedicineFrame();
		}
	}
}
