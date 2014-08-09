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
package pkg8rainhas.operadores;

import ic.ce.seres.permutacoes.GeradorPermutacoes;
import static ic.ce.seres.permutacoes.GeradorPermutacoes.getPermutacao;
import ic.ce.seres.permutacoes.SerPermutacao;
import java.util.List;
import pkg8rainhas.ambiente.DisposicaoRainhas;

/**
 *
 * @author Victor de Lima Soares
 */
public class Geracao extends GeradorPermutacoes<DisposicaoRainhas> {

    @Override
    public DisposicaoRainhas get() {
        DisposicaoRainhas nova = new DisposicaoRainhas();
        return nova;
    }

    @Override
    public DisposicaoRainhas getAleatorio() {
        DisposicaoRainhas nova = new DisposicaoRainhas();
        List<Integer> permutacao = getPermutacao(nova.getLimiteInferior(), nova.getLimiteSuperior());

        nova.setCaracteristicas(SerPermutacao.integerListToLocusList(permutacao));
        return nova;
    }

}
