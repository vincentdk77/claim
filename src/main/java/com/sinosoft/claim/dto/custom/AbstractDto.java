package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 定义PeriodDto的数据传输对象类
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>@createdate 2003-12-30</p>
 * @author liuyang
 * @version 1.0
 */
public class AbstractDto implements Serializable{
    private String action;
    private String rgrade;
    private String wgrade;
    private String xgrade;
    private int    pageNo;
    private int    rowsCount;
    private int    rowsPerPage;
    private int    pageCount;  //页数
    private int    prePageNo;
    private int    nextPageNo;
    private String type;
    private String codeDescription;
    /**
     * 构造函数
     */
    public AbstractDto(){
        try{
            pageNo=1;
            rowsCount=0;
            rowsPerPage=Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        }catch(Exception e)
        {
        	System.out.println("取每页行数错误！");
        }
    }

    /**
     * 设置属性合同号
     * @param TreatyNo 合同号
     */
    public void setPageCount(int iPageCount)
    {
    	this.pageCount = iPageCount;
    }
    
    public int getPageCount()
    {
    	return pageCount;
    }

    public void setAction(String action){
        this.action = action;
    }

    public String getAction(){
        return action;
    }

    public void setRgrade(String rgrade){
        this.rgrade = rgrade;
    }

    public String getRgrade(){
        return rgrade;
    }

    public void setWgrade(String wgrade){
        this.wgrade = wgrade;
    }

    public String getWgrade(){
        return wgrade;
    }

    public void setXgrade(String xgrade){
        this.xgrade = xgrade;
    }

    public String getXgrade(){
        return xgrade;
    }

    public void setPageNo(int pageNo){
        this.pageNo = pageNo;
    }

    public int getPageNo(){
        return pageNo;
    }
    
    public void setPrePageNo(int iPrePageNo)
    {
    	this.prePageNo = iPrePageNo;
    }
    
    public int getPrePageNo()
    {
    	
    	return pageNo-1;
    }
    
    public void setNextPageNo(int iNextPageNo)
    {
    	this.nextPageNo = iNextPageNo;
    }
    
    public int getNextPageNo()
    {
    	return pageNo+1;
    	}
    public void setRowsCount(int rowsCount){
        this.rowsCount = rowsCount;
    }

    public int getRowsCount(){
        return rowsCount;
    }

    public void setRowsPerPage(int rowsPerPage){
        this.rowsPerPage = rowsPerPage;
    }

    public int getRowsPerPage(){
        return rowsPerPage;
    }


    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getCodeDescription(){
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription){
        this.codeDescription = codeDescription;
    }
}
