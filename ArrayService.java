import java.util.ArrayList;
import java.util.List;

public class ArrayService {

    /**  
     * Function permettant de créer des sous-listes à partir d'une liste
     * @param liste liste d'integer à formater
     * @param taille taille des sous-listes à créer
     * 
     * @return Une liste contenant des sous-listes de longueur {@link taille}
     * 
     * @author Platel Jason
     * 
     */
    public static List<List<Integer>> partition (List<Integer> liste, Integer taille){
        List<List<Integer>> result = new ArrayList<>();

        /* On test tout d'abord si la liste n'est pas vide ou si la taille indiquée n'est pas inférieur ou égale à 0 
        ou supérieure ou égale à la liste passée en argument pour éviter d'utiliser plus de ressource que nécessaire */
        if(liste.size() <= taille || liste.size() == 0 || taille <= 0){
            result.add(liste);
            return result;
        } 

        for(int i = 0; i < liste.size(); i++){
            
            if(i + (taille -1) < liste.size()){ // On s'assure que l'on peut encore créé une sous-liste à partir des éléments restants de la liste
                result.add(liste.subList(i,i+taille));
                i = i + taille - 1;

            } else { // Si on ne peut plus créer une sous-liste complète, on renvoie le reste de la liste et nous sortons de la boucle
                result.add(liste.subList(i,liste.size()));
                break; 
            }
        }

        return  result;
    }
}