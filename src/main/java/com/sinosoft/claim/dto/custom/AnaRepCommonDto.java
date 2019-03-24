package com.sinosoft.claim.dto.custom;
import java.util.ArrayList;
import java.util.Vector;

/**
 * �����������ݴ��������<br>
 * <p>Title: AnaRepCommonDto</p>
 * ������ 2004-07-30 11:20:45.203<br>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author zhangshengli
 * @version 1.0
 */

public class AnaRepCommonDto
{
  /**���ڷ�ҳ�ĵ�dto*/
  private AbstractDto abstractDto = null;
  /**���ý���*/
  private Vector configs = new Vector();
  /**��ѯ������������*/
  private ArrayList arrParameter = new ArrayList();
  /**�жϽ��������ѯ�����Ĳ���*/
  private String queryFlag = "";
  /**��ӦMidResultType.ResultType�����ֲ�ѯ����*/
  private String resultType = "";
  /**�Ƿ��ҳ�ı�־��!1&&!3��ҳ��1||3����ҳ������Ϊ����ԭ���ĳ�����ݣ���ԭ����this.queryStyle���жϵģ��汾�ȶ���Ӧ�޸�Ϊ��0����ҳ��1��ҳ*/
  private int pageFlag = 0;
  /**�ж��Ǻ��ֲ�ѯ�Ĳ�����0�Ӳ�ѯ���������ύ�ģ�1���ܲ�ѯ��2��ϸ��ѯ*/
  private int queryStyle = 0;
  /**�û�����*/
  private String logonUser = "";
  /**ҵ�������������*/
  private String comCode = ""; //�Ժ�������䣬��ͬ��ֵ��|�ָ��������������һһ��Ӧ
  /**ҵ�����������Ӧ�ı�*/
  private String comCodeTable = ""; //�Ժ�������䣬��ͬ��ֵ��|�ָ�
  /**ҵ�����������Ӧ���ֶ���*/
  private String comCodeColumn = ""; //�Ժ�������䣬��ͬ��ֵ��|�ָ�
  /**ҵ��������������Ƿ������SELECT�б��У�0�����֣�1����*/
  private int comCodeSelected = 1; //�Ժ�������䣬��ͬ��ֵ��|�ָ�
  /**�Ƿ񰴻����ּ���ѯ��0��1�ǣ��汾�ȶ����Ƿ�Ӧ�޸�Ϊint����*/
  private String companyFlag = "";
  /**���뷭�������*/
  private String translateType = "";
  /**�Ƿ�����EXCEL��־��0��1�ǣ��汾�ȶ����Ƿ�Ӧ�޸�Ϊint����*/
  private String excelFlag = "0";
  /**����Ҫ�����ѯ�ģ���Ҫ������FROM����ģ�����û����MidResultConfig�����ֶε����ݱ���������ж������|�ָ�*/
  private String otherTable = "";
  /**���ִ��룬�����жϲ�ѯ�Ǹ����ݿ�*/
  private String riskCode = "";

  private String reportType="";
  private String timeLimit="";  
  /**
   * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�AnaRepCommonDto����
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

