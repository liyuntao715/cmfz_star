<%@page contentType="text/html;charset=utf-8" isELIgnored = "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户注册</title>
</head>
<body>

<div class="fill_message">
    <form name="ctl00" method="post" action="${ pageContext.request.contextPath }/user/registUser" id="f" >
        <table class="tab_login" >
            <tr>
                <td valign="top" class="w1">
                    设置您的昵称：
                </td>
                <td>
                    <input type="text" id="txtNickName" class="text_input" />
                </td>
            </tr>
            <tr>
                <td valign="top" class="w1">
                    设置你的用户名：
                </td>
                <td>
                    <input type="text" class="text_input" />
                </td>
            </tr>
            <tr>
                <td valign="top" class="w1">
                    设置的密码：
                </td>
                <td>
                    <input type="password" id="txtRepeatPass" class="text_input"/>
                    <div class="text_left" id="repeatPassValidMsg">
                        <span id="password1Info"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="top" class="w1">
                    验证码：
                </td>
                <td>
                    <input type="text" id="txtVerifyCode" class="yzm_input"/>

                    <input class="button_1" type="submit" value="点击获取验证码"/>
                </td>
            </tr>
        </table>
        <div class="login_in">
            <input class="button_1" name="submit"  type="submit" value="注 册"/>
        </div>
    </form>
</div>

</body>
</html>

