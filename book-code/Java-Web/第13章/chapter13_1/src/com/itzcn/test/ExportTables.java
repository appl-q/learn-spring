package com.itzcn.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportTables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();//����������Ϣ
		SchemaExport export = new SchemaExport(cfg);//ʵ����SchemaExport����
		export.create(true, true);//�������ݿ��
	}

}
