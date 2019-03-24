package com.sinosoft.claim.ui.control.facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UndwrtCaseStatusDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.sff.blsvr.BLPrpJpackDetail;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 核赔工作流信息补传
 * @author Administrator
 *
 */
public class UIThirdPayBankElectFacade  extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "success";
		try{
			UserDto user = (UserDto) request.getSession().getAttribute("user");
			if(user==null){
				forward = "error";
				return actionMapping.findForward(forward);
			}
			String strCondition="";
			String strCondition2 ="";
			//领款人名称前标志（= or *）
		    String receiverFullNameSign = request.getParameter("receiverFullNameSign");
		    //领款人名称
		    String receiverFullName = request.getParameter("receiverFullName");
		    //银行账号标志
		    String bankAccountSign = request.getParameter("bankAccountSign");
		    //银行账号
		    String bankAccount = request.getParameter("bankAccount");
		    //报案号标志
		    String registNoSign = request.getParameter("registNoSign");
		    //报案号
		    String registNo = request.getParameter("registNo");
		    //收付编号标志
		    String paymentNoSign = request.getParameter("paymentNoSign");
		    //收付编号
		    String paymentNo = request.getParameter("paymentNo");
		    //录入时间(开始)
		    String payDate1 = request.getParameter("payDate1");
		    //录入时间(结束)
		    String payDate2 = request.getParameter("payDate2");
		    
		    
		    
			int rowsPerPage = TurnPageUtil.PERPAGE;
            //页数
            int pageNo     = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
            
		   if (pageNo == 1&&null==request.getParameter("pageNo")) {
	            StringBuffer sb=new StringBuffer();
	            StringBuffer sb2=new StringBuffer();
	            if (request.getParameter("condition")!=null) {
	            	strCondition=request.getParameter("condition");
				}
	            UIPowerInterface uiPowerInterface = new UIPowerInterface();
				String sqlStr = uiPowerInterface.addPower(user, "prplpaymain", "", "ComCode");
				sb.append(" 1=1 and exists (select 1 from thirdpay_platform.prpqpackmain mm where mm.packno = thirdpay_platform.prpqpackdetail.packno and mm.payway='allinPay') ");
				sb.append(" and approveflag <> '3'			");                                    
				sb.append("   And Exists					");                                    
				sb.append(" (Select 1							");                                    
				sb.append("          From prplpaymain	");                            
				sb.append("         Where prplpaymain.Thirdpayflag In ('7','m', '9')	"); 
				sb.append(" and exists (select 1 from prplpay yy where yy.serialno = prplpaymain.paymentno and yy.classcode <> '05' ");
				//添加区分新农险数据标识
				sb.append(" and (yy.registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='regis')");
				sb.append("  or yy.registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='regis')))");
				sb.append("           And prplpaymain.Paymentno = thirdpay_platform.prpqpackdetail.Visaserialno 	");
				sb.append(" "+sqlStr+"  ");
			       
			       	if(null!=paymentNo&&!"".equals(paymentNo)){
			       		if("*".equals(paymentNoSign)){
			       			sb.append(" and prplpaymain.paymentNo like '%"+paymentNo.trim()+"%'");
			       		}else if("=".equals(paymentNoSign)){
			       			sb.append(" and prplpaymain.paymentNo = '"+paymentNo.trim()+"'");
			       		}
			       	}
			       	//收款人
			       	if (null!=receiverFullName&&!"".equals(receiverFullName)) {
			       		if("*".equals(receiverFullNameSign)){
			       			sb.append(" and prplpaymain.ReceiverFullName like '%"+receiverFullName.trim()+"%'");
			       		}else if("=".equals(receiverFullNameSign)){
			       			sb.append(" and prplpaymain.ReceiverFullName = '"+receiverFullName.trim()+"'");
			       		}
			       	}
			       	//收款账号
			       	if (null!=bankAccount&&!"".equals(bankAccount)) {
			       		if("*".equals(bankAccountSign)){
			       			sb.append(" and prplpaymain.bankaccount like '%"+bankAccount.trim()+"%'");
			       		}else if("=".equals(bankAccountSign)){
			       			sb.append(" and prplpaymain.bankaccount = '"+bankAccount.trim()+"'");
			       		}
			       	}
			       	//流入时间
			       	if(null!=payDate1&&!"".equals(payDate1)){
			       		//sb.append("and prplpaymain.payDate >=  to_date('"+payDate1+"00:00:00"+"','yyyy-mm-dd hh24:mi:ss')");
			       		sb.append(" and prplpaymain.Inputdate >=  To_Date('"+payDate1+" 00:00:00"+"', 'yyyy-MM-dd hh24:mi:ss')");
			       	}
			       	if(null!=payDate2&&!"".equals(payDate2)){
			       		//sb.append("and prplpaymain.payDate <=  to_date('"+payDate2+"23:59:59"+"','yyyy-mm-dd hh24:mi:ss')");
			       		sb.append(" and prplpaymain.Inputdate <=  To_Date('"+payDate2+" 23:59:59"+"', 'yyyy-MM-dd hh24:mi:ss')");
			       	}
					//报案号
			       	if (null!=registNo&&!"".equals(registNo)) {
			       		sb.append("And Exists (Select 1                    ");       
			           	sb.append("	       From Prplpay    where 1=1       ");        
			       		if("*".equals(registNoSign)){
			       			sb.append(" and Registno like '%"+registNo.trim()+"%'");
			       		}else if("=".equals(registNoSign)){
			       			sb.append(" and Registno = '"+registNo.trim()+"'");
			       		}
			       		sb.append("	  And Prplpay.Serialno = prplpaymain.Paymentno)  ");
			       	}
					sb.append(")");
					
			    strCondition = sb.toString();
			    
			  //电子回执单查询表更改  modify by chenyan 20171226 begin
			   	String sqlStr2 = " 1=1 ";
				sb2.append(" "+sqlStr2+"  ");
				//流入时间
			   	if(null!=payDate1&&!"".equals(payDate1)){
			   		sb2.append(" and operatedate >= To_Date('"+payDate1+"', 'yyyy-MM-dd')");
			   	}
			   	if(null!=payDate2&&!"".equals(payDate2)){
			   		sb2.append(" and operatedate <= To_Date('"+payDate2+"', 'yyyy-MM-dd')");
			   	}
			  	//电子回执单查询表更改  modify by chenyan 20171226 end
			       try {
			       	
			       	//支付号
			       	if(null!=paymentNo&&!"".equals(paymentNo)){
			       		if("*".equals(paymentNoSign)){
			       			sb2.append(" and visaserialno like '%"+paymentNo.trim()+"%'");
			       		}else if("=".equals(paymentNoSign)){
			       			sb2.append(" and visaserialno = '"+paymentNo.trim()+"'");
			       		}
			       	}
			       	//收款人
			       	if (null!=receiverFullName&&!"".equals(receiverFullName)) {
			       		if("*".equals(receiverFullNameSign)){
			       			sb2.append(" and receiverfullname like '%"+receiverFullName.trim()+"%'");
			       		}else if("=".equals(receiverFullNameSign)){
			       			sb2.append(" and receiverfullname = '"+receiverFullName.trim()+"'");
			       		}
			       	}
			       	//收款账号
			       	if (null!=bankAccount&&!"".equals(bankAccount)) {
			       		if("*".equals(bankAccountSign)){
			       			sb2.append(" and bankaccount like '%"+bankAccount.trim()+"%'");
			       		}else if("=".equals(bankAccountSign)){
			       			sb2.append(" and bankaccount = '"+bankAccount.trim()+"'");
			       		}
			       	}
			       	
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			    strCondition2 = sb2.toString();
			    
			    String strComCodeCondition ="";
			    if (null!=user.getComCode()&&!"".equals(user.getComCode())) {
			       strComCodeCondition =" and  comcode In" +
			        " (Select Comcode From  prpdcompany Start With Comcode = '"+user.getComCode()+"' " +
			            "Connect By Prior Comcode = Uppercomcode And Prior Comcode != Comcode And Validstatus = '1')";
			        }
			    strCondition2 += " and exists (select 1 from gyic.prplpay prplpay where thirdpay_pay.prpqallinpayreceipt.visaserialno = prplpay.serialno "+strComCodeCondition;
			    
			    if (null!=registNo&&!"".equals(registNo)) {
		    		if("*".equals(registNoSign)){
		    			strCondition2 += " and Registno like '%"+registNo.trim()+"%'";
		       		}else if("=".equals(registNoSign)){
		       			strCondition2 += " and Registno = '"+registNo.trim()+"'";
		       		}
		    	}
			    strCondition2 += " )";
			    System.err.println("prpqallinpayreceipt新表:"+strCondition2);
			    
		   } 
		   else
		   {
		       strCondition = request.getParameter("pageConditions");
		       strCondition2 = request.getParameter("WherePart2");
		   }		    
			
		   //blPrpJpackDetail.query(strCondition,intPageNum,rowsPerPage);
		   PageRecord pr = this.getCollection2(strCondition,strCondition2, pageNo, rowsPerPage);
		   TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容  
	        // 查询出来的一页的结构集
			turnPageDto.setResultList((ArrayList)pr.getResult());
			// 当前页号
			turnPageDto.setPageNo(pr.getPageNo());
			// 一页的条数
			turnPageDto.setRecordPerPage(pr.getRowsPerPage());
			// 查询出来的结果的总数
			turnPageDto.setTotalCount(pr.getCount());
			// 返回总的页数
			int a=(pr.getCount())%pr.getRowsPerPage();
			if(a>0){
				turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
			}else{
				turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
			}
			
			// 搜索条件
			turnPageDto.setCondition(strCondition);
			turnPageDto.setCondition2(strCondition2);
			request.setAttribute("turnPageDto", turnPageDto);
		   
		   
		}catch(Exception e){
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.undwrtCaseStatus.resultList");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(request, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
	
	public PageRecord getCollection(String strCondition,int pageNo,int rowsPerPage)throws Exception{
		DBManager dbManager = new DBManager();
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			int count = this.getListCount(dbManager, strCondition, pageNo, rowsPerPage);
			ArrayList<PrplpayDto> collection = new ArrayList<PrplpayDto>();
	    	collection = this.getList(dbManager, strCondition, pageNo, rowsPerPage);
          	pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
          	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
            dbManager.close();
        }
		return pageRecord;
	}
	public PageRecord getCollection2(String strCondition,String strCondition2,int pageNo,int rowsPerPage)throws Exception{
		DBManager dbManager = new DBManager();
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			int count = this.getListCount2(dbManager, strCondition,strCondition2, pageNo, rowsPerPage);
			ArrayList<PrplpayDto> collection = new ArrayList<PrplpayDto>();
			collection = this.getList2(dbManager, strCondition,strCondition2, pageNo, rowsPerPage);
			pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return pageRecord;
	}
	
	public ArrayList<PrplpayDto> getList(DBManager dbManager,String strCondition,int pageNo,int rowsPerPage) throws Exception {
		ArrayList<PrplpayDto> list = new ArrayList<PrplpayDto>();
		try{
			StringBuffer buffer = new StringBuffer(200);
			buffer.append(" select * ");
	       	buffer.append(" from (  Select Batchno,         ");
	        buffer.append("               Visaserialno,    ");
	        buffer.append("               Resno,           ");
	        buffer.append("               Payreffee,       ");
	        buffer.append("               Receiverfullname,");
	        buffer.append("               Banktype         ");
	        buffer.append("          From thirdpay_platform.prpqpackdetail   ");
	        buffer.append("         Where       " +strCondition);
	        buffer.append(" ) c  ");
	        
	        if (pageNo > 0){
	               //对Oracle优化
	               if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	                   buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	                   buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
	                   //supportPaging=true;
	               }
	               else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
	                   String sql = buffer.toString();
	                   buffer.setLength(0);
	                   buffer.append("select * from ( select rownumber() over(");
	                   int orderByIndex = sql.toLowerCase().indexOf("order by");
	                   if ( orderByIndex>0 ) {
	                      buffer.append( sql.substring(orderByIndex) );
	                   }
	                   buffer.append(") as rownumber_,");
	                   buffer.append(sql.substring( 6 ));
	                   buffer.append(" ) as temp_ where rownumber_");
	                   buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
	                   //supportPaging=true;
	               }
	           }
	        
	        System.err.println(buffer.toString());
			ResultSet resultSet = dbManager.executeQuery(buffer.toString());
			PrplpayDto prpLpayDto =null;
	      	while(resultSet.next()){
	      		prpLpayDto = new PrplpayDto();
	      		prpLpayDto.setClaimno(dbManager.getString(resultSet,"Batchno"));
	      		prpLpayDto.setSerialno(dbManager.getString(resultSet,"Visaserialno"));
	      		prpLpayDto.setSerialNo2(dbManager.getString(resultSet,"Resno"));
	      		prpLpayDto.setPayamount(dbManager.getString(resultSet,"Payreffee"));
	      		prpLpayDto.setReceiverfullname(dbManager.getString(resultSet, "Receiverfullname"));
	      		prpLpayDto.setBanktype(dbManager.getString(resultSet,"Banktype"));
	      		list.add(prpLpayDto);
	      	}
	      	resultSet.close();
	      	
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	public ArrayList<PrplpayDto> getList2(DBManager dbManager,String strCondition,String strCondition2,int pageNo,int rowsPerPage) throws Exception {
		ArrayList<PrplpayDto> list = new ArrayList<PrplpayDto>();
		try{
			StringBuffer buffer = new StringBuffer(200);
			buffer.append(" select * ");
			buffer.append(" from (  Select Batchno,         ");
			buffer.append("               Visaserialno,    ");
			buffer.append("               Resno,           ");
			buffer.append("               Payreffee,       ");
			buffer.append("               Receiverfullname,");
			buffer.append("               Banktype         ");
			buffer.append("          From thirdpay_platform.prpqpackdetail   ");
			buffer.append("         Where       " +strCondition);
			buffer.append(" union all Select batchno,visaserialno,resno,payamount,receiverfullname,banktype From thirdpay_pay.prpqallinpayreceipt Where " + strCondition2+") c  ");
			
			if (pageNo > 0){
				//对Oracle优化
				if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
					buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
					buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
					//supportPaging=true;
				}
				else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
					String sql = buffer.toString();
					buffer.setLength(0);
					buffer.append("select * from ( select rownumber() over(");
					int orderByIndex = sql.toLowerCase().indexOf("order by");
					if ( orderByIndex>0 ) {
						buffer.append( sql.substring(orderByIndex) );
					}
					buffer.append(") as rownumber_,");
					buffer.append(sql.substring( 6 ));
					buffer.append(" ) as temp_ where rownumber_");
					buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
					//supportPaging=true;
				}
			}
			
			System.err.println(buffer.toString());
			ResultSet resultSet = dbManager.executeQuery(buffer.toString());
			PrplpayDto prpLpayDto =null;
			while(resultSet.next()){
				prpLpayDto = new PrplpayDto();
				prpLpayDto.setClaimno(dbManager.getString(resultSet,"Batchno"));
				prpLpayDto.setSerialno(dbManager.getString(resultSet,"Visaserialno"));
				prpLpayDto.setSerialNo2(dbManager.getString(resultSet,"Resno"));
				prpLpayDto.setPayamount(dbManager.getString(resultSet,"Payreffee"));
				prpLpayDto.setReceiverfullname(dbManager.getString(resultSet, "Receiverfullname"));
				prpLpayDto.setBanktype(dbManager.getString(resultSet,"Banktype"));
				list.add(prpLpayDto);
			}
			resultSet.close();
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public int getListCount(DBManager dbManager,String strCondition,int pageNo,int rowsPerPage) throws Exception {
		int count = -1;
		try{
			StringBuffer buffer = new StringBuffer(200);
			buffer.append(" select count(*) ");
	       	buffer.append(" from (  Select Batchno,         ");
	        buffer.append("               Visaserialno,    ");
	        buffer.append("               Resno,           ");
	        buffer.append("               Payreffee,       ");
	        buffer.append("               Receiverfullname,");
	        buffer.append("               Banktype         ");
	        buffer.append("          From thirdpay_platform.prpqpackdetail   ");
	        buffer.append("         Where       " +strCondition);
	        buffer.append(" ) c  ");
	        
	        System.err.println(buffer.toString());
			ResultSet resultSet = dbManager.executeQuery(buffer.toString());
			resultSet.next();
            count = dbManager.getInt(resultSet,1);
	      	resultSet.close();
	      	
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return count;
	}
	public int getListCount2(DBManager dbManager,String strCondition,String strCondition2,int pageNo,int rowsPerPage) throws Exception {
		int count = -1;
		try{
			StringBuffer buffer = new StringBuffer(200);
			buffer.append(" select count(*) ");
			buffer.append(" from (  Select Batchno,         ");
			buffer.append("               Visaserialno,    ");
			buffer.append("               Resno,           ");
			buffer.append("               Payreffee,       ");
			buffer.append("               Receiverfullname,");
			buffer.append("               Banktype         ");
			buffer.append("          From thirdpay_platform.prpqpackdetail   ");
			buffer.append("         Where       " +strCondition);
			buffer.append("  union all Select batchno,visaserialno,resno,payamount,receiverfullname,banktype From thirdpay_pay.prpqallinpayreceipt Where " + strCondition2+") ");
			
			System.err.println(buffer.toString());
			ResultSet resultSet = dbManager.executeQuery(buffer.toString());
			resultSet.next();
			count = dbManager.getInt(resultSet,1);
			resultSet.close();
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return count;
	}
	
}
