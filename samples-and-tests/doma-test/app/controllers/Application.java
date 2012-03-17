package controllers;

import java.util.List;

import javax.inject.Inject;

import play.mvc.Controller;
import play.mvc.With;
import doma.user.User;
import doma.user.UserDao;
import doma.user.domain.Password;

public class Application extends Controller {
	@Inject
	private static UserDao userDao;
	
    public static void index() {
        List<User> users = userDao.select();
        render(users);
    }

    public static void create(User user, String password) {
    	user.setPassword(new Password(password));
    	userDao.insert(user);
        index();
    }

    public static void delete(Integer id) {
    	User user = userDao.selectById(id);
    	userDao.delete(user);
        index();
    }
}