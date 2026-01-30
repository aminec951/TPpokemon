// Classe représentant un Pokémon de type Plante
public class PokemonPlante extends Pokemon {

    // Constructeur de Pokémon Plante
    public PokemonPlante(String nom, int hp, int atk) {
        super(nom, hp, atk);
    }

    // Calcule le multiplicateur de dégâts en fonction du type de l'adversaire
    @Override
    protected double multiplicateurContre(Pokemon cible) {
        // La Plante est très efficace contre l'Eau (2x de dégâts)
        if (cible instanceof PokemonEau) return 2.0;
        // La Plante est peu efficace contre la Plante et le Feu (0.5x de dégâts)
        if (cible instanceof PokemonPlante || cible instanceof PokemonFeu) return 0.5;
        // Effet normal par défaut
        return 1.0;
    }

    // Affiche les détails du Pokémon Plante avec son type
    @Override
    public void afficherDetails() {
        System.out.println("Nom: " + nom + ", HP: " + hp +
                ", ATK: " + atk + ", Type: Plante");
    }
}

