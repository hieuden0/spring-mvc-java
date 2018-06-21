<link href="webjars/bootstrap/4.0.0-alpha/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<html xmlns:th="http://www.thymeleaf.org">
<head>

</head>
<body>
<div th:fragment="header">
    <!-- this is header -->
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" th:href="@{/}">Spring Boot</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a th:href="@{/}">Home</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>

</body>
</html>


<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0-alpha/js/bootstrapmvc:.js"></script>