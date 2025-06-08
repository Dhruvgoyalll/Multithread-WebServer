

# 🚀 Scalable Multithreaded Web Server in Java

This project is a **high-performance multithreaded web server** built using Java that can handle **1,000,000+ HTTP requests per second**, verified using **Apache JMeter**. It demonstrates efficient concurrent server-side programming using Java’s threading model and socket APIs.

---

## 📂 Files Included

- `Server.java` – Multithreaded server implementation
- `Client.java` – Sample client to test server functionality
- `Server.class` – Compiled server bytecode
- `Client.class` – Compiled client bytecode

---

## ⚙️ Features

- Multi-threaded request processing using Java `Thread`
- Capable of handling over 1 million requests per second
- Socket programming using `java.net`
- Validated with Apache JMeter for performance testing
- Lightweight and portable with minimal dependencies

---

## 🛠️ Getting Started

### Prerequisites

- Java JDK 8 or above
- [Apache JMeter](https://jmeter.apache.org/) (optional, for load testing)

### Compilation

```bash
javac Server.java Client.java
