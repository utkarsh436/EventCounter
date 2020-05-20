#Event Counter
This library has the ability to keep track of the amount of events taken in place at a given time or the current
time within a span of 5 mins. 

## Usage
incrementCounter(): has the ability to signal an event has taken place at the current time

incrementCounter(LocalTime currDateTime): ability to signal an event has taken place at  client specified time

getCountOverTime(int seconds) : gets the count for the past seconds inputted by the user will throw excpetion if more
than 5 mins

## Requirements
Java 8+