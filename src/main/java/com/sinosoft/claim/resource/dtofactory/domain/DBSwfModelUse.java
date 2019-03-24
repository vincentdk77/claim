package com.sinosoft.claim.resource.dtofactory.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WfModelUseģ��ʹ�����õ����ݷ��ʶ�����<br>
 * ������ 2004-08-10 10:49:22.112<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfModelUse extends DBSwfModelUseBase{
    private static Log logger = LogFactory.getLog(DBSwfModelUse.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfModelUse(DBManager dbManager){
        super(dbManager);
    }

/**
 * �����������
 * @param collection collection
 * @throws Exception
 */
 
 /*
   public void insertAll(Collection collection) throws Exception{
    int    modelNo  = 0 ; //ģ���
    String riskCode = "" ;//���ִ���
    String comCode  = "" ;//���Ŵ���
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
