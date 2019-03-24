package com.sinosoft.claim.dto.domain;
import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplthirdparty理赔车辆信息的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLthirdPartyDto extends PrpLthirdPartyDtoBase implements Serializable{

   /**
     *  默认构造方法,构造一个默认的PrpLthirdPartyDto对象
     */
    public PrpLthirdPartyDto(){
    }

    /** 属性显示列表*/
    private Collection thirdPartyList ;
    
    /** 属性调度处理标志 */
    private String scheduleType = "";

    /** 属性是否选择发送 */
    private String selectSend = "";
    /** 属性是哪个节点的调用 */
    private String nodeType = "";
    /** 属性是险别*/
    private String prpLthirdPartyKindCode = "";
    /** 属性是三者车驾驶员姓名 */
    private String prpLthirdPartyDriveName = "";
    /** 属性是三者车驾驶员身份征*/
    private String prpLthirdPartyDriveLicensNo = "";    
    
    public String getPrpLthirdPartyDriveName() {
		return prpLthirdPartyDriveName;
	}

	public void setPrpLthirdPartyDriveName(String prpLthirdPartyDriveName) {
		this.prpLthirdPartyDriveName = prpLthirdPartyDriveName;
	}

	public String getPrpLthirdPartyDriveLicensNo() {
		return prpLthirdPartyDriveLicensNo;
	}

	public void setPrpLthirdPartyDriveLicensNo(
			String prpLthirdPartyDriveLicensNo) {
		this.prpLthirdPartyDriveLicensNo = prpLthirdPartyDriveLicensNo;
	}
	/**
     * 获取列表
     * @return 属性列表
     */
    public Collection getThirdPartyList(){
      return thirdPartyList;
    }
    /**
     * 设置列表
     * @param prpLthirdPartyRegistNo 待设置的列表
     */
    public void setThirdPartyList(Collection thirdPartyList) {
      this.thirdPartyList = thirdPartyList;
    }



    /**
     * 设置属性调度处理标志
     * @param scheduleType 待设置的属性调度处理标志的值
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * 获取属性调度处理标志
     * @return 属性调度处理标志的值
     */
    public String getScheduleType(){
        return scheduleType;
    }
    
    /**
     * 设置属性是否选择发送
     * @param selectSend 待设置的属性是否选择发送的值
     */
    public void setSelectSend(String selectSend){
        this.selectSend = StringUtils.rightTrim(selectSend);
    }

    /**
     * 获取属性是否选择发送
     * @return 属性是否选择发送的值
     */
    public String getSelectSend(){
        return selectSend;
    }

 
  /**
     * 设置属性节点类型
     * @param nodeType 待设置的属性节点类型的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性节点类型
     * @return 属性节点类型的值
     */
    public String getNodeType(){
        return nodeType;
    }
    
    /**
     * 设置属性险别类型
     * @param prpLthirdPartyKindCode 待设置的属性险别类型的值
     */
    public void setPrpLthirdPartyKindCode(String prpLthirdPartyKindCode){
        this.prpLthirdPartyKindCode = StringUtils.rightTrim(prpLthirdPartyKindCode);
    }

    /**
     * 获取属性险别类型
     * @return 属性险别类型的值
     */
    public String getPrpLthirdPartyKindCode(){
        return prpLthirdPartyKindCode;
    }
}
