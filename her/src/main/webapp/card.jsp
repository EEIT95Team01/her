<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="" />

<title>Product</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<h3>Welcome, </h3>

<h3>Card Table</h3>

<form action="/her/model/CardServlet.controller" method="get">
<table>
	<tr>
		<td>卡片編號  </td>
		<td><input type="text" name="cardNo" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片名稱 </td>
		<td><input type="text" name="cardName" value=""></td>
		<td></td>
	</tr>

	<tr>
		<td>卡片價格 </td>
		<td><input type="text" name="cardPrice" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片成本</td>
		<td><input type="text" name="cardCost" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片毛利</td>
		<td><input type="text" name="cardGrossProfit" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片廠商</td>
		<td><input type="text" name="cardManufacturer" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片字數</td>
		<td><input type="text" name="cardMaxWordCount" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片圖片</td>
		<td><input type="text" name="cardImage" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>卡片庫存</td>
		<td><input type="text" name="cardStock" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>瀏覽次數</td>
		<td><input type="text" name="cardViewCount" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>銷售數量</td>
		<td><input type="text" name="cardSalesCount" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>上/下架狀態</td>
		<td>
		<input type="radio" name="cardStatus" value="true">上架
		<input type="radio" name="cardStatus" value="false">下架
		</td>
		<td></td>
	</tr>
	
	
	
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
			<input type="submit" name="prodaction" value="Update">
		</td>
		<td>
			<input type="submit" name="prodaction" value="Delete">
			<input type="submit" name="prodaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>
</body>
</html>