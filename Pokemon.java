// Classe abstraite représentant un Pokémon avec ses attributs et méthodes
public abstract class Pokemon {
    // Attributs protégés accessibles par les classes enfants
    protected String nom;  // Nom du Pokémon
    protected int hp;      // Points de vie (Health Points)
    protected int atk;     // Force d'attaque

    // Constructeur initialisant les attributs du Pokémon
    public Pokemon(String nom, int hp, int atk) {
        this.nom = nom;
        this.hp = hp;
        this.atk = atk;
    }

    // Getters pour accéder aux attributs
    public String getNom() { return nom; }
    public int getHp() { return hp; }
    public int getAtk() { return atk; }

    // Vérifie si le Pokémon est éliminé (HP <= 0)
    public boolean isDead() {
        return hp <= 0;
    }

    // Méthode abstraite à implémenter par les classes enfants pour calculer l'avantage de type
    protected abstract double multiplicateurContre(Pokemon cible);

    // Attaque un autre Pokémon et applique les dégâts en fonction du type
    public void attaquer(Pokemon p) {
        // Si un des deux Pokémon est éliminé, l'attaque ne peut pas avoir lieu
        if (this.isDead() || p.isDead()) return;

        // Calcule le multiplicateur de dégâts en fonction de l'avantage de type
        double mult = multiplicateurContre(p);
        // Calcule les dégâts finaux = force d'attaque × multiplicateur
        int degats = (int) Math.round(atk * mult);

        // Réduit les HP de l'adversaire
        p.hp -= degats;
        // Empêche les HP de devenir négatifs
        if (p.hp < 0) p.hp = 0;

        // Affiche les détails de l'attaque
        System.out.println(nom + " attaque " + p.nom +
                " → " + degats + " dégâts (x" + mult + ")");
    }

    // Affiche les détails du Pokémon (nom, HP et force d'attaque)
    public void afficherDetails() {
        System.out.println("Nom: " + nom + ", HP: " + hp + ", ATK: " + atk);
    }
}

