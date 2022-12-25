# Lab 13. Visitor & Proxy
[![Java CI with Maven](https://github.com/andylvua/OOP_Lab13/actions/workflows/maven.yml/badge.svg)](https://github.com/andylvua/OOP_Lab13/actions/workflows/maven.yml)

## Description
A simple example of the Visitor and Proxy patterns.

## Task
- [x] Check what is Celery. Run app.py to understand why do we need Celery.
- [x] Setup Flask-Celery demo from GIT. Use test.http to explore.
- [x] Check the documentation of `Stamping API` in `Celery`. Investigate `Stamping API` source code.
- [x] Complete Task 1.
- [x] Test `JSOUP` and how to scrape websites.
- [x] Check how to send raw HTTP requests. Check PDL example.
- [x] Complete Task 2.
- [x] Submit a link to GitHub with tests and a GitHub Action file.

### Task 1
Implement `Stamping API` in Java. The goal is to reimplement `Stamping API` in Java for a simplified framework. The framework consists of:

- `interface Task`, an interface of building unit;
- `class Signature` that represents the smallest unit in framework and single task invocation;
- `class Group` that represents the list of signatures, and when the group is called, the tasks will be applied one after another in the current process.

- You need to implement `Stamping API` and `Group Stamping` in a similar manner as it is done in `Celery`. When the apply method is called for `Group Stamping`, there should happen an automatic stamping of the `Signature` with the `groupId`. Stamps are stored in the group header.

### Task 2
Implement scrapping service for `NewHomeSource` with `Proxy` template. If the link is already scrapped extract it from the cache, else run the link again. Use the `JDBC` library to store links in `SQLite DB`. Use `JSoup` to parse HTML, if needed.

## License

The [MIT](https://choosealicense.com/licenses/mit/) License (MIT)

Copyright © 2022. Andrii Yaroshevych
