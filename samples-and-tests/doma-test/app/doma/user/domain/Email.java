package doma.user.domain;

import org.seasar.doma.Domain;

/**
 * メールアドレスのDomain
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class Email {
	/**
	 * 値
	 */
	private final String value;

	/**
	 * コンストラクタ
	 * 
	 * @param value
	 */
	private Email(String value) {
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
	 * メールアドレスのドメインを取得する
	 * 
	 * @return
	 */
	public String getDomainName() {
		String name = "";
		int index = value.indexOf("@");
		if (index != -1) {
			name = value.substring(index + 1);
		}
		return name;
	}

	/**
	 * ファクトリーメソッド
	 * 
	 * @param value
	 * @return
	 */
	public static Email of(String value) {
		return new Email(value);
	}

	/**
	 * view用にtoString()で値を返す
	 */
	@Override
	public String toString() {
		return value;
	}
}
