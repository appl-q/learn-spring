package com.itzcn.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itzcn.model.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(User.class);
	}

	public void validate(Object arg0, Errors arg1) {
	}
	
	public void validateuserName(String userNameField, Errors errors){//��֤�û���
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, userNameField, null,"�û�������Ϊ��");
	}
	public void validatepassWord(String passwordField, Errors errors){//��֤����
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, passwordField, null,"���벻��Ϊ��");
	}
	public void validatepass(String passField, Errors errors){//��֤ȷ������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, passField, null,"ȷ�����벻��Ϊ��");
	}
	public void validatepassEquals(String passwordField,String passField, Errors errors){//��֤�����Ƿ�һ��
		String passWord = errors.getFieldValue(passwordField).toString().trim();
		String pass = errors.getFieldValue(passField).toString().trim();
		if (!passWord.equals("")&&!pass.equals("")){
			if(!pass.equals(passWord)){
				errors.rejectValue(passField, null, "�����������벻һ��");
			}
		}
	}
	public void validatemail(String mailField, Errors errors){//��֤�����Ƿ�Ϸ�
		if (!errors.getFieldValue(mailField).toString().trim().equals("")) {
			String email = (String) errors.getFieldValue("mail");
			boolean flag = false;
			String check  = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
			if (!flag) {
				errors.rejectValue(mailField, null, "Email��ʽ����ȷ");
			}
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, mailField, null,"Email����Ϊ��");
		}
	}
	
	public void validateTel(String telField, Errors errors){//��֤�ֻ�����
		if (!errors.getFieldValue(telField).toString().trim().equals("")) {
			String mobile = (String)errors.getFieldValue(telField);
			Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
			Matcher matcher = regex.matcher(mobile);
			if(!matcher.matches()){
				errors.rejectValue(telField, null,"�ֻ������ʽ����ȷ");
			}
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, telField, null,"�ֻ����벻��Ϊ��");
		}
		
	}
	public void validateAddress(String addressField, Errors errors){//��֤��ַ
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, addressField, null,"��ַ����Ϊ��");
	}


	
	

}
