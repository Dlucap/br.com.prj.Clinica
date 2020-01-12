package ModeloBeans;

public enum BeansEnumStatus {

    Aberto(0), EmAtendimento(1), Finalizado(2), Cancelado(3);

    private int status;

    private BeansEnumStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
