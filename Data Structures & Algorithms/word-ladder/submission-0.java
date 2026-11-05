class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        

        if(!wordList.contains(endWord)){
            return 0;
        }

        List<String> words=new ArrayList<>(wordList);
        words.add(beginWord);

        Map<String,List<String>> adj=new HashMap<>();


        for(String word: words){
            for(int i=0;i<word.length();i++){
                String pattern=word.substring(0,i) + "*"+word.substring(i+1);


                adj.computeIfAbsent(pattern, k-> new ArrayList<>()).add(word);
            }
        }



        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);
        int length=1;


        while(!q.isEmpty()){
            int size=q.size();


            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)){
                    return length;
                }

                for(int j=0;j<word.length();j++){
                    String pattern=word.substring(0,j)+"*"+word.substring(j+1);


                    for(String nei:adj.get(pattern)){
                        if(!visited.contains(nei)){
                            visited.add(nei);
                            q.offer(nei);
                        }
                    }
                }


            }

            length++;
        }
        return 0;
    }
}
