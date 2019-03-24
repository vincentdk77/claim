package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUndoCancel���ϻ�ɾ�������켣��������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUndoCancelBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpUndoCancelBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpUndoCancelBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public void insert(PrpUndoCancelDto prpUndoCancelDto) throws Exception{
        String statement = " Insert Into PrpUndoCancel(" + 
                           " OperateTypeCode," + 
                           " OperateTypeName," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " AppliCode," + 
                           " AppliName," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " Remark," + 
                           " OperatorCode," + 
                           " OperateTime," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpUndoCancelDto.getOperateTypeCode());
        dbManager.setString(2,prpUndoCancelDto.getOperateTypeName());
        dbManager.setString(3,prpUndoCancelDto.getCertiNo());
        dbManager.setInt(4,prpUndoCancelDto.getSerialNo());
        dbManager.setString(5,prpUndoCancelDto.getAppliCode());
        dbManager.setString(6,prpUndoCancelDto.getAppliName());
        dbManager.setString(7,prpUndoCancelDto.getComCode());
        dbManager.setString(8,prpUndoCancelDto.getMakeCom());
        dbManager.setString(9,prpUndoCancelDto.getRemark());
        dbManager.setString(10,prpUndoCancelDto.getOperatorCode());
        dbManager.setDateTime(11,prpUndoCancelDto.getOperateTime());
        dbManager.setString(12,prpUndoCancelDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUndoCancelBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpUndoCancelDto prpUndoCancelDto = (PrpUndoCancelDto)i.next();
            insert(prpUndoCancelDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param operateTypeCode ��������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String operateTypeCode,String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpUndoCancel Where " +
                           " OperateTypeCode = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,operateTypeCode);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpUndoCancelBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public void update(PrpUndoCancelDto prpUndoCancelDto) throws Exception{
        String statement = " Update PrpUndoCancel Set OperateTypeName = ?," + 
                           " AppliCode = ?," + 
                           " AppliName = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " Remark = ?," + 
                           " OperatorCode = ?," + 
                           " OperateTime = ?," + 
                           " Flag = ? Where " +
                           " OperateTypeCode = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpUndoCancelDto.getOperateTypeName());
        dbManager.setString(2,prpUndoCancelDto.getAppliCode());
        dbManager.setString(3,prpUndoCancelDto.getAppliName());
        dbManager.setString(4,prpUndoCancelDto.getComCode());
        dbManager.setString(5,prpUndoCancelDto.getMakeCom());
        dbManager.setString(6,prpUndoCancelDto.getRemark());
        dbManager.setString(7,prpUndoCancelDto.getOperatorCode());
        dbManager.setDateTime(8,prpUndoCancelDto.getOperateTime());
        dbManager.setString(9,prpUndoCancelDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpUndoCancelDto.getOperateTypeCode());
        dbManager.setString(11,prpUndoCancelDto.getCertiNo());
        dbManager.setInt(12,prpUndoCancelDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUndoCancelBase.update() success!");
    }

    /**
     * ����������һ������
     * @param operateTypeCode ��������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @return PrpUndoCancelDto
     * @throws Exception
     */
    public PrpUndoCancelDto findByPrimaryKey(String operateTypeCode,String certiNo,int serialNo) throws Exception{
        String statement = " Select OperateTypeCode," + 
                           " OperateTypeName," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " AppliCode," + 
                           " AppliName," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " Remark," + 
                           " OperatorCode," + 
                           " OperateTime," + 
                           " Flag From PrpUndoCancel Where " +
                           " OperateTypeCode = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpUndoCancelDto prpUndoCancelDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,operateTypeCode);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpUndoCancelDto = new PrpUndoCancelDto();
            prpUndoCancelDto.setOperateTypeCode(dbManager.getString(resultSet,1));
            prpUndoCancelDto.setOperateTypeName(dbManager.getString(resultSet,2));
            prpUndoCancelDto.setCertiNo(dbManager.getString(resultSet,3));
            prpUndoCancelDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpUndoCancelDto.setAppliCode(dbManager.getString(resultSet,5));
            prpUndoCancelDto.setAppliName(dbManager.getString(resultSet,6));
            prpUndoCancelDto.setComCode(dbManager.getString(resultSet,7));
            prpUndoCancelDto.setMakeCom(dbManager.getString(resultSet,8));
            prpUndoCancelDto.setRemark(dbManager.getString(resultSet,9));
            prpUndoCancelDto.setOperatorCode(dbManager.getString(resultSet,10));
            prpUndoCancelDto.setOperateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpUndoCancelDto.setFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        log.info("DBPrpUndoCancelBase.findByPrimaryKey() success!");
        return prpUndoCancelDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select OperateTypeCode," + 
                           " OperateTypeName," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " AppliCode," + 
                           " AppliName," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " Remark," + 
                           " OperatorCode," + 
                           " OperateTime," + 
                           " Flag From PrpUndoCancel Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpUndoCancelDto prpUndoCancelDto = null;
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

            prpUndoCancelDto = new PrpUndoCancelDto();
            prpUndoCancelDto.setOperateTypeCode(dbManager.getString(resultSet,1));
            prpUndoCancelDto.setOperateTypeName(dbManager.getString(resultSet,2));
            prpUndoCancelDto.setCertiNo(dbManager.getString(resultSet,3));
            prpUndoCancelDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpUndoCancelDto.setAppliCode(dbManager.getString(resultSet,5));
            prpUndoCancelDto.setAppliName(dbManager.getString(resultSet,6));
            prpUndoCancelDto.setComCode(dbManager.getString(resultSet,7));
            prpUndoCancelDto.setMakeCom(dbManager.getString(resultSet,8));
            prpUndoCancelDto.setRemark(dbManager.getString(resultSet,9));
            prpUndoCancelDto.setOperatorCode(dbManager.getString(resultSet,10));
            prpUndoCancelDto.setOperateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpUndoCancelDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpUndoCancelDto);
        }
        resultSet.close();
        log.info("DBPrpUndoCancelBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpUndoCancel Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpUndoCancelBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpUndoCancel Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpUndoCancelBase.getCount() success!");
        return count;
    }
}
