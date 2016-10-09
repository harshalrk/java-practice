package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        
       
        int[][] nodeIds = new int[nodes-1][2];
        for (int k = 0; k < nodes-1 ; k++){
            scanner.nextLine();
            nodeIds[k][0] = scanner.nextInt();
            nodeIds[k][1] = scanner.nextInt();
        }
        scanner.close();
    
        long subTreeCntr = 1;
        Set<Integer> doneNodes = new HashSet<Integer>();
        Set<Integer> visitedRows = new HashSet<Integer>();
        for (int i = 0; i < nodeIds.length; i++){
            //Generate sub tree 
            int node  = nodeIds[i][0];
            int edgeCnt = 1;
            

            //Validate if fits conditions (has less edges than "edges") only single nodes
            for (int j = 0; j < nodeIds.length; j++){

                if (i == j || doneNodes.contains(node)) continue;
                doneNodes.add(node);
                if (nodeIds[j][0] == node || nodeIds[j][1] == node){
                    edgeCnt++;
                }
                
            }
            if (edgeCnt <= edges)subTreeCntr++;
            
            subTreeCntr++;
            visitedRows.add(i);
            subTreeCntr += createSubTree(i, nodeIds, true, visitedRows);
            
            node  = nodeIds[i][1];
            edgeCnt = 1;
            
            doneNodes.clear();
            //Validate if fits conditions (has less edges than "edges") only single nodes
            for (int j = 0; j < nodeIds.length; j++){

                if (i == j || doneNodes.contains(node)) continue;
                doneNodes.add(node);
                if (nodeIds[j][0] == node || nodeIds[j][1] == node){
                    edgeCnt++;
                }
                
            }
            if (edgeCnt <= edges)subTreeCntr++;
            
       
            visitedRows.clear();
            visitedRows.add(i);
            subTreeCntr += createSubTree(i, nodeIds, false, visitedRows);
            
        }
    
        System.out.println(subTreeCntr);
        
        
    }
    
    private static long createSubTree(int row, int[][] nodes, boolean isLeft, Set<Integer> visitedRows){
        long subsubTreeCntr = 0;
        for (int j = 0; j < nodes.length; j++){
            if (j == row || visitedRows.contains(j)) continue;
            if (nodes[j][0] == nodes[row][(isLeft?0:1)]){ 
                subsubTreeCntr ++;
                visitedRows.add(j);
                subsubTreeCntr += createSubTree(j, nodes, true, visitedRows);
            }else if (nodes[j][1] == nodes[row][(isLeft?0:1)]){
                subsubTreeCntr ++;
                visitedRows.add(j);
                subsubTreeCntr += createSubTree(j, nodes, false, visitedRows);
            }
        }
        return subsubTreeCntr;
    }
}