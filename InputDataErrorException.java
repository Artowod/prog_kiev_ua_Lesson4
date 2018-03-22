package ua.prog.java.lesson4;

public class InputDataErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errInfo;

	public InputDataErrorException(String errInfo) {
		this.errInfo = errInfo;
	}

	public InputDataErrorException() {
		super();
	}

	@Override
	public String getMessage() {
		return " Неверно введены данные студента: " + errInfo;
	}

}
