package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDclause;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclause��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDclauseActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDclauseDto prpDclauseDto) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //�����¼
        dbPrpDclause.insert(prpDclauseDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param clauseCode clausecode
     * @param lineNo lineno
     * @throws Exception
     */
    public void delete(DBManager dbManager,String clauseCode,int lineNo) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //ɾ����¼
        dbPrpDclause.delete(clauseCode, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //������ɾ����¼
        dbPrpDclause.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDclauseDto prpDclauseDto) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //���¼�¼
        dbPrpDclause.update(prpDclauseDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param clauseCode clausecode
     * @param lineNo lineno
     * @return prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public PrpDclauseDto findByPrimaryKey(DBManager dbManager,String clauseCode,int lineNo) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //����DTO
        PrpDclauseDto prpDclauseDto = null;
        //��ѯ����,��ֵ��DTO
        prpDclauseDto = dbPrpDclause.findByPrimaryKey(clauseCode, lineNo);
        return prpDclauseDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDclauseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDclause.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDclause.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDclauseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDclause.getCount(conditions);
        return count;
    }
}
