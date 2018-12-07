<%-- 
    Document   : searchWithStaff
    Created on : Jul 12, 2018, 1:28:01 PM
    Author     : Mochi
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <s:if test="%{#session.USERNAME == null}">
            <%@include file="login.html" %>
        </s:if>  
        <s:else>
        <font color="red">
        Welcome, <s:property value="%{#session.USERNAME}"/>
        </font>
        </br>
        <s:form action="logout">
              <s:submit value="Log Out" />
        </s:form>
        <h1>Search With Staff</h1>
        <form action="search">
            Search <input type="text" name="searchValue" value="${param.searchValue}" /></br>
            <input type="submit" value="Search" />
        </form>
            <s:if test="%{!searchValue.isEmpty()}">
                <s:if test="%{products != null}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>MobileId</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>MobileName</th>
                                <th>YearOfProduction</th>
                                <th>Quantity</th>
                                <th>IsSale</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="products" status="counter">
                                <s:form action="update" theme="simple">
                           
                                    <tr>
                                        <td>
                                            
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <s:property value="mobileId"/>
                                            <s:hidden name="mobileId" value="%{mobileId}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="description" value="%{description}"/>
                                        </td>
                                        <td>
                                      
                                            <s:textfield name="price" value="%{price}"/>
                                        </td>
                                        <td>
                                            <s:property value="mobileName"/>
                                        </td>
                                        <td>
                                            <s:property value="yearOfProduction"/>
                                        </td>
                                        <td>
                                            <s:textfield name="quantity" value="%{quantity}"/>
                                        </td>
                                        <td>
                                           
                                            <s:checkbox name="chkSale" value="%{isSale}"/>
                                        </td>
                                        <td>
                                            <s:url id="delMobile" action="delete">
                                                <s:param name="mobileId" value="mobileId"/>
                                                <s:param name="searchLastValue" value="searchValue"/>
                                            </s:url>
                                            <s:a href="%{delMobile}">Delete</s:a>
                                        </td>
                                        <td>
                                            <s:submit value="Update"/>
                                            <s:hidden name="searchLastValue" value="%{searchValue}"/>
                                        </td>
                                    </tr>
                                </s:form>       
                            </s:iterator>
                        </tbody>
                    </table>

                </s:if>
                <s:else>
                    <h2>
                        <font color="red">No record is matched!!!</font>
                    </h2>
                 </s:else>
            </s:if>
            <a href="signUpProduct">Click here to create new product</a>
            </s:else>
    </body>
</html>
