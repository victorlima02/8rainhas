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
package pkg8rainhas;

import ic.ce.base.Ambiente;
import ic.ce.populacional.algoritmo.AlgoritmoPopulacional;
import ic.ce.base.algoritmo.operadores.Gerador;
import ic.ce.base.algoritmo.operadores.Mutador;
import ic.ce.populacional.algoritmo.operadores.Recombinador;
import ic.ce.populacional.algoritmo.operadores.Seletor;
import java.util.List;
import pkg8rainhas.ambiente.DisposicaoRainhas;
import pkg8rainhas.ambiente.PopulacaoDistribuicoes;
import pkg8rainhas.ambiente.Tabuleiro;
import pkg8rainhas.operadores.Geracao;
import pkg8rainhas.operadores.Mutacao;
import pkg8rainhas.operadores.Recombinacao;
import pkg8rainhas.operadores.Selecao;

/**
 *
 * @author Victor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int maxIndividuos = 50;
        double probabilidaDeCruzamento = 0.2;
        double probabilidadeDeMutacao = 0.6;
        
        Ambiente<Integer,DisposicaoRainhas> ambiente = new Tabuleiro();
        PopulacaoDistribuicoes populacao = new PopulacaoDistribuicoes(ambiente, maxIndividuos);

        Gerador gerador = new Geracao();
        Mutador mutador = new Mutacao(probabilidadeDeMutacao);
        Recombinador recombinador = new Recombinacao(probabilidaDeCruzamento);
        Seletor seletor = new Selecao();
        
        populacao.setIndividuos(gerador.getNAleatorios(maxIndividuos));
        
        AlgoritmoPopulacional algoritmo = new Algoritmo();
            
        algoritmo.setAmbiente(ambiente);
        algoritmo.setPopulacao(populacao);
        
        algoritmo.setGerador(gerador);
        algoritmo.setMutador(mutador);
        algoritmo.setRecombinador(recombinador);
        algoritmo.setSeletor(seletor);
        
        algoritmo.run();
        
        System.out.println(algoritmo.relatorio());
        Tabuleiro.printRainhas(populacao.getMelhor());
    }

}
