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
            <td><a href="/getSaleByID/${sale.sale_id}">${sale.sale_id}</a></td>
            <td>${sale.DOLLARS}</td>
            <td>${sale.time.YEAR}</td>
            <td>${sale.time.QUARTER}</td>
            <td>${sale.time.MONTH}</td>
            <td>${sale.product.CLASS}</td>
            <td>${sale.product.INVENTORY}</td>
            <td>${sale.location.CITY}</td>
            <td>${sale.location.COUNTRY}</td>
        </tr>
    </c:forEach>
</table>
<input type="Submit" onclick="saveDateToPostges()"/>
</body>
</html>


<script>

    function saveDateToPostges(){
        var myURL = "http://localhost:8080/addSale";
        fetch(myURL,{
            credentials: "same-origin",
            method: 'GET',
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