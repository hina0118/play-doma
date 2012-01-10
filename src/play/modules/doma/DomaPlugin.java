package play.modules.doma;

import play.Play;
import play.PlayPlugin;
import play.inject.BeanSource;
import play.inject.Injector;

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
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return clazz.cast(obj);
	}
}