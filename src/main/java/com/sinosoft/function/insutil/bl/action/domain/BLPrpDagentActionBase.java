package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDagentDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDagent;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagent��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDagentActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDagentDto prpDagentDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDagentDto prpDagentDto) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //�����¼
        dbPrpDagent.insert(prpDagentDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param agentCode agentcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String agentCode) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //ɾ����¼
        dbPrpDagent.delete(agentCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //������ɾ����¼
        dbPrpDagent.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDagentDto prpDagentDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDagentDto prpDagentDto) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //���¼�¼
        dbPrpDagent.update(prpDagentDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param agentCode agentcode
     * @return prpDagentDto prpDagentDto
     * @throws Exception
     */
    public PrpDagentDto findByPrimaryKey(DBManager dbManager,String agentCode) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //����DTO
        PrpDagentDto prpDagentDto = null;
        //��ѯ����,��ֵ��DTO
        prpDagentDto = dbPrpDagent.findByPrimaryKey(agentCode);
        return prpDagentDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDagentDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDagent.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDagent.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDagentDto�ļ���
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
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDagent.getCount(conditions);
        return count;
    }
}
