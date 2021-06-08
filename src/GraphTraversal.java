import java.util.*;
public class GraphTraversal {

    private Deque<Integer>[] adjacenyList = new LinkedList[9];

    public static void main(String[] args){

        int userSearchChoice = 0;
        int userStartNode = 0;
        boolean validChoice = false;
        boolean runAgain = true;
        String reRunProgram = "";
        GraphTraversal g = new GraphTraversal();
        Scanner input = new Scanner(System.in);

        // create adjacency list representation of the graph
        g.createGraph();

        // while loop to allow for the user to run the program multiple times before exiting
        while(runAgain){

            // prompt user for either BFS or DFS, validate input
            validChoice = false;
            while(!validChoice){
                System.out.println("Please enter the number associated with the search algorithm you would like to use:");
                System.out.println("1 BFS\n2 DFS");
                userSearchChoice = input.nextInt();

                //flush \n character
                input.nextLine();

                // validate user input, display error message if wrong integer was entered
                if(userSearchChoice != 1 && userSearchChoice != 2){
                    System.out.println("Invalid choice. Please enter either 1 or 2.");
                }
                else{
                    validChoice = true;
                }
            }


            // prompt user for start node, validate input
            validChoice = false;

            while(!validChoice){
                System.out.println("Please enter the node (1-8) you wish to start at: ");
                userStartNode = input.nextInt();

                //flush \n character
                input.nextLine();

                // check if start node is valid, if not display error message
                if(userStartNode < 1 || userStartNode > 8 ){
                    System.out.println("Invalid choice, please enter a number >= 1 or <= 8");
                }
                else{
                    validChoice = true;
                }
            }

            // run either BFS or DFS with the user-defined start node passed in as the argument
            if(userSearchChoice == 1 ){
                System.out.println("Starting BFS with start node: " + userStartNode);
                g.BFS(userStartNode);
            }
            else if(userSearchChoice == 2){
                System.out.println("Starting DFS with start node: " + userStartNode);
                g.DFS(userStartNode);
            }

            // prompt user to run program again or quit
            validChoice = false;

            while(!validChoice){
                System.out.println("Would you like to run the program again? (y/n)");
                reRunProgram = input.nextLine();

                // validate input
                if(!reRunProgram.equals("y") && !reRunProgram.equals("n")){
                    System.out.println("Invalid input. Please enter either y or n");
                }
                else{
                    validChoice = true;
                }
            }

            // quit the program
            if(reRunProgram.equals("n")){
                runAgain = false;
            }

        }

    }

    // function to perform breadth-first search on a graph represented by an adjacency list
    // takes in the desired start node as an argument
    void BFS(int startNode){

        // initialize Q to be a FIFO queue with one element (start node)
        Queue<Integer> Q = new LinkedList();
        Q.add(startNode);

        // create array to hold discovered nodes
        boolean[] discovered = new boolean[9];

        while(Q.size() != 0){
            // take a node from Q (FIFO)
            int vertex = Q.remove();

            if(discovered[vertex] == false){

                // node has now been discovered, add to discovered array and print vertex to console
                discovered[vertex] = true;
                System.out.println("Discovered vertex: " + vertex);

                // for each neighbor to the vertex, check if discovered yet
                // if not, add the node to Q
                for(int edge : adjacenyList[vertex]){
                    if(discovered[edge] == false){
                        Q.add(edge);
                    }
                }

            }
        }

    }

    // function to perform depth-first search on a graph represented by an adjacency list
    // takes in the desired start node as an argument
    void DFS(int startNode){

        // initialize Q to be a LIFO queue with one element (start node)
        Deque<Integer> Q = new LinkedList();
        Q.add(startNode);

        // create array to hold explored nodes
        boolean[] explored = new boolean[9];

        while(Q.size() != 0){

            // take a node from end of Q (LIFO)
            int vertex = Q.removeLast();

            if(explored[vertex] == false){

                // node has now been discovered, add to explored array and print vertex to console
                explored[vertex] = true;
                System.out.println("Discovered vertex: " + vertex);

                // for each neighbor to the vertex, check if explored yet
                // if not, add the node to Q
                for(int edge : adjacenyList[vertex]){
                    if(explored[edge] == false){
                        Q.add(edge);
                    }
                }

            }
        }

    }

    // function to create the adjacency list representation of the graph
    void createGraph(){

        // for vertex 1
        adjacenyList[1] = new LinkedList();
        adjacenyList[1].add(2);
        adjacenyList[1].add(3);

        // vertex 2
        adjacenyList[2] = new LinkedList();
        adjacenyList[2].add(1);
        adjacenyList[2].add(3);
        adjacenyList[2].add(4);
        adjacenyList[2].add(5);

        // vertex 3
        adjacenyList[3] = new LinkedList();
        adjacenyList[3].add(1);
        adjacenyList[3].add(2);
        adjacenyList[3].add(5);
        adjacenyList[3].add(7);
        adjacenyList[3].add(8);

        // vertex 4
        adjacenyList[4] = new LinkedList();
        adjacenyList[4].add(2);
        adjacenyList[4].add(5);

        // vertex 5
        adjacenyList[5] = new LinkedList();
        adjacenyList[5].add(2);
        adjacenyList[5].add(3);
        adjacenyList[5].add(4);
        adjacenyList[5].add(6);

        // vertex 6
        adjacenyList[6] = new LinkedList();
        adjacenyList[6].add(5);

        // vertex 7
        adjacenyList[7] = new LinkedList();
        adjacenyList[7].add(3);
        adjacenyList[7].add(8);

        // vertex 8
        adjacenyList[8] = new LinkedList();
        adjacenyList[8].add(3);
        adjacenyList[8].add(7);
    }

}
