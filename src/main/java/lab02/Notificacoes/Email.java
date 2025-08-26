package lab02.Notificacoes;

public class Email implements Notificavel {
    private String email;

    /**
     * Construtor da classe Email
     * @param email o email do cliente
     */
    public Email(String email) {
        this.email = email;
    }

    /**
     * [Sobrescrita] Método que envia uma notificação por e-mail
     * @return A mensagem de notificação para o e-mail
     */
    @Override
    public void notificacao(String mensagem) {
        System.out.println("Enviando e-mail para " + email + " | " + mensagem);
    }


}
