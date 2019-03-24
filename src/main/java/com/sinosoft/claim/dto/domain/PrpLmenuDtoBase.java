package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLmenu-菜单表(新增)的数据传输对象基类<br>
 * 创建于 2005-05-08 15:15:50.687<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLmenuDtoBase implements Serializable{
    /** 属性菜单功能代码 */
    private String funcID = "";
    /** 属性菜单级别 */
    private String funcLevel = "";
    /** 属性上一级菜单 */
    private String parentID = "";
    /** 属性中文名称 */
    private String funcCName = "";
    /** 属性英文名称 */
    private String funcEName = "";
    /** 属性功能类型 */
    private String funcType = "";
    /** 属性使用标志 */
    private String useFlag = "";
    /** 属性菜单标题图片 */
    private String image = "";
    /** 属性展开菜单的图片 */
    private String imageExpand = "";
    /** 属性合上菜单的图片 */
    private String imageCollapse = "";
    /** 属性任务代码 */
    private String taskCode = "";
    /** 属性权限检验代码 */
    private String checkCode = "";
    /** 属性展开菜单的图标 */
    private String iconExpand = "";
    /** 属性合上菜单的图标 */
    private String iconCollapse = "";
    /** 属性参数 */
    private String param = "";
    /** 属性模块名称 */
    private String modelName = "";
    /** 属性排序 */
    private int sortNo = 0;
    /** 属性Flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLmenuDtoBase对象
     */
    public PrpLmenuDtoBase(){
    }

    /**
     * 设置属性菜单功能代码
     * @param funcID 待设置的属性菜单功能代码的值
     */
    public void setFuncID(String funcID){
        this.funcID = StringUtils.rightTrim(funcID);
    }

    /**
     * 获取属性菜单功能代码
     * @return 属性菜单功能代码的值
     */
    public String getFuncID(){
        return funcID;
    }

    /**
     * 设置属性菜单级别
     * @param funcLevel 待设置的属性菜单级别的值
     */
    public void setFuncLevel(String funcLevel){
        this.funcLevel = StringUtils.rightTrim(funcLevel);
    }

    /**
     * 获取属性菜单级别
     * @return 属性菜单级别的值
     */
    public String getFuncLevel(){
        return funcLevel;
    }

    /**
     * 设置属性上一级菜单
     * @param parentID 待设置的属性上一级菜单的值
     */
    public void setParentID(String parentID){
        this.parentID = StringUtils.rightTrim(parentID);
    }

    /**
     * 获取属性上一级菜单
     * @return 属性上一级菜单的值
     */
    public String getParentID(){
        return parentID;
    }

    /**
     * 设置属性中文名称
     * @param funcCName 待设置的属性中文名称的值
     */
    public void setFuncCName(String funcCName){
        this.funcCName = StringUtils.rightTrim(funcCName);
    }

    /**
     * 获取属性中文名称
     * @return 属性中文名称的值
     */
    public String getFuncCName(){
        return funcCName;
    }

    /**
     * 设置属性英文名称
     * @param funcEName 待设置的属性英文名称的值
     */
    public void setFuncEName(String funcEName){
        this.funcEName = StringUtils.rightTrim(funcEName);
    }

    /**
     * 获取属性英文名称
     * @return 属性英文名称的值
     */
    public String getFuncEName(){
        return funcEName;
    }

    /**
     * 设置属性功能类型
     * @param funcType 待设置的属性功能类型的值
     */
    public void setFuncType(String funcType){
        this.funcType = StringUtils.rightTrim(funcType);
    }

    /**
     * 获取属性功能类型
     * @return 属性功能类型的值
     */
    public String getFuncType(){
        return funcType;
    }

    /**
     * 设置属性使用标志
     * @param useFlag 待设置的属性使用标志的值
     */
    public void setUseFlag(String useFlag){
        this.useFlag = StringUtils.rightTrim(useFlag);
    }

    /**
     * 获取属性使用标志
     * @return 属性使用标志的值
     */
    public String getUseFlag(){
        return useFlag;
    }

    /**
     * 设置属性菜单标题图片
     * @param image 待设置的属性菜单标题图片的值
     */
    public void setImage(String image){
        this.image = StringUtils.rightTrim(image);
    }

    /**
     * 获取属性菜单标题图片
     * @return 属性菜单标题图片的值
     */
    public String getImage(){
        return image;
    }

    /**
     * 设置属性展开菜单的图片
     * @param imageExpand 待设置的属性展开菜单的图片的值
     */
    public void setImageExpand(String imageExpand){
        this.imageExpand = StringUtils.rightTrim(imageExpand);
    }

    /**
     * 获取属性展开菜单的图片
     * @return 属性展开菜单的图片的值
     */
    public String getImageExpand(){
        return imageExpand;
    }

    /**
     * 设置属性合上菜单的图片
     * @param imageCollapse 待设置的属性合上菜单的图片的值
     */
    public void setImageCollapse(String imageCollapse){
        this.imageCollapse = StringUtils.rightTrim(imageCollapse);
    }

    /**
     * 获取属性合上菜单的图片
     * @return 属性合上菜单的图片的值
     */
    public String getImageCollapse(){
        return imageCollapse;
    }

    /**
     * 设置属性任务代码
     * @param taskCode 待设置的属性任务代码的值
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * 获取属性任务代码
     * @return 属性任务代码的值
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置属性权限检验代码
     * @param checkCode 待设置的属性权限检验代码的值
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * 获取属性权限检验代码
     * @return 属性权限检验代码的值
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * 设置属性展开菜单的图标
     * @param iconExpand 待设置的属性展开菜单的图标的值
     */
    public void setIconExpand(String iconExpand){
        this.iconExpand = StringUtils.rightTrim(iconExpand);
    }

    /**
     * 获取属性展开菜单的图标
     * @return 属性展开菜单的图标的值
     */
    public String getIconExpand(){
        return iconExpand;
    }

    /**
     * 设置属性合上菜单的图标
     * @param iconCollapse 待设置的属性合上菜单的图标的值
     */
    public void setIconCollapse(String iconCollapse){
        this.iconCollapse = StringUtils.rightTrim(iconCollapse);
    }

    /**
     * 获取属性合上菜单的图标
     * @return 属性合上菜单的图标的值
     */
    public String getIconCollapse(){
        return iconCollapse;
    }

    /**
     * 设置属性参数
     * @param param 待设置的属性参数的值
     */
    public void setParam(String param){
        this.param = StringUtils.rightTrim(param);
    }

    /**
     * 获取属性参数
     * @return 属性参数的值
     */
    public String getParam(){
        return param;
    }

    /**
     * 设置属性模块名称
     * @param modelName 待设置的属性模块名称的值
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * 获取属性模块名称
     * @return 属性模块名称的值
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * 设置属性排序
     * @param sortNo 待设置的属性排序的值
     */
    public void setSortNo(int sortNo){
        this.sortNo = sortNo;
    }

    /**
     * 获取属性排序
     * @return 属性排序的值
     */
    public int getSortNo(){
        return sortNo;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }
}
