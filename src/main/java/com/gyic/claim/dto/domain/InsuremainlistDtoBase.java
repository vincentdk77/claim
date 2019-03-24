package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保清单头表的数据传输对象基类<br>
 */
public class InsuremainlistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性投保清单编号 */
    private String inusrelistcode = "";
    /** 属性区域代码 */
    private String fareacode = "";
    /** 属性险类 */
    private String classcode = "";
    /** 属性险种 */
    private String riskcode = "";
    /** 属性投保单号 */
    private String proposalno = "";
    /** 属性保单号码 */
    private String policyno = "";
    /** 属性清单标志 */
    private String validity = "";
    /** 属性上次编辑代码 */
    private String updatecode = "";
    /** 属性上次编辑时间 */
    private DateTime updatedate = new DateTime();
    /** 属性操作员代码 */
    private String opcode = "";
    /** 属性投保备注 */
    private String remark = "";
    /** 属性保险起期 */
    private DateTime starttime = new DateTime();
    /** 属性保险止期 */
    private DateTime endtime = new DateTime();

    /**
     *  默认构造方法,构造一个默认的InsuremainlistDtoBase对象
     */
    public InsuremainlistDtoBase(){
    }

    /**
     * 设置属性投保清单编号
     * @param inusrelistcode 待设置的属性投保清单编号的值
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * 获取属性投保清单编号
     * @return 属性投保清单编号的值
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * 设置属性区域代码
     * @param fareacode 待设置的属性区域代码的值
     */
    public void setFareacode(String fareacode){
        this.fareacode = StringUtils.rightTrim(fareacode);
    }

    /**
     * 获取属性区域代码
     * @return 属性区域代码的值
     */
    public String getFareacode(){
        return fareacode;
    }

    /**
     * 设置属性险类
     * @param classcode 待设置的属性险类的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性险类
     * @return 属性险类的值
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * 设置属性险种
     * @param riskcode 待设置的属性险种的值
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * 设置属性投保单号
     * @param proposalno 待设置的属性投保单号的值
     */
    public void setProposalno(String proposalno){
        this.proposalno = StringUtils.rightTrim(proposalno);
    }

    /**
     * 获取属性投保单号
     * @return 属性投保单号的值
     */
    public String getProposalno(){
        return proposalno;
    }

    /**
     * 设置属性保单号码
     * @param policyno 待设置的属性保单号码的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性清单标志
     * @param validity 待设置的属性清单标志的值
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * 获取属性清单标志
     * @return 属性清单标志的值
     */
    public String getValidity(){
        return validity;
    }

    /**
     * 设置属性上次编辑代码
     * @param updatecode 待设置的属性上次编辑代码的值
     */
    public void setUpdatecode(String updatecode){
        this.updatecode = StringUtils.rightTrim(updatecode);
    }

    /**
     * 获取属性上次编辑代码
     * @return 属性上次编辑代码的值
     */
    public String getUpdatecode(){
        return updatecode;
    }

    /**
     * 设置属性上次编辑时间
     * @param updatedate 待设置的属性上次编辑时间的值
     */
    public void setUpdatedate(DateTime updatedate){
        this.updatedate = updatedate;
    }

    /**
     * 获取属性上次编辑时间
     * @return 属性上次编辑时间的值
     */
    public DateTime getUpdatedate(){
        return updatedate;
    }

    /**
     * 设置属性操作员代码
     * @param opcode 待设置的属性操作员代码的值
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * 设置属性投保备注
     * @param remark 待设置的属性投保备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性投保备注
     * @return 属性投保备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性保险起期
     * @param starttime 待设置的属性保险起期的值
     */
    public void setStarttime(DateTime starttime){
        this.starttime = starttime;
    }

    /**
     * 获取属性保险起期
     * @return 属性保险起期的值
     */
    public DateTime getStarttime(){
        return starttime;
    }

    /**
     * 设置属性保险止期
     * @param endtime 待设置的属性保险止期的值
     */
    public void setEndtime(DateTime endtime){
        this.endtime = endtime;
    }

    /**
     * 获取属性保险止期
     * @return 属性保险止期的值
     */
    public DateTime getEndtime(){
        return endtime;
    }
}
