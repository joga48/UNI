

public class ListaDuplamenteEncadeada {
    NoDuplo primeiro;
    NoDuplo ultimo;
    int numeroDeNos;

    ListaDuplamenteEncadeada() {
        primeiro = ultimo = null;
        numeroDeNos = 0;
    }

    public void inserirFinal(NoDuplo novoNo) {
        novoNo.prox = null;
        novoNo.ant = null;
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            ultimo.prox = novoNo;
            novoNo.ant = ultimo;
        }
        ultimo = novoNo;
        numeroDeNos++;
    }

    public void inserirInicio(NoDuplo novoNo) {
        novoNo.ant = null;
        if (primeiro == null) {
            ultimo = novoNo;
        } else {
            novoNo.prox = primeiro;
            primeiro.ant = novoNo;
        }
        primeiro = novoNo;
        numeroDeNos++;
    }

    public NoDuplo obterElementoPorPosicao(int posicao) {
        NoDuplo noTemporario = primeiro;
        int i = 0;

        while (noTemporario != null && i < posicao) {
            noTemporario = noTemporario.prox;
            i++;
        }
        return noTemporario;
    }

    // TODO(Criar uma função para inserir elementos em uma posição específica)

    public String excluirNoUsandoPosicao(int posicao) {
        String mensagem = "";
        NoDuplo noTemporario = obterElementoPorPosicao(posicao);

        if (noTemporario == null) {
            mensagem = "A posição informada está vazia ou não existe";
        } else if (posicao == 0) {
            if (noTemporario.prox == null) {
                primeiro = ultimo = null;
            } else {
                primeiro = noTemporario.prox;
                primeiro.ant = null;
            }
            mensagem = "Posição " + posicao + "excluída. \nValor: " + noTemporario.valor;
        } else if (posicao == numeroDeNos - 1) {
            ultimo = noTemporario.ant;
            ultimo.prox = null;
            mensagem = "Posição " + posicao + "excluída. \nValor: " + noTemporario.valor;
        } else {
            noTemporario.ant.prox = noTemporario.prox;
            noTemporario.prox.ant = noTemporario.ant;
            mensagem = "Posição " + posicao + "excluída. \nValor: " + noTemporario.valor;
        }
        numeroDeNos--;
        return mensagem;
    }

    public String exibirLista() {
        int i = 0;
        NoDuplo noTemporario = primeiro;
        String mensagem = "";
        while (noTemporario != null) {
            mensagem = mensagem + "Posicao: " + i + " valor: " +
                    noTemporario.valor + "\n";
            noTemporario = noTemporario.prox;
            i++;
        }

        return mensagem;
    }

    //TODO(Criar um método que retorno os dados da lista em ordem inversa)
}



