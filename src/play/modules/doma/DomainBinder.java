package play.modules.doma;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import org.seasar.doma.Domain;

import play.Logger;
import play.data.binding.TypeBinder;
import play.utils.Java;

/**
 * HTTP���N�G�X�g�p�����[�^��Domain�N���X�Ƀo�C���h����
 */
public class DomainBinder implements TypeBinder<Object> {
	
	/**
	 * public�R���X�g���N�^���g���ăC���X�^���X��<br>
	 * public�R���X�g���N�^��������Ȃ��ꍇ��FactoryMethod���g���ăC���X�^���X������
	 * 
	 * @param name
	 * @param annotations
	 * @param value
	 * @param actualClass
	 * @param genericType
	 * @return Object
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object bind(String name, Annotation[] annotations, String value,
			Class actualClass, Type genericType) throws Exception {
		if (value == null || value.length() == 0) {
			return null;
		}
		Object domain = null;
		Domain annotation = (Domain) actualClass.getAnnotation(Domain.class);
		try {
			Class type = annotation.valueType();
			Constructor<?> constructor = actualClass.getConstructor(type);
			domain = constructor.newInstance(value);
		} catch(NoSuchMethodException e) {
			Logger.debug("FactoryMethod��Domain�𐶐����܂��B");
			domain = Java.invokeStatic(actualClass, annotation.factoryMethod(), value);
		}
		return domain;
	}
}
