package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpXCformDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpXCform;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxcform��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXCformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXCformActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpXCformActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpXCformDto prpXCformDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpXCformDto prpXCformDto) throws Exception{
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);
        //�����¼
        dbPrpXCform.insert(prpXCformDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param fileType filetype
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String fileType) throws Exception{
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);
        //ɾ����¼
        dbPrpXCform.delete(riskCode, fileType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);
        //������ɾ����¼
        dbPrpXCform.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpXCformDto prpXCformDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpXCformDto prpXCformDto) throws Exception{
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);
        //���¼�¼
        dbPrpXCform.update(prpXCformDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param fileType filetype
     * @return prpXCformDto prpXCformDto
     * @throws Exception
     */
    public PrpXCformDto findByPrimaryKey(DBManager dbManager,String riskCode,String fileType) throws Exception{
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);
        //����DTO
        PrpXCformDto prpXCformDto = null;
        //��ѯ����,��ֵ��DTO
        prpXCformDto = dbPrpXCform.findByPrimaryKey(riskCode, fileType);
        return prpXCformDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpXCformDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpXCform.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpXCform.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpXCformDto�ļ���
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
        DBPrpXCform dbPrpXCform = new DBPrpXCform(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpXCform.getCount(conditions);
        return count;
    }
}
