# assignment2Supplied

# Java OOP Tetris game

This project is a Java OOP Tetris Game.
Tetris is a tile-matching game originally designed and programmed by Soviet Russian game designer Alexey Pajitnov. The game, or one of its many variants, is available for nearly every video game console and computer operating system, as well as on devices such as graphing calculators, mobile phones, portable media players, PDAs, Network music players, and as an Easter egg on non-media products like oscilloscopes.

## Game Figures Featured

I: four cells in a straight line;
J: a row of three cells with one added below the right side;
L: a row of three cells with one added below the left side;
O: four cells in a 2×2 cell;
S: two stacked horizontal cells with the top one offset to the right;
T: a row of three cells with one added below the center;
Z: two stacked horizontal cells with the top one offset to the left.


## Cell

When you move this cell left, the coordinate would become (row, col-1) that is (3, 1); when you move this cell right, the coordinate would become (row, col+1) that is (3, 3); the coordinate would become (row+1, col) that is (4, 2) when you move this cell down.

## Block

A block is a geometric shape composed of four cells. There are seven distinct blocks. A block can be rotated 90° clockwise. Several rotations get the shape back to the original orientation. Each block has one (the O), or four (the L, J, T, I, S and Z) distinct rotational orientations. In this assignment, we define those commonalities in an abstract class named Block.  It has seven subclasses, IBlock, JBlock, LBlock, OBlock, SBlock, TBlock, and ZBlock. 

## Board

On the Board, we have a grid of size 20×10, where 20 is the row number and 10 is the column number as Figure 3. As a block moves in the wall, it would not make sense for it to be able to move through previously fallen blocks or beyond the edges of the Board. In order to prevent these illegal moves, when a block wants to move to a new location, it should check that a previously fallen block does not already occupy the new location and that it is not beyond the edges of the board. These checks should be made whenever a block wants to move left, move right, move down, or rotate.


## Exceptions

The project implements the following exceptions:

InvalidInputException
OutOfBoardException 

