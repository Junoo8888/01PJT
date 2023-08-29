<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>구매 목록조회</title>

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

<tdwidth="93%"class="ct_ttl01">구매 목록조회</td>

</tr>

</table>

</td>

<tdwidth="12"height="37"><imgsrc="/images/ct_ttl_img03.gif"width="12"height="37"></td>

</tr>

</table>



<tablewidth="100%"border="0"cellspacing="0"cellpadding="0"style="margin-top: 10px;">

<tr>

<tdcolspan="11">전체 0 건수, 현재 1 페이지</td>

</tr>

<tr>

<tdclass="ct_list_b"width="100">No</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b"width="150">회원ID</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b"width="150">회원명</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b">전화번호</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b">배송현황</td>

<tdclass="ct_line02"></td>

<tdclass="ct_list_b">정보수정</td>

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

<!-- 페이지 Navigator 끝 -->

</form>

</div>

</body>
</html>