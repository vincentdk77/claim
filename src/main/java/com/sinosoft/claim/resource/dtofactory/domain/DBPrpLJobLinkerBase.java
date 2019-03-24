package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLJobLinker�����ݷ��ʶ������<br>
 * ������ 2012-09-06 10:43:07.953<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLJobLinkerBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLJobLinkerBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLJobLinkerBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void insert(PrpLJobLinkerDto prpLJobLinkerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLJobLinker (");
        buffer.append("StaffId,");
        buffer.append("StaffPosition,");
        buffer.append("StaffUserCode,");
        buffer.append("StaffName,");
        buffer.append("StaffPhone,");
        buffer.append("StaffType,");
        buffer.append("Handledept,");
        buffer.append("Month,");
        buffer.append("FlowinTime,");
        buffer.append("ModifyTime,");
        buffer.append("ClassCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLJobLinkerDto.getStaffId()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getStaffPosition()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getStaffUserCode()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getStaffName()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getStaffPhone()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getStaffType()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getHandledept()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getMonth()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getFlowinTime()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getModifyTime()).append("',");
            debugBuffer.append("'").append(prpLJobLinkerDto.getClassCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLJobLinkerDto.getStaffId());
        dbManager.setString(2,prpLJobLinkerDto.getStaffPosition());
        dbManager.setString(3,prpLJobLinkerDto.getStaffUserCode());
        dbManager.setString(4,prpLJobLinkerDto.getStaffName());
        dbManager.setString(5,prpLJobLinkerDto.getStaffPhone());
        dbManager.setString(6,prpLJobLinkerDto.getStaffType());
        dbManager.setString(7,prpLJobLinkerDto.getHandledept());
        dbManager.setString(8,prpLJobLinkerDto.getMonth());
        dbManager.setString(9,prpLJobLinkerDto.getFlowinTime());
        dbManager.setString(10,prpLJobLinkerDto.getModifyTime());
        dbManager.setString(11,prpLJobLinkerDto.getClassCode());
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
        buffer.append("INSERT INTO PrpLJobLinker (");
        buffer.append("StaffId,");
        buffer.append("StaffPosition,");
        buffer.append("StaffUserCode,");
        buffer.append("StaffName,");
        buffer.append("StaffPhone,");
        buffer.append("StaffType,");
        buffer.append("Handledept,");
        buffer.append("Month,");
        buffer.append("FlowinTime,");
        buffer.append("ModifyTime,");
        buffer.append("ClassCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLJobLinkerDto prpLJobLinkerDto = (PrpLJobLinkerDto)i.next();
            dbManager.setString(1,prpLJobLinkerDto.getStaffId());
            dbManager.setString(2,prpLJobLinkerDto.getStaffPosition());
            dbManager.setString(3,prpLJobLinkerDto.getStaffUserCode());
            dbManager.setString(4,prpLJobLinkerDto.getStaffName());
            dbManager.setString(5,prpLJobLinkerDto.getStaffPhone());
            dbManager.setString(6,prpLJobLinkerDto.getStaffType());
            dbManager.setString(7,prpLJobLinkerDto.getHandledept());
            dbManager.setString(8,prpLJobLinkerDto.getMonth());
            dbManager.setString(9,prpLJobLinkerDto.getFlowinTime());
            dbManager.setString(10,prpLJobLinkerDto.getModifyTime());
            dbManager.setString(11,prpLJobLinkerDto.getClassCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param staffId StaffId
     * @throws Exception
     */
    public void delete(String staffId)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLJobLinker ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("StaffId=").append("'").append(staffId).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("StaffId = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,staffId);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void update(PrpLJobLinkerDto prpLJobLinkerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLJobLinker SET ");
        buffer.append("StaffPosition = ?, ");
        buffer.append("StaffUserCode = ?, ");
        buffer.append("StaffName = ?, ");
        buffer.append("StaffPhone = ?, ");
        buffer.append("StaffType = ?, ");
        buffer.append("Handledept = ?, ");
        buffer.append("Month = ?, ");
        buffer.append("FlowinTime = ?, ");
        buffer.append("ModifyTime = ?, ");
        buffer.append("ClassCode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLJobLinker SET ");
            debugBuffer.append("StaffPosition = '" + prpLJobLinkerDto.getStaffPosition() + "', ");
            debugBuffer.append("StaffUserCode = '" + prpLJobLinkerDto.getStaffUserCode() + "', ");
            debugBuffer.append("StaffName = '" + prpLJobLinkerDto.getStaffName() + "', ");
            debugBuffer.append("StaffPhone = '" + prpLJobLinkerDto.getStaffPhone() + "', ");
            debugBuffer.append("StaffType = '" + prpLJobLinkerDto.getStaffType() + "', ");
            debugBuffer.append("Handledept = '" + prpLJobLinkerDto.getHandledept() + "', ");
            debugBuffer.append("Month = '" + prpLJobLinkerDto.getMonth() + "', ");
            debugBuffer.append("FlowinTime = '" + prpLJobLinkerDto.getFlowinTime() + "', ");
            debugBuffer.append("ModifyTime = '" + prpLJobLinkerDto.getModifyTime() + "', ");
            debugBuffer.append("ClassCode = '" + prpLJobLinkerDto.getClassCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("StaffId=").append("'").append(prpLJobLinkerDto.getStaffId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("StaffId = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLJobLinkerDto.getStaffPosition());
        dbManager.setString(2,prpLJobLinkerDto.getStaffUserCode());
        dbManager.setString(3,prpLJobLinkerDto.getStaffName());
        dbManager.setString(4,prpLJobLinkerDto.getStaffPhone());
        dbManager.setString(5,prpLJobLinkerDto.getStaffType());
        dbManager.setString(6,prpLJobLinkerDto.getHandledept());
        dbManager.setString(7,prpLJobLinkerDto.getMonth());
        dbManager.setString(8,prpLJobLinkerDto.getFlowinTime());
        dbManager.setString(9,prpLJobLinkerDto.getModifyTime());
        dbManager.setString(10,prpLJobLinkerDto.getClassCode());
        //���������ֶ�;
        dbManager.setString(11,prpLJobLinkerDto.getStaffId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param staffId StaffId
     * @return PrpLJobLinkerDto
     * @throws Exception
     */
    public PrpLJobLinkerDto findByPrimaryKey(String staffId)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("StaffId,");
        buffer.append("StaffPosition,");
        buffer.append("StaffUserCode,");
        buffer.append("StaffName,");
        buffer.append("StaffPhone,");
        buffer.append("StaffType,");
        buffer.append("Handledept,");
        buffer.append("Month,");
        buffer.append("FlowinTime,");
        buffer.append("ModifyTime,");
        buffer.append("ClassCode ");
        buffer.append("FROM PrpLJobLinker ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("StaffId=").append("'").append(staffId).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("StaffId = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,staffId);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLJobLinkerDto prpLJobLinkerDto = null;
        if(resultSet.next()){
            prpLJobLinkerDto = new PrpLJobLinkerDto();
            prpLJobLinkerDto.setStaffId(dbManager.getString(resultSet,1));
            prpLJobLinkerDto.setStaffPosition(dbManager.getString(resultSet,2));
            prpLJobLinkerDto.setStaffUserCode(dbManager.getString(resultSet,3));
            prpLJobLinkerDto.setStaffName(dbManager.getString(resultSet,4));
            prpLJobLinkerDto.setStaffPhone(dbManager.getString(resultSet,5));
            prpLJobLinkerDto.setStaffType(dbManager.getString(resultSet,6));
            prpLJobLinkerDto.setHandledept(dbManager.getString(resultSet,7));
            prpLJobLinkerDto.setMonth(dbManager.getString(resultSet,8));
            prpLJobLinkerDto.setFlowinTime(dbManager.getString(resultSet,9));
            prpLJobLinkerDto.setModifyTime(dbManager.getString(resultSet,10));
            prpLJobLinkerDto.setClassCode(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpLJobLinkerDto;
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
        buffer.append("StaffId,");
        buffer.append("StaffPosition,");
        buffer.append("StaffUserCode,");
        buffer.append("StaffName,");
        buffer.append("StaffPhone,");
        buffer.append("StaffType,");
        buffer.append("Handledept,");
        buffer.append("Month,");
        buffer.append("FlowinTime,");
        buffer.append("ModifyTime,");
        buffer.append("ClassCode ");
        buffer.append("FROM PrpLJobLinker WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpLJobLinkerDto prpLJobLinkerDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLJobLinkerDto = new PrpLJobLinkerDto();
            prpLJobLinkerDto.setStaffId(dbManager.getString(resultSet,1));
            prpLJobLinkerDto.setStaffPosition(dbManager.getString(resultSet,2));
            prpLJobLinkerDto.setStaffUserCode(dbManager.getString(resultSet,3));
            prpLJobLinkerDto.setStaffName(dbManager.getString(resultSet,4));
            prpLJobLinkerDto.setStaffPhone(dbManager.getString(resultSet,5));
            prpLJobLinkerDto.setStaffType(dbManager.getString(resultSet,6));
            prpLJobLinkerDto.setHandledept(dbManager.getString(resultSet,7));
            prpLJobLinkerDto.setMonth(dbManager.getString(resultSet,8));
            prpLJobLinkerDto.setFlowinTime(dbManager.getString(resultSet,9));
            prpLJobLinkerDto.setModifyTime(dbManager.getString(resultSet,10));
            prpLJobLinkerDto.setClassCode(dbManager.getString(resultSet,11));
            collection.add(prpLJobLinkerDto);
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
        buffer.append("DELETE FROM PrpLJobLinker WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLJobLinker WHERE ");
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
