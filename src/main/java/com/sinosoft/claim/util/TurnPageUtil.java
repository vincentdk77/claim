package com.sinosoft.claim.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class  TurnPageUtil {
	public static final Integer PERPAGE = 10;
    public static TurnPageDto getTurnPage(PageRecord pageRecord,HttpServletRequest request,String condition){
        TurnPageDto turnPageDto = new TurnPageDto();
     // 查询出来的一页的结构集
        turnPageDto.setResultList((ArrayList)pageRecord.getResult());
        // 当前页号
        turnPageDto.setPageNo(pageRecord.getPageNo());
        // 一页的条数
        turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
        // 查询出来的结果的总数
        turnPageDto.setTotalCount(pageRecord.getCount());
        // 返回总的页数
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
        // 搜索条件
        turnPageDto.setCondition(condition);
        request.setAttribute("pageview",turnPageDto);
        return turnPageDto;
    }
    public static TurnPageDto getTurnPage(PageRecord pageRecord,HttpServletRequest request,String condition,String condition2,String condition3){
        TurnPageDto turnPageDto = new TurnPageDto();
     // 查询出来的一页的结构集
        turnPageDto.setResultList((ArrayList)pageRecord.getResult());
        // 当前页号
        turnPageDto.setPageNo(pageRecord.getPageNo());
        // 一页的条数
        turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
        // 查询出来的结果的总数
        turnPageDto.setTotalCount(pageRecord.getCount());
        // 返回总的页数
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
        // 搜索条件
        turnPageDto.setCondition(condition);
     // 搜索条件
        turnPageDto.setCondition3(condition3);
     // 搜索条件
        turnPageDto.setCondition2(condition2);
        request.setAttribute("pageview",turnPageDto);
        return turnPageDto;
    }
}
