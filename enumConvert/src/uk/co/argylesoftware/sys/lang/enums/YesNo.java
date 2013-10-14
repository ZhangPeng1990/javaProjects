package uk.co.argylesoftware.sys.lang.enums;

import uk.co.argylesoftware.sys.lang.enums.BaseEnum;

/**
 * <strong>YesNo</strong><br>
 * Yes/No 通用<br> 
 * <strong>Create on : 2012-2-6<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>Ecointel v1.0.0</strong><br>
 */
public enum YesNo implements BaseEnum<Integer>
{
	Yes("Yes",1),No("No",0);
	
	private String desc;
	private Integer code;
	
	private YesNo(String desc,Integer code)
	{
		this.desc = desc;
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		// TODO Auto-generated method stub
		return this.desc;
	}
	
	public static YesNo bool2YesNo(boolean flag)
	{
		if (flag)
		{
			return YesNo.Yes;
		}
		return YesNo.No;
	}
	
	public boolean isBoolValue()
	{
		if (this.equals(YesNo.Yes))
		{
			return true;
		}
		return false;
	}
	
}
