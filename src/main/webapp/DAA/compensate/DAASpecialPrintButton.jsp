<%--
****************************************************************************
* DESC       �������ⰸ�������ӡ��ťҳ��
* Author     : wangli
* CREATEDATE ��2005-04-22
* MODIFYLIST ��   Name       Date            Reason/Contents
*
****************************************************************************/
--%>

  <script language="VBScript">
    // ���ⵯ����ȫ������˵����Internetѡ��=����ȫ=�������ε�վ�� 
    // 1.����վ����������վ�㣬
    // 2.�Զ��弶���� ���� ��û�б��Ϊ��ȫ��ActiveX�ؼ����г�ʼ���ͽű�����    

    dim hkey_root,hkey_path,hkey_key
    hkey_root="HKEY_CURRENT_USER"
    hkey_path="\Software\Microsoft\Internet Explorer\PageSetup"
    
    dim oldheader,oldfooter     
    
    '//������ҳ��ӡ��ҳüҳ�ţ���������
    function pagesetup_set(header,footer)
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"          
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,header
        hkey_key="\footer"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,footer
        
        
        hkey_key="\margin_left" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.73"
        hkey_key="\margin_right" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.70"
        hkey_key="\margin_top" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"1.1"
        hkey_key="\margin_bottom" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"1"
        
    end function
    '//������ҳ��ӡ��ҳüҳ��,��������ΪĬ��ֵ
    function pagesetup_default()
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"    
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&w&bҳ�룬&p/&P"
        hkey_key="\footer"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&u&b&d"
        
        hkey_key="\margin_left" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"     '(��Ӧ 19.05����)
        hkey_key="\margin_right" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
        hkey_key="\margin_top" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
        hkey_key="\margin_bottom" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"        
    end function
    
    '//��ʾҳ������
    function pagesetup_get()
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"    
        oldheader=RegWsh.RegRead(hkey_root+hkey_path+hkey_key)
        hkey_key="\footer"
        oldfooter=RegWsh.RegRead(hkey_root+hkey_path+hkey_key)
        
        'hkey_key="\margin_left" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_right" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_top" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_bottom" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        '
        'msgbox (message)
    end function    
    
    function printPage()
		pagesetup_get()         '��ȡ��ֵ
		header=""
		footer=""		
		pagesetup_get()
		pagesetup_set header, footer
		divButton.style.display = "none"
    	        window.print()
		pagesetup_set oldheader, oldfooter            '�ָ�����
    end function
</script>  

      <script LANGUAGE="JavaScript">
     <!--
      /**
       *@description ���س�ʼҳ��
       *@param       ��
       *@return      ͨ������true,���򷵻�false
       */
      
      function specialBack(){
      var url = "/claim/wfLogQuery.do?nodeType=speci&status=0";
      //alert(url);
      document.location = url;
      return true; 
      }
     //--> 
     </script>
  
  
  
<div align="center" id="divButton" style="display:">
<p>
  <table cellpadding="0" cellspacing="0" width="100%" style="display:">
    <tr>
      <td class=button style="width:50%" align="center">
        <input class="button" type="button"  name="buttonPrint" value=" �� ӡ "  onclick="return printPage()">
      </td>
      <td class=button style="width:50%" align="center">
        <input class="button" type="button"  name="buttonClose" value=" �� �� "  onclick="return specialBack();">
      </td>
    </tr>
  </table>
</p>
</div>
