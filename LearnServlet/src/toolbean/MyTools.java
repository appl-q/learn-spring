package toolbean;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTools {
	/**
	 * @���� ת���ַ���������HTML�����е������ַ�
	 * @���� sourceΪҪת�����ַ���
	 * @����ֵ String��ֵ
	 */
	public static String changeHTML(String source){
		String changeStr="";
		changeStr=source.replace("&","&amp;");			//ת���ַ����еġ�&������
		changeStr=changeStr.replace(" ","&nbsp;");		//ת���ַ����еĿո�
		changeStr=changeStr.replace("<","&lt;");		//ת���ַ����еġ�<������
		changeStr=changeStr.replace(">","&gt;");		//ת���ַ����еġ�>������
		changeStr=changeStr.replace("\r\n","<br>");		//ת���ַ����еĻس�����
		return changeStr;
	}
    /**
     * @���� ��Date������ת����ָ����ʽ���ַ�����ʽ���硰yyyy-MM-dd HH:mm:ss��
     * @���� dateΪҪ��ת����Date������
     * @����ֵ String��ֵ
     */
	public static String changeTime(Date date) {
		//����һ����ʽ�����ڵ�SimpleDateFormat����󣬲�ͬʱָ���������ձ�ת���ɵ���ʽ
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);			//����format()������ʽ������
	}
	/**
	 * @���� ���ͨ���ύ����������������
	 * @���� valueΪҪת�����ַ���
	 * @����ֵ String��ֵ
	 */
    public  static String  toChinese(String str) {
		if(str==null)
			str="";
		try {
			str=new String(str.getBytes("ISO-8859-1"),"gb2312");
		} catch (UnsupportedEncodingException e) {
			str="";
			e.printStackTrace();
		}
		return str;
	}
	public static int strToint(String str){			//��String������ת��Ϊint�����ݵķ���
		if(str==null||str.equals(""))
			str="0";
		int i=0;
		try{
			i=Integer.parseInt(str);
		}catch(NumberFormatException e){
			i=0;
			e.printStackTrace();
		}
		return i;		
	}
}
