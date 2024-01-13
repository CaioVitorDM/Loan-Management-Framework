package edu.ufrn.imd.Biblicron.factory;

import edu.ufrn.imd.Biblicron.factory.interfaces.IStrategyFactory;
import edu.ufrn.imd.Biblicron.model.DispositivoEletronico;
import edu.ufrn.imd.Biblicron.model.Livro;
import edu.ufrn.imd.Biblicron.model.MaterialEsportivo;
import edu.ufrn.imd.Biblicron.model.Produto;
import edu.ufrn.imd.Biblicron.strategies.interfaces.ICalculoFinalStrategy;
import edu.ufrn.imd.Biblicron.strategies.interfaces.IDevolucaoStrategy;
import edu.ufrn.imd.Biblicron.strategies.models.*;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory implements IStrategyFactory {
    @Override
    public IDevolucaoStrategy getDevolucaoStrategy(Produto produto){
        if(produto instanceof Livro){
            System.out.println("Criou um novo DevolucaoLivroStrategy");
            return new DevolucaoLivroStrategy();
        }
        else if(produto instanceof MaterialEsportivo){
            System.out.println("Criou um novo DevolucaoMaterialEsportivoStrategy");
            return new DevolucaoMaterialEsportivoStrategy();
        }
        else if(produto instanceof DispositivoEletronico){
            System.out.println("Criou um novo DevolucaoDispositivoEletronicoStrategy");
            return new DevolucaoDispositivoEletronicoStrategy();
        }
        throw new IllegalArgumentException("Estratégia de devolução não encontrada para o tipo de produto");
    }

    @Override
    public ICalculoFinalStrategy getCalculoFinalStrategy(Produto produto){
        if(produto instanceof Livro){
            System.out.println("Criou um novo CalculoFinalLivroStrategy");
            return new CalculoFinalLivroStrategy();
        }
        else if(produto instanceof MaterialEsportivo){
            System.out.println("Criou um novo CalculoFinalMaterialEsportivoStrategy");
            return new CalculoFinalMaterialEsportivoStrategy();
        }
        else if(produto instanceof DispositivoEletronico){
            System.out.println("Criou um novo CalculoFinalDispositivoEletronicoStrategy");
            return new CalculoFinalDispositivoEletronicoStrategy();
        }
        throw new IllegalArgumentException("Estratégia de cálculo final não encontrada para o tipo de produto");
    }
}
