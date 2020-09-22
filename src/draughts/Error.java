package draughts;

import utils.Console;

enum Error {

	NOT_EMPTY("The square is not empty"),
	NOT_OWNER("There is not a token of yours"),
	SAME_COORDINATES("The origin and target pieces are the same"),
	WRONG_COORDINATES("The coordinates are wrong"),
	WRONG_COLOR("The piece has a wrong color"),
	NULL_ERROR;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	void writeln() {
		if (this != Error.NULL_ERROR){
			new Console().write(this.message);
		}
	}

	@Override
	public String toString() {
		return this.message;
	}
}
