<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>���� �����ȸ</title>

<linkrel="stylesheet"href="/css/admin.css"type="text/css">

<scripttype="text/javascript">

function fncGetUserList() {

document.detailForm.submit();

}

</script>

</head>

<bodybgcolor="#ffffff"text="#000000">

<divstyle="width: 98%; margin-left: 10px;">

<formname="detailForm"action="/listUser.do"method="post">

<tablewidth="100%"height="37"border="0"cellpadding="0"cellspacing="0">

<tr>

<tdwidth="15"height="37"><imgsrc="/images/ct_ttl_img01.gif"width="15"height="37"></td>

<tdbackground="/images/ct_ttl_img02.gif"width="100%"style="padding-left: 10px;">

<tablewidth="100%"border="0"cellspacing="0"cellpadding="0">

<tr>

<tdwidth="93%"class="ct_ttl01">���� �����ȸ</td>

</tr>

</table>

</td>

<tdwidth="12"height="37"><imgsrc="/images/ct_ttl_img03.gif"width="12"height="37"></td>

</tr>

</table>



<tablewidth="100%"border="0"cellspacing="0"cellpadding="0"style="margin-top: 10px;">

<tr>

<tdcolspan="11">��ü 0 �Ǽ�, ���� 1 ������</td>

</tr>

<tr>

<tdclass="ct_list_b"width="100">No</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b"width="150">ȸ��ID</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b"width="150">ȸ����</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b">��ȭ��ȣ</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b">�����Ȳ</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b">��������</td>

</tr>

<tr>

<tdcolspan="11"bgcolor="808285"height="1"></td>

</tr>





</table>



<tablewidth="100%"border="0"cellspacing="0"cellpadding="0"style="margin-top: 10px;">

<tr>

<tdalign="center">



</td>

</tr>

</table>

<!-- ������ Navigator �� -->

</form>

</div>

</body>
</html>