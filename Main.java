// Classe principale pour tester le système de combat Pokémon
public class Main {
    public static void main(String[] args) {
        // Crée deux Pokémon : un de type Feu et un de type Eau
        Pokemon salameche = new PokemonFeu("Salameche", 100, 20);
        Pokemon carapuce  = new PokemonEau("Carapuce", 100, 20);

        // Affiche les détails des Pokémon avant le combat
        System.out.println("=== AVANT ===");
        salameche.afficherDetails();
        carapuce.afficherDetails();

        // Les deux Pokémon s'attaquent mutuellement une fois
        System.out.println("\n=== ATTAQUES ===");
        salameche.attaquer(carapuce);
        carapuce.attaquer(salameche);

        // Affiche les détails des Pokémon après une attaque
        System.out.println("\n=== APRÈS ===");
        salameche.afficherDetails();
        carapuce.afficherDetails();

        // Combat complet jusqu'à ce qu'un Pokémon soit éliminé (HP <= 0)
        System.out.println("\n=== COMBAT JUSQU'AU KO ===");
        while (!salameche.isDead() && !carapuce.isDead()) {
            salameche.attaquer(carapuce);
            // Le second Pokémon contre-attaque s'il n'est pas encore vaincu
            if (!carapuce.isDead())
                carapuce.attaquer(salameche);
        }

        // Affiche le nom du vainqueur
        System.out.println("Vainqueur : " +
                (salameche.isDead() ? carapuce.getNom() : salameche.getNom()));
    }
}
