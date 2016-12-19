import java.io.*;
import java.text.*;

public final class Debug{
	   private static Debug instance=null;
	   private static SimpleDateFormat dateFormat=null;
	   private static FileOutputStream fos=null;
	   private Debug(){
	   }
	static synchronized Debug init(String path){
		return instance;//��֤��ͬһʱ�����ֻ��һ���߳�ִ�иöδ��롣		
	}
	public static synchronized void log(String msg){
		
	}
	private String writeFile(String msg){
		return msg;
	}
	public static String getExceptionMsg(Exception e){
		StackTraceElement ste=e.getStackTrace()[0];
		String msg=ste.getClassName() + "." + ste.getMethodName() + "() Ln " + ste.getLineNumber() + ":   " + e.getMessage();
		return msg;
	  }
}
