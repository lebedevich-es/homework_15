# Automated tests for [SPRIBE](https://spribe.co)

<img title="Jenkins Build" src="images/screens/MainPage.png">

## :pushpin: Content:

- [Stack of technologies](#computer-stack-of-technologies)
- [Running tests](#running_woman-running-tests)
- [Build in Jenkins](#-build-in-jenkins)
- [Allure report](#-allure-report)
- [Allure TestOps Integration](#-allure-testops-integration)
- [Jira Integration](#-jira-integration)
- [Telegram notifications](#-telegram-notifications)
- [Video of an example of running a test in Selenoid](#-video-of-an-example-of-running-a-test-in-selenoid)


## :computer: Stack of technologies

<p align="center">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Idea.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="JUnit5" src="images/logo/Junit5.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Jira" src="images/logo/Jira.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TO.svg">
</p>

Autotests are written in <code>Java</code> using <code>JUnit 5</code> and <code>Gradle</code>.
For UI tests, the [Selenide](https://selenide.org/) framework was used.
Tests can be run locally or using [Selenoid](https://aerokube.com/selenoid/).
Also implemented build in <code>Jenkins</code> with generation of Allure-report and sending notification with results to <code>Telegram</code> after completion of the run. All tests are linked with <code>Jira</code> issue's keys.

**Allure report includes:**

* Test execution steps (of automated and manual tests)
* Screenshot of the last step
* Page Source
* Browser console logs
* Video of run


## :running_woman: Running tests

If necessary, you can override the launch options:

```
gradle clean ${TASK}
-Dbrowser_name=${BROWSER}
-Dbrowser_version=${VERSION}
-Dbrowser_size=${SIZE}
-Dselenide_remote=${REMOTE}
```

### Build options

* <code>TASK</code> is the name of the task. The default is <code>test</code> to run all of them.
* <code>BROWSER</code> is the browser in which the tests will be run. The default is <code>chrome</code>.
* <code>VERSION</code> is the browser version in which the tests will be run. The default is <code>100.00</code>.
* <code>SIZE</code> is the size of the browser window in which tests will be run. The default is <code>1920x1080</code>
* <code>REMOTE</code> is the address of the remote server where the tests will be run.


## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Build in [Jenkins](https://jenkins.autotests.cloud/job/homework_15_test_project/)
<p align="center">
<img title="Jenkins Build" src="images/screens/JenkinsBuild.png">

</p>


## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.svg"> [Allure](https://jenkins.autotests.cloud/job/homework_15_test_project/6/allure/) report
### Overview

<p align="center">
<img title="Allure Overview" src="images/screens/AllureReport1.png">
</p>

### Test result

<p align="center">
<img title="Test Results in Allure" src="images/screens/AllureReport2.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Allure TestOps Report" src="images/logo/Allure_TO.svg"> [Allure TestOps](https://allure.autotests.cloud/launch/24378) Integration

Also we can connect <code>Jenkins</code> to the commercial version of <code>Allure</code>, which provides an opportunity to add there manual tests as well as an automated ones:

<p align="center">
<img title="Test Results in Allure" src="images/screens/AllureTestOps.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Jira Integration" src="images/logo/Jira.svg"> [Jira](https://jira.autotests.cloud/browse/HOMEWORK-712) Integration

And also we can see from <code>Jira</code>, which tests been added to <code>Allure</code> with their statuses

<p align="center">
<img title="Allure Overview" src="images/screens/JiraResults.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications

<p align="center">
<img width="50%" title="Telegram Notifications" src="images/screens/telegram.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.svg"> Video of an example of running a test in Selenoid

A video is attached to each test in the report. One of these videos is shown below.
<p align="center">
  <img title="Selenoid Video" src="images/video/video.gif">
</p>
