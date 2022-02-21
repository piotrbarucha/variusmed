<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3c.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html ng-app="CoreApp" xmlns="http://www.w3c.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page pageEncoding="ISO-8859-2" contentType="text/html; charset=ISO-8859-2" %>

    <title><t:message code="main.header"/></title>

    <meta name="author" content="BSTecno SP. Z O.O."/>
    <meta name="description" content="NZOPP">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>

    <!-- add styles and js lib-->
    <link href="resources/static/bootstrap/css/bootstrap.css" rel="stylesheet">

    <script src="http://code.angularjs.org/1.2.0rc1/angular.js"></script>
    <script src="http://code.angularjs.org/1.2.0rc1/angular-animate.min.js"></script>
    <script src="http://code.angularjs.org/1.2.0rc1/angular-touch.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/0.5.1/js/ngDialog.js"></script>
    <script src="resources/js/jcs-auto-validate.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <!-- add styles and js custom-->
    <link href="resources/static/css/main.css" rel="stylesheet">
    <script src="resources/js/main.js"></script>

    <style>
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
            display: none !important;
        }
    </style>

</head>
<body class="ng-cloak" data-ng-controller=MainCtrl data-ng-init="getMenuFromServer();" ng-cloak>

<%--http://www.variusmed.com.pl--%>
<div class="wrapper1">
    <!-- Menu wybor miasta -->
    <div class="wrapper2">
        <div class="vDivider"></div>
        <div class="fontChangeCity" ng-if="city === 'cieszyn'" data-ng-click="setCity('jastrzebie')">Przejd¼ do naszej
            placówki - Jastrzêbie Zdrój
        </div>
        <div class="fontChangeCity" ng-if="city === 'jastrzebie'" data-ng-click="setCity('cieszyn')">Przejd¼ do naszej
            placówki - Cieszyn
        </div>
        <div class="vDividerEmpty m10" ng-if="city === ''"></div>
    </div>
    <div class="filter-drop-shadow">
        <div ng-if="city === ''"><img src="resources/static/img/top_graphic_new.png" height="100%" width="100%"></div>
        <div ng-if="city === 'cieszyn'"><img src="resources/static/img/top_graphic_cieszyn.png" height="100%" width="100%"></div>
        <div ng-if="city === 'jastrzebie'"><img src="resources/static/img/top_graphic_jastrzebie.png" height="100%" width="100%"></div>
    </div>
    <div class="wrapper2">


        <!-- Menu poziom 1 -->
        <div id="toolsArea" class="content" ng-if="city != ''">
            <div class="vDividerEmpty m10"></div>
            <div class="vDivider"></div>
            <ul id="tabsNav" data-ng-repeat="itemTop in menu">
                <li data-ng-click="getMenuItemClicked(itemTop)"
                    ng-class="isActiveItem(itemTop) ?  'btn btn-menu left active' : 'btn btn-menu left'">
                    {{itemTop.propertyName}}
                </li>
            </ul>
            <div class="vDividerEmpty m30"></div>
            <div class="vDivider"></div>
        </div>


        <div class="content padding">
            <div id="mainArea" style="width: 940px; margin: 0 auto;">
                <div ng-include src="trustSrc(sidebar.location)"></div>
            </div>
        </div>
        <div id="menuCity" class="content" ng-if="city === ''">
            <div class="vDividerEmpty m20"></div>
            <div class="vDivider"></div>
            <div class="fontWellcome">ZAPRASZAMY DO ZAPOZNANIA SIÊ Z OFERT¡ NASZYCH PLACÓWEK</div>
            <ul>
                <li data-ng-click="setCity('cieszyn')"
                    ng-class="isActiveCity('cieszyn') ? 'btn btn-city left active' : 'btn btn-city left' ">Cieszyn
                </li>
                <li data-ng-click="setCity('jastrzebie')"
                    ng-class="isActiveCity('jastrzebie') ? 'btn btn-city right active' : 'btn btn-city right' ">
                    Jastrzêbie Zdrój
                </li>
            </ul>
            <div class="vDividerEmpty m20"></div>
            <div class="vDividerEmpty m20"></div>
        </div>

        <div class="wrapper2">
            <div class="vDivider"></div>
            <div class="fontChangeCity" ng-if="city === 'cieszyn'" data-ng-click="setCity('jastrzebie')">Przejd¼ do
                naszej placówki - Jastrzêbie Zdrój
            </div>
            <div class="fontChangeCity" ng-if="city === 'jastrzebie'" data-ng-click="setCity('cieszyn')">Przejd¼ do
                naszej placówki - Cieszyn
            </div>
            <div class="vDividerEmpty m10" ng-if="city === ''"></div>
        </div>
        <div data-ng-include="'common/Footer.jsp'"></div>
    </div>

    <%--
        </div>
    --%>

</div>

</body>
</html>
