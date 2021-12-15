# SecretSanta

<p>A system that takes in a group of people and 
assigns everyone in the group a random group member that isn't themselves or has not been assigned already.</p>

<p> Each group member is then sent a text message containing the name of the group member they have been assigned.</p>

<h3> Dependencies</h3>
<p> This project uses Javax.mail.jar 1.6.2 use the following Maven dependency to add it to your project resources.</p>

```
    <dependency>
        <groupId>com.sun.mail</groupId>
        <artifactId>javax.mail</artifactId>
        <version>1.6.2</version>
    </dependency>
```

<p>This project also uses JUnit 5 for its testing use the following maven dependency to add it to your project resources.

```
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>RELEASE</version>
        <scope>test</scope>
    </dependency>
```