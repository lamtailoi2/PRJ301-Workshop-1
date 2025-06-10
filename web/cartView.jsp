
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.USER}">
            <c:set var="user" value="${sessionScope.USER}" />
            <h1>${user.fullName}'s Cart</h1>
        </c:if>
        <a href="shop.jsp">Back to shop</a>

        <c:if test="${not empty sessionScope.CART}">
            <c:set var="cart" value="${sessionScope.CART}" />
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cart.items.values()}" var="item" varStatus="status">
                        <tr>
                    <form action="DispatchController" method="POST">
                        <td>${status.count}</td>
                        <td>
                            ${item.mobile.mobileId}
                            <input type="hidden" name="txtMobileId" value="${item.mobile.mobileId}" />
                        </td>
                        <td>${item.mobile.mobileName}</td>
                        <td>${item.mobile.price}</td>
                        <td>${item.quantity}</td>
                        <td>
                            <fmt:formatNumber value="${item.mobile.price * item.quantity}" type="currency" maxFractionDigits="2" minFractionDigits="2"/>
                        </td>
                        <td> <input type="submit" value="Remove Item" name="btAction" /> </td>
                    </form>
                </tr>
            </c:forEach>
            <tr> 
                <td colspan="7"> 
                    <form action="DispatchController" method="POST">
                        <input type="submit" value="Checkout" name="btAction" style="width: 100%; " />
                    </form> 
                </td> 
            </tr>
        </tbody>
    </table>

</c:if>

<c:if test="${empty cart}">
    <h2>Cart is empty!!!</h2>
</c:if>

</body>
</html>
