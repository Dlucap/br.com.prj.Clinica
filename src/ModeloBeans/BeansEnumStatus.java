package ModeloBeans;

public enum BeansEnumStatus {

    Aberto(0), AbertoReaagendado(1),ConsultaLiberada(2),EmAtendimento(3), 
    Finalizado(4), Cancelado(5);

    private int status;

    private BeansEnumStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
