import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by donhan on 11/15/15.
 */
public class WordSearch2 {
    Set<String> set = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {

        //Initial Trie
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m ; i ++){
            for(int j = 0; j < n; j++){
                StringBuilder sb = new StringBuilder();
                searchWords(board, i, j,  visited, sb, trie);
            }
        }

        return new ArrayList<String>(set);

    }

    public void searchWords(char[][] board, int i, int j, boolean[][] visited, StringBuilder sb, Trie trie){
        int m = board.length;
        int n = board[0].length;

        if(i >= m || i < 0 || j >= n || j < 0 || visited[i][j]){
            return;
        }

        if(!trie.startsWith(sb.toString()+board[i][j])){
            return;
        }

        if(trie.search(sb.toString()+board[i][j]) ){
            set.add(new String(sb.toString()+board[i][j]));
        }

        visited[i][j] = true;
        sb.append(board[i][j]);
        searchWords(board,i+1,j,visited,sb,trie);
        searchWords(board,i,j+1,visited,sb,trie);
        searchWords(board,i-1,j,visited,sb,trie);
        searchWords(board,i,j-1,visited,sb,trie);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);


    }

    public static void main(String[] args){
        char[][] board =  {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String [] words = {"oath", "pea" ,"eat", "rain"};

        List<String> res = null;
        WordSearch2 wordSearch2 = new WordSearch2();
        res = wordSearch2.findWords(board,words);
        for(String str : res){
            System.out.println(str);
        }




    }
}
