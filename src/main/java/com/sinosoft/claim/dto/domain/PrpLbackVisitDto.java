package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLbackVisit--回访信息主表的数据传输对象类<br>
 * 创建于 2005-03-23 08:59:50.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitDto extends PrpLbackVisitDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLbackVisitDto对象
     */
    public PrpLbackVisitDto(){
    }

    /** 操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";

    /**
     * 设置属性操作状态
     * @param status 待设置的属性操作状态
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * 获取属性操作状态
     * @return 属性操作状态
     */
    public String getStatus(){
        return status;
    }

}
