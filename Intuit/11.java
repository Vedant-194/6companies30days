 public Node construct(int[][] grid) {
        int n = grid.length;
        return getNode(grid, 0, n -1, 0, n - 1);
    }
    
    public Node getNode(int[][] grid, int top, int bottom, int left, int right){
        if(top > bottom || left > right) return null;
        if(left == right || top == bottom) return new Node(grid[top][left] == 1, true);
        
        // not leaf 
        int midH = (top + bottom) / 2;
        int midV = (left + right) / 2;
        
        Node topLeft = getNode(grid, top, midH, left, midV);
        Node topRight = getNode(grid, top, midH, midV + 1, right);
        Node bottomLeft = getNode(grid, midH + 1, bottom, left, midV);
        Node bottomRight = getNode(grid, midH + 1, bottom, midV + 1, right);
        
        
        boolean isLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        
        boolean val1 = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val;
        if(val1 && isLeaf){
           return new Node(true, true);
        }
        
        boolean val2 = !topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val;
        if(val2 && isLeaf){
            return new Node(false, true);
        }
        
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
