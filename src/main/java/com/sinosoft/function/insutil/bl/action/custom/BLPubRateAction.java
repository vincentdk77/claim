/**
 * <p>Title: BLPubRateAction</p>
 * <p>Description: ʵ�ֺ����йصķ���</p>
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
    * ���췽��
   */
   public BLPubRateAction()
   {
  }

  /**
   * ��þ�����������һ������ֱұ��ֱ�Ӷһ���
   * @param dbManager ���ݿ����ӳ�
   * @param baseCurrency ��׼�ұ�
   * @param exchCurrency �һ��ұ�
   * @param exchDate �һ����� ��׼�������ո�ʽ
   * @return exchangeRate �һ���
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
    prpDexchDto = dbPrpDexch.findByPrimaryKey(maxExchDate,baseCurrency,exchCurrency);//����resource��
    if (prpDexchDto == null )
    {
      dblExchangeRate = 0;
      return dblExchangeRate;
    }
    dblExchangeRate = Double.parseDouble(DataUtils.nullToZero(String.valueOf(prpDexchDto.getExchRate()))); //����common��
    return dblExchangeRate;
  }
  /**
   * ���ڷ��ʷ�ʽΪ���µĶ��ڷ���
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

    //��ȡ��ǰ���ֵĶ��ڷ���
     prpDshortRateDto = dbPrpDshortRate.findByPrimaryKey(riskCode,intMonth);
    if (prpDshortRateDto != null )  //��ȡ����
    {
      //�Ӷ��ڷ��ʱ��л�ȡ��
      dblShortRate = intYear * 100 + prpDshortRateDto.getShortRate();
      return dblShortRate;
    }
    //��ȡ�����򷵻�ȱʡ�Ķ��ڷ���
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
        //ȷ���һ���
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
