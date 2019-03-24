package com.sinosoft.claim.ui.control.facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagertimeFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIScheduleJobManagerQueryFacade extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		//获取页面参数
		String handledept = request.getParameter("handledept");//机构代码
		String deptname = request.getParameter("deptname");//机构名称
		String jobdateBegin = request.getParameter("jobdateBegin");//开始日期
		String jobdateEnd = request.getParameter("jobdateEnd");//结束日期
		
		String classCode = request.getParameter("classCode");//结束日期
		try {
			//拼查询条件conditions  start
			String conditions = " 1 = 1 ";
			if(handledept!=null&&handledept.length()>0){
				conditions = conditions+" and fid in (select id from prpljobmanager where 1 = 1 and classcode = '"+classCode+"' and handledept = '"+handledept+"') ";
			}
			if(jobdateBegin!=null&&jobdateBegin.length()>0){
				conditions = conditions+" and  to_date(time,'YYYY-mm-dd') >= to_date('"+jobdateBegin+"' ,'YYYY-mm-dd') ";
			}
			if(jobdateEnd!=null&&jobdateEnd.length()>0){
				conditions = conditions+" and  to_date(time,'YYYY-mm-dd') <= to_date('"+jobdateEnd+"' ,'YYYY-mm-dd') ";
			}
			conditions = conditions+ "   order by to_date(time,'YYYY-mm-dd'), datetype ";
			String condition = request.getParameter("condition");
			if(condition!=null){
				conditions = condition;
			}
			//拼查询条件conditions  end
			//分页查询   start
			String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
			String pageNo = request.getParameter("pageNo");
			if(pageNo == null || "".equals(pageNo)){
				pageNo = "1";
			}
			int intpageNo = Integer.parseInt(pageNo);
			int intrecordPerPage = Integer.parseInt(recordPerPage);
			ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
			BLPrpljobmanagertimeFacade prpljobmanagertimeFacade = new BLPrpljobmanagertimeFacade();
			PageRecord pageRecord =  prpljobmanagertimeFacade.findByConditions(conditions, intpageNo, intrecordPerPage);
			prpljobmanagertimeDtoList = (ArrayList<PrpljobmanagertimeDto>) pageRecord.getResult();
			TurnPageDto turnPageDto = new TurnPageDto();
			// 查询出来的一页的结构集
			turnPageDto.setResultList(prpljobmanagertimeDtoList);
			// 当前页号
			turnPageDto.setPageNo(pageRecord.getPageNo());
			// 一页的条数
			turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
			// 查询出来的结果的总数
			turnPageDto.setTotalCount(pageRecord.getCount());
			// 返回总的页数
			turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
			// 搜索条件
			turnPageDto.setCondition(conditions);
			
			PrpljobmanagertimeDto prpljobmanagertimeDto = new PrpljobmanagertimeDto();
			prpljobmanagertimeDto.setTurnPageDto(turnPageDto);
			request.setAttribute("prpljobmanagertimeDto", prpljobmanagertimeDto);
			//分页查询  end
			//将查询结果封装成页面显示集合
			BLPrpljobmanagerFacade prpljobmanagerFacade = new BLPrpljobmanagerFacade();
			BLPrpDuserFacade prpDuserFacade = new BLPrpDuserFacade();
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(prpljobmanagertimeDtoList!=null&&prpljobmanagertimeDtoList.size()>0){
				for (PrpljobmanagertimeDto prpljobmanagertimeDto1 : prpljobmanagertimeDtoList) {
					PrpljobmanagerDto prpljobmanagerDto = prpljobmanagerFacade.findByPrimaryKey(prpljobmanagertimeDto1.getFid());
					if(prpljobmanagerDto!=null){
						prpljobmanagerDto.setTime(format.format(sdf.parse(prpljobmanagertimeDto1.getTime().trim())));
						prpljobmanagerDto.setDatetype(prpljobmanagertimeDto1.getDatetype());
						PrpDuserDto prpDuserDto = prpDuserFacade.findByPrimaryKey(prpljobmanagerDto.getHandlercode());
						if(prpDuserDto!=null){
							prpljobmanagerDto.setTel(prpDuserDto.getMobile());
						}
						
						prpljobmanagerDtoList.add(prpljobmanagerDto);
					}
				}
			}
			request.setAttribute("prpljobmanagerDtoList", prpljobmanagerDtoList);
		} catch (Exception e) {
			//e.printStackTrace();
			forward = "error";
		}
		return mapping.findForward(forward);
	}

}
