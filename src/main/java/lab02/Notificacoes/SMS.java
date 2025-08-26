package lab02.Notificacoes;

public class SMS implements Notificavel {
    private String telefone;

    /**
     * Construtor da classe SMS.
     * @param telefone O número de telefone para o qual a notificação será enviada.
     */
    public SMS(String telefone) {
        this.telefone = telefone;
    }

    /**
     * [Sobrescrita] Método que envia uma notificação SMS.
     * @return a mensagem de notificação para o telefone por SMS.
     */
    @Override
    public void notificacao(String mensagem) {
        System.out.println("Enviando SMS para " + telefone + " | " + mensagem);
    }

}
