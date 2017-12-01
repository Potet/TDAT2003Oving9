class RelationProperties {

    public static boolean isReflexive(char[][] relation, char [] set){
        boolean[] results = new boolean[set.length];
        for (int i = 0; i < set.length; i++) {
            char x = set[i];
            for (int j = 0; j < relation.length; j++) {
                if (relation[j][0]==x && relation[j][1]==x){
                    results[i]=true;
                    break;
                }
            }
        }
        for (int i = 0; i < results.length; i++) {
            if (!results[i]) return false;
        }
        return true;
    }

    public static boolean isSymmetric(char[][] relation, char [] set){
        boolean[] results = new boolean[set.length];
        for (int i = 0; i < set.length; i++) {
            char x = set[i];
            for (int j = 0; j < relation.length; j++) {
                if (relation[j][0]==x){
                    char y = relation[j][1];
                    for (int k = 0; k < relation.length; k++) {
                        if (relation[k][0]==y&&relation[k][1]==x){
                            results[i]=true;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < results.length; i++) {
            if (!results[i]) return false;
        }
        return true;
    }

    public static boolean isTransitive(char[][] relation, char [] set){
        boolean[] results = new boolean[set.length];
        for (int i = 0; i < set.length; i++) {
            char a = set[i];
            boolean useda = false;
            for (int j = 0; j < relation.length; j++) {
                if (relation[j][0]==a) {
                    useda=true;
                    char b = relation[j][1];
                    if (b==a){
                        results[i]=true;
                        break;
                    }
                    boolean usedb = false;
                    for (int k = 0; k < relation.length; k++) {
                        if (relation[k][0]==b){
                            usedb = true;
                            char c = relation[k][1];
                            for (int l = 0; l < relation.length; l++) {
                                if (relation[l][0]==a){
                                    if (relation[l][1]==c){
                                        results[i]=true;
                                    }
                                }
                            }
                        }
                    }
                    if (!usedb){
                        results[i]=true;
                    }
                }
            }
            if (!useda){
                results[i]=true;
            }
        }
        for (int i = 0; i < results.length; i++) {
            if (!results[i]) return false;
        }
        return true;
    }

    public static boolean isAntiSymmetric(char[][] relation, char [] set){
        for (int i = 0; i < set.length; i++) {
            char a = set[i];
            for (int j = 0; j < relation.length; j++) {
                if (relation[j][0]==a){
                    char b = relation[j][1];
                    if (a!=b) {
                        for (int k = 0; k < relation.length; k++) {
                            if (relation[k][0] == b && relation[k][1] == a) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isEquivalenceRelation(char[][] relation, char [] set){
        return (isSymmetric(relation,set)&&isReflexive(relation,set)&&isTransitive(relation,set));
    }

    public static boolean isPartialOrder(char[][] relation, char [] set){
        return (isTransitive(relation,set)&&isAntiSymmetric(relation,set)&&isReflexive(relation,set));
    }

    public static void main(String[] args) {
        char[] setA = {'a','x','r','m','2','0'};
        char[][] rel1 = {{'a','a'},{'r','a'},{'a','2'},{'x','x'},{'r','2'},{'r','r'},{'m','m'},{'2','r'},{'0','0'},{'a','r'},{'2','2'},{'2','a'}};
        char[][] rel2 = {{'a','x'},{'r','2'},{'0','0'},{'m','2'}};
        System.out.println("Rel1 is reflexive: " + isReflexive(rel1, setA));
        System.out.println("Rel2 is reflexive: " + isReflexive(rel2, setA));
        System.out.println("Rel1 is symmetric: " + isSymmetric(rel1, setA));
        System.out.println("Rel2 is symmetric: " + isSymmetric(rel2, setA));
        System.out.println("Rel1 is transitive: " + isTransitive(rel1, setA));
        System.out.println("Rel2 is transitive: " + isTransitive(rel2, setA));
        System.out.println("Rel1 is antisymmetric: " + isAntiSymmetric(rel1, setA));
        System.out.println("Rel2 is antisymmetric: " + isAntiSymmetric(rel2, setA));
        System.out.println("Rel1 is an equivalence relation: " + isEquivalenceRelation(rel1, setA));
        System.out.println("Rel2 is an equivalence relation: " + isEquivalenceRelation(rel2, setA));
        System.out.println("Rel1 is a partial order: " + isPartialOrder(rel1, setA));
        System.out.println("Rel2 is a partial order: " + isPartialOrder(rel2, setA));
		/* skal gi følgende utskrift:
		   Rel1 is reflexive: true
		   Rel2 is reflexive: false
		   Rel1 is symmetric: true
		   Rel2 is symmetric: false
		   Rel1 is transitive: true
		   Rel2 is transitive: true
		   Rel1 is antisymmetric: false
		   Rel2 is antisymmetric: true
		   Rel1 is an equivalence relation: true
		   Rel2 is an equivalence relation: false
		   Rel1 is a partial order: false
		   Rel2 is a partial order: false
		 */
    }


}