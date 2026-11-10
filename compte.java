public abstract class Compte {
    private static int nombreCrees = 0;

    private final String numero;
    private final String titulaire;
    private long solde;

    public Compte(String numero, String titulaire) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = 0;
        nombreCrees++;
    }

    public String getNumero() { return numero; }
    public String getTitulaire() { return titulaire; }
    public long getSolde() { return solde; }

    public boolean deposer(long montant) {
        if (montant <= 0) return false;
        solde += montant;
        return true;
    }

    // liaison dynamique : frais() et plafond() sont ceux de la classe reelle
    public boolean retirer(long montant) {
        if (montant <= 0 || montant > plafond() || montant + frais(montant) > solde) return false;
        solde -= montant + frais(montant);
        return true;
    }

    public abstract long frais(long montant);
    public abstract long plafond();
    public abstract String type();

    @Override
    public String toString() {
        return "[" + type() + "] " + numero + " " + titulaire + " " + solde + " FCFA";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte)) return false;
        return numero.equals(((Compte) o).numero);
    }

    @Override
    public int hashCode() { return numero.hashCode(); }

    public static int getNombreCrees() { return nombreCrees; }
}
