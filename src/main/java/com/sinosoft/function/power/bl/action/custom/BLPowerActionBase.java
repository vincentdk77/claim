package com.sinosoft.function.power.bl.action.custom;
/**
 * <p>Title: Ȩ��У��</p>
 * <p>Description: �����Ʒ��Ȩ��У�����Action</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ�� κʿ��
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.function.insutil.bl.facade.BLEncryptFacade;
import com.sinosoft.function.power.dto.domain.PrpDcompanyDto;
import com.sinosoft.function.power.dto.domain.PrpDriskDto;
import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.function.power.resource.dtofactory.custom.DBCommonSQL;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpGrant;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpUserGrade;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
public class BLPowerActionBase {
  public BLPowerActionBase() {
  }

  /**
   * ���������Ա���Ƿ�������ĳ������ĳ������������͵�Ȩ��
   * @param  iUserCode    Ա������
   * @param  iRiskCode    ���ִ���
   * @param  iTaskCode    �������
   * @param  iCheckCode   Ȩ�޲�������(r:�� x:ִ�� w��д k�����ˣ�
   * @return blnfound    �Ƿ���в���Ȩ�ޣ���Ȩ�޷���true����Ȩ�޷���false
   * @throws Exception   �쳣
   */
  public boolean checkPower(DBManager dbManager,
                            String iUserCode,
                            String iRiskCode,
                            String iTaskCode,
                            String iCheckCode) throws Exception
  {
    String strPowerValue = "";

   /*��ȡȨ��ȡֵ*/
    strPowerValue = getPowerValue(dbManager,
                                  iUserCode,
                                  iRiskCode,
                                  iTaskCode,
                                  iCheckCode);

   /*�����Ϊ0���߲�Ϊ�գ���˵���в���Ȩ��*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

   /*�����Ƿ���ȨȨ��*/
    strPowerValue = getGrantValue(dbManager,
                                  iUserCode,
                                  iRiskCode,
                                  iTaskCode,
                                  iCheckCode);

   /*�����Ϊ0���߲�Ϊ�գ���˵���в���Ȩ��*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

    return false;

  }

  /**
   * ���������Ա���Ƿ�������ĳ������������͵�Ȩ��(�˵�Ȩ���������޹�)
   * @param  iUserCode    Ա������
   * @param  iRiskCode    ���ִ���
   * @param  iGroupCode   Ȩ�����
   * @param  iTaskCode    �������
   * @param  iCheckCode   Ȩ�޲�������(r:�� x:ִ�� w��д k�����ˣ�
   * @return blnfound    �Ƿ���в���Ȩ�ޣ���Ȩ�޷���true����Ȩ�޷���false
   * @throws Exception   �쳣
   */
  public boolean checkPower(DBManager dbManager,
                            String iUserCode,
                            String iRiskCode,
                            String iGroupCode,
                            String iTaskCode,
                            String iCheckCode) throws Exception
  {
    String strPowerValue = "";

   /*��ȡȨ��ȡֵ*/
    strPowerValue = getPowerValue(dbManager,
                                  iUserCode,
                                  iRiskCode,
                                  iGroupCode,
                                  iTaskCode,
                                  iCheckCode);

   /*�����Ϊ0���߲�Ϊ�գ���˵���в���Ȩ��*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

   /*�����Ƿ���ȨȨ��*/
    strPowerValue = getGrantValue(dbManager,
                                  iUserCode,
                                  iGroupCode,
                                  iTaskCode,
                                  iCheckCode);

   /*�����Ϊ0���߲�Ϊ�գ���˵���в���Ȩ��*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

    return false;

  }



  /**
   * ��ȡ������Ա�����ĳ������ĳ������������͵�Ȩ��ȡֵ
   * @param  iUserCode    Ա������
   * @param  iRiskCode    ���ִ���
   * @param  iTaskCode    �������
   * @param  iCheckCode   Ȩ�޲�������(r:�� x:ִ�� w��д k�����ˣ�
   * @return strPowerValue    ���ظ�������Ȩ�޵ľ���ֵ
   * @throws Exception   �쳣
   */
  public String getPowerValue(DBManager dbManager,
                              String iUserCode,
                              String iRiskCode,
                              String iTaskCode,
                              String iCheckCode) throws Exception
  {
    String strGroupCode = "";
    String strPowerValue = "";
    Collection userGradeList = new ArrayList();
    PrpUserGradeDto prpUserGradeDto = null;  //�û�Ȩ��DTO
    DBPrpDrisk dbPrpDrisk = null;
    PrpDriskDto   prpDriskDto   = null;
    DBPrpUserGrade dbPrpUserGrade = null;
    //System.out.println("----getPowerValue----2---");  
    /*��ȡ������������Ϣ*/
    dbPrpDrisk  = new DBPrpDrisk(dbManager);
    prpDriskDto = dbPrpDrisk.findByPrimaryKey(iRiskCode);
    //System.out.println("----prpDriskDto-"+prpDriskDto);
    if ( prpDriskDto == null )
    {
      return strPowerValue;
    }
    else
    {
        strGroupCode = prpDriskDto.getGroupCode();
    } 
 

    /*��ȡ������Ա��Ȩ����Ϣ*/
    dbPrpUserGrade = new DBPrpUserGrade(dbManager);
    prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(iUserCode,strGroupCode,iTaskCode,iCheckCode);
    //System.out.println("----prpUserGradeDto-"+iUserCode+"|"+strGroupCode+"|"+iTaskCode+"|"+iCheckCode);
    if ( prpUserGradeDto == null )
    {
      return strPowerValue;
    }
    else
    {
        strPowerValue = prpUserGradeDto.getValue() ;
    }


    /*Ȩ��ȡֵ��Ϊ0*/
    if ( strPowerValue.trim().equals("0") == false)
    {
      return strPowerValue;
    }
    //System.out.println("----strPowerValue-"+strPowerValue);
    /*Ȩ��ȡֵΪ0��ʾ������Ȩ�ޣ���ȡ��Ȩ��Ϣ*/
    strPowerValue = getGrantValue(dbManager,iUserCode,strGroupCode,iTaskCode,iCheckCode);

    return strPowerValue;
  }
  /**
   * ��ȡ������Ա�����ĳ������ĳ������������͵�Ȩ��ȡֵ(�˵�Ȩ���������޹�)
   * @param  iUserCode    Ա������
   * @param  iGroupCode   Ȩ�����
   * @param  iTaskCode    �������
   * @param  iCheckCode   Ȩ�޲�������(r:�� x:ִ�� w��д k�����ˣ�
   * @return strPowerValue    ���ظ�������Ȩ�޵ľ���ֵ
   * @throws Exception   �쳣
   */
  public String getPowerValue(DBManager dbManager,
                              String iUserCode,
                              String iRiskCode,
                              String iGroupCode,
                              String iTaskCode,
                              String iCheckCode) throws Exception
  {
    String strGroupCode = "";
    String strPowerValue = "";
    Collection userGradeList = new ArrayList();
    PrpUserGradeDto prpUserGradeDto = null;  //�û�Ȩ��DTO
    DBPrpDrisk dbPrpDrisk = null;
    DBPrpUserGrade dbPrpUserGrade = null;

    strGroupCode = iGroupCode;


    /*��ȡ������Ա��Ȩ����Ϣ*/
    dbPrpUserGrade = new DBPrpUserGrade(dbManager);
    prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(iUserCode,iGroupCode,iTaskCode,iCheckCode);
    if ( prpUserGradeDto == null )
    {
      return strPowerValue;
    }
    else
    {
        strPowerValue = prpUserGradeDto.getValue() ;
    }

    /*Ȩ��ȡֵ��Ϊ0*/
    if ( strPowerValue.trim().equals("0") == false)
    {
      return strPowerValue;
    }

    /*Ȩ��ȡֵΪ0��ʾ������Ȩ�ޣ���ȡ��Ȩ��Ϣ*/
    strPowerValue = getGrantValue(dbManager,iUserCode,strGroupCode,iTaskCode,iCheckCode);

    return strPowerValue;
  }


  /**
   * ��ȡ������Ա�����ĳ������ĳ������������͵���Ȩȡֵ
   * @param DBManage  DBManager
   * @param iUserCode String
   * @param iGroupCode String
   * @param iTaskCode String
   * @param iCheckCode String
   * @throws Exception
   * @return String
   */
  private String getGrantValue(DBManager dbManager,
                               String iUserCode,
                               String iGroupCode,
                               String iTaskCode,
                               String iCheckCode) throws Exception
  {
    String grantValue = "";
    String statement = "";
    Collection grantArrayList = new ArrayList();
    DBPrpGrant dbPrpGrant = null;

    /*��ȡ���������ļ�¼*/
    statement = " UserCode = '" + iUserCode + "'" +
                      " AND GroupCode = '" + iGroupCode + "'" +
                      " AND TaskCode = '" + iTaskCode + "'" +
                      " AND CheckCode = '" + iCheckCode + "'" +
                      " And CURRENT_DATE BETWEEN GrantStartDate AND GrantEndDate ";
    dbPrpGrant = new DBPrpGrant(dbManager);
    grantArrayList = dbPrpGrant.findByConditions(statement);
    if (grantArrayList == null )
    {
      grantValue = "0";
      return grantValue;
    }

    /*��ȡ��1������*/
    for (Iterator iterator = grantArrayList.iterator();iterator.hasNext();)
    {
      grantValue = ((PrpGrantDto) iterator.next()).getValue();
      break;
    }
    return grantValue;

  }


  /**
   * ��ȡ������Ա�����ĳ������ĳ������ĳ���������͵���Ȩ����
   * @param iUserCode String
   * @param iGroupCode String
   * @param iTaskCode String
   * @param iTableName String
   * @throws Exception
   * @return String
   */
  private String getGrantCondition(String iUserCode,
                                   String iGroupCode,
                                   String iTaskCode,
                                   String iTableName)  throws Exception
  {
    String grantCondition = "";
    grantCondition = "1=0";
    return grantCondition;
  }


  /**
   * ��ȡ������Ա�����ĳ������ĳ������ĳ���������͵Ĳ�ѯ������Ȩ������
   * @param  iUserCode    Ա������
   * @param  iRiskCode    ���ִ���
   * @param  iTaskCode    �������
   * @param  iTableName   ���ݱ���
   * @return strCondition  �����������͵Ĳ�ѯ������Ȩ��������������AND...����
   * @throws Exception   �쳣
   */
  public String getPowerCondition(DBManager dbManager,
                                  String iUserCode,
                                  String iRiskCode,
                                  String iTaskCode,
                                  String iTableName) throws Exception
  { 
    //System.out.println("--getPowerCondition-1-");  	
   /* ����Ȩ������ */  
    String strCondition = "";
   /* Ȩ������ */
    String strPowerCondition = "";
   /* ��Ȩ���� */
    String strGrantCondition = "";
   /* Ȩ����� */
    String strGroupCode = "";
   /* �������� */
    String strComCode = "";
   /* Ȩ��ȡֵ */
    String strPowerValue = "";
    int intRet = 0;

    DBPrpDrisk     dbPrpDrisk     = null;
    DBPrpDuser     dbPrpDuser     = null;
    DBPrpUserGrade dbPrpUserGrade = null;
    PrpDuserDto    prpDuserDto    = null;
    PrpDriskDto    prpDriskDto    = null ;
    PrpUserGradeDto prpUserGradeDto = null;

    /*��ȡ������Ա����Ϣ*/
    dbPrpDuser = new DBPrpDuser(dbManager);
    prpDuserDto = dbPrpDuser.findByPrimaryKey(iUserCode) ;
    //System.out.println("--prpDuserDto-1-"+prpDuserDto); 
    if ( prpDuserDto ==null )
    {
      strPowerCondition = " and 1=0 ";
      return strPowerCondition;
    }
    else
    {
      strComCode = prpDuserDto.getComCode();
    }
    /*��ȡ������������Ϣ*/ 
    dbPrpDrisk = new DBPrpDrisk(dbManager);
    prpDriskDto = dbPrpDrisk.findByPrimaryKey(iRiskCode);
    //System.out.println("--prpDriskDto-1-"+iRiskCode); 
    if ( prpDriskDto == null )
    {
      strPowerCondition = " and 1=0 ";
      return strPowerCondition;
    }
    else
    {
        strGroupCode = prpDriskDto.getGroupCode();
    }

    /*��ȡ������Ա��Ȩ����Ϣ*/
    dbPrpUserGrade = new DBPrpUserGrade(dbManager);
    //ystem.out.println("---prpUserGradeDto--1--"+iUserCode+"|"+strGroupCode+"|"+iTaskCode+"|"+AppConfig.get("sysconst.CHECKCODE_READ")+"|");    
    prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(iUserCode,strGroupCode,iTaskCode,AppConfig.get("sysconst.CHECKCODE_READ"));
    //System.out.println("---prpUserGradeDto--2--"+prpUserGradeDto);
    if ( prpUserGradeDto == null )
    {
      strPowerCondition = " and 1=0 ";
      return strPowerCondition;
    }
    else
    {
        strPowerValue = prpUserGradeDto.getValue();
    }

   //System.out.println("---strPowerValue----"+strPowerValue);
    /*��ȡ��Ȩ������*/
    /* ��Ȩ�� */
   
    if ( strPowerValue.trim().equals("0") )
    {
      strPowerCondition = " 1=0 ";
    }
    else if ( strPowerValue.trim().equals("1") )
    {
     /* ������ */
      strPowerCondition = " 1=1 ";
    }
    else if ( strPowerValue.trim().equals("2") )
    {
     /* ʡȨ��*/
     /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*���Ӹ���Ա������(����/����)��ҵ����������*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);
    }   
    else if ( strPowerValue.trim().equals("3") )
    {
     /* �ֹ�˾��Ȩ��*/
            /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*���Ӹ���Ա������(����/����)��ҵ����������*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);

    }
    else if ( strPowerValue.trim().equals("4") )
    {
     /* ��֧��˾Ȩ��*/
            /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*���Ӹ���Ա������(����/����)��ҵ����������*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);

    }
    else if ( strPowerValue.trim().equals("5") )
    {
      /* Ӫ����Ȩ��*/
            /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*���Ӹ���Ա������(����/����)��ҵ����������*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);
    }
    else if ( strPowerValue.trim().equals("6") )
    {
      /* ����Ȩ��*/
            /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*���Ӹ���Ա������(����/����)��ҵ����������*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);
    }
    else if ( strPowerValue.trim().equals("9") )
    {   
        /* ����Ȩ��*/
            /*���ݸ���Ա����ȡ����(����/����)��ҵ����������*/
      strPowerCondition = getUserCondition(dbManager,iUserCode,iTableName);
    }
    else
    {

      strPowerCondition = " 1=0 ";
    }
   /*������Ȩ����*/
   //����Ȩ����δ����ʲôʱ������������������������������
    strGrantCondition = getGrantCondition(iUserCode,strGroupCode,iTaskCode,iTableName);
    if ( strGrantCondition.length() == 0)
    {
      strCondition = " AND (" + strPowerCondition + " )";
    }
    else
    {
      strCondition = " AND (" + strPowerCondition + " OR " + strGrantCondition + " )";
    }
    return strCondition;
  }

/**
 * ��ȡ������Ա�����ĳ������ĳ������ĳ���������͵Ĳ�ѯ������Ȩ������(�������޹�)
 * @param  iUserCode    Ա������
 * @param  iRiskCode    ���ִ���
 * @param  iGroupCode   Ȩ����Ŵ���
 * @param  iTaskCode    �������
 * @param  iTableName   ���ݱ���
 * @return strCondition  �����������͵Ĳ�ѯ������Ȩ��������������AND...����
 * @throws Exception   �쳣
 */
public String getPowerCondition(DBManager dbManager,
                                String iUserCode,
                                String iRiskCode,
                                String iGroupCode,
                                String iTaskCode,
                                String iTableName) throws Exception
{
 /* ����Ȩ������ */
  String strCondition = "";
 /* Ȩ������ */
  String strPowerCondition = "";
 /* ��Ȩ���� */
  String strGrantCondition = "";
 /* Ȩ����� */
  String strGroupCode = "";
 /* �������� */
  String strComCode = "";
 /* Ȩ��ȡֵ */
  String strPowerValue = "";
  int intRet = 0;

  DBPrpDrisk        dbPrpDrisk     = null;
  DBPrpDuser        dbPrpDuser     = null;
  DBPrpUserGrade    dbPrpUserGrade = null;
  PrpDuserDto       prpDuserDto    = null;
  PrpUserGradeDto   prpUserGradeDto= null;


  /*��ȡ������Ա����Ϣ*/
  dbPrpDuser = new DBPrpDuser(dbManager);
  prpDuserDto = dbPrpDuser.findByPrimaryKey(iUserCode);
  if ( prpDuserDto == null )
  {
    strPowerCondition = " and 1=0 ";
    return strPowerCondition;
  }
  else
  {
    strComCode = prpDuserDto.getComCode();
  }

  strGroupCode = iGroupCode;

  /*��ȡ������Ա��Ȩ����Ϣ*/
  dbPrpUserGrade = new DBPrpUserGrade(dbManager);
  prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(iUserCode,strGroupCode,iTaskCode,AppConfig.get("syscont.CHECKCODE_READ"));
  if ( prpUserGradeDto == null )
  {
    strPowerCondition = " and 1=0 ";
    return strPowerCondition;
  }
  else
  {
    strPowerValue = prpUserGradeDto.getValue();
  }

  /*��ȡ��Ȩ������*/
  /* ��Ȩ�� */
  if ( strPowerValue.trim().equals("0") )
  {
    strPowerCondition = " 1=0 ";
  }
  else if ( strPowerValue.trim().equals("1") )
  {
   /* ������ */
    strPowerCondition = " 1=1 ";
  }
  else if ( strPowerValue.trim().equals("2") )
  {
   /* ʡȨ��*/
        /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*���Ӹ���Ա������(����/����)��ҵ����������*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);
  }
  else if ( strPowerValue.trim().equals("3") )
  {
   /* ����Ȩ��*/
          /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*���Ӹ���Ա������(����/����)��ҵ����������*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);

  }
  else if ( strPowerValue.trim().equals("4") )
  {
   /* ����Ȩ��*/
          /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*���Ӹ���Ա������(����/����)��ҵ����������*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);


  }
  else if ( strPowerValue.trim().equals("5") )
  {
    /* ����Ȩ��*/
          /*���ݻ�����ȡҵ�����ݵ�Ȩ������*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*���Ӹ���Ա������(����/����)��ҵ����������*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);
  }
  else if ( strPowerValue.trim().equals("9") )
  {
      /* ����Ȩ��*/
      /*���ݸ���Ա����ȡ����(����/����)��ҵ����������*/
    strPowerCondition = getUserCondition(dbManager,iUserCode,iTableName);
  }
  else
  {

    strPowerCondition = " 1=0 ";
  }
 /*������Ȩ����*/
 //����Ȩ����δ����ʲôʱ������������������������������
  strGrantCondition = getGrantCondition(iUserCode,strGroupCode,iTaskCode,iTableName);
  if ( strGrantCondition.length() == 0)
  {
    strCondition = " AND (" + strPowerCondition + " )";
  }
  else
  {
    strCondition = " AND (" + strPowerCondition + " OR " + strGrantCondition + " )";
  }
  return strCondition;
}


/**
 * ���ݸ����Ļ��������ȡ���¼�������ϵ��Ȩ������
 * @param dbManager DBManager
 * @param iOrginComCode String
 * @param iComCode String
 * @param iPowerValue String
 * @param iType String
 * @throws Exception
 * @return String
 */
private String getRecurseCompanyCondition(DBManager dbManager,
                                          String iOrginComCode,//ԭʼ��������
                                          String iComCode, //��ǰ��������
                                          String iPowerValue,
                                          String iType) throws Exception
{
  String strRecurseCondition = "";
  String statement = "";
  String strCurrentComCode ="";
  Collection companyList = new ArrayList();
  DBPrpDcompany dbPrpDcompany = null;

  if ( (iPowerValue.trim().equals("2") == true ) ||
       (iPowerValue.trim().equals("3") == true ) )
  {
    strRecurseCondition = "";
    return strRecurseCondition;
  }

  /*��ȡ�ϼ��������ڴ���Ļ�����������*/
  statement = " UpperComCode = '" + iComCode+"'";
  dbPrpDcompany = new DBPrpDcompany(dbManager);
  companyList = dbPrpDcompany.findByConditions(statement);
  if (companyList == null || ((ArrayList)companyList).size() ==0 )
  {
    strRecurseCondition = "";
    return strRecurseCondition;
  }

  for (Iterator iterator = companyList.iterator(); iterator.hasNext(); )
  {
    strCurrentComCode = ( (PrpDcompanyDto)iterator.next()).getComCode();
    /*�����ǰ��������ʹ���Ļ����������*/
    if (strCurrentComCode.trim().equals(iComCode.trim()))
    {
      continue;
    } 

    if (iType.trim().equals("1"))
    {
      strRecurseCondition = strRecurseCondition + ",'" +strCurrentComCode + "'";
             /*�ݹ��ȡ����*/
      strRecurseCondition = strRecurseCondition +
                            getRecurseCompanyCondition(dbManager,iOrginComCode,strCurrentComCode,iPowerValue,iType);
    }
    else if (iType.trim().equals("2")) 
    {
        strRecurseCondition = strRecurseCondition + ",'" +strCurrentComCode + "'";
        /*�ݹ��ȡ����*/
        strRecurseCondition = strRecurseCondition +
                       getRecurseCompanyCondition(dbManager,iOrginComCode,strCurrentComCode,iPowerValue,iType);
    }
  } 

  return strRecurseCondition;
}

/*���ݸ�����Ա�������ȡȨ������*/
private String getUserCondition(DBManager dbManager,String iUserCode,String iTableName) throws Exception
{
  String strCondition = "";
  String[] strUser= {"handlercode","operatorcode","handler1code"};
  StringBuffer strBuffer = null;
  boolean blnFound  = false;
  DBCommonSQL  dbCommonSQL = new DBCommonSQL(dbManager);
  for(int i = 0; i< strUser.length;i++)
  {
    blnFound = dbCommonSQL.checkSysColumns(iTableName,strUser[i]);
   /*������ֶ��Ƿ����*/
    if ( blnFound == true )
    {
      strCondition = strCondition + " OR " + iTableName + "."
                   + strUser[i] + "='" + iUserCode +"'";
    }
  }

  if ( strCondition.length()== 0)
  {
    strCondition = "1=0";
    return strCondition;
  }

  strCondition = " " + strCondition + ")";
  strBuffer = new StringBuffer(strCondition);
  strBuffer.replace(0,4,"   (");
  strCondition = strBuffer.toString();
  return strCondition;
} 
 
/**
 * ���ݸ����Ļ��������ȡȨ������
 * @param dbManager DBManager
 * @param iTableName String
 * @param iComCode String
 * @param iPowerValue String
 * @throws Exception
 * @return String
 */
private String getCompanyCondition(DBManager dbManager,
                                   String iTableName,
                                   String iComCode,
                                   String iPowerValue) throws Exception
{ 
  String strCondition = "";
  String strRecurseCondition = "";
  String strPowerConfigFlag = AppConfig.get("sysconst.POWER_CONFIG_FLAG");    
  //System.out.println("------strPowerConfigFlag-----"+strPowerConfigFlag);
  String strUpperComcode = "";
  int intResult = 0;
  String strComLevel = "";
  DBPrpDcompany dbPrpDcompany = null;
   /*ʡȨ��*/
  if (iPowerValue.trim().equals("2"))
  {
    //strCondition = "SUBSTR(" + iTableName + ".ComCode,1,2)='" + iComCode.substring(0,2) + "'";
    strCondition = iTableName + ".ComCode like '" + iComCode.substring(0,2) + "%'";
    return strCondition;
  }

   /*�ֹ�˾Ȩ��*/
  if (iPowerValue.trim().equals("3"))
  {
    //strCondition = "SUBSTR(" + iTableName + ".ComCode,1,4)='" + iComCode.substring(0,4) + "'";
    strCondition = iTableName + ".ComCode like '" + iComCode.substring(0,4) + "%'";
    return strCondition;
  }

   /*��֧��˾Ȩ��*/
  if (iPowerValue.trim().equals("4"))
  {
      strUpperComcode = iComCode;
      /*�����ݲ���iComCode���ϼ�������ֱ���ҵ���һ������Ϊ"��֧"���Ļ���*/
      while(!strComLevel.equals("4"))
      {  
        dbPrpDcompany = new DBPrpDcompany(dbManager);
        PrpDcompanyDto prpDcompanyDto =dbPrpDcompany.findByPrimaryKey(strUpperComcode);
        strComLevel = prpDcompanyDto.getComLevel();
        if(Integer.parseInt(DataUtils.nullToZero(strComLevel)) < 4)
           break; 
        strUpperComcode = prpDcompanyDto.getUpperComCode();
        iComCode = prpDcompanyDto.getComCode();
      } 
      /*�ݹ����iComCode��������������*/
      strRecurseCondition = iTableName + ".ComCode IN ( '" + iComCode + "'";
      strCondition = strRecurseCondition
                     + getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")
                     + ")";
      return strCondition;
  }

   /*����Ȩ��*/
  if (iPowerValue.trim().equals("5"))
  {
    strUpperComcode = iComCode;
    /*�����ݲ���iComCode���ϼ�������ֱ���ҵ���һ������Ϊ"��֧"���Ļ���*/
    while(!strComLevel.equals("5"))
    {  
      dbPrpDcompany = new DBPrpDcompany(dbManager);
      PrpDcompanyDto prpDcompanyDto =dbPrpDcompany.findByPrimaryKey(strUpperComcode);
      strComLevel = prpDcompanyDto.getComLevel();
      if(Integer.parseInt(DataUtils.nullToZero(strComLevel)) < 5)
         break; 
      strUpperComcode = prpDcompanyDto.getUpperComCode();
      iComCode = prpDcompanyDto.getComCode();
    } 
    /*�ݹ����iComCode��������������*/
    strRecurseCondition = iTableName + ".ComCode IN ( '" + iComCode + "'";
    strCondition = strRecurseCondition+ getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")+ ")";
    return strCondition;
  }

  /*����Ȩ��*/
  if (iPowerValue.trim().equals("6"))
  {
    strRecurseCondition = iTableName + ".ComCode IN ( '" + iComCode + "'";
    /*����Ȩ�����ò�����ѡ��Ȩ�޹�������*/
    if (strPowerConfigFlag.trim().equals("1") == true)
    {
      /*��ȡ���¼���������Ȩ������*/
      strCondition = strRecurseCondition +
                     getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")
                   + ")";
    }
    else
    {
      /*�������¼���������Ȩ������*/
      strCondition = strRecurseCondition +
                     getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")
                   + ")";
    }
    return strCondition;
  }
  
  return strCondition;
}


/**
 * �˶Բ���Ա�Ƿ��ܹ���½��Ӧϵͳ
 * @param  iUserCode    Ա������
 * @param  iSystemName  ��½ϵͳ����("prp","account","reins","visa","underwrite")
 * @return blnfound    �Ƿ��ܹ���½��־���ܹ���½����true�����ܵ�½����false
 * @throws Exception   �쳣
 */
public boolean checkLogin(DBManager dbManager,String userCode,String systemName) throws Exception
{
  boolean blnReturn = false;
  DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
  PrpDuserDto prpDuserDto = new PrpDuserDto();

  prpDuserDto = dbPrpDuser.findByPrimaryKey(userCode);

  if (prpDuserDto == null)
  { 
    return false;
  }

  /*�����Ҫʹ��ͨ��Ȩ�ޣ�����뵥��ʹ���µ����ݱ�����*/
  if (systemName.trim().equals(AppConfig.get("sysonst.SYSTEMNAME")))  //����ҵ��ϵͳ
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(0,1).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }
  /*�����Ҫʹ��ͨ��Ȩ�ޣ�����뵥��ʹ���µ����ݱ�����*/
  if (systemName.trim().equals(AppConfig.get("sysonst.SYSTEMCLAIM")))  //����ҵ��ϵͳ
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(0,1).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }

  if (systemName.trim().toLowerCase().equals(AppConfig.get("sysonst.SYSTEM_ACCOUNT")))  //����ϵͳ
  {
    if (prpDuserDto.getLoginSystem().substring(1,2).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }

  if (systemName.trim().toLowerCase().equals(AppConfig.get("sysonst.SYSTEM_REINS")))   //�ٱ���ϵͳ
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(2,3).equals("1"))
    {
      return true;
    }
    else
    {
        return false;
    }
  }

  if (systemName.trim().equals(AppConfig.get("sysonst.SYSTEM_VISA")))  //��֤����ϵͳ
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(3,4).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }

  if (systemName.trim().toLowerCase().equals(AppConfig.get("sysonst.SYSTEM_UNDERWRITE")))  //�˱�����ϵͳ
  {
    if (prpDuserDto.getLoginSystem().substring(4,5).equals("1"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  return false;
}


/**
 * �˶Բ���Ա�����Ƿ���ȷ
 * @param  iUserCode    Ա������
 * @param  iPassword    Ա������
 * @return true/false   �����Ƿ���ȷ��־����ȷ����true�����󷵻�false
 * @throws Exception    �쳣
 */
public boolean checkPassword(DBManager dbManager,String userCode,String password) throws Exception
{
  DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
  int    count          = -1 ;
  String encryptCode   = "" ;//���ܺ���ַ���
  String statement     = "" ;//SQL
  BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
  /*���ý����㷨*/
   //�����ļ��ܳ�����
  encryptCode   =  blEncryptFacade.getEncryptCode(password);
  statement = " userCode='" + userCode + "' AND passwork='" + encryptCode + "'";
  count = dbPrpDuser.getCount(statement);
  if (count <= 0)
  {
    return false;
  }
  else
  {
      return true;
  }

}

/**
 * �˶Բ���Աӡ���Ƿ���ȷ
 * @param  userCode    Ա������
 * @param  seal        ӡ��
 * @return true/false    �����Ƿ���ȷ��־����ȷ����true�����󷵻�false
 * @throws Exception   �쳣
 */
public boolean checkSeal(DBManager dbManager,String userCode,String seal) throws Exception
{
  DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
  String statement     = "" ;//SQL
  int    count         = -1;//��ѯ���
  String encryptCode   = "" ;//���ܺ���ַ���

  BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
  /*���ý����㷨*/
   //�����ļ��ܳ�����
  encryptCode   =  blEncryptFacade.getEncryptCode(seal);
  statement = " userCode='" + userCode + "' AND seal='" + encryptCode + "'";
  count = dbPrpDuser.getCount(statement);
  if (count <= 0)
  {
    return false;
  }
  else
  {
      return true;
  }

}



}
