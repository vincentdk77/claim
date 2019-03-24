/****************************************************************************
 * DESC       ：险种代码解析公共类
 * Author     :  项目组  孙兆云
 * CREATEDATE ：2005-09-130
 * MODIFYLIST ：Name       Date            Reason/Contents
 * DESCRIPTION:此类是主要为解析险种代码用的，以后所有要解析险种代码的地方都统一调用此类
 *             有新的需求只要在此类中加入相应的方法即可
 *          ------------------------------------------------------
 *************************************************************************/

package com.sinosoft.claim.Tools;

	  
  	public    class RiskCodeTools {
		
		/**获取险种代码的0-2位，也就是前两位
		 * @author  项目组 孙兆云
		 * @DESC    专用 根据险种代码解析获得险类代码
		 * @param RiskCode 险种代码
		 * @return 险类代码
		 * @throws Exception
		 */
		public   static  String getClassCode(String RiskCode) throws Exception
		{
			Exception exception = null;
			String riskCode = RiskCode;
			String classCode= "";
			
			if(riskCode==null){
				throw exception;
			}
			
			if(riskCode.trim().equals(""))
			{
				throw exception;
			}
			if(riskCode.length()<=0||riskCode.length()<4)
			{
				throw exception;
			}
			
			classCode = riskCode.substring(0,2);
			return classCode;
		}
		
	    /**
	     *  获取险种代码的第一位
	     *   项目组专用
	     *   项目组  孙兆云
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  10:14:28
	     *  @param RiskCode 险种代码 
	     *  @return
	     *  @throws Exception
	     */
		public static String getFirstCharacter(String RiskCode) throws Exception
		{
			Exception exception = null;
			String riskCode = RiskCode;
			String FirstCharacter= "";
			
			if(riskCode==null){
				throw exception;
			}
			
			if(riskCode.trim().equals(""))
			{
				throw exception;
			}
			FirstCharacter = riskCode.substring(0,1);
			return FirstCharacter;
		}
	
	    /**
	     *  获取险种代码的前三位
	     *   项目组专用
	     *   项目组  孙兆云
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  10:14:28
	     *  @param RiskCode 险种代码 
	     *  @return
	     *  @throws Exception
	     */
		public static String getThree(String RiskCode) throws Exception
		{
			Exception exception = null;
			String riskCode = RiskCode;
			String Three= "";
			
			if(riskCode==null){
				throw exception;
			}
			
			if(riskCode.trim().equals(""))
			{
				throw exception;
			}
			Three = riskCode.substring(0,3);
			return Three;
		}

	    /**
	     *  获取险种代码的前四位
	     *   项目组专用
	     *   项目组  孙兆云
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  10:14:28
	     *  @param RiskCode 险种代码 
	     *  @return
	     *  @throws Exception
	     */
		public static String getFourth(String RiskCode) throws Exception
		{
			Exception exception = null;
			String riskCode = RiskCode;
			String Fourth= "";
			
			if(riskCode==null){
				throw exception;
			}
			
			if(riskCode.trim().equals(""))
			{
				throw exception;
			}
			if(riskCode.length()<4)
			{
				throw exception;
			}
			Fourth = riskCode.substring(0,4);
			return Fourth;
		}
		
		 /**
	     *  判断险种是不是责任险，是的话返回 true 
	     *   项目组专用
	     *   项目组  孙兆云
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  15:04:42
	     *  @param RiskCode
	     *  @return 
	     */
		public static boolean IsLiab(String RiskCode) throws Exception
		{
			
			boolean returnboolean = false;
			String classCode = getClassCode(RiskCode);
			if(classCode.equals("04"))
			{
				returnboolean = true;
			}
			
			return returnboolean;
			
		}
		
	}