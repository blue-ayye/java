<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Newspaper Details</h1>
<h2>${ValidateMessage}</h2>
<hr>
<div>
<c:forEach items = "${ListOfNewspapers}" var = "newspaperObj">
<tr>
<td>${newspaperObj.newspaperName }</td><br>
<td>${newspaperObj.price }</td><br>
<td>${newspaperObj.language }</td><br>
<td>${newspaperObj.noOfPages }</td><br>

<hr>
</tr>
</c:forEach>
</div>
</body>
</html>