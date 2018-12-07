<%-- 
    Document   : viewCart
    Created on : Jul 14, 2018, 7:12:26 PM
    Author     : Mochi
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>>Your cart includes</h1>
        <s:if test="%{!cart.isEmpty()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>MobileName</th>
                        <th>Quantity</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="products" status="counter">
                        <tr>
                            <td>
                                <s:property value="%{#counter.count}"/>
                            </td>
                            <td>
                                <s:property value="key"/> 
                            </td>
                            <td>
                                <s:property value="value"/>
                            </td>
                            
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>

        <s:if test="%{cart.isEmpty()}">
            <h2 color="red">Your Cart does not exist</h2>
        </s:if>
        
        
    </body>
</html>
