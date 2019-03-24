package com.sinosoft.claim.resource.dtofactory.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WfModelUse模板使用设置的数据访问对象类<br>
 * 创建于 2004-08-10 10:49:22.112<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfModelUse extends DBSwfModelUseBase{
    private static Log logger = LogFactory.getLog(DBSwfModelUse.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfModelUse(DBManager dbManager){
        super(dbManager);
    }

/**
 * 插入多条数据
 * @param collection collection
 * @throws Exception
 */
 
 /*
   public void insertAll(Collection collection) throws Exception{
    int    modelNo  = 0 ; //模板号
    String riskCode = "" ;//险种代码
    String comCode  = "" ;//部门代码
    String conditions = "" ;
    
    ArrayList arrayList = (ArrayList)collection;

    insertBatch(collection);

 }

*/
    public void insertBatch(Collection collection)throws Exception
    {

        String mainStatement = "" ;
        String statement = "";
        String deleteStatement = "" ;
        ArrayList arrayList = (ArrayList)collection;
        for (int i=0;i<arrayList.size();i++)
        {
          SwfModelUseDto swfModelUseDto = (SwfModelUseDto) arrayList.get(i);
          mainStatement = " Insert Into SwfModelUse (" +
                    " ModelNo," +
                    " RiskCode," +
                    " ComCode," +
                    " ModelStatus,ModelType" +
                    " Flag)";
                statement = mainStatement + " values(" + swfModelUseDto.getModelNo() + ",'"
                                                       + swfModelUseDto.getRiskCode() + "','"
                                                       + swfModelUseDto.getComCode() + "','"
                                                       + swfModelUseDto.getModelStatus() + "','"
                                                        + swfModelUseDto.getModelType() + "','"
                                                       +swfModelUseDto.getModelStatus() + "')" ;


                dbManager.executeUpdate(statement) ;


        }

        //dbManager.executePreparedBatchUpdate() ;
    }

    public void deleteBatch(String riskCode,String comCode) throws Exception
    {
      String statement = "" ;

      statement = " Delete From SwfModelUse" +
                                     " Where " +
                         " RiskCode = '"+riskCode+ "' And " +
                         " ComCode = '" +comCode + "'";
      dbManager.executeUpdate(statement)  ;

    }

    public void deleteAllBatch(Collection collection) throws Exception
    {
      ArrayList arrayList = (ArrayList)collection;
      int modelNo = 0;
      String riskCode = "" ;
      String comCode = "" ;
      String conditions = "" ;
      for (int i=0;i<arrayList.size();i++)
      {
        SwfModelUseDto swfModelUseDto = (SwfModelUseDto) arrayList.get(i);
        modelNo = swfModelUseDto.getModelNo() ;
        riskCode= swfModelUseDto.getRiskCode();
        comCode = swfModelUseDto.getComCode() ;
        conditions = "delete from swfmodeluse where riskcode='" + riskCode + "' and comcode ='" + comCode + "'";
        //deleteByConditions(conditions);
        dbManager.executeUpdate(conditions) ;

      }

    }
}
