package play.modules.doma;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.tx.LocalTransaction;

import play.Logger;
import play.Play;
import play.PlayPlugin;
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
	}

	@Override
	public <T> T getBeanOfType(Class<T> clazz) {
		Object obj = null;
		try {
			for (Class cls : Play.classloader.getAssignableClasses(clazz)) {
				if (cls.getName().equals(clazz.getName() + "Impl")) {
					obj = cls.newInstance();
				}
			}
		} catch (InstantiationException e) {
			Logger.error(e, "DaoÇÃéÊìæÇ…é∏îsÇµÇ‹ÇµÇΩÅB");
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			Logger.error(e, "DaoÇÃéÊìæÇ…é∏îsÇµÇ‹ÇµÇΩÅB");
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
			Class clazz = Play.classloader.getAssignableClasses(DomaAbstractConfig.class).get(0);
			localTransaction = (LocalTransaction) Java.invokeStatic(clazz, "getLocalTransaction");
		} catch (Exception e) {
			Logger.error(e, "LocalTransactionÇÃéÊìæÇ…é∏îsÇµÇ‹ÇµÇΩÅB");
			throw new RuntimeException(e);
		}
		return localTransaction;
	}
}