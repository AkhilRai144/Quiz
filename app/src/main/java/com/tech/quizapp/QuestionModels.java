package com.tech.quizapp;

public class QuestionModels {

   public static String[] question = {
            "Who invented Java Programming?",
            "Which component is used to compile, debug and execute the java programs?",
            "Which one of the following is not a Java feature?",
            "Which of these cannot be used for a variable name in Java?",
            "What is the extension of java code files?",
            "Which environment variable is used to set the java path?",
    };

   public static String[][] answer = {
            {"Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"},
            {"JRE", "JIT", "JDK", "JVM"},
            {"Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible"},
            {"identifier & keyword", "identifier", "keyword", "none of the mentioned"},
            {"js", "txt", "class", "java"},
            {"MAVEN_Path", "JavaPATH", "JAVA", "JAVA_HOME"}
    };

   public static String[] correctAns = {
            "James Gosling",
            "JDK",
            "Use of pointers",
            "keyword",
            ".java",
            "JAVA_HOME"};
}
