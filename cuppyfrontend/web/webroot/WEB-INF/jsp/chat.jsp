<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
    <title>Chat</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/chat.css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/resources/js/chat.js"></script>

    <script data-main="scripts/main" src="scripts/require.js"></script>
</head>
<body>
<h1>Chat window</h1>
${pageContext.request.contextPath}/
<div class="mainChatWindow">

    <table>
        <td style="width:20%">
            <div class="chatrooms">

            </div>
        </td>
        <td style="width:40%">
            <div class="chat">
                <div id="chatWindow"> </div>
                <div>
                    <form id="newFormMessage" method="post" >
                        <input id="inputMessage" type="text" name="message"/>
                        <input id="postMessageButton" type="submit">
                    </form>
                </div>
            </div>
        </td>
        <td style="width:20%">
            <div class="users">
                <ul>
                    <li> user1 </li>
                    <li> user2 </li>
                    <li> user3 </li>
                </ul>
            </div>
        </td>
    </table>

    <%--<form:form method="post" >
        <form:textarea path="messages"></form:textarea>
        <form:input path="aaa"></form:input>
    </form:form>--%>
</div>
</body>
</html>