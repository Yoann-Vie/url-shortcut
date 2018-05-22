<%@tag description="Admin page" pageEncoding="UTF-8"%>
<%@attribute name="scripts" fragment="true" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello World</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <header id="pageheader">
            <nav class="navbar navbar-light bg-faded">
                <a class="navbar-brand" href="#"><h1>Bzklink</h1></a>
                <img src="${pageContext.request.contextPath}/assets/img/produitenbretagne-292x300.png" width="80" class="d-inline-block align-top" alt="">
            </nav>
        </header>

        <div id="body" class="jumbotron">
            <jsp:doBody/>
        </div>

        <footer id="pagefooter" class="text-center">
            <p>ESGI 4IW1 - Paris</p>
        </footer>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>