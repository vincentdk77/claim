package com.sinosoft.communication.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是DBPrplCommunication理赔沟通的表的数据访问对象类<br>
 * 创建于 2013-02-19<br>
 * JToolpad(1.2.12-RC10) 
 */
public class DBPrplCommunication extends DBPrplCommunicationBase {
	private static Log logger = LogFactory.getLog(DBPrplCommunication.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplCommunication(DBManager dbManager){
        super(dbManager);
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
    public  Collection getResultList(String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	String conditions1 = conditions.split("##")[0];
    	String conditions2 = conditions.split("##").length>1?conditions.split("##")[1]:"";
    	StringBuffer sb = new StringBuffer(200);
    	sb.append("	  SELECT * ");
		sb.append("       from ((select c.communicationno, ");
		sb.append("             c.communicationtopic, ");
		sb.append("          c.registno, ");
		sb.append("           c.username as username, ");
		sb.append("         r.insuredname as insuredname, ");
		sb.append("         r.licenseno as licenseno, ");
		sb.append("         c.createTime, ");
		sb.append("        c.closeTime, ");
		sb.append("       case 	when c.validata = '1' then				");
		sb.append("           case   when exists ");
		sb.append("              (select 1 ");
		sb.append("                    from prplcommunicatperson p ");
		sb.append("                  where ( p.communicationno = c.communicationno ");
		sb.append("                   and p.usercode = '"+userCode+"' ");
		sb.append("                   and p.communicationflag = '2' )or c.usercode='"+userCode+"' ) then ");
		sb.append("          'ORANGE' ");
		sb.append("           when exists ");
		sb.append("           (select 1 ");
		sb.append("          from prplcommunicatperson p ");
		sb.append("        where p.communicationno = c.communicationno ");
		sb.append("                  and p.usercode = '"+userCode+"' and p.validata = '1' ");
		sb.append(" 		         and (p.communicationflag is null or ");
		sb.append(" 			          p.communicationflag = '0')) then ");
		sb.append("          'GREEN' ");
		sb.append("         else ");
		sb.append("          'RED' ");
		sb.append("          end "); 
		sb.append("          else ");
		sb.append("          'RED' ");
		sb.append("       end color, ");
		sb.append("       c.validata as validata, ");
		sb.append("       c.nodename as nodename, ");
		sb.append("        0 as serialno, ");
		sb.append("        0 as lineno ");
		sb.append("     from prplcommunication c, prplregist r ");
		sb.append("    where c.registno = r.registno ");
		sb.append(conditions1);
		
    	if("VIEW".equals(editType)){
			if("".equals(flags)||flags.indexOf("0")>-1){
//				sb.append("        Union all (select 'M' as communicationno, ");
//				sb.append("                     m.context as communicationtopic, ");
//				sb.append("                     m.registno, ");
//				sb.append("                     m.operatorname as username, ");
//				sb.append("                     r.insuredname as insuredname, ");
//				sb.append("                     r.licenseno as licenseno, ");
//				sb.append("                     m.inputdate as createTime, ");
//				sb.append("                     m.inputdate as closeTime, ");
//				sb.append("                     'RED' AS color, ");
//				sb.append("                     '0' as validata, ");
//				sb.append("                     m.serialno as serialno,        ");
//				sb.append("                     m.lineno as lineno        ");
//				sb.append("                from prplmessage m, prplregist r ");
//				sb.append("               where m.registno = r.registno "+conditions2+" ) " );
				sb.append(" 		order by c.createTime desc )  )			");
			}else{
				sb.append("  order by c.createTime desc ) ) ");
			}
		}else{
			sb.append("	  order by c.createTime desc ) )	");
		}
    	
    	String statement = sb.toString();
		log.debug(statement);
		System.out.println(statement);
        Collection collection = new ArrayList();
        PrplCommunicationDto prplCommunicationDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
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
        	prplCommunicationDto.setUserName(dbManager.getString(resultSet, "username"));
        	prplCommunicationDto.setNodeName(dbManager.getString(resultSet, "nodename"));
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
        	collection.add(prplCommunicationDto);
        }
        resultSet.close();
        log.info("DBPrplCommunicationBase.getResultList() success!");
        return collection;
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
    public  Collection getResultList2(String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	String conditions1 = conditions.split("##")[0];
    	String conditions2 = conditions.split("##").length>1?conditions.split("##")[1]:"";
    	StringBuffer sb = new StringBuffer(200);
    	sb.append("	  SELECT * ");
		sb.append("       from ((select c.usercode usercode,c.nodecode nodetype,c.communicationno, ");
		sb.append("             c.communicationtopic, ");
		sb.append("          c.registno, ");
		sb.append("           c.username as username, ");
		sb.append("         r.insuredname as insuredname, ");
		sb.append("         r.licenseno as licenseno, ");
		sb.append("         c.createTime, ");
		sb.append("        c.closeTime, ");
		sb.append("       case 	when c.validata = '1' then				");
		sb.append("           case   when exists ");
		sb.append("              (select 1 ");
		sb.append("                    from prplcommunicatperson p ");
		sb.append("                  where ( p.communicationno = c.communicationno ");
		sb.append("                   and p.usercode = '"+userCode+"' ");
		sb.append("                   and p.communicationflag = '2' )or c.usercode='"+userCode+"' ) then ");
		sb.append("          'ORANGE' ");
		sb.append("           when exists ");
		sb.append("           (select 1 ");
		sb.append("          from prplcommunicatperson p ");
		sb.append("        where p.communicationno = c.communicationno ");
		sb.append("                  and p.usercode = '"+userCode+"' and p.validata = '1' ");
		sb.append(" 		         and (p.communicationflag is null or ");
		sb.append(" 			          p.communicationflag = '0')) then ");
		sb.append("          'GREEN' ");
		sb.append("         else ");
		sb.append("          'RED' ");
		sb.append("          end "); 
		sb.append("          else ");
		sb.append("          'RED' ");
		sb.append("       end color, ");
		sb.append("       c.validata as validata, ");
		sb.append("       c.nodename as nodename, ");
		sb.append("        0 as serialno, ");
		sb.append("        0 as lineno ");
		sb.append("     from prplcommunication c, prplregist r ");
		sb.append("    where c.registno = r.registno ");
		sb.append(conditions1);
		sb.append("	  order by c.createTime desc ) )	");
    	
    	String statement = sb.toString();
		log.debug(statement);
		System.out.println(statement);
        Collection collection = new ArrayList();
        PrplCommunicationDto prplCommunicationDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
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
            prplCommunicationDto.setNodeCode(dbManager.getString(resultSet, "nodetype"));
            prplCommunicationDto.setUserCode(dbManager.getString(resultSet, "usercode"));
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
        	prplCommunicationDto.setUserName(dbManager.getString(resultSet, "username"));
        	prplCommunicationDto.setNodeName(dbManager.getString(resultSet, "nodename"));
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
        	collection.add(prplCommunicationDto);
        }
        resultSet.close();
        log.info("DBPrplCommunicationBase.getResultList() success!");
        return collection;
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
    public int getListCount(String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	int count = -1;
    	String conditions1 = conditions.split("##")[0];
    	String conditions2 = conditions.split("##").length>1?conditions.split("##")[1]:"";
    	StringBuffer sb = new StringBuffer(200);
    	sb.append("Select count(*) ");
    	sb.append("	  from (SELECT * ");
		sb.append("       from ((select c.communicationno, ");
		sb.append("             c.communicationtopic, ");
		sb.append("          c.registno, ");
		sb.append("           c.username, ");
		sb.append("         r.insuredname as insuredname, ");
		sb.append("         r.licenseno as licenseno, ");
		sb.append("         c.createTime, ");
		sb.append("        c.closeTime, ");
		sb.append("       case 	when c.validata = '1' then				");
		sb.append("           case   when exists ");
		sb.append("              (select 1 ");
		sb.append("                    from prplcommunicatperson p ");
		sb.append("                  where ( p.communicationno = c.communicationno ");
		sb.append("                   and p.usercode = '"+userCode+"' ");
		sb.append("                   and p.communicationflag = '2' )or c.usercode='"+userCode+"' ) then ");
		sb.append("          'ORANGE' ");
		sb.append("           when exists ");
		sb.append("           (select 1 ");
		sb.append("          from prplcommunicatperson p ");
		sb.append("        where p.communicationno = c.communicationno ");
		sb.append("                  and p.usercode = '"+userCode+"' and p.validata = '1' ");
		sb.append(" 		         and (p.communicationflag is null or ");
		sb.append(" 			          p.communicationflag = '0')) then ");
		sb.append("          'GREEN' ");
		sb.append("         else ");
		sb.append("          'RED' ");
		sb.append("          end "); 
		sb.append("          else ");
		sb.append("          'RED' ");
		sb.append("       end color, ");
		sb.append("       c.validata as validata, ");
		sb.append("        0 as serialno, ");
		sb.append("        0 as lineno ");
		sb.append("     from prplcommunication c, prplregist r ");
		sb.append("    where c.registno = r.registno ");
		sb.append(conditions1);
		
//		sb.append("      and (c.validata = '1' or ");
//		sb.append("       (c.validata = '0' and ");
//		sb.append("              c.communicationNo in ");
//		sb.append("               (select communicationNo ");
//		sb.append("                   from prplcommunicatperson p ");
//		sb.append("                           where p.communicationno = c.communicationno ");
//		sb.append("                             and p.communicationflag = '2' ");
//		sb.append("	                              and p.usercode = '999999'))) ");
//		sb.append("   	                    and (communicationNo in ");
//		sb.append("    	                        (select communicationNo ");
//		sb.append("    	                            from prplcommunicatperson ");
//		sb.append("                          where usercode = '999999'))))) ");

		////
//    	sb.append("Select count(*) from ( ");
//    	sb.append(" SELECT *   													 ");
//    	sb.append("          from ((select c.communicationno,											 ");
//		sb.append("                       c.communicationtopic,										 ");
//		sb.append("                       c.registno,													 ");
//		sb.append("                       c.username,													 ");
//		sb.append("                       r.insuredname as insuredname,								 ");
//		sb.append("                       r.licenseno as licenseno,	 ");
//		sb.append("                       c.createTime,		 ");
//		sb.append("                       c.closeTime,		 ");
//		sb.append("                       case 				 ");
//		sb.append("                         when exists		 ");
//		sb.append("                          (select 1		 ");
//		sb.append("                                 from prplcommunicatperson p 					 ");
//		sb.append("                                where p.communicationno = c.communicationno 		 ");
//		sb.append("                                  and p.usercode = '"+userCode+"' 				 ");
//		sb.append("                                  and p.communicationflag = '2') then  ");
//		sb.append("                          'ORANGE'  ");
//		sb.append("                         when c.validata = '1' then  ");
//		sb.append("                          case  ");
//		sb.append("                            when exists  ");
//		sb.append("                             (select 1  ");
//		sb.append("                                    from prplcommunicatperson p  ");
//		sb.append("                                   where p.communicationno = c.communicationno  ");
//		sb.append("                                     and p.usercode = '"+userCode+"') then  ");
//		sb.append("                             'GREEN'  ");
//		sb.append("                            else  ");
//		sb.append("                             'RED'  ");
//		sb.append("                          end  ");
//		sb.append("                         else  ");
//		sb.append("                          'RED'  ");
//		sb.append("                       end color,  ");
//		sb.append("                       c.validata as validata, ");
//		sb.append("                       0 as serialno,  ");
//		sb.append("                       0 as lineno  ");
//		sb.append("                  from prplcommunication c, prplregist r  ");
//		sb.append("                 where c.registno = r.registno "+conditions1+") ");
    	if("VIEW".equals(editType)){
			if("".equals(flags)||flags.indexOf("0")>-1){
//				sb.append("        Union all (select 'M' as communicationno, ");
//				sb.append("                     m.context as communicationtopic, ");
//				sb.append("                     m.registno, ");
//				sb.append("                     m.operatorname as username, ");
//				sb.append("                     r.insuredname as insuredname, ");
//				sb.append("                     r.licenseno as licenseno, ");
//				sb.append("                     m.inputdate as createTime, ");
//				sb.append("                     m.inputdate as closeTime, ");
//				sb.append("                     'RED' AS color, ");
//				sb.append("                     '0' as validata, ");
//				sb.append("                     m.serialno as serialno,        ");
//				sb.append("                     m.lineno as lineno        ");
//				sb.append("                from prplmessage m, prplregist r ");
//				sb.append("               where m.registno = r.registno "+conditions2+" ))  )	)		");
				sb.append("                )  )	)	                    ");
			}else{
				sb.append(" ) ) )");
			}
		}else{
			sb.append("	 ) )	)");
		}
    	String statement = sb.toString();
    	log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrplCommunication.getCount() success!");
        return count;
    }
    /**
     * 获取当前人员需处理的的沟通个数
     * @param usercode
     * @return
     * @throws Exception
     */
    public int getUserCommunicatNum(String usercode) throws Exception{
    	int count = -1;
    	StringBuffer sb = new StringBuffer(200);
    	sb.append(" Select count(*) from prplCommunication  c  ");
    	sb.append(" where   ");
    	sb.append(" c.validata='1'  ");
    	sb.append(" and (  ");
    	sb.append("     c.communicationno in  ");
    	sb.append(" 	(select communicationNo ");
    	sb.append("        from prplcommunicatperson ");
        sb.append("       where usercode = '"+usercode+"' ");
        sb.append("         and (communicationflag is null or ");
        sb.append("             communicationflag in ('0', '2'))) ");
//    	sb.append("       (select p.communicationno  ");
//    	sb.append("          from prplcommunicatperson p  ");
//    	sb.append("          where p.usercode = '"+usercode+"'  ");
//    	sb.append("           and p.communicationflag in ('0', '1'))  ");
//    	sb.append("      or c.usercode='"+usercode+"'  ");
    	sb.append("     )  ");
        String statement = sb.toString();
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrplCommunicationBase.getUserCommunicatNum() success!");
        return count;
    }
}
