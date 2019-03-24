package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDareaGroupDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDareaGroup;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdareagroup�������������������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDareaGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpDareaGroupActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

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
     * @param comCode ���ڴ�����Ļ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //ɾ����¼
        dbPrpDareaGroup.delete(comCode);
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
     * @param comCode ���ڴ�����Ļ���
     * @return prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public PrpDareaGroupDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //����DTO
        PrpDareaGroupDto prpDareaGroupDto = null;
        //��ѯ����,��ֵ��DTO
        prpDareaGroupDto = dbPrpDareaGroup.findByPrimaryKey(comCode);
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

        rowCount = dbPrpDareaGroup.getCount(conditions);
        collection = dbPrpDareaGroup.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDareaGroup.getCount(conditions);
        return count;
    }
}
