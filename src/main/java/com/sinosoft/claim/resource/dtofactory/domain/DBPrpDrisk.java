package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是prpdrisk险种代码表的数据访问对象类<br>
 * 创建于 2004-08-25 16:51:29.102<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrisk extends DBPrpDriskBase{
    private static Log log = LogFactory.getLog(DBPrpDrisk.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDrisk(DBManager dbManager){
        super(dbManager);
    }


     /**根据子险种代码得到险种名称
     *
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String riskCode,boolean isChinese) throws Exception
    {
      String codeName  = "" ;
      if(riskCode==null)
      {
        codeName = "" ;
        return codeName;
      }
      else
      {
          if(riskCode.equals(""))
          {
            codeName = "";
            return codeName;
          }
      }
      String statement = "Select * from PrpDrisk Where riskCode='" + riskCode + "'";
      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          codeName = resultSet.getString("riskcname");
        }
        else
        {
           codeName = resultSet.getString("riskename");
        }
      }
      resultSet.close();
      log.info("DBPrpDrisk.translate() success!");
      return codeName;

    }
    /**
     * 按条件查询多条数据(关联prpdclass表进行查询)
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findRiskCodeByConditions(String conditions) throws Exception{
        String statement = "Select k.RiskCode," +
                           " k.RiskCName," +
                           " k.RiskEName," +
                           " k.ClassCode," +
                           " k.Calculator," +
                           " k.EndDateFlag," +
                           " k.RiskFlag," +
                           " k.StartHour," +
                           " k.NewRiskCode," +
                           " k.ValidStatus," +
                           " k.ArticleCode," +
                           " k.ManageFlag," +
                           " k.Flag," +
                           " c.riskcategory From PrpDrisk k," +
                           " PrpDclass c Where c.classcode=k.classcode And " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDriskDto prpDriskDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){

            prpDriskDto = new PrpDriskDto();
            prpDriskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDriskDto.setRiskCName(dbManager.getString(resultSet,2));
            prpDriskDto.setRiskEName(dbManager.getString(resultSet,3));
            prpDriskDto.setClassCode(dbManager.getString(resultSet,4));
            //prpDriskDto.setRiskType(dbManager.getString(resultSet,5));
            prpDriskDto.setCalculator(dbManager.getInt(resultSet,5));
            //prpDriskDto.setCalculateFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setEndDateFlag(dbManager.getString(resultSet,6));
            prpDriskDto.setRiskFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setStartHour(dbManager.getInt(resultSet,8));
            prpDriskDto.setNewRiskCode(dbManager.getString(resultSet,9));
            prpDriskDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDriskDto.setArticleCode(dbManager.getString(resultSet,11));
            prpDriskDto.setManageFlag(dbManager.getString(resultSet,12));
            prpDriskDto.setFlag(dbManager.getString(resultSet,13));
            prpDriskDto.setRiskType(dbManager.getString(resultSet,14));
            collection.add(prpDriskDto);
        }
        resultSet.close();
        log.info("DBPrpDrisk.findRiskCodeByConditions() success!");
        return collection;
    }
}
