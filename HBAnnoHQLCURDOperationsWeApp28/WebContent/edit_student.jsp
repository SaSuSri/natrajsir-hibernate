<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 style="text-align:center"> Edit Student</h1>
<body bgcolor='cyan'>
<form action="controller"  method="post">
  Student no: <input type="text"  value="${stDTO.sno}" readonly name="no"/> <br>
  Student name: <input type="text"  value="${stDTO.sname}" name="name" /><br>
  Student address: <input type="text"  value="${stDTO.sadd}" name="addrs" /><br>
 <input type="submit"  value="update" name="param">  
</form>

    <c:if  test="${editResult ne null }">
       ${editResult}  
    </c:if>
    <a href="controller?param=report">view report</a>
 
</body>