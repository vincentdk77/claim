package com.sinosoft.claimzy.util;

import java.util.Vector;


import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.error.UserException;

public class BLPrpAgriMaxUse {
	 private Vector schemas = new Vector();
	    /**
	     * ���캯��
	     */       
	    public BLPrpAgriMaxUse(){
	    }

	    /**
	     *��ʼ����¼
	     *@param ��
	     *@return ��
	     *@throws Exception
	     */
	    public void initArr() throws Exception
	    {
	       schemas = new Vector();
	     }
	    /**
	     *����һ��PrpMaxUseSchema��¼
	     *@param iPrpMaxUseSchema PrpMaxUseSchema
	     *@throws Exception
	     */
	    public void setArr(PrpAgriMaxUseSchema iPrpAgriMaxUseSchema) throws Exception
	    {
	       try
	       {
	         schemas.add(iPrpAgriMaxUseSchema);
	       }
	       catch(Exception e)
	       {
	         throw e;
	       }
	     }
	    /**
	     *�õ�һ��PrpAgriMaxUseSchema��¼
	     *@param index �±�
	     *@return һ��PrpAgriMaxUseSchema����
	     *@throws Exception
	     */
	    public PrpAgriMaxUseSchema getArr(int index) throws Exception
	    {
	     PrpAgriMaxUseSchema prpAgriMaxUseSchema = null;
	       try
	       {
	        prpAgriMaxUseSchema = (PrpAgriMaxUseSchema)this.schemas.get(index);
	       }
	       catch(Exception e)
	       {
	         throw e;
	       }
	       return prpAgriMaxUseSchema;
	     }
	    /**
	     *ɾ��һ��PrpMaxUseSchema��¼
	     *@param index �±�
	     *@throws Exception
	     */
	    public void remove(int index) throws Exception
	    {
	       try
	       {
	         this.schemas.remove(index);
	       }
	       catch(Exception e)
	       {
	         throw e;
	       }
	     }
	    /**
	     *�õ�schemas��¼��
	     *@return schemas��¼��
	     *@throws Exception
	     */
	    public int getSize() throws Exception
	    {
	        return this.schemas.size();
	    }
	    /**
	     *���ղ�ѯ�����õ�һ���¼�������������¼����schemas����
	     *@param iWherePart ��ѯ����(���������־�)
	     *@throws UserException
	     *@throws Exception
	     */
	     
	    public void query(String iWherePart) throws UserException,Exception
	    {
	       this.query(iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
	    }
	    /**
	     *���ղ�ѯ�����ͼ�¼�����Ƶõ�һ���¼�������������¼����schemas����
	     *@param iWherePart ��ѯ����(���������־�)
	     *@param iLimitCount ��¼������(iLimitCount=0: ������)
	     *@throws UserException
	     *@throws Exception
	     */
	     
	    public void query(String iWherePart,int iLimitCount) throws UserException,Exception
	    {
	      String strSqlStatement = "";
	      DBPrpAgriMaxUse dbMaxUse = new DBPrpAgriMaxUse();
	      
	      if (iLimitCount > 0 && dbMaxUse.getCount(iWherePart) > iLimitCount)
	      {
	        throw new UserException(-98,-1003,"BLPrpMaxUse.query");
	      }
	      else
	      {
	        initArr();
	        strSqlStatement = " SELECT * FROM PrpMaxUse WHERE " + iWherePart; 
	        schemas = dbMaxUse.findByConditions(strSqlStatement);
	      }
	    }
	    /**
	     * ������
	     * @param args �����б�
	     */
	    public static void main(String[] args){
	        //add test code here
	    }
}
