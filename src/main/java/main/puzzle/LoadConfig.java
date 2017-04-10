/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

import java.util.ArrayList;

public class LoadConfig {
    
    public static void loadConfigurations(ArrayList<Piece> PIECES) {

        Piece p_E = new Piece(1,"E");
            /*
            +---+
            | E |
            +---+---+
            | E | E |
            +---+---+
                | E |
                +---+
                | E |
                +---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(1,p_E,
                            new int[][]{{1,0},
                                        {1,1},
                                        {0,1},
                                        {0,1}}, 4, 2)
                    );
            /*
                    +---+---+
                    | E | E |
            +---+---+---+---+
            | E | E | E |
            +---+---+---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(2,p_E,
                            new int[][]{{0,0,1,1},
                                        {1,1,1,0}}, 2, 4)
                    );
            /*
            +---+
            | E |
            +---+
            | E |
            +---+---+
            | E | E |
            +---+---+
                | E |
                +---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(3,p_E,
                            new int[][]{{1,0},
                                        {1,0},
                                        {1,1},
                                        {0,1}}, 4, 2)
                    );
            /*
                +---+---+---+
                | E | E | E |
            +---+---+---+---+
            | E | E |
            +---+---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(4,p_E,
                            new int[][]{{0,1,1,1},
                                        {1,1,0,0}}, 2, 4)
                    );
            //---------------------------------------------------------------------
            /*
                +---+
                | E |
            +---+---+
            | E | E |
            +---+---+
            | E |
            +---+
            | E |
            +---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(5,p_E,
                            new int[][]{{0,1},
                                        {1,1},
                                        {1,0},
                                        {1,0}}, 4, 2)
                    );
            /*
            +---+---+---+
            | E | E | E |
            +---+---+---+---+
                    | E | E |
                    +---+---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(6,p_E,
                            new int[][]{{1,1,1,0},
                                        {0,0,1,1}}, 2, 4)
                    );
            /*
                +---+
                | E |
                +---+
                | E |
            +---+---+
            | E | E |
            +---+---+
            | E |
            +---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(7,p_E,
                            new int[][]{{0,1},
                                        {0,1},
                                        {1,1},
                                        {1,0}}, 4, 2)
                    );
            /*
            +---+---+
            | E | E |
            +---+---+---+---+
                | E | E | E |
                +---+---+---+
            */
            p_E.getPieceConfigurations().add(
                    new PieceConfig(8,p_E,
                            new int[][]{{1,1,0,0},
                                        {0,1,1,1}}, 2, 4)
                    );
        PIECES.add(p_E);
        //=====================================================================
        Piece p_C = new Piece(2,"C");
            /*
            +---+
            | C |
            +---+---+
            | C | C |
            +---+---+
            | C |
            +---+
            | C |
            +---+
            */        
            p_C.getPieceConfigurations().add(
                    new PieceConfig(1,p_C,
                            new int[][]{{1,0},
                                        {1,1},
                                        {1,0},
                                        {1,0}}, 4, 2)
                    );
            /*
            +---+---+---+---+
            | C | C | C | C |
            +---+---+---+---+
                    | C |
                    +---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(2,p_C,
                            new int[][]{{1,1,1,1},
                                        {0,0,1,0}}, 2, 4)
                    );
            /*
                +---+
                | C |
                +---+
                | C |
            +---+---+
            | C | C |
            +---+---+
                | C |
                +---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(3,p_C,
                            new int[][]{{0,1},
                                        {0,1},
                                        {1,1},
                                        {0,1}}, 4, 2)
                    );
            /*
                +---+
                | C |
            +---+---+---+---+
            | C | C | C | C |
            +---+---+---+---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(4,p_C,
                            new int[][]{{0,1,0,0},
                                        {1,1,1,1}}, 2, 4)
                    );
            //---------------------------------------------------------------------
            /*
                +---+
                | C |
            +---+---+
            | C | C |
            +---+---+
                | C |
                +---+
                | C |
                +---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(5,p_C,
                            new int[][]{{0,1},
                                        {1,1},
                                        {0,1},
                                        {0,1}}, 4, 2)
                    );
            /*
                    +---+
                    | C |
            +---+---+---+---+
            | C | C | C | C |
            +---+---+---+---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(6,p_C,
                            new int[][]{{0,0,1,0},
                                        {1,1,1,1}}, 2, 4)
                    );
            /*
            +---+
            | C |
            +---+
            | C |
            +---+---+
            | C | C |
            +---+---+
            | C |
            +---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(7,p_C,
                            new int[][]{{1,0},
                                        {1,0},
                                        {1,1},
                                        {1,0}}, 4, 2)
                    );
            /*
            +---+---+---+---+
            | C | C | C | C |
            +---+---+---+---+
                | C |
                +---+
            */
            p_C.getPieceConfigurations().add(
                    new PieceConfig(8,p_C,
                            new int[][]{{1,1,1,1},
                                        {0,1,0,0}}, 2, 4)
                    );
        PIECES.add(p_C);
        //=====================================================================
        Piece p_L = new Piece(3,"L");
            /*
            +---+---+
            | L | L |
            +---+---+
                | L |
                +---+
                | L |
                +---+
                | L |
                +---+
             */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(1,p_L,
                            new int[][]{{1,1},
                                        {0,1},
                                        {0,1},
                                        {0,1}}, 4, 2)
                    );
            /*
                        +---+
                        | L |
            +---+---+---+---+
            | L | L | L | L |
            +---+---+---+---+
            */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(2,p_L,
                            new int[][]{{0,0,0,1},
                                        {1,1,1,1}}, 2, 4)
                    );
            /*
            +---+
            | L |
            +---+
            | L |
            +---+
            | L |
            +---+---+
            | L | L |
            +---+---+
            */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(3,p_L,
                            new int[][]{{1,0},
                                        {1,0},
                                        {1,0},
                                        {1,1}}, 4, 2)
                    );
            /*
            +---+---+---+---+
            | L | L | L | L |
            +---+---+---+---+
            | L |
            +---+
            */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(4,p_L,
                            new int[][]{{1,1,1,1},
                                        {1,0,0,0}}, 2, 4)
                    );
            //---------------------------------------------------------------------
            /*
            +---+---+
            | L | L |
            +---+---+
            | L |
            +---+
            | L |
            +---+
            | L |
            +---+
            */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(5,p_L,
                            new int[][]{{1,1},
                                        {1,0},
                                        {1,0},
                                        {1,0}}, 4, 2)
                    );
            /*
            +---+---+---+---+
            | L | L | L | L |
            +---+---+---+---+
                        | L |
                        +---+
            */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(6,p_L,
                            new int[][]{{1,1,1,1},
                                        {0,0,0,1}}, 2, 4)
                    );
            /*
                +---+
                | L |
                +---+
                | L |
                +---+
                | L |
            +---+---+
            | L | L |
            +---+---+
             */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(7,p_L,
                            new int[][]{{0,1},
                                        {0,1},
                                        {0,1},
                                        {1,1}}, 4, 2)
                    );
            /*
            +---+
            | L | 
            +---+---+---+---+
            | L | L | L | L |
            +---+---+---+---+
            */
            p_L.getPieceConfigurations().add(
                    new PieceConfig(8,p_L,
                            new int[][]{{1,0,0,0},
                                        {1,1,1,1}}, 2, 4)
                    );
        PIECES.add(p_L);
        //=====================================================================
        Piece p_B = new Piece(4,"B");
            /*
                +---+---+
                | B | B |
            +---+---+---+
            | B | B | B |
            +---+---+---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(1,p_B,
                            new int[][]{{0,1,1},
                                        {1,1,1}}, 2, 3)
                    );
            /*
            +---+
            | B |
            +---+---+
            | B | B |
            +---+---+
            | B | B |
            +---+---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(2,p_B,
                            new int[][]{{1,0},
                                        {1,1},
                                        {1,1}}, 3, 2)
                    );
            /*
            +---+---+---+
            | B | B | B |
            +---+---+---+
            | B | B |
            +---+---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(3,p_B,
                            new int[][]{{1,1,1},
                                        {1,1,0}}, 2, 3)
                    );
            /*
            +---+---+
            | B | B |
            +---+---+
            | B | B |
            +---+---+
                | B |
                +---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(4,p_B,
                            new int[][]{{1,1},
                                        {1,1},
                                        {0,1}}, 3, 2)
                    );
            //---------------------------------------------------------------------
            /*
            +---+---+---+
            | B | B | B |
            +---+---+---+
                | B | B |
                +---+---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(5,p_B,
                            new int[][]{{1,1,1},
                                        {0,1,1}}, 2, 3)
                    );
            /*
                +---+
                | B |
            +---+---+
            | B | B |
            +---+---+
            | B | B |
            +---+---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(6,p_B,
                            new int[][]{{0,1},
                                        {1,1},
                                        {1,1}}, 3, 2)
                    );
            /*
            +---+---+
            | B | B |
            +---+---+---+
            | B | B | B |
            +---+---+---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(7,p_B,
                            new int[][]{{1,1,0},
                                        {1,1,1}}, 2, 3)
                    );
            /*
            +---+---+
            | B | B |
            +---+---+
            | B | B |
            +---+---+
            | B |
            +---+
            */
            p_B.getPieceConfigurations().add(
                    new PieceConfig(8,p_B,
                            new int[][]{{1,1},
                                        {1,1},
                                        {1,0}}, 3, 2)
                    );
        PIECES.add(p_B);
        //=====================================================================
        Piece p_I = new Piece(5,"I");
            /*
                +---+
                | I |
            +---+---+---+
            | I | I | I |
            +---+---+---+
            | I |
            +---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(1,p_I,
                            new int[][]{{0,1,0},
                                        {1,1,1},
                                        {1,0,0}}, 3, 3)
                    );
            /*
            +---+---+
            | I | I |
            +---+---+---+
                | I | I |
                +---+---+
                | I |
                +---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(2,p_I,
                            new int[][]{{1,1,0},
                                        {0,1,1},
                                        {0,1,0}}, 3, 3)
                    );
            /*
                    +---+
                    | I |
            +---+---+---+
            | I | I | I |
            +---+---+---+
                | I |
                +---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(3,p_I,
                            new int[][]{{0,0,1},
                                        {1,1,1},
                                        {0,1,0}}, 3, 3)
                    );
            /*
                +---+
                | I |
            +---+---+
            | I | I |
            +---+---+---+
                | I | I |
                +---+---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(4,p_I,
                            new int[][]{{0,1,0},
                                        {1,1,0},
                                        {0,1,1}}, 3, 3)
                    );
            //---------------------------------------------------------------------
            /*
                +---+
                | I |
            +---+---+---+
            | I | I | I |
            +---+---+---+
                    | I |
                    +---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(5,p_I,
                            new int[][]{{0,1,0},
                                        {1,1,1},
                                        {0,0,1}}, 3, 3)
                    );
            /*
                +---+
                | I |
                +---+---+
                | I | I |
            +---+---+---+
            | I | I |
            +---+---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(6,p_I,
                            new int[][]{{0,1,0},
                                        {0,1,1},
                                        {1,1,0}}, 3, 3)
                    );
            /*
            +---+
            | I |
            +---+---+---+
            | I | I | I |
            +---+---+---+
                | I |
                +---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(7,p_I,
                            new int[][]{{1,0,0},
                                        {1,1,1},
                                        {0,1,0}}, 3, 3)
                    );
            /*
                +---+---+
                | I | I |
            +---+---+---+
            | I | I |
            +---+---+
                | I |
                +---+
            */
            p_I.getPieceConfigurations().add(
                    new PieceConfig(8,p_I,
                            new int[][]{{0,1,1},
                                        {1,1,0},
                                        {0,1,0}}, 3, 3)
                    );
        PIECES.add(p_I);
        //=====================================================================
        Piece p_J = new Piece(6,"J");
            /*
            +---+---+
            | J | J |
            +---+---+
                | J |
                +---+---+
                | J | J |
                +---+---+
            */
            p_J.getPieceConfigurations().add(
                    new PieceConfig(1,p_J,
                            new int[][]{{1,1,0},
                                        {0,1,0},
                                        {0,1,1}}, 3, 3)
                    );
            /*
                    +---+
                    | J |
            +---+---+---+
            | J | J | J |
            +---+---+---+
            | J |
            +---+
            */
            p_J.getPieceConfigurations().add(
                    new PieceConfig(2,p_J,
                            new int[][]{{0,0,1},
                                        {1,1,1},
                                        {1,0,0}}, 3, 3)
                    );
            /*
                +---+---+
                | J | J |
                +---+---+
                | J |
            +---+---+
            | J | J |
            +---+---+
            */
            p_J.getPieceConfigurations().add(
                    new PieceConfig(3,p_J,
                            new int[][]{{0,1,1},
                                        {0,1,0},
                                        {1,1,0}}, 3, 3)
                    );
            /*
            +---+
            | J |
            +---+---+---+
            | J | J | J |
            +---+---+---+
                    | J |
                    +---+
            */
            p_J.getPieceConfigurations().add(
                    new PieceConfig(4,p_J,
                            new int[][]{{1,0,0},
                                        {1,1,1},
                                        {0,0,1}}, 3, 3)
                    );
        PIECES.add(p_J);
        //=====================================================================
        Piece p_K = new Piece(7,"K");
            /*
            +---+
            | K |
            +---+
            | K |
            +---+---+---+
            | K | K | K |
            +---+---+---+
            */
            p_K.getPieceConfigurations().add(
                    new PieceConfig(1,p_K,
                            new int[][]{{1,0,0},
                                        {1,0,0},
                                        {1,1,1}}, 3, 3)
                    );
            /*
            +---+---+---+
            | K | K | K |
            +---+---+---+
            | K |
            +---+
            | K |
            +---+
            */
            p_K.getPieceConfigurations().add(
                    new PieceConfig(2,p_K,
                            new int[][]{{1,1,1},
                                        {1,0,0},
                                        {1,0,0}}, 3, 3)
                    );
            /*
            +---+---+---+
            | K | K | K |
            +---+---+---+
                    | K |
                    +---+
                    | K |
                    +---+
            */
            p_K.getPieceConfigurations().add(
                    new PieceConfig(3,p_K,
                            new int[][]{{1,1,1},
                                        {0,0,1},
                                        {0,0,1}}, 3, 3)
                    );
            /*
                    +---+
                    | K |
                    +---+
                    | K |
            +---+---+---+
            | K | K | K |
            +---+---+---+
            */
            p_K.getPieceConfigurations().add(
                    new PieceConfig(4,p_K,
                            new int[][]{{0,0,1},
                                        {0,0,1},
                                        {1,1,1}}, 3, 3)
                    );
        PIECES.add(p_K);
        //=====================================================================
        Piece p_F = new Piece(8,"F");
            /*
                +---+---+
                | F | F |
            +---+---+---+
            | F | F |
            +---+---+
            | F |
            +---+
            */
            p_F.getPieceConfigurations().add(
                    new PieceConfig(1,p_F,
                            new int[][]{{0,1,1},
                                        {1,1,0},
                                        {1,0,0}}, 3, 3)
                    );
            /*
            +---+---+
            | F | F |
            +---+---+---+
                | F | F |
                +---+---+
                    | F |
                    +---+
            */
            p_F.getPieceConfigurations().add(
                    new PieceConfig(2,p_F,
                            new int[][]{{1,1,0},
                                        {0,1,1},
                                        {0,0,1}}, 3, 3)
                    );
            /*
                    +---+
                    | F |
                +---+---+
                | F | F |
            +---+---+---+
            | F | F |
            +---+---+
            */
            p_F.getPieceConfigurations().add(
                    new PieceConfig(3,p_F,
                            new int[][]{{0,0,1},
                                        {0,1,1},
                                        {1,1,0}}, 3, 3)
                    );
            /*
            +---+
            | F |
            +---+---+
            | F | F |
            +---+---+---+
                | F | F |
                +---+---+
            */
            p_F.getPieceConfigurations().add(
                    new PieceConfig(4,p_F,
                            new int[][]{{1,0,0},
                                        {1,1,0},
                                        {0,1,1}}, 3, 3)
                    );
        PIECES.add(p_F);
        //=====================================================================
        Piece p_D = new Piece(9,"D");
            /*
            +---+---+---+
            | D | D | D |
            +---+---+---+
                | D |
                +---+
                | D |
                +---+
            */
            p_D.getPieceConfigurations().add(
                    new PieceConfig(1,p_D,
                            new int[][]{{1,1,1},
                                        {0,1,0},
                                        {0,1,0}}, 3, 3)
                    );
            /*
                    +---+
                    | D |
            +---+---+---+
            | D | D | D |
            +---+---+---+
                    | D |
                    +---+
            */
            p_D.getPieceConfigurations().add(
                    new PieceConfig(2,p_D,
                            new int[][]{{0,0,1},
                                        {1,1,1},
                                        {0,0,1}}, 3, 3)
                    );
            /*
                +---+
                | D |
                +---+
                | D |
            +---+---+---+
            | D | D | D |
            +---+---+---+
            */
            p_D.getPieceConfigurations().add(
                    new PieceConfig(3,p_D,
                            new int[][]{{0,1,0},
                                        {0,1,0},
                                        {1,1,1}}, 3, 3)
                    );
            /*
            +---+
            | D |
            +---+---+---+
            | D | D | D |
            +---+---+---+
            | D |
            +---+
            */
            p_D.getPieceConfigurations().add(
                    new PieceConfig(4,p_D,
                            new int[][]{{1,0,0},
                                        {1,1,1},
                                        {1,0,0}}, 3, 3)
                    );
        PIECES.add(p_D);
        //=====================================================================
        Piece p_H = new Piece(10,"H");
            /*
            +---+   +---+
            | H |   | H |
            +---+---+---+
            | H | H | H |
            +---+---+---+
            */
            p_H.getPieceConfigurations().add(
                    new PieceConfig(1,p_H,
                            new int[][]{{1,0,1},
                                        {1,1,1}}, 2, 3)
                    );
            /*
            +---+---+
            | H | H |
            +---+---+
            | H |
            +---+---+
            | H | H |
            +---+---+
            */
            p_H.getPieceConfigurations().add(
                    new PieceConfig(2,p_H,
                            new int[][]{{1,1},
                                        {1,0},
                                        {1,1}}, 3, 2)
                    );
            /*
            +---+---+---+
            | H | H | H |
            +---+---+---+
            | H |   | H |
            +---+   +---+
            */
            p_H.getPieceConfigurations().add(
                    new PieceConfig(3,p_H,
                            new int[][]{{1,1,1},
                                        {1,0,1}}, 2, 3)
                    );
            /*
            +---+---+
            | H | H |
            +---+---+
                | H |
            +---+---+
            | H | H |
            +---+---+
            */
            p_H.getPieceConfigurations().add(
                    new PieceConfig(4,p_H,
                            new int[][]{{1,1},
                                        {0,1},
                                        {1,1}}, 3, 2)
                    );
        PIECES.add(p_H);
        //=====================================================================
        Piece p_A = new Piece(11,"A");
            /*
            +---+
            | A |
            +---+
            | A |
            +---+
            | A |
            +---+
            | A |
            +---+
            | A |
            +---+
            */
            p_A.getPieceConfigurations().add(
                    new PieceConfig(1,p_A,
                            new int[][]{{1},
                                        {1},
                                        {1},
                                        {1},
                                        {1}}, 5, 1)
                    );
            /*
            +---+---+---+---+---+
            | A | A | A | A | A |
            +---+---+---+---+---+
            */
            p_A.getPieceConfigurations().add(
                    new PieceConfig(2,p_A,
                            new int[][]{{1,1,1,1,1}}, 1, 5)
                    );
        PIECES.add(p_A);
        //=====================================================================
        Piece p_G = new Piece(12,"G");
            /*
                +---+
                | G |
            +---+---+---+
            | G | G | G |
            +---+---+---+
                | G |
                +---+
            */
            p_G.getPieceConfigurations().add(
                    new PieceConfig(1,p_G,
                            new int[][]{{0,1,0},
                                        {1,1,1},
                                        {0,1,0}}, 3, 3)
                    );
        PIECES.add(p_G);
        //=====================================================================
    }
}
