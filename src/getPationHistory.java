import java.sql.*;
public class getPatientsHistory(String orderBy){//��ѯ����
		conn=DBConnection.getConnection();
		int res=0;
		if(orderBy == null || orderBy.equals(""))
			orderBy=Doctor.NAME;
try{strSQL=
	"SELECT history.HID,history.Diagnose,history.Description,history.Rx,history.SDate,history.FDate,history.Finished,patient.Name,patient.Age,patient.Sex,patient.Address,patient.Phone" +
	 " FROM patient,doctor,history WHERE history.Doctor='" + this.id + "' AND doctor.DID='" + this.id +
		   "' AND history.Patient=patient.PID AND Finished=0 ORDER BY " + orderBy;   //ҽ��ֻ�ܲ�ѯ��ǰ���ߵĵ�ǰ����(��Finished=0��)
		  stmt=conn.createStatement();
		  rs=stmt.executeQuery(strSQL);
result=rs;   //���ֲ������е����ݸ��Ƹ������result��ʹ�ⲿ�����ͨ��getResult()			          //����
res=1;
		}
		catch(SQLException sqle){
			Debug.log(Debug.getExceptionMsg(sqle));  //��¼�쳣��־
			res= -1;
		}
		catch(Exception e){
			res=0;
		}
		finally{
			return res;
		}
	}
