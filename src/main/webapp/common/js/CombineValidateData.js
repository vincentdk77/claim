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

var CombineSchemaColumns = new Array(); //�洢�ֶνṹ������

function schemaColumn(name,desc,dataType,allowNulls)
{
    this.name = name;
    this.desc = desc;
    this.dataType = dataType;
    this.allowNulls = allowNulls;
}
function getCombineSchemaColumn()
{
    return CombineSchemaColumns;
}

//��ʼ������
var columnIndex = 0;
//��׼����
//PrpinsDB��׼У������ .DO NOT EDIT THIS


CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossClaimNo", "֤������", "VARCHAR2(20)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarName", "ũ������", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarBank", "����������", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarAccount", "�����˺�", "VARCHAR2(24)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEarNo", "�����", "VARCHAR2(16)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEstimateLoss", "�⳥���", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossLossesNumber", "�⸶����", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossKillQuantity", "��ɱ����", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossDeathQuantity", "��������", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossDamageInsured", "���ջ���", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLpropSumLoss","������","decimal(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLpropSumReject","�޳����","decimal(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckEstimateLoss", "Ԥ�����", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckEstimateFee", "Ԥ������", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckCheckSite","�鿱/���鿱�ص�","varchar(60)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckChecker1","�鿱/���鿱��1","char(20)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckCheckDate","�鿱/���鿱����","DATE",false);

CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageCode","����ԭ�����","char(4)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageName","����ԭ��˵��","varchar(100,0)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossName","������","varchar(120,0)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossesNumber", "�⸶����", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageInsured", "���ջ���", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDeathQuantity", "��������", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimKillQuantity", "��ɱ����", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindName","�ձ�����","CHAR(80)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindCode","�ձ����","CHAR(7)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrency","�ұ�","CHAR(3)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrencyName","�ұ�����","CHAR(80)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossSumClaim","Ԥ�Ƹ������","DECIMAL(14,2)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossInputDate","��������","DATE",true); 


CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarId_Card", "֤������", "VARCHAR2(20)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarName", "ũ������", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarBank", "����������", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarAccount", "�����˺�", "VARCHAR2(24)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEarNo", "�����", "VARCHAR2(16)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEstimateLoss", "�⳥���", "DECIMAL(14,2)",true);