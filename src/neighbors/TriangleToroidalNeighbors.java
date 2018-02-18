package neighbors;

import rectCells.Cell;
import rectCells.CellMover;

/**
 * 
 * @author Hemanth Yakkali
 * Sets toroidal neighbors for triangle cells
 */
public class TriangleToroidalNeighbors {
	
	private CellMover cm = new CellMover();
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets cardinal toroidal neighbors for all inverted triangle cells
	 */
	public void setCardinalInvertedToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==columns-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[gridSize-1][0]);
				}
				
				if(i==0 && j%2!=0 && j!=columns-1) { //top side odd triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[gridSize-1][j-1]);
				}
				
				if(i!=0 && j==columns-1) { //right side odd triangle and bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j-1],grid[i][0]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-1 && j%2!=0) { //bottom side odd triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j-1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2!=0) { //all other odd triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i-1][j-1]);
				}
				
			}
		}
	}
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets cardinal toroidal neighbors for all normal-oriented triangle cells
	 */
	public void setCardinalNormalToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==0) { //left side even triangle and top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j+1],grid[i][columns-1]);
				}
				
				if(i==0 && j%2==0 && j!=0) { //top side even triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i+1][j+1]);
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][columns-1],grid[0][j+1]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //bottom side even triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[0][j+1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //all other even triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j+1]);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets toroidal neighbors for all normal-oriented triangle cells
	 */
	public void setAllNormalToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i+1][j+2],grid[i+1][j+3]);
					grid[i][j].setNeighbors(grid[gridSize-1][0],grid[i][columns-1],grid[i][columns-2],grid[i+1][columns-1]);
					grid[i][j].setNeighbors(grid[gridSize-1][columns-1],grid[gridSize-1][columns-2]);
				}
				
				if(i==0 && j%2==0 && j==columns-2) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j-2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][0],grid[i+1][0],grid[i+1][1]);
					grid[i][j].setNeighbors(grid[gridSize-1][j],grid[gridSize-1][j-1],grid[gridSize-1][j-2]);
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j+2],grid[i-1][j]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j+1],grid[0][j+2],grid[0][j+3]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[i][columns-2],grid[i-1][columns-1],grid[i-1][columns-2],grid[0][columns-1]);
					grid[i][j].setNeighbors(grid[0][0],grid[0][1],grid[0][2],grid[0][3]);
				}
				
				if(i==gridSize-1 && j%2==0 && j==columns-2) { //bottom right corner 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i][j-2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2]);
					grid[i][j].setNeighbors(grid[i][0],grid[0][0],grid[0][1],grid[0][j],grid[0][j-1],grid[0][j+1]);
				} //
				
				if(i==0 && j%2==0 && j!=0 && j!=columns-2) { //top side triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+2],grid[i+1][j+3]);
					grid[i][j].setNeighbors(grid[gridSize-1][j],grid[gridSize-1][j-1],grid[gridSize-1][j-2]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-2 && j%2==0) { //bottom side triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j-1],grid[0][j+1],grid[0][j+2],grid[0][j+3]);
				}
				
				if(j==0 && i!=0 && i!=gridSize-1) { //left side 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j+2],grid[i-1][j],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2],grid[i+1][j+3]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[i][columns-2],grid[i-1][columns-1],grid[i-1][columns-2],grid[i+1][columns-1]);
				}
				
				if(j==columns-2 && i!=0 && i!=gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j-1],grid[i][j+1],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][0],grid[i+1][0],grid[i+1][1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //all other triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j+1]);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets toroidal neighbors for all inverted triangle cells
	 */
	public void setAllInvertedToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==columns-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j-2],grid[i+1][j]);
					grid[i][j].setNeighbors(grid[i][0],grid[i][1],grid[i+1][0],grid[i+1][1]);
					grid[i][j].setNeighbors(grid[gridSize-1][0],grid[gridSize-1][j],grid[gridSize-1][j-1],grid[gridSize-1][j-2],grid[gridSize-1][j-3]);
				}
				
				if(i==0 && j==1) { //top left corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[gridSize-1][0],grid[gridSize-1][1],grid[gridSize-1][2],grid[gridSize-1][columns-1],grid[gridSize-1][columns-2]);
				}
				
				if(i==gridSize-1 && j==1) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2],grid[i-1][j-1],grid[i-1][j],grid[i-1][j+1]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j+1],grid[0][j+2],grid[i][columns-1],grid[i-1][columns-1],grid[i-1][columns-2]);
				}
				
				if(i==gridSize-1 && j==columns-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j-2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2],grid[i-1][j-3]);
					grid[i][j].setNeighbors(grid[i][0],grid[i][1],grid[i-1][0],grid[0][0],grid[0][1],grid[0][j]);
				}
				
				if(i==0 && j%2!=0 && j!=columns-1 && j!=1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[gridSize-1][j],grid[gridSize-1][j+1],grid[gridSize-1][j-1],grid[gridSize-1][j-2],grid[gridSize-1][j-3]);
				}
				
				if(i!=0 && i!=gridSize-1 && j==columns-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i-1][j],grid[i-1][j-2],grid[i-1][j-3],grid[i+1][j]);
					grid[i][j].setNeighbors(grid[i][0],grid[i][1],grid[i-1][0],grid[i+1][0],grid[i+1][1]);
				}
				
				if(i==gridSize-1 && j!=1 && j!=columns-1 && j%2!=0) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i-1][j],grid[i-1][j+1],grid[i-1][j-2],grid[i-1][j-3]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j+1],grid[0][j+2]);
				}
				
				if(i!=0 && i!=gridSize-1 && j==1) { //left side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2]);
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i-1][j],grid[i-1][j+1]);
					grid[i][j].setNeighbors(grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[i-1][columns-1],grid[i-1][columns-2]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=1 && j!=columns-1 && j%2!=0) { //all other odd triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i-1][j],grid[i-1][j+1],grid[i-1][j-2],grid[i-1][j-3]);
				}
			}
		}
	}
}
