package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclause�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclauseBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDclauseBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDclauseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void insert(PrpDclauseDto prpDclauseDto) throws Exception{
        String statement = " Insert Into PrpDclause(" + 
                           " ClauseCode," + 
                           " ClauseName," + 
                           " Language," + 
                           " TitleFlag," + 
                           " LineNo," + 
                           " Context," + 
                           " NewClauseCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDclauseDto.getClauseCode());
        dbManager.setString(2,prpDclauseDto.getClauseName());
        dbManager.setString(3,prpDclauseDto.getLanguage());
        dbManager.setString(4,prpDclauseDto.getTitleFlag());
        dbManager.setInt(5,prpDclauseDto.getLineNo());
        dbManager.setString(6,prpDclauseDto.getContext());
        dbManager.setString(7,prpDclauseDto.getNewClauseCode());
        dbManager.setString(8,prpDclauseDto.getValidStatus());
        dbManager.setString(9,prpDclauseDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDclauseDto prpDclauseDto = (PrpDclauseDto)i.next();
            insert(prpDclauseDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param clauseCode clausecode
     * @param lineNo lineno
     * @throws Exception
     */
    public void delete(String clauseCode,int lineNo) throws Exception{
        String statement = " Delete From PrpDclause Where " +
                           " ClauseCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,clauseCode);
        dbManager.setInt(2,lineNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDclauseBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void update(PrpDclauseDto prpDclauseDto) throws Exception{
        String statement = " Update PrpDclause Set ClauseName = ?," + 
                           " Language = ?," + 
                           " TitleFlag = ?," + 
                           " Context = ?," + 
                           " NewClauseCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ClauseCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDclauseDto.getClauseName());
        dbManager.setString(2,prpDclauseDto.getLanguage());
        dbManager.setString(3,prpDclauseDto.getTitleFlag());
        dbManager.setString(4,prpDclauseDto.getContext());
        dbManager.setString(5,prpDclauseDto.getNewClauseCode());
        dbManager.setString(6,prpDclauseDto.getValidStatus());
        dbManager.setString(7,prpDclauseDto.getFlag());
        //���������ֶ�;
        dbManager.setString(8,prpDclauseDto.getClauseCode());
        dbManager.setInt(9,prpDclauseDto.getLineNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseBase.update() success!");
    }

    /**
     * ����������һ������
     * @param clauseCode clausecode
     * @param lineNo lineno
     * @return PrpDclauseDto
     * @throws Exception
     */
    public PrpDclauseDto findByPrimaryKey(String clauseCode,int lineNo) throws Exception{
        String statement = " Select ClauseCode," + 
                           " ClauseName," + 
                           " Language," + 
                           " TitleFlag," + 
                           " LineNo," + 
                           " Context," + 
                           " NewClauseCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclause Where " +
                           " ClauseCode = ? And " + 
                           " LineNo = ?";
        PrpDclauseDto prpDclauseDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,clauseCode);
        dbManager.setInt(2,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDclauseDto = new PrpDclauseDto();
            prpDclauseDto.setClauseCode(dbManager.getString(resultSet,1));
            prpDclauseDto.setClauseName(dbManager.getString(resultSet,2));
            prpDclauseDto.setLanguage(dbManager.getString(resultSet,3));
            prpDclauseDto.setTitleFlag(dbManager.getString(resultSet,4));
            prpDclauseDto.setLineNo(dbManager.getInt(resultSet,5));
            prpDclauseDto.setContext(dbManager.getString(resultSet,6));
            prpDclauseDto.setNewClauseCode(dbManager.getString(resultSet,7));
            prpDclauseDto.setValidStatus(dbManager.getString(resultSet,8));
            prpDclauseDto.setFlag(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        log.info("DBPrpDclauseBase.findByPrimaryKey() success!");
        return prpDclauseDto;
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
        String statement = "Select ClauseCode," + 
                           " ClauseName," + 
                           " Language," + 
                           " TitleFlag," + 
                           " LineNo," + 
                           " Context," + 
                           " NewClauseCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclause Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDclauseDto prpDclauseDto = null;
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

            prpDclauseDto = new PrpDclauseDto();
            prpDclauseDto.setClauseCode(dbManager.getString(resultSet,1));
            prpDclauseDto.setClauseName(dbManager.getString(resultSet,2));
            prpDclauseDto.setLanguage(dbManager.getString(resultSet,3));
            prpDclauseDto.setTitleFlag(dbManager.getString(resultSet,4));
            prpDclauseDto.setLineNo(dbManager.getInt(resultSet,5));
            prpDclauseDto.setContext(dbManager.getString(resultSet,6));
            prpDclauseDto.setNewClauseCode(dbManager.getString(resultSet,7));
            prpDclauseDto.setValidStatus(dbManager.getString(resultSet,8));
            prpDclauseDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpDclauseDto);
        }
        resultSet.close();
        log.info("DBPrpDclauseBase.findByConditions() success!");
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
        String statement = "Delete From PrpDclause Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDclauseBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDclause Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDclauseBase.getCount() success!");
        return count;
    }
}
