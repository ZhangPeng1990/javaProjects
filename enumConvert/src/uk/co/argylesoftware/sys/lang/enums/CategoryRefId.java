/**
 * 
 */
package uk.co.argylesoftware.sys.lang.enums;

import uk.co.argylesoftware.sys.lang.enums.BaseEnum;

/**
 * @author peng.shi
 */
public enum CategoryRefId implements BaseEnum<String>
{
	Hour24News("HOUR_24_NEWS","24 hours news");
	
	private String desc;
	private String code;
	
	private CategoryRefId(String code,String desc)
	{
		this.desc = desc;
		this.code = code;
	}
	@Override
	public String getCode()
	{
		return this.code;
	}

	@Override
	public String getDesc()
	{
		return this.desc;
	}
}
