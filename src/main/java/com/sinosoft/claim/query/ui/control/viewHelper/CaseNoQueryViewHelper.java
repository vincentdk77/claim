package com.sinosoft.claim.query.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.CaseNoQueryDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.query.bl.facade.BLPrpLregistFacade;

public class CaseNoQueryViewHelper {
	public TurnPageDto getCaseNoList(HttpServletRequest httpServletRequest,String comcode) throws Exception{
		StringBuffer  condition = new StringBuffer();
		String editType = httpServletRequest.getParameter("editType");
		String policyNo = httpServletRequest.getParameter("policyNo");
		String policyNoSign = httpServletRequest.getParameter("policyNoSign");
		String registNo = httpServletRequest.getParameter("registNo");
		String registNoSign = httpServletRequest.getParameter("registNoSign");
		String claimNo = httpServletRequest.getParameter("claimNo");
		String claimNoSign = httpServletRequest.getParameter("claimNoSign");
		String compensateNo = httpServletRequest.getParameter("compensateNo");
		String compensateNoSign = httpServletRequest.getParameter("compensateNoSign");
		String caseNo = httpServletRequest.getParameter("caseNo");
		String caseNoSign = httpServletRequest.getParameter("caseNoSign");
		String queryType = httpServletRequest.getParameter("queryType");
		String noList = httpServletRequest.getParameter("noList");
		String conditions = httpServletRequest.getParameter("condition");
		
		int recordPerPage = 20;
		int pageNo=0;
		String pageNo1 = httpServletRequest.getParameter("pageNo");
		if(pageNo1!=null&&!"".equals(pageNo1)){
			pageNo = Integer.parseInt(pageNo1);
		}else{
			pageNo=1;
		}
		
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		TurnPageDto turnPageDto = new TurnPageDto();
		boolean flag = false;
		if(noList!=null){
			String[] nolists = noList.split("\\r\\n");
			for(String s:nolists){
				if(!"".equals(s.trim())){
					flag = true;
				}
			}
		}
		
		if(conditions!=null&&!"".equals(conditions)){
			condition.append(conditions);
		}else{
			condition.append("select r.policyno,r.registno,m.claimno,p.compensateno,m.caseno, ");
			condition.append("(SELECT s.flowid FROM swflog s where s.registno = r.registno and s.logno = 1) flowid1, ");
			condition.append("(SELECT ss.flowid FROM swflogstore ss where ss.registno = r.registno and ss.logno = 1) flowid2 ");
			condition.append("from prplregist r,prplclaim m,prplcompensate p ");
			condition.append("where r.registno=m.registno(+)  ");
			condition.append("and m.claimno=p.claimno(+)  ");
			condition.append("and m.claimno is not null  ");
			condition.append("and not exists (select 'X' from swflog sw where sw.registno=r.registno and sw.dataflag='1' union  ");
			condition.append("select 'X' from swflogstore swt where swt.registno=r.registno and swt.dataflag='1')  ");
			if(noList!=null&&!"".equals(noList)&&flag){
				String str = "\\r\\n";
				StringBuffer noss = new StringBuffer();
				String[] nos = noList.split(str);
				for(int i = 0;i<nos.length;i++){
					nos[i]= nos[i].trim();
					if(i==0){
						noss.append("'");
						noss.append(nos[i]);
						noss.append("'");
					}else{
						noss.append(",");
						noss.append("'");
						noss.append(nos[i]);
						noss.append("'");
					}
				}
					if("registNo".equals(queryType)){
			    		condition.append("and r.registno in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("claimNo".equals(queryType)){
			    		condition.append("and m.claimNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("compensateNo".equals(queryType)){
			    		condition.append("and p.compensateNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("caseNoSign".equals(queryType)){
			    		condition.append("and m.caseNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("policyNo".equals(queryType)){
			    		condition.append("and m.policyNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}
					condition.append(createString2(comcode));
					
			}else{
				if(policyNo!=null&&!"".equals(policyNo.trim())){
					condition.append(createString("r.policyNo",policyNo,policyNoSign));
		    	}
				if(registNo!=null&&!"".equals(registNo.trim())){
					condition.append(createString("r.registNo",registNo,registNoSign));
		    	}
				if(claimNo!=null&&!"".equals(claimNo.trim())){
					condition.append(createString("m.claimNo",claimNo,claimNoSign));
		    	}
				if(compensateNo!=null&&!"".equals(compensateNo.trim())){
					condition.append(createString("p.compensateNo",compensateNo,compensateNoSign));
		    	}
				if(caseNo!=null&&!"".equals(caseNo.trim())){
					condition.append(createString("m.caseNo",caseNo,caseNoSign));
		    	}
				condition.append(createString2(comcode));
			}
			condition.append("union all ");
			condition.append("select r.policyno,r.registno,m.claimno,p.compensateno,m.caseno, ");
			condition.append("(SELECT s.flowid FROM swflog s where s.registno = r.registno and s.logno = 1) flowid1, ");
			condition.append("(SELECT ss.flowid FROM swflogstore ss where ss.registno = r.registno and ss.logno = 1) flowid2 ");
			condition.append("from prplregist r,prplclaim m,prplcompensate p ");
			condition.append("where r.registno=m.registno(+)  ");
			condition.append("and m.claimno=p.claimno(+)  ");
			condition.append("and m.claimno is  null  ");
			condition.append("and not exists (select 'X' from swflog sw where sw.registno=r.registno and sw.dataflag='1' union  ");
			condition.append("select 'X' from swflogstore swt where swt.registno=r.registno and swt.dataflag='1')  ");
			if(noList!=null&&!"".equals(noList)&&flag){
				String str = "\\r\\n";
				StringBuffer noss = new StringBuffer();
				String[] nos = noList.split(str);
				for(int i = 0;i<nos.length;i++){
					nos[i]= nos[i].trim();
					if(i==0){
						noss.append("'");
						noss.append(nos[i]);
						noss.append("'");
					}else{
						noss.append(",");
						noss.append("'");
						noss.append(nos[i]);
						noss.append("'");
					}
				}
					if("registNo".equals(queryType)){
			    		condition.append("and r.registno in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("claimNo".equals(queryType)){
			    		condition.append("and m.claimNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("compensateNo".equals(queryType)){
			    		condition.append("and p.compensateNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("caseNoSign".equals(queryType)){
			    		condition.append("and m.caseNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}else if("policyNo".equals(queryType)){
			    		condition.append("and m.policyNo in (");
			    		condition.append(noss.toString());
			    		condition.append(") ");
			    	}
				condition.append(createString2(comcode));	
			}else{
				if(policyNo!=null&&!"".equals(policyNo.trim())){
					condition.append(createString("r.policyNo",policyNo,policyNoSign));
		    	}
				if(registNo!=null&&!"".equals(registNo.trim())){
					condition.append(createString("r.registNo",registNo,registNoSign));
		    	}
				if(claimNo!=null&&!"".equals(claimNo.trim())){
					condition.append(createString("m.claimNo",claimNo,claimNoSign));
		    	}
				if(compensateNo!=null&&!"".equals(compensateNo.trim())){
					condition.append(createString("p.compensateNo",compensateNo,compensateNoSign));
		    	}
				if(caseNo!=null&&!"".equals(caseNo.trim())){
					condition.append(createString("m.caseNo",caseNo,caseNoSign));
		    	}
				condition.append(createString2(comcode));
			}
		}
		System.out.println(condition.toString());
		int totalCount=0;
		ArrayList<CaseNoQueryDto> list = new ArrayList<CaseNoQueryDto>();
		totalCount = blPrpLregistFacade.getCaseNoCount(condition);
		list = blPrpLregistFacade.getCaseNo(condition,pageNo,recordPerPage);
		turnPageDto.setResultList(list);
		turnPageDto.setPageNo(pageNo);
		turnPageDto.setRecordPerPage(recordPerPage);
		turnPageDto.setTotalCount(totalCount);
		turnPageDto.setTotalPage(totalCount%recordPerPage==0?totalCount/recordPerPage:totalCount/recordPerPage+1);
		turnPageDto.setCondition(condition.toString());
				
		
		
		return turnPageDto;
		
	}

	public String createString(String name, String no, String sign) {
		StringBuffer buffer = new StringBuffer();
		if ("=".equals(sign)) {
			buffer.append("and " + name + " = '");
			buffer.append(no.trim());
			buffer.append("'");
		} else {
			buffer.append("and " + name + " like '%");
			buffer.append(no.trim());
			buffer.append("%'");
		}
		return buffer.toString();
	}
	public String createString2(String comcode){
		StringBuffer buffer = new StringBuffer();
		buffer.append("and exists( select 'X'  ");
		buffer.append("  from swflog sl  ");
		buffer.append(" where sl.registno = r.registno  ");
		buffer.append("   and sl.handledept in  ");
		buffer.append("       (select d.comcode  ");
		buffer.append("          from prpdcompany d  ");
		buffer.append("         start with d.comcode = '0000000000'  ");
		buffer.append("        connect by prior comcode = uppercomcode  ");
		buffer.append("               and prior comcode <> comcode)  ");
		buffer.append("union  ");
		buffer.append("select 'X'  ");
		buffer.append("  from swflogstore sl  ");
		buffer.append(" where sl.registno = r.registno  ");
		buffer.append("   and sl.handledept in  ");
		buffer.append("       (select d.comcode  ");
		buffer.append("          from prpdcompany d  ");
		buffer.append("         start with d.comcode = '0000000000'  ");
		buffer.append("        connect by prior comcode = uppercomcode  ");
		buffer.append("               and prior comcode <> comcode)  ) ");
		return buffer.toString();
	}
}
