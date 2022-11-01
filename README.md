# Проект по автоматизации тестирования API на тестовом сайте reqres 
<img src="images/reqres_logo.png"/>

<a target="_blank" href="https://reqres.in/">Веб сайт reqres.in</a>


## :memo: Содержание:

- [Реализованные проверки](#boom-Реализованные-проверки)
- [Технологии](#classical_building-Технологии)
- [Сборка в Jenkins](#man_cook-Сборка-в-Jenkins)
- [Allure отчет](#bar_chart-Allure-отчет)
- [Интеграция с Allure TestOps](#И-Интеграция-с-Allure-TestOps)
- [Уведомление в Telegram при помощи бота](#-Уведомление-в-Telegram-при-помощи-бота)

## :boom: Реализованные проверки

- ✓ Создание пользователя
- ✓ Изменение данных пользователя
- ✓ Удаление пользователя
- ✓ Проверка соответствия формата изображений
- ✓ Проверка запрошенных данных о пользователе
- ✓ Проверка ответа 404 на запрос о несуществующем пользователе
- ✓ Наличие токена зарегистрированного пользователя

## :classical_building: Технологии
<p align="center">
<img width="6%" title="Idea" src="images/intellij-idea.svg">
<img width="6%" title="Java" src="images/Java.svg">
<img width="6%" title="Allure Report" src="images/allure_logo.svg">
<img width="6%" title="Gradle" src="images/Gradle.svg">
<img width="6%" title="JUnit5" src="images/JUnit5.svg">
<img width="6%" title="GitHub" src="images/GitHub.svg">
<img width="6%" title="Jenkins" src="images/Jenkins.svg">
<img width="6%" title="REST Assured" src="images/Rest-Assured.svg">
</p>

## :man_cook: Сборка в Jenkins
<img src="images/Jenkins.svg" width="30" height="30"  alt="Jenkins"/></a>  <a target="_blank" href="https://jenkins.autotests.cloud/job/reqres-API-tests/">Jenkins job</a>
<p align="center">
<a><img src="images/jenkins_job.png" alt="Jenkins"/></a>
</p>


## :bar_chart: Allure-отчет
<img src="images/allure_logo.svg" width="30" height="30"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/reqres-API-tests/4/allure/#">Allure report</a>
<p align="center">
<a><img src="images/allure_report.png" alt="Allure"/></a>
</p>

## <img src="images/allure_testOps_logo.svg" width="30" height="30"  alt="Allure"/></a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/16339">Allure TestOps</a>

<p align="center">
<img title="Allure TestOps Dashboard" src="images/allure_testOps.png">
</p>

## <img src="images/Telegram.svg" width="30" height="30"  alt="Telegram"/></a> Уведомление в Telegram при помощи бота

<p align="center">
<img title="Allure Overview Dashboard" src="images/telegram_report.png">
</p>

