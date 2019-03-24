package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDTypeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpIDType;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidtype�ӿڴ������ͱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDTypeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpIDTypeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpIDTypeDto prpIDTypeDto) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //�����¼
        dbPrpIDType.insert(prpIDTypeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType �ӿڴ�������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //ɾ����¼
        dbPrpIDType.delete(codeType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //������ɾ����¼
        dbPrpIDType.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpIDTypeDto prpIDTypeDto) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //���¼�¼
        dbPrpIDType.update(prpIDTypeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType �ӿڴ�������
     * @return prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public PrpIDTypeDto findByPrimaryKey(DBManager dbManager,String codeType) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //����DTO
        PrpIDTypeDto prpIDTypeDto = null;
        //��ѯ����,��ֵ��DTO
        prpIDTypeDto = dbPrpIDType.findByPrimaryKey(codeType);
        return prpIDTypeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpIDTypeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpIDType.getCount(conditions);
        collection = dbPrpIDType.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpIDType.getCount(conditions);
        return count;
    }
}
