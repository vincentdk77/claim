package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimKind;

/**
 * ����������������Ϣ��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterClaimKindAction extends BLPrpLinterClaimKindActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimKindAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterClaimKindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterClaimKindDto prpLinterClaimKindDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterClaimKindDto[] prpLinterClaimKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimKindDto[] prpLinterClaimKindDto)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //�����¼
        for(int i=0;i<prpLinterClaimKindDto.length;i++){
        	dbPrpLinterClaimKind.insert(prpLinterClaimKindDto[i]);
        }
    }
}
