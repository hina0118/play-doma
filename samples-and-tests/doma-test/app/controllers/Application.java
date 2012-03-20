package controllers;

import java.util.List;

import javax.inject.Inject;

import play.mvc.Controller;
import doma.user.User;
import doma.user.UserDao;

public class Application extends Controller {
	@Inject
	private static UserDao userDao;

	public static void index() {
		List<User> users = userDao.select();
		render(users);
	}

	public static void create(User user) {
		userDao.insert(user);
		index();
	}

	public static void delete(Integer id) {
		User user = userDao.selectById(id);
		userDao.delete(user);
		index();
	}

	public static void view(Integer id) {
		User user = userDao.selectById(id);
		render(user);
	}

	public static void update(User user) {
		userDao.update(user);
		index();
	}
}