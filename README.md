# BTD
Final BTD Project

## What the Project is

Our project is a spinoff of the popular Bloons Tower Defense franchise. The original game is a tower defense game, where
towers (monkey's as they're called in this game) are placed onto the map. The towers take down bloons and prevents them from
reaching the finish line. Our group all has fond memories of the game from when we were younger and decided to recreate this 
game with a twist--incorporating clicking UI for monkeys to take bloons down. 

![Gameplay](https://github.com/PotatoBanana23/BTD/blob/master/ezgif.com-gif-maker.gif)

## How to Install and Run

To execute the program, import the project from GitHub onto your local IDE or clone our repo, "PotatoBanana23/BTD", on your local IDE. From there, navigate to the 
Frame class and have the program run. From there, you can begin playing the game!

## How to Use the Project

###### Player Controls

Once the program is launched, you are in charge of placing monkey towers and clicking to shoot the bloons. You start the game
with one of each monkey and as the game progresses, you will be given money to purchase additional towers. To purchase a tower
visit the menu on the right of the screen and click the tower you'd like to purchase. Then, click on the map where you'd like to
place the tower. Because the monkeys can only shoot bloons when they're in the respective monkey's range, simply click on the screen
once you see bloons appear on your screen.

###### Objective
With 4 monkeys at the beginning of the game, your goal is to stop bloons from reaching the other side of the map. For each bloon that
reaches the finish line, you will lose a certain amount of lives depending on the color of the bloon (ranges from 1-5 lives). As the
rounds progress and you survive, you will be given money as a reward to purchase new towers. These can be used to help survive the 
onsluahgt of bloons that come your way. Both your lives and money will be shown on the top right of the screen. 

## Overview of Game Code

###### Frame class

The primary class used in this project was the Frame class. The paint method in this class continually updates everything happening
on the board. The mouse-clicked class was used to initiate shooting calculations and also check for bloon and dart collisions. 
It also was used for purchasing monkeys and placing them onto the map. 

![Paint1](https://github.com/PotatoBanana23/BTD/blob/master/paintImage1.PNG)
![Paint1](https://github.com/PotatoBanana23/BTD/blob/master/paintImage2.PNG)
![MouseClick1](https://github.com/PotatoBanana23/BTD/blob/master/mouseClickImage1.PNG)
![MouseClick2](https://github.com/PotatoBanana23/BTD/blob/master/mouseClickImage2.PNG)
![MouseClick3](https://github.com/PotatoBanana23/BTD/blob/master/mouseClickImage3.PNG)

###### Monkey (Tower) Classes and Darts

All of our classes that involved creating Monkeys (Towers) were nearly identical. They were used to instantiate the image of the monkey and also create variables necessary to its function in the game (like position coordinates and radius). 

Our dart/shooting classes were similar as they also instatiated images and important variables that were used throughout the program. However, the cannon shooting was slightly different because it had to incorporate explosions. 

![MonkeyImage1](https://github.com/PotatoBanana23/BTD/blob/master/monkeyImage1.PNG)
![ShootingImage1](https://github.com/PotatoBanana23/BTD/blob/master/shootingImage1.PNG)
![tackShootingImage1](https://github.com/PotatoBanana23/BTD/blob/master/tackShooting1.PNG)
![cannonShotingImage1](https://github.com/PotatoBanana23/BTD/blob/master/cannonShooting1.PNG)

###### Bloons

This bloons class accounts for all colors of bloons that spawn during the game. It was used to check the popping layer of the balloon and keep the balloons on the track. 

![bloons1](https://github.com/PotatoBanana23/BTD/blob/master/bloons1.PNG)
![bloons2](https://github.com/PotatoBanana23/BTD/blob/master/bloons2.PNG)

