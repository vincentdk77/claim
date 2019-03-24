package com.sinosoft.claim.dto.custom;

/**
 * 接收页面参数，拼接SQL中WHERE部分用的类<br>
 * <p>Title: ParameterDto</p>
 * 创建于 2005-03-11 11:20:45.203<br>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author zhangshengli
 * @version 1.0
 */
public class ParameterDto
{
  /**SQL连接运算符：AND、OR*/
  private String linkSign = "";
  /**出现在连接运算符后、字段名称前的符号，如“(”，注意赋值时符号中都不含空格，空格在DBCommon中添加*/
  private String leftFlag1 = "";
  /**字段名称，即在Condition中出现在字段*/
  private String itemColumn = "";
  /**参数运算符：= 精确查询、*模糊查询、0不等于、1大于等于、2大于、-1小于等于、-2小于*/
  private String parameterSign = "";
  /**出现在参数运算符后、参数值之前的符号，如“(”*/
  private String leftFlag2 = "";
  /**参数值*/
  private String parameterValue = "";
  /**与leftFlag2对应的符号，如“)”*/
  private String rightFlag2 = "";
  /**与leftFlag1对应的符号，如“)”*/
  private String rightFlag1 = "";

  /**
   * 默认构造方法,构造一个默认的ParameterDto对象
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

