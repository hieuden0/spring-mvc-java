<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Spring MVC Hello World</title>
</head>

<body>
<h2>All Employees in System</h2>
<a href="/">Back </a>
<table border="1">
    <tr>
        <th>sale_id</th>
        <th>DOLLARS</th>
        <th>Year</th>
        <th>Month</th>
        <th>Quarter</th>
        <th>CLASS</th>
        <th>INVENTORY</th>
        <th>CITY</th>
        <th>COUNTRY</th>
    </tr>
    <c:forEach items="${saleList}" var="sale">
        <tr>
            <td>${sale.sale_id}</td>
            <td>${sale.DOLLARS}</td>
            <td>${sale.timeVO.YEAR}</td>
            <td>${sale.timeVO.QUARTER}</td>
            <td>${sale.timeVO.MONTH}</td>
            <td>${sale.productVO.CLASS}</td>
            <td>${sale.productVO.INVENTORY}</td>
            <td>${sale.locationVO.CITY}</td>
            <td>${sale.locationVO.COUNTRY}</td>
        </tr>
    </c:forEach>
</table>
<input type="Submit" onclick="saveDateToPostges()"/>
</body>
</html>


<script>

    function saveDateToPostges(){
        var myURL = "http://localhost:8080/add Time";
        var data = {username: 'example'};
        fetch(myURL,{
            credentials: "same-origin",
            method: 'POST',
            body: JSON.stringify(data),
        }).then(response => {
            if (response.status === 200) {
            return response.json();
        } else {
            throw new Error('Something went wrong on api server!');
        }
    }).then(response => {
            alert(response);
    }).catch(error => {
            console.error(error);
        alert(error);
    });

    }
</script>