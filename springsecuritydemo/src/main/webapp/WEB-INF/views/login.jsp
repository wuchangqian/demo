<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
    <form action="login" method="post">
        <table>
            <tr>
                <td>username:</td>
                <td><input name="username" value="test" /></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input name="password" value="abcd1234" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="submit" /></td>
            </tr>
        </table>
    </form>
</body>
</html>