package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcertifyCollect的数据传输对象类<br>
 * 创建于 2004-07-05 17:15:52.378<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertifyCollectDto extends PrpLcertifyCollectDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLcertifyCollectDto对象
     */
    public PrpLcertifyCollectDto(){
    }  

    /** 集合 **/
    Collection certifyCollectList;
    /** 编辑类型 */
    private String editType = "";
    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";  // Modify By Sunhao,2004-08-24
    /**属性此案件的操作时间*/
    private DateTime operateDate = new DateTime(); // Modify By Sunhao,2004-08-24
    /**先别险别*/
    private String riskCode = "";
    /** 属性出险次数 */
    private int perilCount = 0;
    /**不能够提交的提示信息,如果为'',可以提交单证节点*/
    private String noSubmitMsg = "";
    
    //add by zhaolu 20060803 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060803 end

    public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	/**设置单证的操作状态
    * @param status 单证的操作状态
    * Modify By Sunhao,2004-08-24
    */
     public void setStatus(String status) {
       this.status = status;
     }

   /**得到单证的操作状态
    * @return 单证的操作状态
    * Modify By Sunhao,2004-08-24
    */
     public String getStatus() {
       return status;
     }


     /**
     * 设置属性操作时间
     * @param operateDate 待设置的属性操作时间
     * Modify By Sunhao,2004-08-24
     */
     public void setOperateDate(DateTime operateDate){
         this.operateDate = operateDate;
     }

     /**
      * 获取属性操作时间名称
      * @param status 待设置的属性操作时间
      * Modify By Sunhao,2004-08-24
      */

     public DateTime getOperateDate(){
          return operateDate;
      }

     /**
     * 设置编辑类型
     * @param editType 待设置的编辑类型的值
     */
    public void setEditType(String editType){
        this.editType = StringUtils.rightTrim(editType);
    }

    /**
     * 获取编辑类型
     * @return 属性编辑类型
     */
    public String getEditType(){
        return editType;
    }

    /**得到单证集合
    * @return 单证集合信息
    */
    public Collection getCertifyCollectList() {
      return  certifyCollectList;
    }

  public String getRiskCode() {
    return riskCode;
  }

  /**设置单证集合
    * @param certifyCollectList 单证集合
    */
    public void setCertifyCollectList(Collection certifyCollectList) {
      this.certifyCollectList = certifyCollectList;
    }

  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
  }
  
  
  /**
     * 设置属性出险次数
     * @param perilCount 待设置的属性出险次数的值
     */
    public void setPerilCount(int perilCount){
        this.perilCount = perilCount;
    }

    /**
     * 获取属性出险次数
     * @return 属性出险次数的值
     */
    public int getPerilCount(){
        return perilCount;
    }
    
     /**设置不能够提交的提示信息
    * @param noSubmitMsg 不能够提交的提示信息
    * 
    */
     public void setNoSubmitMsg(String noSubmitMsg) {
       this.noSubmitMsg = noSubmitMsg;
     }

   /**得到不能够提交的提示信息
    * @return 不能够提交的提示信息
    * 
    */
     public String getNoSubmitMsg() {
       return noSubmitMsg;
     }

}
