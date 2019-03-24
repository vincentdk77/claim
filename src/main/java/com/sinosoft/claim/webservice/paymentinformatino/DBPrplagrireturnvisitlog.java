package com.sinosoft.claim.webservice.paymentinformatino;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISITLOG�����ݷ��ʶ�����
 * @author Administrator
 *
 */
public class DBPrplagrireturnvisitlog extends DBPrplagrireturnvisitlogBase {
	 private static Logger logger = Logger.getLogger(DBPrplagrireturnvisitlog.class);

	    /**
	     * ���캯��
	     * @param dbManager ��Դ������
	     */
	    public DBPrplagrireturnvisitlog(DBManager dbManager){
	        super(dbManager);
	    }

	    /**
	     * ��ѯ����ģ����ѯ�����ļ�¼��
	     * @param conditions conditions
	     * @return ����ģ����ѯ�����ļ�¼��
	     * @throws Exception
	     */
		public int getCountQuery(String conditions) throws Exception {
			int count = -1;
	        StringBuffer buffer = new StringBuffer(100);
	        buffer.append("SELECT count(Distinct(g.businessno)) FROM prplagrireturnvisitlog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        count = dbManager.getInt(resultSet,1);
	        resultSet.close();
	        return count;
		}

		/**
	     * ��������ѯ��������
	     * @param conditions ��ѯ����
	     * @param pageNo ҳ��
	     * @param rowsPerPage ÿҳ������
	     * @return Collection
	     * @throws Exception
	     */
		public Collection findByQueryConditions(String conditions, int pageNo,
				int rowsPerPage) throws Exception {
			StringBuffer buffer = new StringBuffer(200);
	        //ƴSQL���
	        buffer.append("SELECT ");
	        buffer.append("Distinct(g.Businessno),");
	        buffer.append("g.Registno,");
	        buffer.append("g.Policyno,");
	        buffer.append("g.Comcode,");
	        buffer.append("g.Comcodename,");
	        buffer.append("g.Insuredname,");
	        buffer.append("g.Handlercode,");
	        buffer.append("g.Handlername,");
	        buffer.append("g.Handlercomcode,");
	        buffer.append("c.bycomplaintcode,");
	        buffer.append("c.bycomplaintcomcode,");
	        buffer.append("c.complaintdate,");
	        buffer.append("r.receivername,");
	        buffer.append("r.Reportdate as stReportdate,");
	        buffer.append("r.Reporthour ");
	        buffer.append("FROM prplagrireturnvisitlog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplComplaint c On g.businessno=c.complaintno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
	        buffer.append(conditions);
	        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
	        if (pageNo > 0){
	            //��Oracle�Ż�
	            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	                buffer.append(") row_) WHERE rownum_ > "+rowsPerPage * (pageNo - 1)+" and rownum_ <= "+rowsPerPage * pageNo);
	                supportPaging=true;
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
	                supportPaging=true;
	            }
	        }
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }     
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        int count=0;
	        if(supportPaging==false && pageNo>1){
	            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
	        }
	        
	        //���巵�ؽ������
	        Collection collection = new ArrayList(rowsPerPage);
	        PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = null;
	        while(resultSet.next()){
	            if (supportPaging == false && pageNo>0) {
	                count++;
	                if(count > rowsPerPage){
	                    break;
	                }
	            }

	            prplagrireturnvisitlogDto = new PrplAgrireturnvisitlogDto();
	            prplagrireturnvisitlogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
	            prplagrireturnvisitlogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
	            prplagrireturnvisitlogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
	            prplagrireturnvisitlogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
	            prplagrireturnvisitlogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
	            prplagrireturnvisitlogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
	            prplagrireturnvisitlogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
	            prplagrireturnvisitlogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
	            prplagrireturnvisitlogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
	            prplagrireturnvisitlogDto.setBycomplaintcode(dbManager.getString(resultSet,"bycomplaintcode"));
	            prplagrireturnvisitlogDto.setBycomplaintcomcode(dbManager.getString(resultSet,"bycomplaintcomcode"));
	            prplagrireturnvisitlogDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"complaintdate").toString());
	            prplagrireturnvisitlogDto.setReceivername(dbManager.getString(resultSet,"receivername"));
	            prplagrireturnvisitlogDto.setStReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"stReportdate").toString());
	            prplagrireturnvisitlogDto.setStReportHour(dbManager.getString(resultSet,"Reporthour"));
	            collection.add(prplagrireturnvisitlogDto);
	            
	        }
	        resultSet.close();
	        return collection;
		}
		
		
		/**
	     * ������ѯ
	     * add by zhangzhiqiang 20120914
	     * @param conditions ��ѯ����
	     * @param pageNo ҳ��
	     * @param rowsPerPage ÿҳ������
	     * @return Collection
	     * @throws Exception
	     */
		public Collection findByQueryExpConditions(String conditions, int pageNo,int rowsPerPage) throws Exception {
			StringBuffer buffer = new StringBuffer(200);
	        //ƴSQL���
	        buffer.append("SELECT ");
	        buffer.append("Distinct(g.Businessno),");
	        buffer.append("g.Registno,");
	        buffer.append("g.Policyno,");
	        buffer.append("g.Comcode,");
	        buffer.append("g.Comcodename,");
	        buffer.append("g.Insuredname,");
	        buffer.append("g.Handlercode,");
	        buffer.append("g.Handlername,");
	        buffer.append("g.Handlercomcode,");
	        buffer.append("c.bycomplaintcode,");
	        buffer.append("c.bycomplaintcomcode,");
	        buffer.append("c.complaintdate,");
	        buffer.append("r.receivername ");
	        buffer.append("FROM prplagrireturnvisitlog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplComplaint c On g.businessno=c.complaintno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        //���巵�ؽ������
	        Collection collection = new ArrayList(rowsPerPage);
	        PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = null;
	        while(resultSet.next()){  
	        	prplagrireturnvisitlogDto = new PrplAgrireturnvisitlogDto();
	        	prplagrireturnvisitlogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
	        	prplagrireturnvisitlogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
	        	prplagrireturnvisitlogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
	        	prplagrireturnvisitlogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
	        	prplagrireturnvisitlogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
	        	prplagrireturnvisitlogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
	        	prplagrireturnvisitlogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
	        	prplagrireturnvisitlogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
	        	prplagrireturnvisitlogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
	        	prplagrireturnvisitlogDto.setBycomplaintcode(dbManager.getString(resultSet,"bycomplaintcode"));
	        	prplagrireturnvisitlogDto.setBycomplaintcomcode(dbManager.getString(resultSet,"bycomplaintcomcode"));
	        	prplagrireturnvisitlogDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"complaintdate").toString());
	        	prplagrireturnvisitlogDto.setReceivername(dbManager.getString(resultSet,"receivername"));
	            collection.add(prplagrireturnvisitlogDto);
	        }
	        resultSet.close();
	        return collection;
		}

		public Double findSumprepaidBySQL(String sql) throws Exception {
			 ResultSet resultSet = dbManager.executeQuery(sql);
			 if(logger.isDebugEnabled()){
		            logger.debug(sql);
		        }
			 Double sumprepaid = 0d;
			 while(resultSet.next()){
				 sumprepaid +=dbManager.getDouble(resultSet, 1);
			 }
			 resultSet.close();
			
			return sumprepaid;
		}
		/**
	     * ��������ѯ��������
	     * @param conditions ��ѯ����
	     * @param pageNo ҳ��
	     * @param rowsPerPage ÿҳ������
	     * @return Collection
	     * @thro	ws Exception
	     */
		public Collection findByQueryConditionsEndca(String conditions, int pageNo,
				int rowsPerPage) throws Exception {
			StringBuffer buffer = new StringBuffer(200);
	        //ƴSQL���
	        buffer.append("SELECT ");
	        buffer.append("Distinct(g.Businessno),");
	        buffer.append("g.Registno,");
	        buffer.append("g.Policyno,");
	        buffer.append("g.Comcode,");
	        buffer.append("g.Comcodename,");
	        buffer.append("g.Insuredname,");
	        buffer.append("g.Handlercode,");
	        buffer.append("g.Handlername,");
	        buffer.append("g.Handlercomcode,");
	        buffer.append("c.bycomplaintcode,");
	        buffer.append("c.bycomplaintcomcode,");
	        buffer.append("c.complaintdate,");
	        buffer.append("r.receivername,");
	        buffer.append("r.Reportdate as stReportdate,");
	        buffer.append("r.Reporthour,");
	        buffer.append(" (select min(f.payrefdate) ");
	        buffer.append("   from prpjpayrefrec f ");
	        buffer.append("   where 1 = 1 ");
	        buffer.append("   and f.certitype in ('C', 'Y') ");
	        buffer.append("   and f.payrefreason in ('P50', 'P60') ");
	        buffer.append("      and exists (select 1 ");
	        buffer.append("      from prplclaim l ");
	        buffer.append("         where f.claimno = l.claimno ");
	        buffer.append("    and l.registno = g.registno)) as payrefdate  ");
	        buffer.append("FROM prplagrireturnvisitlog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplComplaint c On g.businessno=c.complaintno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
	        buffer.append(conditions);
	        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
	        if (pageNo > 0){
	            //��Oracle�Ż�
	            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	                buffer.append(") row_) WHERE rownum_ > "+rowsPerPage * (pageNo - 1)+" and rownum_ <= "+rowsPerPage * pageNo);
	                supportPaging=true;
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
	                supportPaging=true;
	            }
	        }
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        int count=0;
	        if(supportPaging==false && pageNo>1){
	            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
	        }
	        //���巵�ؽ������
	        Collection collection = new ArrayList(rowsPerPage);
	        PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = null;
	        while(resultSet.next()){
	            if (supportPaging == false && pageNo>0) {
	                count++;
	                if(count > rowsPerPage){
	                    break;
	                }
	            }
	            prplagrireturnvisitlogDto = new PrplAgrireturnvisitlogDto();
	            prplagrireturnvisitlogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
	            prplagrireturnvisitlogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
	            prplagrireturnvisitlogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
	            prplagrireturnvisitlogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
	            prplagrireturnvisitlogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
	            prplagrireturnvisitlogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
	            prplagrireturnvisitlogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
	            prplagrireturnvisitlogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
	            prplagrireturnvisitlogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
	            prplagrireturnvisitlogDto.setBycomplaintcode(dbManager.getString(resultSet,"bycomplaintcode"));
	            prplagrireturnvisitlogDto.setBycomplaintcomcode(dbManager.getString(resultSet,"bycomplaintcomcode"));
	            prplagrireturnvisitlogDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"complaintdate").toString());
	            prplagrireturnvisitlogDto.setReceivername(dbManager.getString(resultSet,"receivername"));
	            prplagrireturnvisitlogDto.setStReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"stReportdate").toString());
	            prplagrireturnvisitlogDto.setStReportHour(dbManager.getString(resultSet,"Reporthour"));
	            collection.add(prplagrireturnvisitlogDto);
	        }
	        resultSet.close();
	        return collection;
		}
}
