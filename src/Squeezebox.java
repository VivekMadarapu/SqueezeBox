import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Squeezebox {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("squeezebox.dat"));

        while (file.hasNext()){
            ArrayList<ArrayDeque<Card>> game = new ArrayList<>();
            String c = file.nextLine() + " " + file.nextLine();
            Scanner cards = new Scanner(c);
            while (cards.hasNext()){
                ArrayDeque<Card> cardStack = new ArrayDeque<>();
                String card = cards.next();
                cardStack.add(new Card(card.charAt(0), card.charAt(1)));
                game.add(cardStack);
            }
            boolean canPlay = false;

            while (game.size() != 1){

                int i = 1;
                boolean hasPlayed = false;
                while(!hasPlayed) {
                    boolean threeDownExists = false;
                    if(i >= 3){
                        threeDownExists = game.get(i).getFirst().equals(game.get(i - 3).getFirst());
                    }
//game.get(i).getFirst().charAt(0) == game.get(i - 3).getFirst().charAt(0) || game.get(i).getFirst().charAt(1) == game.get(i - 3).getFirst().charAt(1)
                    if (threeDownExists) {
                        while (game.get(i).size() > 0) {
                            game.get(i - 3).addFirst(game.get(i).removeFirst());
                            hasPlayed = true;
                            System.out.println("ran");
                        }
                    } else if (game.get(i).getFirst().equals(game.get(i - 1).getFirst())) {
                        while (game.get(i).getFirst().equals(game.get(i - 1).getFirst())) {
                            game.get(i - 1).addFirst(game.get(i).removeFirst());
                            hasPlayed = true;
                            System.out.println("ran");
                        }
                    }
                    else{
                        i++;
                    }

                    for (int j = 0; j < game.size(); j++) {
                        if (game.get(j).size() == 0){
                            game.set(j, null);
                        }
                    }

                    while(game.contains(null)){
                        game.remove(null);
                    }

                }

            }
            System.out.print(game.size() + " piles remaining: ");
            for (ArrayDeque<Card> cs : game){
                System.out.print(cs.size() + " ");
            }
            System.out.println();

        }

    }

}
