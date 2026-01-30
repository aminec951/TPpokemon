// Classe représentant un Pokémon de type Feu
public class PokemonFeu extends Pokemon {

    // Constructeur de Pokémon Feu
    public PokemonFeu(String nom, int hp, int atk) {
        super(nom, hp, atk);
    }

    // Calcule le multiplicateur de dégâts en fonction du type de l'adversaire
    @Override
    protected double multiplicateurContre(Pokemon cible) {
        // Le Feu est très efficace contre la Plante (2x de dégâts)
        if (cible instanceof PokemonPlante) return 2.0;
        // Le Feu est peu efficace contre l'Eau et le Feu (0.5x de dégâts)
        if (cible instanceof PokemonEau || cible instanceof PokemonFeu) return 0.5;
        // Effet normal par défaut
        return 1.0;
    }

    // Affiche les détails du Pokémon Feu avec son type
    @Override
    public void afficherDetails() {
        System.out.println("Nom: " + nom + ", HP: " + hp +
                ", ATK: " + atk + ", Type: Feu");
    }
}
