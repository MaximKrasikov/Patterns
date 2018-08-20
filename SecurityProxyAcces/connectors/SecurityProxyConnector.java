package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * Created by Admin on 20.08.2018.
 */
/*удет производить проверку безопасности перед подключением.
В случае, если проверка не пройдена, соединение не должно быть установлено.*/
public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
     private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString ) {
        securityChecker = new SecurityCheckerImpl();
        simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}
