package com.itzcn.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String add(){//���
		return "add";
	}
	public String del(){//ɾ��
		return "del";
	}
	public String up(){//�޸�
		return "up";
	}
	public String show(){//�г�
		return "show";
	}

}
