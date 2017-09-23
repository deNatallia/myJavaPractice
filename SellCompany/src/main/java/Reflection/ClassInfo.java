package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import com.roxoft.sellcompany.models.shop.OnlineShop;

public class ClassInfo {

	public static void main(String[] args){
		OnlineShop www = new OnlineShop();
		Class<? extends OnlineShop> c = www.getClass();
//		Class<OnlineShop> c = OnlineShop.class;
		String s = c.getSimpleName();
		
		Class<?> superClass = c.getSuperclass();
		String sc = superClass.getSimpleName();
		
		int mods = c.getModifiers();
		
		System.out.println(Modifier.toString(mods) + " " + s + " extends " + sc);

		
		Class<?>[] interfaces = c.getInterfaces();
		for (Class<?> cInterface: interfaces){
			System.out.println(cInterface.getName());
		}
		
		System.out.println("Have fields: ");
		
		Field[] cfields = c.getDeclaredFields();
		for (Field field : cfields){
			Class<?> fieldType = field.getType();
			System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getName() + " (" + fieldType.getName()+")");
		}
		
		System.out.println("Constructors: ");
		
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor constr : constructors){
			System.out.println(Modifier.toString(constr.getModifiers()) + " " + c.getSimpleName() + "(" );
//			Class[] paramTypes = constr.getParameterTypes();
//			for (Class paramT : paramTypes){
//				System.out.println(paramT.getName());
//			}
			for (Parameter p:constr.getParameters()){
				System.out.println(p.getType().getName());
			}
		}
		
		System.out.println("Have methods: ");
		
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods){
			int mmods = method.getModifiers();
			Class[] paramTypes = method.getParameterTypes();
			System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getName() + "() returns " + method.getReturnType().getName());
		}
		
		//method call
		try {
			Class[] paramT = new Class[] {};
			Method method = c.getDeclaredMethod("sell",paramT);
			Object[] ar = new Object[]{};
			try {
				System.out.println(method.invoke(www, ar));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
}
