package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcertifyImg的数据传输对象类<br>
 * 创建于 2004-07-05 17:15:52.448<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertifyImgDto extends PrpLcertifyImgDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLcertifyImgDto对象
     */
    public PrpLcertifyImgDto(){
    }
    /** 集合 **/
    Collection certifyImgList;
    /** 编辑类型 */
    private String editType = "";

    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";

    /**得到单证的操作状态
    * @return 单证的操作状态
    */
     public String getStatus() {
       return status;
     }

    /**设置单证的操作状态
    * @param status 单证的操作状态
    */
     public void setStatus(String status) {
       this.status = status;
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
    public Collection getCertifyImgList() {
      return certifyImgList;
    }

    /**设置单证集合
    * @param certifyCollectList 单证集合
    */
    public void setCertifyImgList(Collection certifyImgList) {
      this.certifyImgList = certifyImgList;
    }
}
