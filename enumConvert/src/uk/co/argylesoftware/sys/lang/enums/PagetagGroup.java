/**
 * 
 */
package uk.co.argylesoftware.sys.lang.enums;

import uk.co.argylesoftware.sys.lang.enums.BaseEnum;

/**
 * @author peng.shi
 */
public enum PagetagGroup implements BaseEnum<String>
{
	
	User_Management("User Management"),
	
	Energy_Auditor("Energy Auditor Management"),
	
	PLUG_User("PLUG User"),
	
	/**
	 * 系统配置
	 */
	SystemConfig("SystemConfig"),
	
	/**
	 * 户主
	 */
	HomeOwner("HomeOwner"),
	
	/**
	 * QA
	 */
	QA("QA"),
	
	/**
	 * 新闻菜单
	 */
	News("News, Events & Notice"),
	
	/**
	 * 权限菜单
	 */
	Authority("Authority");

	private String desc;
	private PagetagGroup(String desc)
	{
		this.desc = desc;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.argylesoftware.sys.lang.enums.BaseEnum#getCode()
	 */
	@Override
	public String getCode()
	{
		return this.toString();
	}

	/* (non-Javadoc)
	 * @see uk.co.argylesoftware.sys.lang.enums.BaseEnum#getDesc()
	 */
	@Override
	public String getDesc()
	{
		return this.desc;
	}
}
