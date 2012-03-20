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

public class DomaPlugin extends PlayPlugin implements BeanSource {
	@Override
	public void onLoad() {
		Play.javaPath.add(Play.getVirtualFile(".apt_generated"));
	}

	@Override
	public void onApplicationStart() {
		Injector.inject(this);
		DomainBinder binder = new DomainBinder();
		for (Class c : Play.classloader.getAnnotatedClasses(Domain.class)) {
			Binder.register(c, binder);
		}
	}

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
	
	@Override
	public void beforeInvocation() {
		getLocalTransaction().begin();
	}
	
	@Override
	public void afterInvocation() {
		getLocalTransaction().commit();
	}
	
	@Override
	public void onInvocationException(Throwable e) {
		getLocalTransaction().rollback();
	}
	
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