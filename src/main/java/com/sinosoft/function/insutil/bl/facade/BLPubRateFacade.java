/**
 * <p>Title: BLPubRateFacade</p>
 * <p>Description:�����йصĹ����ࣨ�����һ��ʡ����ڷ��ʣ� </p>
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
   * ���췽��
   */
  public BLPubRateFacade()
  {
  }

  /**
   * ��þ�����������һ������ֱұ�Ķһ���
   * @param baseCurrency ��׼�ұ�
   * @param exchCurrency �һ��ұ�
   * @param exchDate �һ����� ��׼�������ո�ʽ
   * @return exchangeRate �һ���
   * @throws UserExcetion,Exception
   */
  public static double getExchangeRate(String baseCurrency,String exchCurrency,DateTime exchDate)
    throws Exception
  {
    DBManager dbManager = new DBManager();
    double dblExchangeRate = 0d;
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
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
   * ��þ�����������һ������ֱұ�Ķһ���
   * ���Ȼ�ȡbaseCurrency��exchCurrency�Ķһ��ʣ�
   * ��ȡ���������ȡexchCurrency��baseCurrency�Ķһ��ʣ�
   * �������ȡ�����������Ž�exchCurrency��baseCurrency�ֱ����ԪUSD�Ķһ��ʣ�
   * �������ȡ���������ʾ��ȡ�����һ��ʣ�����0
   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * DateTime exchDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * double exchRate = BLPubRateFacade.getExchangeRate("USD","CNY",exchDate);
   * </pre>
   * @param dbManager ���ݿ����ӳ�
   * @param baseCurrency ��׼�ұ�
   * @param exchCurrency �һ��ұ�
   * @param exchDate �һ����� ��׼�������ո�ʽ
   * @return exchangeRate �һ���
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
    //��ȡͬһ���׼�ұ�Ͷһ��ұ��ֱ�Ӷһ���
    dblExchangeRate = BLPubRateAction.getStraightExchangeRate(dbManager,baseCurrency,exchCurrency,exchDate);
    if (dblExchangeRate !=0)
    {
      return dblExchangeRate;
    }
    //��ȡͬһ��һ��ұ�ͻ�׼�ұ��ֱ�Ӷһ���
    dblExchangeRate = BLPubRateAction.getStraightExchangeRate(dbManager,exchCurrency,baseCurrency,exchDate);
    if (dblExchangeRate !=0)
    {
      dblExchangeRate = 1 / dblExchangeRate;
      return dblExchangeRate;
    }

    dblExchangeRate1 = BLPubRateAction.getStraightExchangeRate(dbManager,baseCurrency,"USD",exchDate);
    if (dblExchangeRate1 !=0)
    {
      //���ڻ�׼�ұ��USD�Ķһ���
      dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,exchCurrency,"USD",exchDate);
      if (dblExchangeRate2 !=0)
      {
        //���ڶһ��ұ��USD�Ķһ���
        dblExchangeRate = dblExchangeRate1 / dblExchangeRate2;
        return dblExchangeRate;
      }
      else
      {
        dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,"USD",exchCurrency,exchDate);
        if (dblExchangeRate2 !=0)
        {
          //����USD�Ͷһ��ұ�Ķһ���
          dblExchangeRate = dblExchangeRate1 * dblExchangeRate2;
          return dblExchangeRate;
        }
      }
    }

    dblExchangeRate1 = BLPubRateAction.getStraightExchangeRate(dbManager,"USD",baseCurrency,exchDate);
    if (dblExchangeRate1 !=0)
    {
      //����USD�ͻ�׼�ұ�Ķһ���
      dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,exchCurrency,"USD",exchDate);
      if (dblExchangeRate2 !=0)
      {
        //���ڶһ��ұ��USD�Ķһ���
        dblExchangeRate = dblExchangeRate2  * dblExchangeRate1 ;
        return dblExchangeRate;
      }
      else
      {
        dblExchangeRate2 = BLPubRateAction.getStraightExchangeRate(dbManager,"USD",exchCurrency,exchDate);
        if (dblExchangeRate2 !=0)
        {
          //����USD�Ͷһ��ұ�Ķһ���
          dblExchangeRate = dblExchangeRate2 / dblExchangeRate1 ;
          return dblExchangeRate;
        }
      }
    }
    return dblExchangeRate;
  }

  /**
   * ��ȡ�������ֵİ��£��գ����ڷ���
   * @param riskCode  ���ִ���
   * @param startDate ��ʼ����
   * @param startHour ��ʼСʱ
   * @param endDate   ��ֹ����
   * @param endHour   ��ֹСʱ
   * @param shortRateFlag  ���ڷ��ʷ�ʽ��1������ 2������ 3�����ƣ�
   * @return shortRate ���ڷ���
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
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
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
   * ��ȡ�������ֵİ��£��գ����ڷ���
   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * DateTime startDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * DateTime endDate   = new DateTime("2004/03/01",DateTime.YEAR_TO_DAY);
   * double shortRate = BLPubRateFacade.getShortRate(dbManager,"DAA",startDate,12,endDate,12,"1");
   * double shortRate = BLPubRateFacade.getShortRate(dbManager,"QAA",startDate,12,endDate,12,"2");
   * double shortRate = BLPubRateFacade.getShortRate(dbManager,"ZFG",startDate,12,endDate,12,"3");
   * </pre>
   * @param dbManager ���ݿ����ӳ�
   * @param riskCode  ���ִ���
   * @param startDate ��ʼ����
   * @param startHour ��ʼСʱ
   * @param endDate   ��ֹ����
   * @param endHour   ��ֹСʱ
   * @param shortRateFlag  ���ڷ��ʷ�ʽ��1������ 2������ 3�����ƣ�
   * @return shortRate ���ڷ���
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
   * ���ڷ��ʷ�ʽΪ���µĶ��ڷ���
   * @param startDate ��ʼ����
   * @param startHour ��ʼСʱ
   * @param endDate   ��ֹ����
   * @param endHour   ��ֹСʱ
   * @return shortRate ���ڷ���
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
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
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
   * ���ڷ��ʷ�ʽΪ���µĶ��ڷ���
   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * DateTime startDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * DateTime endDate   = new DateTime("2004/03/01",DateTime.YEAR_TO_DAY);
   * double shortRate = BLPubRateFacade.getMonthShortRate(dbManager,"DAA",startDate,12,endDate,12);
   * double shortRate = BLPubRateFacade.getMonthShortRate(dbManager,"QAA",startDate,0,endDate,24);
   * double shortRate = BLPubRateFacade.getMonthShortRate(dbManager,"ZFG",startDate,0,endDate,0);
   * </pre>
   * @param dbManager ���ݿ����ӳ�
   * @param startDate ��ʼ����
   * @param startHour ��ʼСʱ
   * @param endDate   ��ֹ����
   * @param endHour   ��ֹСʱ
   * @return shortRate ���ڷ���
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
   * ���ڷ��ʷ�ʽΪ���յĶ��ڷ���
   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * DateTime startDate = new DateTime("2004/02/01",DateTime.YEAR_TO_DAY);
   * DateTime endDate   = new DateTime("2004/03/01",DateTime.YEAR_TO_DAY);
   * double shortRate = BLPubRateFacade.getDayShortRate(dbManager,"DAA",startDate,12,endDate,12);
   * double shortRate = BLPubRateFacade.getDayShortRate(dbManager,"QAA",startDate,0,endDate,24);
   * double shortRate = BLPubRateFacade.getDayShortRate(dbManager,"ZFG",startDate,0,endDate,0);
   * </pre>
   * @param riskCode  ���֣���ʱû�����⴦��
   * @param startDate ��ʼ����
   * @param startHour ��ʼСʱ
   * @param endDate   ��ֹ����
   * @param endHour   ��ֹСʱ
   * @return shortRate ���ڷ���
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
      intDay = DateTime.intervalDay(startDate,startHour,endDate,endHour); //����common��
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
            //���ضһ�����Ϣ
            
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
