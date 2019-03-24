package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDidentifierDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDidentifier;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdidentifier��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDidentifierActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDidentifierDto prpDidentifierDto) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //�����¼
        dbPrpDidentifier.insert(prpDidentifierDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param identifierCode identifiercode
     * @param portCode portcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String identifierCode,String portCode) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //ɾ����¼
        dbPrpDidentifier.delete(identifierCode, portCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //������ɾ����¼
        dbPrpDidentifier.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDidentifierDto prpDidentifierDto) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //���¼�¼
        dbPrpDidentifier.update(prpDidentifierDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param identifierCode identifiercode
     * @param portCode portcode
     * @return prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public PrpDidentifierDto findByPrimaryKey(DBManager dbManager,String identifierCode,String portCode) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //����DTO
        PrpDidentifierDto prpDidentifierDto = null;
        //��ѯ����,��ֵ��DTO
        prpDidentifierDto = dbPrpDidentifier.findByPrimaryKey(identifierCode, portCode);
        return prpDidentifierDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDidentifierDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDidentifier.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDidentifier.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDidentifierDto�ļ���
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
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDidentifier.getCount(conditions);
        return count;
    }
}
