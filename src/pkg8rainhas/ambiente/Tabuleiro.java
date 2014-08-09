/*
 * The MIT License
 *
 * Copyright 2014 Victor de Lima Soares.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pkg8rainhas.ambiente;

import ic.ce.base.Ambiente;

/**
 *
 * @author Victor de Lima Soares
 */
public class Tabuleiro extends Ambiente<Integer,DisposicaoRainhas> {

    public Tabuleiro() {
        super(Modo.MINIMIZACAO);
    }
   
    @Override
    public Integer avalia(DisposicaoRainhas individuo) {

        int contador = 0;
        for (int n = 0; n < individuo.getSize(); n++) {

            int posicaoN = (Integer) individuo.getCaracteristica(n).getValor();

            for (int i = n + 1; i < individuo.getSize(); i++) {

                int posicaoI = (Integer) individuo.getCaracteristica(i).getValor();

                if (posicaoI == posicaoN) {
                    contador++;   // Mesma Coluna
                }

                if ((posicaoI - posicaoN) == (n - i)) {
                    contador++;   // Mesma diagonal principal
                }

                if ((posicaoN - posicaoI) == (n - i)) {
                    contador++;   // Mesma diagonal
                }
            }
        }
        return contador;
    }

    public static void printRainhas(DisposicaoRainhas individuo) {
        int N = individuo.getSize();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if ((Integer) individuo.getCaracteristica(i).getValor() == j) {
                    System.out.print("R ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
