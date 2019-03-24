package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ�֧���˻����̹켣������ݷ��ʶ������<br>
 */
public class DBPrplinterPayBackDetailBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplinterPayBackDetailBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplinterPayBackDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public void insert(PrplinterPayBackDetailDto prplinterPayBackDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrplinterPayBackDetail (");
        buffer.append("Id,");
        buffer.append("RelationId,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("OperatorCode,");
        buffer.append("BackComCode,");
        buffer.append("BackReason,");
        buffer.append("SaveSuccFlag,");
        buffer.append("MutualSuccFlag,");
        buffer.append("InputDate,");
        buffer.append("Remark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getId()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getRelationId()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getOutId()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getPaymentNo()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getBackComCode()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getBackReason()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getSaveSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getMutualSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prplinterPayBackDetailDto.getRemark()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplinterPayBackDetailDto.getId());
        dbManager.setString(2,prplinterPayBackDetailDto.getRelationId());
        dbManager.setString(3,prplinterPayBackDetailDto.getOutId());
        dbManager.setString(4,prplinterPayBackDetailDto.getPaymentNo());
        dbManager.setString(5,prplinterPayBackDetailDto.getOperatorCode());
        dbManager.setString(6,prplinterPayBackDetailDto.getBackComCode());
        dbManager.setString(7,prplinterPayBackDetailDto.getBackReason());
        dbManager.setString(8,prplinterPayBackDetailDto.getSaveSuccFlag());
        dbManager.setString(9,prplinterPayBackDetailDto.getMutualSuccFlag());
        dbManager.setDateTime(10,prplinterPayBackDetailDto.getInputDate());
        dbManager.setString(11,prplinterPayBackDetailDto.getRemark());
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
        buffer.append("INSERT INTO PrplinterPayBackDetail (");
        buffer.append("Id,");
        buffer.append("RelationId,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("OperatorCode,");
        buffer.append("BackComCode,");
        buffer.append("BackReason,");
        buffer.append("SaveSuccFlag,");
        buffer.append("MutualSuccFlag,");
        buffer.append("InputDate,");
        buffer.append("Remark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplinterPayBackDetailDto prplinterPayBackDetailDto = (PrplinterPayBackDetailDto)i.next();
            dbManager.setString(1,prplinterPayBackDetailDto.getId());
            dbManager.setString(2,prplinterPayBackDetailDto.getRelationId());
            dbManager.setString(3,prplinterPayBackDetailDto.getOutId());
            dbManager.setString(4,prplinterPayBackDetailDto.getPaymentNo());
            dbManager.setString(5,prplinterPayBackDetailDto.getOperatorCode());
            dbManager.setString(6,prplinterPayBackDetailDto.getBackComCode());
            dbManager.setString(7,prplinterPayBackDetailDto.getBackReason());
            dbManager.setString(8,prplinterPayBackDetailDto.getSaveSuccFlag());
            dbManager.setString(9,prplinterPayBackDetailDto.getMutualSuccFlag());
            dbManager.setDateTime(10,prplinterPayBackDetailDto.getInputDate());
            dbManager.setString(11,prplinterPayBackDetailDto.getRemark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrplinterPayBackDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public void update(PrplinterPayBackDetailDto prplinterPayBackDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrplinterPayBackDetail SET ");
        buffer.append("RelationId = ?, ");
        buffer.append("OutId = ?, ");
        buffer.append("PaymentNo = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("BackComCode = ?, ");
        buffer.append("BackReason = ?, ");
        buffer.append("SaveSuccFlag = ?, ");
        buffer.append("MutualSuccFlag = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("Remark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrplinterPayBackDetail SET ");
            debugBuffer.append("RelationId = '" + prplinterPayBackDetailDto.getRelationId() + "', ");
            debugBuffer.append("OutId = '" + prplinterPayBackDetailDto.getOutId() + "', ");
            debugBuffer.append("PaymentNo = '" + prplinterPayBackDetailDto.getPaymentNo() + "', ");
            debugBuffer.append("OperatorCode = '" + prplinterPayBackDetailDto.getOperatorCode() + "', ");
            debugBuffer.append("BackComCode = '" + prplinterPayBackDetailDto.getBackComCode() + "', ");
            debugBuffer.append("BackReason = '" + prplinterPayBackDetailDto.getBackReason() + "', ");
            debugBuffer.append("SaveSuccFlag = '" + prplinterPayBackDetailDto.getSaveSuccFlag() + "', ");
            debugBuffer.append("MutualSuccFlag = '" + prplinterPayBackDetailDto.getMutualSuccFlag() + "', ");
            debugBuffer.append("InputDate = '" + prplinterPayBackDetailDto.getInputDate() + "', ");
            debugBuffer.append("Remark = '" + prplinterPayBackDetailDto.getRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prplinterPayBackDetailDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplinterPayBackDetailDto.getRelationId());
        dbManager.setString(2,prplinterPayBackDetailDto.getOutId());
        dbManager.setString(3,prplinterPayBackDetailDto.getPaymentNo());
        dbManager.setString(4,prplinterPayBackDetailDto.getOperatorCode());
        dbManager.setString(5,prplinterPayBackDetailDto.getBackComCode());
        dbManager.setString(6,prplinterPayBackDetailDto.getBackReason());
        dbManager.setString(7,prplinterPayBackDetailDto.getSaveSuccFlag());
        dbManager.setString(8,prplinterPayBackDetailDto.getMutualSuccFlag());
        dbManager.setDateTime(9,prplinterPayBackDetailDto.getInputDate());
        dbManager.setString(10,prplinterPayBackDetailDto.getRemark());
        //���������ֶ�;
        dbManager.setString(11,prplinterPayBackDetailDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @return PrplinterPayBackDetailDto
     * @throws Exception
     */
    public PrplinterPayBackDetailDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("RelationId,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("OperatorCode,");
        buffer.append("BackComCode,");
        buffer.append("BackReason,");
        buffer.append("SaveSuccFlag,");
        buffer.append("MutualSuccFlag,");
        buffer.append("InputDate,");
        buffer.append("Remark ");
        buffer.append("FROM PrplinterPayBackDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplinterPayBackDetailDto prplinterPayBackDetailDto = null;
        if(resultSet.next()){
            prplinterPayBackDetailDto = new PrplinterPayBackDetailDto();
            prplinterPayBackDetailDto.setId(dbManager.getString(resultSet,1));
            prplinterPayBackDetailDto.setRelationId(dbManager.getString(resultSet,2));
            prplinterPayBackDetailDto.setOutId(dbManager.getString(resultSet,3));
            prplinterPayBackDetailDto.setPaymentNo(dbManager.getString(resultSet,4));
            prplinterPayBackDetailDto.setOperatorCode(dbManager.getString(resultSet,5));
            prplinterPayBackDetailDto.setBackComCode(dbManager.getString(resultSet,6));
            prplinterPayBackDetailDto.setBackReason(dbManager.getString(resultSet,7));
            prplinterPayBackDetailDto.setSaveSuccFlag(dbManager.getString(resultSet,8));
            prplinterPayBackDetailDto.setMutualSuccFlag(dbManager.getString(resultSet,9));
            prplinterPayBackDetailDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prplinterPayBackDetailDto.setRemark(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prplinterPayBackDetailDto;
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
        buffer.append("Id,");
        buffer.append("RelationId,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("OperatorCode,");
        buffer.append("BackComCode,");
        buffer.append("BackReason,");
        buffer.append("SaveSuccFlag,");
        buffer.append("MutualSuccFlag,");
        buffer.append("InputDate,");
        buffer.append("Remark ");
        buffer.append("FROM PrplinterPayBackDetail WHERE ");
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
        PrplinterPayBackDetailDto prplinterPayBackDetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplinterPayBackDetailDto = new PrplinterPayBackDetailDto();
            prplinterPayBackDetailDto.setId(dbManager.getString(resultSet,"Id"));
            prplinterPayBackDetailDto.setRelationId(dbManager.getString(resultSet,"RelationId"));
            prplinterPayBackDetailDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prplinterPayBackDetailDto.setPaymentNo(dbManager.getString(resultSet,"PaymentNo"));
            prplinterPayBackDetailDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prplinterPayBackDetailDto.setBackComCode(dbManager.getString(resultSet,"BackComCode"));
            prplinterPayBackDetailDto.setBackReason(dbManager.getString(resultSet,"BackReason"));
            prplinterPayBackDetailDto.setSaveSuccFlag(dbManager.getString(resultSet,"SaveSuccFlag"));
            prplinterPayBackDetailDto.setMutualSuccFlag(dbManager.getString(resultSet,"MutualSuccFlag"));
            prplinterPayBackDetailDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            prplinterPayBackDetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            collection.add(prplinterPayBackDetailDto);
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
        buffer.append("DELETE FROM PrplinterPayBackDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrplinterPayBackDetail WHERE ");
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
