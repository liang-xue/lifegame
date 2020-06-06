package LifeGame;


import java.util.Random;

public class Map {
    final static public int x=16;//设置地图初始大小
    final static public int y=16;
    public static Cell [][]initial() {
        Cell [][]cell=new Cell[x][y];
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                cell[i][j]=new Cell();
                Random random=new Random();
                cell[i][j].setStatus(random.nextInt(2)); //随机初始化设置细胞状态             
            }
        }
        return cell;
    }   
	public static void getLiving(Cell [][]cell){
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                int living=0;
                if(i>0&&j>0) living+=cell[i-1][j-1].getStatus();
                if(j>0) living+=cell[i][j-1].getStatus();
                if(i<x-1&&j>0) living+=cell[i+1][j-1].getStatus();
                if(i>0) living+=cell[i-1][j].getStatus();
                if(i<x-1) living+=cell[i+1][j].getStatus();
                if(i>0&&j<x-1) living+=cell[i-1][j+1].getStatus();
                if(j<x-1) living+=cell[i][j+1].getStatus();
                if(i<x-1&&j<x-1) living+=cell[i+1][j+1].getStatus();        
                cell[i][j].setLiving(living);//计算细胞周围八个格子的活细胞数目，特殊位置边界只计算地图内活细胞数目，地图外默认为死细胞
            }
        }
    }
    public static int update(Cell [][]cell){
        int count=0;
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                int status=cell[i][j].getStatus();
                cell[i][j].UpdateStatus();
                if(status==cell[i][j].getStatus()) count++;//计算细胞达到演化平衡时的轮数
            }
        }
        return count;
    }
    public static void printMap(Cell [][]cell) {
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                System.out.print(cell[i][j].getStatus()+" ");//打印细胞地图
            }
            System.out.println();
        }
    }
}
