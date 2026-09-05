class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;

        visited.add(x + ", " + y);

        for(char c : path.toCharArray()){
            if(c == 'N'){
                y++;
            }
            else if(c == 'S'){
                y--;
            }
            else if(c == 'E'){
                x++;
            }
            else{
                x--;
            }
        

        String pos = x + ", " + y;

        if(visited.contains(pos)){
            return true;
        }
        else{
            visited.add(pos);
        }
        }

        return false;
    }
}