//
//Generate By
//
//JTools (Version 1.0.0.1)
//(C) Copyright Zhouxianli 2003.  All rights reserved.
//Visit http://www.jtools.org
//
//Any qustion mail zhouxianli@126.com
//Generate at 2003-10-16 10:37:55
//
//

/**
 * ��������У��
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author zhouxianli
 * @version 1.0
 */
/**
    �ṹΪ �ֶ������ֶ����������ͣ��Ƿ�����Ϊ��
           4��Ǳ����
 */

var schemaColumns = new Array(); //�洢�ֶνṹ������

function schemaColumn(name,desc,dataType,allowNulls)
{
    this.name = name;
    this.desc = desc;
    this.dataType = dataType;
    this.allowNulls = allowNulls;
}

function getSchemaColumn(name)
{
    for(var i=0;i<schemaColumns.length;i++)
    {
        if(name==schemaColumns[i].name)
            return schemaColumns[i];
    }
    return null;
}

//��ʼ������
var columnIndex = 0;
//��׼����
//PrpinsDB��׼У������ .DO NOT EDIT THIS


schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageCode","����ԭ�����","char(4)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageName","����ԭ��˵��","varchar(100,0)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossName","������","varchar(120,0)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossesNumber", "�⸶����", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageInsured", "���ջ���", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDeathQuantity", "��������", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimKillQuantity", "��ɱ����", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindName","�ձ�����","CHAR(80)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindCode","�ձ����","CHAR(7)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrency","�ұ�","CHAR(3)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrencyName","�ұ�����","CHAR(80)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossSumClaim","Ԥ�Ƹ������","DECIMAL(14,2)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossInputDate","��������","DATE",true); 


schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarId_Card", "֤������", "VARCHAR2(20)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarName", "ũ������", "VARCHAR2(50)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarBank", "����������", "VARCHAR2(50)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarAccount", "�����˺�", "VARCHAR2(24)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEarNo", "�����", "VARCHAR2(16)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEstimateLoss", "�⳥���", "DECIMAL(14,2)",true);