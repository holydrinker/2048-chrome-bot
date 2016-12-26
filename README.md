# 2048-chrome-bot
A collection of algorithms collapsed in a package that solve 2048's gaming problem

2048 game: https://gabrielecirulli.github.io/2048/

## Required installation
git, jdk, maven, google chrome

## How to play
1 - `git clone https://github.com/giuseppe-santoro/2048-chrome-bot`

2 - Open Google Chrome and go to `chrome://extensions/`

3 - Enable "Developer Mode", press "Load unpacked extension" and select the project

4 - `git clone https://github.com/holydrinker/2048-chrome-bot`

5 - Go to https://gabrielecirulli.github.io/2048/

6 - Go into the project with your terminal and type `mvn exec:java`

7 - See bot playing :)


## How to add your own solution
Create a YourBrain.java class into the com.example.brain package that implements Brain.java interface. Type your algorithm in computeNextMove() method.

Don't forget to go into MyResource.class and change 

```java
Brain brain = new MyBrain();
```

with 

```java
Brain brain = new YourBrain();
```
