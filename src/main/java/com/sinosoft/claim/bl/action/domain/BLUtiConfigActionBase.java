package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiConfigDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����uticonfig���������ݱ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiConfigActionBase{
    private static Log log = LogFactory.getLog(BLUtiConfigActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiConfigActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiConfigDto utiConfigDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiConfigDto utiConfigDto) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //�����¼
        dbUtiConfig.insert(utiConfigDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param cfgid cfgid
     * @param cfgoth cfgoth
     * @throws Exception
     */
    public void delete(DBManager dbManager,String cfgid,String cfgoth) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //ɾ����¼
        dbUtiConfig.delete(cfgid, cfgoth);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //������ɾ����¼
        dbUtiConfig.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiConfigDto utiConfigDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiConfigDto utiConfigDto) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //���¼�¼
        dbUtiConfig.update(utiConfigDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param cfgid cfgid
     * @param cfgoth cfgoth
     * @return utiConfigDto utiConfigDto
     * @throws Exception
     */
    public UtiConfigDto findByPrimaryKey(DBManager dbManager,String cfgid,String cfgoth) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //����DTO
        UtiConfigDto utiConfigDto = null;
        //��ѯ����,��ֵ��DTO
        utiConfigDto = dbUtiConfig.findByPrimaryKey(cfgid, cfgoth);
        return utiConfigDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiConfigDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiConfig.getCount(conditions);
        collection = dbUtiConfig.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiConfig.getCount(conditions);
        return count;
    }
}
