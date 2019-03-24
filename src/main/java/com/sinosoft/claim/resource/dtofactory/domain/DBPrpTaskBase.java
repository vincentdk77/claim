package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prptask������������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpTaskBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpTaskBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpTaskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void insert(PrpTaskDto prpTaskDto) throws Exception{
        String statement = " Insert Into PrpTask(" + 
                           " TaskCode," + 
                           " TaskName," + 
                           " CheckType," + 
                           " CheckName," + 
                           " GradePoint," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpTaskDto.getTaskCode());
        dbManager.setString(2,prpTaskDto.getTaskName());
        dbManager.setString(3,prpTaskDto.getCheckType());
        dbManager.setString(4,prpTaskDto.getCheckName());
        dbManager.setInt(5,prpTaskDto.getGradePoint());
        dbManager.setString(6,prpTaskDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpTaskBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpTaskDto prpTaskDto = (PrpTaskDto)i.next();
            insert(prpTaskDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param taskCode �������
     * @param checkType Ȩ�޼�������
     * @throws Exception
     */
    public void delete(String taskCode,String checkType) throws Exception{
        String statement = " Delete From PrpTask Where " +
                           " TaskCode = ? And " + 
                           " CheckType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,taskCode);
        dbManager.setString(2,checkType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpTaskBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void update(PrpTaskDto prpTaskDto) throws Exception{
        String statement = " Update PrpTask Set TaskName = ?," + 
                           " CheckName = ?," + 
                           " GradePoint = ?," + 
                           " Flag = ? Where " +
                           " TaskCode = ? And " + 
                           " CheckType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpTaskDto.getTaskName());
        dbManager.setString(2,prpTaskDto.getCheckName());
        dbManager.setInt(3,prpTaskDto.getGradePoint());
        dbManager.setString(4,prpTaskDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpTaskDto.getTaskCode());
        dbManager.setString(6,prpTaskDto.getCheckType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpTaskBase.update() success!");
    }

    /**
     * ����������һ������
     * @param taskCode �������
     * @param checkType Ȩ�޼�������
     * @return PrpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(String taskCode,String checkType) throws Exception{
        String statement = " Select TaskCode," + 
                           " TaskName," + 
                           " CheckType," + 
                           " CheckName," + 
                           " GradePoint," + 
                           " Flag From PrpTask Where " +
                           " TaskCode = ? And " + 
                           " CheckType = ?";
        PrpTaskDto prpTaskDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,taskCode);
        dbManager.setString(2,checkType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpTaskDto = new PrpTaskDto();
            prpTaskDto.setTaskCode(dbManager.getString(resultSet,1));
            prpTaskDto.setTaskName(dbManager.getString(resultSet,2));
            prpTaskDto.setCheckType(dbManager.getString(resultSet,3));
            prpTaskDto.setCheckName(dbManager.getString(resultSet,4));
            prpTaskDto.setGradePoint(dbManager.getInt(resultSet,5));
            prpTaskDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpTaskBase.findByPrimaryKey() success!");
        return prpTaskDto;
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
        String statement = "Select TaskCode," + 
                           " TaskName," + 
                           " CheckType," + 
                           " CheckName," + 
                           " GradePoint," + 
                           " Flag From PrpTask Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpTaskDto prpTaskDto = null;
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

            prpTaskDto = new PrpTaskDto();
            prpTaskDto.setTaskCode(dbManager.getString(resultSet,1));
            prpTaskDto.setTaskName(dbManager.getString(resultSet,2));
            prpTaskDto.setCheckType(dbManager.getString(resultSet,3));
            prpTaskDto.setCheckName(dbManager.getString(resultSet,4));
            prpTaskDto.setGradePoint(dbManager.getInt(resultSet,5));
            prpTaskDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpTaskDto);
        }
        resultSet.close();
        log.info("DBPrpTaskBase.findByConditions() success!");
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
        String statement = "Delete From PrpTask Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpTaskBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpTask Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpTaskBase.getCount() success!");
        return count;
    }
}