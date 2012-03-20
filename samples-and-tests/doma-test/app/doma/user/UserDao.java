package doma.user;

import doma.AppConfig;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;

@Dao(config = AppConfig.class)
public interface UserDao {
	@Select
	List<User> select();

	@Select
	User selectById(Integer id);

	@Insert
	int insert(User user);

	@Update
	int update(User user);

	@Delete
	int delete(User user);
}
