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
</head>
<body>

    <header id="pageheader">
        <p>header here</p>
    </header>

    <div id="body">
        <jsp:doBody/>
    </div>

    <footer id="pagefooter">
        <p>footer here</p>
    </footer>

</body>
</html>