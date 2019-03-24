package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcode通用代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcode extends DBPrpDcodeBase{
    private static Log log = LogFactory.getLog(DBPrpDcode.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcode(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 翻译代码
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String codeType,String codeCode,boolean isChinese) throws Exception
    {
      String codeName  = "" ;
      if(codeType==null||codeCode==null)
      {
        codeName = "" ;
        return codeName;
      }
      else
      {
          if(codeType.equals("")||codeCode.equals(""))
          {
            codeName = "";
            return codeName;
          }
      }
      String statement = "Select * from PrpDcode Where codetype='" + codeType + "' AND codecode='" + codeCode + "'";
      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          codeName = resultSet.getString("codecname");
        }
        else
        {
           codeName = resultSet.getString("codeename");
        }
      }
      resultSet.close();
      log.info("DBPrpDcodde.translate() success!");
      return codeName;

    }
    
    /**
     * 事故原因排序查询
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsReason(String conditions,int pageNo,int rowsPerPage) throws Exception{
        log.debug(conditions);        
        Collection collection = new ArrayList();
        PrpDcodeDto prpDcodeDto = null;
        ResultSet resultSet=null;
        try{
         resultSet = dbManager.executeQuery(conditions);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }
            prpDcodeDto = new PrpDcodeDto();
            prpDcodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpDcodeDto.setCodeCode(dbManager.getString(resultSet,2));
            prpDcodeDto.setCodeCName(dbManager.getString(resultSet,3));
            prpDcodeDto.setCodeEName(dbManager.getString(resultSet,4));
            prpDcodeDto.setNewCodeCode(dbManager.getString(resultSet,5));
            prpDcodeDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDcodeDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDcodeDto);
        }
        log.info("DBPrpDcodeBase.findByConditions() success!");
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(resultSet!=null)
        		resultSet.close();
        }
        return collection;
    }

}
