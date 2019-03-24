package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������������Ϣ�����ݷ��ʶ������<br>
 */
public class DBPrpLinterClaimAppBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterClaimAppBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterClaimAppBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void insert(PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterClaimApp (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterClaimAppDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getRelationCode()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getPhone()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getProposerAddress()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterClaimAppDto.getId());
        dbManager.setInt(2,prpLinterClaimAppDto.getSerialNo());
        dbManager.setString(3,prpLinterClaimAppDto.getAcciName());
        dbManager.setString(4,prpLinterClaimAppDto.getIdentifyNumber());
        dbManager.setString(5,prpLinterClaimAppDto.getRelationCode());
        dbManager.setString(6,prpLinterClaimAppDto.getPhone());
        dbManager.setString(7,prpLinterClaimAppDto.getProposerAddress());
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
        buffer.append("INSERT INTO PrpLinterClaimApp (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterClaimAppDto prpLinterClaimAppDto = (PrpLinterClaimAppDto)i.next();
            dbManager.setString(1,prpLinterClaimAppDto.getId());
            dbManager.setInt(2,prpLinterClaimAppDto.getSerialNo());
            dbManager.setString(3,prpLinterClaimAppDto.getAcciName());
            dbManager.setString(4,prpLinterClaimAppDto.getIdentifyNumber());
            dbManager.setString(5,prpLinterClaimAppDto.getRelationCode());
            dbManager.setString(6,prpLinterClaimAppDto.getPhone());
            dbManager.setString(7,prpLinterClaimAppDto.getProposerAddress());
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
        buffer.append("DELETE FROM PrpLinterClaimApp ");
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
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void update(PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterClaimApp SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("AcciName = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("RelationCode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("ProposerAddress = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterClaimApp SET ");
            debugBuffer.append("SerialNo = " + prpLinterClaimAppDto.getSerialNo() + ", ");
            debugBuffer.append("AcciName = '" + prpLinterClaimAppDto.getAcciName() + "', ");
            debugBuffer.append("IdentifyNumber = '" + prpLinterClaimAppDto.getIdentifyNumber() + "', ");
            debugBuffer.append("RelationCode = '" + prpLinterClaimAppDto.getRelationCode() + "', ");
            debugBuffer.append("Phone = '" + prpLinterClaimAppDto.getPhone() + "', ");
            debugBuffer.append("ProposerAddress = '" + prpLinterClaimAppDto.getProposerAddress() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterClaimAppDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,prpLinterClaimAppDto.getSerialNo());
        dbManager.setString(2,prpLinterClaimAppDto.getAcciName());
        dbManager.setString(3,prpLinterClaimAppDto.getIdentifyNumber());
        dbManager.setString(4,prpLinterClaimAppDto.getRelationCode());
        dbManager.setString(5,prpLinterClaimAppDto.getPhone());
        dbManager.setString(6,prpLinterClaimAppDto.getProposerAddress());
        //���������ֶ�;
        dbManager.setString(7,prpLinterClaimAppDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @return PrpLinterClaimAppDto
     * @throws Exception
     */
    public PrpLinterClaimAppDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append("FROM PrpLinterClaimApp ");
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
        PrpLinterClaimAppDto prpLinterClaimAppDto = null;
        if(resultSet.next()){
            prpLinterClaimAppDto = new PrpLinterClaimAppDto();
            prpLinterClaimAppDto.setId(dbManager.getString(resultSet,1));
            prpLinterClaimAppDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterClaimAppDto.setAcciName(dbManager.getString(resultSet,3));
            prpLinterClaimAppDto.setIdentifyNumber(dbManager.getString(resultSet,4));
            prpLinterClaimAppDto.setRelationCode(dbManager.getString(resultSet,5));
            prpLinterClaimAppDto.setPhone(dbManager.getString(resultSet,6));
            prpLinterClaimAppDto.setProposerAddress(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        return prpLinterClaimAppDto;
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
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append("FROM PrpLinterClaimApp WHERE ");
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
        PrpLinterClaimAppDto prpLinterClaimAppDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterClaimAppDto = new PrpLinterClaimAppDto();
            prpLinterClaimAppDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterClaimAppDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterClaimAppDto.setAcciName(dbManager.getString(resultSet,"AcciName"));
            prpLinterClaimAppDto.setIdentifyNumber(dbManager.getString(resultSet,"IdentifyNumber"));
            prpLinterClaimAppDto.setRelationCode(dbManager.getString(resultSet,"RelationCode"));
            prpLinterClaimAppDto.setPhone(dbManager.getString(resultSet,"Phone"));
            prpLinterClaimAppDto.setProposerAddress(dbManager.getString(resultSet,"ProposerAddress"));
            collection.add(prpLinterClaimAppDto);
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
        buffer.append("DELETE FROM PrpLinterClaimApp WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterClaimApp WHERE ");
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
