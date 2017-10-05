package com.roxoft.sellcompany.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import com.roxoft.sellcompany.models.shop.OnlineShop;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ClassInfo {

	private final static Logger LOGGER = LogManager.getLogger(ClassInfo.class);
	
	public static void main(String[] args){
		OnlineShop www = new OnlineShop();
		Class<? extends OnlineShop> c = www.getClass();
//		Class<OnlineShop> c = OnlineShop.class;
		String s = c.getSimpleName();
		
		Class<?> superClass = c.getSuperclass();
		String sc = superClass.getSimpleName();
		
		int mods = c.getModifiers();
		
		LOGGER.info(Modifier.toString(mods) + " " + s + " extends " + sc);

		
		Class<?>[] interfaces = c.getInterfaces();
		for (Class<?> cInterface: interfaces){
			LOGGER.info(cInterface.getName());
		}
		
		LOGGER.info("Have fields: ");
		
		Field[] cfields = c.getDeclaredFields();
		for (Field field : cfields){
			Class<?> fieldType = field.getType();
			LOGGER.info(Modifier.toString(field.getModifiers()) + " " + field.getName() + " (" + fieldType.getName()+")");
		}
		
		LOGGER.info("Constructors: ");
		
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constr : constructors){
			LOGGER.info(Modifier.toString(constr.getModifiers()) + " " + c.getSimpleName() + "(" );
//			Class[] paramTypes = constr.getParameterTypes();
//			for (Class paramT : paramTypes){
//				System.out.println(paramT.getName());
//			}
			for (Parameter p:constr.getParameters()){
				LOGGER.info(p.getType().getName());
			}
		}
		
		LOGGER.info("Have methods: ");
		
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods){
			int mmods = method.getModifiers();
			Class<?>[] paramTypes = method.getParameterTypes();
			LOGGER.info(Modifier.toString(method.getModifiers()) + " " + method.getName() + "() returns " + method.getReturnType().getName());
		}
		
		//method call
		try {
			Method method = c.getDeclaredMethod("sell");
			method.invoke(new OnlineShop());
		} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.info(e.getStackTrace());
		}
	}
	
}
