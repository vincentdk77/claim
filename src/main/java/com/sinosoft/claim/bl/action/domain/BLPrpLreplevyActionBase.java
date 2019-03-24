package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLreplevy;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLreplevy-Ȩ��ת�ü�׷����Ϣ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLreplevyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLreplevyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLreplevyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLreplevyDto prpLreplevyDto) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //�����¼
        dbPrpLreplevy.insert(prpLreplevyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param times ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int times) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //ɾ����¼
        dbPrpLreplevy.delete(claimNo, times);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //������ɾ����¼
        dbPrpLreplevy.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLreplevyDto prpLreplevyDto) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //���¼�¼
        dbPrpLreplevy.update(prpLreplevyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param times ����
     * @return prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public PrpLreplevyDto findByPrimaryKey(DBManager dbManager,String claimNo,int times) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //����DTO
        PrpLreplevyDto prpLreplevyDto = null;
        //��ѯ����,��ֵ��DTO
        prpLreplevyDto = dbPrpLreplevy.findByPrimaryKey(claimNo, times);
        return prpLreplevyDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreplevy.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLreplevy.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLreplevyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLreplevy.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreplevy.getCount(conditions);
        return count;
    }
}
