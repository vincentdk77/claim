package com.sinosoft.claim.dto.custom;

/**
 * ����ҳ�������ƴ��SQL��WHERE�����õ���<br>
 * <p>Title: ParameterDto</p>
 * ������ 2005-03-11 11:20:45.203<br>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author zhangshengli
 * @version 1.0
 */
public class ParameterDto
{
  /**SQL�����������AND��OR*/
  private String linkSign = "";
  /**������������������ֶ�����ǰ�ķ��ţ��硰(����ע�⸳ֵʱ�����ж������ո񣬿ո���DBCommon�����*/
  private String leftFlag1 = "";
  /**�ֶ����ƣ�����Condition�г������ֶ�*/
  private String itemColumn = "";
  /**�����������= ��ȷ��ѯ��*ģ����ѯ��0�����ڡ�1���ڵ��ڡ�2���ڡ�-1С�ڵ��ڡ�-2С��*/
  private String parameterSign = "";
  /**�����ڲ���������󡢲���ֵ֮ǰ�ķ��ţ��硰(��*/
  private String leftFlag2 = "";
  /**����ֵ*/
  private String parameterValue = "";
  /**��leftFlag2��Ӧ�ķ��ţ��硰)��*/
  private String rightFlag2 = "";
  /**��leftFlag1��Ӧ�ķ��ţ��硰)��*/
  private String rightFlag1 = "";

  /**
   * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�ParameterDto����
   */
  public  ParameterDto()
  {
  }

  public void setLinkSign(String iLinkSign)
  {
    this.linkSign = iLinkSign;
  }

  public String getLinkSign()
  {
    return linkSign;
  }

  public void setLeftFlag1(String iLeftFlag1)
  {
    this.leftFlag1 = iLeftFlag1;
  }

  public String getLeftFlag1()
  {
    return leftFlag1;
  }

  public void setItemColumn(String iItemColumn)
  {
     this.itemColumn = iItemColumn;
  }

  public String getItemColumn()
  {
    return itemColumn;
  }

  public void setParameterSign(String iParameterSign)
  {
     this.parameterSign = iParameterSign;
  }

  public String getParameterSign()
  {
    return parameterSign;
  }

  public void setLeftFlag2(String iLeftFlag2)
  {
    this.leftFlag2 = iLeftFlag2;
  }

  public String getLeftFlag2()
  {
    return leftFlag2;
  }

  public void setParameterValue(String iParameterValue)
  {
     this.parameterValue = iParameterValue;
  }

  public String getParameterValue()
  {
    return parameterValue;
  }

  public void setRightFlag2(String iRightFlag2)
  {
     this.rightFlag2 = iRightFlag2;
  }

  public String getRightFlag2()
  {
    return rightFlag2;
  }

  public void setRightFlag1(String iRightFlag1)
  {
     this.rightFlag1 = iRightFlag1;
  }

  public String getRightFlag1()
  {
    return rightFlag1;
  }
}

