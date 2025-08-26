package lab02.Notificacoes;

/**
 * Interface Notificavel
 * 
 * Esta interface define um método para enviar notificações.
 * Qualquer classe que implemente esta interface deve fornecer uma implementação
 * para o método notificacao, que aceita uma mensagem como parâmetro.
 */
public interface Notificavel {
    void notificacao(String mensagem);
}
