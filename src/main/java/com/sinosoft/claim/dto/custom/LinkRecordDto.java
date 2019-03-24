package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 自定义预赔数据传输对象
 * <p>Title: 车险理赔预赔DTO</p>
 * <p>Description: 车险理赔预赔样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class LinkRecordDto implements Serializable
{
  /** 单位*/
  private String comCode; 
  /** 单位名称*/
  private String comName;
  /** 赔案编号－即赔案号*/
  private String claimNo;
  /** 接报案日期*/
  private DateTime reportDate = new DateTime();
  /** 抄单日期 */
  private DateTime copyPolicyDate = new DateTime();
  /** 与客户联系日期 */
  private DateTime linkCustomDate = new DateTime();
  /** 现场查勘日期*/
  private DateTime checkDate = new DateTime();
  /** 结案日期*/
  private DateTime endCaseDate = new DateTime();
  /** 单证收齐日期*/
  private DateTime finishDocDate = new DateTime();
  private Collection prpLregistExtList = new ArrayList();
  private PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();

  public LinkRecordDto()
  {
  }

  /**得到归属机构
   * @return 归属机构
   */
  public String getComCode()
  {
    return comCode;
  }

  /**设置归属机构
   * @param comCode 归属机构
   */
  public void setComCode(String comCode)
  {
     this.comCode = comCode;
  }
  /**得到归属机构名称
   * @return 归属机构名称
   */
  public String getComName()
  {
    return comName;
  }

  /**设置归属机构名称
   * @param comName 归属机构名称
   */
  public void setComName(String comName)
  {
     this.comName = comName;
  }
  
  /**得到赔案号
   * @return 赔案号
   */
  public String getClaimNo()
  {
    return claimNo;
  }

  /**设置赔案号
   * @param claimNo 赔案号
   */
  public void setClaimNo(String claimNo)
  {
     this.claimNo = claimNo;
  }
  
  /**得到接报案日期
   * @return 接报案日期
   */
  public DateTime getReportDate()
  {
    return reportDate;
  }

  /**设置接报案日期
   * @param reportDate 接报案日期
   */
  public void setReportDate(DateTime reportDate)
  {
     this.reportDate = reportDate;
  }
  
  /**得到抄单日期
   * @return 抄单日期
   */
  public DateTime getCopyPolicyDate()
  {
    return copyPolicyDate;
  }

  /**设置抄单日期
   * @param copyPolicyDate 抄单日期
   */
  public void setCopyPolicyDate(DateTime copyPolicyDate)
  {
     this.copyPolicyDate = copyPolicyDate;
  }

  /**得到现场查勘日期
   * @return 现场查勘日期
   */
  public DateTime getCheckDate()
  {
    return checkDate;
  }

  /**设置现场查勘日期
   * @param checkDate 现场查勘日期
   */
  public void setCheckDate(DateTime checkDate)
  {
     this.checkDate = checkDate;
  }

  /**得到与客户联系日期
   * @return 与客户联系日期
   */
  public DateTime getLinkCustomDate()
  {
    return linkCustomDate;
  }

  /**设置与客户联系日期
   * @param linkCustomDate 与客户联系日期
   */
  public void setLinkCustomDate(DateTime linkCustomDate)
  {
     this.linkCustomDate = linkCustomDate;
  }

  /**得到结案日期
   * @return 结案日期
   */
  public DateTime getEndCaseDate()
  {
    return endCaseDate;
  }

  /**设置结案日期
   * @param endCaseDate 结案日期
   */
  public void setEndCaseDate(DateTime endCaseDate)
  {
     this.endCaseDate = endCaseDate;
  }

  /**得到单证收齐日期
   * @return 单证收齐日期
   */
  public DateTime getFinishDocDate()
  {
    return finishDocDate;
  }

  /**设置单证收齐日期
   * @param finishDocDate 单证收齐日期
   */
  public void setFinishDocDate(DateTime finishDocDate)
  {
     this.finishDocDate = finishDocDate;
  }

  /**得到联系报案记录列表
   * @return 联系报案记录列表
   */
  public Collection getPrpLregistExtList()
  {
    return prpLregistExtList;
  }

  /**设置联系报案记录列表
   * @param prpLregistExtList 联系报案记录列表
   */
  public void setPrpLregistExtList(Collection prpLregistExtList)
  {
     this.prpLregistExtList = prpLregistExtList;
  }
  
 
}
