/**
 * <p>Title: BLPubRateFacade</p>
 * <p>Description:和率有关的公共类（包括兑换率、短期费率） </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author Liuguoan
 * @version 1.0
 */

package com.sinosoft.function.insutil.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.function.insutil.bl.action.custom.BLPubRateAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPubRateFacade
{
  /**
   * 构造方法
   */
  public BLPubRateFacade()
  {
  }

  /**
   * 获得距给定日期最近一天的两种币别的兑换率
   * @param baseCurrency 基准币别
   * @param exchCurrency 兑换币别
   * @param exchDate 兑换日期 标准的年月日格式
   * @return exchangeRate 兑换率
   * @throws UserExcetion,Exception
   */
  public static double getExchangeRate(String baseCurrency,String exchCurrency,DateTime exchDate)
    throws Exception
  {
    DBManager dbManager = new DBManager();
    double dblExchangeRate = 0d;
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
      dblExchangeRate = getExchangeRate(dbManager,baseCurrency,exchCurrency,exchDate);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return dblExchangeRate;

  }

  /**
   * 获得距给定日期最近一天的两种币别的兑换率
   * 首先获取baseCurrency和exchCurrency的兑换率，
   * 获取不到，则获取exchCurrency和baseCurrency的兑换率；
   * 如果还获取不到，则试着将exchCurrency和baseCurrency分别和美元USD的兑换率；
   * 如果都获取不到，则表示获取不到兑换率，返回0
   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * DateTime exchDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * double exchRate = BLPubRateFacade.getExchangeRate("USD","CNY",exchDate);
   * </pre>
   * @param dbManager 数据库连接池
   * @param baseCurrency 基准币别
   * @param exchCurrency 兑换币别
   * @param exchDate 兑换日期 标准的年月日格式
   * @return exchangeRate 兑换率
   * @throws UserExcetion,Exception
   */
  public static double getExchangeRate(DBManager dbManager,String baseCurrency,String exchCurrency,DateTime exchDate)
    throws UserException,Exception
  {
    BLPubRateAction blPubRateAction = new BLPubRateAction();
    double dblExchangeRate = 0d;
    double dblExchangeRate1 = 0d;
    double dblExchangeRate2 = 0d;

    baseCurrency = baseCurrency.trim();
    exchCurrency = exchCurrency.trim();
    if (baseCurrency.equalsIgnoreCase(exchCurrency))
    {
      dblExchangeRate = 1;
      return dblExchangeRate;
    } 
    //获取同一天基准币别和兑换币别的直接兑换率
    dblExchangeRate = BLPubRateAction.getStraightExchangeRate(dbManager,baseCurrency,exchCurrency,exchDate);
    if (dblExchangeRate !=0)
    {
      return dblExchangeRate;
    }
    //获取同一天兑换币别和基准币别的直接兑换率
    dblExchangeRate = BLPubRateAction.getStraightExchangeRate(dbManager,exchCurrency,baseCurrency,exchDate);
    if (dblExchangeRate !=0)
    {
      dblExchangeRate = 1 / dblExchangeRate;
      return dblExchangeRate;
    }

    dblExchangeRate1 = BLPubRateAction.getStraightExchangeRate(dbManager,baseCurrency,"USD",exchDate);
    if (dblExchangeRate1 !=0)
    {
      //存在基准币别和USD的兑换率
      dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,exchCurrency,"USD",exchDate);
      if (dblExchangeRate2 !=0)
      {
        //存在兑换币别和USD的兑换率
        dblExchangeRate = dblExchangeRate1 / dblExchangeRate2;
        return dblExchangeRate;
      }
      else
      {
        dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,"USD",exchCurrency,exchDate);
        if (dblExchangeRate2 !=0)
        {
          //存在USD和兑换币别的兑换率
          dblExchangeRate = dblExchangeRate1 * dblExchangeRate2;
          return dblExchangeRate;
        }
      }
    }

    dblExchangeRate1 = BLPubRateAction.getStraightExchangeRate(dbManager,"USD",baseCurrency,exchDate);
    if (dblExchangeRate1 !=0)
    {
      //存在USD和基准币别的兑换率
      dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,exchCurrency,"USD",exchDate);
      if (dblExchangeRate2 !=0)
      {
        //存在兑换币别和USD的兑换率
        dblExchangeRate = dblExchangeRate2  * dblExchangeRate1 ;
        return dblExchangeRate;
      }
      else
      {
        dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,"USD",exchCurrency,exchDate);
        if (dblExchangeRate2 !=0)
        {
          //存在USD和兑换币别的兑换率
          dblExchangeRate = dblExchangeRate2 / dblExchangeRate1 ;
          return dblExchangeRate;
        }
      }
    }
    return dblExchangeRate;
  }

  /**
   * 获取给定险种的按月（日）短期费率
   * @param riskCode  险种代码
   * @param startDate 起始日期
   * @param startHour 起始小时
   * @param endDate   终止日期
   * @param endHour   终止小时
   * @param shortRateFlag  短期费率方式（1：按月 2：按日 3：不计）
   * @return shortRate 短期费率
   * @throws Exception
   */
  public static double getShortRate(String riskCode,DateTime startDate,int startHour,
                                    DateTime endDate,int endHour,String shortRateFlag)
    throws Exception
  {
    DBManager dbManager = new DBManager();
    double  dblShortRate = 0d;
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
      dblShortRate = getShortRate(dbManager,riskCode,startDate,startHour,
                                  endDate,endHour,shortRateFlag);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return  dblShortRate;

  }

  /**
   * 获取给定险种的按月（日）短期费率
   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * DateTime startDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * DateTime endDate   = new DateTime("2004/03/01",DateTime.YEAR_TO_DAY);
   * double shortRate = BLPubRateFacade.getShortRate(dbManager,"DAA",startDate,12,endDate,12,"1");
   * double shortRate = BLPubRateFacade.getShortRate(dbManager,"QAA",startDate,12,endDate,12,"2");
   * double shortRate = BLPubRateFacade.getShortRate(dbManager,"ZFG",startDate,12,endDate,12,"3");
   * </pre>
   * @param dbManager 数据库连接池
   * @param riskCode  险种代码
   * @param startDate 起始日期
   * @param startHour 起始小时
   * @param endDate   终止日期
   * @param endHour   终止小时
   * @param shortRateFlag  短期费率方式（1：按月 2：按日 3：不计）
   * @return shortRate 短期费率
   * @throws Exception
   */
  public static double getShortRate(DBManager dbManager,String riskCode,DateTime startDate,int startHour,
                                    DateTime endDate,int endHour,String shortRateFlag)
    throws Exception
  {
    double  dblShortRate = 0d;
    try
    {
      if(shortRateFlag.equals("1"))
      {
        dblShortRate = getMonthShortRate(dbManager,riskCode,startDate,startHour,endDate,endHour);
      }
      else if(shortRateFlag.equals("2"))
      {
        dblShortRate = getDayShortRate(riskCode,startDate,startHour,endDate,endHour);
      }
      else
      {
        dblShortRate = 100;
      }
    }
    catch(Exception e)
    {
      throw e;
    }

    return  dblShortRate;
  }

  /**
   * 短期费率方式为按月的短期费率
   * @param startDate 起始日期
   * @param startHour 起始小时
   * @param endDate   终止日期
   * @param endHour   终止小时
   * @return shortRate 短期费率
   * @throws Exception
   */
  public static double getMonthShortRate(String riskCode,DateTime startDate,int startHour,
      DateTime endDate,int endHour)
    throws Exception
  {
    DBManager dbManager = new DBManager();
    double dblShortRate = 0d;
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
      dblShortRate = getMonthShortRate(dbManager,riskCode,startDate,startHour,
                                       endDate,endHour);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return  dblShortRate;

  }

  /**
   * 短期费率方式为按月的短期费率
   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * DateTime startDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * DateTime endDate   = new DateTime("2004/03/01",DateTime.YEAR_TO_DAY);
   * double shortRate = BLPubRateFacade.getMonthShortRate(dbManager,"DAA",startDate,12,endDate,12);
   * double shortRate = BLPubRateFacade.getMonthShortRate(dbManager,"QAA",startDate,0,endDate,24);
   * double shortRate = BLPubRateFacade.getMonthShortRate(dbManager,"ZFG",startDate,0,endDate,0);
   * </pre>
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
    double dblShortRate = 0d;
    try
    {
      dblShortRate = BLPubRateAction.getMonthShortRate(dbManager,riskCode,startDate,startHour,
          endDate,endHour);
    }
    catch(Exception e)
    {
      throw e;
    }
    return  dblShortRate;
  }

  /**
   * 短期费率方式为按日的短期费率
   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * DateTime startDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * DateTime endDate   = new DateTime("2004/03/01",DateTime.YEAR_TO_DAY);
   * double shortRate = BLPubRateFacade.getDayShortRate(dbManager,"DAA",startDate,12,endDate,12);
   * double shortRate = BLPubRateFacade.getDayShortRate(dbManager,"QAA",startDate,0,endDate,24);
   * double shortRate = BLPubRateFacade.getDayShortRate(dbManager,"ZFG",startDate,0,endDate,0);
   * </pre>
   * @param riskCode  险种（暂时没有特殊处理）
   * @param startDate 起始日期
   * @param startHour 起始小时
   * @param endDate   终止日期
   * @param endHour   终止小时
   * @return shortRate 短期费率
   * @throws Exception
   */
  public static double getDayShortRate(String riskCode,DateTime startDate,int startHour,
                                       DateTime endDate,int endHour)
    throws Exception
  {
    double dblShortRate = 0d;
    int intDay = 0;
    try
    {
      intDay = DateTime.intervalDay(startDate,startHour,endDate,endHour); //依赖common包
      dblShortRate = intDay * 100 /365d;
    }
    catch(Exception e)
    {
      throw e;
    }
    return dblShortRate;

  }


  public Collection getExchOfMaxDate(String currDate)
    throws Exception
  {
        DBManager dbManager = new DBManager();
        Collection prpdexchrateDtoList = new ArrayList();
        try
        {
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            BLPubRateAction blPubRateAction = new BLPubRateAction();
            prpdexchrateDtoList = blPubRateAction.getExchOfMaxDate(dbManager,currDate);
            //加载兑换率信息
            
        }
      
        catch (Exception ex) {
           throw ex;
        }
        finally
        {
           dbManager.close();
        }
     return  prpdexchrateDtoList; 
  }
 






}
