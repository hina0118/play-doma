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
 * Doma�A�g�p�̃v���O�C��
 */
public class DomaPlugin extends PlayPlugin implements BeanSource {
	
	/**
	 * Play���[�h���̏���<br>
	 * apt�Ő��������\�[�X�t�@�C���̏o�͐��path�ɒǉ�����
	 */
	@Override
	public void onLoad() {
		Play.javaPath.add(Play.getVirtualFile(".apt_generated"));
	}

	/**
	 * �A�v���P�[�V�����J�n���̏���<br>
	 * Controller�N���X��Dao�����N���X��Inject����<br>
	 * DomainBinder�N���X��Domain�N���X�̐������o�^����
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
	 * Dao�����N���X��Inject
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
			Logger.error(e, "Dao�����N���X�̎擾�Ɏ��s���܂����B");
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			Logger.error(e, "Dao�����N���X�̎擾�Ɏ��s���܂����B");
			throw new RuntimeException(e);
		}
		return clazz.cast(obj);
	}
	
	/**
	 * �g�����U�N�V�������J�n����
	 */
	@Override
	public void beforeInvocation() {
		getLocalTransaction().begin();
	}
	
	/**
	 * �g�����U�N�V�������R�~�b�g����
	 */
	@Override
	public void afterInvocation() {
		getLocalTransaction().commit();
	}
	
	/**
	 * �g�����U�N�V���������[���o�b�N����
	 * 
	 * @param e
	 */
	@Override
	public void onInvocationException(Throwable e) {
		getLocalTransaction().rollback();
	}
	
	/**
	 * Config�N���X����LocalTransaction���擾����
	 */
	private LocalTransaction getLocalTransaction() {
		LocalTransaction localTransaction = null;
		try {
			Class clazz = Play.classloader.getAssignableClasses(Config.class).get(0);
			localTransaction = (LocalTransaction) Java.invokeStatic(clazz, "getLocalTransaction");
		} catch (Exception e) {
			Logger.error(e, "LocalTransaction�̎擾�Ɏ��s���܂����B");
			throw new RuntimeException(e);
		}
		return localTransaction;
	}
}