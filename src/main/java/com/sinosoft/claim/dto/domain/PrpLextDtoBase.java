package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLext的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLextDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLextDtoBase.class.getName().hashCode();
    /** 属性单号 */
    private String certiNo = "";
    /** 属性单号类型 */
    private String certiType = "";
    /** 属性第三者亡人数 */
    private long personDeathB = 0L;
    /** 属性车上人员亡人数 */
    private long personDeathD1 = 0L;
    /** 属性第三者伤人数 */
    private long personInjureB = 0L;
    /** 属性车上人员伤人数 */
    private long personInjureD1 = 0L;
    /** 属性承运人 */
    private String carrier = "";
    /** 属性开航日期 */
    private DateTime sailStartDate = new DateTime();
    /** 属性卸货日期 */
    private DateTime unloadDate = new DateTime();
    /** 属性申请查勘日期 */
    private DateTime appliCheckDate = new DateTime();
    /** 属性投保人或代表联系电话、传真 */
    private String appliPhone = "";
    /** 属性被保险人或代表联系电话、传真 */
    private String insuredPhone = "";
    /** 属性货损查勘公司 */
    private String cargoLossCheckCom = "";
    /** 属性货运险损失类型 */
    private String cargoLossType = "";
    /** 属性共损理算师 */
    private String shareClaimer = "";
    /** 属性救助人 */
    private String salvor = "";
    /** 属性是否需要海事担保 */
    private String guaranteeFlag = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性货价 */
    private double cargoValue = 0D;
    /** 属性救助担保金额 */
    private double salvaGuarantAmount = 0D;
    /** 属性残值数量 */
    private int restQuantity = 0;
    /** 属性担保人 */
    private String guarantor = "";
    /** 属性预留字段1 */
    private String value1 = "";
    /** 属性预留字段2 */
    private String value2 = "";
    /** 属性预留字段3 */
    private String value3 = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLextDtoBase对象
     */
    public PrpLextDtoBase(){
    }

    /**
     * 设置属性单号
     * @param certiNo 待设置的属性单号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单号
     * @return 属性单号的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性单号类型
     * @param certiType 待设置的属性单号类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性单号类型
     * @return 属性单号类型的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性第三者亡人数
     * @param personDeathB 待设置的属性第三者亡人数的值
     */
    public void setPersonDeathB(long personDeathB){
        this.personDeathB = personDeathB;
    }

    /**
     * 获取属性第三者亡人数
     * @return 属性第三者亡人数的值
     */
    public long getPersonDeathB(){
        return personDeathB;
    }

    /**
     * 设置属性车上人员亡人数
     * @param personDeathD1 待设置的属性车上人员亡人数的值
     */
    public void setPersonDeathD1(long personDeathD1){
        this.personDeathD1 = personDeathD1;
    }

    /**
     * 获取属性车上人员亡人数
     * @return 属性车上人员亡人数的值
     */
    public long getPersonDeathD1(){
        return personDeathD1;
    }

    /**
     * 设置属性第三者伤人数
     * @param personInjureB 待设置的属性第三者伤人数的值
     */
    public void setPersonInjureB(long personInjureB){
        this.personInjureB = personInjureB;
    }

    /**
     * 获取属性第三者伤人数
     * @return 属性第三者伤人数的值
     */
    public long getPersonInjureB(){
        return personInjureB;
    }

    /**
     * 设置属性车上人员伤人数
     * @param personInjureD1 待设置的属性车上人员伤人数的值
     */
    public void setPersonInjureD1(long personInjureD1){
        this.personInjureD1 = personInjureD1;
    }

    /**
     * 获取属性车上人员伤人数
     * @return 属性车上人员伤人数的值
     */
    public long getPersonInjureD1(){
        return personInjureD1;
    }

    /**
     * 设置属性承运人
     * @param carrier 待设置的属性承运人的值
     */
    public void setCarrier(String carrier){
        this.carrier = StringUtils.rightTrim(carrier);
    }

    /**
     * 获取属性承运人
     * @return 属性承运人的值
     */
    public String getCarrier(){
        return carrier;
    }

    /**
     * 设置属性开航日期
     * @param sailStartDate 待设置的属性开航日期的值
     */
    public void setSailStartDate(DateTime sailStartDate){
        this.sailStartDate = sailStartDate;
    }

    /**
     * 获取属性开航日期
     * @return 属性开航日期的值
     */
    public DateTime getSailStartDate(){
        return sailStartDate;
    }

    /**
     * 设置属性卸货日期
     * @param unloadDate 待设置的属性卸货日期的值
     */
    public void setUnloadDate(DateTime unloadDate){
        this.unloadDate = unloadDate;
    }

    /**
     * 获取属性卸货日期
     * @return 属性卸货日期的值
     */
    public DateTime getUnloadDate(){
        return unloadDate;
    }

    /**
     * 设置属性申请查勘日期
     * @param appliCheckDate 待设置的属性申请查勘日期的值
     */
    public void setAppliCheckDate(DateTime appliCheckDate){
        this.appliCheckDate = appliCheckDate;
    }

    /**
     * 获取属性申请查勘日期
     * @return 属性申请查勘日期的值
     */
    public DateTime getAppliCheckDate(){
        return appliCheckDate;
    }

    /**
     * 设置属性投保人或代表联系电话、传真
     * @param appliPhone 待设置的属性投保人或代表联系电话、传真的值
     */
    public void setAppliPhone(String appliPhone){
        this.appliPhone = appliPhone;
    }

    /**
     * 获取属性投保人或代表联系电话、传真
     * @return 属性投保人或代表联系电话、传真的值
     */
    public String getAppliPhone(){
        return appliPhone;
    }

    /**
     * 设置属性被保险人或代表联系电话、传真
     * @param insuredPhone 待设置的属性被保险人或代表联系电话、传真的值
     */
    public void setInsuredPhone(String insuredPhone){
        this.insuredPhone = insuredPhone;
    }

    /**
     * 获取属性被保险人或代表联系电话、传真
     * @return 属性被保险人或代表联系电话、传真的值
     */
    public String getInsuredPhone(){
        return insuredPhone;
    }

    /**
     * 设置属性货损查勘公司
     * @param cargoLossCheckCom 待设置的属性货损查勘公司的值
     */
    public void setCargoLossCheckCom(String cargoLossCheckCom){
        this.cargoLossCheckCom = StringUtils.rightTrim(cargoLossCheckCom);
    }

    /**
     * 获取属性货损查勘公司
     * @return 属性货损查勘公司的值
     */
    public String getCargoLossCheckCom(){
        return cargoLossCheckCom;
    }

    /**
     * 设置属性货运险损失类型
     * @param cargoLossType 待设置的属性货运险损失类型的值
     */
    public void setCargoLossType(String cargoLossType){
        this.cargoLossType = StringUtils.rightTrim(cargoLossType);
    }

    /**
     * 获取属性货运险损失类型
     * @return 属性货运险损失类型的值
     */
    public String getCargoLossType(){
        return cargoLossType;
    }

    /**
     * 设置属性共损理算师
     * @param shareClaimer 待设置的属性共损理算师的值
     */
    public void setShareClaimer(String shareClaimer){
        this.shareClaimer = StringUtils.rightTrim(shareClaimer);
    }

    /**
     * 获取属性共损理算师
     * @return 属性共损理算师的值
     */
    public String getShareClaimer(){
        return shareClaimer;
    }

    /**
     * 设置属性救助人
     * @param salvor 待设置的属性救助人的值
     */
    public void setSalvor(String salvor){
        this.salvor = StringUtils.rightTrim(salvor);
    }

    /**
     * 获取属性救助人
     * @return 属性救助人的值
     */
    public String getSalvor(){
        return salvor;
    }

    /**
     * 设置属性是否需要海事担保
     * @param guaranteeFlag 待设置的属性是否需要海事担保的值
     */
    public void setGuaranteeFlag(String guaranteeFlag){
        this.guaranteeFlag = StringUtils.rightTrim(guaranteeFlag);
    }

    /**
     * 获取属性是否需要海事担保
     * @return 属性是否需要海事担保的值
     */
    public String getGuaranteeFlag(){
        return guaranteeFlag;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性货价
     * @param cargoValue 待设置的属性货价的值
     */
    public void setCargoValue(double cargoValue){
        this.cargoValue = cargoValue;
    }

    /**
     * 获取属性货价
     * @return 属性货价的值
     */
    public double getCargoValue(){
        return cargoValue;
    }

    /**
     * 设置属性救助担保金额
     * @param salvaGuarantAmount 待设置的属性救助担保金额的值
     */
    public void setSalvaGuarantAmount(double salvaGuarantAmount){
        this.salvaGuarantAmount = salvaGuarantAmount;
    }

    /**
     * 获取属性救助担保金额
     * @return 属性救助担保金额的值
     */
    public double getSalvaGuarantAmount(){
        return salvaGuarantAmount;
    }

    /**
     * 设置属性残值数量
     * @param restQuantity 待设置的属性残值数量的值
     */
    public void setRestQuantity(int restQuantity){
        this.restQuantity = restQuantity;
    }

    /**
     * 获取属性残值数量
     * @return 属性残值数量的值
     */
    public int getRestQuantity(){
        return restQuantity;
    }

    /**
     * 设置属性担保人
     * @param guarantor 待设置的属性担保人的值
     */
    public void setGuarantor(String guarantor){
        this.guarantor = StringUtils.rightTrim(guarantor);
    }

    /**
     * 获取属性担保人
     * @return 属性担保人的值
     */
    public String getGuarantor(){
        return guarantor;
    }

    /**
     * 设置属性预留字段1
     * @param value1 待设置的属性预留字段1的值
     */
    public void setValue1(String value1){
        this.value1 = StringUtils.rightTrim(value1);
    }

    /**
     * 获取属性预留字段1
     * @return 属性预留字段1的值
     */
    public String getValue1(){
        return value1;
    }

    /**
     * 设置属性预留字段2
     * @param value2 待设置的属性预留字段2的值
     */
    public void setValue2(String value2){
        this.value2 = StringUtils.rightTrim(value2);
    }

    /**
     * 获取属性预留字段2
     * @return 属性预留字段2的值
     */
    public String getValue2(){
        return value2;
    }

    /**
     * 设置属性预留字段3
     * @param value3 待设置的属性预留字段3的值
     */
    public void setValue3(String value3){
        this.value3 = StringUtils.rightTrim(value3);
    }

    /**
     * 获取属性预留字段3
     * @return 属性预留字段3的值
     */
    public String getValue3(){
        return value3;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
