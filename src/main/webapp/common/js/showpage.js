function showPage(img,spanID){
  if(spanID.style.display=="")
  {
   //�ر�
    spanID.style.display="none";
    img.src="/claim/images/butCollapseBlue.gif";
  }
  else
  {
   //չ��
    spanID.style.display="";
    img.src="/claim/images/butExpandBlue.gif";
  }
}




//ѡ�м����鴥��ʱ��
function setCheckFlag(index)
{
  if(fm.check.length == null)
      {
        if(fm.check.checked)
        {
        fm.CheckFlag.value = "Y";
        }else{
        fm.CheckFlag.value = "N";
        }
      }else{
  if(fm.check[index].checked == true)
  {
    fm.CheckFlag[index].value = "Y";
  }
  else if(fm.check[index].checked == false)
  {
    fm.CheckFlag[index].value = "N" ;
  }
}
}

//ɾ�����㴥��ʱ�亯��
function deleteLS()
{
  fm.deleteFlag.value = '1';
  doing.style.visibility="visible";
  fm.deleteButton.disabled = true;	
  fm.submit();
}    


