package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDstatiTypeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDstatiType;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdstatitype����ͳ�Ʒ�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDstatiTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDstatiTypeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDstatiTypeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDstatiTypeDto prpDstatiTypeDto) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //�����¼
        dbPrpDstatiType.insert(prpDstatiTypeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ����
     * @param kindCode �ձ�
     * @param belongType ͳ������
     * @param validDate ��Ч����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //ɾ����¼
        dbPrpDstatiType.delete(riskCode, kindCode, belongType, validDate);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //������ɾ����¼
        dbPrpDstatiType.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDstatiTypeDto prpDstatiTypeDto) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //���¼�¼
        dbPrpDstatiType.update(prpDstatiTypeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ����
     * @param kindCode �ձ�
     * @param belongType ͳ������
     * @param validDate ��Ч����
     * @return prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public PrpDstatiTypeDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //����DTO
        PrpDstatiTypeDto prpDstatiTypeDto = null;
        //��ѯ����,��ֵ��DTO
        prpDstatiTypeDto = dbPrpDstatiType.findByPrimaryKey(riskCode, kindCode, belongType, validDate);
        return prpDstatiTypeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDstatiTypeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDstatiType.getCount(conditions);
        collection = dbPrpDstatiType.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDstatiType.getCount(conditions);
        return count;
    }
}
