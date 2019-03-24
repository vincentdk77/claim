package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseKindDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDclauseKind;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclausekind��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseKindActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDclauseKindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //�����¼
        dbPrpDclauseKind.insert(prpDclauseKindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param relateKindCode relatekindcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //ɾ����¼
        dbPrpDclauseKind.delete(riskCode, clauseType, kindCode, relateKindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //������ɾ����¼
        dbPrpDclauseKind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //���¼�¼
        dbPrpDclauseKind.update(prpDclauseKindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param relateKindCode relatekindcode
     * @return prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public PrpDclauseKindDto findByPrimaryKey(DBManager dbManager,String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //����DTO
        PrpDclauseKindDto prpDclauseKindDto = null;
        //��ѯ����,��ֵ��DTO
        prpDclauseKindDto = dbPrpDclauseKind.findByPrimaryKey(riskCode, clauseType, kindCode, relateKindCode);
        return prpDclauseKindDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDclauseKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDclauseKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDclauseKind.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDclauseKindDto�ļ���
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
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDclauseKind.getCount(conditions);
        return count;
    }
}
