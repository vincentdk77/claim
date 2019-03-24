/****************************************************************************
 * DESC       �����ִ������������
 * Author     :  ��Ŀ��  ������
 * CREATEDATE ��2005-09-130
 * MODIFYLIST ��Name       Date            Reason/Contents
 * DESCRIPTION:��������ҪΪ�������ִ����õģ��Ժ�����Ҫ�������ִ���ĵط���ͳһ���ô���
 *             ���µ�����ֻҪ�ڴ����м�����Ӧ�ķ�������
 *          ------------------------------------------------------
 *************************************************************************/

package com.sinosoft.claim.Tools;

	  
  	public    class RiskCodeTools {
		
		/**��ȡ���ִ����0-2λ��Ҳ����ǰ��λ
		 * @author  ��Ŀ�� ������
		 * @DESC    ר�� �������ִ����������������
		 * @param RiskCode ���ִ���
		 * @return �������
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
	     *  ��ȡ���ִ���ĵ�һλ
	     *   ��Ŀ��ר��
	     *   ��Ŀ��  ������
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  10:14:28
	     *  @param RiskCode ���ִ��� 
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
	     *  ��ȡ���ִ����ǰ��λ
	     *   ��Ŀ��ר��
	     *   ��Ŀ��  ������
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  10:14:28
	     *  @param RiskCode ���ִ��� 
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
	     *  ��ȡ���ִ����ǰ��λ
	     *   ��Ŀ��ר��
	     *   ��Ŀ��  ������
	     *  sunzhaoyun@sinosoft.com.cn  
	     *  dubang  2005-9-30  10:14:28
	     *  @param RiskCode ���ִ��� 
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
	     *  �ж������ǲ��������գ��ǵĻ����� true 
	     *   ��Ŀ��ר��
	     *   ��Ŀ��  ������
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