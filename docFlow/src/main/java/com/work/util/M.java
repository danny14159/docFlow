package com.work.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


abstract public class M {
	
	public static M make(String key,Object value){
		DefaultMapper mapper = new DefaultMapper();
		return mapper.put(key, value);
	}
	public static M make(){
		DefaultMapper mapper = new DefaultMapper();
		return mapper;
	}
	
	public abstract M put(String key,Object value);
	
	public abstract Map<String,Object> asMap();
	
	/**将javaBean中不为null的属性加到map中
	 * @param obj
	 * @return
	 */
	public abstract M joinBean(Object obj);
	
	/**将pageNum和pageSize转化成offset和row值加入map
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public static M pageTransfer(Integer pageNum,Integer pageSize){
		M mapper = M.make();
		if(null != pageNum && null!=pageSize){
			mapper.put("rows", pageSize);
			mapper.put("offset", pageSize*(pageNum-1));
		}
		return mapper;
	}
}
class DefaultMapper extends M{
	private Map<String,Object> map = new HashMap<String,Object>();
	
	public M put(String key,Object value){
		map.put(key, value);
		return this;
	}
	
	public Map<String,Object> asMap(){
		return map;
	}

	@Override
	public M joinBean(Object obj) {
		Class<?> clz = obj.getClass();
		Method[] mds = clz.getMethods();
		for(Method m:mds){
			if(m.getName().startsWith("get")){
				String field =m.getName().substring(3);
				String fieldName = (field.charAt(0)+"").toLowerCase()+field.substring(1);
				//System.out.println(fieldName);
				try {
					Object f = m.invoke(obj);
					if(f!=null)
						map.put(fieldName, f);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return this;
	}

}
