package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplcomponent换件项目清单的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcomponentDto extends PrpLcomponentDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLcomponentDto对象
     */
    public PrpLcomponentDto(){
    }

    /** 集合 **/
    ArrayList componentList;
    /** 属性险别名称 */
    private String kindName = "";

    /** 属性出险次数 */
    private int perilCount = 0;

    /** 属性部件代码 */
    private String prpLcomponentPartCode = "";

    /** 属性部件名称 */
    private String prpLcomponentPartName = "";

    /** 属性经办人名称 */
    private String handlerName = "";
    
    /**
     * 设置属性部件代码
     * @param prpLcomponentPartCode 待设置的属性部件代码
     */
    public void setPrpLcomponentPartCode(String prpLcomponentPartCode){
        this.prpLcomponentPartCode = StringUtils.rightTrim(prpLcomponentPartCode);
    }

    /**
     * 获取属性部件代码
     * @return 属性部件代码
     */
    public String getPrpLcomponentPartCode(){
        return prpLcomponentPartCode;
    }

    /**
     * 设置属性部件名称
     * @param prpLcomponentPartName  待设置的属性部件名称
     */
    public void setPrpLcomponentPartName(String prpLcomponentPartName){
        this.prpLcomponentPartName = StringUtils.rightTrim(prpLcomponentPartName);
    }

    /**
     * 获取属性部件名称
     * @return 属性部件名称
     */
    public String getPrpLcomponentPartName(){
        return prpLcomponentPartName;
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

    /**得到换件项目清单集合
    * @return 换件项目清单集合信息
    */
    public ArrayList getComponentList() {
      return  componentList;
    }
    /**设置换件项目清单集合
    * @param componentList 换件项目清单集合
    */
    public void setComponentList(ArrayList componentList) {
      this.componentList = componentList;
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
    
    public String getHandlerName() {
        return handlerName;
      }
    
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
      }
}
