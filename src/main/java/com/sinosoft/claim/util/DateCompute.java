package com.sinosoft.claim.util;
/****************************************************************************
 * DESC       �����ڼ��㹤����
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-08-23
 * MODIFYLIST ��  Name       Date            Reason/Contents
 ****************************************************************************/


import java.util.Calendar;
import java.text.SimpleDateFormat;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.utility.string.Date;
/**
 *  ����������ش�������
 */
public class DateCompute
{
	/**
	 * ���ʱ��ķ������� type
	 * */
	public static final int DAY_TO_DAY    = 11;
	public static final int DAY_TO_HOUR   = 12;
	public static final int DAY_TO_MINUTE = 13;
	public static final int DAY_TO_SECOND = 14;
	private static final long dayToMiins    = 1000*60*60*24 ;
	private static final long hourToMiins   = 60*60*1000;
	private static final long minuteToMiins = 60*1000;
	private static final int  secondToMiins = 1000;
	
	/**
	 * ���ַ���ʱ���ַ���תΪDateTime
	 * ���ڲ���תΪDateTime���ͷ���Ϊ��
	 * */
	public static DateTime convertString2DateTime(String sourceDateTime) throws Exception{
		DateTime rtnDateTime = null;
		if(sourceDateTime==null||sourceDateTime.equals("null") ||sourceDateTime.equals("")){
		}else{
			if(sourceDateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
				rtnDateTime = new DateTime(sourceDateTime, DateTime.YEAR_TO_DAY);
			}else if(sourceDateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}$")){
				rtnDateTime = new DateTime(sourceDateTime, DateTime.YEAR_TO_MINUTE);
			}else if(sourceDateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
				rtnDateTime = new DateTime(sourceDateTime, DateTime.YEAR_TO_SECOND);
			}
		}
		return rtnDateTime;
	}
	
	/**
	 * ���ܣ��������ʱ��ļ��
	 * @param FirstDate String  ����Ϊyyyy-MM-DD hh:mm:ss����yyyy/MM/DD
	 * @param SecondDate String
	 * @return String X��XСʱX����X��
	 */
	public static String intervalDateTime(String beginDateTime,String endDateTime,int type) throws Exception{
		long dayCount   =0;//����
		long hourCount   = 0 ;  //Сʱ��
		long minuteCount = 0 ;  //������
		int  secondCount = 0;   //����
		long remainNum = 0  ;
		long diffTime = 0 ;//ʱ�����ĺ�����
		DateTime beginTime = convertString2DateTime(beginDateTime);
		if(null ==beginTime){return "" ;}
		DateTime endTime = convertString2DateTime(endDateTime);
		if(null == endTime){return "" ;}
		
		diffTime = endTime.getTime()- beginTime.getTime() ;
		//��������
		dayCount = (long)diffTime/dayToMiins;
		//����ʣ���Сʱ�ͷ����Լ���
		remainNum = diffTime % dayToMiins;
		if(remainNum>0){
			//����Сʱ
			hourCount = (long)remainNum/hourToMiins;
			//����ʣ��ķ��Ӻ���
			remainNum = remainNum % hourToMiins;
			if(remainNum>0){
				//�������
				minuteCount = (long)remainNum/minuteToMiins;
				//����ʣ��ķ��Ӻ���
				remainNum   = remainNum % minuteToMiins;
				if(remainNum>0){
					//������
					secondCount = (int)remainNum/secondToMiins;
				}
			}
		}
		StringBuffer stopTimeDesc = new StringBuffer();
		switch(type){
		case DAY_TO_DAY:
			stopTimeDesc.append(dayCount+"��");
			break;
		case DAY_TO_HOUR:
			stopTimeDesc.append(dayCount+"��"+hourCount+"Сʱ");
			break;
		case DAY_TO_MINUTE:
			stopTimeDesc.append(dayCount+"��"+hourCount+"Сʱ"+minuteCount + "����");
			break;
		case DAY_TO_SECOND:
			stopTimeDesc.append(dayCount+"��"+hourCount+"Сʱ"+minuteCount + "����"+secondCount+"��");
			break;
		default:
			throw new IllegalArgumentException(type + " is not support");
		}
		return stopTimeDesc.toString() ;
	}
/**
 * ������ʼ����ֹ���ڼ��������������Ϣ�ղ���,���㹤����
 *@param iStartDate ��ʼ����
 *@param iStartHour ��ʼСʱ
 *@param iEndDate   ��ֹ����
 *@param iEndHour   ��ֹСʱ
 *@param iOption    ����չ
 *@return   ������ */

public static int getBusinessDays(DateTime iStartDate,DateTime iEndDate)
    throws Exception
{
  int intDay = 0;
  int intRest =0;  //��¼���������Ϣ�յ�����
  int intYear = 0;
  int intMonth = 0;
  int intDate =0;
  int intWeek =0;

  try
  {
     DateTime computeDate=iStartDate ;
     String strStartDate = iStartDate.getYear() +"-"+iStartDate.getMonth() +"-"+iStartDate.getDay()  ;
     String strEndDate = iEndDate.getYear() +"-"+iEndDate.getMonth() +"-"+iEndDate.getDay() ;

     if(compareDate(strStartDate,strEndDate)>=0)  //�������ں�¼������Ϊͬһ��,ͬʱ�ų��������ڱ�¼����������쳣
     {
       //return intDay;
       return 1;  //jsp����0ʱ��24ʱ������1��
     }
     else
     {
        intDay =  (int)((iStartDate.getTime()  -iEndDate.getTime())/86400000l);
        intRest=0;
        while(compareDate(strStartDate,strEndDate)<=0)
        {
            //�ۼ��ж�����Ϣ��
            //strStartDate = chgDate.toFormat(strStartDate);  //��ʽ����yyyy-MM-dd����ʽ
            intYear = computeDate.getYear();
            intMonth = computeDate.getMonth();
            intDate = computeDate.getDate();
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(intYear,intMonth,intDate); //1�·ݶ�Ӧ����ֵ0�������ն�Ӧ����ֵ1
            intMonth  = cal.get(Calendar.MONTH);
            intDate = cal.get(Calendar.DATE);
            intWeek = cal.get(Calendar.DAY_OF_WEEK);
            if(intWeek==1||intWeek==7||((intMonth==4||intMonth==9)&&intDate>=1&&intDate<=7)||(intMonth==0&&intDate==1))
            {
              intRest++;
            }
            //ȡ��һ��
            computeDate =computeDate.addDay(1);
            strStartDate = computeDate.getYear() +"-"+computeDate.getMonth() +"-"+computeDate.getDay();
        }
        intDay -= intRest; //��Ϣ�ղ���
        if(intDay<0)
        {
          intDay=0;
        }
        return intDay;

     }
  }
  catch(Exception e)
  {
    throw e;
  }
}
/**
 * ������ʼ����ֹ���ڼ���������
 *@param iStartDate ��ʼ����
 *@param iEndDate   ��ֹ����
 *@return   ������ */

public static String getBusinessDays2(DateTime iStartDate,DateTime iEndDate)
    throws Exception
{
	String costTime = "";
	try{
		String starDateStr = iStartDate.toString(DateTime.YEAR_TO_SECOND);
		String endDateStr = iEndDate.toString(DateTime.YEAR_TO_SECOND);
		String resultStr = betweenDate(starDateStr,endDateStr);
	 
		int index = resultStr.indexOf("��");
		if (index != -1){
			costTime = resultStr.substring(0, index);
		}
    
	}catch(Exception e){
		throw e;
	}
	return costTime;
}
/**
 * ���ܣ��Ƚ������Ƿ����
 * @param FirstDate String  ����Ϊyyyy-MM-DD����yyyy/MM/DD
 * @param SecondDate String
 * @return int 1�����ڣ�0����ȣ�-1��С��
 */
public static int compareDate(String FirstDate,String SecondDate) throws Exception
{
  int intReturn   = 0 ; //����ֵ
  java.util.Date firstDate  = null;
  java.util.Date secondDate = null;
  try
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    StringConvert.replace(FirstDate,"/","-");  //����/���ķָ���
    firstDate = format.parse(FirstDate);
    secondDate = format.parse(SecondDate);
    if (firstDate.after(secondDate)) {
      intReturn = 1;
    }
    else if (firstDate.before(secondDate)) {
      intReturn = -1;
    }
    else if (firstDate.equals(secondDate)) {
      intReturn = 0;
    }
    return intReturn;
  }
  catch(Exception e)
  {
    throw e;
  }
}

/**
 * ���ܣ��Ƚ������Ƿ����
 * @param FirstDate String  ����Ϊyyyy-MM-DD hh:mm:ss����yyyy/MM/DD
 * @param SecondDate String
 * @return String X��XСʱX����X��
 */
public static String betweenDate(String firstDateTime,String secondDateTime) throws Exception
{
              //������������
   long dayToMiins = 1000*60*60*24 ;
   long hourToMiins = 60*60*1000;
   long minuteToMiins = 60*1000;
   int  secondToMiins = 1000;
   long hourCount   = 0 ;  //Сʱ��
   long minuteCount = 0 ;  //����
   int  secondCount = 0;
   long dayCount   =0;
   long remainNum = 0  ;
   long diffTime = 0 ;
   DateTime  beginTime=null;
   DateTime  endTime=null;
   StringBuffer stopTimeDesc=null;
   boolean isDate=false;

  //����û��ʱ��İ��� ����stopTime = 0 ;
   if(firstDateTime==null||firstDateTime.equals("null") ||firstDateTime.equals("")||secondDateTime==null||secondDateTime.equals("null") ||secondDateTime.equals("") )
     {
       return "" ;
     }
     isDate =isDateTime(firstDateTime);
         //�ж����������Ƿ���ȷ
     if(!isDate)  return "" ;

     isDate = isDateTime(secondDateTime);
         //�ж����������Ƿ���ȷ
     if(!isDate)  return "" ;

     if(firstDateTime.length() <11)
     {
        beginTime = new DateTime(firstDateTime, DateTime.YEAR_TO_DAY);
     }
     //add by xia begin
     else if(firstDateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}$")){
    	 beginTime = new DateTime(firstDateTime, DateTime.YEAR_TO_MINUTE);
     }
     //add by xia end 
     else{
        beginTime = new DateTime(firstDateTime, DateTime.YEAR_TO_SECOND);
     }

     if(secondDateTime.length()<11)
     {
       endTime = new DateTime(secondDateTime, DateTime.YEAR_TO_DAY);
     }
     //add by xia begin
     else if(secondDateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}$")){
    	 endTime = new DateTime(secondDateTime, DateTime.YEAR_TO_MINUTE);
     }
     //add by xia end
     else {
       endTime = new DateTime(secondDateTime, DateTime.YEAR_TO_SECOND);
     }

      diffTime = endTime.getTime()- beginTime.getTime() ;
      //��������֮��
      dayCount   = (long)diffTime/dayToMiins  ;
      //����ʣ���Сʱ�ͷ���
      remainNum = diffTime % dayToMiins  ;

      if(remainNum>0)
       {
        hourCount = (long)remainNum/hourToMiins;  //����Сʱ
        remainNum      = remainNum % hourToMiins;
        if(remainNum > 0)
           {
           minuteCount = (long)remainNum/minuteToMiins; //�������
           remainNum   = remainNum % minuteToMiins;
           if(remainNum>0)
            {
               secondCount = (int)remainNum/secondToMiins;

            }
             else
             {
                 secondCount = 0 ;
             }
           }
           else
           {
               minuteCount = 0 ;
           }
         }
         else{
           hourCount = 0 ;
       }

     stopTimeDesc = new StringBuffer();
     stopTimeDesc =  stopTimeDesc.append(dayCount+"��"+hourCount+"Сʱ"+minuteCount + "����"+secondCount+"��");
     return stopTimeDesc.toString() ;
}

      //modify by weishixin add 20050225 start
    //reason:�ж�����Դ���Ƿ�������
    /**
     * �ж�����Դ���Ƿ�������
     * @param sourceDateTime String
     * @throws Exception
     * @return boolean
     */
    private static boolean isDateTime(String sourceDateTime) throws Exception
    {
      boolean isDate = false ;
      DateTime checkTime = null ;
      try
      {
         if(sourceDateTime.length()<11)
         {
           checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_DAY);
           isDate = true ;
         }
         //add by xia begin 
         else if(sourceDateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}$")){
        	 checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_MINUTE);
        	 isDate = true ;
         }
         //add by xia end 
         else
         {
             checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_SECOND);
             isDate = true ;
         }
         //System.out.println("�������ڣ�"+sourceDateTime);
      }
      catch(Exception e)
      {
        // System.out.println("�������ڣ�"+sourceDateTime);
         isDate = false ;
      }

      return isDate;
    }
    
    /**
     * ������ʼ����ֹ���ڼ���Сʱ�������Ϣ�ղ���,���㹤����
     *@param iStartDate ��ʼ����
     *@param iStartHour ��ʼСʱ
     *@param iEndDate   ��ֹ����
     *@param iEndHour   ��ֹСʱ
     *@param iOption    ����չ
     *@return   Сʱ�� */

    public  int getBusinessDaysHour(DateTime iStartDate,int hour1,DateTime iEndDate,int hour2)
        throws Exception
    {
      int intDay = 0;
      int intRest =0;  //��¼���������Ϣ�յ�����
      int intYear = 0;
      int intMonth = 0;
      int intDate =0;
      int intWeek =0;
      int resulthour=0;

      try
      {
         DateTime computeDate = iStartDate ;
         String strStartDate = iStartDate.getYear() +"-"+iStartDate.getMonth() +"-"+iStartDate.getDay();
         String strEndDate = iEndDate.getYear() +"-"+iEndDate.getMonth() +"-"+iEndDate.getDay();
         if(compareDate(strStartDate,strEndDate)>=0)  //�������ںͲ�������Ϊͬһ��,ͬʱ�ų��������ڱȲ�����������쳣
         {
         	resulthour= hour2-hour1;
         	return resulthour;
         }
        
         while(compareDate(strStartDate,strEndDate)<=0)
            {
                //�ۼ��ж�����Ϣ��
                //strStartDate = chgDate.toFormat(strStartDate);  //��ʽ����yyyy-MM-dd����ʽ
                intYear = computeDate.getYear();
                intMonth = computeDate.getMonth()-1;
                intDate = computeDate.getDate();
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(intYear,intMonth,intDate); //1�·ݶ�Ӧ����ֵ0�������ն�Ӧ����ֵ1
                intMonth  = cal.get(cal.MONTH);
                intDate = cal.get(cal.DATE);
                intWeek = cal.get(cal.DAY_OF_WEEK);
                
                //ȡ��һ��
                DateTime computeDateTemp=new DateTime(computeDate.toString(),DateTime.YEAR_TO_DAY );
                computeDate =computeDate.addDay(1);
                strStartDate = computeDate.getYear() +"-"+computeDate.getMonth() +"-"+computeDate.getDay();
                 
                if(intWeek == 1||intWeek == 7                                                    //�޳�����������
                        || ((intMonth == 4 || intMonth == 9) && intDate >=1 && intDate <= 7)     //�޳���һ��ʮһ
                		|| (intMonth == 0 && intDate >= 1 && intDate <= 3)                       //�޳�Ԫ��
                        || (intMonth == 0 && intDate >= 29 && intDate <= 31)                    
                        || (intMonth == 1 && intDate >= 1 && intDate <= 4))                      //�޳�06�괺����Ϣ��
                {
                 continue;
                }
                
                if (computeDateTemp.getTime() ==iStartDate.getTime()){
                	resulthour=24-hour1;
                	 continue;
                }
                if (computeDateTemp.getTime() ==iEndDate.getTime() ){
                	resulthour=resulthour+hour2;
                	 continue;
                }
                
                resulthour=resulthour+24;
            }
        
            return resulthour;

      }
      catch(Exception e)
      {
        throw e;
      }
    }

    /**
     * ������ʼ����ֹ���ڼ���Сʱ��㹫����Ϣ��
     *@param iStartDate ��ʼ����
     *@param iStartHour ��ʼСʱ
     *@param iEndDate   ��ֹ����
     *@param iEndHour   ��ֹСʱ
     *@param iOption    ����չ
     *@return   Сʱ�� */

    public  int getDaysHour(DateTime iStartDate,int hour1,DateTime iEndDate,int hour2)
        throws Exception
    {
      int resulthour=0;

      try
      {
         DateTime computeDate=iStartDate ;
         String strStartDate = iStartDate.getYear() +"-"+iStartDate.getMonth() +"-"+iStartDate.getDay()  ;
         String strEndDate = iEndDate.getYear() +"-"+iEndDate.getMonth() +"-"+iEndDate.getDay() ;
         if(compareDate(strStartDate,strEndDate)>0)  //�������ں�¼������Ϊͬһ��,ͬʱ�ų��������ڱ�¼����������쳣
         {
         	return resulthour;
         }
        
         if(compareDate(strStartDate,strEndDate)==0)  //�������ں�¼������Ϊͬһ��,ͬʱ�ų��������ڱ�¼����������쳣
         {
         	resulthour= hour2-hour1;
         	return resulthour;
         }
               
         resulthour =(int)((iEndDate.getTime()- iStartDate.getTime())/(60*60*1000))+ hour2 - hour1;    
         
         return resulthour;

      }
      catch(Exception e)
      {
        throw e;
      }
    }
    
    /**
     * ������ʼ����ֹ���ڼ����·ݲ�
     *@param iStartDate ��ʼ����
     *@param iStartHour ��ʼСʱ
     *@param iEndDate   ��ֹ����
     *@param iEndHour   ��ֹСʱ
     *@return ���ڷ���   */
    public static int getDayMinus(Date iStartDate,int iStartHour,Date iEndDate,int iEndHour)
        throws Exception
    {
      int intDay = 0;
      java.util.Date startDate = new java.util.Date(iStartDate.get(Date.YEAR),iStartDate.get(Date.MONTH)-1,iStartDate.get(Date.DATE),iStartHour,0,0);
      java.util.Date endDate = new java.util.Date(iEndDate.get(Date.YEAR),iEndDate.get(Date.MONTH)-1,iEndDate.get(Date.DATE),iEndHour,0,0);
      intDay =  (int)((endDate.getTime() - startDate.getTime())/86400000l);
      return intDay;
    }
    
  
    public  int getHoliDays(DateTime iStartDate,DateTime iEndDate)
    throws Exception
    {
    int intRest =0;  //��¼���������Ϣ�յ�����
    int intYear = 0;
    int intMonth = 0;
    int intDate =0;
    int intWeek =0;

    try
    {
     DateTime computeDate=iStartDate ;
     String strStartDate = iStartDate.getYear() +"-"+iStartDate.getMonth() +"-"+iStartDate.getDay()  ;
     String strEndDate = iEndDate.getYear() +"-"+iEndDate.getMonth() +"-"+iEndDate.getDay() ;
     
        intRest=0;
        while(compareDate(strStartDate,strEndDate)<=0)
        {
            //�ۼ��ж�����Ϣ��
            //strStartDate = chgDate.toFormat(strStartDate);  //��ʽ����yyyy-MM-dd����ʽ
        	//System.out.println("�Ƚ�"+computeDate+"----strStartDate"+strStartDate);

        	intYear = computeDate.getYear();
            intMonth = computeDate.getMonth()-1;
            intDate = computeDate.getDate();
            //System.out.println("***********icomputeDate:"+computeDate);
            //System.out.println("***********intYear:"+intYear);
            //System.out.println("********intMonth:"+intMonth);
            //System.out.println("*****intDate:"+intDate);
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(intYear,intMonth,intDate); //1�·ݶ�Ӧ����ֵ0�������ն�Ӧ����ֵ1
            intMonth  = cal.get(cal.MONTH);
            intDate = cal.get(cal.DATE);
            intWeek = cal.get(cal.DAY_OF_WEEK);
            
            //System.out.println("**********QQQQQQQQQQ*icomputeDate:"+intMonth);
            //System.out.println("********QQQQQQQQQQQ***intYear:"+intDate);
            //System.out.println("********QQQQQQQQQQQintWeek:"+intWeek);
          
      //System.out.println("intWeek"+intWeek);
            if(intWeek==1||intWeek==7||((intMonth==4||intMonth==9)&&intDate>=1&&intDate<=7)||(intMonth==0&&intDate==1))
            {
              intRest++;
            }
            //ȡ��һ��
            computeDate =computeDate.addDay(1);
            strStartDate = computeDate.getYear() +"-"+computeDate.getMonth() +"-"+computeDate.getDay();
        }
        if(intRest<0)
        {
        	intRest=0;
        }
        return intRest;

    }
    catch(Exception e)
    {
    throw e;
    }
    
    
    }

}
