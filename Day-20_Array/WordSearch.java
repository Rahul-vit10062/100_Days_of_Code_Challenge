import java.util.*;

public class WordSearch
{
    public static String[] SEARCH_LIST = {"ONE", "TWO", "FOUR", "FIVE", "SIX", "NINE", "IN"}; //list of words to be searched

    //sample puzzles
    public static char[][] ex1 = new char[][]{
        {'E', 'N', 'I', 'N'}, 
        {'V', 'E', 'X', 'E'}, 
        {'I', 'N', 'N', 'V'},
        {'F', 'O', 'U', 'R'}
        };    

    //holds parameters to use in findDir() for each direction
    //first two parameters govern the horizontal working room
    //second two parameters govern the vertical working room
    //third two parameters govern the next grid element to be analyzed
    public static final int[][] directions = new int[][]{ 
        {1, 0, 1, 0, -1, -1}, //up left
        {1, 0, 0, 0, -1, 0},  //up
        {1, 0, -1, 1, -1, 1},  //up right
        {0, 0, 1, 0, 0, -1},  //left
        {0, 0, -1, 1, 0, 1},  //right
        {-1, 1, 1, 0, 1, -1}, //down left
        {-1, 1, 0, 0, 1, 0},  //down
        {-1, 1, -1, 1, 1, 1}}; //down right

    private static ArrayList<char[]> SEARCH_LIST2;
    private static char puz[][];
    private static int height = 0;
    private static int width = 0;

    public static void main(String args[]){
        System.out.println(searchWords(ex1));       
    }

    /**
     * Find the number of matches in the puzzle
     * 
     * @param puzzle        multidimensional array of characters representing puzzle
     * @return              number of matches found
     */

    public static int searchWords(char[][] puzzle){
        puz = puzzle;
        height = puzzle.length; //attain height of puzzle
        width = puzzle[0].length; //attain width of puzzle

        SEARCH_LIST2 = fixDictionary(); //convert DICTIONARY to ArrayList of char[]

        int numMatches = 0;

        for (int i1 = 0; i1 < height; ++i1){
            for (int i2 = 0; i2 < width; ++i2){
                for (char[] w : SEARCH_LIST2){
                    numMatches = numMatches + scanSpaceForWord(i1, i2, w);
                }
            }
        }

        return numMatches;
    }

    /**
     * Converts String[] DICTIONARY of words to be searched into an ArrayList of char[]
     * 
     * @return      The converted ArrayList of char[]
     * @see         PuzzleSolver#SEARCH_LIST
     */
    private static ArrayList<char[]> fixDictionary(){
        ArrayList<char[]> result = new ArrayList<char[]>();

        for (int i = 0; i < SEARCH_LIST.length; ++i){
            result.add(SEARCH_LIST[i].toCharArray());
        }

        return result;
    }

    /**
     * Scan space for instances of a single word
     * 
     * @param i1        First index of space
     * @param i2        Second index of space
     * @param word      Word to search for
     * @return          Number of occurrences of word
     */
    private static int scanSpaceForWord(int i1, int i2, char[] word){
        if (word.length > 1){
            //if word length is greater than 1
            int numMatches = 0;

            //Find word for each of 8 directions from the space. 
            //Directions numbered 1 - 4 and 6 - 9. 5 is the space itself.
            for (int x = 0; x < 4; ++x){
                numMatches = numMatches + findDir(i1, i2, word, directions[x]);
            }

            if (!isPalindrome(word)){
                for (int x = 4; x < 8; ++x){
                    numMatches = numMatches + findDir(i1, i2, word, directions[x]);
                }           
            }

            return numMatches;
        }
        else{
            //if word is only a single character
            if (word[0] == puz[i1][i2]){
                return 1;
            }
            else return 0;
        }       
    }

    /** 
     * Determine if word is a palindrome
     *
     * @param word      word to be evaluated
     * @return          true if word is palindrome
     */
    private static boolean isPalindrome(char[] word){
        int len = word.length;
        int half = len/2;

        for (int i = 0; i < half; ++i){ //for each first half of elements
            if (word[i] != word[len - 1 - i]) return false; //if a nonmatch found
        }

        return true; //no nonmatches found
    }

    /**
     * Finds a word moving a specific direction from a space
     * 
     * @param i1        First index of space
     * @param i2        Second index of space
     * @param word      Word to be searched
     * @param dir       Direction (Up Right, Up, Down, Down Right, etc.) to evaluate. 
     * @return          Return 1 if match found, otherwise 0
     * 
     * @see             PuzzleSolver#directions
     */   
    private static int findDir(int i1, int i2, char[] word, int[] dir){
        int h = (dir[0] * (i1 + 1)) + (dir[1] * (height + 1));
        int w = (dir[2] * (i2 + 1)) + (dir[3] * (width + 1));   

        //verify that there exists enough grid room
        if (h > 0 && w > 0){
            if (word.length > h || word.length > w){ //if word is longer than grid room         
                return 0; 
            }           
        }
        else if (h > 0 && w == 0){
            if (word.length > h){ //if word is longer than grid room        
                return 0; 
            }           
        }
        else if (h == 0 && w > 0){
            if (word.length > w){ //if word is longer than grid room        
                return 0; 
            }           
        }
        else if (h == 0 && w == 0){ //if there is no grid room      
            return 0;           
        }
        else {
            System.out.println(("findDir() - invalid h and w values"));
            System.exit(1);
        }

        //search for mismatches
        for (int i = 0; i < word.length; ++i){ //if mismatch is found
            if (word[i] != puz[i1 + (i * dir[4])][i2 + (i * dir[5])]) return 0;
        }

        return 1; //if no mismatch found

    }
}
