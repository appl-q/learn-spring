package com;


import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ShowDate extends TagSupport {
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Date dt = new Date();
			java.sql.Date date = new java.sql.Date(dt.getTime());
			out.print(date);
		} catch (Exception e) {
			System.out.println("��ʾϵͳ���ڳ��ֵ��쳣��" + e.getMessage());
		}
		return (SKIP_BODY); // ����SKIP_BODY��������ʾ���Ա�ǩ����д���
	}
}
