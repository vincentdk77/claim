package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���������Զ�����״̬��ѯ������ݷ��ʶ������<br>
 */
public class DBPrplinterAutoClaimDetailBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplinterAutoClaimDetailBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplinterAutoClaimDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrplinterAutoClaimDetail (");
        buffer.append("Id,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("SchedSuccFlag,");
        buffer.append("CheckSuccFlag,");
        buffer.append("ClaimSuccFlag,");
        buffer.append("CertiSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark,");
        buffer.append("PrepaySuccFlag,");
        buffer.append("PrepayVericSuccFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getId()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getRegistSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getSchedSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getCheckSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getClaimSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getCertiSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getComppSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getVericSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getEndcaSuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getRemark()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getPrepaySuccFlag()).append("',");
            debugBuffer.append("'").append(prplinterAutoClaimDetailDto.getPrepayVericSuccFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplinterAutoClaimDetailDto.getId());
        dbManager.setString(2,prplinterAutoClaimDetailDto.getRegistNo());
        dbManager.setString(3,prplinterAutoClaimDetailDto.getPolicyNo());
        dbManager.setString(4,prplinterAutoClaimDetailDto.getRegistSuccFlag());
        dbManager.setString(5,prplinterAutoClaimDetailDto.getSchedSuccFlag());
        dbManager.setString(6,prplinterAutoClaimDetailDto.getCheckSuccFlag());
        dbManager.setString(7,prplinterAutoClaimDetailDto.getClaimSuccFlag());
        dbManager.setString(8,prplinterAutoClaimDetailDto.getCertiSuccFlag());
        dbManager.setString(9,prplinterAutoClaimDetailDto.getComppSuccFlag());
        dbManager.setString(10,prplinterAutoClaimDetailDto.getVericSuccFlag());
        dbManager.setString(11,prplinterAutoClaimDetailDto.getEndcaSuccFlag());
        dbManager.setString(12,prplinterAutoClaimDetailDto.getRemark());
        dbManager.setString(13,prplinterAutoClaimDetailDto.getPrepaySuccFlag());
        dbManager.setString(14,prplinterAutoClaimDetailDto.getPrepayVericSuccFlag());
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
        buffer.append("INSERT INTO PrplinterAutoClaimDetail (");
        buffer.append("Id,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("SchedSuccFlag,");
        buffer.append("CheckSuccFlag,");
        buffer.append("ClaimSuccFlag,");
        buffer.append("CertiSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark,");
        buffer.append("PrepaySuccFlag,");
        buffer.append("PrepayVericSuccFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = (PrplinterAutoClaimDetailDto)i.next();
            dbManager.setString(1,prplinterAutoClaimDetailDto.getId());
            dbManager.setString(2,prplinterAutoClaimDetailDto.getRegistNo());
            dbManager.setString(3,prplinterAutoClaimDetailDto.getPolicyNo());
            dbManager.setString(4,prplinterAutoClaimDetailDto.getRegistSuccFlag());
            dbManager.setString(5,prplinterAutoClaimDetailDto.getSchedSuccFlag());
            dbManager.setString(6,prplinterAutoClaimDetailDto.getCheckSuccFlag());
            dbManager.setString(7,prplinterAutoClaimDetailDto.getClaimSuccFlag());
            dbManager.setString(8,prplinterAutoClaimDetailDto.getCertiSuccFlag());
            dbManager.setString(9,prplinterAutoClaimDetailDto.getComppSuccFlag());
            dbManager.setString(10,prplinterAutoClaimDetailDto.getVericSuccFlag());
            dbManager.setString(11,prplinterAutoClaimDetailDto.getEndcaSuccFlag());
            dbManager.setString(12,prplinterAutoClaimDetailDto.getRemark());
            dbManager.setString(13,prplinterAutoClaimDetailDto.getPrepaySuccFlag());
            dbManager.setString(14,prplinterAutoClaimDetailDto.getPrepayVericSuccFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @param registNo �������� PK
     * @throws Exception
     */
    public void delete(String id,String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrplinterAutoClaimDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("RegistNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setString(2,registNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void update(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrplinterAutoClaimDetail SET ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("RegistSuccFlag = ?, ");
        buffer.append("SchedSuccFlag = ?, ");
        buffer.append("CheckSuccFlag = ?, ");
        buffer.append("ClaimSuccFlag = ?, ");
        buffer.append("CertiSuccFlag = ?, ");
        buffer.append("ComppSuccFlag = ?, ");
        buffer.append("VericSuccFlag = ?, ");
        buffer.append("EndcaSuccFlag = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("PrepaySuccFlag = ?, ");
        buffer.append("PrepayVericSuccFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrplinterAutoClaimDetail SET ");
            debugBuffer.append("PolicyNo = '" + prplinterAutoClaimDetailDto.getPolicyNo() + "', ");
            debugBuffer.append("RegistSuccFlag = '" + prplinterAutoClaimDetailDto.getRegistSuccFlag() + "', ");
            debugBuffer.append("SchedSuccFlag = '" + prplinterAutoClaimDetailDto.getSchedSuccFlag() + "', ");
            debugBuffer.append("CheckSuccFlag = '" + prplinterAutoClaimDetailDto.getCheckSuccFlag() + "', ");
            debugBuffer.append("ClaimSuccFlag = '" + prplinterAutoClaimDetailDto.getClaimSuccFlag() + "', ");
            debugBuffer.append("CertiSuccFlag = '" + prplinterAutoClaimDetailDto.getCertiSuccFlag() + "', ");
            debugBuffer.append("ComppSuccFlag = '" + prplinterAutoClaimDetailDto.getComppSuccFlag() + "', ");
            debugBuffer.append("VericSuccFlag = '" + prplinterAutoClaimDetailDto.getVericSuccFlag() + "', ");
            debugBuffer.append("EndcaSuccFlag = '" + prplinterAutoClaimDetailDto.getEndcaSuccFlag() + "', ");
            debugBuffer.append("Remark = '" + prplinterAutoClaimDetailDto.getRemark() + "', ");
            debugBuffer.append("PrepaySuccFlag = '" + prplinterAutoClaimDetailDto.getPrepaySuccFlag() + "', ");
            debugBuffer.append("PrepayVericSuccFlag = '" + prplinterAutoClaimDetailDto.getPrepayVericSuccFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prplinterAutoClaimDetailDto.getId()).append("' AND ");
            debugBuffer.append("RegistNo=").append("'").append(prplinterAutoClaimDetailDto.getRegistNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("RegistNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplinterAutoClaimDetailDto.getPolicyNo());
        dbManager.setString(2,prplinterAutoClaimDetailDto.getRegistSuccFlag());
        dbManager.setString(3,prplinterAutoClaimDetailDto.getSchedSuccFlag());
        dbManager.setString(4,prplinterAutoClaimDetailDto.getCheckSuccFlag());
        dbManager.setString(5,prplinterAutoClaimDetailDto.getClaimSuccFlag());
        dbManager.setString(6,prplinterAutoClaimDetailDto.getCertiSuccFlag());
        dbManager.setString(7,prplinterAutoClaimDetailDto.getComppSuccFlag());
        dbManager.setString(8,prplinterAutoClaimDetailDto.getVericSuccFlag());
        dbManager.setString(9,prplinterAutoClaimDetailDto.getEndcaSuccFlag());
        dbManager.setString(10,prplinterAutoClaimDetailDto.getRemark());
        dbManager.setString(11,prplinterAutoClaimDetailDto.getPrepaySuccFlag());
        dbManager.setString(12,prplinterAutoClaimDetailDto.getPrepayVericSuccFlag());
        //���������ֶ�;
        dbManager.setString(13,prplinterAutoClaimDetailDto.getId());
        dbManager.setString(14,prplinterAutoClaimDetailDto.getRegistNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @param registNo �������� PK
     * @return PrplinterAutoClaimDetailDto
     * @throws Exception
     */
    public PrplinterAutoClaimDetailDto findByPrimaryKey(String id,String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("SchedSuccFlag,");
        buffer.append("CheckSuccFlag,");
        buffer.append("ClaimSuccFlag,");
        buffer.append("CertiSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark,");
        buffer.append("PrepaySuccFlag,");
        buffer.append("PrepayVericSuccFlag ");
        buffer.append("FROM PrplinterAutoClaimDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("RegistNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setString(2,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
        if(resultSet.next()){
            prplinterAutoClaimDetailDto = new PrplinterAutoClaimDetailDto();
            prplinterAutoClaimDetailDto.setId(dbManager.getString(resultSet,1));
            prplinterAutoClaimDetailDto.setRegistNo(dbManager.getString(resultSet,2));
            prplinterAutoClaimDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prplinterAutoClaimDetailDto.setRegistSuccFlag(dbManager.getString(resultSet,4));
            prplinterAutoClaimDetailDto.setSchedSuccFlag(dbManager.getString(resultSet,5));
            prplinterAutoClaimDetailDto.setCheckSuccFlag(dbManager.getString(resultSet,6));
            prplinterAutoClaimDetailDto.setClaimSuccFlag(dbManager.getString(resultSet,7));
            prplinterAutoClaimDetailDto.setCertiSuccFlag(dbManager.getString(resultSet,8));
            prplinterAutoClaimDetailDto.setComppSuccFlag(dbManager.getString(resultSet,9));
            prplinterAutoClaimDetailDto.setVericSuccFlag(dbManager.getString(resultSet,10));
            prplinterAutoClaimDetailDto.setEndcaSuccFlag(dbManager.getString(resultSet,11));
            prplinterAutoClaimDetailDto.setRemark(dbManager.getString(resultSet,12));
            prplinterAutoClaimDetailDto.setPrepaySuccFlag(dbManager.getString(resultSet,13));
            prplinterAutoClaimDetailDto.setPrepayVericSuccFlag(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        return prplinterAutoClaimDetailDto;
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
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("SchedSuccFlag,");
        buffer.append("CheckSuccFlag,");
        buffer.append("ClaimSuccFlag,");
        buffer.append("CertiSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark,");
        buffer.append("PrepaySuccFlag,");
        buffer.append("PrepayVericSuccFlag ");
        buffer.append("FROM PrplinterAutoClaimDetail WHERE ");
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
        PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplinterAutoClaimDetailDto = new PrplinterAutoClaimDetailDto();
            prplinterAutoClaimDetailDto.setId(dbManager.getString(resultSet,"Id"));
            prplinterAutoClaimDetailDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
            prplinterAutoClaimDetailDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prplinterAutoClaimDetailDto.setRegistSuccFlag(dbManager.getString(resultSet,"RegistSuccFlag"));
            prplinterAutoClaimDetailDto.setSchedSuccFlag(dbManager.getString(resultSet,"SchedSuccFlag"));
            prplinterAutoClaimDetailDto.setCheckSuccFlag(dbManager.getString(resultSet,"CheckSuccFlag"));
            prplinterAutoClaimDetailDto.setClaimSuccFlag(dbManager.getString(resultSet,"ClaimSuccFlag"));
            prplinterAutoClaimDetailDto.setCertiSuccFlag(dbManager.getString(resultSet,"CertiSuccFlag"));
            prplinterAutoClaimDetailDto.setComppSuccFlag(dbManager.getString(resultSet,"ComppSuccFlag"));
            prplinterAutoClaimDetailDto.setVericSuccFlag(dbManager.getString(resultSet,"VericSuccFlag"));
            prplinterAutoClaimDetailDto.setEndcaSuccFlag(dbManager.getString(resultSet,"EndcaSuccFlag"));
            prplinterAutoClaimDetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            prplinterAutoClaimDetailDto.setPrepaySuccFlag(dbManager.getString(resultSet,"PrepaySuccFlag"));
            prplinterAutoClaimDetailDto.setPrepayVericSuccFlag(dbManager.getString(resultSet,"PrepayVericSuccFlag"));
            collection.add(prplinterAutoClaimDetailDto);
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
        buffer.append("DELETE FROM PrplinterAutoClaimDetail WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }
    
    /**
     * ������ɾ��һ������
     * @param id ����id
     * @param outId �ͻ�������
     * @throws Exception
     */
    public void updateBySQL(String sql)
            throws Exception{
    	if(logger.isDebugEnabled()){
            logger.debug(sql);
        }
    	dbManager.executeUpdate(sql);
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
        buffer.append("SELECT count(1) FROM PrplinterAutoClaimDetail WHERE ");
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
