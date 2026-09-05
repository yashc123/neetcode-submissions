class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> finalList = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            boolean found = false;
            for(int j = 0; j < words.length && !found; j++){
                if(i != j){
                    if(words[i].length() < words[j].length()){
                        for(int k = 0; k <= words[j].length() - words[i].length(); k++){
                            if(words[j].substring(k, k + words[i].length()).equals(words[i])){
                                finalList.add(words[i]);
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
        }


        return finalList;
    }
}