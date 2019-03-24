package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcaddress保险地址表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertainLossDto extends PrpLcertainLossDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpCaddressDto对象
     */
    public PrpLcertainLossDto(){
    }

    /** 集合 **/
    Collection certainLossList;
    /** 编辑类型 */
    private String editType = "";
    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";  //Modify By Sunhao,2004-08-24
    /** 属性出险次数 */
    private int perilCount = 0;
    
    

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
    public Collection getCertainLossList() {
      return  certainLossList;
    }
    
    /**设置单证集合
    * @param certainLossList 单证集合
    */
    public void setCertainLossList(Collection certainLossList) {
      this.certainLossList = certainLossList;
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
    
}
