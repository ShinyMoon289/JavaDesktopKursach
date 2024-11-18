package kursachserver.validator;

import kursachserver.models.Roles;
import kursachserver.models.User;

import java.sql.Date;
import java.util.regex.Pattern;

public class Validator {
	private static final Pattern EMAIL_CHECK = Pattern.compile
			("((([a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*)|(\"(([\\x01-\\x08\\x0B\\x0C\\x0E-\\x1F\\x7F]|[\\x21\\x23-\\x5B\\x5D-\\x7E])|(\\\\[\\x01-\\x09\\x0B\\x0C\\x0E-\\x7F]))*\"))@(([a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*)|(\\[(([\\x01-\\x08\\x0B\\x0C\\x0E-\\x1F\\x7F]|[\\x21-\\x5A\\x5E-\\x7E])|(\\\\[\\x01-\\x09\\x0B\\x0C\\x0E-\\x7F]))*\\])))\n");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");


	public static boolean checkUser(int id, Date reg, String email,String role){
		boolean isCorrect=true;
		if(email.isBlank()||!EMAIL_CHECK.matcher(email).matches()||reg==null){
			isCorrect=false;
		}
		else{
			for(Roles value:Roles.values()){
				if(role !=value.name()){
					isCorrect=false;
				}
			}
		}
		return isCorrect;
	}

	public static boolean checkPersonInfo
			(String firstname,String lastname,String middlename,int telephone,Date birthday,String email){
		boolean isCorrect=true;
		if(firstname.isBlank()
				||lastname.isBlank()
				||middlename.isBlank()
				||birthday==null
				||email.isBlank()
				||!EMAIL_CHECK.matcher(email).matches()
				||String.valueOf(telephone).length()>7){
			isCorrect=false;
		}
		return isCorrect;
	}
	public static boolean checkAccount(Date reg, User user){
		boolean isCorrect = true;
		if(reg==null||user==null){
			isCorrect=false;
		}
		return isCorrect;
	}



}


