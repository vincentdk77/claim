package com.sinosoft.function.power.bl.action.custom;
/**
 * <p>Title: 权限校验</p>
 * <p>Description: 理赔产品组权限校验基类Action</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔产品组 魏士鑫
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
   * 检验给定的员工是否具有针对某个险种某个任务操作类型的权限
   * @param  iUserCode    员工代码
   * @param  iRiskCode    险种代码
   * @param  iTaskCode    任务代码
   * @param  iCheckCode   权限操作代码(r:读 x:执行 w：写 k：复核）
   * @return blnfound    是否具有操作权限，有权限返回true，无权限返回false
   * @throws Exception   异常
   */
  public boolean checkPower(DBManager dbManager,
                            String iUserCode,
                            String iRiskCode,
                            String iTaskCode,
                            String iCheckCode) throws Exception
  {
    String strPowerValue = "";

   /*获取权限取值*/
    strPowerValue = getPowerValue(dbManager,
                                  iUserCode,
                                  iRiskCode,
                                  iTaskCode,
                                  iCheckCode);

   /*如果不为0或者不为空，则说明有操作权限*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

   /*检验是否授权权限*/
    strPowerValue = getGrantValue(dbManager,
                                  iUserCode,
                                  iRiskCode,
                                  iTaskCode,
                                  iCheckCode);

   /*如果不为0或者不为空，则说明有操作权限*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

    return false;

  }

  /**
   * 检验给定的员工是否具有针对某个任务操作类型的权限(菜单权限与险种无关)
   * @param  iUserCode    员工代码
   * @param  iRiskCode    险种代码
   * @param  iGroupCode   权限组号
   * @param  iTaskCode    任务代码
   * @param  iCheckCode   权限操作代码(r:读 x:执行 w：写 k：复核）
   * @return blnfound    是否具有操作权限，有权限返回true，无权限返回false
   * @throws Exception   异常
   */
  public boolean checkPower(DBManager dbManager,
                            String iUserCode,
                            String iRiskCode,
                            String iGroupCode,
                            String iTaskCode,
                            String iCheckCode) throws Exception
  {
    String strPowerValue = "";

   /*获取权限取值*/
    strPowerValue = getPowerValue(dbManager,
                                  iUserCode,
                                  iRiskCode,
                                  iGroupCode,
                                  iTaskCode,
                                  iCheckCode);

   /*如果不为0或者不为空，则说明有操作权限*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

   /*检验是否授权权限*/
    strPowerValue = getGrantValue(dbManager,
                                  iUserCode,
                                  iGroupCode,
                                  iTaskCode,
                                  iCheckCode);

   /*如果不为0或者不为空，则说明有操作权限*/
    if ( (strPowerValue.trim().equals("0") == false) &&
         (strPowerValue.trim().equals("") == false ) )
    {
      return true;
    }

    return false;

  }



  /**
   * 获取给定的员工针对某个险种某个任务操作类型的权限取值
   * @param  iUserCode    员工代码
   * @param  iRiskCode    险种代码
   * @param  iTaskCode    任务代码
   * @param  iCheckCode   权限操作代码(r:读 x:执行 w：写 k：复核）
   * @return strPowerValue    返回给定操作权限的具体值
   * @throws Exception   异常
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
    PrpUserGradeDto prpUserGradeDto = null;  //用户权限DTO
    DBPrpDrisk dbPrpDrisk = null;
    PrpDriskDto   prpDriskDto   = null;
    DBPrpUserGrade dbPrpUserGrade = null;
    //System.out.println("----getPowerValue----2---");  
    /*获取给定的险种信息*/
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
 

    /*获取给定的员工权限信息*/
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


    /*权限取值不为0*/
    if ( strPowerValue.trim().equals("0") == false)
    {
      return strPowerValue;
    }
    //System.out.println("----strPowerValue-"+strPowerValue);
    /*权限取值为0表示无正常权限，获取授权信息*/
    strPowerValue = getGrantValue(dbManager,iUserCode,strGroupCode,iTaskCode,iCheckCode);

    return strPowerValue;
  }
  /**
   * 获取给定的员工针对某个险种某个任务操作类型的权限取值(菜单权限与险种无关)
   * @param  iUserCode    员工代码
   * @param  iGroupCode   权限组号
   * @param  iTaskCode    任务代码
   * @param  iCheckCode   权限操作代码(r:读 x:执行 w：写 k：复核）
   * @return strPowerValue    返回给定操作权限的具体值
   * @throws Exception   异常
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
    PrpUserGradeDto prpUserGradeDto = null;  //用户权限DTO
    DBPrpDrisk dbPrpDrisk = null;
    DBPrpUserGrade dbPrpUserGrade = null;

    strGroupCode = iGroupCode;


    /*获取给定的员工权限信息*/
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

    /*权限取值不为0*/
    if ( strPowerValue.trim().equals("0") == false)
    {
      return strPowerValue;
    }

    /*权限取值为0表示无正常权限，获取授权信息*/
    strPowerValue = getGrantValue(dbManager,iUserCode,strGroupCode,iTaskCode,iCheckCode);

    return strPowerValue;
  }


  /**
   * 获取给定的员工针对某个险种某个任务操作类型的授权取值
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

    /*获取满足条件的记录*/
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

    /*获取第1条数据*/
    for (Iterator iterator = grantArrayList.iterator();iterator.hasNext();)
    {
      grantValue = ((PrpGrantDto) iterator.next()).getValue();
      break;
    }
    return grantValue;

  }


  /**
   * 获取给定的员工针对某个险种某个任务某个操作类型的授权条件
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
   * 获取给定的员工针对某个险种某个任务某个操作类型的查询（读）权限条件
   * @param  iUserCode    员工代码
   * @param  iRiskCode    险种代码
   * @param  iTaskCode    任务代码
   * @param  iTableName   数据表名
   * @return strCondition  给定操作类型的查询（读）权限条件，条件以AND...返回
   * @throws Exception   异常
   */
  public String getPowerCondition(DBManager dbManager,
                                  String iUserCode,
                                  String iRiskCode,
                                  String iTaskCode,
                                  String iTableName) throws Exception
  { 
    //System.out.println("--getPowerCondition-1-");  	
   /* 最终权限条件 */  
    String strCondition = "";
   /* 权限条件 */
    String strPowerCondition = "";
   /* 授权条件 */
    String strGrantCondition = "";
   /* 权限组号 */
    String strGroupCode = "";
   /* 机构代码 */
    String strComCode = "";
   /* 权限取值 */
    String strPowerValue = "";
    int intRet = 0;

    DBPrpDrisk     dbPrpDrisk     = null;
    DBPrpDuser     dbPrpDuser     = null;
    DBPrpUserGrade dbPrpUserGrade = null;
    PrpDuserDto    prpDuserDto    = null;
    PrpDriskDto    prpDriskDto    = null ;
    PrpUserGradeDto prpUserGradeDto = null;

    /*获取给定的员工信息*/
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
    /*获取给定的险种信息*/ 
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

    /*获取给定的员工权限信息*/
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
    /*获取读权限条件*/
    /* 无权限 */
   
    if ( strPowerValue.trim().equals("0") )
    {
      strPowerCondition = " 1=0 ";
    }
    else if ( strPowerValue.trim().equals("1") )
    {
     /* 无限制 */
      strPowerCondition = " 1=1 ";
    }
    else if ( strPowerValue.trim().equals("2") )
    {
     /* 省权限*/
     /*根据机构获取业务数据的权限条件*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*附加给定员工输入(经办/归属)的业务数据条件*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);
    }   
    else if ( strPowerValue.trim().equals("3") )
    {
     /* 分公司级权限*/
            /*根据机构获取业务数据的权限条件*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*附加给定员工输入(经办/归属)的业务数据条件*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);

    }
    else if ( strPowerValue.trim().equals("4") )
    {
     /* 中支公司权限*/
            /*根据机构获取业务数据的权限条件*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*附加给定员工输入(经办/归属)的业务数据条件*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);

    }
    else if ( strPowerValue.trim().equals("5") )
    {
      /* 营销部权限*/
            /*根据机构获取业务数据的权限条件*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*附加给定员工输入(经办/归属)的业务数据条件*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);
    }
    else if ( strPowerValue.trim().equals("6") )
    {
      /* 科室权限*/
            /*根据机构获取业务数据的权限条件*/
      strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
            /*附加给定员工输入(经办/归属)的业务数据条件*/
      strPowerCondition = strPowerCondition + " OR " +
                          getUserCondition(dbManager,iUserCode,iTableName);
    }
    else if ( strPowerValue.trim().equals("9") )
    {   
        /* 个人权限*/
            /*根据给定员工获取输入(经办/归属)的业务数据条件*/
      strPowerCondition = getUserCondition(dbManager,iUserCode,iTableName);
    }
    else
    {

      strPowerCondition = " 1=0 ";
    }
   /*附加授权条件*/
   //对授权处理未做，什么时候做？？？？？？？？？？？？？
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
 * 获取给定的员工针对某个险种某个任务某个操作类型的查询（读）权限条件(与险种无关)
 * @param  iUserCode    员工代码
 * @param  iRiskCode    险种代码
 * @param  iGroupCode   权限组号代码
 * @param  iTaskCode    任务代码
 * @param  iTableName   数据表名
 * @return strCondition  给定操作类型的查询（读）权限条件，条件以AND...返回
 * @throws Exception   异常
 */
public String getPowerCondition(DBManager dbManager,
                                String iUserCode,
                                String iRiskCode,
                                String iGroupCode,
                                String iTaskCode,
                                String iTableName) throws Exception
{
 /* 最终权限条件 */
  String strCondition = "";
 /* 权限条件 */
  String strPowerCondition = "";
 /* 授权条件 */
  String strGrantCondition = "";
 /* 权限组号 */
  String strGroupCode = "";
 /* 机构代码 */
  String strComCode = "";
 /* 权限取值 */
  String strPowerValue = "";
  int intRet = 0;

  DBPrpDrisk        dbPrpDrisk     = null;
  DBPrpDuser        dbPrpDuser     = null;
  DBPrpUserGrade    dbPrpUserGrade = null;
  PrpDuserDto       prpDuserDto    = null;
  PrpUserGradeDto   prpUserGradeDto= null;


  /*获取给定的员工信息*/
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

  /*获取给定的员工权限信息*/
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

  /*获取读权限条件*/
  /* 无权限 */
  if ( strPowerValue.trim().equals("0") )
  {
    strPowerCondition = " 1=0 ";
  }
  else if ( strPowerValue.trim().equals("1") )
  {
   /* 无限制 */
    strPowerCondition = " 1=1 ";
  }
  else if ( strPowerValue.trim().equals("2") )
  {
   /* 省权限*/
        /*根据机构获取业务数据的权限条件*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*附加给定员工输入(经办/归属)的业务数据条件*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);
  }
  else if ( strPowerValue.trim().equals("3") )
  {
   /* 地市权限*/
          /*根据机构获取业务数据的权限条件*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*附加给定员工输入(经办/归属)的业务数据条件*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);

  }
  else if ( strPowerValue.trim().equals("4") )
  {
   /* 区县权限*/
          /*根据机构获取业务数据的权限条件*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*附加给定员工输入(经办/归属)的业务数据条件*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);


  }
  else if ( strPowerValue.trim().equals("5") )
  {
    /* 科室权限*/
          /*根据机构获取业务数据的权限条件*/
    strPowerCondition = getCompanyCondition(dbManager,iTableName,strComCode,strPowerValue);
          /*附加给定员工输入(经办/归属)的业务数据条件*/
    strPowerCondition = strPowerCondition + " OR " +
                        getUserCondition(dbManager,iUserCode,iTableName);
  }
  else if ( strPowerValue.trim().equals("9") )
  {
      /* 个人权限*/
      /*根据给定员工获取输入(经办/归属)的业务数据条件*/
    strPowerCondition = getUserCondition(dbManager,iUserCode,iTableName);
  }
  else
  {

    strPowerCondition = " 1=0 ";
  }
 /*附加授权条件*/
 //对授权处理未做，什么时候做？？？？？？？？？？？？？
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
 * 根据给定的机构代码获取上下级隶属关系的权限条件
 * @param dbManager DBManager
 * @param iOrginComCode String
 * @param iComCode String
 * @param iPowerValue String
 * @param iType String
 * @throws Exception
 * @return String
 */
private String getRecurseCompanyCondition(DBManager dbManager,
                                          String iOrginComCode,//原始机构代码
                                          String iComCode, //当前机构代码
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

  /*获取上级机构等于传入的机构代码数据*/
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
    /*如果当前机构代码和传入的机构代码相等*/
    if (strCurrentComCode.trim().equals(iComCode.trim()))
    {
      continue;
    } 

    if (iType.trim().equals("1"))
    {
      strRecurseCondition = strRecurseCondition + ",'" +strCurrentComCode + "'";
             /*递归获取数据*/
      strRecurseCondition = strRecurseCondition +
                            getRecurseCompanyCondition(dbManager,iOrginComCode,strCurrentComCode,iPowerValue,iType);
    }
    else if (iType.trim().equals("2")) 
    {
        strRecurseCondition = strRecurseCondition + ",'" +strCurrentComCode + "'";
        /*递归获取数据*/
        strRecurseCondition = strRecurseCondition +
                       getRecurseCompanyCondition(dbManager,iOrginComCode,strCurrentComCode,iPowerValue,iType);
    }
  } 

  return strRecurseCondition;
}

/*根据给定的员工代码获取权限条件*/
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
   /*检验该字段是否存在*/
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
 * 根据给定的机构代码获取权限条件
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
   /*省权限*/
  if (iPowerValue.trim().equals("2"))
  {
    //strCondition = "SUBSTR(" + iTableName + ".ComCode,1,2)='" + iComCode.substring(0,2) + "'";
    strCondition = iTableName + ".ComCode like '" + iComCode.substring(0,2) + "%'";
    return strCondition;
  }

   /*分公司权限*/
  if (iPowerValue.trim().equals("3"))
  {
    //strCondition = "SUBSTR(" + iTableName + ".ComCode,1,4)='" + iComCode.substring(0,4) + "'";
    strCondition = iTableName + ".ComCode like '" + iComCode.substring(0,4) + "%'";
    return strCondition;
  }

   /*中支公司权限*/
  if (iPowerValue.trim().equals("4"))
  {
      strUpperComcode = iComCode;
      /*逐级上溯查找iComCode的上级机构，直至找到第一个级别为"中支"级的机构*/
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
      /*递归查找iComCode的所有下属机构*/
      strRecurseCondition = iTableName + ".ComCode IN ( '" + iComCode + "'";
      strCondition = strRecurseCondition
                     + getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")
                     + ")";
      return strCondition;
  }

   /*科室权限*/
  if (iPowerValue.trim().equals("5"))
  {
    strUpperComcode = iComCode;
    /*逐级上溯查找iComCode的上级机构，直至找到第一个级别为"中支"级的机构*/
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
    /*递归查找iComCode的所有下属机构*/
    strRecurseCondition = iTableName + ".ComCode IN ( '" + iComCode + "'";
    strCondition = strRecurseCondition+ getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")+ ")";
    return strCondition;
  }

  /*科室权限*/
  if (iPowerValue.trim().equals("6"))
  {
    strRecurseCondition = iTableName + ".ComCode IN ( '" + iComCode + "'";
    /*根据权限配置参数来选择权限构造条件*/
    if (strPowerConfigFlag.trim().equals("1") == true)
    {
      /*获取上下级归属机构权限条件*/
      strCondition = strRecurseCondition +
                     getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")
                   + ")";
    }
    else
    {
      /*附加上下级归属机构权限条件*/
      strCondition = strRecurseCondition +
                     getRecurseCompanyCondition(dbManager,iComCode,iComCode,iPowerValue,"1")
                   + ")";
    }
    return strCondition;
  }
  
  return strCondition;
}


/**
 * 核对操作员是否能够登陆相应系统
 * @param  iUserCode    员工代码
 * @param  iSystemName  登陆系统名称("prp","account","reins","visa","underwrite")
 * @return blnfound    是否能够登陆标志，能够登陆返回true，不能登陆返回false
 * @throws Exception   异常
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

  /*如果需要使用通用权限，则必须单独使用新的数据表？？？*/
  if (systemName.trim().equals(AppConfig.get("sysonst.SYSTEMNAME")))  //核心业务系统
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(0,1).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }
  /*如果需要使用通用权限，则必须单独使用新的数据表？？？*/
  if (systemName.trim().equals(AppConfig.get("sysonst.SYSTEMCLAIM")))  //理赔业务系统
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(0,1).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }

  if (systemName.trim().toLowerCase().equals(AppConfig.get("sysonst.SYSTEM_ACCOUNT")))  //财务系统
  {
    if (prpDuserDto.getLoginSystem().substring(1,2).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }

  if (systemName.trim().toLowerCase().equals(AppConfig.get("sysonst.SYSTEM_REINS")))   //再保险系统
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

  if (systemName.trim().equals(AppConfig.get("sysonst.SYSTEM_VISA")))  //单证管理系统
  {
    if (prpDuserDto.getLoginSystem().toLowerCase().substring(3,4).equals("1"))
    {
      return true;
    }
    else
    {   return false;

    }
  }

  if (systemName.trim().toLowerCase().equals(AppConfig.get("sysonst.SYSTEM_UNDERWRITE")))  //核保核赔系统
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
 * 核对操作员密码是否正确
 * @param  iUserCode    员工代码
 * @param  iPassword    员工密码
 * @return true/false   密码是否正确标志，正确返回true，错误返回false
 * @throws Exception    异常
 */
public boolean checkPassword(DBManager dbManager,String userCode,String password) throws Exception
{
  DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
  int    count          = -1 ;
  String encryptCode   = "" ;//加密后的字符串
  String statement     = "" ;//SQL
  BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
  /*调用解密算法*/
   //将明文加密成密文
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
 * 核对操作员印鉴是否正确
 * @param  userCode    员工代码
 * @param  seal        印鉴
 * @return true/false    密码是否正确标志，正确返回true，错误返回false
 * @throws Exception   异常
 */
public boolean checkSeal(DBManager dbManager,String userCode,String seal) throws Exception
{
  DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
  String statement     = "" ;//SQL
  int    count         = -1;//查询结果
  String encryptCode   = "" ;//加密后的字符串

  BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
  /*调用解密算法*/
   //将明文加密成密文
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
