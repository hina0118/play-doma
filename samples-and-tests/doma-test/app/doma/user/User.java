package doma.user;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;

import play.data.validation.Required;

import doma.user.domain.Email;
import doma.user.domain.Password;

/**
 * ユーザーのEntity
 */
@Entity
public class User {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequence = "UserSeq")
	Integer id;
	/**
	 * メールアドレス
	 */
	@Required(message = "email is required")
	Email email;
	/**
	 * パスワード
	 */
	@Required(message = "password is required")
	Password password;
	/**
	 * 名前
	 */
	@Required(message = "fullname is required")
	String fullname;
	/**
	 * 管理者
	 */
	Boolean isAdmin;

	/**
	 * IDを取得します。
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * IDを設定します。
	 * @param id ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * メールアドレスを取得します。
	 * @return メールアドレス
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * メールアドレスを設定します。
	 * @param email メールアドレス
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * パスワードを取得します。
	 * @return パスワード
	 */
	public Password getPassword() {
		return password;
	}

	/**
	 * パスワードを設定します。
	 * @param password パスワード
	 */
	public void setPassword(Password password) {
		this.password = password;
	}

	/**
	 * 名前を取得します。
	 * @return 名前
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * 名前を設定します。
	 * @param fullname 名前
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * 管理者を取得します。
	 * @return 管理者
	 */
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	/**
	 * 管理者を設定します。
	 * @param isAdmin 管理者
	 */
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
