package com.sinosoft.claim.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class  TurnPageUtil {
	public static final Integer PERPAGE = 10;
    public static TurnPageDto getTurnPage(PageRecord pageRecord,HttpServletRequest request,String condition){
        TurnPageDto turnPageDto = new TurnPageDto();
     // ��ѯ������һҳ�Ľṹ��
        turnPageDto.setResultList((ArrayList)pageRecord.getResult());
        // ��ǰҳ��
        turnPageDto.setPageNo(pageRecord.getPageNo());
        // һҳ������
        turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
        // ��ѯ�����Ľ��������
        turnPageDto.setTotalCount(pageRecord.getCount());
        // �����ܵ�ҳ��
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
        // ��������
        turnPageDto.setCondition(condition);
        request.setAttribute("pageview",turnPageDto);
        return turnPageDto;
    }
    public static TurnPageDto getTurnPage(PageRecord pageRecord,HttpServletRequest request,String condition,String condition2,String condition3){
        TurnPageDto turnPageDto = new TurnPageDto();
     // ��ѯ������һҳ�Ľṹ��
        turnPageDto.setResultList((ArrayList)pageRecord.getResult());
        // ��ǰҳ��
        turnPageDto.setPageNo(pageRecord.getPageNo());
        // һҳ������
        turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
        // ��ѯ�����Ľ��������
        turnPageDto.setTotalCount(pageRecord.getCount());
        // �����ܵ�ҳ��
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
        // ��������
        turnPageDto.setCondition(condition);
     // ��������
        turnPageDto.setCondition3(condition3);
     // ��������
        turnPageDto.setCondition2(condition2);
        request.setAttribute("pageview",turnPageDto);
        return turnPageDto;
    }
}
