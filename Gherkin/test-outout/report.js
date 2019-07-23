$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("web6.feature");
formatter.feature({
  "line": 1,
  "name": "Profile edit",
  "description": "",
  "id": "profile-edit",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit \u003celements\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input \u003cdata\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;",
  "rows": [
    {
      "cells": [
        "elements",
        "data"
      ],
      "line": 12,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;1"
    },
    {
      "cells": [
        "birthday",
        "1975"
      ],
      "line": 13,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;2"
    },
    {
      "cells": [
        "id",
        "IFSID0004"
      ],
      "line": 14,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;3"
    },
    {
      "cells": [
        "name",
        "William Ngan"
      ],
      "line": 15,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;4"
    },
    {
      "cells": [
        "join",
        "2014"
      ],
      "line": 16,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;5"
    },
    {
      "cells": [
        "title",
        "Project Leader"
      ],
      "line": 17,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;6"
    },
    {
      "cells": [
        "status",
        "Working"
      ],
      "line": 18,
      "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;7"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit birthday",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input 1975",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.match({
  "location": "feature6.user_in_local_host()"
});
formatter.result({
  "duration": 6193353040,
  "status": "passed"
});
formatter.match({
  "location": "feature6.press_edit_button()"
});
formatter.result({
  "duration": 62617197,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "birthday",
      "offset": 5
    }
  ],
  "location": "feature6.edit_elements$(String)"
});
formatter.result({
  "duration": 45990680,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:60142}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 408c53f0c7c4d4f10097bf2c0dc2ac8c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepdfs3.feature6.edit_elements$(feature6.java:38)\r\n\tat ✽.Then edit birthday(web6.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "1975",
      "offset": 6
    }
  ],
  "location": "feature6.edit_data$(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.choosing_the_right_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.press_save_and_check_list_for_the_new_profile()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 636923608,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit id",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input IFSID0004",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.match({
  "location": "feature6.user_in_local_host()"
});
formatter.result({
  "duration": 6283396531,
  "status": "passed"
});
formatter.match({
  "location": "feature6.press_edit_button()"
});
formatter.result({
  "duration": 5064023009,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "id",
      "offset": 5
    }
  ],
  "location": "feature6.edit_elements$(String)"
});
formatter.result({
  "duration": 27426659,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:60200}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 65845b883a794a9eef4b22e1d196293c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepdfs3.feature6.edit_elements$(feature6.java:38)\r\n\tat ✽.Then edit id(web6.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "IFSID0004",
      "offset": 6
    }
  ],
  "location": "feature6.edit_data$(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.choosing_the_right_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.press_save_and_check_list_for_the_new_profile()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 572216108,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input William Ngan",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.match({
  "location": "feature6.user_in_local_host()"
});
formatter.result({
  "duration": 5689086007,
  "status": "passed"
});
formatter.match({
  "location": "feature6.press_edit_button()"
});
formatter.result({
  "duration": 5076296429,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "name",
      "offset": 5
    }
  ],
  "location": "feature6.edit_elements$(String)"
});
formatter.result({
  "duration": 31098547,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:60259}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: c80a2722436a03b48acab7563aacc815\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepdfs3.feature6.edit_elements$(feature6.java:38)\r\n\tat ✽.Then edit name(web6.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "William Ngan",
      "offset": 6
    }
  ],
  "location": "feature6.edit_data$(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.choosing_the_right_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.press_save_and_check_list_for_the_new_profile()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 564502553,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit join",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input 2014",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.match({
  "location": "feature6.user_in_local_host()"
});
formatter.result({
  "duration": 5739476826,
  "status": "passed"
});
formatter.match({
  "location": "feature6.press_edit_button()"
});
formatter.result({
  "duration": 64456605,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "join",
      "offset": 5
    }
  ],
  "location": "feature6.edit_elements$(String)"
});
formatter.result({
  "duration": 29232518,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:60331}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 899a3f112c12df8e6491598b07379337\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepdfs3.feature6.edit_elements$(feature6.java:38)\r\n\tat ✽.Then edit join(web6.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "2014",
      "offset": 6
    }
  ],
  "location": "feature6.edit_data$(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.choosing_the_right_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.press_save_and_check_list_for_the_new_profile()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 605559215,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit title",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input Project Leader",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.match({
  "location": "feature6.user_in_local_host()"
});
formatter.result({
  "duration": 6173923650,
  "status": "passed"
});
formatter.match({
  "location": "feature6.press_edit_button()"
});
formatter.result({
  "duration": 67248903,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "title",
      "offset": 5
    }
  ],
  "location": "feature6.edit_elements$(String)"
});
formatter.result({
  "duration": 31877487,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:60389}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 44459afee095bc8ea3de4e6e81cd4cbd\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepdfs3.feature6.edit_elements$(feature6.java:38)\r\n\tat ✽.Then edit title(web6.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Project Leader",
      "offset": 6
    }
  ],
  "location": "feature6.edit_data$(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.choosing_the_right_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.press_save_and_check_list_for_the_new_profile()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 604075726,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "edit or remove factor in available user profile",
  "description": "",
  "id": "profile-edit;edit-or-remove-factor-in-available-user-profile;;7",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user in local host",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "press edit button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "edit status",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "input Working",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "choosing the right label",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "press save and check list for the new profile",
  "keyword": "Then "
});
formatter.match({
  "location": "feature6.user_in_local_host()"
});
formatter.result({
  "duration": 5761054866,
  "status": "passed"
});
formatter.match({
  "location": "feature6.press_edit_button()"
});
formatter.result({
  "duration": 56555244,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "status",
      "offset": 5
    }
  ],
  "location": "feature6.edit_elements$(String)"
});
formatter.result({
  "duration": 30272928,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d75.0.3770.142)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-9A9DCIF\u0027, ip: \u002710.225.3.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: C:\\Users\\PCT532\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:60446}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: bd2059dda1e7292cace4e91c88d5b888\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepdfs3.feature6.edit_elements$(feature6.java:38)\r\n\tat ✽.Then edit status(web6.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Working",
      "offset": 6
    }
  ],
  "location": "feature6.edit_data$(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.choosing_the_right_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "feature6.press_save_and_check_list_for_the_new_profile()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 610446920,
  "status": "passed"
});
});