package com.sinosoft.claimzy.util;

import java.util.Vector;


import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.error.UserException;

public class BLPrpAgriMaxUse {
	 private Vector schemas = new Vector();
	    /**
	     * 构造函数
	     */       
	    public BLPrpAgriMaxUse(){
	    }

	    /**
	     *初始化记录
	     *@param 无
	     *@return 无
	     *@throws Exception
	     */
	    public void initArr() throws Exception
	    {
	       schemas = new Vector();
	     }
	    /**
	     *增加一条PrpMaxUseSchema记录
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
	     *得到一条PrpAgriMaxUseSchema记录
	     *@param index 下标
	     *@return 一个PrpAgriMaxUseSchema对象
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
	     *删除一条PrpMaxUseSchema记录
	     *@param index 下标
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
	     *得到schemas记录数
	     *@return schemas记录数
	     *@throws Exception
	     */
	    public int getSize() throws Exception
	    {
	        return this.schemas.size();
	    }
	    /**
	     *按照查询条件得到一组记录数，并将这组记录赋给schemas对象
	     *@param iWherePart 查询条件(包括排序字句)
	     *@throws UserException
	     *@throws Exception
	     */
	     
	    public void query(String iWherePart) throws UserException,Exception
	    {
	       this.query(iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
	    }
	    /**
	     *按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
	     *@param iWherePart 查询条件(包括排序字句)
	     *@param iLimitCount 记录数限制(iLimitCount=0: 无限制)
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
	     * 主函数
	     * @param args 参数列表
	     */
	    public static void main(String[] args){
	        //add test code here
	    }
}
