package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpusergrade�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUserGradeBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpUserGradeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpUserGradeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(PrpUserGradeDto prpUserGradeDto) throws Exception{
        String statement = " Insert Into PrpUserGrade(" + 
                           " UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpUserGradeDto.getUserCode());
        dbManager.setString(2,prpUserGradeDto.getGroupCode());
        dbManager.setString(3,prpUserGradeDto.getTaskCode());
        dbManager.setString(4,prpUserGradeDto.getCheckCode());
        dbManager.setString(5,prpUserGradeDto.getValue());
        dbManager.setString(6,prpUserGradeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUserGradeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpUserGradeDto prpUserGradeDto = (PrpUserGradeDto)i.next();
            insert(prpUserGradeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param userCode usercode
     * @param groupCode groupcode
     * @param taskCode taskcode
     * @param checkCode checkcode
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        String statement = " Delete From PrpUserGrade Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpUserGradeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(PrpUserGradeDto prpUserGradeDto) throws Exception{
        String statement = " Update PrpUserGrade Set Value = ?," + 
                           " Flag = ? Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpUserGradeDto.getValue());
        dbManager.setString(2,prpUserGradeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpUserGradeDto.getUserCode());
        dbManager.setString(4,prpUserGradeDto.getGroupCode());
        dbManager.setString(5,prpUserGradeDto.getTaskCode());
        dbManager.setString(6,prpUserGradeDto.getCheckCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUserGradeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param userCode usercode
     * @param groupCode groupcode
     * @param taskCode taskcode
     * @param checkCode checkcode
     * @return PrpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        String statement = " Select UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " Flag From PrpUserGrade Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        PrpUserGradeDto prpUserGradeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpUserGradeDto = new PrpUserGradeDto();
            prpUserGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpUserGradeDto.setGroupCode(dbManager.getString(resultSet,2));
            prpUserGradeDto.setTaskCode(dbManager.getString(resultSet,3));
            prpUserGradeDto.setCheckCode(dbManager.getString(resultSet,4));
            prpUserGradeDto.setValue(dbManager.getString(resultSet,5));
            prpUserGradeDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpUserGradeBase.findByPrimaryKey() success!");
        return prpUserGradeDto;
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
        String statement = "Select UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " Flag From PrpUserGrade Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpUserGradeDto prpUserGradeDto = null;
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

            prpUserGradeDto = new PrpUserGradeDto();
            prpUserGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpUserGradeDto.setGroupCode(dbManager.getString(resultSet,2));
            prpUserGradeDto.setTaskCode(dbManager.getString(resultSet,3));
            prpUserGradeDto.setCheckCode(dbManager.getString(resultSet,4));
            prpUserGradeDto.setValue(dbManager.getString(resultSet,5));
            prpUserGradeDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpUserGradeDto);
        }
        resultSet.close();
        log.info("DBPrpUserGradeBase.findByConditions() success!");
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
        String statement = "Delete From PrpUserGrade Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpUserGradeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpUserGrade Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpUserGradeBase.getCount() success!");
        return count;
    }
}
