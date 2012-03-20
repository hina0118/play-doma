package controllers;

import java.util.List;

import javax.inject.Inject;

import play.mvc.Controller;
import doma.user.User;
import doma.user.UserDao;

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
	public static void create(User user) {
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
	 * @param user
	 */
	public static void update(User user) {
		userDao.update(user);
		index();
	}
}