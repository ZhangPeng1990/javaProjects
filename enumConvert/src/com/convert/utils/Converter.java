package com.convert.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import uk.co.argylesoftware.sys.lang.enums.BaseEnum;
import uk.co.argylesoftware.sys.lang.enums.EnumUtils;
import uk.co.argylesoftware.sys.lang.enums.Country;

@SuppressWarnings("all")
public class Converter implements GenericConverter {

	@Test
	public void getGetByStr(){
		
		String str = "SCT";
		TypeDescriptor targetType = TypeDescriptor.valueOf(Country.class);
		Object o = this.myConvert(str, targetType);
		
	}
	
	public Object myConvert(Object source, TypeDescriptor targetType){
		
		List<Class> clazzs = ClassUtils.getAllClassByInterface(BaseEnum.class);
		System.out.println("找到实现 BaseEnum接口的类" + clazzs.size() + "个");
		for(Class clazz : clazzs){
			if (targetType.getObjectType().equals(clazz))
			{
				Object code;
				try {
					code = this._getInteger(source);
				} catch (NumberFormatException e) {
					code = this._getString(source);
				}
				Object enumObject = EnumUtils.getByCode(code, clazz);
				if(enumObject != null){
					System.out.println("根据" + source.toString() + "匹配到的枚举对象是：" + enumObject.getClass().getName());
				}else{
					System.out.println("根据" + source.toString() + "未匹配到枚举对象");
				}
				return enumObject;
			}
		}
		
		return null;
	}
	
	@Override
	public Set<ConvertiblePair> getConvertibleTypes()
	{
		Set<ConvertiblePair> pairs = new HashSet<GenericConverter.ConvertiblePair>();
		
		List<Class> clazzs = ClassUtils.getAllClassByInterface(BaseEnum.class);
		System.out.println("找到implements BaseEnum接口的类" + clazzs.size() + "个");
		
		for(Class clazz : clazzs){
			pairs.add(new ConvertiblePair(String.class, clazz));
		}
		
		return pairs;
	}
	
	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType)
	{
//		if (targetType.getObjectType().equals(Location.class))
//		{
//			return EnumUtils.getByCode(this._getString(source),Location.class);
//		}
//		if (targetType.getObjectType().equals(YesNo.class))
//		{
//			return EnumUtils.getByCode(this._getInteger(source),YesNo.class);
//		}
		return null;
	}
	
	private Object _getInteger(Object source) throws NumberFormatException 
	{
		String strSource = (String)source;
		if (!StringUtils.isEmpty(strSource) && !StringUtils.isBlank(strSource))
		{
			return Integer.parseInt(source.toString());
		}
		return null;
	}
	
	private Object _getString(Object source)
	{
		String strSource = (String)source;
		if (!StringUtils.isEmpty(strSource) && !StringUtils.isBlank(strSource))
		{
			return strSource;
		}
		return null;
	}

}
