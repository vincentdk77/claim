package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaUser-��ϯԱ��Ϣ���ҵ�������չ��<br>
 * ������ 2005-06-22 14:56:46.226<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserAction extends BLEdaUserActionBase{
    private static Log logger = LogFactory.getLog(BLEdaUserAction.class);

    /**
     * ���캯��
     */
    public BLEdaUserAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param edaUserDto edaUserDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdaUserDto edaUserDto,String mode) throws Exception{
    }
}
