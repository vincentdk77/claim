package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplrepairfee修理费用清单的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLrepairFeeDto extends PrpLrepairFeeDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLrepairFeeDto对象
     */
    public PrpLrepairFeeDto(){
    }

    /** 集合 **/
    ArrayList repairFeeList;
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性经办人名称 */
    private String handlerName = "";

    private String prpLrepairFeePartCode = "";

    private String prpLrepairFeePartName = "";
    
    private String repairTypeName = "";
   

    /**
    * 设置属性部件代码
    * @param prpLrepairFeePartCode 待设置的属性部件代码
    */
   public void setPrpLrepairFeePartCode(String prpLrepairFeePartCode){
       this.prpLrepairFeePartCode = StringUtils.rightTrim(prpLrepairFeePartCode);
   }

   /**
    * 获取属性部件代码
    * @return 属性部件代码
    */
   public String getPrpLrepairFeePartCode(){
       return prpLrepairFeePartCode;
   }

   /**
    * 设置属性部件名称
    * @param prpLrepairFeePartCode 待设置的属性部件名称
    */
   public void setPrpLrepairFeePartName(String prpLrepairFeePartName){
       this.prpLrepairFeePartName = StringUtils.rightTrim(prpLrepairFeePartName);
   }

   /**
    * 获取属性部件名称
    * @return 属性部件名称
    */
   public String getPrpLrepairFeePartName(){
       return prpLrepairFeePartName;
   }


    /**
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }

    /**得到修理费用清单集合
    * @return 修理费用清单集合信息
    */
    public ArrayList getRepairFeeList() {
      return  repairFeeList;
    }

    public String getHandlerName() {
      return handlerName;
    }

  /**设置修理费用清单集合
    * @param repairFeeList 修理费用清单集合
    */
    public void setRepairFeeList(ArrayList repairFeeList) {
      this.repairFeeList = repairFeeList;
    }

    public void setHandlerName(String handlerName) {
      this.handlerName = handlerName;
    }
    
    /**
    * 获取属性部件代码
    * @return 属性部件代码
    */
   public String getRepairTypeName(){
       return repairTypeName;
   }

   /**
    * 设置属性部件名称
    * @param repairTypeName 待设置的属性部件名称
    */
   public void setRepairTypeName(String repairTypeName){
       this.repairTypeName = StringUtils.rightTrim(repairTypeName);
   }
  }
