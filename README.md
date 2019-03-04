# Java
Java code for Object Oriented Programming and Data Structures Coursework
The programs get more complex as you move down this list and start out basic.

Files:

Problemone.java and Problemtwo.java are solutions for the first two problems from ProjectEuler.net
Problemone.java: a simple main method that prints the sum of all numbers less than 1000 that are multiples of 3 or 5
Problemtwo.java: a simple main method that prints the sum of all even numbers in the fibonacci sequence upto 4,000,000.

Room.java: Creates a new class Room and allows you to:
  state the number of people in each instance of Room, 
  add or remove people from any specified room,
  get the number of people in a room,
  get the total number of people in the building
RoomTest.java: Tests the Room class by creating new Room objects and manipulating the number of people in each room.

In Folder ComplexNumberAssignment:
  ComplexNumber.java: Creates a Complex number class and allows you to:
    add complex numbers together
    subtract complex numbers
    multiple complex numbers
    divide complex numbers
    find the conjugate of a complex number
  CNTest.java: Tests the complex number class by creating new complex numbers. Initiates 2 complex numbers "hey" and "bye".

TicTacToe.java: Simulates a game of Tic Tac Toe between two players. Takes the spot players want to mark as input of row first and column next.
                Allows players to restart the game. Stops running when players don't want to start a new game anymore.
                
ModuleTwo.java: A program that can take in data from a text file and tally the digits in the nth position of each number. 
                Useful in finding the 0th digit and seeing if the data follows Benford's Law
                Takes the digit n as input. Change name of data file in the program to run on a different file. 
                Example data file: Instagram_Data.txt
                
In SolitaireEncryption_CircularLinkedList Folder:
  CircularLinkedList.java: A program that implements circular linked lists that can be used for SolitaireAssignment.java
                           Has methods that enable the simplified solitaire encryption and decryption algorithms to work.
  SolitaireAssignment.java:This program can decrypt your messages using a simplified version of the solitaire encryption                                  algorithm.
                           It needs CircularLinkedList.java to run.
                           The deck to be used to begin can be changed by changing the "deck" array.
                           This program can encrypt messages too! However, if you have used it to encrypt a message, it can't                            decrypt on that run since the deck has changed. Rerun the program and this time, comment out the                              encryption and just decrypt your message.
                           It can decrypt multiple messages but beware, the deck changes after every decryption and the new                              message will be decrypted from the deck as it exists after the previous decryption.
