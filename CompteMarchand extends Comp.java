public class CompteMarchand extends Compte {
    private final String enseigne;

    public CompteMarchand(String numero, String titulaire, String enseigne) {
        super(numero, titulaire);
        this.enseigne = enseigne;
    }
    public String getEnseigne() { return enseigne; }

    @Override public long frais(long montant) { return montant * Parametres.TAUX_FRAIS / 2000; }
    @Override public long plafond() { return 5 * Parametres.PLAFOND_RETRAIT; }
    @Override public String type() { return "MAR"; }
    @Override public String toString() { return super.toString() + " (" + enseigne + ")"; }
}
