$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Node adding",
  "description": "",
  "id": "node-adding",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Search from the node option",
  "description": "",
  "id": "node-adding;search-from-the-node-option",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "a node at local api",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user type \u003cname\u003e in the database",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user input \u003ctuoi\u003e in the database",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user input1 \u003cbirthday\u003e in the database",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user input2 \u003cid\u003e in the database",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user input3 \u003cjoin\u003e in the database",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user input4 \u003ctitle\u003e in the database",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user input5 \u003cstatus\u003e in the database",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user info compare in the list",
  "keyword": "And "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "node-adding;search-from-the-node-option;",
  "rows": [
    {
      "cells": [
        "name",
        "tuoi",
        "birthday",
        "id",
        "join",
        "title",
        "status"
      ],
      "line": 16,
      "id": "node-adding;search-from-the-node-option;;1"
    },
    {
      "cells": [
        "Tuan Anh",
        "30",
        "1985",
        "18",
        "2013",
        "Project Leader",
        "WORKING"
      ],
      "line": 17,
      "id": "node-adding;search-from-the-node-option;;2"
    },
    {
      "cells": [
        "Giang Pham",
        "44",
        "1995",
        "19",
        "2014",
        "Team Member",
        "WORKING"
      ],
      "line": 18,
      "id": "node-adding;search-from-the-node-option;;3"
    },
    {
      "cells": [
        "Vu Hien",
        "36",
        "1996",
        "20",
        "2014",
        "Team Member",
        "TRANSFERING"
      ],
      "line": 19,
      "id": "node-adding;search-from-the-node-option;;4"
    },
    {
      "cells": [
        "Thu Nguyen",
        "25",
        "1984",
        "21",
        "2013",
        "Facilitator",
        "VACATION"
      ],
      "line": 20,
      "id": "node-adding;search-from-the-node-option;;5"
    },
    {
      "cells": [
        "Khoi Do",
        "22",
        "1998",
        "22",
        "2018",
        "Technician",
        "IN ACTIVE"
      ],
      "line": 21,
      "id": "node-adding;search-from-the-node-option;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 17,
  "name": "Search from the node option",
  "description": "",
  "id": "node-adding;search-from-the-node-option;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "a node at local api",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user type Tuan Anh in the database",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user input 30 in the database",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user input1 1985 in the database",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user input2 18 in the database",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user input3 2013 in the database",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user input4 Project Leader in the database",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user input5 WORKING in the database",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user info compare in the list",
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureDefinition.a_node_at_local_api()"
});
formatter.result({
  "duration": 5906436530,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tuan Anh",
      "offset": 10
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_the_database(String)"
});
formatter.result({
  "duration": 27000663,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//*[@id\u003d\u0027form\u0027]/input[2]\"}\n  (Session info: chrome\u003d75.0.3770.142)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:54930}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 42527813cce4b878a9d1757c7c9b7bc4\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\u0027form\u0027]/input[2]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepdefinitions.LoginFeatureDefinition.user_type_in_the_database(LoginFeatureDefinition.java:52)\r\n\tat ✽.When user type Tuan Anh in the database(login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "30",
      "offset": 11
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_tuoi_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1985",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_birthday_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "18",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_id_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2013",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_join_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Project Leader",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_title_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "WORKING",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_status_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginFeatureDefinition.use_info_is_added_in_the_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 47704902,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Search from the node option",
  "description": "",
  "id": "node-adding;search-from-the-node-option;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "a node at local api",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user type Giang Pham in the database",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user input 44 in the database",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user input1 1995 in the database",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user input2 19 in the database",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user input3 2014 in the database",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user input4 Team Member in the database",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user input5 WORKING in the database",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user info compare in the list",
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureDefinition.a_node_at_local_api()"
});
formatter.result({
  "duration": 5313417514,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Giang Pham",
      "offset": 10
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_the_database(String)"
});
formatter.result({
  "duration": 43821147,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//*[@id\u003d\u0027form\u0027]/input[2]\"}\n  (Session info: chrome\u003d75.0.3770.142)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:54958}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: f7cbd47e0a1ce042ec3338c554e3a966\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\u0027form\u0027]/input[2]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepdefinitions.LoginFeatureDefinition.user_type_in_the_database(LoginFeatureDefinition.java:52)\r\n\tat ✽.When user type Giang Pham in the database(login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "44",
      "offset": 11
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_tuoi_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1995",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_birthday_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "19",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_id_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2014",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_join_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Team Member",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_title_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "WORKING",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_status_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginFeatureDefinition.use_info_is_added_in_the_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 48586313,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Search from the node option",
  "description": "",
  "id": "node-adding;search-from-the-node-option;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "a node at local api",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user type Vu Hien in the database",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user input 36 in the database",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user input1 1996 in the database",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user input2 20 in the database",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user input3 2014 in the database",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user input4 Team Member in the database",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user input5 TRANSFERING in the database",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user info compare in the list",
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureDefinition.a_node_at_local_api()"
});
formatter.result({
  "duration": 20223082118,
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:54986}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: ffd24d67b756f47d5e1cb70e96ed290c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getTitle(RemoteWebDriver.java:281)\r\n\tat stepdefinitions.LoginFeatureDefinition.a_node_at_local_api(LoginFeatureDefinition.java:44)\r\n\tat ✽.Given a node at local api(login.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Vu Hien",
      "offset": 10
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "36",
      "offset": 11
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_tuoi_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1996",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_birthday_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_id_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2014",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_join_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Team Member",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_title_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "TRANSFERING",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_status_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginFeatureDefinition.use_info_is_added_in_the_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 243982916,
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:54986}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: ffd24d67b756f47d5e1cb70e96ed290c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:442)\r\n\tat stepdefinitions.LoginFeatureDefinition.closeBrowser(LoginFeatureDefinition.java:123)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:59)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:222)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:210)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:204)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:50)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 20,
  "name": "Search from the node option",
  "description": "",
  "id": "node-adding;search-from-the-node-option;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "a node at local api",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user type Thu Nguyen in the database",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user input 25 in the database",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user input1 1984 in the database",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user input2 21 in the database",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user input3 2013 in the database",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user input4 Facilitator in the database",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user input5 VACATION in the database",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user info compare in the list",
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureDefinition.a_node_at_local_api()"
});
formatter.result({
  "duration": 5290227308,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Thu Nguyen",
      "offset": 10
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_the_database(String)"
});
formatter.result({
  "duration": 15349035,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//*[@id\u003d\u0027form\u0027]/input[2]\"}\n  (Session info: chrome\u003d75.0.3770.142)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55043}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 9f5d00bd6a66d0a63b7fd8019d7ede32\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\u0027form\u0027]/input[2]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepdefinitions.LoginFeatureDefinition.user_type_in_the_database(LoginFeatureDefinition.java:52)\r\n\tat ✽.When user type Thu Nguyen in the database(login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "25",
      "offset": 11
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_tuoi_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1984",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_birthday_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "21",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_id_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2013",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_join_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Facilitator",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_title_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "VACATION",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_status_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginFeatureDefinition.use_info_is_added_in_the_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 46834795,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Search from the node option",
  "description": "",
  "id": "node-adding;search-from-the-node-option;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "a node at local api",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user type Khoi Do in the database",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user input 22 in the database",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user input1 1998 in the database",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user input2 22 in the database",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user input3 2018 in the database",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user input4 Technician in the database",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user input5 IN ACTIVE in the database",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user info compare in the list",
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureDefinition.a_node_at_local_api()"
});
formatter.result({
  "duration": 5330838614,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Khoi Do",
      "offset": 10
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_the_database(String)"
});
formatter.result({
  "duration": 20861777,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//*[@id\u003d\u0027form\u0027]/input[2]\"}\n  (Session info: chrome\u003d75.0.3770.142)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55073}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 77389f94beddadcdde4c2b3553efb66b\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\u0027form\u0027]/input[2]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepdefinitions.LoginFeatureDefinition.user_type_in_the_database(LoginFeatureDefinition.java:52)\r\n\tat ✽.When user type Khoi Do in the database(login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "22",
      "offset": 11
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_tuoi_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1998",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_birthday_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "22",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_id_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2018",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_join_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Technician",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_title_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "IN ACTIVE",
      "offset": 12
    }
  ],
  "location": "LoginFeatureDefinition.user_type_in_status_the_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginFeatureDefinition.use_info_is_added_in_the_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 39771832,
  "status": "passed"
});
});