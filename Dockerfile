FROM java:8
ADD ./pebbles-user.jar .
EXPOSE 9998
CMD java -jar -Xmx512M pebbles-user.jar
