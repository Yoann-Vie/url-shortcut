<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>
      <form action="" method="post">
          <label for="base-url">Saisir l'url longue</label>
          <input type="text" id="base-url" name="base-url">
      </form>
  </jsp:body>
</t:layout>