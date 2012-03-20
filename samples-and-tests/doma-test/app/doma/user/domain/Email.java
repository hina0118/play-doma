package doma.user.domain;

import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public class Email {
	private final String value;

	private Email(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getDomainName() {
		String name = "";
		int index = value.indexOf("@");
		if (index != -1) {
			name = value.substring(index + 1);
		}
		return name;
	}

	public static Email of(String value) {
		return new Email(value);
	}

	public String toString() {
		return value;
	}
}
