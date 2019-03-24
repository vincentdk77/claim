package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.function.insutil.dto.domain.PrpDexchDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdexch�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br> 
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDexch extends DBPrpDexchBase{
    private static Log log = LogFactory.getLog(DBPrpDexch.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDexch(DBManager dbManager){
        super(dbManager);
    }


   /**
   * ��ѯ����ģ����ѯ���������һ�����
   * @param wherePart ��ѯ����
   * @return �������������һ�����
   * @throws SQLException,Exception
   */
  public DateTime getMaxExchangeDate(String wherePart)
      throws SQLException,Exception
  {
    DateTime exchDate = new DateTime();
    String statement = " SELECT MAX(ExchDate) ExchDate FROM PrpDexch Where " + wherePart;
    log.debug(statement);
    dbManager.prepareStatement(statement);
    ResultSet resultSet = dbManager.executePreparedQuery();
    if(resultSet.next())
    {
      exchDate = dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1);
    }
    resultSet.close();
    log.info("DBPrpDexch.getMaxExchangeDate success!");
    return exchDate;
  }
  
  public Collection getExchOfMaxDate(String currDate)
    throws Exception
  {
  	Collection prpdexchRateDtoList = new ArrayList();
  	ResultSet resultSet = null;
  	String statement = " select max(exchDate),baseCurrency,exchCurrency from prpdexch where exchDate <= SINOSOFT_to_date('"+currDate+"','YYYY-MM-DD') group by basecurrency,exchcurrency ";   
    resultSet = dbManager.executeQuery(statement);
    
    while(resultSet.next())
    {
        try
        {
        	PrpDexchDto  prpDexchDto = new PrpDexchDto();
        	prpDexchDto.setExchDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1));
        	prpDexchDto.setBaseCurrency(dbManager.getString(resultSet,2));
        	prpDexchDto.setExchCurrency(dbManager.getString(resultSet,3));
           	prpdexchRateDtoList.add(prpDexchDto);
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    resultSet.close();
    return prpdexchRateDtoList;
  }
  
  
  
  
  
}
