package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclassDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclass�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclassBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDclassBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDclassBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void insert(PrpDclassDto prpDclassDto) throws Exception{
        String statement = " Insert Into PrpDclass(" + 
                           " ClassCode," + 
                           " ClassName," + 
                           " ClassEName," + 
                           " AccCode," + 
                           " NewClassCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDclassDto.getClassCode());
        dbManager.setString(2,prpDclassDto.getClassName());
        dbManager.setString(3,prpDclassDto.getClassEName());
        dbManager.setString(4,prpDclassDto.getAccCode());
        dbManager.setString(5,prpDclassDto.getNewClassCode());
        dbManager.setString(6,prpDclassDto.getValidStatus());
        dbManager.setString(7,prpDclassDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclassBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDclassDto prpDclassDto = (PrpDclassDto)i.next();
            insert(prpDclassDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param classCode classcode
     * @throws Exception
     */
    public void delete(String classCode) throws Exception{
        String statement = " Delete From PrpDclass Where " +
                           " ClassCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,classCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDclassBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void update(PrpDclassDto prpDclassDto) throws Exception{
        String statement = " Update PrpDclass Set ClassName = ?," + 
                           " ClassEName = ?," + 
                           " AccCode = ?," + 
                           " NewClassCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ClassCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDclassDto.getClassName());
        dbManager.setString(2,prpDclassDto.getClassEName());
        dbManager.setString(3,prpDclassDto.getAccCode());
        dbManager.setString(4,prpDclassDto.getNewClassCode());
        dbManager.setString(5,prpDclassDto.getValidStatus());
        dbManager.setString(6,prpDclassDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpDclassDto.getClassCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclassBase.update() success!");
    }

    /**
     * ����������һ������
     * @param classCode classcode
     * @return PrpDclassDto
     * @throws Exception
     */
    public PrpDclassDto findByPrimaryKey(String classCode) throws Exception{
        String statement = " Select ClassCode," + 
                           " ClassName," + 
                           " ClassEName," + 
                           " AccCode," + 
                           " NewClassCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclass Where " +
                           " ClassCode = ?";
        PrpDclassDto prpDclassDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,classCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDclassDto = new PrpDclassDto();
            prpDclassDto.setClassCode(dbManager.getString(resultSet,1));
            prpDclassDto.setClassName(dbManager.getString(resultSet,2));
            prpDclassDto.setClassEName(dbManager.getString(resultSet,3));
            prpDclassDto.setAccCode(dbManager.getString(resultSet,4));
            prpDclassDto.setNewClassCode(dbManager.getString(resultSet,5));
            prpDclassDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDclassDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDclassBase.findByPrimaryKey() success!");
        return prpDclassDto;
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
        String statement = "Select ClassCode," + 
                           " ClassName," + 
                           " ClassEName," + 
                           " AccCode," + 
                           " NewClassCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclass Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDclassDto prpDclassDto = null;
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

            prpDclassDto = new PrpDclassDto();
            prpDclassDto.setClassCode(dbManager.getString(resultSet,1));
            prpDclassDto.setClassName(dbManager.getString(resultSet,2));
            prpDclassDto.setClassEName(dbManager.getString(resultSet,3));
            prpDclassDto.setAccCode(dbManager.getString(resultSet,4));
            prpDclassDto.setNewClassCode(dbManager.getString(resultSet,5));
            prpDclassDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDclassDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDclassDto);
        }
        resultSet.close();
        log.info("DBPrpDclassBase.findByConditions() success!");
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
        String statement = "Delete From PrpDclass Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDclassBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDclass Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDclassBase.getCount() success!");
        return count;
    }
}
