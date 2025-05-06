package restaurant;

public class Restaurant {
    private Table[] tables;

    public Restaurant() {
        tables = new Table[75]; // Création d'un tableau pour contenir 75 tables
        int index = 0;

        // Ajouter 30 tables pour 2 personnes avec banquette (numérotées de 1 à 30)
        for (int i = 0; i < 30; i++, index++) {
            tables[index] = new Table(2, index + 1, true);
        }

        // Ajouter 5 tables pour 2 personnes sans banquette (numérotées de 31 à 35)
        for (int i = 0; i < 5; i++, index++) {
            tables[index] = new Table(2, index + 1, false);
        }

        // Ajouter 30 tables pour 4 personnes avec banquette (numérotées de 36 à 65)
        for (int i = 0; i < 30; i++, index++) {
            tables[index] = new Table(4, index + 1, true);
        }

        // Ajouter 10 tables pour 4 personnes sans banquette (numérotées de 66 à 75)
        for (int i = 0; i < 10; i++, index++) {
            tables[index] = new Table(4, index + 1, false);
        }
    }

    // Retourne le nombre de tables actuellement occupées
    public int nbTablesOccupees() {
        int compteur = 0;
        for (int i = 0; i < tables.length; i++) {
            if (tables[i].isOccupe()) {
                compteur++; // Incrémenter si la table est occupée
            }
        }
        return compteur;
    }

    // Assigne une table disponible selon le nombre de personnes et la préférence de banquette
    // Retourne le numéro de la table assignée ou -1 si aucune ne correspond
    public int assignerTableDispo(int nbPersonnes, boolean banquette) {
        for (int i = 0; i < tables.length; i++) {
            Table t = tables[i];
            if (!t.isOccupe() && t.getNbPlaces() == nbPersonnes && t.isBanquette() == banquette) {
                t.setOccupe(true); // Marque la table comme occupée
                return t.getNumero(); // Retourne le numéro de cette table
            }
        }
        return -1; // Aucune table disponible correspondant aux critères
    }

    // Vérifie si une table (par son numéro) est occupée ou non
    public boolean verifierSiTableOccupe(int numero) {
        if (numero >= 1 && numero <= tables.length) {
            return tables[numero - 1].isOccupe(); // Retourne l'état d'occupation
        }
        return false; // Numéro invalide
    }
}
