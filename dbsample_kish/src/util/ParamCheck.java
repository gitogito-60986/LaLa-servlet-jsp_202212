package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

import model.Employee;
import model.Gender;
import model.MyError;
import model.logic.GetEmpByIdLogic;

public class ParamCheck {
	private List<MyError> errorList;
	private boolean isError;
	private boolean replaceBirthdayFlag;
		
	public ParamCheck(List<MyError> errorList) {
		this.errorList = errorList;
		this.isError = false;
		this.replaceBirthdayFlag = false;
	}
	
	public void validate(Employee emp) {
		checkId(emp.getId());
		checkName(emp.getName());
		checkGender(emp.getGender());
		checkBirthday(emp.getBirthday());
		if(this.replaceBirthdayFlag) {
			emp.setBirthday(emp.getBirthday().replaceAll("/", "-"));
		}
	}

	private void checkId(String emp_id) {
		nullCheck("ID", emp_id);
		if(this.isError) {
			this.isError = false;
			return;
		}
		
		if(!emp_id.matches("^EMP[0-9]{3}$")) {
			MyError err = new MyError(emp_id, "不正なIDです。");
			this.errorList.add(err);
		}
		duplicationCheck(emp_id);
	}
	
	private void duplicationCheck(String emp_id) {
		GetEmpByIdLogic logic = new GetEmpByIdLogic();
		Employee emp = logic.execute(emp_id);
		if(emp != null) {
			MyError err = new MyError(emp_id, "そのIDはすでに使われています。");
			this.errorList.add(err);
		}
	}
	
	private void checkName(String emp_name) {
		nullCheck("名前", emp_name);
		if(this.isError) {
			this.isError = false;
			return;
		}

		if(emp_name.length() > 30) {
			MyError err = new MyError("名前", "長すぎます。");
			this.errorList.add(err);
		}
	}
	
	private void checkGender(Gender emp_gender) {
		nullCheck("性別", emp_gender);
		if(this.isError) {
			this.isError = false;
			return;
		}
		
		String gender_id = emp_gender.getId();
		int result = MyTool.parseInt(gender_id);
		if(result < 0) {
			MyError err = new MyError("性別", "正しい入力値ではありません。");
			this.errorList.add(err);
		}
		
		// もう1つのやり方
//		if(!gender_id.matches("[1-3]")) {
//			MyError err = new MyError("性別", "正しい入力値ではありません。");
//			this.errorList.add(err);
//		}
	}

	private void checkBirthday(String emp_birthday) {
		nullCheck("生年月日", emp_birthday);
		if(this.isError) {
			this.isError = false;
			return;
		}
		
		if(emp_birthday.matches("^[0-9]{4}/[0-9]{2}/[0-9]{2}$")) {
			emp_birthday = emp_birthday.replaceAll("/", "-");
			this.replaceBirthdayFlag = true;
		}
		
		if(emp_birthday.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
			;
		} else {
			MyError err = new MyError("生年月日", "正しい書式ではありません。（「2000-01-01」の形式で入力してください）");
			this.errorList.add(err);
		}
		if(isDate(emp_birthday)) {
			;
		} else {
			MyError err = new MyError("生年月日", "正しい日付ではありません。");
			this.errorList.add(err);
		}
	}
	
	private boolean isDate(String dateTxt) {
		final String DATE_PATTERN = "uuuu-MM-dd";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_PATTERN).withResolverStyle(ResolverStyle.STRICT);
		
		try {
			LocalDate.parse(dateTxt, fmt);
			return true;
		} catch(DateTimeParseException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * value が未入力でないかチェックする
	 * @param key value の項目名。エラー表示のときに
	 * @param value 調べたい項目。
	 * @param errorList MyError クラスのリスト。
	 *
	 */
	private void nullCheck(String key, String value) {
		if(value == null || value.length() == 0) {
			MyError err = new MyError(key, "未入力です。");
			this.errorList.add(err);
			this.isError = true;
		}
	}
	
	private void nullCheck(String key, Object obj) {
		if(obj == null) {
			MyError err = new MyError(key, "未入力です。");
			this.errorList.add(err);
			this.isError = true;
		}
	}
}
