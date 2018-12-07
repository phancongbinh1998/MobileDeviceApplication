<%-- 
    Document   : createNewProduct
    Created on : Jul 14, 2018, 11:19:44 AM
    Author     : Mochi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib uri="/struts-tags" prefix="s"%>
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Create New Product</h1>
        <s:form action="create">
            <s:textfield name="mobileId" label="MobileId"/> 
            <s:textfield name="description" label="Description"/>
            <s:textfield name="price" label="Price"/>
            <s:textfield name="mobileName" label="MobileName"/>
            <s:textfield name="yearOfProduction" label="YearOfProduction"/>
            <s:textfield name="quantity" label="Quantity"/>
            <s:checkbox name="sale" label="Sale"/>
            <s:submit value="Create New Product"/>
            <s:reset value="Reset"/>
        </s:form>
            <s:if test="%{exception.message.contains('duplicate')}">
                <font color="red">
                <s:property value="mobileId"/> is existed!!!
                </font>
            </s:if>
    </body>
</html>
