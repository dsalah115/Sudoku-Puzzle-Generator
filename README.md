# Sudoku-Puzzle-Generator
Daniel Salah

This program generates a solved sudoku board. It does this through the use of a recursive method, nested loops, 1D and 2D arrays, as well as other generic methods like those to check things and print the board. It does not take an input as it just starts with an empty 9x9 2D array that represents the sudoku board.

To run the program simply put it into an IDE of your choice and click run. It does not require any inputs and therefore the solved sudoku board will appear in the terminal after running.

The board is generated through the use of the recursive method. It gets a position and a value and tests if that value could work in that position. If it does then it goes to the next position and if it doesn’t then it tests the next value. If there are no more values then it goes to the previous position and tests the next value. This process repeats until the entire board is solved.

Files: 
README.md          SudokuGenerator.java             DesignDoc.pdf
