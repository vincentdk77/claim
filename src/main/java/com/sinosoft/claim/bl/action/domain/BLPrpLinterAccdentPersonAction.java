package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterAccdentPerson;

/**
 * ��������ӿ��¹�����Ϣ��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterAccdentPersonAction extends BLPrpLinterAccdentPersonActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterAccdentPersonAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterAccdentPersonAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterAccdentPersonDto prpLinterAccdentPersonDto,String mode)
            throws Exception{
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterAccdentPersonDto[] prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //�����¼
        for(int i=0;i<prpLinterAccdentPersonDto.length;i++){
        	dbPrpLinterAccdentPerson.insert(prpLinterAccdentPersonDto[i]);
        }
    }
}
