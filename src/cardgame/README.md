## BlackJack Project
 I created an object oriented program that simulates a Blackjack Game. Initially, I created a project that had high coupling and low cohesion which caused quite a bit of problems for me once I started changing my methods to account for the ace having two values. Therefore, I redid my project with methods that were more clearly defined and provided only one purpose. Once I made this change, it was much easier to edit my formulas without causing the whole program to have compiling errors.

 In the main class, I simply called one method and that was to start the game. In the BlackJack game class was where most of the methods lie. I felt like the game should have the responsibility of calculating each person's hand as well as determine who the winner was.

 I then created a dealer class, which includes methods to shuffle and deal cards. The player class simply contains getters and setters and the playermoves subclass provides the player options to hit or stay.

 The most difficult part of this project for me was using more object-oriented programming. However, after running into many errors, I found it helpful to rewrite my program and separate the classes and methods more. I feel like I greatly improved on calling methods and passing variables, which was the one thing that I have struggled most with thus far. 
