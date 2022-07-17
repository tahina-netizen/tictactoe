package tahina.netizen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board someBoard; // an initially empty board

    @Before
    public void init() {
        someBoard = new Board();
    }

    @Test
    public void when_board_is_instantiated_board_iterator_iterates_over_correct_number_of_empty_cells() {
        Iterator<String> symbolIterator = someBoard.iterator();

        int numberOfCells = 0;
        while(symbolIterator.hasNext()) {
            String symbol = symbolIterator.next();
            assertNull(symbol);
            numberOfCells++;   
        }
        int expectedNumberOfCells = 9;
        assertEquals(expectedNumberOfCells, numberOfCells);
    }

    @Test
    public void when_board_contains_some_symbol_the_iterator_iterate_correctly_through() {
        Iterator<String> symbolIterator = someBoard.iterator();
        for (int x = 0; x < Board.WIDTH; x++) {
            for (int y = 0; y < Board.HEIGHT; y++) {
                String expectedSymbol = someBoard.get(x, y);
                String actualSymbol = symbolIterator.next();
                assertEquals(expectedSymbol, actualSymbol);
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_setting_a_symbol_out_of_bound_exception_is_throwed() throws Exception {
        Board someBoard = new Board();
        someBoard.set(Board.WIDTH + 1000, Board.HEIGHT + 1000, "X");
    }

    @Test
    public void when_a_cell_is_available_setting_a_symbol_on_it_works_correctly() throws Exception {
        Board someBoard = new Board();
        int x = 1, y = 2;
        assertTrue(someBoard.isCellAvailable(x, y));

        someBoard.set(x, y, "O");

        assertEquals("O", someBoard.get(x, y));
    }

    @Test (expected = IllegalPlayException.class)
    public void when_a_cell_is_not_available_setting_a_symbol_on_it_throws_exception() throws Exception {
        int x = 0;
        int y = 2;
        someBoard.set(x, y, "O");
        assertFalse(someBoard.isCellAvailable(x, y));

        someBoard.set(x, y, "O");
    }

    @Test
    public void when_the_board_is_full_isFullMethod_return_true() throws Exception {
        Board someBoard = new Board();
        makeFull(someBoard);

        assertTrue(someBoard.isFull());
    }

    private static void makeFull(Board someBoard) throws Exception {
        for (int x = 0; x < Board.WIDTH; x++) {
            for (int y = 0; y < Board.HEIGHT; y++) {      
                someBoard.set(x, y, "X");
            }
        }
    }

    @Test
    public void when_the_board_is_not_full_isFullMethod_return_false() throws Exception{
        Board someBoard = new Board();
        someBoard.set(0, 0, "X");

        assertFalse(someBoard.isFull());
    }

    @Test 
    public void when_a_cell_contains_one_cell_isCellAvailableMethod_return_false() throws Exception {
        Board someBoard = new Board();
        int x = 2;
        int y = 1;
        someBoard.set(x, y, "O");

        assertFalse(someBoard.isCellAvailable(x, y));
    }

    @Test 
    public void when_a_cell_is_empty_isCellAvailableMethod_return_true() throws Exception {
        Board someBoard = new Board();
        int x = 2;
        int y = 0;

        assertTrue(someBoard.isCellAvailable(x, y));
    }

    @Test (expected = IllegalArgumentException.class)
    public void when_the_coordinates_are_out_of_bound_getMethod_throws() {
        // out of bound coordinates
        int x = Board.WIDTH + 1000;
        int y = Board.HEIGHT + 1000;

        someBoard.get(x, y);
    }

    @Test
    public void when_the_coordinates_are_valid_and_the_cell_is_empty_getMethod_return_null() {
        int x = 0;
        int y = 1;
        assertTrue(someBoard.isCellAvailable(x, y));

        assertNull(someBoard.get(x, y));
    }

    @Test
    public void when_the_coordinates_are_valid_and_the_cell_contains_a_symbol_getMethod_return_correct_symbol() throws Exception {
        int x = 0;
        int y = 1;
        someBoard.set(x, y, "O");
        assertFalse(someBoard.isCellAvailable(x, y));

        String actual = someBoard.get(x, y);
        assertNotNull(actual);
    }
 
}
