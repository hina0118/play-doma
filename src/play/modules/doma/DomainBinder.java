package play.modules.doma;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import org.seasar.doma.Domain;

import play.Logger;
import play.data.binding.TypeBinder;
import play.utils.Java;

/**
 * HTTPリクエストパラメータをDomainクラスにバインドする
 */
public class DomainBinder implements TypeBinder<Object> {
	
	/**
	 * publicコンストラクタを使ってインスタンス化<br>
	 * publicコンストラクタが見つからない場合はFactoryMethodを使ってインスタンス化する
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
			Logger.debug("FactoryMethodでDomainを生成します。");
			domain = Java.invokeStatic(actualClass, annotation.factoryMethod(), value);
		}
		return domain;
	}
}
