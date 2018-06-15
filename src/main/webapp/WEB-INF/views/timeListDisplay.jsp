<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Spring MVC Hello World</title>
    <link href="webjars/bootstrap/4.0.0-alpha/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
    <h2>All Employees in System</h2>
    <a href="/">Back </a>
    <table class="table table-bordered" border="1">
        <tr>
            <th>UUID</th>
            <th>Month</th>
            <th>Year</th>
            <th>Quarter</th>
        </tr>
        <c:forEach items="${timeList}" var="time">
            <tr>
                <td><a href="/getTimeByID/${time.time_id}">${time.time_id}</a> </td>
                <td>${time.MONTH}</td>
                <td>${time.YEAR}</td>
                <td>${time.QUARTER}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="Submit" onclick="saveDateToPostges()"/>
</body>
</html>

<script>

    function saveDateToPostges(){
        var myURL = "http://localhost:8080/addTime";
        fetch(myURL,{
            credentials: "same-origin"
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
            });

    }
</script>

<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0-alpha/js/bootstrapmvc:.js"></script>