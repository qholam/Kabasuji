package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Bullpen implements Serializable {
	//the current selected piece inside the bullpen, null if nothing is selected
	Piece selectedPiece;
	//Array list to hold all the piece on the bullpen
	public ArrayList<Piece> pieces;
	//Hashmap to keep track of the quantity of each piece left
	HashMap<Piece, Integer> piecesInfo;
	
	/**
	 * Constructor to create an empty Bullpen.
	 */
	public Bullpen(){ 
		//initially no piece is selected
		this.selectedPiece = null;
		//no pieces are on the board
		pieces = new ArrayList<Piece>();
		piecesInfo = new HashMap<Piece, Integer>();
	}

	/**
	 * Constructor to create a Bullpen filled with the given pieces.
	 * @param p the pieces to add to the Bullpen.
	 */
	public Bullpen(ArrayList<Piece> p){
		//initially no piece is selected
		this.selectedPiece = null;
		//no pieces are on the board
		pieces = new ArrayList<Piece>();
		piecesInfo = new HashMap<Piece, Integer>();
		
		//add given pieces to bullpen
		for(Piece piece: p){
			addPiece(piece);
		}
	}
	
	/**
	 * method to get the quantity of a given piece.
	 * @param piece Given piece.
	 */
	public int getQuantity(Piece p){
		return piecesInfo.get(p);
	}
	
	/**
	 * Method to easily add only one of a Piece to the Bullpen.
	 * @param Piece Given Piece to add.
	 */
	public void addPiece(Piece p){
		addPiece(p, 1);
	}
	
	/**
	 * Add a piece to the Bullpen with the given quantity.
	 * @param Piece Given Piece to add.
	 * @param int The quantity of that piece to add.
	 */
	public void addPiece(Piece p, int n){
		//add piece to arraylist
		pieces.add(p);
		//add piece to hashmap
		piecesInfo.put(p, n);
	}

	/**
	 * Get the piece that is currently selected in the bullpen.
	 * @return the selectedPiece.
	 */
	public Piece getSelectedPiece() {
		return selectedPiece;
	}
	
	/**
	 * Set the selected piece.
	 * @param selectedPiece the selectedPiece to set.
	 */
	public void setSelectedPiece(Piece selectedPiece) {
		//Ensures that the piece is in the bullpen
		if(pieces.contains(selectedPiece))
			this.selectedPiece = selectedPiece;
	}
	
	/**
	 * Gets the array of pieces from the bullpen.
	 * @return the pieces.
	 */
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	/**
	 * @return the piecesInfo.
	 */
	public HashMap<Piece, Integer> getPiecesInfo() {
		return piecesInfo;
	}

	/**
	 * Checks the number of pieces left.
	 * @return The number of pieces left in the bullpen.
	 */
	public int getNumPieces(){
		return pieces.size();
	}
}
