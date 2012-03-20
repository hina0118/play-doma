package doma.user.domain;

import org.seasar.doma.Domain;

/**
 * パスワードのDomain
 */
@Domain(valueType = String.class)
public class Password {
	/**
	 * 値
	 */
	private final String value;

	/**
	 * コンストラクタ
	 * 
	 * @param value
	 */
	public Password(String value) {
		this.value = value;
	}

	/**
	 * 値取得
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * パスワードにマスクをかける
	 * 
	 * @return
	 */
	public String getMaskedPassword() {
		return "*****";
	}

	/**
	 * view用にtoString()で値を返す
	 */
	@Override
	public String toString() {
		return value;
	}
}
