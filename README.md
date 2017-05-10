# How to instruct a computer to find all possible solutions to a puzzle
---

In professional software development, we don’t find algorithmically challenging problems so often. Sure, there are a lot of complex projects out there, but we must remember that despite the knowledge that we might have on a particular set of technologies, we also need to constantly polish our algorithm design skills.

Having this in mind, I came across this puzzle and ask myself, how would I instruct a computer to find all possible solutions to this? Let’s find out.

![Fig1](https://raw.githubusercontent.com/aaguilerav/puzzle_solver/master/src/test/resources/fig01.png)

First of all, how would a human solve it? I guess that for a problem like this, a great majority of people would just try one piece at a time in a trial-and-error way. So, if I were to solve this myself, I would use the following procedure:

* Starting from the upper left corner, from left to right, top down. (Or the lower right corner, it doesn’t really matter, what matters is that we decide to start somewhere in the puzzle and stick to our decision):
 * a) Piece number 1 (whatever piece we decide), is placed in the upper left corner.
 * b) In the spaces that are left, can we put another piece?
 * c) NO, rotate 90 degrees clockwise/counter-clockwise, or flip horizontally/vertically (or, in other words, try a different position) and try again (go to step **b**).
 * YES, let’s continue with the following piece (piece number 2).
 
* .
