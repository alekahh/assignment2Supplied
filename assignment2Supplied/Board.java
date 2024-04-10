package assignment2Supplied;
import assignment2Supplied.OutOfBoardException;
import assignment2Supplied.Block;
import assignment2Supplied.BlockColor;
import assignment2Supplied.Cell;
public class Board {
static int BOARD_HEIGHT = 20;
static int BOARD_WIDTH = 10;
private BlockColor[][] cells = new BlockColor[BOARD_HEIGHT][BOARD_WIDTH];
private Block activeBlock;
private int numFullLinesRemoved = 0;

public Board() {
    for (int i = 0; i < BOARD_HEIGHT; i++) {
        for (int j = 0; j < BOARD_WIDTH; j++) {
        this.cells[i][j] = BlockColor.NO_COLOR;
        }
    }
}

public BlockColor[][] getCells() {
    return this.cells;
}

public Block activeBlock() {
    return this.activeBlock;
}

public void setactiveBlock(Block b) {
    this.activeBlock = b;
}

public void setCells(BlockColor[][] cells) {
    this.cells = cells;
}

public BlockColor blockAt(int x, int y) {
    return this.cells[x][y];
}

public void clear() {
    for (int i = 0; i < BOARD_HEIGHT; i++) {
        for (int j = 0; j < BOARD_WIDTH; j++) {
            this.cells[i][j] = BlockColor.NO_COLOR;
        }
    }
    this.activeBlock = null;
}

public void blockLanded() {
    Cell[] landedCells = this.activeBlock.getCells();
    int x, y;
    for (int i = 0; i < 4; i++) {
        x = landedCells[i].getRow();
        y = landedCells[i].getCol();
        if (x < 0)
        continue;
        this.cells[x][y] = landedCells[i].getColor();
    }
    this.activeBlock = null;
}

public boolean canMove() {
    for (int i = 3; i <= 6; i++) {
        if (cells[0][i] != BlockColor.NO_COLOR)
        return false;
    }
    return true;
}

public boolean rotate() throws OutOfBoardException {
    Cell[] currentCells = activeBlock.getCells();
    if (currentCells[1].getRow() < 1)
    throw new OutOfBoardException();
    activeBlock.rotate();
    Cell[] rotatedCells = activeBlock.getCells();
    int x, y;
    for (int i = 0; i < 4; i++) {
    x = rotatedCells[i].getRow();
    y = rotatedCells[i].getCol();
    if (x < 0 || y < 0 || x >= BOARD_HEIGHT || y >= BOARD_WIDTH) {
        for (int j = 0; j < 3; j++)
        activeBlock.rotate();
        throw new OutOfBoardException();
    }
    //if occupied by previous landed blocks
    if (cells[x][y] != BlockColor.NO_COLOR) {
        for (int j = 0; j < 3; j++)
        activeBlock.rotate();
        return false;
    }
    }
    return true;
}

public boolean oneLineDown() throws OutOfBoardException {
    Cell[] currentCells = this.activeBlock.getCells();
    int x, y;
    for (int i = 0; i < 4; i++) {
        x = currentCells[i].getRow() + 1;
        y = currentCells[i].getCol();
        if (x >= BOARD_HEIGHT || cells[x][y] != BlockColor.NO_COLOR) {
        return false;
        }
    }
    this.activeBlock.moveDown();
    return true;
}

public boolean moveLeft() throws OutOfBoardException {
    Cell[] currentCells = this.activeBlock.getCells();
    int x, y;
    for (int i = 0; i < 4; i++) {
        x = currentCells[i].getRow();
        y = currentCells[i].getCol() - 1;
        if (y < 0 || x < 0) {
            throw new OutOfBoardException();
        }
        if (cells[x][y] != BlockColor.NO_COLOR)
        return false;
    }
    this.activeBlock.moveLeft();
    return true;
}

public boolean moveRight() throws OutOfBoardException {
    Cell[] currentCells = this.activeBlock.getCells();
    int x, y;
    for (int i = 0; i < 4; i++) {
        x = currentCells[i].getRow();
        y = currentCells[i].getCol() + 1;
        if (y >= BOARD_WIDTH || x < 0) {
            throw new OutOfBoardException();
        }
        if (cells[x][y] != BlockColor.NO_COLOR)
        return false;
    }
    this.activeBlock.moveRight();
    return true;
}

public boolean newBlock() {
    if (canMove()) {
        activeBlock = Block.randomBlock();
        return true;
    } else
    return false;
}

public int removeFullLines() {
    int count = 0;
    boolean find = true;
    for (int i = 0; i < BOARD_HEIGHT; i++) {
    find = true;
    for (int j = 0; j < BOARD_WIDTH; j++) {
    if (cells[i][j] == BlockColor.NO_COLOR) {
    find = false;
    break;
    }
}
if (find == true) {
        for (int k = i; k > 0; k--)
            for (int x = 0; x < BOARD_WIDTH; x++)
            cells[k][x] = cells[k - 1][x];
        for (int k = 0; k < BOARD_WIDTH; k++)
            cells[0][k] = BlockColor.NO_COLOR;
        i--;
        count++;
        }
    }
    numFullLinesRemoved += count;
    return count;
    }
    public int numFullLinesRemoved() {
    return numFullLinesRemoved;
    }
}
