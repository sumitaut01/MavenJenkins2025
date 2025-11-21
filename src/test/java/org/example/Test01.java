package org.example;

import org.testng.annotations.Test;

public class Test01 {


    @Test
    public void Method1(){


//        1. Reading Jenkins Parameters (Build Parameters) in Java
//        If your Jenkins job has parameters like:

//        browser = chrome
//        ENV = QA
//        and you run your tests with Maven:
//        mvn test -DBROWSER=chrome -DENV=QA
//        Then in Java you read them with:

        String browser = System.getProperty("BROWSER");
        String env = System.getProperty("ENV");
        //✔ This is the standard way for Jenkins parameters.



//        2. Reading Jenkins Environment Variables in Java
//        If Jenkins passes environment variables internally (e.g., BUILD_NUMBER, WORKSPACE, custom variables), you can read them using:

        String buildNumber = System.getenv("BUILD_NUMBER");
        String workspace = System.getenv("WORKSPACE");
        String customVar = System.getenv("MY_CUSTOM_VAR");


//✔ These come from the Jenkins machine environment.
//✔ Use this if Jenkins uses environment injection or pipeline environment blocks.



        //1. Running Maven manually (local terminal)
        //
        //You run it exactly like this:
        //
        //mvn test -DBROWSER=chrome -DENV=QA
        //
        //
        //✔ No braces
        //✔ No $
        //✔ You directly pass values
        //
        //✅ 2. Running inside Jenkins (Freestyle job or Pipeline)
        //
        //If Jenkins has parameters defined like:
        //
        //BROWSER (String) = chrome
        //ENV (String) = QA
        //
        //
        //Then Jenkins replaces ${BROWSER} and ${ENV} with actual values.
        //
        //So inside Jenkins you write:
        //
        //mvn test -DBROWSER=${BROWSER} -DENV=${ENV}
        //
        //
        //OR in a pipeline sh step:
        //
        //sh 'mvn test -DBROWSER=$BROWSER -DENV=$ENV'
        //
        //📌 So which one should you use?
        //✔ Local machine
        //mvn test -DBROWSER=chrome -DENV=QA
        //
        //✔ Jenkins (Freestyle job)
        //mvn test -DBROWSER=${BROWSER} -DENV=${ENV}
        //
        //✔ Jenkins Pipeline (declarative/scripted)
        //sh 'mvn test -DBROWSER=$BROWSER -DENV=$ENV'
        //
        //💡 Why different syntaxes?
        //Place	Syntax	Why
        //Local terminal	-DENV=QA	You type actual values
        //Jenkins Freestyle	${ENV}	Jenkins replaces parameters in command
        //Jenkins Pipeline	$ENV	Shell environment variable expansion
        //🎯 Java code remains the same
        //String browser = System.getProperty("BROWSER");
        //String env = System.getProperty("ENV");
        //
        //
        //If you want, I can show you the correct Jenkinsfile, the pipeline syntax, or how to automatically map ENV → your ENV enum.

    }
}
