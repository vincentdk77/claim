package com.sinosoft.communication.bl.facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.communication.bl.action.BLPrplCommunicationAction;
import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrplCommunicationFacade extends BLPrplCommunicationFacadeBase{
	/**
	 * 无参构造
	 */
	public BLPrplCommunicationFacade(){
		
	}
	
	public ArrayList getResult(String userCode, String registNo) throws Exception{
		String conditions = ""+
		"select c.communicationno,													"+
	    "   c.registno,																"+
	    "   c.comname,																"+
	    "   c.nodename,																"+
	    "   c.username,																"+
	    "   c.tasktype,																"+
	    "   c.taskname,																"+
	    "   c.validata,																"+
	    "   c.createTime,															"+
	    "   c.communicationtopic,													"+
	    " 	case             														"+
	    " 		when c.validata = '1' and exists									"+
	    " 		  (select 1															"+
	    " 		         from prplcommunicatperson p								"+
	    " 		        where p.communicationno = c.communicationno					"+
	    " 		          and p.usercode = '"+userCode+"') then            			"+
	    " 			case             												"+
	    "  				when exists (select 1             							"+
	    "          			from prplcommunicatperson p            	 				"+
	    "       				where p.communicationno = c.communicationno      	"+
	    "       						and p.usercode = '"+userCode+"'             "+
	    "        						and p.communicationflag = '2'             	"+
	    "          						or (c.usercode = '"+userCode+"' and c.validata = '1')) then	 "+
	    "  					'ORANGE'             									"+
	    "  				when exists (select 1             							"+
	    "         						from prplcommunicatperson p             	"+
	    "      							 where p.communicationno = c.communicationno 	"+
	    "          							and p.usercode = '"+userCode+"'         "+
	    "          							and p.validata = '1'             		"+
	    "         							and (p.communicationflag is null or  	"+
        "             								p.communicationflag = '0')) then	"+
	    "  					'GREEN'             									"+
	    " 				else             											"+             
	    "  					'red'             										"+            
	    "  				end             											"+
	    "   else             														"+
	    "   	'RED'                  												"+
	    "  	end color             													"+
		" from prplcommunication c													"+
		" where c.registno = '"+registNo+"' order by c.createTime desc				";
		
		System.out.println("<BLPrplCommunicationFacade.java 55行>"+conditions);
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList prplCommunicatPersonList = new ArrayList();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            resultSet = dbManager.executeQuery(conditions);
            PrplCommunicationDto prplCommunicationDto =null;
            while(resultSet.next()){
            	prplCommunicationDto = new PrplCommunicationDto();
            	prplCommunicationDto.setCommunicationNo(dbManager.getString(resultSet, "communicationno"));
            	prplCommunicationDto.setRegistNo(dbManager.getString(resultSet, "registno"));
            	prplCommunicationDto.setComName(dbManager.getString(resultSet, "comname"));
            	prplCommunicationDto.setNodeName(dbManager.getString(resultSet, "nodename"));
            	prplCommunicationDto.setUserName(dbManager.getString(resultSet, "username"));
            	prplCommunicationDto.setTaskType(dbManager.getString(resultSet, "tasktype"));
            	prplCommunicationDto.setTaskName(dbManager.getString(resultSet, "taskname"));
            	prplCommunicationDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, "createTime"));
            	prplCommunicationDto.setCommunicationTopic(dbManager.getString(resultSet, "communicationtopic"));
            	prplCommunicationDto.setColor(dbManager.getString(resultSet, "color"));
            	prplCommunicationDto.setValidata(dbManager.getString(resultSet, "validata"));
            	prplCommunicatPersonList.add(prplCommunicationDto);
            }
        }catch(Exception exception){
            throw exception;
        }finally{
            if(resultSet!=null){
              resultSet.close();
            }
            dbManager.close();
        }
		
		return prplCommunicatPersonList;
	}
	public ArrayList getResult(String conditions,int pageNo,int rowsPerPage) throws Exception{
		/**
		int starRow = 0;
		int endRow = 0;
		if(pageNo<=0){
			pageNo=1;
		}
		starRow = rowsPerPage * (pageNo - 1);
		endRow = rowsPerPage * pageNo;
		String conditions =" SELECT * FROM 													" +
		"(select tt.*,rownum as SUMROW														" +
		"          from ((select c.communicationno,											" +
		"                       c.registno,													" +
		"                       c.username,													" +
		"                       r.insuredname as insuredname,								" +
		"                       r.licenseno as licenseno,									" +
		"                       c.createTime,												" +
		"                       c.communicationtopic,										" +
		"                       case 														" +
		"                         when exists												" +
		"                          (select 1												" +
		"                                 from prplcommunicatperson p 						" +
		"                                where p.communicationno = c.communicationno 		" +
		"                                  and p.usercode = '"+userCode+"' 					" +
		"                                  and p.communicationflag = '2') then " +
		"                          'ORANGE' " +
		"                         when c.validata = '1' then " +
		"                          case " +
		"                            when exists " +
		"                             (select 1 " +
		"                                    from prplcommunicatperson p " +
		"                                   where p.communicationno = c.communicationno " +
		"                                     and p.usercode = '"+userCode+"') then " +
		"                             'GREEN' " +
		"                            else " +
		"                             'RED' " +
		"                          end " +
		"                         else " +
		"                          'RED' " +
		"                       end color, " +
		"                       c.validata as validata, " +
		"                       0 as comcode " +
		"                  from prplcommunication c, prplregist r " +
		"                 where c.registno = r.registno "+iWhere+") " +
		"        Union (select 'M' as communicationno, " +
		"                     m.registno, " +
		"                     m.operatorname as username, " +
		"                     r.licenseno as licenseno, " +
		"                     r.insuredname as insuredname, " +
		"                     m.inputdate as createTime, " +
		"                     m.context as communicationtopic, " +
		"                     'RED' AS color, " +
		"                     '0' as validata, " +
		"                     m.serialno as comcode        " +              
		"                from prplmessage m, prplregist r " +
		"               where m.registno = r.registno " +
		"                 and m.registno = '"+registNo+"')) tt 			" +
		" where rownum <="+endRow+") where SUMROW>"+starRow+"										";
		
		*/
		System.out.println("<BLPrplCommunicationFacade.java 148--行>"+conditions);
		DBManager dbManager = new DBManager();
		ResultSet resultSet =null;
		ArrayList prplCommunicatPersonList = new ArrayList();
		int count=0;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            resultSet = dbManager.executeQuery(conditions);
            PrplCommunicationDto prplCommunicationDto =null;
            if(pageNo>1){
            	dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
            }
            while(resultSet.next()){
            	count++;
                if(pageNo>0){
                    if(count > rowsPerPage){
                        break;
                    }
                }
            	prplCommunicationDto = new PrplCommunicationDto();
            	prplCommunicationDto.setCommunicationNo(dbManager.getString(resultSet, "communicationno"));
            	prplCommunicationDto.setRegistNo(dbManager.getString(resultSet, "registno"));
            	prplCommunicationDto.setUserName(dbManager.getString(resultSet, "username"));
            	prplCommunicationDto.setLicenseNo(dbManager.getString(resultSet, "licenseno"));//车牌号
            	prplCommunicationDto.setInsuredName(dbManager.getString(resultSet, "insuredname"));//展示用，被保险人名称
            	prplCommunicationDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, "createTime"));
            	prplCommunicationDto.setCloseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, "closeTime"));
            	prplCommunicationDto.setCommunicationTopic(dbManager.getString(resultSet, "communicationtopic"));
            	prplCommunicationDto.setColor(dbManager.getString(resultSet, "color"));
            	prplCommunicationDto.setValidata(dbManager.getString(resultSet, "validata"));
            	prplCommunicationDto.setSerialNo(dbManager.getString(resultSet, "serialno"));// 留言序号
            	prplCommunicationDto.setLineno(dbManager.getString(resultSet, "lineno"));// 留言行号
            	String aboveTime = "";
            	//int intAboveTime =0;
            	if("0".equals(prplCommunicationDto.getValidata())){
            		aboveTime =DateCompute.getBusinessDays2(prplCommunicationDto.getCreateTime(), prplCommunicationDto.getCloseTime());
            	}else{
            		aboveTime =DateCompute.getBusinessDays2(prplCommunicationDto.getCreateTime(), DateTime.current());
            	}
            	//aboveTime=String.valueOf(intAboveTime)+"天";
            	//System.out.println(prplCommunicationDto.getCommunicationNo()+"<185>"+aboveTime);
            	prplCommunicationDto.setAboveTime(aboveTime);
            	prplCommunicatPersonList.add(prplCommunicationDto);
            }
        }catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet!=null){
              resultSet.close();
            }
            dbManager.close();
        }
		
		return prplCommunicatPersonList;
	}
	public int getResultCount(String conditions) throws Exception{
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		String countConditions = "select count(*) from ( "+conditions+" )";
		int count = 0;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            resultSet = dbManager.executeQuery(countConditions);
            resultSet.next();
            count = dbManager.getInt(resultSet,1);
        }catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet!=null){
              resultSet.close();
            }
            dbManager.close();
        }
		
		return count;
	}
	/**
     * 沟通查询方法
     * @param conditions
     * @param userCode
     * @param editType
     * @param flags
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public  PageRecord getResultList(String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        //conditions = " 1=1 " + conditions;
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicationAction.getResultList(dbManager, conditions, userCode, editType, flags, pageNo, rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 沟通查询方法2(供呼叫中心接口使用，查出的数据要多出上面方法2个字段usercode,nodecode)
     * @param conditions
     * @param userCode
     * @param editType
     * @param flags
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public  PageRecord getResultList2(String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        //conditions = " 1=1 " + conditions;
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicationAction.getResultList2(dbManager, conditions, userCode, editType, flags, pageNo, rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 获取当前人员需处理的的沟通个数
     * @param usercode
     * @return
     * @throws Exception
     */
    public int getUserCommunicatNum(String usercode) throws Exception{
    	int count=0;
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	count = blPrplCommunicationAction.getUserCommunicatNum(dbManager, usercode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return count;
    }
}
