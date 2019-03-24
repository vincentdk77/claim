package com.sinosoft.claim.webservice.paymentinformatino;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflogBase;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISITLOG�����ݷ��ʶ������
 * @author Administrator
 *
 */
public class DBPrplagrireturnvisitlogBase {
	/**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplreturnvisitswflogBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplagrireturnvisitlogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param PrplAgrireturnvisitlogDto 
     * @throws Exception
     */
    public void insert(PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PRPLAGRIRETURNVISITLOG (");
        buffer.append("Businessno,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getComcode()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getComcodename()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getInsuredname()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getHandlercode()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getHandlername()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitlogDto.getHandlercomcode()).append("')");
            logger.debug(debugBuffer.toString());
        }
        
        System.err.println(buffer);
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplagrireturnvisitlogDto.getBusinessno());
        dbManager.setString(2,prplagrireturnvisitlogDto.getRegistno());
        dbManager.setString(3,prplagrireturnvisitlogDto.getPolicyno());
        dbManager.setString(4,prplagrireturnvisitlogDto.getComcode());
        dbManager.setString(5,prplagrireturnvisitlogDto.getComcodename());
        dbManager.setString(6,prplagrireturnvisitlogDto.getInsuredname());
        dbManager.setString(7,prplagrireturnvisitlogDto.getHandlercode());
        dbManager.setString(8,prplagrireturnvisitlogDto.getHandlername());
        dbManager.setString(9,prplagrireturnvisitlogDto.getHandlercomcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PRPLAGRIRETURNVISITLOG (");
        buffer.append("Businessno,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = (PrplAgrireturnvisitlogDto)i.next();
            dbManager.setString(1,prplagrireturnvisitlogDto.getBusinessno());
            dbManager.setString(2,prplagrireturnvisitlogDto.getRegistno());
            dbManager.setString(3,prplagrireturnvisitlogDto.getPolicyno());
            dbManager.setString(4,prplagrireturnvisitlogDto.getComcode());
            dbManager.setString(5,prplagrireturnvisitlogDto.getComcodename());
            dbManager.setString(6,prplagrireturnvisitlogDto.getInsuredname());
            dbManager.setString(7,prplagrireturnvisitlogDto.getHandlercode());
            dbManager.setString(8,prplagrireturnvisitlogDto.getHandlername());
            dbManager.setString(9,prplagrireturnvisitlogDto.getHandlercomcode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String businessno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PRPLAGRIRETURNVISITLOG ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Businessno = ?");
        System.err.println(buffer);
        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessno);
        
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param PrplAgrireturnvisitlogDto 
     * @throws Exception
     */
    public void update(PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PRPLAGRIRETURNVISITLOG SET ");
        buffer.append("Registno = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Comcode = ?, ");
        buffer.append("Comcodename = ?, ");
        buffer.append("Insuredname = ?, ");
        buffer.append("Handlercode = ?, ");
        buffer.append("Handlername = ?, ");
        buffer.append("Handlercomcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PRPLAGRIRETURNVISITLOG SET ");
            debugBuffer.append("Registno = '" + prplagrireturnvisitlogDto.getRegistno() + "', ");
            debugBuffer.append("Policyno = '" + prplagrireturnvisitlogDto.getPolicyno() + "', ");
            debugBuffer.append("Comcode = '" + prplagrireturnvisitlogDto.getComcode() + "', ");
            debugBuffer.append("Comcodename = '" + prplagrireturnvisitlogDto.getComcodename() + "', ");
            debugBuffer.append("Insuredname = '" + prplagrireturnvisitlogDto.getInsuredname() + "', ");
            debugBuffer.append("Handlercode = '" + prplagrireturnvisitlogDto.getHandlercode() + "', ");
            debugBuffer.append("Handlername = '" + prplagrireturnvisitlogDto.getHandlername() + "', ");
            debugBuffer.append("Handlercomcode = '" + prplagrireturnvisitlogDto.getHandlercomcode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Businessno=").append("'").append(prplagrireturnvisitlogDto.getBusinessno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplagrireturnvisitlogDto.getRegistno());
        dbManager.setString(2,prplagrireturnvisitlogDto.getPolicyno());
        dbManager.setString(3,prplagrireturnvisitlogDto.getComcode());
        dbManager.setString(4,prplagrireturnvisitlogDto.getComcodename());
        dbManager.setString(5,prplagrireturnvisitlogDto.getInsuredname());
        dbManager.setString(6,prplagrireturnvisitlogDto.getHandlercode());
        dbManager.setString(7,prplagrireturnvisitlogDto.getHandlername());
        dbManager.setString(8,prplagrireturnvisitlogDto.getHandlercomcode());
        //���������ֶ�;
        dbManager.setString(9,prplagrireturnvisitlogDto.getBusinessno());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return PrplreturnvisitswflogDto
     * @throws Exception
     */
    public PrplAgrireturnvisitlogDto findByPrimaryKey(String businessno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Businessno,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode ");
        buffer.append("FROM PrplAgrireturnvisitlog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = null;
        if(resultSet.next()){
        	prplagrireturnvisitlogDto = new PrplAgrireturnvisitlogDto();
        	prplagrireturnvisitlogDto.setBusinessno(dbManager.getString(resultSet,1));
        	prplagrireturnvisitlogDto.setRegistno(dbManager.getString(resultSet,2));
        	prplagrireturnvisitlogDto.setPolicyno(dbManager.getString(resultSet,3));
        	prplagrireturnvisitlogDto.setComcode(dbManager.getString(resultSet,4));
        	prplagrireturnvisitlogDto.setComcodename(dbManager.getString(resultSet,5));
        	prplagrireturnvisitlogDto.setInsuredname(dbManager.getString(resultSet,6));
        	prplagrireturnvisitlogDto.setHandlercode(dbManager.getString(resultSet,7));
        	prplagrireturnvisitlogDto.setHandlername(dbManager.getString(resultSet,8));
        	prplagrireturnvisitlogDto.setHandlercomcode(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prplagrireturnvisitlogDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Businessno,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode ");
        buffer.append("FROM PrplAgrireturnvisitlog WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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
            collection.add(prplagrireturnvisitlogDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrplAgrireturnvisitlog WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM PrplAgrireturnvisitlog WHERE ");
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
}
