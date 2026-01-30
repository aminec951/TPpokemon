// Classe représentant un Pokémon de type Eau
public class PokemonEau extends Pokemon {

    // Constructeur de Pokémon Eau
    public PokemonEau(String nom, int hp, int atk) {
        super(nom, hp, atk);
    }

    // Calcule le multiplicateur de dégâts en fonction du type de l'adversaire
    @Override
    protected double multiplicateurContre(Pokemon cible) {
        // L'Eau est très efficace contre le Feu (2x de dégâts)
        if (cible instanceof PokemonFeu) return 2.0;
        // L'Eau est peu efficace contre l'Eau et la Plante (0.5x de dégâts)
        if (cible instanceof PokemonEau || cible instanceof PokemonPlante) return 0.5;
        // Effet normal par défaut
        return 1.0;
    }

    // Affiche les détails du Pokémon Eau avec son type
    @Override
    public void afficherDetails() {
        System.out.println("Nom: " + nom + ", HP: " + hp +
                ", ATK: " + atk + ", Type: Eau");
    }
}
