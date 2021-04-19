
java.exe -Dlog4j.configurationFile="log4j2.xml" -DldapUrl=ldap://localhost:389 -Dpassword=admin -Dprefix=CN= -DuserName=admin -Dsuffix=,DC=student  -classpath ".;lib\*" -jar executable.jar
