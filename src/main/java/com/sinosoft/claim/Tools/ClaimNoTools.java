/****************************************************************************
 * DESC       ：赔案号工具类
 * Author     :  项目组  孙兆云
 * CREATEDATE ：2005-9-30    15:48:29
 * MODIFYLIST ：dubang    2005-9-30 15:48:29          
 * Reason/Contents:  项目组专用
 * DESCRIPTION:
 *          ------------------------------------------------------
 ****************************************************************************/

package com.sinosoft.claim.Tools;

public class ClaimNoTools {
	
	 public static String GetRiskCode(String claimNo) throws Exception
	 {
		 Exception exception = null;
			String ClaimNo = claimNo;
			String riskcode= "";
			
			if(ClaimNo==null){
				throw exception;
			}
			
			if(ClaimNo.trim().equals(""))
			{
				throw exception;
			}
		   
			riskcode = ClaimNo.substring(1,5);
			return riskcode;
	 } 

}
