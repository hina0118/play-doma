package play.modules.doma;

import org.seasar.doma.Domain;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.tx.LocalTransaction;

import play.Logger;
import play.Play;
import play.PlayPlugin;
import play.data.binding.Binder;
import play.inject.BeanSource;
import play.inject.Injector;
import play.utils.Java;

/**
 * Doma連携用のプラグイン
 */
public class DomaPlugin extends PlayPlugin implements BeanSource {
	
	/**
	 * Playロード時の処理<br>
	 * aptで生成されるソースファイルの出力先をpathに追加する
	 */
	@Override
	public void onLoad() {
		Play.javaPath.add(Play.getVirtualFile(".apt_generated"));
	}

	/**
	 * アプリケーション開始時の処理<br>
	 * ControllerクラスへDao実装クラスをInjectする<br>
	 * DomainBinderクラスをDomainクラスの数だけ登録する
	 */
	@Override
	public void onApplicationStart() {
		Injector.inject(this);
		DomainBinder binder = new DomainBinder();
		for (Class c : Play.classloader.getAnnotatedClasses(Domain.class)) {
			Binder.register(c, binder);
		}
	}

	/**
	 * Dao実装クラスのInject
	 * 
	 * @param clazz
	 */
	@Override
	public <T> T getBeanOfType(Class<T> clazz) {
		Object obj = null;
		try {
			for (Class cls : Play.classloader.getAssignableClasses(clazz)) {
				obj = cls.newInstance();
			}
		} catch (InstantiationException e) {
			Logger.error(e, "Dao実装クラスの取得に失敗しました。");
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			Logger.error(e, "Dao実装クラスの取得に失敗しました。");
			throw new RuntimeException(e);
		}
		return clazz.cast(obj);
	}
	
	/**
	 * トランザクションを開始する
	 */
	@Override
	public void beforeInvocation() {
		getLocalTransaction().begin();
	}
	
	/**
	 * トランザクションをコミットする
	 */
	@Override
	public void afterInvocation() {
		getLocalTransaction().commit();
	}
	
	/**
	 * トランザクションをロールバックする
	 * 
	 * @param e
	 */
	@Override
	public void onInvocationException(Throwable e) {
		getLocalTransaction().rollback();
	}
	
	/**
	 * ConfigクラスからLocalTransactionを取得する
	 */
	private LocalTransaction getLocalTransaction() {
		LocalTransaction localTransaction = null;
		try {
			Class clazz = Play.classloader.getAssignableClasses(Config.class).get(0);
			localTransaction = (LocalTransaction) Java.invokeStatic(clazz, "getLocalTransaction");
		} catch (Exception e) {
			Logger.error(e, "LocalTransactionの取得に失敗しました。");
			throw new RuntimeException(e);
		}
		return localTransaction;
	}
}