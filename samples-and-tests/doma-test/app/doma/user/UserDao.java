package doma.user;

import doma.AppConfig;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;

/**
 * ユーザーを操作するDao
 */
@Dao(config = AppConfig.class)
public interface UserDao {
	/**
	 * 全データ取得
	 * 
	 * @return
	 */
	@Select
	List<User> select();

	/**
	 * ID指定で取得
	 * 
	 * @param id
	 * @return
	 */
	@Select
	User selectById(Integer id);

	/**
	 * 登録
	 * 
	 * @param user
	 * @return
	 */
	@Insert
	int insert(User user);

	/**
	 * 更新
	 * 
	 * @param user
	 * @return
	 */
	@Update
	int update(User user);

	/**
	 * 削除
	 * 
	 * @param user
	 * @return
	 */
	@Delete
	int delete(User user);
}
