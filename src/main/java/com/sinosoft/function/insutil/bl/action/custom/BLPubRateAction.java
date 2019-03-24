/**
 * <p>Title: BLPubRateAction</p>
 * <p>Description: 实现和率有关的方法</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author Liuguoan
 * @version 1.0
 */
package com.sinosoft.function.insutil.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.function.insutil.dto.domain.PrpDexchDto;
import com.sinosoft.function.insutil.dto.domain.PrpDshortRateDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDexch;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDshortRate;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPubRateAction
{
  /**
    * 构造方法
   */
   public BLPubRateAction()
   {
  }

  /**
   * 获得距给定日期最近一天的两种币别的直接兑换率
   * @param dbManager 数据库连接池
   * @param baseCurrency 基准币别
   * @param exchCurrency 兑换币别
   * @param exchDate 兑换日期 标准的年月日格式
   * @return exchangeRate 兑换率
   * @throws UserExcetion,Exception
   */
  public static double getStraightExchangeRate(DBManager dbManager,String baseCurrency,
                                               String exchCurrency,DateTime exchDate)
    throws Exception
  {
    PrpDexchDto prpDexchDto = new PrpDexchDto();
    double dblExchangeRate = 0d;
    String strWherePart = "";
    int intCount = 0;
    DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
    DateTime maxExchDate = new DateTime();

    strWherePart = " BaseCurrency = '" + baseCurrency.trim() + "'" +
                   " AND ExchCurrency = '" + exchCurrency.trim() + "'"  +
                   " AND ExchDate <= '" +  exchDate + "'" +
                   " AND ExchRate IS NOT NULL ";
    intCount = dbPrpDexch.getCount(strWherePart);
    if (intCount == 0)
    {
      dblExchangeRate = 0;
      return dblExchangeRate;
    }
    maxExchDate = dbPrpDexch.getMaxExchangeDate(strWherePart);
    prpDexchDto = dbPrpDexch.findByPrimaryKey(maxExchDate,baseCurrency,exchCurrency);//依赖resource包
    if (prpDexchDto == null )
    {
      dblExchangeRate = 0;
      return dblExchangeRate;
    }
    dblExchangeRate = Double.parseDouble(DataUtils.nullToZero(String.valueOf(prpDexchDto.getExchRate()))); //依赖common包
    return dblExchangeRate;
  }
  /**
   * 短期费率方式为按月的短期费率
   * @param dbManager 数据库连接池
   * @param startDate 起始日期
   * @param startHour 起始小时
   * @param endDate   终止日期
   * @param endHour   终止小时
   * @return shortRate 短期费率
   * @throws Exception
   */
  public static double getMonthShortRate(DBManager dbManager,String riskCode,
      DateTime startDate,int startHour,DateTime endDate,int endHour)
    throws Exception
  {
    double[] arrMonthRate = new double[]{0,10,20,30,40,50,60,70,80,85,90,95,100};
    double dblShortRate = 0d;
    DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
    PrpDshortRateDto prpDshortRateDto = new PrpDshortRateDto();
    int intYear = 0;
    int intMonth = 0;
    int intResult = 0; 

    intMonth = DateTime.intervalMonth(startDate,startHour,endDate,endHour);
    System.out.println("intMonth is " + intMonth);
    intYear = intMonth/12;
    intMonth = intMonth%12;

    //获取当前险种的短期费率
     prpDshortRateDto = dbPrpDshortRate.findByPrimaryKey(riskCode,intMonth);
    if (prpDshortRateDto != null )  //获取不到
    {
      //从短期费率表中获取到
      dblShortRate = intYear * 100 + prpDshortRateDto.getShortRate();
      return dblShortRate;
    }
    //获取不到则返回缺省的短期费率
    dblShortRate = intYear * 100 + arrMonthRate[intMonth];
    return dblShortRate;
  }
  
  
 
  public Collection getExchOfMaxDate(DBManager dbManager,String currDate)
    throws Exception
  {
        Collection prpdexchRateDtoList = new ArrayList();
        Collection prpdexchRateDtoListNew = new ArrayList();
        PrpDexchDto prpDexchDto;
        PrpDexchDto prpDexchDto1;
        prpdexchRateDtoList = new DBPrpDexch(dbManager).getExchOfMaxDate(currDate);
        Iterator itprpdexch = prpdexchRateDtoList.iterator();
        //确定兑换率
        while (itprpdexch.hasNext())
        {
        	prpDexchDto = (PrpDexchDto)itprpdexch.next();
        	prpDexchDto1 =  new DBPrpDexch(dbManager).findByPrimaryKey(prpDexchDto.getExchDate(),
        			            prpDexchDto.getBaseCurrency(),
					               prpDexchDto.getExchCurrency());
					prpdexchRateDtoListNew.add(prpDexchDto1);               
        }    
        return prpdexchRateDtoListNew;
  }
}
