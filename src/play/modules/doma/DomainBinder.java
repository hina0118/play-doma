package play.modules.doma;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import org.seasar.doma.Domain;

import play.Logger;
import play.data.binding.TypeBinder;
import play.utils.Java;

public class DomainBinder implements TypeBinder<Object> {
	
	@Override
	@SuppressWarnings("unchecked")
	public Object bind(String name, Annotation[] annotations, String value,
			Class actualClass, Type genericType) throws Exception {
		Object domain = null;
		Domain annotation = (Domain) actualClass.getAnnotation(Domain.class);
		try {
			Class type = annotation.valueType();
			Constructor<?> constructor = actualClass.getConstructor(type);
			domain = constructor.newInstance(value);
		} catch(NoSuchMethodException e) {
			Logger.debug("FactoryMethodÇ≈DomainÇê∂ê¨ÇµÇ‹Ç∑ÅB");
			domain = Java.invokeStatic(actualClass, annotation.factoryMethod(), value);
		}
		return domain;
	}
}
