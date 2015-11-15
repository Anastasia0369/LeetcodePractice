/**
 * Created by donhan on 11/15/15.
 */

//This question is a typical DFS problem.
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; //Use visited array to keep track of visited position to avoid duplicate visit
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n ; j++){
                if(hasValidSubStr(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasValidSubStr(char[][] board, String word, int i, int j, int wordIndex, boolean[][] visited){
        //DFS termination condition
        if(wordIndex == word.length()){
            return true;
        }
        // Need to check board limit first, otherwise other checking will be failed!!
        if( i >= board.length || i< 0 || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(wordIndex) ){
            return false;
        }
        visited[i][j] = true;
        boolean result = hasValidSubStr(board, word, i, j+1, wordIndex + 1, visited) ||
                hasValidSubStr(board, word, i+1, j, wordIndex + 1, visited) ||
                hasValidSubStr(board, word, i-1, j, wordIndex + 1, visited) ||
                hasValidSubStr(board, word, i, j-1, wordIndex + 1, visited);
        visited[i][j] = false;
        return result;
    }
}
