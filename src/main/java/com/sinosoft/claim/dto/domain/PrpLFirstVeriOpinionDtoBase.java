package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是初核意见表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLFirstVeriOpinionDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性报案号 */
    private String registNo = "";
    /** 属性交强险理算书号 */
    private String compensateBz = "";
    /** 属性商业险理算书号 */
    private String compensateBi = "";
    /** 属性事故类型 */
    private String accidentType = "";
    /** 属性出险原因 */
    private String occReason = "";
    /** 属性通融类型 */
    private String accommodType = "";
    /** 属性追偿类型 */
    private String recoveryType = "";
    /** 属性是否赔付 */
    private String peifuFlag = "";
    /** 属性赔付类型 */
    private String peifuType = "";
    /** 属性是否零结案 */
    private String lingjieAnFlag = "";
    /** 属性零结案类型 */
    private String lingjieAnType = "";
    /** 属性处理意见：1 特急通道 2 高风险客户 3 涉及诉讼 4 标的全损 5 需补传资料 */
    private String suggestionType = "";
    /** 属性赔付说明 */
    private String peifuIns = "";
    /** 属性节点 */
    private String nodeType = "";
    /** 属性欺诈标志 */
    private String fraudLogo = "";
    /** 属性欺诈挽回损失金额 */
    private double fraudRecoverAmount = 0.0;
    /** 属性欺诈类型 */
    private String fraudType = "";
    

    /**
     *  默认构造方法,构造一个默认的PrpLFirstVeriOpinionDtoBase对象
     */
    public PrpLFirstVeriOpinionDtoBase(){
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性交强险理算书号
     * @param compensateBz 待设置的属性交强险理算书号的值
     */
    public void setCompensateBz(String compensateBz){
        this.compensateBz = StringUtils.rightTrim(compensateBz);
    }

    /**
     * 获取属性交强险理算书号
     * @return 属性交强险理算书号的值
     */
    public String getCompensateBz(){
        return compensateBz;
    }

    /**
     * 设置属性商业险理算书号
     * @param compensateBi 待设置的属性商业险理算书号的值
     */
    public void setCompensateBi(String compensateBi){
        this.compensateBi = StringUtils.rightTrim(compensateBi);
    }

    /**
     * 获取属性商业险理算书号
     * @return 属性商业险理算书号的值
     */
    public String getCompensateBi(){
        return compensateBi;
    }

    /**
     * 设置属性事故类型
     * @param accidentType 待设置的属性事故类型的值
     */
    public void setAccidentType(String accidentType){
        this.accidentType = StringUtils.rightTrim(accidentType);
    }

    /**
     * 获取属性事故类型
     * @return 属性事故类型的值
     */
    public String getAccidentType(){
        return accidentType;
    }

    /**
     * 设置属性出险原因
     * @param occReason 待设置的属性出险原因的值
     */
    public void setOccReason(String occReason){
        this.occReason = StringUtils.rightTrim(occReason);
    }

    /**
     * 获取属性出险原因
     * @return 属性出险原因的值
     */
    public String getOccReason(){
        return occReason;
    }

    /**
     * 设置属性通融类型
     * @param accommodType 待设置的属性通融类型的值
     */
    public void setAccommodType(String accommodType){
        this.accommodType = StringUtils.rightTrim(accommodType);
    }

    /**
     * 获取属性通融类型
     * @return 属性通融类型的值
     */
    public String getAccommodType(){
        return accommodType;
    }

    /**
     * 设置属性追偿类型
     * @param recoveryType 待设置的属性追偿类型的值
     */
    public void setRecoveryType(String recoveryType){
        this.recoveryType = StringUtils.rightTrim(recoveryType);
    }

    /**
     * 获取属性追偿类型
     * @return 属性追偿类型的值
     */
    public String getRecoveryType(){
        return recoveryType;
    }

    /**
     * 设置属性是否赔付
     * @param peifuFlag 待设置的属性是否赔付的值
     */
    public void setPeifuFlag(String peifuFlag){
        this.peifuFlag = StringUtils.rightTrim(peifuFlag);
    }

    /**
     * 获取属性是否赔付
     * @return 属性是否赔付的值
     */
    public String getPeifuFlag(){
        return peifuFlag;
    }

    /**
     * 设置属性赔付类型
     * @param peifuType 待设置的属性赔付类型的值
     */
    public void setPeifuType(String peifuType){
        this.peifuType = StringUtils.rightTrim(peifuType);
    }

    /**
     * 获取属性赔付类型
     * @return 属性赔付类型的值
     */
    public String getPeifuType(){
        return peifuType;
    }

    /**
     * 设置属性是否零结案
     * @param lingjieAnFlag 待设置的属性是否零结案的值
     */
    public void setLingjieAnFlag(String lingjieAnFlag){
        this.lingjieAnFlag = StringUtils.rightTrim(lingjieAnFlag);
    }

    /**
     * 获取属性是否零结案
     * @return 属性是否零结案的值
     */
    public String getLingjieAnFlag(){
        return lingjieAnFlag;
    }

    /**
     * 设置属性零结案类型
     * @param lingjieAnType 待设置的属性零结案类型的值
     */
    public void setLingjieAnType(String lingjieAnType){
        this.lingjieAnType = StringUtils.rightTrim(lingjieAnType);
    }

    /**
     * 获取属性零结案类型
     * @return 属性零结案类型的值
     */
    public String getLingjieAnType(){
        return lingjieAnType;
    }

    /**
     * 设置属性处理意见：1 特急通道 2 高风险客户 3 涉及诉讼 4 标的全损 5 需补传资料
     * @param suggestionType 待设置的属性处理意见：1 特急通道 2 高风险客户 3 涉及诉讼 4 标的全损 5 需补传资料的值
     */
    public void setSuggestionType(String suggestionType){
        this.suggestionType = StringUtils.rightTrim(suggestionType);
    }

    /**
     * 获取属性处理意见：1 特急通道 2 高风险客户 3 涉及诉讼 4 标的全损 5 需补传资料
     * @return 属性处理意见：1 特急通道 2 高风险客户 3 涉及诉讼 4 标的全损 5 需补传资料的值
     */
    public String getSuggestionType(){
        return suggestionType;
    }

    /**
     * 设置属性赔付说明
     * @param peifuIns 待设置的属性赔付说明的值
     */
    public void setPeifuIns(String peifuIns){
        this.peifuIns = StringUtils.rightTrim(peifuIns);
    }

    /**
     * 获取属性赔付说明
     * @return 属性赔付说明的值
     */
    public String getPeifuIns(){
        return peifuIns;
    }

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getFraudLogo() {
		return fraudLogo;
	}

	public void setFraudLogo(String fraudLogo) {
		this.fraudLogo = fraudLogo;
	}

	public double getFraudRecoverAmount() {
		return fraudRecoverAmount;
	}

	public void setFraudRecoverAmount(double fraudRecoverAmount) {
		this.fraudRecoverAmount = fraudRecoverAmount;
	}

	public String getFraudType() {
		return fraudType;
	}

	public void setFraudType(String fraudType) {
		this.fraudType = fraudType;
	}
	
}
