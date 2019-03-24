package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrade��λ���������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGradeBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpGradeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpGradeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void insert(PrpGradeDto prpGradeDto) throws Exception{
        String statement = " Insert Into PrpGrade(" + 
                           " GradeCode," + 
                           " GradeName," + 
                           " Power," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGradeDto.getGradeCode());
        dbManager.setString(2,prpGradeDto.getGradeName());
        dbManager.setString(3,prpGradeDto.getPower());
        dbManager.setString(4,prpGradeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGradeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGradeDto prpGradeDto = (PrpGradeDto)i.next();
            insert(prpGradeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param gradeCode ��λ����
     * @throws Exception
     */
    public void delete(String gradeCode) throws Exception{
        String statement = " Delete From PrpGrade Where " +
                           " GradeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,gradeCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGradeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void update(PrpGradeDto prpGradeDto) throws Exception{
        String statement = " Update PrpGrade Set GradeName = ?," + 
                           " Power = ?," + 
                           " Flag = ? Where " +
                           " GradeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpGradeDto.getGradeName());
        dbManager.setString(2,prpGradeDto.getPower());
        dbManager.setString(3,prpGradeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,prpGradeDto.getGradeCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGradeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param gradeCode ��λ����
     * @return PrpGradeDto
     * @throws Exception
     */
    public PrpGradeDto findByPrimaryKey(String gradeCode) throws Exception{
        String statement = " Select GradeCode," + 
                           " GradeName," + 
                           " Power," + 
                           " Flag From PrpGrade Where " +
                           " GradeCode = ?";
        PrpGradeDto prpGradeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,gradeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGradeDto = new PrpGradeDto();
            prpGradeDto.setGradeCode(dbManager.getString(resultSet,1));
            prpGradeDto.setGradeName(dbManager.getString(resultSet,2));
            prpGradeDto.setPower(dbManager.getString(resultSet,3));
            prpGradeDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpGradeBase.findByPrimaryKey() success!");
        return prpGradeDto;
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
        String statement = "Select GradeCode," + 
                           " GradeName," + 
                           " Power," + 
                           " Flag From PrpGrade Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGradeDto prpGradeDto = null;
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

            prpGradeDto = new PrpGradeDto();
            prpGradeDto.setGradeCode(dbManager.getString(resultSet,1));
            prpGradeDto.setGradeName(dbManager.getString(resultSet,2));
            prpGradeDto.setPower(dbManager.getString(resultSet,3));
            prpGradeDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpGradeDto);
        }
        resultSet.close();
        log.info("DBPrpGradeBase.findByConditions() success!");
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
        String statement = "Delete From PrpGrade Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGradeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpGrade Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGradeBase.getCount() success!");
        return count;
    }
}
