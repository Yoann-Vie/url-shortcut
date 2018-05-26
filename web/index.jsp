<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "WEB-INF/tld/url.tld" prefix="url" %>

<t:layout>
  <jsp:body>
      <url:Item id="1"/>

      <form action="" method="post">
          <div class="form-group">
              <label for="base-url">Saisir l'url longue</label>
              <input type="text" class="form-control" id="base-url" name="base-url" placeholder="Url">
          </div>
          <button type="submit" class="btn btn-primary">Envoyer</button>
      </form>
  </jsp:body>
</t:layout>