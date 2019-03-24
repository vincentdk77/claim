package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgtask1任务日志表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGtask1DtoBase implements Serializable{
    /** 属性任务类型 */
    private String taskType = "";
    /** 属性模板号 */
    private int modelNo = 0;
    /** 属性案件标识号 */
    private String caseIdNo = "";
    /** 属性业务险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性出单人员代码 */
    private String operatorCode = "";
    /** 属性单证类型 */
    private String certiType = "";
    /** 属性单证号码 */
    private String certiNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性次数 */
    private int times = 0;
    /** 属性最大级别 */
    private int maxGrade = 0;
    /** 属性节点名称 */
    private String taskExplain = "";
    /** 属性流入时间 */
    private DateTime sysTime = new DateTime();
    /** 属性父节点号 */
    private int fatherNode = 0;
    /** 属性当前结点号 */
    private int currentNode = 0;
    /** 属性子结点号 */
    private int sonNode = 0;
    /** 属性预计时限 */
    private int limitDay = 0;
    /** 属性currentgrade */
    private int currentGrade = 0;
    /** 属性处理人员代码 */
    private String underWriteCode = "";
    /** 属性处理时间 */
    private DateTime dealDate = new DateTime();
    /** 属性节点状态 */
    private String dealResult = "";
    /** 属性处理文本 */
    private String handleText = "";
    /** 属性nextgrade */
    private int nextGrade = 0;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGtask1DtoBase对象
     */
    public PrpGtask1DtoBase(){
    }

    /**
     * 设置属性任务类型
     * @param taskType 待设置的属性任务类型的值
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * 获取属性任务类型
     * @return 属性任务类型的值
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * 设置属性模板号
     * @param modelNo 待设置的属性模板号的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性模板号
     * @return 属性模板号的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性案件标识号
     * @param caseIdNo 待设置的属性案件标识号的值
     */
    public void setCaseIdNo(String caseIdNo){
        this.caseIdNo = StringUtils.rightTrim(caseIdNo);
    }

    /**
     * 获取属性案件标识号
     * @return 属性案件标识号的值
     */
    public String getCaseIdNo(){
        return caseIdNo;
    }

    /**
     * 设置属性业务险类代码
     * @param classCode 待设置的属性业务险类代码的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性业务险类代码
     * @return 属性业务险类代码的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性归属机构代码
     * @param comCode 待设置的属性归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构代码
     * @return 属性归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性出单机构代码
     * @param makeCom 待设置的属性出单机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构代码
     * @return 属性出单机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性出单人员代码
     * @param operatorCode 待设置的属性出单人员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性出单人员代码
     * @return 属性出单人员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性单证类型
     * @param certiType 待设置的属性单证类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性单证类型
     * @return 属性单证类型的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性单证号码
     * @param certiNo 待设置的属性单证号码的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单证号码
     * @return 属性单证号码的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性次数
     * @param times 待设置的属性次数的值
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * 获取属性次数
     * @return 属性次数的值
     */
    public int getTimes(){
        return times;
    }

    /**
     * 设置属性最大级别
     * @param maxGrade 待设置的属性最大级别的值
     */
    public void setMaxGrade(int maxGrade){
        this.maxGrade = maxGrade;
    }

    /**
     * 获取属性最大级别
     * @return 属性最大级别的值
     */
    public int getMaxGrade(){
        return maxGrade;
    }

    /**
     * 设置属性节点名称
     * @param taskExplain 待设置的属性节点名称的值
     */
    public void setTaskExplain(String taskExplain){
        this.taskExplain = StringUtils.rightTrim(taskExplain);
    }

    /**
     * 获取属性节点名称
     * @return 属性节点名称的值
     */
    public String getTaskExplain(){
        return taskExplain;
    }

    /**
     * 设置属性流入时间
     * @param sysTime 待设置的属性流入时间的值
     */
    public void setSysTime(DateTime sysTime){
        this.sysTime = sysTime;
    }

    /**
     * 获取属性流入时间
     * @return 属性流入时间的值
     */
    public DateTime getSysTime(){
        return sysTime;
    }

    /**
     * 设置属性父节点号
     * @param fatherNode 待设置的属性父节点号的值
     */
    public void setFatherNode(int fatherNode){
        this.fatherNode = fatherNode;
    }

    /**
     * 获取属性父节点号
     * @return 属性父节点号的值
     */
    public int getFatherNode(){
        return fatherNode;
    }

    /**
     * 设置属性当前结点号
     * @param currentNode 待设置的属性当前结点号的值
     */
    public void setCurrentNode(int currentNode){
        this.currentNode = currentNode;
    }

    /**
     * 获取属性当前结点号
     * @return 属性当前结点号的值
     */
    public int getCurrentNode(){
        return currentNode;
    }

    /**
     * 设置属性子结点号
     * @param sonNode 待设置的属性子结点号的值
     */
    public void setSonNode(int sonNode){
        this.sonNode = sonNode;
    }

    /**
     * 获取属性子结点号
     * @return 属性子结点号的值
     */
    public int getSonNode(){
        return sonNode;
    }

    /**
     * 设置属性预计时限
     * @param limitDay 待设置的属性预计时限的值
     */
    public void setLimitDay(int limitDay){
        this.limitDay = limitDay;
    }

    /**
     * 获取属性预计时限
     * @return 属性预计时限的值
     */
    public int getLimitDay(){
        return limitDay;
    }

    /**
     * 设置属性currentgrade
     * @param currentGrade 待设置的属性currentgrade的值
     */
    public void setCurrentGrade(int currentGrade){
        this.currentGrade = currentGrade;
    }

    /**
     * 获取属性currentgrade
     * @return 属性currentgrade的值
     */
    public int getCurrentGrade(){
        return currentGrade;
    }

    /**
     * 设置属性处理人员代码
     * @param underWriteCode 待设置的属性处理人员代码的值
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * 获取属性处理人员代码
     * @return 属性处理人员代码的值
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * 设置属性处理时间
     * @param dealDate 待设置的属性处理时间的值
     */
    public void setDealDate(DateTime dealDate){
        this.dealDate = dealDate;
    }

    /**
     * 获取属性处理时间
     * @return 属性处理时间的值
     */
    public DateTime getDealDate(){
        return dealDate;
    }

    /**
     * 设置属性节点状态
     * @param dealResult 待设置的属性节点状态的值
     */
    public void setDealResult(String dealResult){
        this.dealResult = StringUtils.rightTrim(dealResult);
    }

    /**
     * 获取属性节点状态
     * @return 属性节点状态的值
     */
    public String getDealResult(){
        return dealResult;
    }

    /**
     * 设置属性处理文本
     * @param handleText 待设置的属性处理文本的值
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * 获取属性处理文本
     * @return 属性处理文本的值
     */
    public String getHandleText(){
        return handleText;
    }

    /**
     * 设置属性nextgrade
     * @param nextGrade 待设置的属性nextgrade的值
     */
    public void setNextGrade(int nextGrade){
        this.nextGrade = nextGrade;
    }

    /**
     * 获取属性nextgrade
     * @return 属性nextgrade的值
     */
    public int getNextGrade(){
        return nextGrade;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
