package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDareaGroupDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDareaGroup;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdareagroup��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDareaGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpDareaGroupActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDareaGroupActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //�����¼
        dbPrpDareaGroup.insert(prpDareaGroupDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param comCode comcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String comCode) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //ɾ����¼
        dbPrpDareaGroup.delete(riskCode, comCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //������ɾ����¼
        dbPrpDareaGroup.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //���¼�¼
        dbPrpDareaGroup.update(prpDareaGroupDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param comCode comcode
     * @return prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public PrpDareaGroupDto findByPrimaryKey(DBManager dbManager,String riskCode,String comCode) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //����DTO
        PrpDareaGroupDto prpDareaGroupDto = null;
        //��ѯ����,��ֵ��DTO
        prpDareaGroupDto = dbPrpDareaGroup.findByPrimaryKey(riskCode, comCode);
        return prpDareaGroupDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDareaGroupDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDareaGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDareaGroup.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDareaGroupDto�ļ���
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
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDareaGroup.getCount(conditions);
        return count;
    }
}
