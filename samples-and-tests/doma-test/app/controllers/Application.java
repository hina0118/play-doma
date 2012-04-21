package controllers;

import java.util.List;

import javax.inject.Inject;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.mvc.Controller;
import doma.user.User;
import doma.user.UserDao;
import doma.user.domain.Email;

/**
 * サンプルアプリケーションのコントローラ
 */
public class Application extends Controller {
	/**
	 * Dao
	 */
	@Inject
	private static UserDao userDao;

	/**
	 * ユーザー一覧
	 */
	public static void index() {
		List<User> users = userDao.select();
		render(users);
	}

	/**
	 * ユーザー登録
	 * 
	 * @param user
	 */
	public static void create(@Valid(message="validation failed") User user) {
		if(validation.hasErrors()) {
			validation.keep();
			index();
		}
		userDao.insert(user);
		index();
	}

	/**
	 * ユーザー削除
	 * 
	 * @param id
	 */
	public static void delete(Integer id) {
		User user = userDao.selectById(id);
		userDao.delete(user);
		index();
	}

	/**
	 * ユーザー更新表示
	 * 
	 * @param id
	 */
	public static void view(Integer id) {
		User user = userDao.selectById(id);
		render(user);
	}

	/**
	 * ユーザー更新
	 * 
	 * @param id
	 * @param email
	 * @param fullname
	 */
	public static void update(Integer id,
			@Required(message = "email is required") Email email,
			@Required(message = "fullname is required") String fullname) {
		if(validation.hasErrors()) {
			validation.keep();
			view(id);
		}
		User user = userDao.selectById(id);
		user.setEmail(email);
		user.setFullname(fullname);
		userDao.update(user);
		index();
	}
}