package com.sinosoft.claim.dto.custom;
import java.util.ArrayList;
import java.util.Vector;

/**
 * 这是条件数据传输对象类<br>
 * <p>Title: AnaRepCommonDto</p>
 * 创建于 2004-07-30 11:20:45.203<br>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author zhangshengli
 * @version 1.0
 */

public class AnaRepCommonDto
{
  /**用于分页的的dto*/
  private AbstractDto abstractDto = null;
  /**配置界面*/
  private Vector configs = new Vector();
  /**查询条件参数集合*/
  private ArrayList arrParameter = new ArrayList();
  /**判断进行哪项查询操作的参数*/
  private String queryFlag = "";
  /**对应MidResultType.ResultType，区分查询类型*/
  private String resultType = "";
  /**是否分页的标志，!1&&!3分页、1||3不分页，这是为了与原来的程序兼容，因原是用this.queryStyle来判断的，版本稳定后应修改为：0不分页，1分页*/
  private int pageFlag = 0;
  /**判断是何种查询的参数：0从查询条件界面提交的，1汇总查询，2明细查询*/
  private int queryStyle = 0;
  /**用户代码*/
  private String logonUser = "";
  /**业务归属机构代码*/
  private String comCode = ""; //以后可以扩充，不同的值用|分隔，和下面的属性一一对应
  /**业务归属机构对应的表*/
  private String comCodeTable = ""; //以后可以扩充，不同的值用|分隔
  /**业务归属机构对应的字段名*/
  private String comCodeColumn = ""; //以后可以扩充，不同的值用|分隔
  /**业务归属机构代码是否出现在SELECT列表中：0不出现，1出现*/
  private int comCodeSelected = 1; //以后可以扩充，不同的值用|分隔
  /**是否按机构分级查询，0否，1是，版本稳定后，是否应修改为int类型*/
  private String companyFlag = "";
  /**代码翻译的类型*/
  private String translateType = "";
  /**是否生成EXCEL标志，0否，1是，版本稳定后，是否应修改为int类型*/
  private String excelFlag = "0";
  /**放需要联表查询的（即要出现在FROM后面的）、但没有在MidResultConfig配置字段的数据表名，如果有多个表用|分隔*/
  private String otherTable = "";
  /**险种代码，用来判断查询那个数据库*/
  private String riskCode = "";

  private String reportType="";
  private String timeLimit="";  
  /**
   * 默认构造方法,构造一个默认的AnaRepCommonDto对象
   */
  public AnaRepCommonDto()
  {
  }

  public void setAbstractDto(AbstractDto iAbstractDto)
  {
    this.abstractDto = iAbstractDto;
  }

  public AbstractDto getAbstractDto()
  {
    return abstractDto;
  }

  public void setConfigs(Vector iConfigs)
  {
    this.configs = iConfigs;
  }

  public Vector getConfigs()
  {
    return configs;
  }

  public void setArrParameter(ArrayList iArrParameter)
  {
    this.arrParameter = iArrParameter;
  }

  public ArrayList getArrParameter()
  {
    return arrParameter;
  }

  public void setQueryFlag(String iQueryFlag)
  {
    this.queryFlag = iQueryFlag;
  }

  public String getQueryFlag()
  {
    return queryFlag;
  }

  public void setResultType(String iResultType)
  {
    this.resultType = iResultType;
  }

  public String getResultType()
  {
    return resultType;
  }

  public void setPageFlag(int iPageFlag)
  {
    this.pageFlag = iPageFlag;
  }

  public int getPageFlag()
  {
    return pageFlag;
  }

  public void setQueryStyle(int iQueryStyle)
  {
    this.queryStyle = iQueryStyle;
  }

  public int getQueryStyle()
  {
    return queryStyle;
  }

  public void setLogonUser(String iLogonUser)
  {
    this.logonUser=iLogonUser;
  }

  public String getLogonUser()
  {
    return logonUser;
  }

  public void setComCode(String iComCode)
  {
    this.comCode = iComCode;
  }

  public String getComCode()
  {
    return comCode;
  }

  public void setComCodeTable(String iComCodeTable)
  {
    this.comCodeTable = iComCodeTable;
  }

  public String getComCodeTable()
  {
    return comCodeTable;
  }

  public void setComCodeColumn(String iComCodeColumn)
  {
    this.comCodeColumn = iComCodeColumn;
  }

  public String getComCodeColumn()
  {
    return comCodeColumn;
  }

  public void setComCodeSelected(int iComCodeSelected)
  {
    this.comCodeSelected = iComCodeSelected;
  }

  public int getComCodeSelected()
  {
    return comCodeSelected;
  }

  public void setCompanyFlag(String iCompanyFlag)
  {
    this.companyFlag = iCompanyFlag;
  }

  public String getCompanyFlag()
  {
    return companyFlag;
  }

  public void setTranslateType(String iTranslateType)
  {
    this.translateType = iTranslateType;
  }

  public String getTranslateType()
  {
    return translateType;
  }

  public void setExcelFlag(String iExcelFlag)
  {
    this.excelFlag = iExcelFlag;
  }

  public String getExcelFlag()
  {
    return excelFlag;
  }

  public void setOtherTable(String iOtherTable)
  {
    this.otherTable = iOtherTable;
  }

  public String getOtherTable()
  {
    return otherTable;
  }

  public void setRiskCode(String iRiskCode)
  {
    this.riskCode = iRiskCode;
  }

  public String getRiskCode()
  {
    return riskCode;
  }
  public void setReportType(String ireportType)
  {
    this.reportType = ireportType;
  }

  public String getReportType()
  {
    return reportType;
  }

  public void setTimeLimit(String itimeLimit)
  {
    this.timeLimit= itimeLimit;
  }

  public String getTimeLimit()
  {
    return timeLimit;
  }
  
}

