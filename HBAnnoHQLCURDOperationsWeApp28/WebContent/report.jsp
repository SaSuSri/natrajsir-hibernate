<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="text-align:center"> Students Report </h1>

<c:choose>
   <c:when test="${resultList ne null}">
    <table border="1" width="100%" height="100%">
      <tr><th>Stno</th><th>stname</th><th>stAdd</th><th>operations</th></tr>
      <c:forEach var="dto" items="${resultList}">
         <tr>
           <td>${dto.sno}</td>
           <td>${dto.sname}</td>
           <td>${dto.sadd}</td>
           <td>
            <a href="controller?param=edit&no=${dto.sno}">edit</a>
           </td>
         </tr>
      </c:forEach>
    </table>
   </c:when>
   <c:otherwise>
     <h1 style='color:red'> Records not found</h1>
   </c:otherwise>
</c:choose>
