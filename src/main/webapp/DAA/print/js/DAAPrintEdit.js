 /*****************************************************************************
 * DESC       �����մ�ӡ�ľ���ű�����ҳ��
 * AUTHOR     ��lixiang
 * CREATEDATE �� 2004-11-16
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
 function DAARegistloadForm()
  {
    
    //tdPolicyNo.innerHTML = '���յ��ţ�' +tdPolicyNo.innerHTML ;
    tdRegistNo.innerHTML = '������ţ�' + "<bean:write name='prpLregistDto' property='registNo'/>";
    
    //*****������Ϣ��PrpLregist*****
    
    tdReportType.innerHTML      = '������ʽ��' + '�绰����';
    tdReportorName.innerHTML    = '�����ˣ�'   + '6765';
    //modify by lirj update begin 040219
    //reason:��ӡ����������������¼��ʱ�޷���ʾ��ʱ���֡�
    //tdReportDate.innerHTML      = '����ʱ�䣺' + '';
    tdReportDate.innerHTML      = '����ʱ�䣺' + '2004-11-01' + ' '+'18';
    tdLinkerName.innerHTML      = '��ϵ�ˣ�'   + '54765';
    tdPhoneNumber.innerHTML     = '��ϵ�绰��' + '564765';
    //tdDamageStartDate.innerHTML = '����ʱ�䣺' + '2004-11-01';
    tdDamageStartDate.innerHTML = '����ʱ�䣺' + '2004-11-01'+ ' '+ '18';
    //modify by lirj update end 040219
    tdDamageName.innerHTML      = '����ԭ��' + '��ˮ';
    tdDamageAddress.innerHTML   = '���յص㣺' + '564756';
    
    tdFirstSiteFlag.innerHTML   = '�Ƿ��ǵ�һ�ֳ�������' + '��';
    
    //tdHandleUnit.innerHTML      = '�����ţ�' + '';
    tdHandleUnit.innerHTML      = '�����ţ�' + '42010102';
    
    tdComCode.innerHTML         = '�б���˾��' + '�����ֹ�˾�˱���';
    
    //*****���չ�ϵ�˱�PrpCinsured*****

        tdInsuredName.innerHTML        = '�������ˣ�'    + '��ɯɯ';
        tdInsuredType.innerHTML        = '�ͻ����'    + '����';
        tdInsuredAddress.innerHTML     = '��������סַ��'+ '�Ϻ��̳�·';
        tdInsuredPostCode.innerHTML    = '�������룺'    + '';
        tdInsuredLinkerName.innerHTML  = '��ϵ�ˣ�'      + '��ɯɯ';  
        tdInsuredPhoneNumber.innerHTML = '�̶��绰��'    + '87511338';
        tdInsuredMobile.innerHTML      = '�ƶ��绰��'    + '13891918919';

        tdBusinessSort.innerHTML      = '�������˵�λ���ʣ�' + '';
  
    //*****����������Ϣ��PrpCmain*****
    
    tdInsuredTerm.innerHTML   = '�������ޣ�'      + '2004/6/8-2005/6/7';
    tdSumPremium.innerHTML    = '���շѣ�'        + '4,586.41'+ 'Ԫ';
    
    tdArgueSolution.innerHTML = '��������ʽ��'  + '����';

    tdOperatorName.innerHTML   ='ǩ���ˣ�'   + 'ǮƼ';
    tdHandlerName.innerHTML    ='�����ˣ�'   + 'ǮƼ';
    tdUnderwriteName.innerHTML ='�˱��ˣ�'   + 'admin';
    tdUserName.innerHTML       ='�����ˣ�'   + 'admin';
    tdInputDate.innerHTML      ='�������ڣ�' + '2004��11��10��';
  
    //*****���⳵����ϢPrpLthirdParty*****
    tdLicenseNo.innerHTML        = '���ƺ��룺';
    tdUseYears.innerHTML         = '��ʹ�����ޣ�';
    tdLicenseColorCode.innerHTML = '���Ƶ�ɫ��';
    tdBrandName.innerHTML        = '�����ͺţ�';
    tdEngineNo.innerHTML         = '�������ţ�';
    tdFrameNo.innerHTML          = '���ܺţ�';
    tdCarKindCode.innerHTML      = '�������ࣺ';
    tdClauseType.innerHTML       = '�������������';
        
        tdLicenseNo.innerHTML       = '���ƺ��룺'         + '��A1234';
        tdUseYears.innerHTML        = '��ʹ�����ޣ�'       + '1' +'��';
                                                         
        tdLicenseColorCode.innerHTML = '���Ƶ�ɫ��'        + '��';
        tdBrandName.innerHTML        = '�����ͺţ�'        + 'ɣ����';
        tdEngineNo.innerHTML         = '�������ţ�'        + '456853';
        tdFrameNo.innerHTML          = '���ܺţ�'          + '456853';
       
        tdCarKindCode.innerHTML       = '�������ࣺ'       + '�ͳ�';
        
        tdClauseType.innerHTML        = '�������������' + '����������ʧ��������';
        
        tdVINNo.innerHTML = 'VIN�룺' + '';
        
        tdUseNatureCode.innerHTML = '����ʹ�����ʣ�'      + '��Ӫҵ��(������ͥ����)';
        tdSeatCount.innerHTML     = '�˶��ؿ� '           + '5' + ' ��' + '<br>'
                                    + ' �˶������� '      + '0.00' + ' ǧ��';
      
        tdEnrollDate.innerHTML     = '�������εǼ����ڣ�' + '2002-10-01';
        
        tdRunAreaName.innerHTML    = '������ʻ����'    + '�л����񹲺͹�����(�����۰�̨)';
        tdPurchasePrice.innerHTML  = '�³����üۣ�'      + '200,000.00' + 'Ԫ';

    //*****���ռ�ʻԱ��Ϣ��PrpLdriver*****
    tdDriverName.innerHTML         = '��ʻ��Ա���ƣ�';
    tdDrivingCarType.innerHTML     = '׼�ݳ��ͣ�';
    tdReceiveLicenseDate.innerHTML = '��ʻ֤������֤���ڣ�';
    tdDrivingLicenseNo.innerHTML   = '��ʻ֤���룺';
  
    //*****������ʻԱ��ϵ��PrpCcarDriver*****
    tdDriverName1.innerHTML        = '����ʻ��Ա������';
    tdDrivingLicenseno1.innerHTML  = '��ʻ֤���룺';
    tdAcceptLicenseDate1.innerHTML = '������֤���ڣ�';
    tdDriverName2.innerHTML        = '�Ӽ�ʻ��Ա������';
    tdDrivingLicenseno2.innerHTML  = '��ʻ֤���룺';
    tdAcceptLicenseDate2.innerHTML = '������֤���ڣ�';
        
        tdKindName1.innerHTML = '������ʧ��' + '(' + 'A' + ')';
        tdAmount1.innerHTML   = '' + '200,000.00' + '';

        tdKindName2.innerHTML = '������������' + '(' + 'B' + ')';
        tdAmount2.innerHTML   = '' + '100,000.00' + '';
        
        tdKindName3.innerHTML = '���ӳ�����Ա������' + '(' + 'D1' + ')';
        tdAmount3.innerHTML   = '' + '10,000.00' + '/��*2��';
        
        tdKindName4.innerHTML = '���ӳ�����Ա������' + '(' + 'D1' + ')';
        tdAmount4.innerHTML   = '' + '5,000.00' + '/��*3��';
        
        tdKindName5.innerHTML = '����������Լ' + '(' + 'M' + ')';
        tdAmount5.innerHTML   = '' + '' + '';

    
    //*****�ر�Լ����PrpCengage*****

      fm.Engage.value = ' �ر�Լ����' + '';
  
    fm.PheadText.value = '';
      
    //*****������Ϣ��PrpLclaim*****
  
    fm.ClaimText.value          = '����ժҪ��4565436\r\n';
    tdPheadCount.innerHTML      = '�������Ĵ�����'  + '0';
    tdClaimCount.innerHTML      = '�������մ�����'  + '0';
    tdCompensateCount.innerHTML = '��������'      + '0';
    tdSumPaid.innerHTML         = '����ܼƣ�'      + '0.00';
  }
