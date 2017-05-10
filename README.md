# How to instruct a computer to find all possible solutions to a puzzle
---

In professional software development, we don’t find algorithmically challenging problems so often. Sure, there are a lot of complex projects out there, but we must remember that despite the knowledge that we might have on a particular set of technologies, we also need to constantly polish our algorithm design skills.

Having this in mind, I came across this puzzle and ask myself, how would I instruct a computer to find all possible solutions to this? Let’s find out.

![Fig1](https://raw.githubusercontent.com/aaguilerav/puzzle_solver/master/src/test/resources/fig01.png)

First of all, how would a human solve it? I guess that for a problem like this, a great majority of people would just try one piece at a time in a trial-and-error way. So, if I were to solve this myself, I would use the following procedure:

* Starting from the upper left corner, from left to right, top down. (Or the lower right corner, it doesn’t really matter, what matters is that we decide to start somewhere in the puzzle and stick to our decision):
* **1)** Piece number 1 (whatever piece we decide), is placed in the upper left corner.
* **2)** In the spaces that are left, can we put another piece?
* **3)** NO, rotate 90 degrees clockwise/counter-clockwise, or flip horizontally/vertically (or, in other words, try a different position) and try again (go to step _2)_).
* **4)** YES, let’s continue with the following piece (piece number 2).
* **4.1)** In the spaces that are left, can we put another piece? (except piece number 1 because is already placed).
* **4.2)** NO, rotate 90 degrees clockwise/counter-clockwise, or flip horizontally/vertically and try again (go to step _4.1)_)
* **4.3)** YES, let’s continue with the following piece (piece number 3).
* **4.3.1)** In the spaces that are left, can we put another piece? (except piece number 1 and 2 because they are already placed)
* **4.3.2)** NO, rotate 90 degrees clockwise/counter-clockwise, or flip horizontally/vertically and try again (go to step _4.3.1)_)
* **4.3.3)** YES, let’s continue with the following piece (piece number 4).
* **4.3.3.1)** And so on...

See where this is going?

Let’s execute the algorithm, but now visually:

![Fig2](https://raw.githubusercontent.com/aaguilerav/puzzle_solver/master/src/test/resources/fig02.png)

* **Step 1**: in the diagram: Piece number 1 is placed in the upper left corner and, there is still plenty of space left for the next piece.
* **Step 2**: Piece number 2 is placed, but there is a little hole where no other piece can fit. So, we change the position of the piece (rotate clockwise in this case) and try again.
* **Step 3**: Piece number 2 is placed in a new position and now we have space left to continue.
* **Step 4**: Piece number 3 is placed and we still have space left to continue.
* **Step 5**: Piece number 4 is placed but there is a little hole where no other piece can fit. So, we change the position of the piece (rotate clockwise) and try again.
* **Step 6**: Piece number 4 is placed in a new position and we have space left to continue.
* And so on…

We have now an algorithm that can help us find solutions to this puzzle, let’s translate it into something that a computer can understand.

### Defining the Pieces in computer terms

How can we define a “Piece” in computer terms? First, the puzzle must be broken down into smaller components, in this case the pieces are made of 5 squares each for a total of 12 pieces that fit in a 6 x 10 squares space (60 squares)

![Fig3](https://raw.githubusercontent.com/aaguilerav/puzzle_solver/master/src/test/resources/fig03.png)

We can identify each piece with a letter from the alphabet:

![Fig4](https://raw.githubusercontent.com/aaguilerav/puzzle_solver/master/src/test/resources/fig04.png)

Now, each one of these pieces can fit in the 6x10 space in different positions (except piece G as you may have noticed already), let's put in an array all these different positions:

![Fig5](https://raw.githubusercontent.com/aaguilerav/puzzle_solver/master/src/test/resources/fig05.jpg)

The order of the pieces doesn't really matter for the purpose of creating a program that can find all possible solutions to this puzzle. We are using Java as the programming language to solve this problem, so let’s define all these combinations of pieces and different positions in Java terms.

I have defined 2 java classes: Piece.java and PieceConfig.Java, the former is self-explained, the latter represents the different positions a piece could be placed within the puzzle board.

To define a Piece and its different positions (PieceConfig objects) we do it the following way:

```Java
/*          +---+---+
            | E | E |
    +---+---+---+---+
    | E | E | E |
    +---+---+---+         */
Piece p_E = new Piece(1,"E");
    p_E.getPieceConfigurations().add(new PieceConfig(1,p_E,
                    new int[][]{{1,0},
                                {1,1},
                                {0,1},
                                {0,1}}, 4, 2)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(2,p_E,
                    new int[][]{{0,0,1,1},
                                {1,1,1,0}}, 2, 4)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(3,p_E,
                    new int[][]{{1,0},
                                {1,0},
                                {1,1},
                                {0,1}}, 4, 2)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(4,p_E,
                    new int[][]{{0,1,1,1},
                                {1,1,0,0}}, 2, 4)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(5,p_E,
                    new int[][]{{0,1},
                                {1,1},
                                {1,0},
                                {1,0}}, 4, 2)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(6,p_E,
                    new int[][]{{1,1,1,0},
                                {0,0,1,1}}, 2, 4)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(7,p_E,
                    new int[][]{{0,1},
                                {0,1},
                                {1,1},
                                {1,0}}, 4, 2)
                    );
    p_E.getPieceConfigurations().add(new PieceConfig(8,p_E,
                    new int[][]{{1,1,0,0},
                                {0,1,1,1}}, 2, 4)
                    );
PIECES.add(p_E);
```

As you perhaps have already noticed, the different positions (or configurations) this piece can be, are defined within those little arrays of 0’s and 1’s. In the last line of code of this sample, we add the piece (and its configurations) to a larger array along with the rest of the pieces.

### Translating the algorithm into computer terms

Now that we have a data structure where we can find all the different pieces and their different positions (configurations), let’s write the main piece of code in charge of trying every possible combination of pieces and positions:
